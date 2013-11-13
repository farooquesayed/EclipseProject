package kwi.zakir.PUP;

public class PaymentMethods extends NewQuote{

	public void CreditCard() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", getJSONvalue("paymentTypeId"));
		DoSelecti("CardTypeId", getJSONvalue("cardTypeId"));
		DoKeyi("CardNumber", getJSONvalue("CardNumber"));
		DoKeyi("SecurityCode", getJSONvalue("SecurityCode"));
		DoSelecti("Month", getJSONvalue("Month"));
		DoSelecti("Year", getJSONvalue("Year"));
	}
	
	public void DebitCard() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", getJSONvalue("paymentTypeId"));
		DoSelecti("CardTypeId", getJSONvalue("cardTypeId"));
		DoKeyi("CardNumber", getJSONvalue("CardNumber"));
		DoSelecti("Month", getJSONvalue("Month"));
		DoSelecti("Year", getJSONvalue("Year"));
	}

	public void PersonalEcheck() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", getJSONvalue("paymentTypeId"));
		DoSelecti("CheckNumber", getJSONvalue("CheckNumber"));
		DoKeyi("ABANumber", getJSONvalue("ABANumber"));
		DoSelecti("AccountNumber", getJSONvalue("AccountNumber"));
	}
	
	public void paperCheck() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", getJSONvalue("paymentTypeId"));
		addDelay(3000);
		WaitProperty_Click("PaymentMsgNo");
		DoKeyi("CheckNumber", getJSONvalue("CheckNumber"));
	}
			
}
