package stepdefinition;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObject.loginpage;
import utilities.reporter;
import utilities.screenshot;

public class testcase1_login extends reporter{
	

	 WebDriver driver=hooks.driver;
	 loginpage Loginpage1;
    
	
	
	
  @Test
    
	@Given("The user in the login page to login with valid details")
	public void the_user_in_the_login_page_to_login_with_valid_details() {
	   System.out.println("The user in the login page to login with valid details");
	   Loginpage1 =new loginpage(driver);
	  
	}
	
	@When("he enters the valid credentials of {string} and {string}")
	public void he_enters_the_valid_credentials_of_and(String username, String password) throws InterruptedException {
	    Loginpage1.login(username, password);
	}
	
	@Then("he should be able to login to the Home page")
	public void he_should_be_able_to_login_to_the_Home_page() throws InterruptedException {
	      System.out.println("The user should be able to login to the Home page");
	      reporter.logger=reporter.extent.startTest("Test");
		  boolean expected = true;
		  boolean actual=Loginpage1.isLoginSuccessfull();
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
