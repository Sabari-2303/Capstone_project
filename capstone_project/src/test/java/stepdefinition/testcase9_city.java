package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObject.Paymentpage;
import pageObject.loginpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase9_city extends reporter{
	WebDriver driver=hooks.driver;
	loginpage login4;
	Paymentpage payment2;
	@Given("The user is in the Payment page to add the City to the Shipping details")
	public void the_user_is_in_the_Payment_page_to_add_the_City_to_the_Shipping_details() {
		System.out.println("The user is in the Payment page to add the City to the Shipping details");
		login4=new loginpage(driver);
		payment2=new Paymentpage(driver);
	    
	}
	@When("The user enters the invalid City to City section after login using {string} and {string}  and selecting the {string}")
	public void the_user_enters_the_invalid_City_to_City_section_after_login_using_and_and_selecting_the(String username, String password, String product) throws InterruptedException {
		login4.login(username, password);
		payment2.enteringproduct(product);
	   
	}
	@Then("The System shows an error message as Invalid City when enters the invalid {string}")
	public void the_System_shows_an_error_message_as_Invalid_City_when_enters_the_invalid(String city) throws IOException {
		System.out.println("The System shows an error message as Invalid City when enters the invalid {string}");
		reporter.logger=reporter.extent.startTest("Test");
		boolean expected =true;
		boolean actual=payment2.City(city);
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
