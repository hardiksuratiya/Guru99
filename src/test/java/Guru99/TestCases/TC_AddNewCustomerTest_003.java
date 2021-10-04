package Guru99.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Guru99.PageObject.AddNewCustomerPage;
import Guru99.PageObject.LoginPage;
import Guru99.Utilities.XLUtils;

public class TC_AddNewCustomerTest_003 extends BaseClass {
	
	@Test
	public static void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("mngr357211");
		lp.setPassword("ysuhunA");
		lp.clickSubmit();
		Thread.sleep(2000);
		
		
		AddNewCustomerPage newcust = new AddNewCustomerPage(driver);
		newcust.clickAddNewCustomer();
		logger.info("providing customer details....");
		newcust.setCustomerName("johnsmith");
		newcust.setGender("Male");
		newcust.setDoB("02", "15", "1991");
		newcust.setAddress("235 West st");
		newcust.setcity("Surat");
		newcust.setState("Gujarat");
		newcust.setpin("390001");
		newcust.setPhone("9213698567");
		String email = randomString()+"@gmail.com";
		newcust.setEmail(email);
		String pwd= randomNumbers();
		newcust.setPassword(pwd);
		newcust.clickonSubmit();
		//driver.switchTo().alert().accept();
		Thread.sleep(3000);
		logger.info("Start Validating Test Case...");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			//captureScreen(driver,"addNewCustomer");
			logger.info("Test case is Passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("test case is failed....");
			captureScreen(driver,"addNewCustomer");
		}
		
		String path="/Users/patel/eclipse-workspace/Guru99WebApplication/src/test/java/Guru99/TestData/testdatalogin.xlsx";

		WebElement captureCustId=driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]"));
		String custId=captureCustId.getText();
		System.out.println(custId);
		XLUtils.setCellData(path, "Sheet1", 1, 5, custId);
		XLUtils.setCellData(path, "Sheet1", 1, 3, email);
		XLUtils.setCellData(path, "Sheet1", 1, 4, pwd);
		
	}
	
	
	
	
}
