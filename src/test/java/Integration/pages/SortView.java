package Integration.pages;

import Integration.Params.ParamInput;
import Integration.util.WDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SortView extends UrlPage{
    public SortView(BasicPage page){
        super( page);

    }
    public SortView(WDriver driver, ParamInput paramInput){
        super(driver,paramInput);

    }


    //3.	Select the cheapest dress
    public void selectCheapest()
    {


        boolean ret = waitForUrl(25, "orderby=price&orderway=asc");
        assertEquals(ret,true);



        WebElement center_column = driver.findBy(By.id("center_column"));

        List<WebElement> list =  center_column.findElements(By.className("product-price"));
        Double cheapest=null;
        String cheapestText=null;
        for(WebElement priceEle: list){
            String className = priceEle.getAttribute("class");
            if(!className.equals("price product-price"))
                continue;
            String priceText = priceEle.getText();
            if(priceText.indexOf("$")!=0)
                continue;
            String priceText2=priceText.substring(1);
            Double price = Double.valueOf(priceText2);
            if(cheapest==null || cheapest> price){

                cheapest=price;
                cheapestText=priceText;
            }
            
        }
        WebElement firstEle = driver.findBy(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span[1]"));
        String firstText=firstEle.getText();
        assertEquals(firstText,cheapestText);


        //  return driver.findElements(By.className("product-container"));
        List<WebElement> listMore =  driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img"));
        WebElement first = (WebElement)listMore.get(0);
        driver.hover(first);
        more();

    }



    public void more(){


        WebElement more=  driver.findBy(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]"));

        more.click();

    }
}
