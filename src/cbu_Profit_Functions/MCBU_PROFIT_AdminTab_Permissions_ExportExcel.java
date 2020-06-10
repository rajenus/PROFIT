package cbu_Profit_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cbu_Profit_ObjectProperties.PropertiesFile;
import cbu_Profit_OperationsSupport.PerformOperation;

public class MCBU_PROFIT_AdminTab_Permissions_ExportExcel extends cbu_Profit_DriverScript.Driver_Script {
	static ExtentReports report =cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test =cbu_Profit_DriverScript.Driver_Script.test;
	
public static void VerifytheAdminTabPermissionsExportExcel() throws Exception  {
	test = report.startTest("Test Execution Started in -----> AdminTab-Permissions-ExportExcel");
try { 
	///Delete local file 
	String username = System.getProperty("user.name").toLowerCase(); 
	String localexcelFilePath = "C:\\Users\\"+username+"\\Downloads\\Permissions.xlsx";
	if ((new File(localexcelFilePath)).delete()) {
	    System.out.println("Pass");     
    } 
	PerformOperation.scrollToElement(PropertiesFile.Profit_Factory(driver));
	if (PerformOperation.wrn_Present(PropertiesFile.Profit_Factory(driver))) {
		Actions actionsnew = new Actions(driver);
		actionsnew.moveToElement(PropertiesFile.Profit_Factory(driver)).build().perform();
		PerformOperation.wait(2);
		actionsnew.moveToElement(PropertiesFile.Profit_Admin(driver)).build().perform();
		PerformOperation.wait(2);
		if (PerformOperation.wrn_Present(PropertiesFile.Profit_Adminsub_Permissions(driver))) {
			PerformOperation.link_Click(PropertiesFile.Profit_Adminsub_Permissions(driver));
		 	test.log(LogStatus.PASS, "Click Permissions button");
		}
	} else {
		test.log(LogStatus.FAIL, "Factorytab Name is not displayed");
	}
	PerformOperation.wait(5);
	String forcasttypedefname = PerformOperation.getText_Display(PropertiesFile.Profit_Forecasttypedefaultname(driver));
	PerformOperation.wait(2);
	PerformOperation.link_Click(PropertiesFile.Profit_Permission_ExportExcel(driver));
 	test.log(LogStatus.PASS, "Click ExportExcel button");
 	PerformOperation.wait(5);
 	MCBU_PROFIT_AdminTab_Permissions_ExportExcel.CompareExportExcelandUIvalues(forcasttypedefname);
} catch(Exception e) {
	test.log(LogStatus.FAIL, "Test Execution Status - AdminTab-Permissions-ExportExcel");           	
}
  report.endTest(test);
  report.flush();
}

public static void CompareExportExcelandUIvalues(String textName) throws Exception {
 try {
	 DataFormatter df1 = new DataFormatter();
	 Cell cellValue1;
	 Cell cellValue2;
	 int exprownum = 0;
	 String username = System.getProperty("user.name");
	 String filePath ="C:\\Users\\"+username+"\\Downloads\\Permissions.xlsx";
	 File file = new File(filePath);
	 boolean fileExists = file.exists();
     if(fileExists == true) {
       test.log(LogStatus.PASS, "Permissions Export File is generated");
	   FileInputStream inputStream = new FileInputStream(file);
	   XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
       XSSFSheet sheet = workbook.getSheet("Permissions");
	   int rowCount  = sheet.getLastRowNum();
       Row Excelrow = sheet.getRow(0);
       int colCount = Excelrow.getLastCellNum();
       System.out.println("Excel row count "+ rowCount);
       System.out.println("Excel col count "+ colCount);
       ///header names
       ArrayList<String> list = getColumnValuesFromLockedGrid();
       PerformOperation.wait(2);
       for (int column = 2; column<=colCount; column++) {
   			String tableheadername =list.get(column-1);
   			String Excelheadername = sheet.getRow(0).getCell(column-1).getStringCellValue().trim();
	   		if (tableheadername.equalsIgnoreCase(Excelheadername)) {
	   			System.out.println("Permissions headerTable Colvalue:: UI value::" + tableheadername + " && - Excel value::" + Excelheadername + " are displayed Same");
			    test.log(LogStatus.PASS, "Permissions headerTable Colvalue:: UI value::" + tableheadername + " && - Excel value::" + Excelheadername + " are displayed Same");
			    //test.log(LogStatus.PASS,test.addScreenCapture(mcbu_Tracer_ExternalDataSource.ScreenShots.getScreenshot("All col compare Export Values")));
	   		} else {
	   			System.out.println("Permissions headerTable Colvalue:: UI value::" + tableheadername + " && - Excel value::" + Excelheadername + " Not displayed Same");
			    test.log(LogStatus.FAIL, "Permissions headerTable Colvalue:: UI value::" + tableheadername + " && - Excel value::" + Excelheadername + " Not displayed Same");
			    test.log(LogStatus.FAIL,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("All col compare Export Values")));
	   		}
   	   }
       for (int i = 1; i<=rowCount; i++) {
    	    cellValue2 = sheet.getRow(i).getCell(0);
		    String ExcelTextname = df1.formatCellValue(cellValue2).trim();
    	    if (ExcelTextname.equals(textName)) {
    		   exprownum=i;
    	       break;
    	    }
       }
       System.out.println("Permissions default name Excel col number::"+ exprownum);
       //Web table values fetching 
       WebElement Managedatatable = driver.findElement(By.xpath("//div[@id='t-user-permissions-grid']//div[@class='k-grid-content k-auto-scrollable']//table"));
       List <WebElement> rows = Managedatatable.findElements(By.tagName("tr"));
       int rowscount = rows.size();
       System.out.println("UI Rows count "+ rowscount);
       String actdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
       for (int row = 1; row<=rowscount; row++) {
 	    	for (int column = 2; column<=colCount; column++) {
 	    		String tableTextname = driver.findElement(By.xpath("//div[@id='t-user-permissions-grid']//div[@class='k-grid-content k-auto-scrollable']//table//tr[" +row+ "]//td[" +column+ "]")).getText().trim().replace(" ", "");
 	    		cellValue1 = sheet.getRow(exprownum+row-1).getCell(column-1);
 	    		String ExcelTextname = df1.formatCellValue(cellValue1).trim().replace(" ", "").replace("Yes", "").replace("No", "");
 	    		if (tableTextname.equalsIgnoreCase(ExcelTextname)) {
 	    			System.out.println("UI value::" + tableTextname + " && - Excel value::" + ExcelTextname + " are displayed Same");
 	    			test.log(LogStatus.PASS, "ColumnName::-- " + list.get(column-1) + "-- UI value::" + tableTextname + " && - Excel value::" + ExcelTextname + " are displayed Same");
 	    		} else {
 	    			System.out.println("UI value::" + tableTextname + " && - Excel value::" + ExcelTextname + " Not displayed Same");
 	    			test.log(LogStatus.FAIL, "ColumnName::-- " + list.get(column-1) + "-- UI value::" + tableTextname + " && - Excel value::" + ExcelTextname + " Not displayed Same");
 	    			test.log(LogStatus.FAIL,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("All col compare Export Values")));
 	    		}
 	    	}
 	    }
        //close excel 
 	    workbook.close();
 	    inputStream.close();
        test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Permissions compare Export")));
     }else {
	    test.log(LogStatus.FAIL, "Permissions Export File is not generated");
	    test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Permissions Export")));
	 }
  }catch(Exception e) {
    e.printStackTrace();
  }
}

public static ArrayList<String> getColumnValuesFromLockedGrid() {
	   ArrayList<String> colValues = new ArrayList<String>();
	   WebElement we = driver.findElement(By.xpath("//div[@id='t-user-permissions-grid']//div[@class='k-grid-header']//table//tr[1]"));
	   List<WebElement> we1= we.findElements(By.tagName("th"));
	   System.out.println("count"+we1.size());
	   for (int i=0;i<we1.size();i++) { 
			WebElement ele = driver.findElement(By.xpath("//div[@id='t-user-permissions-grid']//div[@class='k-grid-header']//table//tr[1]//th[" +(i+1)+"]")); 
			PerformOperation.scrollToElementcol(ele, driver);
			String data = driver.findElement(By.xpath("//div[@id='t-user-permissions-grid']//div[@class='k-grid-header']//table//tr[1]//th[" +(i+1)+ "]")).getText();
			System.out.println(data);
			colValues.add(data);
		}
		return colValues;
}

}
