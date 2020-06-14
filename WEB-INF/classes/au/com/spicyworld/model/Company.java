package au.com.spicyworld.model;

public class Company {
	
		private int company_id;
		private String company_name;
		private String company_email;
		private String company_number;
		
		public int getCompany_id() {
			return company_id;
		}
		public void setCompany_id(int company_id) {
			this.company_id = company_id;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public String getCompany_email() {
			return company_email;
		}
		public void setCompany_email(String company_email) {
			this.company_email = company_email;
		}
		public String getCompany_number() {
			return company_number;
		}
		public void setCompany_number(String comapny_number) {
			this.company_number = comapny_number;
		}
		@Override
		public String toString() {
			return "Company [company_id=" + company_id + ", company_name=" + company_name + ", company_email="
					+ company_email + ", comapny_number=" + company_number + ", getCompany_id()=" + getCompany_id()
					+ ", getCompany_name()=" + getCompany_name() + ", getCompany_email()=" + getCompany_email()
					+ ", getComapny_number()=" + getCompany_number() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
		
	
}
