package model.user;

import model.Post;
import model.PostType;

import java.security.MessageDigest;

public abstract class User extends GuestUser {
	//1.variables
	private String username;
	//TODO uztaisit enkodesanu, piemeram ar MD5
	private String password;
	protected String nameAndSurnameOrTitle;
	
	
	//2. get and set
	public String getUsername() {
		return username;
	}
	public void setUsername() {
		this.username = nameAndSurnameOrTitle+ "_" + getUserID();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		//TODO ievietot enkodēšanu
		if(password != null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,40}$"))
		{
			try{
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes());
				this.password = new String(md.digest());
			}
			catch(Exception e) {
				this.password = password;
			}
		}
		else{
		this.password = "--------";
		}

	}
	public String getNameAndSurnameOrTitle() {
		return nameAndSurnameOrTitle;
	}



    public abstract void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle);
	


	//3. constructors
	public User() {
		super(); //GuestUser()
		setPassword("1234567890");
		
	}
	
	public User(String password) {
		super();
		setPassword(password);
	}
	
	
	//4. toString
	
	public String toString() {
		return super.toString() + ":" + nameAndSurnameOrTitle + "(" + username + ")";
	}

	public abstract Post publishPost(PostType type, String message) throws Exception;

	//5. other functions
	
	//TODO login()
	//TODO followPage()
	

}
