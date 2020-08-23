package sharpenControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import sharpenDataBase.addUser;
import sharpenDataBase.getPassword;
import sharpenDataBase.getUser;
import sharpenDataBase.newConnection;
import sharpenDataBase.updateUser;
import sharpenProducts.storeManager;
import sharpenUserAccounts.userAccount;

@Controller
public class loginController {

//	-----------------------------------------------------CLASSIC LOGIN SITE
	
	@GetMapping("/login")
	public ModelAndView pageLogin() {
		
		if (storeManager.loginStatus == true) {
			
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
					storeManager.loginStatus = true;
					storeManager.loginEmail = login;
					return new ModelAndView("redirect:/account");
				}
				else
					return new ModelAndView("loginPasswordError");
			}
			else
				return new ModelAndView("loginEmailError");
		
	}
	
	@PostMapping("/account")
	public ModelAndView redirectedToAccount(Model model) {
		newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
		getUser getUser = new getUser(sharpenDB, storeManager.loginEmail);
		model.addAttribute("name", getUser.getUserName());
		return new ModelAndView("account");
	}	
	
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
	public String pageAccount(Model model) {
		
		newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
		getUser getUser = new getUser(sharpenDB, storeManager.loginEmail);
		model.addAttribute("name", getUser.getUserName());
		System.out.println(getUser.getUserName());
		
		return "account";
	}
	
	@GetMapping("/account/clientinfo")
	public String pageAccountClient(Model model) {
		
		newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
		getUser getUser = new getUser(sharpenDB, storeManager.loginEmail);
		System.out.println(storeManager.loginEmail);
		System.out.println(getUser.getUserName());
		model.addAttribute("name", getUser.getUserName());
		model.addAttribute("surname", getUser.getUserSurname());
		model.addAttribute("email", getUser.getUserMail());
		model.addAttribute("password", getUser.getUserPassword());
		model.addAttribute("street", getUser.getUserStreet());
		model.addAttribute("postalcode", getUser.getUserPostalCode());
		model.addAttribute("city", getUser.getUserCity());
		model.addAttribute("phone", getUser.getUserPhone());
		
		return "accountInfo";
	}
	
	@PostMapping("/account/clientinfo")
	public String pageAccountClientUpdate(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
			@RequestParam(value = "password") String password, @RequestParam(value = "street") String street, @RequestParam(value = "postalcode") String postalcode, 
			@RequestParam(value = "city") String city, @RequestParam(value = "phone") String phone, Model model) {
		
		newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
		updateUser updateUser = new updateUser(sharpenDB,storeManager.loginEmail,password,name,surname,street,postalcode,city,Integer.parseInt(phone));
		updateUser.updateData();
		
		return "accountInfo";
	}
	
	@GetMapping("/account/clientorders")
	public String pageAccountOrders() {
		return "accountOrders";
	}
	
	@GetMapping("/account/mysharpen")
	public String pageAccountMySharpen() {
		return "accountMySharpen";
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		storeManager.loginStatus = false;
		return new ModelAndView("redirect:/login");
	}
}
