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

import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.dao.impl.UserDAOimpl;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;

@WebServlet(urlPatterns = { "/web-home" })
public class WebController extends HttpServlet {
	
	ProductDaoImpl Productdao = new ProductDaoImpl();
	UserDAOimpl UserDao = new UserDAOimpl();
	public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		List<Product> list = Productdao.findAll();
		request.setAttribute("listP", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
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
			response.sendRedirect(request.getContextPath() + "/home");
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
					response.sendRedirect(request.getContextPath() + "/home");
					session.setAttribute("USERMODEL", user); 
				} else if (user.getUserRole().getRoleName().equals("admin")) {
					response.sendRedirect(request.getContextPath() + "/admin-home"); 
				}
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login?action=login");
		}			

	}
}
