package au.com.spicyworld.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import au.com.spicyworld.model.Customer;
import au.com.spicyworld.model.Item;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMail implements MailInterface{
	
	
	public boolean sendMail(Customer customer, CartMain cartmain) {
		boolean flag =false;
		try {
			String host = "smtp.gmail.com";
			
			String to = customer.getEmailid();
			
			String from = user;
			

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, pass);
				}
			});
			try {

				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				// Set Subject: header field
				String subject= "Test";
				subject= Integer.toString(customer.getOrder_ID());
				message.setSubject("Order No:"+subject);

				// This mail has 2 part, the BODY and the embedded image
				MimeMultipart multipart = new MimeMultipart("related");

				// first part (the html)
				BodyPart messageBodyPart = new MimeBodyPart();
				String htmlText = this.setInvoice(customer, cartmain);
				
				messageBodyPart.setContent(htmlText, "text/html");
				// add it
				multipart.addBodyPart(messageBodyPart);

				

				// put everything together
				message.setContent(multipart);
				// Send message
				Transport.send(message);
				flag=true;
			} catch (MessagingException e) {
				System.out.println(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return false;
			}
		} catch (NullPointerException ex) {
			//System.out.println(ex);
			return false;
		}
		return flag;
	}
	
	public String setInvoice(Customer customer, CartMain cartmain) throws SQLException {
		// TODO Auto-generated method stub
		String part1 = "<div style=\"height: auto; width:auto;\">\r\n" + 
				"	<div style=\"background-color: #dddddd;\" align=\"	center\"><h1>INVOICE</h1></div>\r\n" + 
				"	<div>\r\n" + 
				"			<table style=\"font-family: arial, sans-serif;\r\n" + 
				"							border-collapse: collapse;\r\n" + 
				"							width: 100%;\">\r\n" + 
				"					<tr>\r\n" + 
				"						<td style=\"border: 1px solid #000000;background-color: #dce1dc;text-align: left;padding: 8px;\">Invoice NO</td>\r\n" + 
				"						<td style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getOrder_ID() +"</td>\r\n" + 
				"						<td style=\"border: 1px solid #000000;background-color: #dce1dc;text-align: left;padding: 8px;\">Order No</td>\r\n" + 
				"						<td style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getOrder_ID() +"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<th style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Pickup Date</th>\r\n" + 
				"						<th style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getPickdate()+"</th>\r\n" + 
				"						<th style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Pickup Time</th>\r\n" + 
				"						<th style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getPicktime()+"</th>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Name</td>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getFirstname() +" "+customer.getLastname()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Email Id</td>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getEmailid()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Contact Info</td>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getMobileno()+"</td>\r\n" + 
				"					</tr>\r\n" + 
				"					<tr>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Address</td>\r\n" + 
				"						<td colspan='2' style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+customer.getAddress()+"</td>\r\n" + 
				"					</tr>	\r\n" + 
				"			</table>\r\n" + 
				"	</div>\r\n" + 
				"	<div>\r\n" +
				"		<table style=\"font-family: arial, sans-serif;\r\n" + 
				"							border-collapse: collapse;\r\n" + 
				"							width: 100%; \">\r\n" + 
				"  <tr>\r\n" + 
				"    <th style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Item ID</th>\r\n" + 
				"    <th style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Item Quantity</th>\r\n" + 
				"    <th style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">Total Price</th>\r\n" + 
				"  </tr>\r\n"; 
				
		String part2="\r\n";
		Map< String ,Integer> cart =  cartmain.getCartListHash();
 		Set< Map.Entry< String,Integer> > st = cart.entrySet();
 		ItemImpl itemimpl =  new ItemImpl();
 		Item item = new Item();
		float total_price = 0;
 		for (Map.Entry<String, Integer> me : st) 
 		{	
 			
 			item =itemimpl.getItem_info(me.getKey(), me.getValue());
 			float price = item.getItem_price()*item.getItem_quantitymax();
 			price = (float) (Math.round(price * 100.0) / 100.0);
 			total_price = price + total_price;
 			String dummypart2= "  <tr>\r\n" + 
 					"    <td style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+item.getItem_name()+"</td>\r\n" + 
 					"    <td style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">"+item.getItem_quantitymax()+"</td>\r\n" + 
 					"    <td style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">$"+price+"</td>\r\n" + 
 					"  </tr>\r\n" + 
 					"  \r\n" + 
 					"  \r\n" ;
 			part2 = part2 + dummypart2;
 			
 			
 		}
 		
				
 		total_price = (float) (Math.round(total_price * 100.0) / 100.0);
		String part3= "  <tr>\r\n" + 
				"	<td style=\"border: 1px solid #000000;text-align: left;padding: 8px;\"></td>\r\n" + 
				"	<td style=\"border: 1px solid #000000;background-color: #dce1dc;text-align: left;padding: 8px;\">Total Price</td>\r\n" + 
				"	<td style=\"border: 1px solid #000000;text-align: left;padding: 8px;\">$"+total_price+"</td>\r\n" + 
				"  </tr>\r\n" + 
				"</table>\r\n" + 
				"</div>\r\n" + 
				"</div>";
		return part1 + part2 + part3;
	}
	
	public boolean sendMail(String owner, Customer customer, CartMain cartmain) {
		
		boolean flag =false;
		try {
			String host = "smtp.gmail.com";
			
			String to = owner;
			String from = user;
			

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");


			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, pass);
				}
			});
			try {

				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				// Set Subject: header field
				String subject= "Test";
				subject= Integer.toString(customer.getOrder_ID());
				message.setSubject(subject);

				// This mail has 2 part, the BODY and the embedded image
				MimeMultipart multipart = new MimeMultipart("related");

				// first part (the html)
				BodyPart messageBodyPart = new MimeBodyPart();
				String htmlText = this.setInvoice(customer, cartmain);
				messageBodyPart.setContent(htmlText, "text/html");
				// add it
				multipart.addBodyPart(messageBodyPart);
				// put everything together
				message.setContent(multipart);
				// Send message
				Transport.send(message);
				flag=true;
			} catch (MessagingException e) {
				//
				return false;
			}
		} catch (Exception ex) {
			//System.out.println(ex);
			return false;
		}
		return flag;
	}
}
