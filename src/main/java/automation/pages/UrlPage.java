package automation.pages;
import automation.Params.ParamInput;
import automation.util.WDriver;

public class UrlPage extends BasicPage{
    public UrlPage(BasicPage page){
        super( page);

    }
     public String URL=null;

    public UrlPage(WDriver driver, ParamInput paramInput) {
        super(driver, paramInput);
    }
    public boolean waitForUrl(int waitsec ,String url){

         if(url==null)
             url=URL;
         if(url==null)
             return false;

         for(int i=1;i<waitsec;++i) {
             if(driver.currentURL().indexOf(url)>=0)
                 return true;

             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         return false;
     }

}
