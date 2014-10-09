/**
 * 
 */
package com.wiu.findstuff.dto;


/**
 * @author kavitha
 *
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentInfo {
	private int CustomerId;
	private int PaymentId;
	private String CreditCardNum;
	private String NameOnCard;
	private String CVV;
	private String ExpiryDate;
	private String CardType;
	
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(int paymentId) {
		PaymentId = paymentId;
	}
	public String getCreditCardNum() {
		return CreditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		CreditCardNum = creditCardNum;
	}
	public String getNameOnCard() {
		return NameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		NameOnCard = nameOnCard;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	
	
}
