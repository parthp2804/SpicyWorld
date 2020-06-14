package au.com.spicyworld.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.OwnerDAOImpl;
import au.com.spicyworld.model.Owner;

/**
 * Servlet implementation class Authenticator
 */

public class Authenticator extends HttpServlet {
	
	String Username = null;
	String Password = null;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Owner owner = new Owner();
		Username = request.getParameter("username");
		Password = request.getParameter("password");
		owner.setUsername(Username);
		owner.setPassword(Password);
		if (Username != "" & Password != "") {

			OwnerDAOImpl ownerDAOImpl = new OwnerDAOImpl();
			try {
				//System.out.println(ownerDAOImpl.authenticate(owner));
				if (ownerDAOImpl.authenticate(owner)) {

					session.setAttribute("MESSAGE", "Login successful");
					session.setAttribute("USERNAME", Username);
					session.removeAttribute("ERROR");
					RequestDispatcher rd = request.getRequestDispatcher("home_admin.jsp");
					rd.forward(request, response);

				} else {
					session.setAttribute("ERROR", "Login fail");
					response.sendRedirect("login_admin.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("ERROR", "Login fail");
				response.sendRedirect("login_admin.jsp");
			}
		}

	}

}
