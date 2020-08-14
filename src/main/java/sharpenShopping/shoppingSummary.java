package sharpenShopping;

import sharpenProducts.Product;
import sharpenProducts.storeManager;

public class shoppingSummary {
	
	private String clientData;
	private shoppingClient client;
	
	public shoppingSummary () {
		
	}
	
	public shoppingSummary (String clientData) {
		this.clientData = clientData;
		client = new shoppingClient(clientData);
	}

	public shoppingBasket getBasket() {
		return storeManager.getBasket();
	}
	
	public void getBasketProducts() {
		for (int i=0;i<storeManager.getBasket().getBasket().size();i++) {
				Product product = storeManager.getBasket().getBasket().get(i);
				System.out.println("produkt: "+ product.getNazwa() + ", cena: " + product.getCena());
		}
	}
	
	public void getClientData() {
		if (clientData != null)
			System.out.println(client.getRegisteredClientData());
	}
	
	public void getDeliveryDetails() {
		
	}
	
}
