package Guru99.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Guru99.Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	Guru99.Utilities.ReadConfig readconfig = new  ReadConfig();
	public String baseURL= readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{	 
		if(br.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver=new  ChromeDriver();
			}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (br.equals("safari"))
		{
			driver = new SafariDriver();
		}
		 
		 driver.get(baseURL);
		 logger= Logger.getLogger("eBanking");
		 PropertyConfigurator.configure("Log4j.properties");
		 
		 
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		//Thread.sleep(3000);
		driver.quit();
		
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+ "/ScreenShots/"+ tname + ".png");
		FileUtils.copyFile(source, Target);
		System.out.println("ScreenShot Taken");
			
	}
	
	
	
}
