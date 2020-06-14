package au.com.spicyworld.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.RandomID;

public class CartAuthenticator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		String user_id = RandomID.set_userId();
		session.setAttribute("user_id", user_id);
		
		rd = request.getRequestDispatcher("home.jsp");
		//rd = request.getRequestDispatcher("CartServlet?action="+action+"&category="+category+"&item_id="+item_id);
		rd.forward(request, response);
		//response.sendRedirect("CartServlet?action="+action+"&category="+category+"&item_id="+item_id);
		
	}

}
