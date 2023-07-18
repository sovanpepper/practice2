package practice2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import practice2.abstractcomponents.abstractcomponents;

public class confirmationPage extends abstractcomponents{
	WebDriver driver;
	By confirmationtext=By.cssSelector(".hero-primary");
	
	public confirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;		
	}
	
	public String orderconfirm() {
		
		   clickablewait(confirmationtext);
	       String orderConfirmation=driver.findElement(confirmationtext).getText();
	       return orderConfirmation;
	}
	
	

}
