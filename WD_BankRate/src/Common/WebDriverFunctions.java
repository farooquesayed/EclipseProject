package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverFunctions {

	public boolean isVisibleOnScreen(WebDriver myDriver, By objBy) {
		 return myDriver.findElements(objBy).size() != 0 ? false : true;
	}
	
	public void wdClick(WebDriver myDriver, By objBy) {
		
		if(isVisibleOnScreen(myDriver, objBy)) {
			myDriver.findElement(objBy).click();
			System.out.println("Click action performed: " + objBy.toString());
		}
		else
			System.out.println("Object not found. Unable to perform click operation: " 
								+ objBy.toString());
			
	}
	
	
	public void wdKeys(WebDriver myDriver, By objBy) {
		myDriver.findElement(objBy).click();
		System.out.println("Keyboard input action performed: " + objBy.toString());
	}
	
	public void mouseOver(WebDriver myDriver, By objBy) {
		Actions action = new Actions(myDriver);
		WebElement we = myDriver.findElement(objBy);
		action.moveToElement(we).build().perform();
	}

	public void mouseOver(WebDriver myDriver, By Hover_objBy, By Click_objBy) {
		Actions action = new Actions(myDriver);
		WebElement we = myDriver.findElement(Hover_objBy);
		action.moveToElement(we).moveToElement(myDriver.findElement(Click_objBy)).click().build().perform();
	}
	
	
	public void closePopUpWindows(WebDriver myDriver) {
		String originalHandle = myDriver.getWindowHandle();

	    for(String handle : myDriver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	        	myDriver.switchTo().window(handle);
	        	myDriver.close();
	        }
	    }
	    myDriver.switchTo().window(originalHandle);
	}
}
