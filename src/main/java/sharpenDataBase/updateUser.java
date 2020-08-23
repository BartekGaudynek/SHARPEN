package sharpenDataBase;

import java.sql.SQLException;

public class updateUser {

	private newConnection connection;
	
	private String userMail;
	private String userPassword;
	private String userName;
	private String userSurname;
	private String userStreet;
	private String userPostalCode;
	private String userCity;
	private int userPhone;
	
	public updateUser(newConnection connection, String userMail, String userPassword, String userName, String userSurname, 
			String userStreet, String userPostalCode, String userCity, int userPhone) {
		this.connection = connection;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSurname = userSurname;
		this.userStreet = userStreet;
		this.userPostalCode = userPostalCode;
		this.userCity = userCity;
		this.userPhone = userPhone;
	}
	
	public void updateData() {
		try {
			connection.getStatement().execute("UPDATE sharpenUSERS SET userName ='"+userName+"', userSurname='"+userSurname+"', userPassword='"+userPassword+"', userStreet='"+userStreet+"', userPostalCode='"+userPostalCode+"', userCity='"+userCity+"', userPhone="+userPhone+" WHERE userMail='"+userMail+"';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
