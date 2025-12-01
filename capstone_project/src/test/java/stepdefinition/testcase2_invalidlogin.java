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
import pageObject.loginpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase2_invalidlogin extends reporter{
	
	 WebDriver driver=hooks.driver;
     loginpage Loginpage2;
	
	
	@Test
	@Given("The user in the login page to login with Invalid details")
	public void the_user_in_the_login_page_to_login_with_Invalid_details() {
	System.out.println("The user in the login page to login with Invalid details");
	   driver=new EdgeDriver();
	   driver.get("https://www.advantageonlineshopping.com");
	   Loginpage2 =new loginpage(driver);
	
	}
	
	@When("he enters the Invalid credentials of {string} and {string}")
		public void he_enters_the_invalid_credentials_of_and(String username, String password) throws InterruptedException {
		Loginpage2.login(username, password);
		    
		}
	
		
			
			
	   
	
	@Then("he should not be able to login to the Home page")
	public void he_should_not_be_able_to_login_to_the_Home_page() throws InterruptedException, IOException {
	     System.out.println("The user should not be able to login to the Home page");
	     reporter.logger=reporter.extent.startTest("Test");
	 	 boolean expected =false;
	 	 boolean actual=Loginpage2.isLoginFailed();

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
