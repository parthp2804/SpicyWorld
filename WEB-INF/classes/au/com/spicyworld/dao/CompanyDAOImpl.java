package au.com.spicyworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import au.com.spicyworld.model.Company;

public class CompanyDAOImpl implements CompanyDAO {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	public CompanyDAOImpl() throws SQLException {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean Insert_company(Company company) {
		try {
			String query = "insert into company_tb values(?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, company.getCompany_id());
			statement.setString(2, company.getCompany_name());
			statement.setString(3, company.getCompany_email());
			statement.setString(4, company.getCompany_number());

			if (statement.executeUpdate() >= 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean Update_company_mail(Company company) {
		String query1 = "update company_tb set company_mail = ? where company_id = ?";
		try {
			statement = connection.prepareStatement(query1);
			statement.setString(1, company.getCompany_email());
			statement.setInt(2, company.getCompany_id());
			if (statement.executeUpdate() >= 1) {

				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;

	}

	public boolean Update_company_contact(Company company) {
		String query2 = "update company_tb set company_number = ? where company_id = ?";
		try {
			statement = connection.prepareStatement(query2);
			statement.setString(1, company.getCompany_name());
			statement.setInt(2, company.getCompany_id());
			if (statement.executeUpdate() >= 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean Delete_company(int company_id) {
		try {
			String query = "delete from company_tb where company_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, company_id);

			if (statement.executeUpdate() >= 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public Company getCompany(int company_id) {
		try {
			String query = "select * from company_tb where company_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, company_id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		try {
			while (resultSet.next()) {
				Company company = new Company();
				company.setCompany_id(company_id);

				String company_name = null;
				String company_email = null;
				String company_number = null;
				company.setCompany_name(company_name);
				company.setCompany_email(company_email);
				company.setCompany_number(company_number);
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
