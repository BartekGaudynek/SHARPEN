package sharpenProducts;

import sharpenDataBase.newConnection;
import sharpenShopping.shoppingBasket;

public class storeManager {
	
	private productCategory meleeWeapons;
	private productCategory firearmsWeapons;
	public static shoppingBasket basket;
//	private static newConnection connection;
	
	public storeManager() {
		
//		-----------------------------------------SHOPPING BASKET
		
		basket = new shoppingBasket();
		
//		-----------------------------------------PRODUCT CATEGORIES
		meleeWeapons = new productCategory("Melee");
		firearmsWeapons = new productCategory("Melee");
		
		
//		-----------------------------------------PRODUCT SUBCATEGORIES
		productSubcategory bluntWeapons = new productSubcategory("Blunt weapons", meleeWeapons);
		bluntWeapons.addSubcategoryToCategory();
		productSubcategory knifeWeapons = new productSubcategory("Knife weapons", meleeWeapons);
		knifeWeapons.addSubcategoryToCategory();
		
		productSubcategory handgunWeapons = new productSubcategory("Blunt weapons", firearmsWeapons);
		handgunWeapons.addSubcategoryToCategory();
		productSubcategory shotgunWeapons = new productSubcategory("Blunt weapons", firearmsWeapons);
		shotgunWeapons.addSubcategoryToCategory();
		
//		-----------------------------------------BLUNT WEAPON PRODUCTS
		Product blunt1 = new Product("Cukierkowa pałka z kolcami", 100, null, bluntWeapons,0);
		Product blunt2 = new Product("Pałka2", 200, null, bluntWeapons,1);
		Product blunt3 = new Product("Pałka3", 300, null, bluntWeapons,2);
		Product blunt4 = new Product("Pałka4", 400, null, bluntWeapons,3);
		Product blunt5 = new Product("Pałka5", 500, null, bluntWeapons,4);
		blunt1.addProductToSubcategory();
		blunt2.addProductToSubcategory();
		blunt3.addProductToSubcategory();
		blunt4.addProductToSubcategory();
		blunt5.addProductToSubcategory();
		
//		-----------------------------------------KNIFE WEAPON PRODUCTS
		Product knife1 = new Product("Nóż1", 100, null, knifeWeapons,0);
		Product knife2 = new Product("Nóż2", 200, null, knifeWeapons,1);
		Product knife3 = new Product("Nóż3", 300, null, knifeWeapons,2);
		Product knife4 = new Product("Nóż4", 400, null, knifeWeapons,3);
		Product knife5 = new Product("Nóż5", 500, null, knifeWeapons,4);
		knife1.addProductToSubcategory();
		knife2.addProductToSubcategory();
		knife3.addProductToSubcategory();
		knife4.addProductToSubcategory();
		knife5.addProductToSubcategory();
		
//		-----------------------------------------HANDGUN WEAPON PRODUCTS
		Product handgun1 = new Product("Pistolet1", 100, null, handgunWeapons,0);
		Product handgun2 = new Product("Pistolet2", 200, null, handgunWeapons,1);
		Product handgun3 = new Product("Pistolet3", 300, null, handgunWeapons,2);
		Product handgun4 = new Product("Pistolet4", 400, null, handgunWeapons,3);
		Product handgun5 = new Product("Pistolet5", 500, null, handgunWeapons,4);
		handgun1.addProductToSubcategory();
		handgun2.addProductToSubcategory();
		handgun3.addProductToSubcategory();
		handgun4.addProductToSubcategory();
		handgun5.addProductToSubcategory();
		
//		-----------------------------------------SHOTGUN WEAPON PRODUCTS
		Product shotgun1 = new Product("Strzelba Stoeger M3000 Shotgun", 1000, null, shotgunWeapons,0);
		Product shotgun2 = new Product("Strzelba2", 200, null, shotgunWeapons,1);
		Product shotgun3 = new Product("Strzelba3", 300, null, shotgunWeapons,2);
		Product shotgun4 = new Product("Strzelba4", 400, null, shotgunWeapons,3);
		Product shotgun5 = new Product("Strzelba5", 500, null, shotgunWeapons,4);
		shotgun1.addProductToSubcategory();
		shotgun2.addProductToSubcategory();
		shotgun3.addProductToSubcategory();
		shotgun4.addProductToSubcategory();
		shotgun5.addProductToSubcategory();

//		-----------------------------------------OPERATIONS
		
//		basket.getBasket().add(blunt1);
//		basket.getBasket().add(knife3);
//		basket.getBasket().add(shotgun1);
//		System.out.println(basket.getSuma());
		
//		basket.removeProduct(1);
//		System.out.println(basket.getSuma());
		
		
		
//		System.out.println(blunt1.getNazwa());
//		System.out.println(bluntWeapons.getSubProducts().get(0).getNazwa());
//		System.out.println(meleeWeapons.getSubcategories().get(0).getSubProducts().get(0).getNazwa());		
	}
	
	public productCategory getMeleeWeapons () {
		return meleeWeapons;
	}
	
	public productCategory getFirearmsWeapons () {
		return firearmsWeapons;		
	}
	
	public static shoppingBasket getBasket () {
		return basket;		
	}

//	public static newConnection getConnection() {
//		return connection;
//	}
	
}