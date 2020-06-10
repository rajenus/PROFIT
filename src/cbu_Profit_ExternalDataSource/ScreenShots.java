package cbu_Profit_ExternalDataSource;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenShots {
	static WebDriver driver = cbu_Profit_DriverScript.Driver_Script.driver;
	static String filepath = cbu_Profit_DriverScript.Driver_Script.filepath;
	static ExtentReports report = cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test = cbu_Profit_DriverScript.Driver_Script.test;

	public static String getScreenshot(String info) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names 
        String dateName = new SimpleDateFormat("dd-MM-yy.HH.mm.ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/Screenshot/"+info+dateName+".jpg";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
         return destination;
	}

}
/*
 * File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 * FileUtils.copyFile(scrFile1, new File(".\\Screenshot\\ALUpload_"+new
 * SimpleDateFormat("dd-MM-yy.HH.mm.ss").format(new Date())+".jpg"));
 */