package sharpenControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sharpenProducts.storeManager;

@Controller
public class productController {
	
	storeManager storeSharpen = new storeManager();
	
	@GetMapping("/products")
	public String pageProduct() {
		return "products";
	}

	// -----------------------------------------------------MAIN PRODUCT CATEGORIES	
	
	@GetMapping("/products/melee")
	public String pageMelee() {
		return "productsMeleeWeapon";
	}
	
	@GetMapping("/products/firearms")
	public String pageFirearms() {
		return "productsFireArms";
	}
	
	// -----------------------------------------------------PRODUCT SUBCATEGORIES
	
	@GetMapping("/products/melee/blunt")
	public String pageBlunt(Model model) {
		model.addAttribute("blunt", storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts());
		return "productsBlunt";
	}
	
	@GetMapping("/products/melee/knives")
	public String pageKnives() {
		return "productsKnives";
	}
	
	@GetMapping("/products/firearms/handguns")
	public String pageHandguns() {
		return "productsHandguns";
	}
	
	@GetMapping("/products/firearms/shotguns")
	public String pageShotguns() {
		return "productsShotguns";
	}
	
	// -----------------------------------------------------BLUNT WEAPON PRODUCTS
	
	@GetMapping("/products/melee/blunt/blunt1")
	public String pageBlunt1() {
		
		return "blunt1";
	}
	
	@GetMapping("/products/melee/blunt/blunt2")
	public String pageBlunt2() {
		return "blunt2";
	}
	
	@GetMapping("/products/melee/blunt/blunt3")
	public String pageBlunt3() {
		return "blunt3";
	}
	
	@GetMapping("/products/melee/blunt/blunt4")
	public String pageBlunt4() {
		return "blunt4";
	}
	
	@GetMapping("/products/melee/blunt/blunt5")
	public String pageBlunt5() {
		return "blunt5";
	}
	
	// -----------------------------------------------------KNIFE PRODUCTS
	
	@GetMapping("/products/melee/knives/knife1")
	public String pageKnife1() {
		return "knife1";
	}
	
	@GetMapping("/products/melee/knives/knife2")
	public String pageKnife2() {
		return "knife2";
	}
	
	@GetMapping("/products/melee/knives/knife3")
	public String pageKnife3() {
		return "knife3";
	}
	
	@GetMapping("/products/melee/knives/knife4")
	public String pageKnife4() {
		return "knife4";
	}
	
	@GetMapping("/products/melee/knives/knife5")
	public String pageKnife5() {
		return "knife5";
	}
	
	// -----------------------------------------------------HANDGUN PRODUCTS
	
	@GetMapping("/products/firearms/handguns/handgun1")
	public String pageHandgun1() {
		return "handgun1";
	}
	
	@GetMapping("/products/firearms/handguns/handgun2")
	public String pageHandgun2() {
		return "handgun2";
	}
	
	@GetMapping("/products/firearms/handguns/handgun3")
	public String pageHandgun3() {
		return "handgun3";
	}
	
	@GetMapping("/products/firearms/handguns/handgun4")
	public String pageHandgun4() {
		return "handgun4";
	}
	
	@GetMapping("/products/firearms/handguns/handgun5")
	public String pageHandgun5() {
		return "handgun5";
	}
	
	// -----------------------------------------------------SHOTGUN PRODUCTS
	
	@GetMapping("/products/firearms/shotguns/shotgun1")
	public String pageShotgun1() {
		return "shotgun1";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun2")
	public String pageShotgun2() {
		return "shotgun2";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun3")
	public String pageShotgun3() {
		return "shotgun3";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun4")
	public String pageShotgun4() {
		return "shotgun4";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun5")
	public String pageShotgun5() {
		return "shotgun5";
	}
	
}
