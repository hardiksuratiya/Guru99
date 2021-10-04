package Guru99.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewBankAccount {
	WebDriver ldriver;
	public NewBankAccount(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy (xpath="//a[normalize-space()='New Account']")
	@CacheLookup
	WebElement lnkNewAccount;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement txtCustID;
	
	@FindBy (name="selaccount")
	@CacheLookup
	WebElement drpSelectAccount;
	
	@FindBy (name="inideposit")
	@CacheLookup
	WebElement txtInitiDeposite;
	
	@FindBy (name="button2")
	@CacheLookup
	WebElement btnSubmit;
	public void clickonNewAccount()
	{
		lnkNewAccount.click();
	}
	public void EnterCustumerID(String CustID)
	{
		txtCustID.sendKeys(CustID);
	}
	public void SelectAccountType(String accountType) {
		Select drp = new Select(drpSelectAccount);
		drp.selectByVisibleText(accountType);
	}
	public void InitialDeposit(int amount)
	{
		txtInitiDeposite.sendKeys(String.valueOf(amount));
	}
	public void clickonSubmit()
	{
		btnSubmit.click();
	}

}
