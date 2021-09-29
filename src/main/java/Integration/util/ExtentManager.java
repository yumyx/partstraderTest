package Integration.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
