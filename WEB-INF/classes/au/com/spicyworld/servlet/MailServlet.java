package au.com.spicyworld.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.CartMain;
import au.com.spicyworld.dao.SendMail;
import au.com.spicyworld.model.Customer;


public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SendMail sendmail = new SendMail();
		HttpSession session = request.getSession();
		boolean flag = false;

		synchronized (this) {
			String cart_id = "0000C";
			String user_id = (String) session.getAttribute("user_id");
			if (user_id == null) {
				session.setAttribute("ERROR", "No UserID Found");
				rd = request.getRequestDispatcher("error.jsp");
			} else {
				cart_id = "C" + user_id;
			}

			CartMain cartmain = (CartMain) session.getAttribute(cart_id);
			Customer customer = (Customer) session.getAttribute("customer" + cart_id);

			flag = sendmail.sendMail(customer, cartmain);

			if (flag) {
				session.removeAttribute(cart_id);
				session.removeAttribute("user_id");
				session.removeAttribute("customer" + cart_id);
				session.removeAttribute("ERROR");
				request.setAttribute("flag", "true");
				session.invalidate();
				rd = request.getRequestDispatcher("invoice.jsp");

			} else {
				session.setAttribute("ERROR", "Error Occured while Buying");
				rd = request.getRequestDispatcher("error.jsp");
			}
			rd.forward(request, response);
		}

	}

}
