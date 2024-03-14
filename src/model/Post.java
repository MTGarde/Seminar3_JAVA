package model;

import java.time.LocalDateTime;

public class Post {
	//1. variables
	private String msg;
	private LocalDateTime dateTime;
	private int countOfLikes = 0; 
	//2. get and set
	public String getMsg() {
		return msg;
	}
	
	
	public void setMsg(String msg) {
		if(msg != null && msg.length() > 5 && msg.length() < 300)
			this.msg = msg;
		else
			this.msg = "------";
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}
	public int getCountOfLikes() {
		return countOfLikes;
	}
	//TODO glabajam lietotajus, kuri ir piespieduši like
	public void incrementCountOfLikes() {
		this.countOfLikes++;
	}
		
	//3. constructors
	public Post() {
		setMsg("Test msg");
		setDateTime();
	}
	
	public Post(String msg) {
		setMsg(msg);
		setDateTime();
	}
	
	
	//4. toString
	public String toString() {
		return msg + "(" + dateTime + ") likes [" +countOfLikes+ "]";
	}
	
		
	//5. other functions

}
