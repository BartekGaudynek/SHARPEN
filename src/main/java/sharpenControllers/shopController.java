package sharpenControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sharpenProducts.storeManager;

@Controller
public class shopController {
	
	@GetMapping("/basket")
	public String pageBasket(Model model) {
		model.addAttribute("basket", storeManager.getBasket().getBasket());
		model.addAttribute("cena", storeManager.getBasket().getSuma());
		return "basket";
	}
	
	@GetMapping("/basket/login")
	public String pageBasketLogin(Model model) {
		return "basketLogin";
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
