package cbu_Profit_ExternalDataSource;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;


public class ExcelReportCreate {
static String filepath="./report/Status"+new SimpleDateFormat("dd-MM-yy.HH.mm.ss").format(new Date())+".xls";
static File fileObject = new File(filepath);
    
    static void CreateExcelReport()
    {
        try
        {
    
            fileObject.createNewFile();
        }
        catch(Exception e)
        {
            File folder = new File("./report/");
            folder.mkdir();
        }
    }
    
    public static String columnHeader() throws IOException, RowsExceededException, WriteException, BiffException
    {    
        CreateExcelReport();
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(fileObject);
        WritableSheet excelSheet = writableWorkbook.createSheet("Result", 0);
        int rRowcount=excelSheet.getRows();
        int rColcount=excelSheet.getColumns();
        for(int i=rRowcount; i<=rRowcount;i++)
        {
            for(int j=0; j<=rColcount;j++)
            {
            Label col1= new Label(j, i, "TS ID");
            Label col2=new Label(j+1, i, "Test Scenario");
            Label col3=new Label(j+2, i, "Status");    
            Label col4=new Label(j+3, i, "OrderNo/Details");    
            excelSheet.addCell(col1);
            excelSheet.addCell(col2);
            excelSheet.addCell(col3);
            excelSheet.addCell(col4);
            }
        }
        writableWorkbook.write();
        writableWorkbook.close();
        return filepath;
    }
    
}
