package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class speakerpage {
	WebDriver driver;
	public speakerpage(WebDriver driver)
	{
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void selectManufacturer(String Maunufacturer)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("speakersImg")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement manufacturerAccordion = wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionAttrib1")));
		manufacturerAccordion.click();
		WebElement hpCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id(Maunufacturer)));
		if (!hpCheckbox.isSelected()) {
			    hpCheckbox.click();
			}

		

        
        
    }
	public int getNumbermanufacturerproducts(String Manufacturer)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> imageList= driver.findElements(By.xpath("//a[@class='productName ng-binding' and contains(text(),'" + Manufacturer + "')]"));
        return imageList.size();
	}
	public void selectColour(String colour)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("speakersImg")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement colouroption = wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionColor")));
	    colouroption.click();
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement colorElement = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='productColor ' and @title='" + colour + "']")));
	    colorElement.click();
		
	}
	
	
	
	 public boolean checkColour(String manufacturer,String colour)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement prod= driver.findElement(By.xpath("//a[@class='productName ng-binding' and contains(text(),'" + manufacturer + "')]"));
	     prod.click();
	     List<WebElement> colourprod=driver.findElements(By.xpath("//span[@title='" + colour + "']") );
	     int a=colourprod.size();
	     if(a>0)
	     {
	    	 return true;
	     }
	     return false;

	 }
	 public void setPriceFilter(String low, String high) {
	        driver.findElement(priceLowerInput).clear();
	        driver.findElement(priceLowerInput).sendKeys(low);
	        driver.findElement(priceUpperInput).clear();
	        driver.findElement(priceUpperInput).sendKeys(high);
	    }

	    public boolean isLowerLimitValid(String low) {
	        return Integer.parseInt(low) <= 170;
	    }
	    
	 public void applyBluetoothFilter(String bluetoothoption) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    driver.findElement(By.id("speakersImg")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement bluetooth = wait.until(ExpectedConditions.elementToBeClickable(By.id("accordionAttrib3")));
	        bluetooth.click();
	        WebElement bluetoothbox = wait.until(ExpectedConditions.elementToBeClickable(By.id(bluetoothoption)));
			if (!bluetoothbox.isSelected()) {
				    bluetoothbox.click();
				}
	    }

	 public int getNumberofBluetoothdivision(String bluetoothavailable) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> numberlist= driver.findElements(By.xpath("//a[@class='productName ng-binding' and contains(text(),'" + blutoothavailable + "')]"));
	        return numberlist.size();
		
	        
	    }

	 
	
	

}
