package sharpenProducts;

public class storeMain {

	public static void main(String[] args) {
		storeManager storeSharpen = new storeManager();
		System.out.println(storeManager.basket.getBasket().size());
		for (int i=0;i<storeManager.basket.getBasket().size();i++) {
		Product product = storeManager.basket.getBasket().get(i);
		System.out.println(i);
		System.out.println(product.getNazwa()+","+product.getCena());
		}
	}

}
