package sharpenControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import sharpenDataBase.addUser;
import sharpenDataBase.getPassword;
import sharpenDataBase.newConnection;
import sharpenProducts.storeManager;
import sharpenShopping.shoppingClient;
import sharpenUserAccounts.userAccount;

@Controller
public class loginController {

//	-----------------------------------------------------CLASSIC LOGIN SITE
	
	@GetMapping("/login")
	public ModelAndView pageLogin() {
		
		if (storeManager.loginStatus = true) {
			
			return new ModelAndView("redirect:/account");
		}
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView redirectToAccount(@RequestParam(value = "email") String login, @RequestParam(value = "password") String password, HttpServletRequest request) {
		
			newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
			getPassword getPassword = new getPassword(sharpenDB,login);
			String dbPassword = getPassword.getUserPassword();
		
			if (getPassword.isMailInDB()==true) {
				if (dbPassword.equals(password)) {		
					request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
					storeManager.client = new shoppingClient(login);
					storeManager.loginStatus = true;
					return new ModelAndView("redirect:/account");
				}
				else
					return new ModelAndView("loginPasswordError");
			}
			else
				return new ModelAndView("loginEmailError");
		
	}
	
	@PostMapping("/account")
	public ModelAndView redirectedToAccount() {
		return new ModelAndView("account");
	}
	
//	----------------------------------------------------- LOGIN SITE (SHOPPING PROCESS)
	
	
//	-----------------------------------------------------REGISTRATION SITE
	@GetMapping("/register")
	public String pageRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String pageRegisterUpdate(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, @RequestParam(value = "password1") String password1, @RequestParam(value = "street") String street, @RequestParam(value = "postalcode") String postalcode, 
			@RequestParam(value = "city") String city, @RequestParam(value = "phone") String phone) {
		if (name.isEmpty()==false && surname.isEmpty()==false && email.isEmpty()==false && password.isEmpty()==false && street.isEmpty()==false && postalcode.isEmpty()==false && city.isEmpty()==false && phone.isEmpty()==false) {
			if (email.contains("@") && (email.lastIndexOf(".", email.length()) == email.length()-3 || email.lastIndexOf(".", email.length()) == email.length()-4 || email.lastIndexOf(".", email.length()) == email.length()-5)) {
				if (password.equals(password1)) {
					System.out.println(name + "," + surname + "," + email + "," + password + "," + street + "," + postalcode + "," + city + "," + phone);
					newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
					new addUser(sharpenDB, new userAccount(email,password,name,surname,street,postalcode,city,Integer.parseInt(phone)));
					return "registerComplete";
				}
				else 
					return "registerPasswordError";
			}
			else
				return "registerEmailError";
		}
		else
			return "registerError";
	}
	
//	-----------------------------------------------------ACCOUNT PANEL SITE
	@GetMapping("/account")
	public String pageAccount() {
		return "account";
	}
}
