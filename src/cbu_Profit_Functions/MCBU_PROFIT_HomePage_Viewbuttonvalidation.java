package cbu_Profit_Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import cbu_Profit_ObjectProperties.PropertiesFile;
import cbu_Profit_OperationsSupport.PerformOperation;

public class MCBU_PROFIT_HomePage_Viewbuttonvalidation extends cbu_Profit_DriverScript.Driver_Script {
	static ExtentReports report =cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test =cbu_Profit_DriverScript.Driver_Script.test;
	private static String parentWinHandle = null;
	private static int exprownum;
	
@SuppressWarnings("unlikely-arg-type")
public static void VerifytheDevelopmentViewbuttonvalidation() throws Exception  {
	test = report.startTest("Test Execution Started in -----> Verify the hierarchyTree Development Viewbutton validation");
try {
	parentWinHandle = driver.getWindowHandle();
    System.out.println("Parent window handle: " + parentWinHandle);
    
    String Name1 = "CBU";
    String Name2 = "MGS East Kaybs (D2)";
    String Name3 = "EK Fox Creek South";
    String Name4 = "PAD022106219W500";
    
   
    String ActualhierarchyTree= Name1+"_"+Name2+"_"+Name3+"_"+Name4;
    System.out.println("Actual hierarchyTree Values in Order of::"+ActualhierarchyTree);
    test.log(LogStatus.INFO,"Actual hierarchyTree Values in Order of "+ActualhierarchyTree);
    
    PerformOperation.scrollToElement(PropertiesFile.Profit_ProfitHomePage(driver));
    PerformOperation.link_Click(PropertiesFile.Profit_HomePagedd(driver));
   	test.log(LogStatus.PASS, "Click Homepage dropdown Button");
   	PerformOperation.wait(2);
   	PerformOperation.link_Click(PropertiesFile.Profit_POPUPTeamSubMenu_drpDwnvalues(driver, "DEVELOPMENT"));
   	test.log(LogStatus.PASS, "Click DEVELOPMENT dropdown Button");
   	PerformOperation.wait(8);
    try {	
     List<WebElement> usernames = driver.findElements(By.xpath("//div[@id='treeview']//span[starts-with(@class,'k-icon')]//following-sibling::span"));
     System.out.println("num::"+usernames.size());
     PerformOperation.wait(2);
     for (int i=0;i<usernames.size();i++) {
	   String actval1 = usernames.get(i).getText();
	   System.out.println("name::"+actval1);
	   if (actval1.equals(Name2)) {
		   exprownum =i+1;
		   break;
	   }
     }
    }catch(Exception e) {
 	 e.printStackTrace();
    }
    PerformOperation.wait(2); 
	for (int i=0;i<=1;i++) {
		 String treename  = driver.findElement(By.xpath("(//div[@id='treeview']//span[starts-with(@class,'k-icon')])["+(exprownum+i)+"]//following-sibling::span")).getText();
		 if (treename.equals(Name2) || (treename.equals(Name3))) {
			 driver.findElement(By.xpath("(//div[@id='treeview']//span[starts-with(@class,'k-icon')])["+(exprownum+i)+"]")).click();
			 test.log(LogStatus.PASS, "Click on Expand::" +treename+ "hierarchyTree icon");
			 PerformOperation.wait(2);
		 }
	}
	PerformOperation.wait(2);
	String treenamefinal  = driver.findElement(By.xpath("//li[@id='treeview_tv_active']//div[@class='k-top']//span[starts-with(@class,'k-in')]//div[1]")).getText();
	if (treenamefinal.equals(Name4)) {
		driver.findElement(By.xpath("//li[@id='treeview_tv_active']//div[@class='k-top']//span[starts-with(@class,'k-in')]//div[1]")).click();
		PerformOperation.wait(2);
		test.log(LogStatus.PASS, "Click on Expand::" +treenamefinal+ "hierarchyTree icon");
		test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Development HierarchyTree")));
	} else {
		test.log(LogStatus.FAIL, "Click on Expand::" +treenamefinal+ "hierarchyTree icon");	
    }
	PerformOperation.wait(10);
	WebElement ForecastTypeFirstrow = driver.findElement(By.xpath("//div[@id='#vm']//div[@class='k-grid-content k-auto-scrollable']//tr[1]//td[1]"));
    if (ForecastTypeFirstrow.isDisplayed()) {
    	PerformOperation.link_Click(ForecastTypeFirstrow);
    	PerformOperation.wait(1);
    	if (PerformOperation.value_IsEnabled(PropertiesFile.Profit_HomePage_Viewmenu(driver))) {
			PerformOperation.link_Click(PropertiesFile.Profit_HomePage_Viewmenu(driver));
			test.log(LogStatus.PASS, "Click View Button");
		}
     }
     PerformOperation.wait(50);
	 try {
	    Set <String> winHandles = driver.getWindowHandles();
	    for(String handle: winHandles){
	       if(!handle.equals(parentWinHandle)){
	          driver.switchTo().window(handle);
	          PerformOperation.wait(30);
	          ArrayList<String>  expectedhierarchyTree = getColumnValuestabGrid(Name1,Name2,Name3,Name4);
	          String expectedhierarchyTree1 = expectedhierarchyTree.get(0)+"_"+expectedhierarchyTree.get(1)+"_"+expectedhierarchyTree.get(2)+"_"+expectedhierarchyTree.get(3);
	          System.out.println("Expected hierarchyTree Values in Order of::"+expectedhierarchyTree1);
	          test.log(LogStatus.INFO,"Expected hierarchyTree Values in Order of "+expectedhierarchyTree1);
	          if(expectedhierarchyTree1.equals(ActualhierarchyTree)) {
	  			test.log(LogStatus.PASS, "DevelopmentArea HierarchyTree:: " +expectedhierarchyTree1+ " is displayed successfully in OtherWindow");
	  			test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("HierarchyTree")));
	  		  }else {
	  			test.log(LogStatus.FAIL, "DevelopmentArea hierarchyTree:: " +expectedhierarchyTree1+ "is not displayed successfully in OtherWindow");
	  			test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("HierarchyTree")));
	  	  	  }
	          //window close
	    	  driver.close();
	    	  PerformOperation.wait(5);
	       }
	    }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
    //Switching the control back to parent window
    driver.switchTo().window(parentWinHandle);
    System.out.println("Parent window URL: " + driver.getCurrentUrl());
    PerformOperation.wait(5);
} catch(Exception e) {
	test.log(LogStatus.FAIL, "Test Execution Status - Verify the hierarchyTree Development Viewbutton validation");           	
}
 report.endTest(test);
 report.flush();
}

public static ArrayList<String> getColumnValuestabGrid(String Name1,String Name2,String Name3,String Name4) {
	ArrayList<String> colValues = new ArrayList<String>();
	List<WebElement> usernames1 = driver.findElements(By.xpath("//div[@id='treeview-forecast-details']//span[contains(@class,'wrapper')]/following-sibling::span"));
    System.out.println("num::"+usernames1.size());
    String values = "";
    for (int i=0;i<usernames1.size();i++) {
	    String data = usernames1.get(i).getText();
	    if (data.equals(Name1) || (data.equals(Name2)) || (data.equals(Name3)) || (data.equals(Name4))) {
		   values = values+"_"+data;
		   System.out.println(data);
		   colValues.add(data);
	    }
    }
    return colValues;
}


}