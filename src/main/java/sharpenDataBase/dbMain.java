package sharpenDataBase;

import sharpenUserAccounts.userAccount;

public class dbMain {

	public static void main(String[] args) {
		
		newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
//		new addUser(sharpenDB, new userAccount("adres@adres.pl", "adres"));
//		new removeUser(sharpenDB,"adres@adres.pl");
	}
}
