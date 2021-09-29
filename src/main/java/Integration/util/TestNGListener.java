package Integration.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Integration.test.TestBase;

public class TestNGListener implements ITestListener{
   
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
    public void onTestSkipped(ITestResult result) {
    	String testname = result.getMethod().getMethodName();
    	System.out.println("@@@@ onTestSkipped getTestName:"+testname);
    	//LoggerUtil.errorInfo("@@@@ onTestSkip "+result.getInstanceName()+":"+testname);
    	//LoggerUtil.errorInfo(result.getThrowable().toString());
    	TestBase ts = (TestBase)result.getInstance();
		//WDriver driver = ts.getDriver();
	    

    }
	public void onTestSuccess(ITestResult result) {
		
		String testname = result.getMethod().getMethodName();
		System.out.println("@@@@ onTestSuccess getTestName:"+testname);
		TestBase ts = (TestBase)result.getInstance();
	    ExtentTest extent_test = ts.getExtentTest();
	    extent_test.createNode(testname).log(Status.PASS, "Test passed"+ts.getParameter().printDescriptio());
	}

	public void onTestFailure(ITestResult result) {	
		
		String testname = result.getMethod().getMethodName();
		System.out.println("@@@@ onTestFailure getTestName:"+testname);
	//	LoggerUtil.errorInfo("@@@@ onTestFailure "+result.getInstanceName()+":"+testname);
    	//LoggerUtil.errorInfo(result.getThrowable().toString());
		TestBase ts = (TestBase)result.getInstance();
	    ExtentTest extent_test = ts.getExtentTest();
	    extent_test.createNode(testname).log(Status.FAIL, ts.getParameter().printDescriptio()+"\n\n"+result.getThrowable());
		ts.takeScreenshot(testname);
	}
	public void onFinish(ITestContext testContext) {
	     //   super.onFinish(testContext);
		// System.out.println("@@@@ onFinish");
	  /*   Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
	     while (listOfFailedTests.hasNext()) {
	           ITestResult failedTest = (ITestResult) listOfFailedTests.next();
	           System.out.println("@@@@ onFinish failedTest:"+failedTest);
	           ITestNGMethod method = failedTest.getMethod();
	           System.out.println("@@@@ onFinish method:"+method);
	           if (testContext.getFailedTests().getResults(method).size() > 1) {
	                listOfFailedTests.remove();
	           } else {
	           if (testContext.getPassedTests().getResults(method).size() > 0) {
	               listOfFailedTests.remove();
	           }

	       }
	     }*/
		
	    }
	
}
