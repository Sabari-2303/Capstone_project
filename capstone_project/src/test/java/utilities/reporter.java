package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import org.testng.annotations.BeforeSuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class reporter {
	public static ExtentReports extent;
	public static ExtentTest logger;
	

	
 
  
  @BeforeSuite
  public void beforeSuite() {
	  extent=new ExtentReports("D:\\Selenium demo\\capstone_project\\Reports\\report.html",true);
  }
  

  @AfterSuite
  public void afterSuite() {
	  extent.flush();
	 
	  
  }
}


