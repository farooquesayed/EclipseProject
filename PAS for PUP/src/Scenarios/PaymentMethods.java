package Scenarios;

import kwi.zakir.Common.CommonLibrary;
import kwi.zakir.Common.PUPCommon;

public class PaymentMethods extends CommonLibrary{

	private PUPCommon cmmPUP = new PUPCommon();
	
	public void paymentSelectByIndex() {
		Long p = (Long) cmmPUP.getJSONvalue("paymentTypeId");
		Payment_Method(p.intValue());
	}
	
	public void Payment_Method(int p) {
		System.out.println("Entering Payment Method");
		
		switch (p) {
		case 1:
			CreditCard();
			break;
		case 2:
			DebitCard();
			break;
		case 3:
			PersonalEcheck();
			break;
		case 4:
			paperCheck();
			break;
		default:
			System.out.println("Invalid payment type selected: " + p);
		}

		DoClicki("ContinueLink");
	}
	
	public void CreditCard() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", cmmPUP.getJSONvalue("paymentTypeId"));
		DoSelecti("CardTypeId", cmmPUP.getJSONvalue("cardTypeId"));
		DoKeyi("CardNumber", cmmPUP.getJSONvalue("CardNumber"));
		DoKeyi("SecurityCode", cmmPUP.getJSONvalue("SecurityCode"));
		DoSelecti("Month", cmmPUP.getJSONvalue("Month"));
		DoSelecti("Year", cmmPUP.getJSONvalue("Year"));
	}
	
	public void DebitCard() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", cmmPUP.getJSONvalue("paymentTypeId"));
		DoSelecti("CardTypeId", cmmPUP.getJSONvalue("cardTypeId"));
		DoKeyi("CardNumber", cmmPUP.getJSONvalue("CardNumber"));
		DoSelecti("Month", cmmPUP.getJSONvalue("Month"));
		DoSelecti("Year", cmmPUP.getJSONvalue("Year"));
	}

	public void PersonalEcheck() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", cmmPUP.getJSONvalue("paymentTypeId"));
		DoSelecti("CheckNumber", cmmPUP.getJSONvalue("CheckNumber"));
		DoKeyi("ABANumber", cmmPUP.getJSONvalue("ABANumber"));
		DoSelecti("AccountNumber", cmmPUP.getJSONvalue("AccountNumber"));
	}
	
	public void paperCheck() {
		System.out.println("Entering Payment Method");
		DoSelecti("PaymentTypeId", cmmPUP.getJSONvalue("paymentTypeId"));
		addDelay(3000);
		WaitProperty_Click("PaymentMsgNo");
		DoKeyi("CheckNumber", cmmPUP.getJSONvalue("CheckNumber"));
	}
			
}
