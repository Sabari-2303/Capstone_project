package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.productpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase7_addtoCart {
	WebDriver driver=hooks.driver;
	productpage product2;
	@Given("The user is in the Product page to add the products to the cart")
	public void the_user_is_in_the_Product_page_to_add_the_products_to_the_cart() {
	    System.out.println("The user is in the Product page to add the products to the cart");
	    product2=new productpage(driver);
	}
	@When("The user clicks the Add to cart button for desired {string}")
	public void the_user_clicks_the_add_to_cart_button_for_desired(String product) {
		product2.enterproduct(product);
		
		
	    
	}

	@Then("The System adds the product in the cart page")
	public void the_System_adds_the_product_in_the_cart_page() {
	   System.out.println("The System adds the product in the cart page");
	   reporter.logger=reporter.extent.startTest("Test");
	   boolean expected =true;
	   boolean actual=product2.addtocart();
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
