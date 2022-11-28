package vn.iotstar.controller.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vn.iotstar.dao.impl.CategoryDAOimpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.dao.impl.UserDAOimpl;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;
import vn.iotstar.entity.Category;


@WebServlet(urlPatterns = {"/web-home" })
public class WebController extends HttpServlet {
	
	ProductDaoImpl Productdao = new ProductDaoImpl();
	UserDAOimpl UserDao = new UserDAOimpl();
	CategoryDAOimpl CategoryDAO= new CategoryDAOimpl();
	public void load(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//String cateID = req.getParameter("categoryId");

        ProductDaoImpl dao = new ProductDaoImpl();
       // AccountModel acc=new AccountModel();
        Product top1 = dao.findTop1Price();
        
        //List<Product> top4last = dao.findLastProduct();
        //List<Product> top4best = dao.findBestAmount();
        req.setAttribute("top1", top1);
        //req.setAttribute("top4last", top4last);
        //req.setAttribute("top4best", top4best);
        
        //String namuser=acc.getUsername();
        //req.setAttribute("txtusername",namuser);
        
        //String namuser=acc.getUsername();
        //req.setAttribute("txtusername",namuser);

        RequestDispatcher rd = req.getRequestDispatcher("/views/web/homemain.jsp");
		rd.forward(req, resp);
// 		
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action != null && action.equals("login")) {

			RequestDispatcher rd = request.getRequestDispatcher("/decorators/login.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			session.removeAttribute("USERMODEL");
			load(request, response);
			response.sendRedirect(request.getContextPath() + "/category");
		} else {
			load(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block  nhập sai rùi , nhập lại 
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		user = UserDao.login(username, password);
		if (user != null) {
			if (action != null && action.equals("login")) {
				if (user.getUserRole().getRoleName().equals("user")) {
					response.sendRedirect(request.getContextPath() + "/category");
					session.setAttribute("USERMODEL", user); 
				} else if (user.getUserRole().getRoleName().equals("admin")) {
					response.sendRedirect(request.getContextPath() + "/admin-category"); 
				}
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login?action=login");
		}			

	}
}
