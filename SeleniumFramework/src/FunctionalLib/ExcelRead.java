package FunctionalLib;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ExcelRead {

    int col,Column_Count,Row_Count;
    int colnNum=0;
    Sheet sheet1 ;
    Workbook wb = null;
    
    
    public ExcelRead(){}

    public ExcelRead(String Filename, String SheetName){
        File fp = new File(Filename);
        try {
            wb = Workbook.getWorkbook(fp);
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sheet1 = wb.getSheet(SheetName);
        Row_Count = sheet1.getRows();
        Column_Count = sheet1.getColumns();
    }

    public int getCoulmnNumber(String strCoulmn){
        for(colnNum=0 ; colnNum<this.sheet1.getColumns();colnNum++){
            if(this.sheet1.getCell(colnNum,0).getContents().equals(strCoulmn))	{
                break;
            }
        }
        return colnNum;
    }

    public int getRowNumber(String strRowData){
        int rowNum;
        for(rowNum=1;rowNum<this.sheet1.getRows();rowNum++)
            if(this.sheet1.getCell(0,rowNum).getContents().toString().equals(strRowData))
                break;
        return rowNum;
    }

    public String getCellData(int iRow, int iColumn){
        return this.sheet1.getCell(iColumn, iRow).getContents().toString();
    }

    public String getCellData(String strColumn, int iRow){
        return this.sheet1.getCell(this.getCoulmnNumber(strColumn), iRow).getContents().toString();
    }

    public int rowCount(){
        return sheet1.getRows();
    }

    public int columnCount(){
        return sheet1.getColumns();
    }

}
