package automation.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry  implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount=2;


    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
            String message = "running retry for  '" + result.getName() + "' on class " + 
                                       this.getClass().getName() + " Retrying " + retryCount + " times";
            System.out.println(message);
          
            retryCount++;
            return true;
        }
        return false;
    }
}
