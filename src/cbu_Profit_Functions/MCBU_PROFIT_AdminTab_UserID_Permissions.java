package cbu_Profit_Functions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import cbu_Profit_ObjectProperties.PropertiesFile;
import cbu_Profit_OperationsSupport.PerformOperation;
import cbu_Profit_ExternalDataSource.Input_DataSource;

public class MCBU_PROFIT_AdminTab_UserID_Permissions extends cbu_Profit_DriverScript.Driver_Script {
	static ExtentReports report =cbu_Profit_DriverScript.Driver_Script.report;
	static ExtentTest test =cbu_Profit_DriverScript.Driver_Script.test;
	private static Sheet inputSheet;
	
public static void VerifytheAdminTabUserIDPermissions() throws Exception  {
	test = report.startTest("Test Execution Started in -----> Verify the AdminTab-UserID-Permissions");
try { 	
	inputSheet = Input_DataSource.testData(Input_DataSource.CBUTestData, "MCBUPROFITTestdata"); 
  	String actAddNewPermissionstext = inputSheet.getCell(0,1).getContents().trim();
  	
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
	PerformOperation.wait(10);
	String [] actdropdownvalues = {"Outlook x+y","Business Plan"};
	PerformOperation.wait(1);
	test.log(LogStatus.INFO, "Validate the Delete UserId");
	//Delete all ForecastType userid's
	for(int i=0; i<actdropdownvalues.length; i++){
		PerformOperation.link_Click(PropertiesFile.Profit_Forecasttypedefaultname(driver));
		PerformOperation.wait(1);
		if(PerformOperation.wrn_Present(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[i]))) {
		   PerformOperation.link_Click(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[i]));
		   PerformOperation.wait(2);
		   MCBU_PROFIT_AdminTab_UserID_Permissions.deleteuserID();
		   PerformOperation.wait(1);
		}
	}
	PerformOperation.wait(5);
	PerformOperation.link_Click(PropertiesFile.Profit_Forecasttypedefaultname(driver));
	test.log(LogStatus.PASS, "Click ForecastType Dropdown button");
	PerformOperation.wait(2);
	//verifying all ForecastType's
	for(int i=0; i<actdropdownvalues.length; i++){
		if(PerformOperation.wrn_Present(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[i]))) {
		   PerformOperation.wait(1);
		   System.out.println("ForecastType Dropdown Values '"+actdropdownvalues[i]+"' is displayed");
		   test.log(LogStatus.PASS, "ForecastType Dropdown Values - "+actdropdownvalues[i]);
		} else{
		   System.out.println("ForecastType Dropdown Values are not displayed :"+actdropdownvalues[i]);
		   test.log(LogStatus.FAIL, "ForecastType Dropdown Values are not displayed :"+actdropdownvalues[i]);
		   test.log(LogStatus.FAIL,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("ForecastType Dropdown Values")));
		}	
	}
	test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("ForecastType Dropdown Values")));
	PerformOperation.link_Click(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[0]));
	PerformOperation.wait(1);
	PerformOperation.link_Click(PropertiesFile.Profit_PermissiAddUser(driver));
	test.log(LogStatus.PASS, "Click ADDUser button");
	PerformOperation.wait(2);
	//POUPtext verifying
	if (PerformOperation.wrn_Present(PropertiesFile.Profit_Permissionuserpopup(driver))) {
		String expAddNewPermissionstext = PerformOperation.getText_Display(PropertiesFile.Profit_Permissionuserpopup(driver));
		System.out.println("User has been added Notification displayed successfully " + expAddNewPermissionstext);
		if(expAddNewPermissionstext.trim().equalsIgnoreCase(actAddNewPermissionstext)) {
			test.log(LogStatus.PASS, "AddNewPermissions POPUP Text:: " +actAddNewPermissionstext+ "is present");
		}else {
			test.log(LogStatus.FAIL, "AddNewPermissions POPUP Text:: " +actAddNewPermissionstext+ "is not present");
			test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("AddNewPermissions")));
		}
		PerformOperation.link_Click(PropertiesFile.Profit_POPUPcancelbutton(driver));
		test.log(LogStatus.PASS, "Click Cancel Button");
	} else {
		test.log(LogStatus.FAIL, "AddNewPermissions POPUP Text is not displayed");
	}
	PerformOperation.wait(3);
	test.log(LogStatus.INFO, "Validate the Adding UserId");
	///adding all Forecast type-UserID
	for(int i=0; i<actdropdownvalues.length; i++){
		PerformOperation.link_Click(PropertiesFile.Profit_Forecasttypedefaultname(driver));
		test.log(LogStatus.PASS, "Click ForecastType Dropdown button");
		PerformOperation.wait(2);
		if(PerformOperation.wrn_Present(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[i]))) {
		   PerformOperation.link_Click(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[i]));
		   PerformOperation.wait(1);
		   test.log(LogStatus.PASS, "Selected ForecastType Dropdown Value:: - "+actdropdownvalues[i]);
		   PerformOperation.link_Click(PropertiesFile.Profit_PermissiAddUser(driver));
		   test.log(LogStatus.PASS, "Click ADDUser button");
		   PerformOperation.wait(2);
		   MCBU_PROFIT_AdminTab_UserID_Permissions.Add_userID("PROFIT Admins");
		   try {
			 if(PerformOperation.wrn_Present(PropertiesFile.Profit_addedNotificationpopup(driver))) {
				System.out.println("User has been added Notification displayed successfully ");
				test.log(LogStatus.PASS, "User has been added  Notification displayed successfully");
				test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("User has been added Notification"))); 
			}
		   } catch(Exception e) {
			  System.out.println("User has been added Notification is not displayed");
		   }
		   PerformOperation.wait(2);
		}
	}
	PerformOperation.wait(3);
	MCBU_PROFIT_AdminTab_UserID_Permissions.Search_UserID();
	PerformOperation.wait(3);
	test.log(LogStatus.INFO, "Vallidating Edit Permission");
	//Changes-User ID
	for(int i=0; i<actdropdownvalues.length; i++){
		PerformOperation.link_Click(PropertiesFile.Profit_Forecasttypedefaultname(driver));
		test.log(LogStatus.PASS, "Click ForecastType Dropdown button");
		PerformOperation.wait(2);
		if(PerformOperation.wrn_Present(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[i]))) {
		   PerformOperation.link_Click(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, actdropdownvalues[i]));
		   PerformOperation.wait(1);
		   test.log(LogStatus.PASS, "Selected ForecastType Dropdown Value:: - "+actdropdownvalues[i]);
		   PerformOperation.link_Click(PropertiesFile.Profit_Editbutton(driver));
		   test.log(LogStatus.PASS, "Click Edit button");
		   PerformOperation.wait(2);
		   MCBU_PROFIT_AdminTab_UserID_Permissions.EditChnages_UserID("Commercial Team");
		   PerformOperation.wait(2);
		}
	}
	PerformOperation.wait(3);
	test.log(LogStatus.INFO, "Validating existing UserId");
	//existing user id checking
	PerformOperation.link_Click(PropertiesFile.Profit_PermissiAddUser(driver));
	test.log(LogStatus.PASS, "Click ADDUser button");
	PerformOperation.wait(2);
	MCBU_PROFIT_AdminTab_UserID_Permissions.Add_userID("PROFIT Admins");
	PerformOperation.wait(1);
	if(PerformOperation.wrn_Present(PropertiesFile.Profit_existingaddedNotificationpopuperror(driver))) {
		test.log(LogStatus.PASS, "User already exists in PROFIT");
		test.log(LogStatus.PASS, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("User already exists in PROFIT")));
		PerformOperation.wait(1);
		PerformOperation.link_Click(PropertiesFile.Profit_existingaddedNotificationpopuperror(driver));
	}else {
		test.log(LogStatus.FAIL, "User already exists in PROFIT");
		test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("User already exists in PROFIT")));
	}
	PerformOperation.wait(3);
	test.log(LogStatus.INFO, "Validating UserAccess Reviewdate");
	///verifying update review status
	if(PerformOperation.wrn_Present(PropertiesFile.Profit_updateuseraccessreviewbutton(driver))) {
		PerformOperation.link_Click(PropertiesFile.Profit_updateuseraccessreviewbutton(driver));
		test.log(LogStatus.PASS, "Click Update user access reviewdate  button");
		PerformOperation.wait(2);
		if(PerformOperation.wrn_Present(PropertiesFile.Profit_updateuseraccessreviewsubmitbutton(driver))) {
		   PerformOperation.link_Click(PropertiesFile.Profit_updateuseraccessreviewsubmitbutton(driver));
		   PerformOperation.wait(1);
		   try {
			 if(PerformOperation.wrn_Present(PropertiesFile.Profit_UserAccessReviewDateNotification(driver))) {
				System.out.println("User Access Review Date updated Notification displayed successfully ");
				test.log(LogStatus.PASS, "User Access Review Date updated Notification displayed successfully");
				test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("User Access Review Date updated Notification"))); 
			 }
		   } catch(Exception e) {
			  System.out.println("User Access Review Date updated Notification is not displayed");
		   }
		}
		if(PerformOperation.wrn_Present(PropertiesFile.Profit_Permisionslastreviewstatus(driver))) {
			System.out.println("Permissions Last Reviewed is present");
			test.log(LogStatus.PASS, "Permissions Last Reviewed is present");
		}else {
			test.log(LogStatus.FAIL, "Permissions Last Reviewed is Not present");
			test.log(LogStatus.FAIL, test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Permissions Last Reviewed")));
		}
	} else {
		test.log(LogStatus.FAIL, "Update user access reviewdate is Not present");
	}
} catch(Exception e) {
	test.log(LogStatus.FAIL, "Test Execution Status - Verify the AdminTab-UserID-Permissions");           	
}
  report.endTest(test);
  report.flush();
}

