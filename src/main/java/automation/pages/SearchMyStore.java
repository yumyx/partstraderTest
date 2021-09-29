package automation.pages;



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
        debugInfo("Sort By:"+params.getSelectProduct());
        sortBy(params.getSelectProduct());

    }

    public void sortBy(String s){
        boolean ret = waitForUrl(15, params.getURLToSearch());
        assertEquals(ret,true);
        new Select(sort).selectByVisibleText(s);

    }


}
