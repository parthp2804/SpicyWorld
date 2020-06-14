package au.com.spicyworld.model;

public class Owner {
			private String firstname;
			private String lastname;
			private String gender;
			private String mobileno;
			private String username;
			private String password;
			private int age;
			
			public String getFirstname() {
				return firstname;
			}
			public void setFirstname(String firstname) {
				this.firstname = firstname;
			}
			public String getLastname() {
				return lastname;
			}
			public void setLastname(String lastname) {
				this.lastname = lastname;
			}
			public String getGender() {
				return gender;
			}
			public void setGender(String gender) {
				this.gender = gender;
			}
			public String getMobileno() {
				return mobileno;
			}
			public void setMobileno(String mobileno) {
				this.mobileno = mobileno;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			@Override
			public String toString() {
				return "Owner [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", mobileno="
						+ mobileno + ", username=" + username + ", password=" + password + ", age=" + age
						+ ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getGender()="
						+ getGender() + ", getMobileno()=" + getMobileno() + ", getUsername()=" + getUsername()
						+ ", getPassword()=" + getPassword() + ", getAge()=" + getAge() + ", getClass()=" + getClass()
						+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
			}
			
			
			
			
			
}
