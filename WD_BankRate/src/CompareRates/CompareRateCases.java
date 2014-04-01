package CompareRates;

import java.sql.DriverManager;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.WebDriverFunctions;

public class CompareRateCases extends WebDriverFunctions {
	private static WebDriver myDriver;
	
	public CompareRateCases() {
		myDriver = Main.DRIVER;
	}

	
	public void getMortgageRates() {
		System.out.println("In method: getMortgageRates()");
		String xpath_mortgage = "//*[@id=\"OAmultiModule\"]/div[2]/table[1]/tbody/tr/td[1]";
		wdClick(myDriver, By.xpath(xpath_mortgage));
		String xpath_link1 = "//*[@id=\"OAmultiModule\"]/div[2]/table[2]/tbody/tr[1]/a";
		System.out.println("Link1 value: " + myDriver.findElement(By.xpath(xpath_link1)).getText());
		String xpath_link2 = "//*[@id=\"OAmultiModule\"]/div[2]/table[2]/tbody/tr[1]";
		mouseOver(myDriver, By.xpath(xpath_mortgage), By.xpath(xpath_link2));
	}
	
}
