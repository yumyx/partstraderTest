package automation.pages;

import automation.util.LoggerUtil;
import automation.util.WDriver;
import   automation.Params.ParamInput;
import static org.testng.Assert.assertEquals;

/***
 * Super class for all the web pages.
 */
public class BasicPage {
    protected WDriver driver;
    protected ParamInput params;
    public void initBasicPage(WDriver driver, ParamInput paramInput){
        this.driver = driver;
        driver.pageFactoryInit(this);
        params=paramInput;

    }
    public BasicPage(WDriver driver, ParamInput paramInput){
        initBasicPage(driver,paramInput);
    }
    public BasicPage(BasicPage page){
        initBasicPage(page.driver,page.params);
    }
    public void takeScreenShot(){
        driver.takeScreenShot(params.get_TestName_()+"."+this.getClass().getSimpleName());
    }

    public static void assertEq(String actual, String expected) {
        String eq=" != ";
        if(actual.equals(expected))
            eq=" == ";
        String text="actual:"+actual+eq+"expected:"+expected;
        debugInfo(text);
        assertEquals(actual,  expected);

    }
    public static void debugInfo(String text){
        LoggerUtil.debugInfo(text);
        System.out.println(text);
    }
}
