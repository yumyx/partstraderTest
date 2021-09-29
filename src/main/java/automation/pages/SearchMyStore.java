package automation.pages;

import automation.util.LoggerUtil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class SearchMyStore extends UrlPage {
    @FindBy(id="selectProductSort")
    private WebElement sort;

    public SearchMyStore(BasicPage page){
        super( page);

    }
    public void sortBy(){
        LoggerUtil.debugInfo("Sort "+params.getSelectProduct());
        sortBy(params.getSelectProduct());

    }

    public void sortBy(String s){
        boolean ret = waitForUrl(15, "search_query=Printed+Summer+Dress");
        assertEquals(ret,true);
        new Select(sort).selectByVisibleText(s);

    }


}
