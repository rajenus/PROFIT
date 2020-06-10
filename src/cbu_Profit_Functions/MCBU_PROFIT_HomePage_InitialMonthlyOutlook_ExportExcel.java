package cbu_Profit_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import jxl.Sheet;
import cbu_Profit_ExternalDataSource.Input_DataSource;
import cbu_Profit_ObjectProperties.PropertiesFile;
import cbu_Profit_OperationsSupport.PerformOperation;

public class MCBU_PROFIT_HomePage_InitialMonthlyOutlook_ExportExcel extends cbu_Profit_DriverScript.Driver_Script {
	static ExtentReports report =cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test =cbu_Profit_DriverScript.Driver_Script.test;
	private static Sheet inputSheet;
	private static String parentWinHandle = null;
	private static String Rptperiodname = null;
	private static String ExcellocalFilePath= null;
	
public static void VerifytheAllForecastTypes_ExportExcel() throws Exception  {
	test = report.startTest("Test Execution Started in -----> VerifytheAllForecastTypes_ExportExcel");
try {
	
	inputSheet = Input_DataSource.testData(Input_DataSource.CBUTestData, "MCBUPROFITTestdata"); 
  	String forecasttypeExcelColValues = inputSheet.getCell(1,1).getContents().trim();
  	String[] ExpforecasttypeExcelColValues = forecasttypeExcelColValues.split(";");
  	
  	String HomePageforecasttypeExcelColValues = inputSheet.getCell(2,1).getContents().trim();
  	String[] ExpHomePageforecasttypeExcelColValues = HomePageforecasttypeExcelColValues.split(";");
  	
  	String forecasttypeInitial= "Outlook x+y";
    String forecasttypePlanned = "Business Plan";
    
  	PerformOperation.scrollToElement(PropertiesFile.Profit_ProfitHomePage(driver));
	PerformOperation.link_Click(PropertiesFile.Profit_ProfitHomePage(driver));
	PerformOperation.wait(5);
  	//// Forecast type-Outlook x+y
  	test.log(LogStatus.INFO, "validation Forecast type-Outlook x+y");
	parentWinHandle = driver.getWindowHandle();
    System.out.println("Parent window handle: " + parentWinHandle);
    PerformOperation.wait(1);
    Homepageforecastcolselect(forecasttypeInitial);
    PerformOperation.wait(1);
    String expRptperiod = ForecasttypeselectedRowclick();
    PerformOperation.wait(1);
    String[] exprptdate=expRptperiod.split("-");
    String Month = exprptdate[0];
    String Date = exprptdate[1];
    Rptperiodname = Date+"_"+Month;
    PerformOperation.wait(10);
    ForecasttypeOtherWindow(parentWinHandle, ExpforecasttypeExcelColValues, ExpHomePageforecasttypeExcelColValues, forecasttypeInitial, Rptperiodname);
    PerformOperation.wait(10);
    //Switching the control back to parent window
    driver.switchTo().window(parentWinHandle);
    System.out.println("Parent window URL: " + driver.getCurrentUrl());
    PerformOperation.wait(5);
    PerformOperation.link_Click(PropertiesFile.Profit_HomePageClearall(driver));
	test.log(LogStatus.PASS, "Click ClearAll button");
	PerformOperation.wait(10);
	
	////Forecast type-Business Plan
	test.log(LogStatus.INFO, "validation Forecast type-Business Plan");
    parentWinHandle = driver.getWindowHandle();
    System.out.println("Parent window handle: " + parentWinHandle);
    PerformOperation.wait(1);
    Homepageforecastcolselect(forecasttypePlanned);
    PerformOperation.wait(1);
    String expRptperiod1 = ForecasttypeselectedRowclick();
    PerformOperation.wait(1);
    String[] exprptdate1=expRptperiod1.split("-");
    String Month1 = exprptdate1[0];
    String Date1 = exprptdate1[1];
    Rptperiodname = Date1+"_"+Month1;
    PerformOperation.wait(10);
    ForecasttypeOtherWindow(parentWinHandle, ExpforecasttypeExcelColValues, ExpHomePageforecasttypeExcelColValues, forecasttypePlanned, Rptperiodname);
    PerformOperation.wait(10);
    //Switching the control back to parent window
    driver.switchTo().window(parentWinHandle);
    System.out.println("Parent window URL: " + driver.getCurrentUrl());
    PerformOperation.wait(5);
    PerformOperation.link_Click(PropertiesFile.Profit_HomePageClearall(driver));
	test.log(LogStatus.PASS, "Click ClearAll button");
	PerformOperation.wait(10);
    	
} catch(Exception e) {
	test.log(LogStatus.FAIL, "Test Execution Status - Verifythe_InitialMonthlyOutlook_ExportExcel");           	
}
 report.endTest(test);
 report.flush();	
}

public static HashMap<String,String> getValuesFromExportExcel(String filePath, String ExcelSheetName) throws Exception {
	DataFormatter df = new DataFormatter();
    File file = new File(filePath);	  
    if(file.exists()) {
    	 test.log(LogStatus.PASS, ExcelSheetName+" Export File is generated");
    }else {
    	test.log(LogStatus.FAIL, ExcelSheetName+" Export File is not generated");
    } 
    FileInputStream inputStream = new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    XSSFSheet sheet = workbook.getSheet("Forecast Metadata");
    String key = null;
    String value = null;
    Cell cellHeader;
    Cell cellValue;
    HashMap<String,String> map = new LinkedHashMap<String,String>();
    for(int i=0;i<=17;i++) {
        cellHeader = sheet.getRow(i).getCell(0);
        key = df.formatCellValue(cellHeader).trim();           
        cellValue = sheet.getRow(i).getCell(1);
        value = df.formatCellValue(cellValue).trim();      
        map.put(key, value);  
    } 
    System.out.println("Values from Excel");
    for(Map.Entry<String,String> itr:map.entrySet()) {
    	System.out.println("Key:"+itr.getKey()+" Value:"+itr.getValue());
    }
    return map;
}

@SuppressWarnings("unlikely-arg-type")
public static HashMap<String,String> getValuesFromCRSVolumeSummaryGrid() throws Exception {
	String key ="";
	String value ="";
	HashMap<String,String> UIMap = new LinkedHashMap<String,String>();
	List<WebElement> mainGridHeader=driver.findElements(By.xpath("(//div[@class='panel-body'])[1]//div[starts-with(@class,'row')]//div[starts-with(@class,'col-sm-4 forecast-details')]"));
	List<WebElement> mainGridValues = driver.findElements(By.xpath("(//div[@class='panel-body'])[1]//div[starts-with(@class,'row')]//div[starts-with(@class,'col-sm-5 ng-binding')]"));
	for (int i=0;i<=18; i++) {
	  if (!mainGridHeader.get(i).getText().equals("Entity Count:")) {
          key = mainGridHeader.get(i).getText().trim().replace(":","");
          value = mainGridValues.get(i).getText().trim();
          UIMap.put(key,value);
	  }
	}
	System.out.println("Values from UI");
	for(Map.Entry<String,String> itr:UIMap.entrySet()) {
    	System.out.println("Key:"+itr.getKey()+" Value:"+itr.getValue());
    }
   return UIMap;	
}

public static void compareHashMap(HashMap<String,String> map1,HashMap<String,String> map2) throws Exception {
	for(String key:map1.keySet()) {
		// System.out.println("Keys from excel:"+key);
		for(String key1:map2.keySet()) {
		//	System.out.println("keys from UI:"+key1);
			if(key.equalsIgnoreCase(key1)){
				String value1 = map1.get(key);
				String value2 = map2.get(key1);
				if(value1.equals(value2)) {
					test.log(LogStatus.PASS, key.toUpperCase()+": Value From Excel:"+value1+ "--&&-- Value From UI:"+value2);
			   }else {
				    test.log(LogStatus.FAIL, key.toUpperCase()+": Value From Excel:"+value1+ "--&&-- Value From UI: "+value2);
			   }
			}
		}
	}
}

public static void excelcompareUI(String[] ExpcolValues , String filePath) throws Exception {
try {
	DataFormatter df1 = new DataFormatter();
	Cell cellValue1;
	File file = new File(filePath);
	boolean fileExists = file.exists();
    if(fileExists == true) {
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	    XSSFSheet sheet = workbook.getSheet("Forecast Details");
	    Row Excelrow = sheet.getRow(0);
	    int colCount = Excelrow.getLastCellNum();
	    //headervalues checking
	    for(int i=0; i<ExpcolValues.length; i++){
	    	String actExcelheadername = sheet.getRow(0).getCell(i).getStringCellValue().trim();
			if (actExcelheadername.equalsIgnoreCase(ExpcolValues[i])) {
				System.out.println("HeaderTable values:: " + ExpcolValues[i] + " is present");
		  	    test.log(LogStatus.PASS, "HeaderTable values:: " + ExpcolValues[i] + " is present");
			} else {
				System.out.println("HeaderTable values:: " + ExpcolValues[i] + " is Not present");
		  	    test.log(LogStatus.FAIL, "HeaderTable values:: " + ExpcolValues[i] + " is Not present");
			    test.log(LogStatus.FAIL,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("HeaderTable compare")));
			}
		}
	    //Table checking
	    WebElement forcecasttypewindowtablerow = driver.findElement(By.xpath("//div[@id='viewer-grid']//div[@class='k-grid-content-locked']//table//tbody"));
	    List <WebElement> tablerows = forcecasttypewindowtablerow.findElements(By.tagName("tr"));
	    int tablerowscount = tablerows.size();
	    System.out.println("forcecasttypewindow table row count " + tablerowscount);
	    for (int row = 1; row<=tablerowscount; row++) {
	    	for (int column = 1; column<=1; column++) {
	    		String tableoneTextname = driver.findElement(By.xpath("//div[@id='viewer-grid']//div[@class='k-grid-content-locked']//table//tbody//tr[" +row+ "]//td[" +column+ "]")).getText().trim().replace(" ", "");
	    		cellValue1 = sheet.getRow(row).getCell(column-1);
	    		String ExceloneTextname = df1.formatCellValue(cellValue1).trim().replace(" ", "");
	    		if (tableoneTextname.equalsIgnoreCase(ExceloneTextname)) {
	    			System.out.println("Table:: UI value::" + tableoneTextname + " && - Excel value::" + ExceloneTextname + " are displayed Same");
	 			    test.log(LogStatus.PASS, "Table:: UI value::" + tableoneTextname + " && - Excel value::" + ExceloneTextname + " are displayed Same");
	    		} else {
	    			System.out.println("Table:: UI value::" + tableoneTextname + " && - Excel value::" + ExceloneTextname + " Not displayed Same");
	 			    test.log(LogStatus.FAIL, "Table:: UI value::" + tableoneTextname + " && - Excel value::" + ExceloneTextname + " Not displayed Same");
	    		}
	    	}
	    }
	    test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("forcecasttypewindow table All col compare Export Values")));
	    //close excel 
        workbook.close();
        inputStream.close();
    }
}catch(Exception e) {
    e.printStackTrace();
}
}

