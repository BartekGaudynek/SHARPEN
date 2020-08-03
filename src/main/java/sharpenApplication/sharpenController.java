package sharpenApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sharpenController {

	@GetMapping("/home")
	public String pageHome() {
		return "home";
	}
	
	@GetMapping("/products")
	public String pageProducts() {
		return "products";
	}
	
	@GetMapping("/products/knives")
	public String pageKnives() {
		return "productsKnives";
	}
	
	@GetMapping("/products/knives/knife1")
	public String pageKnifeOne() {
		return "knife1";
	}
	
	@GetMapping("/contact")
	public String pageContact() {
		return "contact";
	}
}
