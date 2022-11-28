package vn.iotstar.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import vn.iotstar.dao.impl.CategoryDAOimpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;
import vn.iotstar.entity.Category;
/**
 * Servlet implementation class WebSearchControl
 */
@WebServlet("/web-search")
public class WebSearchControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebSearchControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        
		// search tiếng Việt
		req.setCharacterEncoding("UTF-8");
        
        
        String txtSearch = req.getParameter("txt");
        ProductDaoImpl dao = new ProductDaoImpl();
       
        //
        // search
        List<Product> list = dao.findByProductName(txtSearch);
        req.setAttribute("list", list);
        
        req.setAttribute("txtname",txtSearch);
        //hiển thị chữ trên ô input search
        req.setAttribute("txtS", txtSearch);
        
        
        //hien thi danh sach category
       // String cateID = req.getParameter("cateId");
        //CategoryDAOimpl cdao = new CategoryDAOimpl();
        //List<Category> listCate = cdao.findAll();
       // req.setAttribute("tagCate", cateID);
       // req.setAttribute("listCC", listCate);
        
        // hien thi sp top1
       
        
        req.getRequestDispatcher("/views/web/search.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
