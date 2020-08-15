package sharpenProducts;

public class Product {

	private String nazwa;
	private int cena;
	private String iconPath;
	private productSubcategory subcategory;
	private int index;
	
	public Product(String nazwa, int cena, String iconPath, productSubcategory subcategory, int index) {
		this.nazwa = nazwa;
		this.cena = cena;
		this.iconPath = iconPath;
		this.subcategory = subcategory;
		this.index = index;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void addProductToSubcategory() {
		subcategory.getSubProducts().add(this);
	}
	
}
