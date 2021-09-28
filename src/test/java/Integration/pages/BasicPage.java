package Integration.pages;

import Integration.util.WDriver;
import   Integration.Params.ParamInput;

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
}
