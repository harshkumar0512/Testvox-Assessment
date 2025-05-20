package utils;

import com.aventstack.extentreports.ExtentReports;
//old - import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
	

    public static ExtentReports getInstance() {
        if (extent == null) {
        	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent.html");
            //old
        	//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

}
