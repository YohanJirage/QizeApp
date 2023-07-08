package entities;

public class User {
	
	private String u_id;
	private String password;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String contact;
	
	
	
	public User(String u_id, String password, String fname, String mname, String lname, String email, String contact) {
		
		this.u_id = u_id;
		this.password = password;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
	}



	public String getU_id() {
		return u_id;
	}



	public void setU_id(String u_id) {
		this.u_id = u_id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", password=" + password + ", fname=" + fname + ", mname=" + mname + ", lname="
				+ lname + ", email=" + email + ", contact=" + contact + "]";
	}
	
	
	
	
	
	

}
