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

public class testcase6_quantity extends reporter{
	WebDriver driver=hooks.driver;
	productpage product1;
	@Given("The user is in the Product page to enter the quantity of product")
	public void the_user_is_in_the_Product_page_to_enter_the_quantity_of_product() {
	   System.out.println("The user is in the Product page to enter the quantity of product");
	   product1=new productpage(driver);
	}
	@When("The user enters the desired {string} quantity")
	public void the_user_enters_the_desired_quantity(String product) {
		product1.enterproduct(product);
	    
	}
	@Then("The System adds the desired product {string} in the cart page")
	public void the_system_adds_the_desired_product_in_the_cart_page(String quantity) throws IOException {
		System.out.println("The System adds the desired product in the cart page");
		reporter.logger=reporter.extent.startTest("Test");
		boolean expected =true;
		boolean actual=product1.setQuantity(quantity);
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
