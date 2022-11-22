

import java.io.IOException;
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
@WebServlet(urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// hien thi danh sach category
        String cateID = req.getParameter("cateId");
        CategoryDAOimpl cdao = new CategoryDAOimpl();
        List<CategoryModel> listCate = cdao.findAll();
        req.setAttribute("tagCate", cateID);
        req.setAttribute("listCC", listCate);
        req.setAttribute("tagCate", cateID);
        
        // hien thi sp top1
        ProductDaoImpl dao = new ProductDaoImpl();
        productModel top1 = dao.findTopOne();
        req.setAttribute("top1", top1);
			
        
        // hien thi sp theo id -> search
        List<productModel> list = dao.getAllProductByCID(cateID);
        req.setAttribute("listP", list);
        
        
        req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}
	
}

