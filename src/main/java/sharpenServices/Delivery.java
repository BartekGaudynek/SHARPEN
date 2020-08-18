package sharpenServices;

public class Delivery {

	private String nazwa;
	private int cena;
	private int deliveryID;
	
	public Delivery(String nazwa, int cena, int deliveryID) {
		this.nazwa = nazwa;
		this.cena = cena;
		this.deliveryID = deliveryID;
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

	public int getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(int deliveryID) {
		this.deliveryID = deliveryID;
	}
	
}
