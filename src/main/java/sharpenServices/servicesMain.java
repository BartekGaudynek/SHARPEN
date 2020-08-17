package sharpenServices;

public class servicesMain {
	public static void main(String[] args) {
		DeliPay delipay = new DeliPay();
		{
			String paymentName = delipay.getPayments().get(1).getNazwa();
			int paymentID = delipay.getPayments().get(1).getPaymentID();
			int paymentPrice = delipay.getPayments().get(1).getCena();
			
			System.out.println("Dostawa: " + paymentName + ", cena: " + paymentID + ", ID: " + paymentPrice);
			
			String deliveryName = delipay.getDeliveries().get(2).getNazwa();
			int deliveryID = delipay.getDeliveries().get(2).getDeliveryID();
			int deliveryPrice = delipay.getDeliveries().get(2).getCena();
		
			System.out.println("Dostawa: " + deliveryName + ", cena: " + deliveryPrice + ", ID: " + deliveryID);
		}
	}
}
