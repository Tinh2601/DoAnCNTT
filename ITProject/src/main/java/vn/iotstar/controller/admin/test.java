package vn.iotstar.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;


/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "select u from User u join u.userRole where u.username LIKE 'admin' and u.password LIKE '1' ";
		TypedQuery<User> query = enma.createQuery(jpql, User.class); // createQuery # createNamedQuery
		User resultList = query.getSingleResult();		
		
		PrintWriter printWriter = response.getWriter();
//		if(resultList.getUserRole().getRoleName().equals("admin")) {
//			printWriter.println("đúng rùi");
//		}
		printWriter.println(resultList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
