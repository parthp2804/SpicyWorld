package au.com.spicyworld.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import au.com.spicyworld.model.Item;

public interface ItemDAO {

	final String DRIVER = "com.mysql.jdbc.Driver";
	final String USERNAME = "spicy481_sunny123";
	final String PASSWORD = "******";
	final String DATABASE = "spicy481_storemngt_db";
	final String connectionString = "jdbc:mysql://localhost:3306/" + DATABASE;
	
	
	public boolean Insert_item(Item item) throws FileNotFoundException, IOException;
	public boolean Update_item_price(Item item);
	public boolean Update_item_quantitymax(Item item);
	public boolean Update_item_image(Item item) throws IOException;
	public boolean Delete_item(String item_id);
	public Item getItem(String item_id);
	
	
}
