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
import sharpenDataBase.getUser;
import sharpenDataBase.newConnection;
import sharpenProducts.storeManager;
import sharpenShopping.shoppingDelivery;

@Controller
public class shopController {
	
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
		if (storeManager.getBasket().getSuma() != 0) {
			model.addAttribute("basket", storeManager.getBasket().getBasket());
			storeManager.basket.getBasket().remove(Integer.parseInt(index));
				if (storeManager.getBasket().getSuma() == 0)
					return "basketEmpty";
			model.addAttribute("cena", storeManager.getBasket().getSuma());
			System.out.println(storeManager.basket.getBasket().size());
			System.out.println(storeManager.basket.getSuma());
			return "basket";
		} 
		else
			return "basketEmpty";
	}
	
	@GetMapping("/basket/login")
	public ModelAndView pageBasketLogin(Model model) {
		if (storeManager.loginStatus == true) {
			
			return new ModelAndView("redirect:/basket/order");
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
				storeManager.loginEmail = login;
				storeManager.loginStatus = true;
				return new ModelAndView("redirect:/basket/order");
			}
			else
				return new ModelAndView("basketLoginPasswordError");
		}
		else
			return new ModelAndView("basketLoginEmailError");
	}
	
	@PostMapping("/basket/order")
	public ModelAndView redirectedToOrder(@RequestParam(value = "get", required=false) String deliveryID, @RequestParam(value = "pay", required=false) String paymentID, Model model) {
		model.addAttribute("delivery", storeManager.delipay.getDeliveries());
		model.addAttribute("payment", storeManager.delipay.getPayments());
		
		if (deliveryID != null && paymentID != null) {
		System.out.println(deliveryID);
		System.out.println(paymentID);
		storeManager.delivery = new shoppingDelivery(Integer.parseInt(deliveryID),Integer.parseInt(paymentID));
		return new ModelAndView("redirect:/basket/summary");
		}
		
		return new ModelAndView("basketOrder");
	}
	
	
	@GetMapping("/basket/order")
	public String pageOrder(Model model) {
		model.addAttribute("delivery", storeManager.delipay.getDeliveries());
		model.addAttribute("payment", storeManager.delipay.getPayments());
		return "basketOrder";
	}
	
	@GetMapping("/basket/summary")
	public String pageSummary(Model model) {
		if (storeManager.getBasket().getSuma() != 0) {
			if (storeManager.loginStatus == true) {
			
			model.addAttribute("basket", storeManager.basket.getBasket());
			
			newConnection sharpenDB = new newConnection("jdbc:postgresql://localhost/SHARPEN", "postgres", "postgres");
			getUser getUser = new getUser(sharpenDB, storeManager.loginEmail);
			model.addAttribute("name", getUser.getUserName());
			model.addAttribute("surname", getUser.getUserSurname());
			model.addAttribute("email", getUser.getUserMail());
			model.addAttribute("street", getUser.getUserStreet());
			model.addAttribute("postalcode", getUser.getUserPostalCode());
			model.addAttribute("city", getUser.getUserCity());
			model.addAttribute("phone", getUser.getUserPhone());
			
			int deliveryID = storeManager.delivery.getDeliveryID();
			int paymentID = storeManager.delivery.getPaymentID();
			System.out.println(deliveryID);
			model.addAttribute("delivery", storeManager.delivery.getShoppingDelivery(deliveryID));
			model.addAttribute("payment", storeManager.delivery.getShoppingPayment(paymentID));
			
			int totalPrice = storeManager.getBasket().getSuma() + storeManager.delivery.getShoppingDelivery(deliveryID).getCena() + storeManager.delivery.getShoppingPayment(paymentID).getCena();
			model.addAttribute("totalprice", totalPrice);
		
			return "basketSummary";
			}
			else	
			return "redirect:/basket/login";
		}
		return "basketEmpty";
	}
}
