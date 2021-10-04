package Guru99.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Guru99.PageObject.LoginPage;
import Guru99.Utilities.XLUtils;

public class TC_NewBankAccount_004	 extends BaseClass{

	@Test
	public void NewBankAccount() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("mngr357211");
		lp.setPassword("ysuhunA");
		lp.clickSubmit();
		Thread.sleep(2000);
		
		String path="/Users/patel/eclipse-workspace/Guru99WebApplication/src/test/java/Guru99/TestData/testdatalogin.xlsx";
		Guru99.PageObject.NewBankAccount bankaccount = new Guru99.PageObject.NewBankAccount(driver);
		bankaccount.clickonNewAccount();
		bankaccount.EnterCustumerID(XLUtils.getCellData(path, "Sheet1", 1, 5));
		bankaccount.SelectAccountType("Current");
		bankaccount.InitialDeposit(10000);
		bankaccount.clickonSubmit();
		captureScreen(driver,"NewBankAccount");
		
		String accountnum=driver.findElement(By.xpath("//*[@id='account']/tbody/tr[4]/td[2]")).getText();
		XLUtils.setCellData(path, "Sheet1", 1, 6, accountnum);
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		Thread.sleep(2000);
		
	}	
}
