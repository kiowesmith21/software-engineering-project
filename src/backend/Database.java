import java.sql.*;

public class Database {

	static Connection connection = null;
	//this part is the address and name of your database server: jdbc:mysql://localhost:3306/VC3
	//this part of the string is for time adjustment: ?useTimezone=true&serverTimezone=UTC
	static String url = "jdbc:mysql://localhost:3306/VC3?useTimezone=true&serverTimezone=UTC";
	static String username = "root";
	static String password = "Dancer16!";

	public static void main(String[] args) {

		try {
			//tdeclares a connection to your database
			connection = DriverManager.getConnection(url, username, password);
			//creates an insert query
			String sql = "INSERT INTO table1" + "(ClientID , name)" + "VALUES (23, 'David Cruise')";
			//establishes the connection session
			Statement statement = connection.createStatement();
			//executes the query 
			int row = statement.executeUpdate(sql);
			//the return value is the indication of success or failure of the query execution
			if (row > 0)
				System.out.println("Data was inserted!");

			connection.close();
			
		} catch (SQLException e) {
			e.getMessage();

		}
	}
}