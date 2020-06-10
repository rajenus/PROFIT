package cbu_Profit_Functions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cbu_Profit_ObjectProperties.PropertiesFile;
import cbu_Profit_OperationsSupport.PerformOperation;


public class HomePageValidation extends cbu_Profit_DriverScript.Driver_Script {
	public Sheet st1;
	public static Workbook workbook;
	static ExtentReports report =cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test =cbu_Profit_DriverScript.Driver_Script.test;
	
public static void actionCall() throws Exception {
	test=report.startTest("Test Case -----> Validate the Audit Trails, Forecast Deletion, Compare Forecast");
    try {
    	PerformOperation.scrollToElement(PropertiesFile.Profit_ProfitHomePage(driver));
    	PerformOperation.link_Click(PropertiesFile.Profit_ProfitHomePage(driver));
    	PerformOperation.wait(5);
		auditReports();
		deleteForecast();
		compareForecast();
	
		report.endTest(test);
		report.flush();
	
	}catch(Exception e) {
		report.endTest(test);
		report.flush();
	}
}
	
	public static void auditReports() throws Exception {
		try {
			
		String exportPath = "C:\\Users\\" + user + "\\Downloads\\Forecast History Report "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +" - "
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xlsx";
		File file = new File(exportPath);
		file.delete();
		
		PerformOperation.mouseOver(PropertiesFile.factory(driver), driver);
		PerformOperation.wait(2);
		PerformOperation.mouseOver(PropertiesFile.auditTrail(driver), driver);
		PerformOperation.wait(2);
		PerformOperation.link_Click(PropertiesFile.forecastHistory(driver));
		PerformOperation.wait(2);
		PerformOperation.link_Click(PropertiesFile.okAT(driver));
		PerformOperation.wait(7);
		
		if (file.exists()) {
			System.out.println("Forecast History Report File is generated");
			test.log(LogStatus.PASS, "Forecast History Report file generated");

			workbook = new XSSFWorkbook(exportPath);
			Sheet st1 = workbook.getSheet("Forecast History");
			
			String[] colNames = {"CAI", "Created Date","Last Updated Date","Deleted Date","Forecast Surrogate Key ","Forecast Type",
					"Forecast Version Number ","Active ","Approved"};
			
			for (int i=0; i<colNames.length; i++) {
				
				String col = st1.getRow(0).getCell(i).getStringCellValue();
				
				if (col.equalsIgnoreCase(colNames[i])) {
					System.out.println(colNames[i]+" is displayed");
					test.log(LogStatus.PASS, colNames[i]+" is displayed");					
				}else {
					System.out.println(colNames[i]+" is not displayed"+col);
					test.log(LogStatus.PASS, colNames[i]+" is not displayed"+col);
				}
			}
			workbook.close();
			
	}else {
		System.out.println("Forecast History Report File is not generated");
		test.log(LogStatus.FAIL, "Forecast History Report file is not generated");

	}
		}catch(Exception e) {
			e.printStackTrace();
		}
//-------------------------------------------------------------------------------
	try {
		
		String exportPath = "C:\\Users\\" + user + "\\Downloads\\Export History Report "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +" - "
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xlsx";
		File file = new File(exportPath);
		file.delete();
		
		PerformOperation.mouseOver(PropertiesFile.factory(driver), driver);
		PerformOperation.wait(2);
		PerformOperation.mouseOver(PropertiesFile.auditTrail(driver), driver);
		PerformOperation.wait(2);
		PerformOperation.link_Click(PropertiesFile.exportHistory(driver));
		PerformOperation.wait(2);
		PerformOperation.link_Click(PropertiesFile.okAT(driver));
		PerformOperation.wait(7);
		
		if (file.exists()) {
			System.out.println("Export History Report File is generated");
			test.log(LogStatus.PASS, "Export History Report file generated");

			workbook = new XSSFWorkbook(exportPath);
			Sheet st1 = workbook.getSheet("Export History");
			
			String[] colNames = {"CAI", "Time","Export Type","Forecast Type","Records"};
					
			
			for (int i=0; i<colNames.length; i++) {
				
				String col = st1.getRow(0).getCell(i).getStringCellValue();
				
				if (col.equalsIgnoreCase(colNames[i])) {
					System.out.println(colNames[i]+" is displayed");
					test.log(LogStatus.PASS, colNames[i]+" is displayed");					
				}else {
					System.out.println(colNames[i]+" is not displayed"+col);
					test.log(LogStatus.PASS, colNames[i]+" is not displayed"+col);
				}
			}
			workbook.close();
			
	}else {
		System.out.println("Export History Report File is not generated");
		test.log(LogStatus.FAIL, "Export History Report file is not generated");

	}
		}catch(Exception e) {
			e.printStackTrace();
		}
//-------------------------------------------------------------------	
try {
		
		String exportPath = "C:\\Users\\" + user + "\\Downloads\\User Team History Report "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +" - "
				+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xlsx";
		File file = new File(exportPath);
		file.delete();
		
		PerformOperation.mouseOver(PropertiesFile.factory(driver), driver);
		PerformOperation.wait(2);
		PerformOperation.mouseOver(PropertiesFile.auditTrail(driver), driver);
		PerformOperation.wait(2);
		PerformOperation.link_Click(PropertiesFile.userTeamHistory(driver));
		PerformOperation.wait(2);
		PerformOperation.link_Click(PropertiesFile.okAT(driver));
		PerformOperation.wait(7);
		
		if (file.exists()) {
			System.out.println("User Team History Report File is generated");
			test.log(LogStatus.PASS, "User Team History Report file generated");

			workbook = new XSSFWorkbook(exportPath);
			Sheet st1 = workbook.getSheet("User Team History");
			
			String[] colNames = {"Log CAI", "Log time","User team id","User team name","Start date","End date","Update By","Update Date"};
					
			
			for (int i=0; i<colNames.length; i++) {
				
				String col = st1.getRow(0).getCell(i).getStringCellValue();
				
				if (col.equalsIgnoreCase(colNames[i])) {
					System.out.println(colNames[i]+" is displayed");
					test.log(LogStatus.PASS, colNames[i]+" is displayed");					
				}else {
					System.out.println(colNames[i]+" is not displayed"+col);
					test.log(LogStatus.PASS, colNames[i]+" is not displayed"+col);
				}
			}	
			workbook.close();
	}else {
		System.out.println("User Team History Report File is not generated");
		test.log(LogStatus.FAIL, "User Team History Report file is not generated");

	}
		}catch(Exception e) {
			e.printStackTrace();
		}
}
	
