package sharpenDataBase;

import java.sql.SQLException;

import sharpenUserAccounts.userAccount;

public class removeUser {

	private newConnection connection;
	private String userMail;
	private userAccount account;
	
	public removeUser(newConnection connection, String userMail) {
		this.connection = connection;
		this.userMail = userMail;
		dbRemoveUser();
	}
	
	public void dbRemoveUser() {
		
		try {
			connection.getStatement().execute("DELETE FROM sharpenUSERS WHERE userMail='" + userMail+"';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

