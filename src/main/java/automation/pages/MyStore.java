package automation.pages;

<<<<<<< Updated upstream:src/main/java/automation/pages/MyStore.java
import automation.util.WDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
=======
import automation.util.LoggerUtil;
import automation.util.WDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
>>>>>>> Stashed changes:src/test/java/Integration/pages/MyStore.java
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
        String url = params.getNavigateTo();
        LoggerUtil.debugInfo("Access URL "+url);
        driver.get(url);
        searchText.sendKeys(text);
        LoggerUtil.debugInfo("Searching "+text);
        searchButton.click();
       // WebElement sort = driver.findBy(By.id("selectProductSort"));
        //new Select(sort).selectByVisibleText(params.getSelectProduct());

    }
}
