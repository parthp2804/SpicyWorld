package au.com.spicyworld.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import au.com.spicyworld.dao.ItemDAOImpl;
import au.com.spicyworld.model.Item;
@MultipartConfig(maxFileSize = 16177215)
public class InsertItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		HttpSession session=request.getSession();
		
		
		
		
		Item item  = new Item();
		
		item.setItem_id(request.getParameter("item_id"));
		item.setItem_name(request.getParameter("item_name"));
		item.setItem_category(request.getParameter("item_category"));
		item.setItem_price(Float.parseFloat(request.getParameter("item_price")));
		item.setItem_quantitymax(Integer.parseInt(request.getParameter("item_quantitymax")));
		item.setItem_image(request.getPart("item_image"));
		Part filepart = request.getPart("item_image");
		if(filepart!=null) {
			System.out.println(filepart.getName());
			System.out.println(filepart.getSize());
			System.out.println(filepart.getContentType());
		}
		
		try {
			ItemDAOImpl itemDAOImpl = new ItemDAOImpl();
				if(itemDAOImpl.Insert_item(item)) {
					 
					 session.setAttribute("MESSAGE", "Item added successfully");
					response.sendRedirect("home_admin.jsp");}
				else
					session.setAttribute("ERROR","Invalid input: item not inserted");
					response.sendRedirect("insertitem.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
	}
}