public static void Homepageforecastcolselect(String forecasttype) throws InterruptedException {
 try {
	Actions actions1 = new Actions(driver);
    actions1.moveToElement(PropertiesFile.Profit_PermissionsTableColName(driver, "Forecast Type")).build().perform();
    PerformOperation.link_Click(PropertiesFile.Profit_PermissionsTableColName(driver, "Forecast Type"));
    PerformOperation.wait(2);
    if(PerformOperation.wrn_Present(PropertiesFile.Profit_Homepagesubmenu_filter(driver))) {
  	   PerformOperation.link_Click(PropertiesFile.Profit_Homepagesubmenu_filter(driver));
  	   PerformOperation.wait(2);
       List<WebElement> usernames = driver.findElements(By.xpath("//li[contains(@class,'k-state-border-right')]//li//label[starts-with(@class,'k-label')]"));
       System.out.println("num::"+usernames.size());
       PerformOperation.wait(2);
       for (int i=1;i<usernames.size();i++) {
    	   String actval1 = usernames.get(i).getText();
    	   if (actval1.equalsIgnoreCase(forecasttype)) {
    		   PerformOperation.wait(1);
    		   //actions1.moveToElement(usernames.get(i)).click().build().perform();
    		   PerformOperation.link_Click(usernames.get(i));
    		   PerformOperation.wait(1);
    		   PerformOperation.link_Click(PropertiesFile.Profit_Homepagesubmenu_Filterbutton(driver));
    		 }
    	 }
    } else {
       test.log(LogStatus.FAIL, "ForecostType verticalmenu is not present");
    }
 }catch(Exception e) {
    e.printStackTrace();
 }
}

