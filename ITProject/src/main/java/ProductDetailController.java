

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/detail")
public class ProductDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String pid=req.getParameter("pid");
		ProductDaoImpl dao = new ProductDaoImpl();
		productModel p=dao.findProductByID(pid);
		req.setAttribute("detail", p);
        
       
        
        req.getRequestDispatcher("/views/web/detailProduct.jsp").forward(req, resp);
        
        
				
	}

}
