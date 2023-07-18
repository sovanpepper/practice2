package practice2.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import practice2.abstractcomponents.abstractcomponents;

public class cartPage extends abstractcomponents {
	
	WebDriver driver;
	By toast= By.id("toast-container");
	By cartbutton=By.xpath("//button[@routerlink='/dashboard/cart']");
	By cartproducts=By.cssSelector(".cartWrap.ng-star-inserted");
	By checkoutbutton= By.xpath("//div/ul/li[3]/button");
	By loader= By.cssSelector(".ng-animating");

	
	public cartPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
	}
	
	public List<WebElement> cartaddition(String productname) {
	
	clickablewait(loader);
	clickablewait(toast);
	driver.findElement(cartbutton).click();		
	List<WebElement> cartitems=driver.findElements(cartproducts);		
   List<WebElement> sortedlist= cartitems.stream().filter(a->a.getText().contains(productname)).collect(Collectors.toList());	
   driver.findElement(checkoutbutton).click();
   return sortedlist;


}
}
