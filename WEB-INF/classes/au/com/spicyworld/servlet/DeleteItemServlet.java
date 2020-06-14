package au.com.spicyworld.servlet;

import java.io.IOException;
import au.com.spicyworld.dao.ItemDAOImpl;
import au.com.spicyworld.model.Item;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteItemServlet
 */

public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		HttpSession session=request.getSession();		
				Item item  = new Item();
				 item.setItem_id(request.getParameter("item_id"));
				try {
					ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
						if(itemDAOImpl.Delete_item(item.getItem_id())) {
							 
						     session.setAttribute("MESSAGE","Item added successfully");
							response.sendRedirect("home_admin.jsp");}
						else
							session.setAttribute("ERROR","Invalid input: item not deleted");
							response.sendRedirect("deleteitem.jsp");
				}catch(Exception e) {
					e.printStackTrace();
					
				}
				
			}

}
