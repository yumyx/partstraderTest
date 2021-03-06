package automation.pages;

import automation.Params.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import automation.Params.ParamInput;

import java.util.HashMap;

import static automation.pages.BasicPage.debugInfo;

public class DetailPage extends BasicPage{

    @FindBy(xpath="//*[@id=\"quantity_wanted_p\"]/a[2]")
    private WebElement plus;
    @FindBy(xpath="//*[@id=\"quantity_wanted_p\"]/a[1]")
    private WebElement minus;

    //quantity_wanted
    @FindBy(id="quantity_wanted")
    private WebElement quantity_wanted;


    @FindBy(id="group_1")
    private WebElement size;
    @FindBy(name="Yellow")
    private WebElement Yellow;
    @FindBy(name="Green")
    private WebElement Green;
    @FindBy(name="Submit")
    private WebElement addToCart;

    public DetailPage(BasicPage page){
        super( page);

    }
    public void addProduct(ParamInput params){
        HashMap <String,WebElement> colorMap= new HashMap();
        colorMap.put("Green",Green);
        colorMap.put("Yellow",Yellow);


        Product product = params.product;
        quantity_wanted.clear();


        String quantity=""+product.getQuantity();

        quantity_wanted.sendKeys(quantity);
        debugInfo("set quantity:"+quantity);


       // plus.click();
        debugInfo("set size:"+product.getSize());
        new Select(size).selectByVisibleText(product.getSize());
       // Green.click();

        debugInfo("set colour:"+product.colour);
        WebElement colorEm = colorMap.get(product.colour);
        if(colorEm!=null)
            colorEm.click();

        addToCart.click();
    }
}
