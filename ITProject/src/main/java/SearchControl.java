

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

@WebServlet(urlPatterns = {"/search"})
public class SearchControl extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
	        
			// search tiáº¿ng Viá»‡t
			req.setCharacterEncoding("UTF-8");
	        
	        
	        String txtSearch = req.getParameter("txt");
	        ProductDaoImpl dao = new ProductDaoImpl();
	       
	        //
	        // search
	        List<productModel> list = dao.searchProduct(txtSearch);
	        req.setAttribute("list", list);
	        
	        req.setAttribute("txtname",txtSearch);
	        //hiá»ƒn thá»‹ chá»¯ trÃªn Ã´ input search
	        req.setAttribute("txtS", txtSearch);
	        
	        
	        //hien thi danh sach category
	        String cateID = req.getParameter("cateId");
	        CategoryDAOimpl cdao = new CategoryDAOimpl();
	        List<CategoryModel> listCate = cdao.findAll();
	        req.setAttribute("tagCate", cateID);
	        req.setAttribute("listCC", listCate);
	        
	        // hien thi sp top1
	        productModel top1 = dao.findTopOne();
	        req.setAttribute("top1", top1);
	        
	        req.getRequestDispatcher("/views/web/search.jsp").forward(req, resp);
		}
}
