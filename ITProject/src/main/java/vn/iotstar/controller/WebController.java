package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;

@WebServlet(urlPatterns = { "/homemain", "/category/list", "/category/productfind", "/search", "/product/detail",
		"/contact", "/cart" })
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDaoImpl categorydao = new CategoryDaoImpl();
	ProductDaoImpl productdao = new ProductDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		if (url.contains("list")) {
			loadCategoryAndProduct(request, response);
		} else if (url.contains("productfind")) {
			loadProductByCategory(request, response);
		} else if (url.contains("detail")) {
			detail(request, response);
		}else if (url.contains("contact")) {
			contact(request, response);
		}else if (url.contains("cart")) {
			contact(request, response);
		}
		

		loadHome(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();
		if (url.contains("list")) {
			loadCategoryAndProduct(request, response);
		} else if (url.contains("productfind")) {
			loadProductByCategory(request, response);
		} else if (url.contains("search")) {
			search(request, response);
		} else if (url.contains("detail")) {
			detail(request, response);
		} else if (url.contains("contact")) {
			contact(request, response);
		}else if (url.contains("cart")) {
			contact(request, response);
		}

		loadHome(request, response);
	}

	protected void cart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/web/cart.jsp").forward(request, response);
	}
	
	protected void contact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/web/contact.jsp").forward(request, response);
	}

	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		int pid = Integer.parseInt(request.getParameter("pid"));

		Product p = productdao.findProductByID(pid);
		request.setAttribute("detail", p);

		request.getRequestDispatcher("/views/web/detailProduct.jsp").forward(request, response);
	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		request.setCharacterEncoding("UTF-8");

		String txtSearch = request.getParameter("txt");

		List<Product> list = productdao.findByProductName(txtSearch);
		request.setAttribute("list", list);

		request.setAttribute("txtname", txtSearch);

		request.setAttribute("txtS", txtSearch);

		String cateID = request.getParameter("cateId");
		CategoryDaoImpl cdao = new CategoryDaoImpl();
		List<Category> listCate = cdao.findAll();
		request.setAttribute("tagCate", cateID);
		request.setAttribute("listCC", listCate);

		Product top1 = productdao.findTop1Price();
		request.setAttribute("top1", top1);

		request.getRequestDispatcher("/views/web/search.jsp").forward(request, response);
	}

	protected void loadHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Product top1 = productdao.findTop1Price();

		List<Product> top4last = productdao.findLastProduct();
		List<Product> top4best = productdao.findBestAmount();
		request.setAttribute("top1", top1);
		request.setAttribute("top4last", top4last);
		request.setAttribute("top4best", top4best);

		request.getRequestDispatcher("/views/web/homemain.jsp").forward(request, response);
	}

	protected void loadCategoryAndProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// hien thi danh sach category
//        int cateID = Integer.parseInt(request.getParameter("cateId"));
		CategoryDaoImpl cdao = new CategoryDaoImpl();
		List<Category> listCate = cdao.findAll();
//        request.setAttribute("tagCate", cateID);
		request.setAttribute("listCC", listCate);
//        request.setAttribute("tagCate", cateID);

		// hien thi sp top1
		ProductDaoImpl dao = new ProductDaoImpl();
		Product top1 = dao.findTop1Price();
		request.setAttribute("top1", top1);

		// hien thi sp theo id -> search
		List<Product> list = productdao.findAll();
		request.setAttribute("listP", list);

		request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
	}

	protected void loadProductByCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		 hien thi danh sach category
		int cateID = Integer.parseInt(request.getParameter("categoryId"));
		CategoryDaoImpl cdao = new CategoryDaoImpl();
		List<Category> listCate = cdao.findAll();
		request.setAttribute("tagCate", cateID);
		request.setAttribute("listCC", listCate);
		request.setAttribute("tagCate", cateID);

		// hien thi sp top1
		ProductDaoImpl dao = new ProductDaoImpl();
		Product top1 = dao.findTop1Price();
		request.setAttribute("top1", top1);

		// hien thi sp theo id -> search
		List<Product> list = productdao.getProductByCID(cateID);
		request.setAttribute("listP", list);

		request.getRequestDispatcher("/views/web/home.jsp").forward(request, response);
	}
}
