package sharpenServices;

public class Payment {
	
	private String nazwa;
	private int cena;
	private int paymentID;
	
	public Payment(String nazwa, int cena, int paymentID) {
		this.nazwa = nazwa;
		this.cena = cena;
		this.paymentID = paymentID;
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

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	
}
