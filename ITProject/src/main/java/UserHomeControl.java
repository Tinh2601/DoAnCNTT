

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.CategoryDAOimpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.productModel;

/**
 * Servlet implementation class adminControl
 */
//@WebServlet("/home")
public class UserHomeControl extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		
        ProductDaoImpl dao = new ProductDaoImpl();
        
     // hien thi danh sach category
        String cateID = request.getParameter("cateId");
        CategoryDAOimpl cdao = new CategoryDAOimpl();
        List<CategoryModel> listCate = cdao.findAll();
        request.setAttribute("tagCate", cateID);
        request.setAttribute("listCC", listCate);
        
        List<productModel> list = dao.findAll();       
       
        request.setAttribute("listP", list);
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(list);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
