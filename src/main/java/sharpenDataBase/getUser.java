package sharpenDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getUser {
	
	private newConnection connection;
	private String email;
	
	private String userMail;
	private String userPassword;
	private String userName;
	private String userSurname;
	private String userStreet;
	private String userPostalCode;
	private String userCity;
	private int userPhone;
	
	public getUser(newConnection connection, String email) {
		this.connection = connection;
		this.email = email;
		getData();
	}
	
	public void getData() {
		
		try {
			ResultSet resultUser = connection.getStatement().executeQuery("SELECT * from sharpenUSERS WHERE userMail='"+email+"';");
			while(resultUser.next()) {
				userMail = resultUser.getString("userMail");
				userPassword = resultUser.getString("userPassword");
				userName = resultUser.getString("userName");
				userSurname = resultUser.getString("userSurname");
				userStreet = resultUser.getString("userStreet");
				userPostalCode = resultUser.getString("userPostalCode");
				userCity = resultUser.getString("userCity");
				userPhone = resultUser.getInt("userPhone");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getUserMail() {
		return userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public String getUserStreet() {
		return userStreet;
	}

	public String getUserPostalCode() {
		return userPostalCode;
	}

	public String getUserCity() {
		return userCity;
	}

	public int getUserPhone() {
		return userPhone;
	}
	
	
}
