package cbu_Profit_Functions;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cbu_Profit_ExternalDataSource.Input_DataSource;
import cbu_Profit_ObjectProperties.PropertiesFile;
import cbu_Profit_OperationsSupport.PerformOperation;

public class CBU_PROFIT_UploadForecast_BusinessPlan extends cbu_Profit_DriverScript.Driver_Script {
	static ExtentReports report =cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test =cbu_Profit_DriverScript.Driver_Script.test;
	
	
		  static  String forecastType ;
		  static  String forecastProject;
		  static  String reportingPeriod;
		  static  String forecastAuthor;
		  static  String forecastAssumption;
		  static  String percentileCase;
		 public static void uploadForecastBusinessPlan() throws Exception {
			 test = report.startTest("Test Execution Started in -----> Upload Forecast BusinessPlan");
			 try { 
				
				forecastType = "Business Plan";
			    reportingPeriod = "2018";
				forecastProject = "PROFIT Automation";
				forecastAssumption = "PROFIT auto";
				forecastAuthor = "USHD";
				percentileCase = "EV";
				String uploadFilePath = Input_DataSource.BusinessPlanUploadFilePath;
				uploadForecast(uploadFilePath,forecastType,reportingPeriod,forecastProject,forecastAssumption,forecastAuthor,percentileCase);
				navigateToForecastDetails();
				PerformOperation.wait(1);
				}catch(Exception e) {
					e.printStackTrace();
				}
			    report.endTest(test);
				report.flush();
				
			}
		 
		 
		 
		 
		 
		 
		 public static void uploadForecast(String filePath,String forecastType,String reportingPeriod,String project,String assumption,String author,String percentileCase) throws Exception {
				
				String forecastProject = project;
				String forecastAssumption =assumption;
				String forecastAuthor =author;		
				PerformOperation.link_Click(PropertiesFile.profit_menu_UploadForecast(driver));
				PerformOperation.wait(2);
				PerformOperation.link_Click(PropertiesFile.profit_upload_forecastTypeDD(driver));
				PerformOperation.wait(1);
				PerformOperation.link_Click(PropertiesFile.profit_upload_optionDD(driver, forecastType));
				PerformOperation.wait(2);
				test.log(LogStatus.INFO, "Forecast Type: "+forecastType);
				PerformOperation.link_Click(PropertiesFile.profit_upload_reportingPeriodDD(driver));
			//	PerformOperation.wait(1);
				PerformOperation.link_Click(PropertiesFile.profit_upload_optionDD(driver, reportingPeriod));
				test.log(LogStatus.INFO, "Reporting Period: "+reportingPeriod);
				PerformOperation.wait(2);
				PerformOperation.eb_EnterValue(PropertiesFile.profit_upload_forecaseProject(driver),forecastProject);
				PerformOperation.wait(1);
				test.log(LogStatus.INFO, "Forecast Project: "+forecastProject);
				PerformOperation.eb_EnterValue(PropertiesFile.profit_upload_forecastAssumption(driver),forecastAssumption);
				PerformOperation.wait(1);
				test.log(LogStatus.INFO, "Forecast Assumption: "+forecastAssumption);
				PerformOperation.eb_EnterValue(PropertiesFile.profit_upload_forecastAuthor(driver),forecastAuthor);
				PerformOperation.wait(1);
				test.log(LogStatus.INFO, "Forecast Author: "+forecastAuthor);
				
				PerformOperation.link_Click(PropertiesFile.profit_upload_ValidateBtn(driver));
				PerformOperation.wait(1);
				if(!forecastType.contentEquals("Appropriation Request (AR)")) {
					PerformOperation.link_Click(PropertiesFile.profit_upload_percentileCase(driver));
					PerformOperation.wait(1);
					PerformOperation.link_Click(PropertiesFile.profit_upload_optionDD(driver, percentileCase));
					PerformOperation.wait(1);
					test.log(LogStatus.INFO, "Percentile Case: "+percentileCase);
				}else {
					test.log(LogStatus.INFO, "Percentile Case has default value");
				}
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].style.display = 'block';", PropertiesFile.profit_upload_forecastFileUpload(driver));
				PerformOperation.eb_EnterValue(PropertiesFile.profit_upload_forecastFileUpload(driver), filePath);
				PerformOperation.wait(4);
				if(PerformOperation.value_IsEnabled(PropertiesFile.profit_upload_submitForecastBtn(driver))) {
					test.log(LogStatus.PASS, "File can be successfully uploaded");
				    test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("File Upload")));
				    PerformOperation.link_Click(PropertiesFile.profit_upload_submitForecastBtn(driver));
				    PerformOperation.wait(3);
				    try {
		            if(PropertiesFile.profit_upload_Overwrite_Popup(driver).isDisplayed()) {
		            	test.log(LogStatus.INFO, "Overwrite Forecast");
		            	PerformOperation.eb_EnterValue(PropertiesFile.profit_upload_Overwrite_Textarea(driver), "Overwrite PROFIT");
		            	test.log(LogStatus.INFO,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Overwrite window")));
		            	PerformOperation.link_Click(PropertiesFile.profit_upload_Overwrite_UploadBtn(driver));
		            	PerformOperation.wait(3);
		            	if(PropertiesFile.profit_upload_Overwrite_ConfirmationPopup(driver).isDisplayed()) {
		            		test.log(LogStatus.INFO,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Overwrite window Confirmation")));
		            		PerformOperation.link_Click(PropertiesFile.profit_upload_Overwrite_Confirmation_UploadBtn(driver));
		            		
		            	}
		            }}catch(Exception e) {
		            	test.log(LogStatus.INFO, "Overwrite Forecast is not displayed");
		            }
		            
				}else {
					test.log(LogStatus.FAIL, "File cannot  be successfully uploaded");
				    test.log(LogStatus.FAIL,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("File Upload")));

				}
				
				PerformOperation.wait(10);
				if(PropertiesFile.profit_upload_UploadedeReport(driver).isDisplayed()) {
					PerformOperation.link_Click(PropertiesFile.profit_upload_UploadedeReport(driver));
					String uploadStatus = PropertiesFile.profit_upload_UploadedeReport(driver).getText();
					String uploadCount[] = uploadStatus.split(" ");
					String uploadValue = uploadCount[1].replaceAll("[()]","");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,500)");
					try {
					  if(PropertiesFile.profit_upload_UploadedeReportPanelBar(driver).isDisplayed())
					      PerformOperation.link_Click(PropertiesFile.profit_upload_UploadedeReportPanelBar(driver));
					}catch(Exception e) {
						test.log(LogStatus.INFO, "Upload Expand button is not displayed");
					}
					if(!uploadValue.contentEquals("0")) {
						test.log(LogStatus.PASS, "File is successfully uploaded");
					    test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("File Upload")));
					    PerformOperation.link_Click(PropertiesFile.profit_uploadForecast_CloseBtn(driver));

					}			
				}else {
					test.log(LogStatus.FAIL, "File cannot  be successfully uploaded");
				    test.log(LogStatus.FAIL,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("File Upload")));

				}
				
		   }	


		public static void navigateToForecastDetails() throws Exception {
			try {
			String currentWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			for(String window:windows) {
				if(!window.equals(currentWindow)) {
					driver.switchTo().window(window);
					test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Forecast Details")));
					PerformOperation.wait(5);
					while(true) {
						try {
							if(PropertiesFile.profit_uploadForecast_expansion(driver).isDisplayed()) {
								PerformOperation.link_Click(PropertiesFile.profit_uploadForecast_expansion(driver));
							}
						}catch(Exception e) {
							 test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Well expansion")));
							 break;
						}
					}
					driver.close();
					PerformOperation.wait(7);
					driver.switchTo().window(currentWindow);
				}
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		  }


}
