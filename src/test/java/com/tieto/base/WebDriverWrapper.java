package com.tieto.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tieto.utils.PropUtils;

public class WebDriverWrapper {
	
 protected WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void init(@Optional("ch") String sBrowser) throws IOException
	{
		
		System.out.println(sBrowser);
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
		
		if (sBrowser.toLowerCase().equals("ch"))
		{
			driver = new ChromeDriver();
		}
		else if (sBrowser.toLowerCase().equals("ff"))
		{
			
			driver = new FirefoxDriver();
			
		}
		
         
		String url=PropUtils.getValueFromKey("testdata/data.properties", "url");
		
		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void end()
	{
	   driver.quit();	
	}
	

}
