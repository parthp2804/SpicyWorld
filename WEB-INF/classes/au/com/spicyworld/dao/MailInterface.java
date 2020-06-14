package au.com.spicyworld.dao;

import java.sql.SQLException;

import au.com.spicyworld.model.Customer;

public interface MailInterface {
	final String user = "<email_id>";//enable the mail to send emails from 3rd party software
	final String pass = "********";
	public boolean sendMail(Customer customer, CartMain cartmain);
	//send mail to customer
	public boolean sendMail(String owner,Customer customer, CartMain cartmain) throws SQLException;
	//send mail to owner
	public String setInvoice(Customer customer, CartMain cartmain) throws SQLException;
}
