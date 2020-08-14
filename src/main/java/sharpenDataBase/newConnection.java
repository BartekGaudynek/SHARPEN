package sharpenDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class newConnection {
	
	private String dbPath;
	private String dbUser;
	private String dbPassword;
	
	private Connection connection;
	private Statement statement;
	
	public newConnection(String dbPath,String dbUser,String dbPassword) {
		this.dbPath = dbPath;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbPath,dbUser,dbPassword);
			statement = connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Statement getStatement() {
		return statement;
	}
	
}