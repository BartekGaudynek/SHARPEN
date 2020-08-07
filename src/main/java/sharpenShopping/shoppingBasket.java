package sharpenShopping;

import java.util.ArrayList;
import sharpenProducts.Product; 

public class shoppingBasket {
	
	private ArrayList<Product> basket;
	private int suma;
	private int productIndex;
	
	public shoppingBasket() {
		basket = new ArrayList<Product>();
	}

	public ArrayList<Product> getBasket() {
		return basket;
	}

	public void setBasket(ArrayList<Product> basket) {
		this.basket = basket;
	}
	
	public int getSuma() {
		for (int i=0; i<basket.size();i++) {
			suma = suma	+ basket.get(i).getCena();		
		}
		return suma;
	}
	
	public void basketCleanout() {
		for (int i=0; i<basket.size();i++) {
			basket.remove(i);	
		}
	}
	
	public void removeProduct(int productIndex) {
		basket.remove(productIndex);
	}
	
}
