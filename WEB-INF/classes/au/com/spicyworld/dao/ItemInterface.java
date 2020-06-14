package au.com.spicyworld.dao;

import java.sql.SQLException;

import au.com.spicyworld.model.Item;

public interface ItemInterface {
	final String ItemTable = "item_tb";
	final String DRIVER= "com.mysql.jdbc.Driver";
	final String DATABASE="spicy481_storemngt_db";
	final String URL="jdbc:mysql://localhost:3306/spicy481_storemngt_db";//serverTimezone=UTC";
	final String USERNAME = "spicy481_sunny123";
	final String PASSWORD = "*******";
	public int max_limit(String item_id) throws SQLException;
	public Item getItem_info(String item_id, Integer quantity) throws SQLException;
}