public static void deleteuserID() throws InterruptedException {
  String username = System.getProperty("user.name").toUpperCase();
  Actions actions1 = new Actions(driver);
  actions1.moveToElement(PropertiesFile.Profit_PermissionsTableColName(driver, "CAI")).build().perform();
  PerformOperation.link_Click(PropertiesFile.Profit_PermissionsTableColName(driver, "CAI"));
  PerformOperation.wait(2);
  if(PerformOperation.wrn_Present(PropertiesFile.Profit_ColSubMenu_Filter(driver))) {
	 PerformOperation.link_Click(PropertiesFile.Profit_ColSubMenu_Filter(driver));
	 PerformOperation.wait(2);
     List<WebElement> usernames = driver.findElements(By.xpath("//li[contains(@class,'k-state-border-right')]//div[@class='k-filterable k-content']//li"));
  	 System.out.println("num::"+usernames.size());
  	 PerformOperation.wait(2);
  	 for (int i=1;i<usernames.size();i++) {
  		 String actval1 = usernames.get(i).getText();
  		 if (actval1.equalsIgnoreCase(username)) {
  			 PerformOperation.wait(1);
  			 //actions1.moveToElement(PropertiesFile.Profit_PermissionsTableuserid(driver,username)).click().build().perform();
  			 PerformOperation.link_Click(PropertiesFile.Profit_PermissionsTableuserid(driver,username));
  			 PerformOperation.wait(3);
  			 PerformOperation.link_Click(PropertiesFile.Profit_ColSubMenu_Filterbutton(driver));
  			 PerformOperation.wait(5);
  			 if(PerformOperation.wrn_Present(PropertiesFile.Profit_Deletebutton(driver))) {
  			    PerformOperation.link_Click(PropertiesFile.Profit_Deletebutton(driver));
  			    PerformOperation.wait(5);
  			    driver.switchTo().alert().accept();
			    PerformOperation.wait(5);
			    try {
					 if(PerformOperation.wrn_Present(PropertiesFile.Profit_deletedNotificationpopup(driver))) {
						System.out.println("User permissions have been deleted Notification displayed successfully ");
						test.log(LogStatus.PASS, "User permissions have been deleted Notification displayed successfully");
						test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("User permissions have been deleted Notification"))); 
					 }
			    } catch(Exception e) {
			    	System.out.println("User permissions have been deleted Notification is not displayed");
				}
			    PerformOperation.wait(4);
			    Actions actions2 = new Actions(driver);
			    actions2.moveToElement(PropertiesFile.Profit_PermissionsTableColName(driver, "CAI")).build().perform();
			    PerformOperation.link_Click(PropertiesFile.Profit_PermissionsTableColName(driver, "CAI"));
			    //PerformOperation.wait(2);
			    Actions actions3 = new Actions(driver);
			    actions3.moveToElement(PropertiesFile.Profit_ColSubMenu_Filter(driver)).build().perform();
			    //PerformOperation.link_Click(PropertiesFile.Profit_ColSubMenu_Filter(driver));
			    PerformOperation.wait(3);
			    PerformOperation.link_Click(PropertiesFile.Profit_ColSubMenu_clearbutton(driver));
			    PerformOperation.wait(5);
  			 }
  			 break;
  	     }
  	 }
   } else {
 	  System.out.println("Vertical FilterMenu Dropdown is not displayed");
 	  test.log(LogStatus.PASS, "Vertical FilterMenu Dropdown is not displayed");
   }
}

