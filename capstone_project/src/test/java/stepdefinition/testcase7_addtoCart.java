package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObject.productpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase7_addtoCart extends reporter{
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
	public void the_System_adds_the_product_in_the_cart_page() throws IOException {
	   System.out.println("The System adds the product in the cart page");
	   reporter.logger=reporter.extent.startTest("Test");
	   boolean expected =true;
	   boolean actual=product2.addtocart();

	   try {
			
	         assertEquals(actual, expected);
		     screenshot.bugScreenshot(driver);
		     reporter.logger.log(LogStatus.PASS, "test passed successfully");
		     Allure.step("Valid login passed");
	     }
	   catch(AssertionError e) {
		    screenshot.bugScreenshot(driver);
	        reporter.logger.log(LogStatus.FAIL, "test failed");
		    Allure.addAttachment("Valid login failed", e.getMessage());
		    throw e;
	   }
	  finally {
		   reporter.extent.endTest(reporter.logger);
      }
	}
	

}
