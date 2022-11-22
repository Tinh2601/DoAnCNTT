
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.impl.CategoryDAOimpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.productModel;
import vn.iotstar.service.IProductServices;
import vn.iotstar.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/home", "/login", "/logout" }) // ,
public class adminControl extends HttpServlet {
	public void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		IProductServices productService = new ProductServiceImpl();
		ProductDaoImpl dao = new ProductDaoImpl();

		String cateID = request.getParameter("cateId");
		CategoryDAOimpl cdao = new CategoryDAOimpl();
		List<CategoryModel> listCate = cdao.findAll();
		request.setAttribute("tagCate", cateID);
		request.setAttribute("listCC", listCate);

		List<productModel> list = productService.findAll();

		request.setAttribute("listP", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action != null && action.equals("login")) {

			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
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
		UserDAOimpl dao = new UserDAOimpl();
		UserModel user = dao.login(username, password);

		// tạo hàm lấy thuộc tính role
		String role = request.getParameter("role");
		if (user != null) {
			if (action != null && action.equals("login")) {
				if (role.equals("User")) {
					response.sendRedirect(request.getContextPath() + "/home");
					session.setAttribute("USERMODEL", user); // chỗ này gửi cái full name lên
				} else if (role.equals("Admin")) {
					response.sendRedirect(request.getContextPath() + "/admin-home"); // viết thêm hàm gọi cái này ra
				}
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login?action=login");
		}

	}
}
