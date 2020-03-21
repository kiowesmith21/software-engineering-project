package backend;

import java.sql.Timestamp;

public class User {
	protected String id;
	protected String name;
	protected Timestamp registeredTime;
	
	public User() {
		
	}
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
		this.registeredTime = new Timestamp(System.currentTimeMillis());
	}
}
