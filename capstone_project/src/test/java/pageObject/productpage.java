package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productpage {
	WebDriver driver;
	public productpage(WebDriver driver)
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void enterproduct(String product)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("speakersImg")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement prod=driver.findElement(By.xpath("//a[@class='productName ng-binding' and contains(text(),'" + product + "')]"));
		prod.click();
	}
	public boolean setQuantity(String quantity) {
	    WebElement qtyField = driver.findElement(By.name("quantity"));
	    qtyField.sendKeys(Keys.CONTROL + "a");
	    qtyField.sendKeys(Keys.DELETE);          
	    qtyField.sendKeys(quantity);       
	    String enteredValue = qtyField.getAttribute("value");
	    return enteredValue.equals(quantity);
	}
	public boolean addtocart()
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement bluetooth = wait1.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart")));
        bluetooth.click();
        boolean checkout=driver.findElement(By.id("checkOutPopUp")).isEnabled();
        return checkout;
	}


}
