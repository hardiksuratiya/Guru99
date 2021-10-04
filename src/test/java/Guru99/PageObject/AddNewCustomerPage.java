package Guru99.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}	
		
		@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
		@CacheLookup
		WebElement lnkAddNewCustomer;
		
		@FindBy (name="name")
		@CacheLookup
		WebElement txtCustomerName;
		
		@FindBy (name="rad1")
		@CacheLookup
		WebElement rdGender;
		
		@FindBy (id="dob")
		@CacheLookup
		WebElement txdob;
		
		@FindBy (name="addr")
		@CacheLookup
		WebElement txtaddress;
		
		@FindBy (name="city")
		@CacheLookup
		WebElement txtcity;
		
		@FindBy (name="state")
		@CacheLookup
		WebElement txtstate;
		
		@FindBy (name="pinno")
		@CacheLookup
		WebElement txtpin;
		
		@FindBy (name="telephoneno")
		@CacheLookup
		WebElement txtphone;
		
		@FindBy (name="emailid")
		@CacheLookup
		WebElement txtemail;
		
		@FindBy (name="password")
		@CacheLookup
		WebElement txtpassword;
		
		@FindBy (name="sub")
		@CacheLookup
		WebElement btnsubmit;
		
		@FindBy (xpath="//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
		@CacheLookup
		WebElement captureCustId;
		
		public void clickAddNewCustomer()
		{
			lnkAddNewCustomer.click();
		}
		public void setCustomerName(String name)
		{
			txtCustomerName.sendKeys(name);
		}
		public void setGender(String gender)
		{
			rdGender.click();
		}
		public void setDoB(String mm , String dd , String yy)
		{
			txdob.sendKeys(mm);
			txdob.sendKeys(dd);
			txdob.sendKeys(yy);
		}
		public void setAddress(String value)
		{
			txtaddress.sendKeys(value);
		}
		public void setcity(String city)
		{
			txtcity.sendKeys(city);
		}
		public void setState(String state)
		{
			txtstate.sendKeys(state);
		}
		public void setpin(String pin)
		{
			txtpin.sendKeys(pin);
		}
		public void setPhone(String tele)
		{
			txtphone.sendKeys(tele);
		}
		public void setEmail(String email)
		{
			txtemail.sendKeys(email);
		}
		public void setPassword(String pass)
		{
			txtpassword.sendKeys(pass);
		}
		public void clickonSubmit()
		{
			btnsubmit.click();
		}
	
		
}
