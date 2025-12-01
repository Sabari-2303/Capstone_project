package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class screenshot {
	
	
     static int i=1;
	 public static void bugScreenshot(WebDriver driver) throws IOException {
		    
		    File scrFile;
			scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile, new File("C:\\Users\\Administrator\\git\\repository11\\capstone_project\\Screenshots\\Steps"+i+ ".jpeg"));
			i++;
	  }
	

}
