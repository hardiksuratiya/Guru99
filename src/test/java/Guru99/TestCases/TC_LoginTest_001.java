package Guru99.TestCases;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import Guru99.PageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password"); 
		
		lp.clickSubmit();
		logger.info("Click Login Button");
		
		System.out.println(driver.getTitle());
		logger.info("Getting Title of the Page");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test is Passed");
		}
		else
		{	
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test is Failed");
			
		}
		
		
	}

}
