package au.com.spicyworld.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.CartMain;
import au.com.spicyworld.model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		synchronized (this) {

			HttpSession session = request.getSession();
			Customer customer = new Customer();
			customer.setOrder_ID();
			customer.setFirstname(request.getParameter("firstname"));
			customer.setLastname(request.getParameter("lastname"));
			customer.setAddress(request.getParameter("address"));
			customer.setMobileno(request.getParameter("mobileno"));
			customer.setEmailid(request.getParameter("emailid"));

			customer.setPickdate(request.getParameter("pickdate"));
			customer.setPicktime(request.getParameter("picktime"));

			String cart_id = "0000C";
			String user_id = (String) session.getAttribute("user_id");
			if (user_id == null) {
				session.setAttribute("ERROR", "No UserID Found");
				rd = request.getRequestDispatcher("error.jsp");
			} else {
				cart_id = "C" + user_id;
			}
			CartMain cartmain = (CartMain) session.getAttribute(cart_id);
			if (cartmain != null) {
				session.setAttribute("customer" + cart_id, customer);
				rd = request.getRequestDispatcher("view.jsp");
			} else {
				session.setAttribute("ERROR", "Cart Not Found");
				rd = request.getRequestDispatcher("error.jsp");
			}

			rd.forward(request, response);
		}

	}

}
