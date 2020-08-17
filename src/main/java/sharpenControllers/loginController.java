package sharpenControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

	@GetMapping("/login")
	public String pageLogin() {
		return "login";
	}
	
	@GetMapping("/register")
	public String pageRegister() {
		return "register";
	}
	
	@GetMapping("/account")
	public String pageAccount() {
		return "account";
	}
}
