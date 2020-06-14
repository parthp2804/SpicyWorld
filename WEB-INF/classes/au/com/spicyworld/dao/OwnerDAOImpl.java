package au.com.spicyworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import au.com.spicyworld.model.Owner;

public class OwnerDAOImpl implements OwnerDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	private PreparedStatement pr = null;

	public OwnerDAOImpl() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
			statement = connection.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean authenticate(Owner owner) throws SQLException {

		String query = "select * from owner_login_tb where username='" + owner.getUsername() + "' and password='"
				+ owner.getPassword() + "'";
		// System.out.println(query);

		pr = connection.prepareStatement(query);
		resultSet = pr.executeQuery();
		while (resultSet.next()) {

			return true;

		}

		connection.close();
		return false;

	}

	public boolean createOwner(Owner owner) {
		try {

			String query1 = "insert into owner_info_tb values ('" + owner.getUsername() + "','" + owner.getFirstname()
					+ "','" + owner.getLastname() + "'," + owner.getAge() + ",'" + owner.getGender() + "','"
					+ owner.getMobileno() + "')";
			String query2 = "insert into owner_login_tb values ('" + owner.getUsername() + "','" + owner.getPassword()
					+ "')";

			statement.execute(query1);
			statement.execute(query2);

			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Owner getOwner(String username) {
		String query = "select * from owner_info_tb where username='" + username + "'";
		try {

			resultSet = statement.executeQuery(query);
		} catch (SQLException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			while (resultSet.next()) {
				Owner owner = new Owner();
				owner.setUsername(username);
				String firstname = null;
				int age = 0;
				String lastname = null;
				String gender = null;
				String mobileno = null;
				owner.setFirstname(firstname);
				owner.setLastname(lastname);
				owner.setAge(age);
				owner.setGender(gender);
				owner.setMobileno(mobileno);
				connection.close();
				return owner;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

}
