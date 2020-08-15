package sharpenControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sharpenProducts.Product;
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
		return "blunts";
	}
	
	@PostMapping("/products/melee/blunt")
	public String pageBluntUpdate(@RequestParam(value = "shbutton") int index, Model model) {
		model.addAttribute("blunt", storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts());
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(index);
		storeManager.basket.getBasket().add(product);
		System.out.println(storeManager.basket.getBasket().size());
		System.out.println(storeManager.basket.getSuma());
		return "blunts";
	}
	
	@GetMapping("/products/melee/knives")
	public String pageKnives(Model model) {
		model.addAttribute("knife", storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts());
		return "knives";
	}
	
	@PostMapping("/products/melee/knives")
	public String pageKnivesUpdate(@RequestParam(value = "shbutton") int index, Model model) {
		model.addAttribute("knife", storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts());
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(index);
		storeManager.basket.getBasket().add(product);
		System.out.println(storeManager.basket.getBasket().size());
		System.out.println(storeManager.basket.getSuma());
		return "knives";
	}
	
	@GetMapping("/products/firearms/handguns")
	public String pageHandguns(Model model) {
		model.addAttribute("handgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts());
		return "handguns";
	}
	
	@PostMapping("/products/firearms/handguns")
	public String pageHandgunsUpdate(@RequestParam(value = "shbutton") int index, Model model) {
		model.addAttribute("handgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts());
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(index);
		storeManager.basket.getBasket().add(product);
		System.out.println(storeManager.basket.getBasket().size());
		System.out.println(storeManager.basket.getSuma());
		return "handguns";
	}
	
	@GetMapping("/products/firearms/shotguns")
	public String pageShotguns(Model model) {
		model.addAttribute("shotgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts());
		return "shotguns";
	}
	
	@PostMapping("/products/firearms/shotguns")
	public String pageShotgunsUpdate(@RequestParam(value = "shbutton") int index, Model model) {
		model.addAttribute("shotgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts());
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(index);
		storeManager.basket.getBasket().add(product);
		System.out.println(storeManager.basket.getBasket().size());
		System.out.println(storeManager.basket.getSuma());
		return "shotguns";
	}
	
	// -----------------------------------------------------BLUNT WEAPON PRODUCTS
	
	@GetMapping("/products/melee/blunt/blunt1")
	public String pageBlunt1(Model model) {
		model.addAttribute("blunt", storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(0));
		return "blunt1";
	}
	
	@PostMapping("/products/melee/blunt/blunt1")
	public String pageBlunt1Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(0);
		model.addAttribute("blunt", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "blunt1";
	}
	
	@GetMapping("/products/melee/blunt/blunt2")
	public String pageBlunt2(Model model) {
		model.addAttribute("blunt", storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(1));
		return "blunt2";
	}
	
	@PostMapping("/products/melee/blunt/blunt2")
	public String pageBlunt2Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(1);
		model.addAttribute("blunt", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "blunt2";
	}
	
	@GetMapping("/products/melee/blunt/blunt3")
	public String pageBlunt3(Model model) {
		model.addAttribute("blunt", storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(2));
		return "blunt3";
	}
	
	@PostMapping("/products/melee/blunt/blunt3")
	public String pageBlunt3Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(2);
		model.addAttribute("blunt", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "blunt3";
	}
	
	@GetMapping("/products/melee/blunt/blunt4")
	public String pageBlunt4(Model model) {
		model.addAttribute("blunt", storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(3));
		return "blunt4";
	}
	
	@PostMapping("/products/melee/blunt/blunt4")
	public String pageBlunt4Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(3);
		model.addAttribute("blunt", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "blunt4";
	}
	
	@GetMapping("/products/melee/blunt/blunt5")
	public String pageBlunt5(Model model) {
		model.addAttribute("blunt", storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(4));
		return "blunt5";
	}
	
	@PostMapping("/products/melee/blunt/blunt5")
	public String pageBlunt5Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(0).getSubProducts().get(4);
		model.addAttribute("blunt", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "blunt5";
	}
	
	// -----------------------------------------------------KNIFE PRODUCTS
	
	@GetMapping("/products/melee/knives/knife1")
	public String pageKnife1(Model model) {
		model.addAttribute("knife", storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(0));
		return "knife1";
	}
	
	@PostMapping("/products/melee/knives/knife1")
	public String pageKnife1Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(0);
		model.addAttribute("knife", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "knife1";
	}
	
	@GetMapping("/products/melee/knives/knife2")
	public String pageKnife2(Model model) {
		model.addAttribute("knife", storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(1));
		return "knife2";
	}
	
	@PostMapping("/products/melee/knives/knife2")
	public String pageKnife2Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(1);
		model.addAttribute("knife", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "knife2";
	}
	
	@GetMapping("/products/melee/knives/knife3")
	public String pageKnife3(Model model) {
		model.addAttribute("knife", storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(2));
		return "knife3";
	}
	
	@PostMapping("/products/melee/knives/knife3")
	public String pageKnife3Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(2);
		model.addAttribute("knife", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "knife3";
	}
	
	@GetMapping("/products/melee/knives/knife4")
	public String pageKnife4(Model model) {
		model.addAttribute("knife", storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(3));
		return "knife4";
	}
	
	@PostMapping("/products/melee/knives/knife4")
	public String pageKnife4Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(3);
		model.addAttribute("knife", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "knife4";
	}
	
	@GetMapping("/products/melee/knives/knife5")
	public String pageKnife5(Model model) {
		model.addAttribute("knife", storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(4));
		return "knife5";
	}
	
	@PostMapping("/products/melee/knives/knife5")
	public String pageKnife5Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getMeleeWeapons().getSubcategories().get(1).getSubProducts().get(4);
		model.addAttribute("knife", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "knife5";
	}
	
	// -----------------------------------------------------HANDGUN PRODUCTS
	
	@GetMapping("/products/firearms/handguns/handgun1")
	public String pageHandgun1(Model model) {
		model.addAttribute("handgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(0));
		return "handgun1";
	}
	
	@PostMapping("/products/firearms/handguns/handgun1")
	public String pageHandgun1Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(0);
		model.addAttribute("handgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "handgun1";
	}
	
	@GetMapping("/products/firearms/handguns/handgun2")
	public String pageHandgun2(Model model) {
		model.addAttribute("handgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(1));
		return "handgun2";
	}
	
	@PostMapping("/products/firearms/handguns/handgun2")
	public String pageHandgun2Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(1);
		model.addAttribute("handgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "handgun2";
	}
	
	@GetMapping("/products/firearms/handguns/handgun3")
	public String pageHandgun3(Model model) {
		model.addAttribute("handgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(2));
		return "handgun3";
	}
	
	@PostMapping("/products/firearms/handguns/handgun3")
	public String pageHandgun3Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(2);
		model.addAttribute("handgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "handgun3";
	}
	
	@GetMapping("/products/firearms/handguns/handgun4")
	public String pageHandgun4(Model model) {
		model.addAttribute("handgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(3));
		return "handgun4";
	}
	
	@PostMapping("/products/firearms/handguns/handgun4")
	public String pageHandgun4Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(3);
		model.addAttribute("handgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "handgun4";
	}
	
	@GetMapping("/products/firearms/handguns/handgun5")
	public String pageHandgun5(Model model) {
		model.addAttribute("handgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(4));
		return "handgun5";
	}
	
	@PostMapping("/products/firearms/handguns/handgun5")
	public String pageHandgun5Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(0).getSubProducts().get(4);
		model.addAttribute("handgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "handgun5";
	}
	
	// -----------------------------------------------------SHOTGUN PRODUCTS
	
	@GetMapping("/products/firearms/shotguns/shotgun1")
	public String pageShotgun1(Model model) {
		model.addAttribute("shotgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(0));
		return "shotgun1";
	}
	
	@PostMapping("/products/firearms/shotguns/shotgun1")
	public String pageShotgun1Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(0);
		model.addAttribute("shotgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "shotgun1";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun2")
	public String pageShotgun2(Model model) {
		model.addAttribute("shotgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(1));
		return "shotgun2";
	}
	
	@PostMapping("/products/firearms/shotguns/shotgun2")
	public String pageShotgun2Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(1);
		model.addAttribute("shotgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "shotgun2";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun3")
	public String pageShotgun3(Model model) {
		model.addAttribute("shotgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(2));
		return "shotgun3";
	}
	
	@PostMapping("/products/firearms/shotguns/shotgun3")
	public String pageShotgun3Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(2);
		model.addAttribute("shotgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "shotgun3";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun4")
	public String pageShotgun4(Model model) {
		model.addAttribute("shotgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(3));
		return "shotgun4";
	}
	
	@PostMapping("/products/firearms/shotguns/shotgun4")
	public String pageShotgun4Update(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(3);
		model.addAttribute("shotgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "shotgun4";
	}
	
	@GetMapping("/products/firearms/shotguns/shotgun5")
	public String pageShotgun5(Model model) {
		model.addAttribute("shotgun", storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(4));
		return "shotgun5";
	}
	
	@PostMapping("/products/firearms/shotguns/shotgun5")
	public String pageShotgun5pdate(@RequestParam(value = "amount") int amount, Model model) {
		Product product = storeSharpen.getFirearmsWeapons().getSubcategories().get(1).getSubProducts().get(4);
		model.addAttribute("shotgun", product);
		for (int i=0;i<amount;i++) {
			storeManager.basket.getBasket().add(product);
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
		}
		return "shotgun5";
	}
}
