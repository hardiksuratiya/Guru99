package Guru99.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Guru99.PageObject.LoginPage;
import Guru99.Utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="logindata")
	public void LoginDDT(String usr , String pwd) throws InterruptedException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(usr);
		logger.info("User name Provided");
		lp.setPassword(pwd);
		logger.info("Pasword Provided");
		lp.clickSubmit();
		Thread.sleep(2500);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login Failed");
		}
		else
		{
			lp.clicklogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login Succesfull");
		}
		
	}
	
	public boolean isAlertPresent() //user defined method is created to check alert window is present or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@DataProvider(name="logindata")
	String[][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+"/src/test/java/Guru99/TestData/testdatalogin.xlsx";
		
		int rownum= XLUtils.getRowCount(path, "Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
