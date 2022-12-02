package vn.iotstar.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entity.Seller;
import vn.iotstar.entity.User;
import vn.iotstar.entity.UserRole;

/**
 * Servlet implementation class profile
 */
@WebServlet(urlPatterns = { "/profile","/updateuser" })
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    UserDaoImpl userdao = new UserDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		if (url.contains("updateuser")) {
			update(request, response);
		}
		request.getRequestDispatcher("/views/web/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");


			User user = new User();

			BeanUtils.populate(user, request.getParameterMap());
			
			
			
			userdao.update(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}

	}
	protected void update(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		try {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("USERMODEL");
		
			// username ,email , fullname , phone
			user.setUsername(request.getParameter("username"));
			user.setEmail(request.getParameter("email"));
			user.setFullname(request.getParameter("fullname"));
			user.setPhone(request.getParameter("phone"));
			userdao.update(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "Cập nhật thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Eror: " + e.getMessage());
		}

	}
}
