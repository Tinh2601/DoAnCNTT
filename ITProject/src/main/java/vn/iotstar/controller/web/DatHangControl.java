package vn.iotstar.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.User;

/**
 * Servlet implementation class DatHangControl
 */
@WebServlet("/dathang")
public class DatHangControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatHangControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatHang(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void DatHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USERMODEL");
		DaoDBConection DAO=new DaoDBConection();
		
		
		//float total=Float.parseFloat(request.getParameter("total"));
		Date date = new Date();
		  Timestamp timestamp2 = new Timestamp(date.getTime());
		CartDaoImpl cartDAO= new CartDaoImpl();
		Cart cartid=cartDAO.CheckCartstatus(u.getUserId(),0);
		//String address=request.getParameter("address");
		//String note=request.getParameter("ghichu");
		//String name=request.getParameter("fullname");
		DAO.Insert_Bills(120, timestamp2, cartid.getCartId(), u.getUserId(), "tien mat", 0, "address", "note", "name", "email", "phone");
		response.sendRedirect("/ITProject/category/list");
	}

}
