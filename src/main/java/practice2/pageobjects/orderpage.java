package practice2.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import practice2.abstractcomponents.abstractcomponents;

public class orderpage extends abstractcomponents {
	WebDriver driver;
	By productList=By.cssSelector(".col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted");
	By addtocart=By.cssSelector(".btn.w-10.rounded");
	
	
	public orderpage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		
		
	    }
	
	public void productselection(String productname) {
		
		clickablewait(productList);
		List<WebElement> descp=driver.findElements(productList);		
		 WebElement prod=descp.stream().filter(c->c.getText().contains(productname)).findFirst().orElse(null);
//		 WebElement prod=descp.stream().filter(c->c.getText().contains("ZARA COAT 3")).findFirst().orElse(null);

		 prod.findElement(addtocart).click();
	}

}
