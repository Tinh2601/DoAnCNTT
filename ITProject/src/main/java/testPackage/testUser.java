package testPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.config.DBConnection;
import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.User;

/**
 * Servlet implementation class testUser
 */
@WebServlet("/testUser")
public class testUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartItemDaoImpl dao = new CartItemDaoImpl();
		PrintWriter printWriter = response.getWriter();

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USERMODEL");
		//session.getAttribute("USERMODEL");
		//User lg= (User) session.getAttribute("USERMODEL");;
		DaoDBConection DAO=new DaoDBConection();
		CartDaoImpl cartDao=new CartDaoImpl();
		//CartItemDaoImpl cartItem =new CartItemDaoImpl();
		//Cart cart =cartDao.CheckCartstatus(u.getUserId(),0);	  
		 //String useridd=Integer.toString(u.getUserId());
		 Date date = new Date();
		  Timestamp timestamp2 = new Timestamp(date.getTime());
		printWriter.println(cartDao.CheckCartstatus(u.getUserId(),0));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