public static void Add_userID(String TeamddName) throws InterruptedException {
	try {
		String username = System.getProperty("user.name").toUpperCase();
		if (PerformOperation.wrn_Present(PropertiesFile.Profit_Permissionuserpopup(driver))) {
			PerformOperation.eb_EnterValue(PropertiesFile.Profit_PermissionuserpopupUserCAI(driver), username);
			test.log(LogStatus.PASS, "Enter User-CAI Comments");
			PerformOperation.wait(2);
			PerformOperation.link_Click(PropertiesFile.Profit_PopupUserCAIvalidate(driver));
			test.log(LogStatus.PASS, "Click Validate button");
			PerformOperation.wait(2);
			PerformOperation.link_Click(PropertiesFile.Profit_PopupUserCAITeam(driver));
			test.log(LogStatus.PASS, "Click Team button");
			PerformOperation.wait(2);
			if(PerformOperation.wrn_Present(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, TeamddName))) {
			   PerformOperation.link_Click(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, TeamddName));
			}
			PerformOperation.wait(2);
			PerformOperation.link_Click(PropertiesFile.Profit_POPUPCreatechekbox(driver));
			test.log(LogStatus.PASS, "Click Create/Upload checkbox");
			test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("Added Data was updated POPUP")));
			if (PerformOperation.value_IsEnabled(PropertiesFile.Profit_POPUPokbutton(driver))) {
				PerformOperation.link_Click(PropertiesFile.Profit_POPUPokbutton(driver));
				test.log(LogStatus.PASS, "Click Ok Button");
			}
		} else {
			test.log(LogStatus.FAIL, "AdduserName POPUP is not displayed");
		}
	} catch(Exception e) {
	   System.out.println("AdduserName POpUp is not displayed");
	   test.log(LogStatus.FAIL, "AdduserName POPUp is not displayed");
	}
}

