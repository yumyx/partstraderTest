package automation.pages;

import automation.util.WDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import automation.Params.ParamInput;
public class MyStore extends  BasicPage {

    @FindBy(id="search_query_top")
    private WebElement searchText;
    @FindBy(name="submit_search")
    private WebElement searchButton;

    public MyStore(WDriver driver, ParamInput paramInput)
    {
        super(driver,paramInput);
    }
    public void search(){
        search(params.getSearchFor());
    }

    public void search(String text){
        driver.get(params.getNavigateTo());
        searchText.sendKeys(text);
        searchButton.click();
        WebElement sort = driver.findBy(By.id("selectProductSort"));
        new Select(sort).selectByVisibleText("Price: Lowest first");

    }
}
