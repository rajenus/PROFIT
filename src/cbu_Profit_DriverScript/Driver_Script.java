package cbu_Profit_DriverScript;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import cbu_Profit_ActionsCall.ActionsCall;
import cbu_Profit_ExternalDataSource.ExcelReportCreate;
import cbu_Profit_ExternalDataSource.Input_DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver_Script {
	static String keyword = "";
	static String status = "";
	public static WebDriver driver;
	public static String filepath;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String appUrl;
	public static String workingDir;
	public static String user;
	public static String workDirectory;
	

	@Parameters("browser")
	@Test (testName = "DriverScript")
	public static void mcbuApplication(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Edge")) {
			report = new ExtentReports(".\\ExtentReports\\AutomationReport_" + browser + "_"
					+ new SimpleDateFormat("dd-MM-yy.HH.mm.ss").format(new Date()) + ".html", true);
			test = report.startTest("Test Execution Started in -----> " + browser + " - Browser");
			String exePath = ".\\EdgeDriver\\MicrosoftWebDriver.exe";
			System.setProperty("webdriver.edge.driver", exePath);
			driver = new EdgeDriver();	
			workingDir = System.getProperty("user.dir");
			workDirectory= System.getProperty("user.dir");
			user=System.getProperty("user.name");
			//String filepath = workingDir;
			Sheet appUrl_Collect = Input_DataSource.testData(Input_DataSource.CBUTestData, "URL");
			int appUrlrowcount = appUrl_Collect.getRows();
			System.out.println(appUrlrowcount);
			appUrl = "";
			appUrl = appUrl_Collect.getCell(0, 1).getContents();
			driver.getCurrentUrl();
			driver.get(appUrl);
			System.out.println("Browser- " + browser + " " + "URL -" + appUrl);
			// test.log(LogStatus.INFO, appUrl);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			filepath = ExcelReportCreate.columnHeader();
			test.log(LogStatus.INFO, "Application URL - " + appUrl);
			// test.log(LogStatus.INFO, browser+"- Browser Launched");
			Sheet scenario = Input_DataSource.testData(Input_DataSource.CBUTestData, "Scenario");
			int scenarioRowCount = scenario.getRows();
			String filepath = ExcelReportCreate.columnHeader();
			driver.manage().window().maximize();
			//PerformOperation.wait(10);
			for (int i = 1; i < scenarioRowCount; i++) {

				keyword = scenario.getCell(1, i).getContents();
				status = scenario.getCell(2, i).getContents();
				if (status.equalsIgnoreCase("yes")) {
					System.out.println("Scenario -" + keyword);
					Reporter.log("Scenario -" + keyword);

					test.log(LogStatus.INFO, "Scenario -----> " + keyword);
					ActionsCall.operationCalls(keyword, filepath);
				}

			}
			driver.close();
			driver.quit();
			report.endTest(test);
			report.flush();
		}
	else if(browser.equalsIgnoreCase("Chrome"))

	{
		report = new ExtentReports(".\\ExtentReports\\AutomationReport_" + browser + "_"
				+ new SimpleDateFormat("dd-MM-yy.HH.mm.ss").format(new Date()) + ".html", true);
		test = report.startTest("Test Execution Started in -----> " + browser + " - Browser");
		String exePath = ".\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        //prefsMap.put("download.default_directory",downloadPath);
        prefsMap.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
        prefsMap.put("download.prompt_for_download", false);
        
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", prefsMap);
        option.addArguments("--test-type");
        option.addArguments("--disable-extensions");
        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, option);
        driver = new ChromeDriver(option);
        //PerformOperation.wait(5);
        driver.manage().deleteAllCookies();

		//PerformOperation.wait(5);
		workingDir = System.getProperty("user.dir");
		workDirectory= System.getProperty("user.dir");
		user=System.getProperty("user.name");
		Sheet appUrl_Collect = Input_DataSource.testData(Input_DataSource.CBUTestData, "URL");
		int appUrlrowcount = appUrl_Collect.getRows();
		System.out.println(appUrlrowcount);
		String appUrl = "";
		appUrl = appUrl_Collect.getCell(0, 1).getContents();
		//PerformOperation.wait(5);
		driver.getCurrentUrl();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Browser- " + browser + " " + "URL -" + appUrl);
		//PerformOperation.wait(5);
		filepath = ExcelReportCreate.columnHeader();
		test.log(LogStatus.INFO, "Application URL - " + appUrl);
		// test.log(LogStatus.INFO, browser+"- Browser Launched");
		Sheet scenario = Input_DataSource.testData(Input_DataSource.CBUTestData, "Scenario");
		int scenarioRowCount = scenario.getRows();
		String filepath = ExcelReportCreate.columnHeader();
		driver.manage().window().maximize();
		//PerformOperation.wait(10);
		for (int i = 1; i < scenarioRowCount; i++) {

			keyword = scenario.getCell(1, i).getContents();
			status = scenario.getCell(2, i).getContents();
			if (status.equalsIgnoreCase("yes")) {
				System.out.println("Scenario -" + keyword);
				Reporter.log("Scenario -" + keyword);

				test.log(LogStatus.INFO, "Scenario -----> " + keyword);
				ActionsCall.operationCalls(keyword, filepath);
				}

			}
		driver.close();
		driver.quit();
		report.endTest(test);
		report.flush();
		}

	}
}