public static void Search_UserID() throws InterruptedException {
	  String username = System.getProperty("user.name").toUpperCase();
	  Actions actions1 = new Actions(driver);
	  actions1.moveToElement(PropertiesFile.Profit_PermissionsTableColName(driver, "CAI")).build().perform();
	  PerformOperation.link_Click(PropertiesFile.Profit_PermissionsTableColName(driver, "CAI"));
	  PerformOperation.wait(2);
	  if(PerformOperation.wrn_Present(PropertiesFile.Profit_ColSubMenu_Filter(driver))) {
		 PerformOperation.link_Click(PropertiesFile.Profit_ColSubMenu_Filter(driver));
		 test.log(LogStatus.PASS, "Click Filter button");
		 PerformOperation.wait(2);
	     List<WebElement> usernames = driver.findElements(By.xpath("//li[contains(@class,'k-state-border-right')]//div[@class='k-filterable k-content']//li"));
	  	 System.out.println("num::"+usernames.size());
	  	 PerformOperation.wait(2);
	  	 for (int i=1;i<usernames.size();i++) {
	  		 String actval1 = usernames.get(i).getText();
	  		 if (actval1.equalsIgnoreCase(username)) {
	  			 PerformOperation.wait(1);
	  			 //actions1.moveToElement(PropertiesFile.Profit_PermissionsTableuserid(driver,username)).click().build().perform();
	  			 PerformOperation.link_Click(PropertiesFile.Profit_PermissionsTableuserid(driver,username));
	  			 PerformOperation.wait(1);
	  			 PerformOperation.link_Click(PropertiesFile.Profit_ColSubMenu_Filterbutton(driver));
	  			 PerformOperation.wait(5);
	  			 break;
	  	     }
	  	 }
	   } else {
	 	  System.out.println("Vertical FilterMenu Dropdown is not displayed");
	 	  test.log(LogStatus.PASS, "Vertical FilterMenu Dropdown is not displayed");
	   }
}

public static void EditChnages_UserID(String TeamddName) {
	try {
		if (PerformOperation.wrn_Present(PropertiesFile.Profit_PopupUseEditrCAITeam(driver))) {
			PerformOperation.link_Click(PropertiesFile.Profit_PopupUseEditrCAITeam(driver));
			test.log(LogStatus.PASS, "Click Edit-Team button");
			PerformOperation.wait(2);
			if(PerformOperation.wrn_Present(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, TeamddName))) {
			   PerformOperation.link_Click(PropertiesFile.Profit_PermissionSubMenu_drpDwnvalues(driver, TeamddName));
			}
			PerformOperation.wait(2);
			PerformOperation.link_Click(PropertiesFile.Profit_POPUPApprovechekbox(driver));
			test.log(LogStatus.PASS, "Click Approve checkbox");
			test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("chnages Data was updated POPUP")));
			PerformOperation.wait(2);
			if (PerformOperation.value_IsEnabled(PropertiesFile.Profit_POPUPEdit_okbutton(driver))) {
				PerformOperation.link_Click(PropertiesFile.Profit_POPUPEdit_okbutton(driver));
				test.log(LogStatus.PASS, "Click ok button");
			}
		} else {
			test.log(LogStatus.FAIL, "AdduserName POPUP is not displayed");
		}
		try {
			if(PerformOperation.wrn_Present(PropertiesFile.Profit_updatedNotificationpopup(driver))) {
				System.out.println("User permissions have been updated Notification displayed successfully ");
				test.log(LogStatus.PASS, "User permissions have been updated Notification displayed successfully");
				test.log(LogStatus.PASS,test.addScreenCapture(cbu_Profit_ExternalDataSource.ScreenShots.getScreenshot("User permissions have been updated Notification"))); 
			}
		 } catch(Exception e) {
		   System.out.println("User permissions have been updated Notification is not displayed");
	     }
	} catch(Exception e) {
	   System.out.println("AdduserName POpUp is not displayed");
	   test.log(LogStatus.FAIL, "AdduserName POpUp is not displayed");
	}
}

}
