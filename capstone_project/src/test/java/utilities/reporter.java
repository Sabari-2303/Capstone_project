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
	
//	@AfterMethod
//	public void getresult(ITestResult result)
//	{
//		if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			logger.log(LogStatus.PASS,"Test is passed");
//		}
//		else if(result.getStatus()==ITestResult.FAILURE)
//		{
//			logger.log(LogStatus.FAIL,"Test is Failed");
//		}
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//			logger.log(LogStatus.SKIP,"Test is Skipped");
//		}
//		extent.endTest(logger);
//	}
	
 
  
  @BeforeSuite
  public void beforeSuite() {
	  extent=new ExtentReports("D:\\Selenium demo\\capstone_project\\Reports\\report.html",true);
  }
  

  @AfterSuite
  public void afterSuite() {
	  extent.flush();
	 
	  
  }
}


