package easybooking.client.data.classes;

public interface IMasterCard {
	public int payMasterCard(int cardNumber,String UserName, String UserSurname ,int expirationMonth, int expirationYear, int criptogram);
}
