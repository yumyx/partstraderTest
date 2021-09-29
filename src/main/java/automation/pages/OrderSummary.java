package automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class OrderSummary extends BasicPage{

    public OrderSummary(BasicPage page){
        super( page);

    }

    @FindBy(id="total_price_container")
    private WebElement total;


    public String getTotal(){
        driver.waitForElement(total);
        return total.getText();
    }
    public void checkTotal(){
        assertEquals(getTotal(),params.getShoppingCartSummary().getTotal());
    }
}
