package com.tieto.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;
import com.tieto.pages.DashboardPage;
import com.tieto.pages.LoginPage;
import com.tieto.utils.ExcelUtils;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class LoginTest extends WebDriverWrapper {
	
	
	
	@DataProvider
	public Object[][] fillData()
	{
		Object[][] data= new Object[2][4];
		
		data[0][0]="John";
		data[0][1]="John123";
		data[0][2]="Armenian";
		data[0][3]="Invalid username or password";
		
		data[1][0]="Paul";
		data[1][1]="Paul123";
		data[1][2]="Dutch";
		data[1][3]="Invalid username or password";
		
		return data;
		
	}
	
	//@Test ( priority=2, dataProvider="fillData")
	public void invalidCredentials(String un, String pass, String sDropdown, String sError)
	{
		

		LoginPage lObj=new LoginPage(driver);
		lObj.enterUserName( un);
		lObj.enterPassword( pass);
		//driver.findElement(By.id("authUser")).sendKeys("admin");
		//driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		
		lObj.selectDropdown(sDropdown);
		lObj.clickLogin();
		
		
		
		
		Assert.assertEquals(lObj.verifyError(), sError, null);
		
		//driver.close();
	}
	
	@DataProvider
	public Object[][] validCredentialsTestData() throws IOException
	{
		
		return ExcelUtils.getSheetIntoObject("testdata/OpenEMRData.xlsx", "validCredentialsTestData");
	}
	
	
    //@Test ( priority=1)
	@Test (dataProvider="readExcel", dataProviderClass=DemoTest.class)
	public void validCredentialsTest(String uname, String pass, String lang, String expTitle)
	{
		LoginPage lObj=new LoginPage(driver);
		
		lObj.enterUserName( uname);
		lObj.enterPassword( pass);
		//driver.findElement(By.id("authUser")).sendKeys("admin");
		
		//driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		
		lObj.selectDropdown(lang);
		lObj.clickLogin();
		
		DashboardPage dPage= new DashboardPage(driver);
		
		
		
		
		
		
		//assert.assertEquals(actualTitle, "OPEN");
		
		Assert.assertEquals(dPage.getPageTitle(), expTitle);
		
		//driver.close();
		
		
	}

}
