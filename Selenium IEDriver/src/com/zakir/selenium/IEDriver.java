package com.zakir.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class IEDriver {
  private InternetExplorerDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.ie.driver", "C:\\Zakir\\Selenium\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();
    baseUrl = "http://www.cnico.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWebDriver1() throws Exception {
	  navigateToOnlineBillPay();
	  logInToPolicy();
  }
  
  public void navigateToOnlineBillPay () {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("PayOnlineButton")).click();
  }

  public void logInToPolicy() throws Exception {
    driver.findElement(By.id("tPolicyNumber")).clear();
    driver.findElement(By.id("tPolicyNumber")).sendKeys("FC18119520");
    driver.findElement(By.id("tZipCode")).clear();
    driver.findElement(By.id("tZipCode")).sendKeys("94062");
    
    chkpt_PolicyInfo();
    
    driver.findElement(By.id("bContinue")).click();
    driver.findElement(By.id("totalAmountDueRadio")).click();
    new Select(driver.findElement(By.id("paymentMethod"))).selectByVisibleText("Credit Card");
  }
  
  public void chkpt_PolicyInfo() {
	  
	  String innerText;
	  innerText = driver.findElement(By.id("tPolicyNumber")).getAttribute("value");
	  assertEquals("Checkpoint for Policy Number", "FC18119520", innerText);
	  innerText = driver.findElement(By.id("tZipCode")).getAttribute("value");
	  assertEquals("Checkpoint for Zip Code", "94062", innerText);
  }
  
  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}
