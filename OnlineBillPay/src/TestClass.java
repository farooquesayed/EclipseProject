import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;


public class TestClass {

	private final static String filePath = "C:\\Zakir\\Eclipse Projects\\FF_OnlineBillPay\\src\\OBP_Policies.xls";
	ArrayList<String> PolicyNumbers  = new ArrayList<String>();
	ArrayList ZipCodes = new ArrayList();
	
	
	public static void main(String[] args) {
		
		TestClass t1 = new TestClass();
		try {
			System.out.println("Excel value = " + t1.readXLSFile(4, 2).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//t1.printVariables();
	}
	
	public void printVariables() {
//		Iterator it1 = this.PolicyNumbers.iterator();
//		Iterator it2 = this.ZipCodes.iterator();
//		
//		while(it1.hasNext() && it2.hasNext()) {
//			System.out.println(it1.next() + " " + it2.next());
//		}
		System.out.println(this.PolicyNumbers.get(1));
		System.out.println(this.ZipCodes.get(1));
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
	
	public Object readXLSFile(int ColID, int RowID) throws IOException
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
	}
}
