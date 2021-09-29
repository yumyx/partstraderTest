package automation.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * ExtentReport is the third party lib for test reporting
 */
public class ExtentManager {
	private static final ExtentReports extentReports = new ExtentReports();;
	private static ExtentSparkReporter reporter;
	public static ExtentReports getReport() {
		
		if(reporter == null)
			reporter = new ExtentSparkReporter("./test-output/extent-report.html");
		
        reporter.config().setReportName("Shopping Cart Test Report");
        extentReports.attachReporter(reporter);
        return extentReports;
    
	}
}
