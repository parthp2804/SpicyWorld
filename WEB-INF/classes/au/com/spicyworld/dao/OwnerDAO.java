package au.com.spicyworld.dao;



import java.sql.SQLException;

import au.com.spicyworld.model.Owner;

public interface OwnerDAO {
	
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String USERNAME = "spicy481_sunny123";
	final String PASSWORD = "*******";
	final String DATABASE = "spicy481_storemngt_db";
	final String connectionString = "jdbc:mysql://localhost:3306/" + DATABASE;
		
	public boolean authenticate(Owner owner) throws SQLException;
	public boolean createOwner(Owner owner);
	public Owner getOwner(String username);
}