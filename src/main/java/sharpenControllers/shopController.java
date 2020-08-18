package sharpenControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sharpenProducts.Product;
import sharpenProducts.storeManager;

@Controller
public class shopController {
	
	//dodac warunek w przypadku pustego koszyka
	
	@GetMapping("/basket")
	public String pageBasket(Model model) {
		model.addAttribute("basket", storeManager.getBasket().getBasket());
		model.addAttribute("cena", storeManager.getBasket().getSuma());
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
