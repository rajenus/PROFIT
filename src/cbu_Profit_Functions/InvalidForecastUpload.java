package cbu_Profit_Functions;

import org.openqa.selenium.JavascriptExecutor;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cbu_Profit_ObjectProperties.PropertiesFile;
import cbu_Profit_OperationsSupport.PerformOperation;

public class InvalidForecastUpload extends cbu_Profit_DriverScript.Driver_Script {
	 
	static ExtentReports report =cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test =cbu_Profit_DriverScript.Driver_Script.test;
	
    static String OXY[] = {"Row 4:  The date provided does not match the correct format (Mmm YYYY) or (Mmm-YY)","Row 4: Raw Gas must be a number or \"-\"","Row 4: Propane must be a number or \"-\"",
    		"Row 4: Condensate Inflow Potential must be a number or \"-\"","Row 5: Sales Gas must be a number or \"-\"","Row 5: Ethane must be a number or \"-\"",
    		"Row 5: Butane must be a number or \"-\"","Row 5: Oil must be a number or \"-\"","Row 5: Gas Inflow Potential must be a number or \"-\"",
    		"Row 5: Royalty must be a positive number >= 0 and <= 100","Row 6: Condensate must be a number or \"-\"","Row 6: Water must be a number or \"-\"",
    		"Row 6: Oil Inflow Potential must be a number or \"-\"","Row 7: Equivalent Volume must be a number or \"-\"","Row 7: Gas Equivalent Rate must be a number or \"-\"",
    		"Row 7: WI must be a positive number >= 0 and <= 100"};
    
    static String BP[] = {"Row 4:  The date provided does not match the correct format (Mmm YYYY) or (Mmm-YY)","Row 4: Raw Gas must be a number or \"-\"","Row 4: Ethane must be a number or \"-\"",
    		"Row 4: Water must be a number or \"-\"","Row 4: Condensate Inflow Potential must be a number or \"-\"","Row 4: WI must be a positive number >= 0 and <= 100",
    		"Row 5: Sales Gas must be a number or \"-\"","Row 5: Butane must be a number or \"-\"","Row 5: Oil must be a number or \"-\"","Row 6: Propane must be a number or \"-\"",
    		"Row 6: Condensate must be a number or \"-\"","Row 6: Oil Inflow Potential must be a number or \"-\"","Row 6: Gas Equivalent Rate must be a number or \"-\"",
    		"Row 7: Equivalent Volume must be a number or \"-\"","Row 7: Gas Inflow Potential must be a number or \"-\"","Row 7: Royalty must be a positive number >= 0 and <= 100"};
    
    
    
	public static void actionCall() throws Exception {
		test = report.startTest("Test Execution Started in -----> Forecast Upload Error Validation");
		uploadForecastNeg(workDirectory+"\\Keyword\\Negative test data for CBU Outlook xy-Upload.xlsx", "Outlook x+y", "2017", "TestQA", "TestQA", user, "P10", OXY);
		uploadForecastNeg(workDirectory+"\\Keyword\\Negative Test data for Business plan-Upload.xlsx", "Business Plan", "2017", "TestQA", "TestQA", user, "P10", BP);
		report.endTest(test);
		report.flush();
	}
	
	public static void uploadForecastNeg(String filePath,String forecastType,String reportingPeriod,String project,String assumption,String author,String percentileCase, String errArr[]) throws Exception {
        try {
        String forecastProject = project;
        String forecastAssumption =assumption;
        String forecastAuthor =author; 
        PerformOperation.wait(5);
        PerformOperation.link_Click(PropertiesFile.profit_menu_UploadForecast(driver));
        PerformOperation.wait(2);
        PerformOperation.link_Click(PropertiesFile.profit_upload_forecastTypeDD(driver));
        PerformOperation.wait(2);
        PerformOperation.link_Click(PropertiesFile.profit_upload_optionDD(driver, forecastType));
        PerformOperation.wait(2);
        test.log(LogStatus.INFO, "Forecast Type: "+forecastType);
        PerformOperation.link_Click(PropertiesFile.profit_upload_reportingPeriodDD(driver));
        PerformOperation.wait(1);
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
        try {
        if(PropertiesFile.profit_upload_percentileCase(driver).isEnabled()) {
               PerformOperation.link_Click(PropertiesFile.profit_upload_percentileCase(driver));
               PerformOperation.wait(1);
               PerformOperation.link_Click(PropertiesFile.profit_upload_optionDD(driver, percentileCase));
               PerformOperation.wait(1);
               test.log(LogStatus.INFO, "Percentile Case: "+percentileCase);
        }
        }catch(Exception e) {
               test.log(LogStatus.INFO, "Percentile Case has default value");
        }
        JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].style.display = 'block';", PropertiesFile.profit_upload_forecastFileUpload(driver));
		
        PerformOperation.eb_EnterValue(PropertiesFile.profit_upload_forecastFileUpload(driver), filePath);
        PerformOperation.wait(4);
      if(PerformOperation.value_IsEnabled(PropertiesFile.profit_upload_submitForecastBtn(driver))) {
//               test.log(LogStatus.PASS, "File can be successfully uploaded");
//            test.log(LogStatus.PASS,test.addScreenCapture(profit_ExternalDataSource.ScreenShots.getScreenshot("File Upload")));
            PerformOperation.link_Click(PropertiesFile.profit_upload_submitForecastBtn(driver));
            try {
      if(PropertiesFile.profit_upload_Overwrite_Popup(driver).isDisplayed()) {
      test.log(LogStatus.INFO, "Overwrite Forecast");
             PerformOperation.eb_EnterValue(PropertiesFile.profit_upload_Overwrite_Textarea(driver), "Overwrite PROFIT");
      test.log(LogStatus.INFO,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Overwrite window")));
             PerformOperation.link_Click(PropertiesFile.profit_upload_Overwrite_UploadBtn(driver));
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
        
        
        if(PropertiesFile.profit_upload_FailedReport(driver).isDisplayed()) {
               PerformOperation.link_Click(PropertiesFile.profit_upload_FailedReport(driver));
               String uploadStatus = PropertiesFile.profit_upload_FailedReport(driver).getText();
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
                     test.log(LogStatus.PASS, "File is not successfully uploaded");
                   test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("File Upload Fail")));

               }                    
        }else {
               test.log(LogStatus.FAIL, "File successfully uploaded");
            test.log(LogStatus.FAIL,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("File Upload succesful")));

        }
       
        for(int i=0; i<errArr.length; i++) {
        	try {
        	if(PropertiesFile.profit_upload_errorMsg(driver, errArr[i]).isDisplayed()) {
        		PerformOperation.scrollToObject(PropertiesFile.profit_upload_errorMsg(driver, errArr[i]), driver);
        		test.log(LogStatus.PASS, "Error Message is displayed as expected"+errArr[i]);
        	}
        	}catch(Exception e) {
        		test.log(LogStatus.FAIL, "Error Message is not displayed as expected"+errArr[i]);
        	}
        }
        
        try {
        	while(PropertiesFile.profit_upload_errorNotification(driver).isDisplayed()) {
        	PerformOperation.link_Click(PropertiesFile.profit_upload_errorNotification(driver));
        	}
        }catch(Exception e){
        	
        }
        PerformOperation.link_Click(PropertiesFile.profit_upload_closeBtn(driver));
        PerformOperation.wait(2);
        
}catch(Exception e) {
	e.printStackTrace();
}
	}
	

}
