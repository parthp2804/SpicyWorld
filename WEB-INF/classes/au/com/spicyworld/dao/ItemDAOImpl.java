package au.com.spicyworld.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import au.com.spicyworld.model.Item;

public class ItemDAOImpl implements ItemDAO {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	public ItemDAOImpl() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean Insert_item(Item item) throws IOException {

		try {
			String query = "insert into item_tb values(?,?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, item.getItem_id());
			statement.setString(2, item.getItem_name());
			statement.setString(3, item.getItem_category());
			statement.setFloat(4, item.getItem_price());
			statement.setInt(5, item.getItem_quantitymax());
			InputStream inputStream = null;
			inputStream = item.getItem_image().getInputStream();
			// FileInputStream fin = new FileInputStream(item.getItem_image());
			statement.setBlob(6, inputStream);

			if (statement.executeUpdate() >= 1) {
				connection.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public boolean Update_item_price(Item item) {
		String query1 = "update item_tb set item_price = ? where item_id = ?";
		try {
			statement = connection.prepareStatement(query1);
			statement.setFloat(1, item.getItem_price());
			statement.setString(2, item.getItem_id());
			if (statement.executeUpdate() >= 1) {
				connection.close();
				return true;}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public boolean Update_item_quantitymax(Item item) {
		String query2 = "update item_tb set item_quantitymax = ? where item_id = ?";
		try {
			statement = connection.prepareStatement(query2);
			statement.setInt(1, item.getItem_quantitymax());
			statement.setString(2, item.getItem_id());
			if (statement.executeUpdate() >= 1) {
				connection.close();
				return true;
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public boolean Update_item_image(Item item) throws IOException {
		String query2 = "update item_tb set item_image = ? where item_id = ?";
		try {
			statement = connection.prepareStatement(query2);
			InputStream inputStream = null;
			inputStream = item.getItem_image().getInputStream();
			// FileInputStream fin = new FileInputStream(item.getItem_image());
			statement.setBlob(1, inputStream);
			statement.setString(2, item.getItem_id());
			if (statement.executeUpdate() >= 1) {
				connection.close();
				return true;
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	public boolean Delete_item(String item_id) {
		try {
			String query = "delete from item_tb where item_id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, item_id);

			if (statement.executeUpdate() >= 1) {
				connection.close();
				return true;
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public Item getItem(String item_id) {
		try {
			String query = "select * from item_tb where item_id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, item_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		try {
			while (resultSet.next()) {
				Item item = new Item();
				item.setItem_id(item_id);

				String item_name = null;
				String item_category = null;
				float item_price = 0;
				int item_quantitymax = 0;
				item.setItem_name(item_name);
				item.setItem_category(item_category);
				item.setItem_price(item_price);
				item.setItem_quantitymax(item_quantitymax);
				connection.close();
				return item;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}