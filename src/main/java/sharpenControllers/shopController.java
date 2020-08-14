package sharpenControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sharpenProducts.storeManager;

@Controller
public class shopController {
	
	@GetMapping("/basket")
	public String pageHome(Model model) {
		model.addAttribute("basket", storeManager.getBasket().getBasket());
		model.addAttribute("cena", storeManager.getBasket().getSuma());
		return "basket";
	}
}
