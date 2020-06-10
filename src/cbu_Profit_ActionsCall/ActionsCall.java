package cbu_Profit_ActionsCall;

import cbu_Profit_Functions.MCBU_PROFIT_AdminTab_Permissions_ExportExcel;
import cbu_Profit_Functions.MCBU_PROFIT_AdminTab_UserID_Permissions;
import cbu_Profit_Functions.MCBU_PROFIT_HomePage_InitialMonthlyOutlook_ExportExcel;
import cbu_Profit_Functions.MCBU_PROFIT_HomePage_Viewbuttonvalidation;
import cbu_Profit_Functions.CBU_PROFIT_UploadForecast_BusinessPlan;
import cbu_Profit_Functions.CBU_PROFIT_UploadForecast_OutlookXY;
import cbu_Profit_Functions.HomePageValidation;
import cbu_Profit_Functions.InvalidForecastUpload;

public class ActionsCall {
	
public static void operationCalls(String actionkey,  String filepath) throws Exception
    {
        switch(actionkey)
        {
        case "AdminTab-Permissions-ExportExcel":
      	      MCBU_PROFIT_AdminTab_Permissions_ExportExcel.VerifytheAdminTabPermissionsExportExcel();
              break;	  
        case "AdminTab-UserId_Permissions":
        	  MCBU_PROFIT_AdminTab_UserID_Permissions.VerifytheAdminTabUserIDPermissions();
              break;
        case "AllForecastTypes_ExportExcel":
      	  	  MCBU_PROFIT_HomePage_InitialMonthlyOutlook_ExportExcel.VerifytheAllForecastTypes_ExportExcel();
              break;
        case "HomePage_DevelopmentView":
        	  MCBU_PROFIT_HomePage_Viewbuttonvalidation.VerifytheDevelopmentViewbuttonvalidation();
              break;
        case "HomePageValidation_CBU":
              HomePageValidation.actionCall();
        	  break;
        case "NegativeUploadValidation_CBU":
        	  InvalidForecastUpload.actionCall();
        	  break;
        case "CBU_PROFIT_UploadForecast_BusinessPlan":
        	CBU_PROFIT_UploadForecast_BusinessPlan.uploadForecastBusinessPlan();
  	          break;
        case "CBU_PROFIT_UploadForecast_OutlookXY":
        	  CBU_PROFIT_UploadForecast_OutlookXY.uploadForecastOutlookXY();
	          break;      
        default:
            System.out.println("Invalid Method");
        }
    }

}


