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

  public WebDriver getDriver() {
	  return driver;
  }

  public void moveToElement(WebElement ele) {
      action.moveToElement(ele).perform();
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


