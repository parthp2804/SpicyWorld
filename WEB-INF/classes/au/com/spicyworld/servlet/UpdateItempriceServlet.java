package au.com.spicyworld.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.ItemDAOImpl;
import au.com.spicyworld.model.Item;


public class UpdateItempriceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		HttpSession session=request.getSession();
		Item item  = new Item();
		item.setItem_id(request.getParameter("item_id"));
		item.setItem_price(Float.parseFloat(request.getParameter("item_price")));
		
		try {
			ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
				if(itemDAOImpl.Update_item_price(item)) {
					 
					 session.setAttribute("MESSAGE", "Item updated successfully");
					 response.sendRedirect("home_admin.jsp");}
				else
					session.setAttribute("ERROR","Invalid input: item not updated");
					response.sendRedirect("updatepriceitem.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
