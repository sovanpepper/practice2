package practice2.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import practice2.abstractcomponents.abstractcomponents;

public class checkoutPage extends abstractcomponents {
	
	By countrydropdown=By.xpath("//input[@placeholder='Select Country']");
	By dropdownresults= By.cssSelector(".ta-results.list-group.ng-star-inserted");
	By countrylist=By.cssSelector(".ng-star-inserted");
	By confirmorder=By.cssSelector(".btnn.action__submit.ng-star-inserted");
	
	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;		
	}
	
	public void countryselection() {
		
		   driver.findElement(countrydropdown).sendKeys("Ind");
	       clickablewait(dropdownresults);
	       List<WebElement> countries=driver.findElements(countrylist);       
	       WebElement country=countries.stream().filter(b->b.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
	       country.click(); 
	       driver.findElement(confirmorder).click();

	}
	
	
	

}
