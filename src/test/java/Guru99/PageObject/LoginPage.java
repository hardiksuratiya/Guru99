package Guru99.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

		WebDriver ldriver;
		public LoginPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(name="uid") 
		@CacheLookup
		WebElement txtUserName;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(name="btnLogin")
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(xpath="//a[normalize-space()='Log out']")
		@CacheLookup
		WebElement logoutbtn;
		
		
		//WebElement txtUserName=driver.findElement(By.name("uid"));
	//	WebElement txtPassword=driver.findElement(By.name("password"));
		//WebElement btnLogin=driver.findElement(By.name("btnLogin"));
		
		//txtUserName.sendKeys("mngr318652");
		//txtPassword.sendKeys("AvAsege");
		//btnLogin.click();
		 
		public void setUserName(String uname)
		{
			txtUserName.sendKeys(uname);
		}
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		public void clickSubmit()
		{
			btnLogin.click();
		}
		public void clicklogout()
		{
			logoutbtn.click();
		}
		
		
	

}
