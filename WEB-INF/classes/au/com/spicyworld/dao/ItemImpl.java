package au.com.spicyworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import au.com.spicyworld.model.Item;

public class ItemImpl implements ItemInterface {
	
	private String query;
	private String query1;
	private String queryd;
	private ResultSet rs = null;
	private Connection connection;
	private PreparedStatement pr = null;
	private String password = null;
	private Item item= null;
	
	public ItemImpl() {
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int max_limit(String item_id) throws SQLException {
		// TODO Auto-generated method stub
		query = "select item_quantitymax from item_tb where item_id=?";
		pr = connection.prepareStatement(query);
		pr.setString(1, item_id);
		
		rs = pr.executeQuery();
		while(rs.next()) {
			return  rs.getInt("item_quantitymax");
		}
		connection.close();
		return 0;
	}

	
	public Item getItem_info(String item_id, Integer quantity) throws SQLException {
		// TODO Auto-generated method stub
		item=  new Item();
		query = "select * from item_tb where item_id=?";
		pr = connection.prepareStatement(query);
		pr.setString(1, item_id);
		
		rs = pr.executeQuery();
		while(rs.next()) {
			item.setItem_id(item_id);
			item.setItem_name(rs.getString("item_name"));
			item.setItem_category(rs.getString("item_category"));
			item.setItem_price(rs.getFloat("item_price"));
			item.setItem_quantitymax(quantity.intValue());
			item.setItem_image(null);
			return item;
		}
		connection.close();
		return null;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
