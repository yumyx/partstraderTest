package automation.test;

import automation.pages.*;
import automation.Params.ParamInput;
import automation.util.JasonDataProvider;

import automation.util.TestNGListener;
import automation.util.WDriver;
import org.testng.TestNG;

import automation.util.LoggerUtil;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static automation.pages.BasicPage.debugInfo;


public class TestCart extends TestBase{

  @BeforeClass
    public void init(){
      driver = this.initDriver();
      this.initReport(this.getClass().getName());

  }
  @Test(dataProvider = "JasonReader",dataProviderClass = JasonDataProvider.class)
  public void testShoppingCart(ParamInput param){
    parameter = param;
    doShopTest( param);
  }


  public void testShoppingCart1(ParamInput paramInput){
    driver.get(paramInput.getNavigateTo());
    SortView sortView = new SortView(driver,paramInput);
    sortView.selectCheapest();

  }

    public void doShopTest(ParamInput params){
      debugInfo("================================================");
      debugInfo("Test Name:"+params.get_TestName_());
      debugInfo("Test Description:"+params.get_TestDescription_());
      debugInfo("================================================");

    MyStore myStore = new MyStore(driver,params);
   // p.search("Printed Summer Dress");
    myStore.search();

   // SearchMyStore sr = new SearchMyStore(driver);
    SearchMyStore searchMyStore = new SearchMyStore(myStore);

    //sr.sortBy("Price: Lowest first");
    searchMyStore.sortBy();

    SortView sortView = new SortView(myStore);
      sortView.selectCheapest();

    DetailPage dp = new DetailPage(myStore);
    dp.addProduct( params);
    CartSummary cartSummary = new CartSummary(myStore);

    cartSummary.selectAction();
    OrderSummary orderSummary = new OrderSummary(myStore);
    orderSummary.checkTotal();


    orderSummary.takeScreenShot();
  }
   @AfterClass
   public void afterClass() {
     extentReportFlush();
     driver.quit();
     //	LoggerUtil.close();
   }

  public static void main(String[] args) {
    TestNG testng = new TestNG();
    TestNGListener tla = new TestNGListener();
    testng.setTestClasses(new Class[]{TestCart.class});
    testng.addListener(tla);
    testng.run();

  }
}
