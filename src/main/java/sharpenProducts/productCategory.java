package sharpenProducts;

import java.util.ArrayList;

public class productCategory {
	
	private ArrayList<productSubcategory> subcategories;
	private String nazwa;
	
	public productCategory(String nazwa) {
		this.nazwa = nazwa;
		this.subcategories = new ArrayList<productSubcategory>();	
	}

	public ArrayList<productSubcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(ArrayList<productSubcategory> subcategories) {
		this.subcategories = subcategories;
	}

}
