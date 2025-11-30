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
import io.qameta.allure.Allure;
import pageObject.speakerpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase4_colour extends reporter {
	
	WebDriver driver=hooks.driver;
	speakerpage speaker2;
	
	@Test
	
	
	@Given("The user is in the Speakers page to filter based on colour")
	public void the_user_is_in_the_speakers_page_to_filter_based_on_colour() {
	   System.out.println("The user is in the Speakers page to filter based on colour");
	   driver=new EdgeDriver();
	   driver.get("https://www.advantageonlineshopping.com");
	   speaker2=new speakerpage(driver);
	}
	@When("The user selects the desired {string} of the product")
	public void the_user_selects_the_desired_of_the_product(String colour) {
		speaker2.selectColour(colour);
	    
	}
	@Then("The System displays the  desired {string} products in the desired {string}")
	public void the_system_displays_the_desired_products_in_the_desired(String manufacturer, String colour) throws InterruptedException, IOException {
		 System.out.println("The System displays the products of the Manufacturer");
	        reporter.logger=reporter.extent.startTest("Test");
		    boolean expected =true;
		    boolean actual=speaker2.checkColour(manufacturer, colour);
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

	   
	}
	

	
}
