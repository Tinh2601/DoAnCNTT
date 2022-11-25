

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.ProductDaoImpl;

import vn.iotstar.model.productModel;

/**
 * Servlet implementation class HomControl
 */
@WebServlet("/homemain")
public class HomControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html;charset=UTF-8");
		String cateID = req.getParameter("categoryId");

        ProductDaoImpl dao = new ProductDaoImpl();
       // AccountModel acc=new AccountModel();
        productModel top1 = dao.findTopOne();
        
        List<productModel> top4last = dao.findLastProduct();
        List<productModel> top4best = dao.findBestAmount();
        req.setAttribute("top1", top1);
        req.setAttribute("top4last", top4last);
        req.setAttribute("top4best", top4best);
        
        //String namuser=acc.getUsername();
        //req.setAttribute("txtusername",namuser);
        
        //String namuser=acc.getUsername();
        //req.setAttribute("txtusername",namuser);

        req.getRequestDispatcher("/views/web/homemain.jsp").forward(req, resp);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
