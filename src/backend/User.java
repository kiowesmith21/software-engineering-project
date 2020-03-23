package backend;

import java.sql.Timestamp;

public class User {
	
	protected int id;
	protected String name;
	protected Timestamp registeredTime;
	
	/**
	 * Constructor for the user class.
	 * @param id: integer ID for a user
	 * @param name: string name for a user
	 */
	public User(int id, String name) {
		this.id = id;
		this.name = name;
		this.registeredTime = new Timestamp(System.currentTimeMillis());
	}

}
