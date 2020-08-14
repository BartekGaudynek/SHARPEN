package sharpenShopping;

import java.sql.ResultSet;
import java.sql.SQLException;

import sharpenDataBase.newConnection;
import sharpenProducts.storeManager;

public class shoppingClient {
	
	private String clientMail;
	private newConnection connection;
	
	private String clientName;
	private String clientSurname;
	private String clientStreet;
	private String clientPostalCode;
	private String clientCity;
	private int clientPhone;
	
	public shoppingClient (String clientMail) {
		this.clientMail = clientMail;
	}
	
	public shoppingClient () {
		
	}
	
	public String getRegisteredClientData() {
		connection = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
		try {
			ResultSet clientData = connection.getStatement().executeQuery("SELECT * FROM sharpenUSERS WHERE userMail='"+ clientMail +"';");
			while(clientData.next()) {
				clientName = clientData.getString("userName");
				clientSurname = clientData.getString("userSurname");
				clientStreet = clientData.getString("userStreet");
				clientPostalCode = clientData.getString("userPostalCode");
				clientCity = clientData.getString("userCity");
				clientPhone = clientData.getInt("userPhone");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Name: " + clientName + "\nSurname: " + clientSurname + "\nStreet: " + clientStreet + "\nPostal Code: " + clientPostalCode + "\nCity: " + clientCity + "\nPhone: " + clientPhone;
	}
	
	public void getUnregisteredClientData() {
		
	}
}
