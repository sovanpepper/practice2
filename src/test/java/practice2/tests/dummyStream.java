package practice2.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dummyStream {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		WebElement dropdown=driver.findElement(By.id("page-menu"));
		Select select= new Select(dropdown);
		select.selectByIndex(2);
		List<WebElement> init=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));  //
//		List<String> names=init.stream().map(s->s.getText()).collect(Collectors.toList());
//		List<String> names2=names.stream().sorted().collect(Collectors.toList());
	//	Assert.assertTrue(names.equals(names2));
		
		for (int i=0; i<init.size(); i++) {
			
			if(init.get(i).getText().equalsIgnoreCase("Wheat")) {
				
				
	//			WebElement desired=driver.findElements(By.xpath("//table/tbody/tr")).get(i);
				System.out.println(driver.findElements(By.xpath("//td[3]")).get(i).getText());
				
			
				
		//		System.out.println(desired.findElement(By.xpath("//td")).getText());
			//	System.out.println(init.get(i).findElement(By.xpath("//td[3]")).getText());
				break;
				//table/tbody/tr[1]/td[3]
			}
			
			
			
		}
		
		
		driver.close();		
	}

}