	public static void deleteForecast() {
		try {
		
		try {
			PerformOperation.link_Click(PropertiesFile.clearFilters(driver));
			PerformOperation.wait(2);
		}catch(Exception e) {}
			
			if (PerformOperation.value_IsEnabled(PropertiesFile.deleteForecast(driver))==false) {
				System.out.println("Delete button is not enabled when no lookback is selected");
				test.log(LogStatus.PASS, "Delete button is not enabled when no lookback is selected");
				test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Delete button is not enabled when no lookback is selected")));
			}else {
				System.out.println("Delete button is enabled when no lookback is selected");
				test.log(LogStatus.FAIL, "Delete button is enabled when no lookback is selected");
				test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Delete button is enabled when no lookback is selected")));
			}
		
			PerformOperation.link_Click(PropertiesFile.menuOptions(driver, "Approved"));
			PerformOperation.wait(2);
			
			PerformOperation.mouseOver(PropertiesFile.filterByValue(driver),driver);
			PerformOperation.wait(2);
			
			
			PerformOperation.link_Click(PropertiesFile.approvedCB(driver));
			PerformOperation.wait(2);
			PerformOperation.link_Click(PropertiesFile.confirmFilter(driver));
			PerformOperation.wait(5);
			
			PerformOperation.link_Click(PropertiesFile.selectForecast(driver));
			PerformOperation.wait(3);
			
			if (PerformOperation.value_IsEnabled(PropertiesFile.deleteForecast(driver))==false) {
				System.out.println("Delete button is not enabled when approved lookback is selected");
				test.log(LogStatus.PASS, "Delete button is not enabled when approved lookback is selected");
				test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Delete button is not enabled when approved lookback is selected")));
			}else {
				System.out.println("Delete button is enabled when approved lookback is selected");
				test.log(LogStatus.FAIL, "Delete button is enabled when approved lookback is selected");
				test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Delete button is enabled when approved lookback is selected")));
			}
			
			try {
				PerformOperation.link_Click(PropertiesFile.clearFilters(driver));
				PerformOperation.wait(2);
			}catch(Exception e) {}
			PerformOperation.wait(5);
			PerformOperation.link_Click(PropertiesFile.menuOptions(driver, "Approved"));
			PerformOperation.wait(2);
			
			PerformOperation.mouseOver(PropertiesFile.filterByValue(driver),driver);
			PerformOperation.wait(2);
			
			
			PerformOperation.link_Click(PropertiesFile.unApprovedCB(driver));
			PerformOperation.wait(2);
			PerformOperation.link_Click(PropertiesFile.confirmFilter(driver));
			PerformOperation.wait(5);
			
			PerformOperation.link_Click(PropertiesFile.selectForecast(driver));
			PerformOperation.wait(3);
			
			if (PerformOperation.value_IsEnabled(PropertiesFile.deleteForecast(driver))==true) {
				System.out.println("Delete button is enabled when Unapproved lookback is selected");
				test.log(LogStatus.PASS, "Delete button is enabled when Unapproved lookback is selected");
				test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Delete button is enabled when Unapproved lookback is selected")));
			}else {
				System.out.println("Delete button is not enabled when unapproved lookback is selected");
				test.log(LogStatus.FAIL, "Delete button is not enabled when unapproved lookback is selected");
				test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Delete button is not enabled when unapproved lookback is selected")));
			}
			
			PerformOperation.link_Click(PropertiesFile.deleteForecast(driver));
			PerformOperation.wait(3);
			
			PerformOperation.link_Click(PropertiesFile.deleteConfirm(driver));
			PerformOperation.wait(3);
			
			try {
			if(PerformOperation.wrn_Present(PropertiesFile.deletedMsg(driver))==true) {
				System.out.println("Forecast Deleted");
				test.log(LogStatus.PASS, "Forecast Deleted");
				test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast Deleted")));
				PerformOperation.link_Click(PropertiesFile.closeMsg(driver));
				PerformOperation.wait(2);
			}}catch(Exception e) {
				System.out.println("Forecast is not Deleted");
				test.log(LogStatus.FAIL, "Forecast is not Deleted");
				test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast is not Deleted")));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void compareForecast() {
		
		try {
			PerformOperation.link_Click(PropertiesFile.compare(driver));
			PerformOperation.wait(2);
			
			PerformOperation.link_Click(PropertiesFile.selectForecastCB(driver, 1));
			PerformOperation.link_Click(PropertiesFile.selectForecastCB(driver, 2));
			PerformOperation.wait(3);
			
			try {
				if(PerformOperation.value_IsEnabled(PropertiesFile.selectForecastCB(driver, 3))==false){
					System.out.println("User is not able to select more than 2 forecasts to compare");
					test.log(LogStatus.PASS, "User is not able to select more than 2 forecasts to compare");
				}
			}catch(Exception e) {
				System.out.println("User is able to select more than 2 forecasts to compare");
				test.log(LogStatus.FAIL, "User is able to select more than 2 forecasts to compare");
			}
			
			PerformOperation.link_Click(PropertiesFile.viewForecast(driver));
			PerformOperation.wait(3);
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
			
		    try {
		  
		    	PerformOperation.link_Click(PropertiesFile.hierarchyDropDown(driver));
		    	PerformOperation.wait(2);
		    	PerformOperation.link_Click(PropertiesFile.hierarchyDropDownOption(driver,"DEVELOPMENT"));
		    	PerformOperation.wait(2);
		    
		    }catch(Exception e) {
		    	test.log(LogStatus.ERROR, "Error selecting the forecast hierarchy");
		    }
		    
		    try {
		    if(PerformOperation.wrn_Present(PropertiesFile.chart(driver))==true) {
		    	System.out.println("Forecast comparison chart is displayed");
				test.log(LogStatus.PASS, "Forecast comparison chart is displayed");
				test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast comparison chart is displayed")));
		    }}catch(Exception e) {
		    	System.out.println("Forecast comparison chart is not displayed");
				test.log(LogStatus.FAIL, "Forecast comparison chart is not displayed");
				test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast comparison chart is not displayed")));
		    }
		    
		    try {
			    if(PerformOperation.wrn_Present(PropertiesFile.forecastMetaData(driver, "F1"))==true) {
			    	PerformOperation.link_Click(PropertiesFile.forecastMetaData(driver, "F1"));
			    	System.out.println("Forecast Meta Data F1 is displayed");
					test.log(LogStatus.PASS, "Forecast Meta Data F1 chart is displayed");
					test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast Meta Data F1 chart is displayed")));
			    }}catch(Exception e) {
			    	System.out.println("Forecast Meta Data F1 chart is not displayed");
					test.log(LogStatus.FAIL, "Forecast Meta Data F1 chart is not displayed");
					test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast Meta Data F1 chart is not displayed")));
			    }
		    
		    try {
			    if(PerformOperation.wrn_Present(PropertiesFile.forecastMetaData(driver, "F2"))==true) {
			    	PerformOperation.link_Click(PropertiesFile.forecastMetaData(driver, "F2"));
			    	System.out.println("Forecast Meta Data F2 chart is displayed");
					test.log(LogStatus.PASS, "Forecast Meta Data F2 chart is displayed");
					test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast Meta Data F2 chart is displayed")));
			    }}catch(Exception e) {
			    	System.out.println("Forecast Meta Data F2 chart is not displayed");
					test.log(LogStatus.FAIL, "Forecast Meta Data F2 chart is not displayed");
					test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast Meta Data F2 chart is not displayed")));
			    }
			 
		    try {
			    if(PerformOperation.wrn_Present(PropertiesFile.hierarchy(driver))==true) {
			    	System.out.println("Hierarchy is displayed");
					test.log(LogStatus.PASS, "Hierarchy is displayed");
					test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Hierarchy is displayed")));
			    }}catch(Exception e) {
			    	System.out.println("Hierarchy is not displayed");
					test.log(LogStatus.FAIL, "Hierarchy is not displayed");
					test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Hierarchy is not displayed")));
			    }
		    
		    String[] cols = {"Forecast Type","Reporting Period","Entity","Date","Case","GROSS_OIL (bbl/d)",
		    		"GROSS_WATER (bbl/d)","GROSS_WET_GAS (mscf/d)","GROSS_SALES_GAS (mscf/d)","GROSS_CONDENSATE (bbl/d)",
		    		"GROSS_ETHANE (bbl/d)","GROSS_PROPANE (bbl/d)","GROSS_BUTANE (bbl/d)","GROSS_NGL (bbl/d)","GROSS_BOE (boe/d)",
		    		"GAS_EQUIVALENT_RATE (mscf/d)","NRI_OIL (%)","NRI_GAS (%)","NRI_NGL (%)","ROYALTY (%)","WI (%)"};

		    	for(int i=0; i<cols.length; i++) {
		    		 
				    try {
					    if(PerformOperation.wrn_Present(PropertiesFile.tableColumns(driver, cols[i]))==true) {
					    	System.out.println(cols[i]+" is displayed");
							test.log(LogStatus.PASS, cols[i]+" is displayed");
							test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot(cols[i]+" is displayed")));
					    }}catch(Exception e) {
					    	System.out.println(cols[i]+" is not displayed");
							test.log(LogStatus.FAIL, cols[i]+" is not displayed");
							test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot(cols[i]+" is not displayed")));
					    }
		    	}
		    	
		    	 try {
					    if(PerformOperation.wrn_Present(PropertiesFile.tableData(driver))==true) {
					    	System.out.println("Data is displayed in the datatable");
							test.log(LogStatus.PASS, "Data is displayed in the datatable");
							test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Data is displayed in the datatable")));
					    }}catch(Exception e) {
					    	System.out.println("Data is not displayed in the datatable");
							test.log(LogStatus.FAIL, "Data is not displayed in the datatable");
							test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Data is not displayed in the datatable")));
					    }
		    	 
		    	 driver.close();
		    	 PerformOperation.wait(2);
		    	 driver.switchTo().window(tabs.get(0));
		    	 PerformOperation.wait(2);
		    	 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
