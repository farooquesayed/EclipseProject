import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.base.Stopwatch;


public class DataDrivenTest extends Common{
	public WebDriver DRIVER; 
	public String baseUrl = "https://dev-pay.cnico.com";
	public Stopwatch stpWatch = new Stopwatch();
	private final static String filePath = "C:\\Zakir\\Eclipse Projects\\OnlineBillPay\\src\\OBP_Policies.xls";
	ArrayList<String> PolicyNumbers  = new ArrayList<String>();
	ArrayList<Object> ZipCodes = new ArrayList<Object>();
	
	//@Before
	public void setUp() {
		System.out.println("TEST STARTED FOR ONLINE BILL PAY.");
		stpWatch.start();		
	}

	
	//@Test
	public void runOnlineBillPay() {
		devLogin(DRIVER, baseUrl);
//		PolicySearch.allPolicySearch(DRIVER, this.PolicyNumbers.get(1), this.ZipCodes.get(1));
		PolicySearch.allPolicySearch(DRIVER, readXLSFile(1, 2).toString(), readXLSFile(1, 3).toString());
		PaymentInfo.AllPaymentInformation(DRIVER);
		ReviewAndPay.allReviewAndPay(DRIVER);
		Confirmation.allConfirmation(DRIVER);
	}

	//@After
	public void tearDown() {
	    DRIVER.quit();
		stpWatch.stop();
		System.out.println("Total test time = " + stpWatch.elapsed(TimeUnit.SECONDS) + " seconds");
	}

	
	public void readXLSFile() throws IOException
	{

			
		InputStream ExcelFileToRead = new FileInputStream(filePath);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
 
		HSSFSheet sheet=wb.getSheet("OBP_Policies");
		HSSFRow row; 
		HSSFCell cell;
 
		Iterator rows = sheet.rowIterator();
 		
		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.next();
				if(cell.getColumnIndex() == 2) 
						this.PolicyNumbers.add(cell.getStringCellValue());
				else if(cell.getColumnIndex() == 3) {
					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
						this.ZipCodes.add(cell.getStringCellValue());
					else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
						this.ZipCodes.add(cell.getNumericCellValue());
					}
				
			}

		}
	}
	
	public Object readXLSFile(int ColID, int RowID) {

			
		try {
			InputStream ExcelFileToRead = new FileInputStream(filePath);
			HSSFWorkbook wb;
			wb = new HSSFWorkbook(ExcelFileToRead);
			HSSFSheet sheet=wb.getSheet("OBP_Policies");
			HSSFRow row; 
			HSSFCell cell;
	 
			Iterator rows = sheet.rowIterator();
	 		
			
			
			while (rows.hasNext())
			{
				row=(HSSFRow) rows.next();
				
				Iterator cells = row.cellIterator();
				
				if(row.getRowNum() == ColID) {
					while (cells.hasNext())	 {
						cell=(HSSFCell) cells.next();
		
						if(cell.getColumnIndex() == RowID) { 
							if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) 
								return cell.getStringCellValue();
							else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
								return cell.getStringCellValue();
							else 
								return "Unknown cell type found";
						}
					}
				 }
			}
			return this;
		} catch (IOException e) {
			e.printStackTrace();
			return this;
		}
 
	}
	
	public void xKillIEs(String processName) {
		final String KILL = "taskkill /IM ";
		try {
			Runtime.getRuntime().exec(KILL + processName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		addDelay(3000);
	}
	

	public void setBrowserdriver(String browserDriver) {
		switch(browserDriver) {
		case "IE": {
			xKillIEs("iexplore.exe");
		    DRIVER = new InternetExplorerDriver();
		    break;
		}
		case "FF": {
			xKillIEs("firefox.exe");
		    DRIVER = new FirefoxDriver();
		    break;
		}
		case "CR": {
			xKillIEs("chrome.exe");
		    DRIVER = new ChromeDriver();
		    break;
		}
		default: break;
		}
	}

}
