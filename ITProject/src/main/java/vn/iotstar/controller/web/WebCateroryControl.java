package vn.iotstar.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.CategoryDAOimpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.dao.impl.UserDAOimpl;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;


/**
 * Servlet implementation class WebCateroeyControl
 */
@WebServlet(urlPatterns = {"/web-category"})
public class WebCateroryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDaoImpl Productdao = new ProductDaoImpl();
	UserDAOimpl UserDao = new UserDAOimpl();
	CategoryDAOimpl CategoryDAO= new CategoryDAOimpl();
	public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	
		//String cateID= request.getParameter("cid");
		//int cateIDint=Integer.parseInt(cateID);
		List<Category> listCate= CategoryDAO.findAll();
		List<Product> list = Productdao.findAll();
		//List<Product> productbycid= Productdao.getProductByCID(cateIDint);
		request.setAttribute("listCC", listCate);
		request.setAttribute("listP", list);
		//request.setAttribute("listP", productbycid);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
// 		
	}
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String searchtxt = request.getParameter("txtS");

			List<Product> list = Productdao.findByProductName(searchtxt);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
			
		}
// 		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public WebCateroryControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		String url = request.getRequestURL().toString();
			load(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}

}
