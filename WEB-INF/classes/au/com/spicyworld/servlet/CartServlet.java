package au.com.spicyworld.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.CartMain;
import au.com.spicyworld.dao.RandomID;

public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CartMain cartmain;
	private RequestDispatcher rd = null;
	String cart_id = "0000C";
	String category = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		category = req.getParameter("category");
		

		if (action == null)
			action = "browse";

		switch (action)

		{

		case "addToCart":
			try {
				this.addToCart(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.sendRedirect("error.jsp");
			}

			break;

		case "addToCartButon":
			try {
				this.addToCartButon(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.sendRedirect("error.jsp");
			}

			break;

		case "viewCart":
			this.viewCart(req, resp);
			break;

		case "delfromCart":
			try {
				this.delfromCart(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.sendRedirect("error.jsp");
			}
			break;

		case "delItemfromCart":
			try {
				this.delItemfromCart(req, resp);
			} catch (ServletException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				resp.sendRedirect("error.jsp");
			}
			break;

		case "emptyCart":
			try {
				this.emptyCart(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "browse":
			resp.sendRedirect("home.jsp");
			break;

		default:
			resp.sendRedirect("home.jsp");
			break;
		}
	}

	private void addToCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		// Integer item_id = Integer.parseInt(req.getParameter("item_id"));
		String item_id = req.getParameter("item_id");
		// String item_id = (String) req.getAttribute("item_id");

		synchronized (this) {
			HttpSession session = req.getSession(false);
			String user_id = (String) session.getAttribute("user_id");
			// System.out.println(user_id);
			if (user_id == null) {
				session.setAttribute("ERROR", "Here i Am");
				resp.sendRedirect("error.jsp");
			}

			cart_id = "C" + user_id;
			if (session.getAttribute(cart_id) == null) {
				cartmain = new CartMain();
				session.setAttribute(cart_id, cartmain);

			} else {
				cartmain = (CartMain) session.getAttribute(cart_id);
			}

			boolean flag = cartmain.CartAddToListHash(item_id);
			if (flag == true) {
				rd = req.getRequestDispatcher("products.jsp?category=" + category + " &page=1");
				rd.forward(req, resp);
			} else {

				String max = String.valueOf(cartmain.getmax_limit(item_id));
				String error = "Max Quantity Limit :" + max;
				session.setAttribute("ERROR" + cart_id, error);
				rd = req.getRequestDispatcher("products.jsp?category=" + category + " &page=1");
				rd.forward(req, resp);
			}
		}

		//cartmain = null;

	}// end of add to cart

	private void addToCartButon(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String item_id = req.getParameter("item_id");

		synchronized (this) {
			HttpSession session = req.getSession(false);

			String user_id = (String) session.getAttribute("user_id");

			if (user_id == null)
				resp.sendRedirect("error.jsp");
			cart_id = "C" + user_id;
			if (session.getAttribute(cart_id) == null) {
				session.setAttribute("ERROR" + cart_id, "No Cart Found");
				rd = req.getRequestDispatcher("products.jsp?category=" + category + " &page=1");
				rd.forward(req, resp);
			} else {
				cartmain = (CartMain) session.getAttribute(cart_id);
			}

			boolean flag = cartmain.CartAddToListHash(item_id);
			if (flag == true) {
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			} else {

				String max = String.valueOf(cartmain.getmax_limit(item_id));
				String error = "Max Quantity Limit :" + max;
				session.setAttribute("ERROR" + cart_id, error);
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			}

		}

		//cartmain = null;
	}

	private void delfromCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String item_id = req.getParameter("item_id");

		synchronized (this) {
			HttpSession session = req.getSession(false);

			String user_id = (String) session.getAttribute("user_id");
			if (user_id == null)
				resp.sendRedirect("error.jsp");
			cart_id = "C" + user_id;

			if (session.getAttribute(cart_id) == null) {
				session.setAttribute("ERROR" + cart_id, "No Cart Found");
				rd = req.getRequestDispatcher("products.jsp?category=" + category + " &page=1");
				rd.forward(req, resp);

			} else {
				cartmain = (CartMain) session.getAttribute(cart_id);
			}
			boolean flag = cartmain.delfromCart(item_id);
			if (flag == true) {
				//session.setAttribute(cart_id, cartmain);
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			} else {
				session.setAttribute("ERROR" + cart_id, "The item" + item_id + " is not available");
				//session.setAttribute(cart_id, cartmain);
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			}
		}

		//cartmain = null;

	}// end of delete from cart

	private void delItemfromCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String item_id = req.getParameter("item_id");

		synchronized (this) {
			HttpSession session = req.getSession(false);

			String user_id = (String) session.getAttribute("user_id");
			if (user_id == null)
				resp.sendRedirect("error.jsp");
			cart_id = "C" + user_id;

			if (session.getAttribute(cart_id) == null) {
				session.setAttribute("ERROR" + cart_id, "No Cart Found");
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			} else {
				cartmain = (CartMain) session.getAttribute(cart_id);
			}

			boolean flag = cartmain.delItemfromCart(item_id);
			if (flag == true) {
				//session.setAttribute(cart_id, cartmain);
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			} else {
				//session.setAttribute(cart_id, cartmain);
				session.setAttribute("ERROR" + cart_id, "Item not deleted");
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			}

		}

		//cartmain = null;

	}// end of delete item from cart

	private void emptyCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		synchronized (this) {
			HttpSession session = req.getSession();

			String user_id = (String) session.getAttribute("user_id");
			if (user_id == null)
				resp.sendRedirect("error.jsp");
			cart_id = "C" + user_id;
			if (user_id == null) {
				session.setAttribute("Error" + cart_id, "No Cart Found");
				rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			} else {
				cartmain = (CartMain) session.getAttribute(cart_id);
				cartmain.emptyCart();
				session.removeAttribute(cart_id);
				rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}

		}

		//cartmain = null;
	}// empty cart

	private void viewCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		synchronized (this) {
			HttpSession session = req.getSession();

			String user_id = (String) session.getAttribute("user_id");
			if (user_id == null)
				resp.sendRedirect("error.jsp");
			if (session.getAttribute(cart_id) == null) {
				session.setAttribute("Error" + cart_id, "No Cart Found");
				rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);

			} else {
				cartmain = (CartMain) session.getAttribute(cart_id);
				session.setAttribute(cart_id, cartmain);
				rd = req.getRequestDispatcher("cart.jsp");
				rd.forward(req, resp);
			}
		}

		//cartmain = null;
	}// end of view cart

}
