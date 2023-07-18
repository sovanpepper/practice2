package practice2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import practice2.abstractcomponents.abstractcomponents;

public class landingPage extends abstractcomponents{
	By useremail=By.id("userEmail");
	By password=By.id("userPassword");
	By loginbutton=By.id("login");
	
	WebDriver driver;
	public landingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
	}
	
	public void loginaction(String username, String pass) {
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(useremail).sendKeys(username);
		driver.findElement(password).sendKeys(pass);	
		driver.findElement(loginbutton).click();
	}
	
	

}
