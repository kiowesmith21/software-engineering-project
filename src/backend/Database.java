package backend; 

import java.sql.*;

public class Database {

	static Connection connection = null;
	static String url = "jdbc:mysql://localhost:3306/VC3?useTimezone=true&serverTimezone=UTC";
	static String username = "root";
	static String password = "Dancer16!";

	public static void insertIntoDatabase(String clientName, int clientID, String jobName, int jobID, String timestamp, int Duration) {
		
		try {
			//declares a connection to your database
			connection = DriverManager.getConnection(url, username, password);
			//creates an insert query
			String sql = "INSERT INTO client" + "(ClientID , name)" + " VALUES ("+ clientID +", '"+ clientName +"')";
			String sql2 = "INSERT INTO job" + "(JobID , duration, timeSubmitted, clientID)" + " VALUES ("+ jobID +", '"+ Duration +"', "+ timestamp +", '"+ clientID +"')";
			//establishes the connection session
			Statement statement = connection.createStatement();
			//executes the query 
			int row = statement.executeUpdate(sql);
			//the return value is the indication of success or failure of the query execution
			if (row > 0)
				System.out.println("Client Data was inserted!");
				row = statement.executeUpdate(sql2);
			//the return value is the indication of success or failure of the query execution
			if (row > 0)
				System.out.println("Job Data was inserted!");

			connection.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}