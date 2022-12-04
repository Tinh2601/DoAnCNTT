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
 * Servlet implementation class CartControl
 */
@WebServlet("/cartupdate")

public class UpdateCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		update(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		DaoDBConection DAO=new DaoDBConection();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int cartitemid=Integer.parseInt(request.getParameter("cartitemid"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		float unitprice=Float.parseFloat(request.getParameter("unitprice"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		int cartid=Integer.parseInt(request.getParameter("cartid"));
		int newquantity=Integer.parseInt(request.getParameter(String.valueOf(cartitemid)));
		float newunitprice= (unitprice/quantity)*newquantity;
		DAO.Update_CartItem(newquantity, newunitprice, pid, cartid, cartitemid);
		response.sendRedirect("/ITProject/cart");
		
	}

}
