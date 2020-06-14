package au.com.spicyworld.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.ItemDAOImpl;
import au.com.spicyworld.model.Item;
public class UpdateItemquantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd = null;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		
		HttpSession session=request.getSession();
		Item item  = new Item();
		item.setItem_id(request.getParameter("item_id"));
		item.setItem_quantitymax(Integer.parseInt(request.getParameter("item_quantitymax")));
		
		try {
			ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
				if(itemDAOImpl.Update_item_quantitymax(item)) {
					 session.setAttribute("MESSAGE", "Item updated successfully");
						response.sendRedirect("home_admin.jsp");}
					else
						session.setAttribute("ERROR","Invalid input: item not inserted");
						response.sendRedirect("updatequantityitem.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
