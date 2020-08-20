package sharpenUserAccounts;

public class userAccount {
	
	private String userMail;
	private String userPassword;
	private String userName;
	private String userSurname;
	private String userStreet;
	private String userPostalCode;
	private String userCity;
	private int userPhone;
	
	
	public userAccount(String userMail, String userPassword, String userName, String userSurname, String userStreet, String userPostalCode, String userCity, int userPhone) {
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSurname = userSurname;
		this.userStreet = userStreet;
		this.userPostalCode = userPostalCode;
		this.userCity = userCity;
		this.userPhone = userPhone;
	}


	public String getUserMail() {
		return userMail;
	}


	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserSurname() {
		return userSurname;
	}


	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}


	public String getUserStreet() {
		return userStreet;
	}


	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}


	public String getUserPostalCode() {
		return userPostalCode;
	}


	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;
	}


	public String getUserCity() {
		return userCity;
	}


	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}


	public int getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}
	
	public String toString() {
		return "e-mail: " + userMail + "\nName: " + userName + "\nSurname: " + userSurname + "\nStreet: " + userStreet + "\nPostal Code: " + userPostalCode + "\nCity: " + userCity + "\nPhone Number: " + userPhone;
		
	}
}
