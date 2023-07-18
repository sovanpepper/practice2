package practice2.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import practice2.pagecomponents.baseTest;
import practice2.pageobjects.landingPage;

public class authenticationTest extends baseTest {
	
	@Test(dataProvider="getData")
	
     public void loginerror(String username, String pass) {
		
		landingPage landingPage=new landingPage(driver);
		landingPage.loginaction(username,pass);
		driver.findElements(By.cssSelector(".col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted"));
		
		
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		Object [][] data= {{"qa@qa.com", "Password"}, {"qwert@y.com", "Password"}};
		return data;
	}

}