public static String ForecasttypeselectedRowclick () throws InterruptedException  {
	String expRptperiodname="";
    WebElement ForecastTypeFirstrow = driver.findElement(By.xpath("//div[@id='#vm']//div[@class='k-grid-content k-auto-scrollable']//tr[1]//td[1]"));
    if (ForecastTypeFirstrow.isDisplayed()) {
    	PerformOperation.link_Click(ForecastTypeFirstrow);
    	PerformOperation.wait(1);
    	try {
    	  WebElement Childtablecolname = driver.findElement(By.xpath("//div[@k-ng-delay='vm.childGridConfiguration']//table[@role='grid']//tr[1]//td[1]"));
    	  if (Childtablecolname.isDisplayed()) {
    	      driver.findElement(By.xpath("//div[@k-ng-delay='vm.childGridConfiguration']//table[@role='grid']//tr[1]//td[1]")).click();
    	      PerformOperation.wait(1);
    	      expRptperiodname = driver.findElement(By.xpath("//div[@k-ng-delay='vm.childGridConfiguration']//table[@role='grid']//tr[1]//td[3]")).getText();
    	      PerformOperation.wait(1);
    		  PerformOperation.link_Click(PropertiesFile.Profit_HomePage_exportmenu(driver));
			  test.log(LogStatus.PASS, "Click Export button");
			  //PerformOperation.wait(5);
			  //PerformOperation.link_Click(PropertiesFile.Profit_HomePage_ExportForecastDetailsPOPUPOKbutton(driver));
			  PerformOperation.wait(10);
    		  PerformOperation.link_Click(PropertiesFile.Profit_HomePage_Viewmenu(driver));
			  test.log(LogStatus.PASS, "Click View button");
    	  }
    	}catch(Exception e) {
    		  expRptperiodname = driver.findElement(By.xpath("//div[@id='#vm']//div[@class='k-grid-content k-auto-scrollable']//tr[1]//td[4]")).getText();
    		  PerformOperation.wait(1);
    		  PerformOperation.link_Click(PropertiesFile.Profit_HomePage_exportmenu(driver));
			  test.log(LogStatus.PASS, "Click Export button");
			  //PerformOperation.wait(5);
			  //PerformOperation.link_Click(PropertiesFile.Profit_HomePage_ExportForecastDetailsPOPUPOKbutton(driver));
			  PerformOperation.wait(10);
    		  PerformOperation.link_Click(PropertiesFile.Profit_HomePage_Viewmenu(driver));
			  test.log(LogStatus.PASS, "Click View button");
		}
    } else {
    	test.log(LogStatus.FAIL, "ForecastTypeFirst row is not present");
    }
    PerformOperation.wait(1);
	return expRptperiodname;
}

