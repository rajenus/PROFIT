package cbu_Profit_ExternalDataSource;
import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import cbu_Profit_DriverScript.Driver_Script;


public class Input_DataSource extends Driver_Script {
    public static String CBUTestData= workingDir+"\\Keyword\\PROFIT_CBU_TestData.xls";
    public static String BusinessPlanUploadFilePath = workingDir+"\\Keyword\\BusinessPlanForecast-Upload.xlsx";
    public static String OutlookXYUploadFilePath = workingDir+"\\Keyword\\Outlook_xyForecast-Upload.xlsx";
    
    
   public static Sheet testData(String filename, String sheetname) throws IOException, BiffException
    {
    File f =new File(filename);
    Workbook wb=Workbook.getWorkbook(f);
    Sheet st=wb.getSheet(sheetname);
    return (st);
    }
}
