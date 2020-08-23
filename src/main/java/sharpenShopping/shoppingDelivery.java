package sharpenShopping;

import sharpenProducts.storeManager;
import sharpenServices.Delivery;
import sharpenServices.Payment;

public class shoppingDelivery {

	private int deliveryID;
	private int paymentID;
	private storeManager manager;
	
	public shoppingDelivery(int deliveryID, int paymentID) {
		this.deliveryID = deliveryID;
		this.paymentID = paymentID;
	}
	
	public Delivery getShoppingDelivery(int deliveryID) {
		return manager.delipay.getDeliveries().get(deliveryID);	
	}
	
	public Payment getShoppingPayment(int paymentID) {
		return manager.delipay.getPayments().get(paymentID);
	}

	public int getDeliveryID() {
		return deliveryID;
	}

	public int getPaymentID() {
		return paymentID;
	}
	
}
