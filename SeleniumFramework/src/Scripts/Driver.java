package Scripts;

import FunctionalLib.ExcelRead;

public class Driver {
	public static void main(String args[]) throws InterruptedException{
		ExcelRead oExcel = new ExcelRead("C:\\Users\\Naresh\\Downloads\\AHLMFramework3.0\\B3SeleniumFramework\\src\\TestData\\BankRateTestData.xls","TestSuite");
		BankRate oBank = new BankRate();
		
		int NOfScenarios = oExcel.rowCount();
		int ActionCnt;
		for(int i=1; i<NOfScenarios; i++)
		{
			String sTestScenario =oExcel.getCellData("TestScenario", i);
			String sExecutionFlag = oExcel.getCellData("ExecutionFlag", i);
			if(sExecutionFlag.equals("YES"))
			{
				ActionCnt=1;
				while(oExcel.getCellData("Action" + ActionCnt, i)!="")
				{
					String sAction = oExcel.getCellData("Action" + ActionCnt, i);
					if(sAction.equals("OpenBrowser"))
						oBank.OpenBrowser();
					else if(sAction.equals("closeBrowser"))
						oBank.closeBrowser();
					else if(sAction.equals("LoanAmortizationCalculator"))
						oBank.LoanAmortizationCalculator();
					else if(sAction.equals("insuranceQuotes"))
						oBank.insuranceQuotes();
					else if(sAction.equals("autoInsuranceQuotes"))
						oBank.autoInsuranceQuotes();
					ActionCnt = ActionCnt+1;				
				}
			}
			else
				System.out.println("Scenario: " + sTestScenario + " is not set to TRUE, so not executing");			
		}
	}

}
