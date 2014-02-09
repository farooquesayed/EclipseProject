package CommonLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunctions {

	public static String Extract_Amount(String testStr) {
		Pattern p = Pattern.compile("-?[0-9]+,\\d+");
		Matcher m = p.matcher(testStr);
		while (m.find()) {
			return m.group();
		}
		return null;
	}
	
	public static void addDelay(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static String CustomDate(int dateValue, boolean isFormatted) {
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
}
