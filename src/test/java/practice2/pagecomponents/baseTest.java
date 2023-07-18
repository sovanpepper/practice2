package practice2.pagecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
	
	public static WebDriver driver;

	
	@BeforeMethod	
		
	public WebDriver  driverinitiation() throws IOException {
		
		String browsername;
		Properties prop =new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/practice2/resources/GlobalData.properties");
		prop.load(file);
		
		if(System.getProperty("browser")!=null) {
			
			 browsername=System.getProperty("browser");
		}
		else {
			 browsername=prop.getProperty("browser");
			
		}
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();			
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();					
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
		}
		
		return driver;
		
	}
	
	@AfterMethod
	
	public void driverclose() {
		
	       driver.close();

	}
	
	public void takesscreenshot(String fileWithPath ) throws IOException {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
	
	public List<HashMap<String, String>> jsonreadertoMap(String filePath) throws IOException {
		
		String JSONData=FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(JSONData, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
	}
	
}
