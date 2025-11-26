package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpage {
	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	

	public void enterMail(String email) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(email);
		Thread.sleep(2000);
	}
	
	public void enterPassword(String psd) throws InterruptedException {
		  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	      wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(psd);
	      Thread.sleep(2000);
		
	}
	public void clickrememberme() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
        driver.findElement(By.name("remember_me")).click();
        Thread.sleep(2000);
		


	}
	

	public void clickLogin() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
		WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign_in_btn")));
		signInBtn.click();


		
	}
    public void login(String username, String password) throws InterruptedException {
    	driver.findElement(By.cssSelector("svg#menuUser > path#menuUserSVGPath")).click();
    	enterMail(username);
        enterPassword(password);
        clickrememberme();
        clickLogin();
   }
   public  boolean isLoginSuccessfull()
   {
	   
		return driver.getPageSource().contains("My account");
	   
   }
   public  boolean isLoginFailed()
   {
	  
		return driver.getPageSource().contains("Incorrect username or password");
	
   }
}
