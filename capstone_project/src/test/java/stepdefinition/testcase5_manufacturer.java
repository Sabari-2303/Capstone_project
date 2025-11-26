package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.speakerpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase5_manufacturer extends reporter{
	WebDriver driver=hooks.driver;
	speakerpage speaker1;
	
	@Test
	@Given("The user is in the Speakers page to filter based on Manufacturer")
	public void the_user_is_in_the_Speakers_page_to_filter_based_on_Manufacturer() {
	   System.out.println("The user is in the Speakers page to filter based on Manufacturer");
	   driver=new EdgeDriver();
	   driver.get("https://www.advantageonlineshopping.com");
	   speaker1=new speakerpage(driver);
	   
	}
	@When("The user selects the {string} from the available list")
	public void the_user_selects_the_from_the_available_list(String manufacturer) {
	    speaker1.selectManufacturer(manufacturer);
	    
	}

	
	@Then("The System displays the products of the {string}")
	public void the_system_displays_the_products_of_the(String manufacturer) throws InterruptedException {
		 System.out.println("The System displays the products of the Manufacturer");
		    reporter.logger=reporter.extent.startTest("Test");
			 int expected =4;
			 int actual=speaker1.getNumbermanufacturerproducts(manufacturer);
			 if(actual==expected)
		     {
	             reporter.logger.log(LogStatus.PASS, "Test passed successfully");
			     try {
			         screenshot.bugScreenshot(driver);
			         reporter.logger.log(LogStatus.PASS, "Screenshot captured for Success");
			     } catch (IOException e1) {
			         e1.printStackTrace();
			     }

			 } 
		     else
		    	 {
		    	 reporter.logger.log(LogStatus.FAIL, "Test failed");
			     try {
			         screenshot.bugScreenshot(driver);
			         reporter.logger.log(LogStatus.FAIL, "Screenshot captured for Failure");
			     } catch (IOException e1) {
			         e1.printStackTrace();
			     }

			    
			 } 
		     
			 reporter.extent.endTest(reporter.logger);

	}
	    
}
	
