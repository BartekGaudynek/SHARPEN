package sharpenServices;

import java.util.ArrayList;

public class DeliPay {

	private ArrayList<Payment> payments;
	private ArrayList<Delivery> deliveries;
	
	public DeliPay() {
//		----------------PAYMENT LIST CREATION----------------
		payments = new ArrayList<Payment>();
		payments.add(new Payment("Przelew tradycyjny",0,0));
		payments.add(new Payment("Płatność internetowa PayU",5,1));
		payments.add(new Payment("Płatność BLIK",0,2));
		
//		----------------DELIVERY LIST CREATION----------------
		deliveries = new ArrayList<Delivery>();
		deliveries.add(new Delivery("Kurier DHL",10,0));
		deliveries.add(new Delivery("Kurier InPost",10,1));
		deliveries.add(new Delivery("Odbiór osobisty",0,2));
		
	}
	
	public ArrayList<Payment> getPayments(){
		return payments;
	}
	
	public ArrayList<Delivery> getDeliveries(){
		return deliveries;
	}
}
