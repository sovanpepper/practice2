package practice2.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	
	public ExtentReports getReport() {
		
		String path= System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Extent Reports");
		reporter.config().setReportName("Test Reports");
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);	
		return extent;
	}

}
