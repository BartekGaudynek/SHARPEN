package sharpenDataBase;

import java.sql.SQLException;
import sharpenUserAccounts.userAccount;

public class addUser {

	private newConnection connection;
	private userAccount account;
	
	public addUser(newConnection connection, userAccount account) {
		this.connection = connection;
		this.account = account;
		dbAddUser();
	}
	
	public void dbAddUser() {
		
		try {
			connection.getStatement().execute("INSERT INTO sharpenUSERS (userMail, userPassword) VALUES ('" + account.getUserMail() + "','" + account.getUserPassword() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
