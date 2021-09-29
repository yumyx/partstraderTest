package automation.pages;

<<<<<<< Updated upstream:src/main/java/automation/pages/CartSummary.java
=======
import automation.util.LoggerUtil;
>>>>>>> Stashed changes:src/test/java/Integration/pages/CartSummary.java
import automation.util.WDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import automation.Params.ParamInput;

public class CartSummary extends BasicPage{

    public CartSummary(BasicPage page){
            super( page);

    }
    @FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    private WebElement proceed;
    @FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    private WebElement continueShopping;

    public CartSummary(WDriver driver, ParamInput paramInput)
    {

        super(driver,paramInput);
    }

    public void proceed(){
        driver.waitForElement(proceed);
        proceed.click();
    }
    public void continueShopping(){
        driver.waitForElement(continueShopping);
        continueShopping.click();
    }
    public void selectAction(){
        String action = params.getAction();
        LoggerUtil.debugInfo("Action :"+action);
        if(action.equals("Proceed to Checkout"))
            proceed();
        else if(action.equals("ContinueShopping"))
            continueShopping();
    }
}
