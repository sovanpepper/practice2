package practice2.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class ExceldrivenStandardTest extends baseTest {
	
	   DataFormatter formatter= new DataFormatter();


	@Test(dataProvider="getData")
	
	public void standardtest(String username, String pass, String productname) throws IOException{
		landingPage landingPage=new landingPage(driver);
		landingPage.loginaction(username,pass);
		orderpage orderpage= new orderpage(driver);
		orderpage.productselection(productname);		
		cartPage cartPage=new cartPage(driver);
		List<WebElement> sortedlist=cartPage.cartaddition(productname);
       AssertJUnit.assertEquals(sortedlist.size(), 1);
       checkoutPage checkoutPage= new checkoutPage(driver);
       checkoutPage.countryselection(); 
       confirmationPage confirmationPage= new confirmationPage(driver);
       String orderConfirmation=confirmationPage.orderconfirm();
       AssertJUnit.assertEquals(orderConfirmation, "THANKYOU FOR THE ORDER.");
}
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
		
		FileInputStream file= new FileInputStream("/users/sovansarthak/Downloads/testdata3.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowcount=sheet.getPhysicalNumberOfRows();
		Row firstrow=sheet.getRow(0);
		int columncount=firstrow.getLastCellNum();
		Object [][] data= new Object [rowcount-1][columncount];
		  for(int i=0; i<rowcount-1; i++) {
			  
			  Row row=sheet.getRow(i+1);
			  
			  for(int j=0; j<columncount; j++) {
				  
				  Cell cell=row.getCell(j);
				  data [i][j]=formatter.formatCellValue(cell);				  
			  }
			  
		  }
		workbook.close();  
		return data;
		
		
		
	}
}




