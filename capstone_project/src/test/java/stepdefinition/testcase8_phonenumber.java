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
import pageObject.productpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase8_phonenumber extends reporter{
	WebDriver driver=hooks.driver;
	loginpage login3;
	Paymentpage payment1;
	@Given("The user is in the Payment page to add the Phone number to the Shipping details")
	public void the_user_is_in_the_Payment_page_to_add_the_Phone_number_to_the_Shipping_details() {
		System.out.println("The user is in the Payment page to add the Phone number to the Shipping details");
		login3=new loginpage(driver);
		payment1=new Paymentpage(driver);
	   
	}
	
	@When("The user enters the invalid Phone number to Phone number section after login using {string} and {string}  and selecting the {string}")
	public void the_user_enters_the_invalid_Phone_number_to_Phone_number_section_after_login_using_and_and_selecting_the(String username, String password, String product) throws InterruptedException {
		login3.login(username, password);
		payment1.enteringproduct(product);
	}
	@Then("The System shows an error message as Invalid Phone number when enters the invalid {string}")
	public void the_System_shows_an_error_message_as_Invalid_Phone_number_when_enters_the_invalid(String phno) throws IOException {
		System.out.println("The System shows an error message as Invalid Phone number when enters the invalid {string}");
		reporter.logger=reporter.extent.startTest("Test");
		boolean expected =true;
		boolean actual=payment1.Phonenumber(phno);
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
