package Scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UIObjectInfo.UIObjectInfo;

import FunctionalLib.ExcelRead;

public class BankRate {
	
	UIObjectInfo uiObj = new UIObjectInfo();
	
	public WebDriver oBrowser;
	
	public void OpenBrowser() throws InterruptedException{
		String sBrowserType=null;
		String sURL=null;
		
		ExcelRead oExcel = new ExcelRead("C:\\Users\\Naresh\\Downloads\\AHLMFramework3.0\\B3SeleniumFramework\\src\\TestData\\BankRateTestData.xls","OpenApplication");
		sBrowserType = oExcel.getCellData("BrowserType",1);
		sURL = oExcel.getCellData("URL",1);
		
		if(sBrowserType.equals("FireFox"))
			oBrowser = new FirefoxDriver();
		else if(sBrowserType.equals("IExplore"))
			oBrowser = new InternetExplorerDriver();
		else if(sBrowserType.equals("Chrome"))
			oBrowser = new ChromeDriver();
		
		oBrowser.get(sURL);
		
	}
	
	public void closeBrowser(){
		oBrowser.quit();
	}

	public void LoanAmortizationCalculator() throws InterruptedException{
		ExcelRead oExcel = new ExcelRead("C:\\Users\\Naresh\\Downloads\\AHLMFramework3.0\\B3SeleniumFramework\\src\\TestData\\BankRateTestData.xls","LoanAmortizationCalculator");
				
		oBrowser.findElement(By.linkText(uiObj.BR_LoanAmortCalc)).click();
		//Loan Amount
		oBrowser.findElement(By.id(uiObj.BR_LAAC_LoanAmnt)).clear();
		oBrowser.findElement(By.id(uiObj.BR_LAAC_LoanAmnt)).sendKeys(oExcel.getCellData("LoanAmount", 1));
		//Loan term - years
		oBrowser.findElement(By.id("ctl00_well_DefaultUC_nrOfYears")).clear();
		oBrowser.findElement(By.id("ctl00_well_DefaultUC_nrOfYears")).sendKeys(oExcel.getCellData("LoanYears", 1));
		//Loan term - Months
		oBrowser.findElement(By.id("ctl00_well_DefaultUC_nrOfMonths")).clear();
		oBrowser.findElement(By.id("ctl00_well_DefaultUC_nrOfMonths")).sendKeys(oExcel.getCellData("LoanMonths", 1));
		//IRare
		oBrowser.findElement(By.id("ctl00_well_DefaultUC_interestRate")).clear();
		oBrowser.findElement(By.id("ctl00_well_DefaultUC_interestRate")).sendKeys(oExcel.getCellData("RateofInterest", 1));
		//Selecting Date
		Select oMonth = new Select(oBrowser.findElement(By.id("ctl00_well_DefaultUC_LoanMonth")));
		oMonth.selectByVisibleText(oExcel.getCellData("LoanStMon", 1));
		Select oDate = new Select(oBrowser.findElement(By.id("ctl00_well_DefaultUC_LoanDate")));
		oDate.selectByVisibleText(oExcel.getCellData("LoanStDate", 1));
		Select oYear = new Select(oBrowser.findElement(By.id("ctl00_well_DefaultUC_LoanYear")));
		oYear.selectByVisibleText(oExcel.getCellData("LoanStYear", 1));
					
		//Calculate Button
		oBrowser.findElement(By.id("ctl00_well_DefaultUC_Calculate_1")).click();
		Thread.sleep(5000);
		//Monthly Payments
		String sEMI = oBrowser.findElement(By.id("ctl00_well_DefaultUC_monthlyPayment")).getAttribute("value").toString();
		System.out.println("EMI is: " + sEMI);
	}
	
	public void insuranceQuotes(){
		ExcelRead oExcel = new ExcelRead("C:\\Users\\Naresh\\Downloads\\AHLMFramework3.0\\B3SeleniumFramework\\src\\TestData\\BankRateTestData.xls","InsuranceQuotes");
		
		oBrowser.findElement(By.linkText("Compare Insurance Quotes")).click();
		oBrowser.switchTo().window(null);
		
		//Selecting Insurance
		Select oSelectInsurance = new Select(oBrowser.findElement(By.id("ctl00_QuoteBox_ddlChooseInsType")));
		oSelectInsurance.selectByVisibleText(oExcel.getCellData("SelectInsuranceType", 1));
		//Entering ZIP code
		oBrowser.findElement(By.id("ctl00_QuoteBox_tbEnterZip")).sendKeys(oExcel.getCellData("ZIPCode", 1));
		//Currently Insured
		String sCurrentlyInsured=oExcel.getCellData("CurrentlyInsured", 1);
		if(sCurrentlyInsured.equals("YES"))
			oBrowser.findElement(By.id("ctl00_QuoteBox_rblLeadHasInsurance_0")).click();
		else
			oBrowser.findElement(By.id("ctl00_QuoteBox_rblLeadHasInsurance_1")).click();
		
		//Get Quotes button
		oBrowser.findElement(By.id("ctl00_QuoteBox_btnGetQuote")).click();
		
		if(oBrowser.findElement(By.id("ctl00_insuranceHeader")).isDisplayed())
			System.out.println("Insurance Quotes Page is displayed");
		else
			System.out.println("Insurance Quotes Page is not displayed");
		
	}

	public void autoInsuranceQuotes() throws InterruptedException{
		ExcelRead oExcel = new ExcelRead("C:\\Users\\Naresh\\Downloads\\AHLMFramework3.0\\B3SeleniumFramework\\src\\TestData\\BankRateTestData.xls","InsuranceQuotes");	
	
		Actions act = new Actions(oBrowser);		
		act.moveToElement(oBrowser.findElement(By.xpath("//a[@href='/auto.aspx']")));
		Thread.sleep(3000);
		//act.moveToElement(oBrowser.findElement(By.linkText("Insurance Quotes")));
		//act.click();
		act.build();
		act.perform();
		String sText;
		List <WebElement> oLinks = oBrowser.findElements(By.tagName("li"));
		sText = oBrowser.getPageSource();
		System.out.println(sText );
	/*	for(WebElement oLink:oLinks){
			sText = oLink.getText();
			System.out.println(sText );
		}*/
		
		//oBrowser.findElement(By.linkText("Auto")).click();
		//oBrowser.findElement(By.linkText("Insurance Quotes")).click();
		Thread.sleep(25000);
		oBrowser.findElement(By.xpath("//a[@href='/finance/auto-insurance-companies.aspx']")).click();
		
		oBrowser.findElement(By.id("zipcode")).sendKeys(oExcel.getCellData("ZIPCode",1));
		String sCurrentlyInsured=oExcel.getCellData("CurrentlyInsured", 1);
		if(sCurrentlyInsured.equals("YES"))
			oBrowser.findElement(By.id("currently_0")).click();
		else
			oBrowser.findElement(By.id("currently_1")).click();
		oBrowser.findElement(By.xpath("//input[@value='Find Rates']")).click();
		
		String sOldBrwTitle = oBrowser.getTitle();
		oBrowser.findElement(By.xpath("//td[3]/a")).click();
		oBrowser.switchTo().window(null);
		String sNewBrwTitle = oBrowser.getTitle();
		
		if(sNewBrwTitle.equals(sOldBrwTitle))
			System.out.println("FAIL");
		else
			System.out.println("PASS");
	}
}






































