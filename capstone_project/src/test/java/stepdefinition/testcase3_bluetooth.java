package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObject.speakerpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase3_bluetooth extends reporter{
	
	WebDriver driver=hooks.driver;
	speakerpage speaker3;
	@Given("The user is in the Speakers page to filter based on Bluetooth availability")
	public void the_user_is_in_the_Speakers_page_to_filter_based_on_Bluetooth_availability() {
	   System.out.println("The user is in the Speakers page to filter based on Bluetooth availability");
//	   driver=new EdgeDriver();
//	   driver.get("https://www.advantageonlineshopping.com");
	   speaker3=new speakerpage(driver);
	}
	
	@When("The user selects whether the product has {string} feature or not")
	public void the_user_selects_whether_the_product_has_feature_or_not(String bluetoothoption) {
		speaker3.applyBluetoothFilter(bluetoothoption);
	    
	}
	@Then("The System displays the products contains {string} or not")
	public void the_system_displays_the_products_contains_or_not(String bluetoothavailable) throws InterruptedException {
		System.out.println("The syatem displays the product contains the bluetooth feature or not");
		reporter.logger=reporter.extent.startTest("Test");
		 int expected =0;
		 int actual=speaker3.getNumbermanufacturerproducts(bluetoothavailable);
	     if(actual==expected)
	     {
             reporter.logger.log(LogStatus.PASS, "Test passed successfully");
		     try {
		         screenshot.bugScreenshot(driver);
		         reporter.logger.log(LogStatus.PASS, "Screenshot captured for Success");
		         Allure.step("content");
		     } catch (IOException e1) {
		    	 Allure.addAttachment("content",e1.getMessage());
		         e1.printStackTrace();
		     }

		 } 
	     else
	    	 {
	    	 reporter.logger.log(LogStatus.FAIL, "Test failed");
		     try {
		         screenshot.bugScreenshot(driver);
		         reporter.logger.log(LogStatus.FAIL, "Screenshot captured for Failure");
		         Allure.step("content");
		     } catch (IOException e1) {
		    	 Allure.addAttachment("content",e1.getMessage());
		         e1.printStackTrace();
		     }

		    
		 } 
	     
		 reporter.extent.endTest(reporter.logger);
//		 Thread.sleep(2000);
//		 driver.quit();
		 

	    
	}

}
