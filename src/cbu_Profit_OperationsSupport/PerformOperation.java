package cbu_Profit_OperationsSupport;

import java.io.IOException;
import java.nio.CharBuffer;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cbu_Profit_ExternalDataSource.Input_DataSource;
import jxl.Sheet;

public class PerformOperation extends cbu_Profit_DriverScript.Driver_Script {
	//static WebDriver driver;
    public static void wait(int n) throws InterruptedException
    {
        Thread.sleep(n*1000);
    }
	/*
	 * public static void fluentWait(WebElement Element) {
	 * 
	 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	 * .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(2))
	 * .ignoring(NoSuchElementException.class);
	 * 
	 * 
	 * }
	 */
    public static Wait<WebDriver> mFluentWait(WebElement ele) {
    	Wait<WebDriver> gWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
    			.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
    	//System.out.println("Waited for 60 seconds");
    	return gWait;
    }
    public WebElement isElementLoaded(WebElement elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }
    public static void webdriverWait_clickOn(WebDriver driver, WebElement locator, int timeout)
    {
	    new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	    locator.click();
    }
    public static void link_Click(WebElement ele)
    {
        ele.click();
    }
    public static void textboxEnabled(WebElement ele)
    {
        ele.isEnabled();
    }
    public static void KeysEnter(WebElement ele)
    {
        ele.sendKeys(Keys.ENTER);
    }
    public static void eb_EnterValue(WebElement ele,String value)
    {
         ele.sendKeys(value);
    }
    public static void link_Value_Click(WebElement ele,String value)
    {
        ele.click();
    }
    public static void clear_Text(WebElement ele)
    {
        ele.clear();
    }
    public static boolean wrn_Present(WebElement ele)
    {
        return ele.isDisplayed();
    }
    public static String getText_Display(WebElement ele)
    {
        return ele.getText();
    }
    public static boolean value_IsEnabled(WebElement ele)
    {
         return ele.isEnabled();
    }
    public static String selectSwitch(String milesType)
    {
        String membershipNo="";
        switch(milesType)
        {
        case "Asia Miles":
            membershipNo="1999999433";
        break;
        case "Kris Flyer":
            membershipNo="8420015788";
        break;
        case "Air Asia":
            membershipNo="8420015788";
        break;
        case "Enrich Miles":
            membershipNo="MH010924933";
        break;
        case "JP Miles":
            membershipNo="221926121";
        break;
        }
        return membershipNo;
    }
   public static void navigation(WebElement ele1,WebElement ele2,WebDriver driver) {
 	   Actions act = new Actions(driver);
 	   act.moveToElement(ele1).moveToElement(ele2).build().perform();
   }
   
   public static void navigation(WebElement ele1,WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.moveToElement(ele1).build().perform();
   }
  
   public static void scrollToElement(WebElement ele) {
 	 JavascriptExecutor js = (JavascriptExecutor)driver; 
     js.executeScript("arguments[0].scrollIntoView(true);",ele);
   }
  
   public static void scrollToElementcol(WebElement ele,WebDriver driver) {
 	  JavascriptExecutor js = (JavascriptExecutor)driver; 
      js.executeScript("arguments[0].scrollIntoView(true);",ele);
   }
  
   public static void scrollAndClickOnElement(WebElement ele,WebDriver driver) throws InterruptedException {
 	 JavascriptExecutor js = (JavascriptExecutor)driver; 
      js.executeScript("arguments[0].scrollIntoView();",ele);
      wait(1);
      ele.click();
   }
   
   public static void selectbyVal(WebElement ele, String value) {
   	Select select = new Select(ele);
   	select.selectByValue(value);
   }
   
   public static String testData(String varName, String SheetName) throws Exception, IOException {
   
   	Sheet scenario = Input_DataSource.testData(Input_DataSource.CBUTestData, SheetName);
   	String value = null;
   	int testDataRowCount = scenario.getRows();
	
   	for (int i = 1; i < testDataRowCount; i++) {

		String varXcel = scenario.getCell(0, i).getContents();
		String value1 = scenario.getCell(1, i).getContents();
		if (varXcel.equalsIgnoreCase(varName)) {
			 value=value1;		
			}
   	}
   	return value;

   }
   
   public static void jsClick(WebDriver driver,WebElement ele) {
   	JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
   }
   
   public static void enterTextOneByOne(WebElement inputElement, String text) throws InterruptedException{
   	  for (char letter : text.toCharArray()) {
   	    inputElement.sendKeys(CharBuffer.wrap(new char[]{letter}));
   	    wait(1);
   	  }
   	}
   
   public static void mouseOver(WebElement ele, WebDriver driver) {
   	Actions action = new Actions(driver);
   	action.moveToElement(ele).build().perform();
   }
   
   public static void scrollToObject(WebElement ele,WebDriver driver)
   {
   	JavascriptExecutor js = (JavascriptExecutor) driver;
   	js.executeScript("arguments[0].scrollIntoView();",ele);
   }
}