public static void ForecasttypeOtherWindow(String parentWinHandle, String[] ExpcolValues ,String[] HomePageExpcolvalues, String ExcelSheetName ,String rptdate) throws Exception {
try {
    Set <String> winHandles = driver.getWindowHandles();
    for(String handle: winHandles){
       if(!handle.equals(parentWinHandle)){
          driver.switchTo().window(handle);
          PerformOperation.wait(10);
          PerformOperation.link_Click(PropertiesFile.Profit_ExportForecastDetailsverticalbutton(driver));
          PerformOperation.wait(2);
          String defaultcolorder = driver.findElement(By.xpath("//div[@class='k-grid-header-locked']//table//tr[1]//th[2]")).getAttribute("aria-sort");
          if (defaultcolorder.equalsIgnoreCase("ascending")) {
        	  WebElement colorderdesn=  driver.findElement(By.xpath("//div[@class='k-grid-header-locked']//table//tr[1]//th[2]"));
        	  colorderdesn.click();
          }
          PerformOperation.wait(10);
          String userName = System.getProperty("user.name");
		  ExcellocalFilePath ="C:\\Users\\"+userName+"\\Downloads\\"+ExcelSheetName+"_"+rptdate+" .xlsx";
		  String localfile ="C:\\Users\\"+userName+"\\Downloads\\"+ExcelSheetName+"_"+rptdate+" .xlsx";
		  PerformOperation.wait(2);
	      HashMap<String,String> excelValues=getValuesFromExportExcel(ExcellocalFilePath, ExcelSheetName);
	      PerformOperation.wait(2);
	      test.log(LogStatus.INFO, ExcelSheetName+" :: Home Page Export Excel validation");
	  	  HashMap<String,String> UIValues = getValuesFromCRSVolumeSummaryGrid();
	  	  PerformOperation.wait(2);
	  	  compareHashMap(excelValues, UIValues);
	      PerformOperation.wait(2);
	      excelcompareUI(HomePageExpcolvalues, ExcellocalFilePath);
	      PerformOperation.wait(5);
	      //delete local file
    	  //localfiledelete(ExcellocalFilePath);
    	  //PerformOperation.wait(5);
    	  
    	  ///2nd time compare
    	  exportexcelotherwindow();
    	  PerformOperation.wait(10);
		  ExcellocalFilePath ="C:\\Users\\"+userName+"\\Downloads\\"+ExcelSheetName+"_"+rptdate+"  (1).xlsx";
    	  PerformOperation.wait(2);
    	  test.log(LogStatus.INFO, ExcelSheetName+" :: New window Export Excel validation");
	      HashMap<String,String> excelValues1=getValuesFromExportExcel(ExcellocalFilePath, ExcelSheetName);
	      PerformOperation.wait(2);
	  	  HashMap<String,String> UIValues1 = getValuesFromCRSVolumeSummaryGrid();
	  	  PerformOperation.wait(2);
	  	  compareHashMap(excelValues1, UIValues1);
	      PerformOperation.wait(2);
	      excelcompareUI(ExpcolValues, ExcellocalFilePath);
	      PerformOperation.wait(5);
	      //delete local file
    	  localfiledelete(ExcellocalFilePath);
    	  PerformOperation.wait(5);
		  if ((new File(localfile)).delete()) {
			 System.out.println("Pass");     
		  }
		  PerformOperation.wait(5);
	      //window close
    	  driver.close();
    	  PerformOperation.wait(5);
    	  //delete local file
    	  localfiledelete(ExcellocalFilePath);
       }
    }
} catch(Exception e) {
   System.out.println("ForecasttypeOtherWindow is not displayed");
   test.log(LogStatus.FAIL, "ForecasttypeOtherWindow is not displayed");
}
}

public static void localfiledelete(String filePath) throws InterruptedException {
	PerformOperation.wait(2);
	if ((new File(filePath)).delete()) {
	    System.out.println("Pass");     
	}
}

public static void exportexcelotherwindow() throws InterruptedException {
	//Click Export
    if (PerformOperation.wrn_Present(PropertiesFile.Profit_HomePage_ExportForecastDetails(driver))) {
  	    PerformOperation.link_Click(PropertiesFile.Profit_HomePage_ExportForecastDetails(driver));
		test.log(LogStatus.PASS, "Click ExportForecastDetails button");
		PerformOperation.wait(5);
		PerformOperation.link_Click(PropertiesFile.Profit_HomePage_ExportForecastDetailsPOPUPOKbutton(driver));
    } else {
  	    test.log(LogStatus.FAIL, "ExportForecastDetails button is not present");
    }
}

}
