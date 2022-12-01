package vn.iotstar.controller.web;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;

/**
 * Servlet implementation class WebCartAdd
 */
@WebServlet("/cart-add")
public class WebCartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebCartAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	/*
	 * protected void addcart(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String pid
	 * =request.getParameter("pid"); CartDaoImpl DaoCart=new CartDaoImpl();
	 * CartItemDaoImpl DaoCartItem=new CartItemDaoImpl(); //List<Cart> cartuser=
	 * DaoCart.CheckCartstatus(5, 0);// Cart cart=new Cart();
	 * 
	 * CartItem cartitem=new CartItem();
	 * 
	 * 
	 * // Date date = new Date(); Timestamp timestamp2 = new
	 * Timestamp(date.getTime()); if(cartuser == null) {
	 * cart.setBuyDate(timestamp2); cart.setStatus(0); cart.setUser(null);
	 * DaoCart.insert(cart); List<CartItem>
	 * listcart=DaoCartItem.findCartItemByCartID(1);
	 * request.setAttribute("listcart", cartuser); }
	 * 
	 * request.getRequestDispatcher("/views/web/cart.jsp").forward(request,
	 * response); }
	 */

}
