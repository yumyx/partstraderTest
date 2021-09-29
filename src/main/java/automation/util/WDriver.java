package automation.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDriver {
  private WebDriver driver;
  private WebDriverWait wait ;
  private Actions action;
  private int timeout=15;

    /**
     * Init WebDriver Instance
     * @return
     */
  public WDriver init() {

      String driverLocation = ".\\lib\\chromedriver_win32\\chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", driverLocation);
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver,timeout);
      action = new Actions(driver);

      return this;
  }

    /***
     * Navigate to url
     */
  public void get(String url) {
      driver.get(url);
  }
    /***
     * Get current url
     * @param url
     */
  public String currentURL(){
      return driver.getCurrentUrl();
  }
  public void pageFactoryInit(Object instance) {
	  PageFactory.initElements(driver, instance);
  }

    /***
     * Wait for Web Element to be visible in DOM
     * @param element
     */
  public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
  }

    /***
     * Find by with WebDriverWait. Wait for expected conditions
     * @param by
     * @return
     */
  public WebElement findBy(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

   }

    /**
     * Hover over web element
     * @param ele
     */
   public void hover(WebElement ele){
        action.moveToElement(ele).perform();
   }

    /***
     * Find elements. Return list.
     * @param by
     * @return
     */
   public List<WebElement> findElements(By by){
        return driver.findElements(by);
   }

    /***
     * Close all the browser windows and terminates the WebDriver session.
     */
   public void quit() {
        driver.quit();
   }
  public void sendActionKeys(Keys key) {
	  action.sendKeys(key).perform();
	  
  }
  
  public void switchToDefaultContent() {
	  driver.switchTo().defaultContent();	  
  }
  public void swithToFrameIndex(int i) {
	  driver.switchTo().frame(0);
  }
  public void switchToFrame(String name) {
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	  
  }
  public void switchToFrame(By by) {
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	 
  }

  public void waitForElementClickable(WebElement element) {
	  wait.until(ExpectedConditions.elementToBeClickable(element));
  }



  public void sendKeysWithWait(WebElement elem,String s) {
	  waitForElement(elem);
	  elem.sendKeys(s);
  }
  public Alert switchToAlert() {
	  return driver.switchTo().alert();
  }
  public void sendKeys(WebElement elem,String s) {
	  elem.sendKeys(s);
  }
  public WebElement elementClickable(By by) {
	  return wait.until(ExpectedConditions.elementToBeClickable(by));
  }
  public void executJSClick(WebElement ele) {
  	JavascriptExecutor js = (JavascriptExecutor)driver;
  	js.executeScript("arguments[0].click();", ele);
  }
  public String getCurrentWindow() {
	  return driver.getWindowHandle();
  }
  public String getCurrentURL() {
	  return driver.getCurrentUrl();
  }
  public Set<String> getWindows() {
	  return driver.getWindowHandles();
  }
  public WebDriver getDriver() {
	  return driver;
  }
  public void swithToWindow(String s) {
	  driver.switchTo().window(s);
  }
  public void maximize() {
	  driver.manage().window().maximize();	
  }

  public void moveToElement(WebElement ele) {
      action.moveToElement(ele).perform();
  }
  public void actionClick(WebElement ele) {
	  moveToElement(ele);
	  try {
		  Thread.sleep(20000);  
	  }catch(Exception ex) {
		  
	  }
	  
	  action.click().perform();
  }
  public void pageDown(int repeat) {
	  int i=0;
	  while(i++<repeat) 
	  {
		  action.sendKeys(Keys.PAGE_DOWN).perform();
		  try {
			   Thread.sleep(500);
		  }catch(Exception ex) {
			   
		  }
	 }
	  
  }
  public void findByWithoutWait(By by) {
	  driver.findElement(by);
  }
  public void scrollDownTillWebElementVisible(By by) {
	 boolean found = false;
	 while(!found) 
	 {
		 try {
			 this.pageDown(1);
			 WebElement adiveToGP = driver.findElement(by);
			 found = adiveToGP.isDisplayed();
			 
		 }catch(Exception ex) {
			 
		 }
	 }
	 
	
  }
  public void takeScreenShot(String testName){
      TakesScreenshot scrShot =((TakesScreenshot)driver);
      File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
      String filePath = ".\\"+testName+".png";
      File DestFile=new File(filePath);
      //Copy file at destination
      try {
          FileUtils.copyFile(SrcFile, DestFile);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

}


