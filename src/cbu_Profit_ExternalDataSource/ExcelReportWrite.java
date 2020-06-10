package cbu_Profit_ExternalDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReportWrite {
    
    static public void writeExcel(String filepath, String sheetName,String[] dataToWrite) throws IOException{
     File file=new File(filepath);
     FileInputStream inputStream = new FileInputStream(file);
     Workbook WriteWorkbook= null;
     String fileExtensionName = filepath.substring(filepath.lastIndexOf("."));
     if(fileExtensionName.equals(".xlsx")){
     WriteWorkbook = new XSSFWorkbook(inputStream);

     }
     else if(fileExtensionName.equals(".xls")){
       WriteWorkbook = new HSSFWorkbook(inputStream);
     }
    Sheet sheet = WriteWorkbook.getSheet(sheetName);
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    Row newRow = sheet.createRow(rowCount+1);
     for(int j = 0; j<=3; j++)
    {
            Cell cell = newRow.createCell(j);
            cell.setCellValue(dataToWrite[j]);
    }
    inputStream.close();
     FileOutputStream outputStream = new FileOutputStream(file);
       WriteWorkbook.write(outputStream);
        outputStream.close();
    }

    
}
