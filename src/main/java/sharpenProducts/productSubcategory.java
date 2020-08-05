package sharpenProducts;

import java.util.ArrayList;

public class productSubcategory {

	private ArrayList<Product> subProducts;
	private String nazwa;
	private productCategory category;
	
	public productSubcategory(String nazwa, productCategory category) {
		this.nazwa = nazwa;
		this.category = category;
		this.subProducts = new ArrayList<Product>();
	}

	public ArrayList<Product> getSubProducts() {
		return subProducts;
	}

	public void setSubProducts(ArrayList<Product> subProducts) {
		this.subProducts = subProducts;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public productCategory getCategory() {
		return category;
	}

	public void setCategory(productCategory category) {
		this.category = category;
	}
	
	public void addSubcategoryToCategory() {
		category.getSubcategories().add(this);
	}
	
}
