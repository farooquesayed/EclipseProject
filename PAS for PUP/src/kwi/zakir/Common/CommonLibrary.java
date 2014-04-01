

package kwi.zakir.Common;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLibrary {
	public static WebDriver commDRIVER;


	public void WaitProperty_Click(String ID) {
		WebDriverWait wait = new WebDriverWait(commDRIVER, 60000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ID)));
		DoClicki(ID);
	}
	
	public String CustomDate(int dateValue, boolean isFormatted) {
		Date tDate = new Date();
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(tDate);
		cal.add(Calendar.DAY_OF_MONTH, dateValue);
		Date cDate = cal.getTime();
		
		SimpleDateFormat fDate;
		if(isFormatted) fDate = new SimpleDateFormat("MM/dd/yyyy");
		else fDate = new SimpleDateFormat("MMddyyyy");
		System.out.println(fDate.format(cDate)); 
		
		return fDate.format(cDate);
	}
	
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
		System.out.println("Clicking at: " + objID);
		commDRIVER.findElement(By.id(objID)).click();
	}

	public void DoSelectn(String objID, int i) {
		new Select(commDRIVER.findElement(By.name(objID))).selectByIndex(i);
	}

	public void DoSelecti(String objID, Object obj) {
//		if(obj.toString().isEmpty() == false && obj instanceof Integer) 
//			new Select(commDRIVER.findElement(By.id(objID))).selectByIndex((int) obj);
//		else if(obj.toString().isEmpty() == false && obj instanceof String) 
//			new Select(commDRIVER.findElement(By.id(objID))).selectByValue((String) obj);
		if(obj.toString().isEmpty() == false) 
			new Select(commDRIVER.findElement(By.id(objID))).selectByIndex(Integer.parseInt(obj.toString()));
	}

	public void DoKeyn(String objID, String val) {
		commDRIVER.findElement(By.name(objID)).sendKeys(val);
	}

	public void DoKeyi(String objID, Object val) {
		commDRIVER.findElement(By.id(objID)).clear();
		commDRIVER.findElement(By.id(objID)).sendKeys(val.toString());
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
			xKillIEs("chromedriver.exe");
			break;
		}
		default:
			break;
		}
	}
	
	public static void SendEmail(String to, String Subject, String Body) {
	      //String to = "zakirhere@gmail.com";
	      String from = "zakirsayed@cnico.com";
	      String host = "kwnhmail";

	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);
	      try{
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         message.setSubject(Subject);

	         message.setText(Body);

	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }

	}
	

}
