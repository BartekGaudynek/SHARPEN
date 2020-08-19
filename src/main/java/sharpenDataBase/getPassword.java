package sharpenDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import sharpenUserAccounts.userAccount;

public class getPassword {

	private newConnection connection;
	private String email;
	private String password;
	
	public getPassword(newConnection connection, String email) {
		this.connection = connection;
		this.email = email;
	}
	
	public boolean isMailInDB() {
		try {
			ResultSet resultEmail = connection.getStatement().executeQuery("SELECT userPassword from sharpenUSERS WHERE userMail='"+email+"';");
			while(resultEmail.next()) {
				password = resultEmail.getString("userPassword");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (password==null)
			return false;
		else
			return true;
	}
	
	public String getUserPassword() {
		
		try {
			ResultSet resultEmail = connection.getStatement().executeQuery("SELECT userPassword from sharpenUSERS WHERE userMail='"+email+"';");
			while(resultEmail.next()) {
				password = resultEmail.getString("userPassword");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
	
}
