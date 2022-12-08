package vn.iotstar.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.BillDaoImpl;

/**
 * Servlet implementation class testAnalytics
 */
@WebServlet(urlPatterns = { "/admin-analytics/sday","/admin-analytics/smonth","/admin-analytics/syear" })
public class Statics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BillDaoImpl billdao = new BillDaoImpl();

	// true là order , false : total money
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("sday")) {
			Day(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/analytics/sday.jsp");
			rd.forward(request, response);
		}else if (url.contains("smonth")) {
			Month(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/analytics/smonth.jsp");
			rd.forward(request, response);
		}else if (url.contains("syear")) {
			Year(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/analytics/syear.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("sday")) {
			StaticsDay(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/analytics/sday.jsp");
			rd.forward(request, response);
		}else if (url.contains("smonth")) {
			StaticsMonth(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/analytics/smonth.jsp");
			rd.forward(request, response);
		}else if (url.contains("syear")) {
			StaticsYear(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/analytics/syear.jsp");
			rd.forward(request, response);
		}
	}

	protected void StaticsDay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = "";
		String column_properities = "";
		int total = 0;
		String name = "";

		String value = request.getParameter("status"); // true là order , false : total money
		String date = request.getParameter("date");
		if (value.equals("false")) {
			title = "Total money in " + date;
			column_properities = "Money";
			total = billdao.tien(date);
			name = "Total money";
		} else {
			title = "Total order in " + date;
			column_properities = "number";
			total = billdao.donhang(date);
			name = "Total order";
		}

		request.setAttribute("name", name);
		request.setAttribute("total", total);
		request.setAttribute("column_properities", column_properities);
		request.setAttribute("title", title);
	}
	
	protected void StaticsMonth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = "";
		String column_properities = "";
		int total = 0;
		String name = "";

		String value = request.getParameter("status"); // true là order , false : total money
		String date = request.getParameter("date");
		String day = date.substring(0, 8);
		if (value.equals("false")) {
			title = "Total money in " + day;
			column_properities = "Money";
			total = billdao.tien(day);
			name = "Total money";
		} else {
			title = "Total order in " + day;
			column_properities = "number";
			total = billdao.donhang(day);
			name = "Total order";
		}

		request.setAttribute("name", name);
		request.setAttribute("total", total);
		request.setAttribute("column_properities", column_properities);
		request.setAttribute("title", title);
	}
	
	protected void StaticsYear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = "";
		String column_properities = "";
		int total = 0;
		String name = "";

		String value = request.getParameter("status"); // true là order , false : total money
		String date = request.getParameter("date");
		String day = date.substring(0, 4);
		if (value.equals("false")) {
			title = "Total money in " + day;
			column_properities = "Money";
			total = billdao.tien(day);
			name = "Total money";
		} else {
			title = "Total order in " + day;
			column_properities = "number";
			total = billdao.donhang(day);
			name = "Total order";
		}

		request.setAttribute("name", name);
		request.setAttribute("total", total);
		request.setAttribute("column_properities", column_properities);
		request.setAttribute("title", title);
	}
	
	protected void Day(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = "";
		String column_properities = "";
		int total = 0;
		String name = "";
		LocalDate date = LocalDate.now();
		String day = date.toString();

		String url = request.getRequestURL().toString();
		if (url.contains("day")) {
			title = "Total money in " + day;
			column_properities = "Money";
			total = billdao.tien(day);
			System.out.println(total);
			name = "Total money";
		}

		request.setAttribute("name", name);
		request.setAttribute("total", total);
		request.setAttribute("column_properities", column_properities);
		request.setAttribute("title", title);
	}
	
	protected void Month(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = "";
		String column_properities = "";
		int total = 0;
		String name = "";
		LocalDate date = LocalDate.now();
		String day1 = date.toString();
		String day = day1.substring(0, 7);
		; // hàm mặc định khi nhấn vào lần đầu

		title = "Total money in " + day;
		column_properities = "Money";
		total = billdao.tien(day);
		name = "Total money";

		request.setAttribute("name", name);
		request.setAttribute("total", total);
		request.setAttribute("column_properities", column_properities);
		request.setAttribute("title", title);
	}

	protected void Year(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hàm này có hoạt động !");
		String title = "";
		String column_properities = "";
		int total = 0;
		String name = "";

		LocalDate date = LocalDate.now();
		String day1 = date.toString();
		String day = day1.substring(0, 4);


		title = "Total money in " + day;
		column_properities = "Money";
		total = billdao.tien(day);
		System.out.println(total);
		name = "Total money";

		request.setAttribute("name", name);
		request.setAttribute("total", total);
		request.setAttribute("column_properities", column_properities);
		request.setAttribute("title", title);
	}
}
