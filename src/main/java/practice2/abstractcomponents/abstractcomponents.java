package practice2.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractcomponents {
	WebDriver driver;
	
	public abstractcomponents(WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
	public void clickablewait(By locator) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}

}
