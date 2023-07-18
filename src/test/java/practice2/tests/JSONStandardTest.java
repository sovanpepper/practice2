package practice2.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import practice2.pagecomponents.baseTest;
import practice2.pageobjects.cartPage;
import practice2.pageobjects.checkoutPage;
import practice2.pageobjects.confirmationPage;
import practice2.pageobjects.landingPage;
import practice2.pageobjects.orderpage;

public class JSONStandardTest extends baseTest {

	@Test(dataProvider="getData")
	
	public void standardtest(HashMap<String, String> input) throws IOException{

		landingPage landingPage=new landingPage(driver);
		landingPage.loginaction(input.get("email"),input.get("pw"));
		orderpage orderpage= new orderpage(driver);
		orderpage.productselection(input.get("productname"));		
		cartPage cartPage=new cartPage(driver);
		List<WebElement> sortedlist=cartPage.cartaddition(input.get("productname"));
       AssertJUnit.assertEquals(sortedlist.size(), 1);
       checkoutPage checkoutPage= new checkoutPage(driver);
       checkoutPage.countryselection(); 
       confirmationPage confirmationPage= new confirmationPage(driver);
       String orderConfirmation=confirmationPage.orderconfirm();
       AssertJUnit.assertEquals(orderConfirmation, "THANKYOU FOR THE ORDER.");
}
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data=jsonreadertoMap(System.getProperty("user.dir")+"/src/test/java/practice2/data/standardTest.JSON");
		return new Object [][] {{data.get(0)}, {data.get(1)}};
		
		
		
	}
}

//WebDriver driver=driverinitiation();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////driver.get("https://rahulshettyacademy.com/client/");
////driver.manage().window().maximize();
////driver.findElement(By.id("userEmail")).sendKeys("abcd@abcd.com");
////driver.findElement(By.id("userPassword")).sendKeys("March@2021");
////driver.findElement(By.id("login")).click();
//landingPage landingPage=new landingPage(driver);
//landingPage.loginaction();
//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(7));
//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted")));	
//List<WebElement> descp=driver.findElements(By.cssSelector(".col-lg-4.col-md-6.col-sm-10.offset-md-0.offset-sm-1.mb-3.ng-star-inserted"));		
// WebElement prod=descp.stream().filter(c->c.getText().contains("ZARA COAT 3")).findFirst().orElse(null);
// prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
//wait.until(ExpectedConditions.elementToBeClickable(By.id("toast-container")));
//driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();		
//List<WebElement> cartitems=driver.findElements(By.cssSelector(".cartWrap.ng-star-inserted"));		
//List<WebElement> sortedlist= cartitems.stream().filter(a->a.getText().contains("ZARA COAT 3")).collect(Collectors.toList());	
//Assert.assertEquals(sortedlist.size(), 1);
//driver.findElement(By.xpath("//div/ul/li[3]/button")).click();
//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
//List<WebElement> countries=driver.findElements(By.cssSelector(".ng-star-inserted"));       
//WebElement country=countries.stream().filter(b->b.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
//country.click();         
//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hero-primary")));
//String orderConfirmation=driver.findElement(By.cssSelector(".hero-primary")).getText();
//Assert.assertEquals(orderConfirmation, "THANKYOU FOR THE ORDER.");
//driver.close();


