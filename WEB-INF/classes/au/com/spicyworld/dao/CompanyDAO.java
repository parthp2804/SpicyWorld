package au.com.spicyworld.dao;

import au.com.spicyworld.model.Company;

public interface CompanyDAO {
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String USERNAME = "spicy481_sunny123";
	final String PASSWORD = "*******";
	final String DATABASE = "spicy481_storemngt_db";
	final String connectionString = "jdbc:mysql://localhost:3306/" + DATABASE;

	public boolean Insert_company(Company company);

	public boolean Update_company_mail(Company company);

	public boolean Update_company_contact(Company company);

	public boolean Delete_company(int company_id);

	public Company getCompany(int company_id);
}
