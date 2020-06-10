package cbu_Profit_ObjectProperties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PropertiesFile {
	
	 	public static WebElement Profit_Factory(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//span[text()[normalize-space()='Factory']]"));
	    }
	    public static WebElement Profit_Admin(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//span[text()[normalize-space()='Admin']]"));
	    }
	    public static WebElement Profit_Adminsub_Permissions(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//a[starts-with(@class,'k-link')][text()='Permissions']"));
	    }
	    public static WebElement Profit_Permission_ExportExcel(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//a[@class='f-right'][text()='Export to Excel']"));
	    }
	    public static WebElement Profit_Forecasttypedefaultname(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//manage-permissions[@class='ng-scope ng-isolate-scope']//span[@class='k-widget k-dropdown']"));
	    }
	    public static WebElement Profit_PermissionSubMenu_drpDwnvalues(WebDriver driver, String content)
	    {
	      return driver.findElement(By.xpath("//div[@class='k-list-container k-popup k-group k-reset k-state-border-up']//li[starts-with(@class,'k-item')][text()='"+content+"']"));
	    }
	    public static WebElement Profit_PermissionsTableColName(WebDriver driver,String option)
	    {
	      return driver.findElement(By.xpath("//a[contains(text(),'"+option+"')]/preceding-sibling::a"));
	    }
	    public static WebElement Profit_PermissionsTableuserid(WebDriver driver,String option)
	    {
	      //return driver.findElement(By.xpath("//span[@class='k-item-title'][contains(text(),'"+option+"')]"));
	      return driver.findElement(By.xpath("//input[@type='checkbox'][@value='"+option+"']"));
	    	
	    }
	    public static WebElement Profit_ColSubMenu_Filter(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//span[contains(text(),'Filter')]"));
	    }
	    public static WebElement Profit_ColSubMenu_Filterbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Filter')]"));
	    }
	    public static WebElement Profit_ColSubMenu_clearbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//button[@type='reset'][contains(text(),'Clear')]"));
	    }
	    public static WebElement Profit_PermissiAddUser(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//button[@id='t-open-add-user-permission-modal-btn'])[1]"));
	    }
	    public static WebElement Profit_Deletebutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//div[@id='t-user-permissions-grid']//table//tr[1]//button[@id='t-delete-permission-btn']"));
	    }
	    public static WebElement Profit_Editbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//div[@id='t-user-permissions-grid']//table//tr[1]//button[@id='t-open-edit-permission-modal-btn']"));
	    }
	    public static WebElement Profit_Permissionuserpopup(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window']//div[@class='permissions-dialog-content relative'])[1]"));
	    }
	    public static WebElement Profit_PermissionuserpopupUserCAI(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//input[@name='cai']"));
	    }
	    public static WebElement Profit_PopupUserCAIvalidate(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@ng-if='!permissionsDialog.isEditMode'])[1]//button[@type='button']"));
	    }
	    public static WebElement Profit_PopupUserCAITeam(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window']//span[starts-with(@class,'k-widget k-dropdown')]//span[starts-with(@class,'k-icon')])[1]"));
	    }
	    public static WebElement Profit_PopupUseEditrCAITeam(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window']//span[starts-with(@class,'k-widget k-dropdown')]//span[starts-with(@class,'k-icon')])[2]"));
	    }
	    public static WebElement Profit_POPUPTeamSubMenu_drpDwnvalues(WebDriver driver, String content)
	    {
	      return driver.findElement(By.xpath("//li[starts-with(@class,'k-item')][text()='"+content+"']"));
	    }
	    public static WebElement Profit_POPUPCreatechekbox(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window'])[1]//label[@class='col-md-2']//input[1]"));
	    }
	    public static WebElement Profit_POPUPApprovechekbox(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window'])[2]//label[@class='col-md-4 k-label']//input[1]"));
	    }
	    public static WebElement Profit_POPUPokbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window']//button[@class='k-button k-button-icontext k-primary'])[1]"));
	    }
	    public static WebElement Profit_POPUPcancelbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window']//button[@class='k-button k-button-icontext'])[2]"));
	    }
	    public static WebElement Profit_POPUPEdit_okbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("(//div[@id='t-add-permission-window']//button[@class='k-button k-button-icontext k-primary'])[2]"));
	    }
	    public static WebElement Profit_updatedNotificationpopup(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='k-notification-wrap'][contains(text(),'User permissions have been updated successfully.')]"));
	    }
	    public static WebElement Profit_deletedNotificationpopup(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='k-notification-wrap'][contains(text(),'User permissions have been deleted successfully.')]"));
	    }
	    public static WebElement Profit_addedNotificationpopup(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='k-notification-wrap'][contains(text(),'User has been added successfully.')]"));
	    }
	    public static WebElement Profit_existingaddedNotificationpopuperror(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='k-notification-wrap'][contains(text(),'User already exists in PROFIT')]"));
	    }
	    public static WebElement Profit_UserAccessReviewDateNotification(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='k-notification-wrap'][contains(text(),'User Access Review Date updated successfully.')]"));
	    }
	    public static WebElement Profit_updateuseraccessreviewbutton(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//button[@id='t-open-update-permission-review-modal-btn']"));
	    }
	    public static WebElement Profit_updateuseraccessreviewsubmitbutton(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='k-widget k-window k-state-focused']//button[@type='submit']"));
	    }
	    public static WebElement Profit_Permisionslastreviewstatus(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//label[@class='ng-binding']"));
	    }
	    public static WebElement Profit_Homepagesubmenu_filter(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[starts-with(@class,'k-column-menu')]//li//span[contains(text(),'Filter by Value')]"));
	    }
	    public static WebElement Profit_Homepagesubmenu_Filterbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//span[@class='k-link k-menu-link']//button[@type='submit'][contains(text(),'Filter')]"));
	    }
	    public static WebElement Profit_HomePage_Viewmenu(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//main[@class='container-fluid body-content']//button[contains(@ng-click,'view')]"));
	    }
	    public static WebElement Profit_HomePage_exportmenu(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//main[@class='container-fluid body-content']//button[contains(@ng-click,'Export')]"));
	    }
	    public static WebElement Profit_HomePage_ExportForecastDetails(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//div[@class='grid-buttons-container ng-scope']//button[@title='Export Forecast Details']"));
	    }
	    public static WebElement Profit_HomePage_ExportForecastDetailsPOPUPOKbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//div[@id='t-adjust-forecast-window']//button[@class='k-button k-button-icontext k-primary']"));
	    }
	    public static WebElement Profit_ExportForecastDetailsverticalbutton(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//div[@class='k-splitbar k-state-default k-splitbar-vertical k-splitbar-draggable-vertical']//div[starts-with(@class,'k-icon k-collapse-prev')]"));
	    }
	    public static WebElement Profit_HomePageClearall(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//filter-indicator[@class='ng-isolate-scope']"));
	    }
	    public static WebElement Profit_HomePagedd(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//span[@class='k-widget k-dropdown full-wide hierarchy-tree-hierarchy-selector']"));
	    }
	    public static WebElement Profit_ProfitHomePage(WebDriver driver)
	    {
	      return driver.findElement(By.xpath("//a[@class='navbar-brand navbar-logo ng-binding']"));
	    }
	    //
	    public static WebElement factory(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//span[@class='k-link k-menu-link'][contains(text(),'Factory')]")); 
		}
		
		public static WebElement auditTrail(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//span[@class='k-link k-menu-link']/span[contains(text(),'Audit Trail')]")); 
		}
		
		public static WebElement forecastHistory(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//ng-transclude[contains(text(),'Forecast History')]"));
		}
		
		public static WebElement exportHistory(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//ng-transclude[contains(text(),'Export History')]"));
		}
		
		public static WebElement userTeamHistory(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//ng-transclude[contains(text(),'User Team History')]"));
		}
		
		public static WebElement okAT(WebDriver driver) 
		{
			return driver.findElement(By.xpath("(//button[@type='submit'])[5]"));
		}
		
		public static WebElement selectdd(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//span[@class='k-input']"));
		}
		
		public static WebElement menuOptions(WebDriver driver, String colName) 
		{
			return driver.findElement(By.xpath("(//th[@data-title='"+colName+"']/a/span[@class='k-icon k-i-more-vertical'])[1]"));
		}
		
		public static WebElement clearFilters(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//span[contains(@title,'click to clear all')]"));
		}
		
		public static WebElement filterByValue(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//span[contains(text(),'Filter by Value')]"));
		}
		
		public static WebElement approvedCB(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//input[@type='checkbox'][@value='Approved']"));
		}
		
		public static WebElement unApprovedCB(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//input[@type='checkbox'][@value='Unapproved']"));
		}
		
		public static WebElement confirmFilter(WebDriver driver) 
		{
			return driver.findElement(By.xpath("(//button[@type='submit'][contains(text(),Filter)])[7]"));
		}
		
		public static WebElement selectForecast(WebDriver driver) 
		{
			return driver.findElement(By.xpath("(//td[@class='k-hierarchy-cell'])[1]"));
		}
		
		public static WebElement deleteForecast(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//button[@ng-disabled='!vm.isDeleteEnabled']"));
		}
		
		public static WebElement deleteConfirm(WebDriver driver) 
		{
			return driver.findElement(By.xpath("(//div[contains(text(),'The forecast will be removed permanently')]/following::button[@ng-click='confirmation.confirm()'])[1]"));
		}
		
		public static WebElement deletedMsg(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//div[contains(text(),'Forecast Deleted')]"));
		}
		
		public static WebElement closeMsg(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//button[@ng-click='informPopup.close()']"));
		}
		
		public static WebElement compare(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//button[@ng-click='vm.toggleCompareMode()']"));
		}
		
		public static WebElement forecastMetaData(WebDriver driver, String fnum) 
		{
			return driver.findElement(By.xpath("//span[starts-with(@class,'k-link k-header')][contains(text(),'"+fnum+"')]"));
		}
		
		public static WebElement chart(WebDriver driver) 
		{
			return driver.findElement(By.xpath("//div[@kendo-stock-chart='vm.chartModel']"));
		}
		
		public static WebElement hierarchyDropDown(WebDriver driver)
		{
			return driver.findElement(By.xpath("//span[@title='Select hierarchy']"));
		}
		
		public static WebElement hierarchyDropDownOption(WebDriver driver, String option)
		{
			return driver.findElement(By.xpath("//li[starts-with(@class,'k-item')][contains(text(),'"+option+"')]"));
		}
		
		public static WebElement selectForecastCB(WebDriver driver, int num)
		{
			return driver.findElement(By.xpath("(//input[@type='checkbox'][starts-with(@class,'compare')])["+num+"]"));
		}
		
		public static WebElement viewForecast(WebDriver driver)
		{
			return driver.findElement(By.xpath("//button[@ng-click='vm.viewForecastDetails()']"));
		}
		
		public static WebElement hierarchy(WebDriver driver)
		{
			return driver.findElement(By.xpath("//ul[@class='k-group k-treeview-lines']"));
		}
		
		public static WebElement tableColumns(WebDriver driver, String colName)
		{
			return driver.findElement(By.xpath("//a[@class='k-link'][text()='"+colName+"']"));
		}
		
		public static WebElement tableData(WebDriver driver)
		{
			return driver.findElement(By.xpath("(//td[@data-field='GrossOil'])[1]"));
		}
		

		public static WebElement profit_upload_FailedReport(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//ul[@id='t-report']/li/span[contains(text(),'FAILED')]"));
	    }
	    
	    public static WebElement profit_upload_errorMsg(WebDriver driver, String errMsg)
	    {
	       return driver.findElement(By.xpath("//span[contains(text(),'"+errMsg+"')]"));
	    }

	    public static WebElement profit_upload_errorNotification(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='k-notification-wrap']"));
	    }
	    
	    
	    public static WebElement profit_menu_UploadForecast(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//a[contains(text(),'Upload Forecast')]"));
	    }
	    public static WebElement profit_upload_reportingPeriodDD(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//span[@title='Forecast Period Year is required']/span/span[2]"));
	    }
	    public static WebElement profit_upload_forecastTypeDD(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//span[@title='Forecast Type is required']/span/span[2]"));
	    }
	    public static WebElement profit_upload_constraintTypeDD(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//span[@title='Constraint Type is required']/span/span[2]"));
	    }
	    public static WebElement profit_upload_percentileCase(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//span[@title='Select an Option']/span/span[2]"));
	    }
	    public static WebElement profit_upload_optionDD(WebDriver driver,String option)
	    {
	       return driver.findElement(By.xpath("//li[contains(text(),'"+option+"')]"));
	    }
	    public static WebElement profit_upload_forecaseProject(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//textarea[@name='ForecastProject']"));
	    }
	    public static WebElement profit_upload_forecastAssumption(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//textarea[@name='ForecastAssumption']"));
	    }
	    public static WebElement profit_upload_forecastAuthor(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//input[@id='ForecastAuthor']"));
	    }
	    public static WebElement profit_upload_ValidateBtn(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//button[normalize-space()='Validate']"));
	    }
	    public static WebElement profit_upload_forecastFileUpload(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//input[@id='t-file-input']"));
	    }
	    public static WebElement profit_upload_closeBtn(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
	    }
	    public static WebElement profit_upload_submitForecastBtn(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//button[normalize-space()='Submit Forecast']"));
	    }
	    public static WebElement profit_upload_UploadedeReport(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//ul[@id='t-report']/li[1]/span"));
	    }
	    public static WebElement profit_upload_UploadedeReportPanelBar(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//span[contains(@class,'k-panelbar-expand')]"));
	    }
	    public static WebElement profit_upload_Overwrite_Popup(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//span[text()='Overwrite Forecast']"));
	    }
	    public static WebElement profit_upload_Overwrite_Textarea(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//textarea[@name='RevisionComments']"));
	    }
	    public static WebElement profit_upload_Overwrite_UploadBtn(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[contains(@kendo-window,'overrideForecastDialog')]//ng-transclude[normalize-space()='Upload']"));
	    }
	    public static WebElement profit_upload_Overwrite_ConfirmationPopup(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//span[@id='t-confirmation-window_wnd_title' and text()='Overwrite Forecast' ]"));
	    }
	    public static WebElement profit_upload_Overwrite_Confirmation_UploadBtn(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@class='upload-forecast-dialog-footer dialog-footer']//button[normalize-space()='Upload']"));
	    }
	    public static WebElement profit_uploadForecast_CloseBtn(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//div[@id='upload-forecast-window']//span[@class='k-icon k-i-cancel']/parent::button"));
	    }
	    
	    public static WebElement profit_uploadForecast_expansion(WebDriver driver)
	    {
	       return driver.findElement(By.xpath("//ul[@class='k-group k-treeview-lines']/li//span[@class='k-icon k-i-expand']"));
	    }


	  
}
