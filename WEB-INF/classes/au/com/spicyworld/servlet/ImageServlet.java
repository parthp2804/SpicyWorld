package au.com.spicyworld.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import au.com.spicyworld.dao.ItemDAO;
import au.com.spicyworld.dao.ItemDAOImpl;
import au.com.spicyworld.model.Item;

public class ImageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String USERNAME = "spicy481_sunny123";
		final String PASSWORD = "******";
		final String DATABASE = "spicy481_storemngt_db";
		final String connectionString = "jdbc:mysql://localhost:3306/"+DATABASE;
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
			statement = connection.prepareStatement("select item_image from item_tb where item_id=?");
			statement.setString(1, request.getParameter("item_id"));
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				response.getOutputStream().write(resultSet.getBytes("item_image"));
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			response.sendRedirect("home.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			response.sendRedirect("home.jsp");
		}
	}
	
}
