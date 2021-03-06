package kwi.zakir.Common;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonLibrary {
	public static WebDriver commDRIVER;

	public static String Extract_Amount(String testStr) {
		Pattern p = Pattern.compile("-?[0-9]+,\\d+");
		Matcher m = p.matcher(testStr);
		while (m.find()) {
			return m.group();
		}
		return null;
	}

	public void DoClickn(String objID) {
		commDRIVER.findElement(By.name(objID)).click();
	}

	public void DoClicki(String objID) {
		commDRIVER.findElement(By.id(objID)).click();
	}

	public void DoSelectn(String objID, int i) {
		new Select(commDRIVER.findElement(By.name(objID))).selectByIndex(i);
	}

	public void DoSelecti(String objID, int i) {
		new Select(commDRIVER.findElement(By.id(objID))).selectByIndex(i);
	}

	public void DoKeyn(String objID, String val) {
		commDRIVER.findElement(By.name(objID)).sendKeys(val);
	}

	public void DoKeyi(String objID, String val) {
		commDRIVER.findElement(By.id(objID)).sendKeys(val);
	}

	public static void init_Driver(WebDriver DRIVER) {
		commDRIVER = DRIVER;
	}

	public static void xKillIEs(String processName) {
		final String KILL = "taskkill /IM ";
		try {
			Runtime.getRuntime().exec(KILL + processName + " /F");
		} catch (IOException e) {

			e.printStackTrace();
		}
		addDelay(3000);
	}

	public static void addDelay(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void TearDown(String browserDriver) {

		switch (browserDriver) {
		case "IE": {
			xKillIEs("IEDriverServer.exe");
			break;
		}
		case "CR": {
			//xKillIEs("chromedriver.exe");
			break;
		}
		default:
			break;
		}
	}
}
