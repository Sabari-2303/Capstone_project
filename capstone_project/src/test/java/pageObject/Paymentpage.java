package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Paymentpage {
	WebDriver driver;
	public Paymentpage(WebDriver driver)
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void enteringproduct(String product)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.PopUp")));
        WebElement speakersTile = wait.until(ExpectedConditions.elementToBeClickable(By.id("speakersImg")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", speakersTile);
        speakersTile.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement prod=driver.findElement(By.xpath("//a[@class='productName ng-binding' and contains(text(),'" + product + "')]"));
		prod.click();

	}
	public boolean Phonenumber(String phno)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart")));
        addcart.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkout = wait1.until(ExpectedConditions.elementToBeClickable(By.id("checkOutPopUp")));
        checkout.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
        WebElement editLink = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Edit shipping details']")));
        editLink.click();
        WebElement phoneInput = driver.findElement(By.name("phone_number"));
        phoneInput.sendKeys(Keys.CONTROL + "a");
	    phoneInput.sendKeys(Keys.DELETE);          
        phoneInput.sendKeys(phno);
        String enteredValue = phoneInput.getAttribute("value");
        boolean isNumericphone = enteredValue.matches("\\d+");
        return isNumericphone;

     }
	public boolean City(String city)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart")));
        addcart.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkout = wait1.until(ExpectedConditions.elementToBeClickable(By.id("checkOutPopUp")));
        checkout.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
        WebElement editLink = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Edit shipping details']")));
        editLink.click();
        WebElement CityInput = driver.findElement(By.name("city"));
        CityInput.sendKeys(Keys.CONTROL + "a");
	    CityInput.sendKeys(Keys.DELETE); 
        CityInput.sendKeys(city);
        String enteredValue = CityInput.getAttribute("value");
        boolean isAlphabeticCity = enteredValue.matches("[a-zA-Z]+");
        return isAlphabeticCity;
        
	}
	public boolean Postalcode(String postcode)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart")));
        addcart.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkout = wait1.until(ExpectedConditions.elementToBeClickable(By.id("checkOutPopUp")));
        checkout.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
        WebElement editLink = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Edit shipping details']")));
        editLink.click();
        WebElement postcodeInput = driver.findElement(By.name("postal_code"));
        postcodeInput.sendKeys(Keys.CONTROL + "a");
	    postcodeInput.sendKeys(Keys.DELETE); 
        postcodeInput.sendKeys(postcode);
        String enteredValue =postcodeInput.getAttribute("value");
        boolean isNumericPostcode = enteredValue.matches("\\d+");
        return  isNumericPostcode;
        
	}

}
