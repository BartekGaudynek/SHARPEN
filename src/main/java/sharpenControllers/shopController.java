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

import sharpenDataBase.getPassword;
import sharpenDataBase.newConnection;
import sharpenProducts.Product;
import sharpenProducts.storeManager;
import sharpenShopping.shoppingClient;

@Controller
public class shopController {
	
	// umieszczam ogolnie dostepna zmienna client, z ktorej potem bedzie mozna wyciagac dane zalogowanych uzytkownikow
	
	@GetMapping("/basket")
	public String pageBasket(Model model) {
		model.addAttribute("basket", storeManager.getBasket().getBasket());
		model.addAttribute("cena", storeManager.getBasket().getSuma());
		
		if (storeManager.getBasket().getSuma()==0)
			return "basketEmpty";
		else
			return "basket";
	}
	
	@PostMapping("/basket")
	public String pageBasketUpdate(@RequestParam(value = "delete") String index, Model model) {
		model.addAttribute("basket", storeManager.getBasket().getBasket());
		storeManager.basket.getBasket().remove(Integer.parseInt(index));
		model.addAttribute("cena", storeManager.getBasket().getSuma());
		System.out.println(storeManager.basket.getBasket().size());
		System.out.println(storeManager.basket.getSuma());
		
		return "basket";
	}
	
	@GetMapping("/basket/login")
	public ModelAndView pageBasketLogin(Model model) {
		if (storeManager.loginStatus = true) {
			
			return new ModelAndView("redirect:/basket/zamowienie");
		}
		return new ModelAndView("basketLogin");
	}
	
	@PostMapping("/basket/login")
	public ModelAndView redirectToOrder(@RequestParam(value = "email") String login, @RequestParam(value = "password") String password, HttpServletRequest request) {
		
		newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
		getPassword getPassword = new getPassword(sharpenDB,login);
		String dbPassword = getPassword.getUserPassword();
		
		if (getPassword.isMailInDB()==true) {
			if (dbPassword.equals(password)) {		
				request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
				storeManager.client = new shoppingClient(login);
				storeManager.loginStatus = true;
				//System.out.println(client.getRegisteredClientData());
				//wyciąg danych zalogowanego uzytkownika
				return new ModelAndView("redirect:/basket/zamowienie");
			}
			else
				return new ModelAndView("basketLoginPasswordError");
		}
		else
			return new ModelAndView("basketLoginEmailError");
	}
	
	@PostMapping("/basket/zamowienie")
	public ModelAndView redirectedToOrder() {
		return new ModelAndView("basketOrder");
	}
	
	
	@GetMapping("/basket/zamowienie")
	public String pageOrder(Model model) {
		return "basketOrder";
	}
	
	@GetMapping("/basket/podsumowanie")
	public String pageSummary(Model model) {
		return "basketSummary";
	}
}
