package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	 private  By objUserName= By.id("authUser");
	 private  By objUserPass= By.id("clearPass");
	 private  By objLangDropDown=By.name("languageChoice");
	 private  By locMsg =By.xpath("//span[text()='Message Center']");
	 private By   objLogin= By.xpath(".//button");
	 private By objError= By.xpath("//div[@class='alert alert-danger login-failure m-1']");
	 
	 private WebDriver driver;
	 
	 public LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
		
		public  void enterUserName( String valUname)
		{
			
			driver.findElement(objUserName).sendKeys(valUname);
		
		}
		
		public  void enterPassword(	 String valPass)
		{
			
			driver.findElement(objUserPass).sendKeys(valPass);
		
		}
		
		public void selectDropdown(String val)
		{
			Select sDropDown=new Select(driver.findElement(objLangDropDown));
			sDropDown.selectByVisibleText(val);
			driver.findElement(By.xpath(".//button")).click();
		}
		
		public void clickLogin()
		{
			driver.findElement(objLogin).click();
		}
		
		
		public String verifyError()
		{
			
			return driver.findElement(objError).getText();
		}
	
	
	
/* private static By objUserName= By.id("authUser");
 private static By objUserPass= By.id("clearPass");
	
	public static void enterUserName(WebDriver driver, String valUname)
	{
		
		driver.findElement(objUserName).sendKeys(valUname);
	
	}
	
	public static void enterPassword(WebDriver driver, String valPass)
	{
		
		driver.findElement(objUserPass).sendKeys(valPass);
	
	}*/
	
	

}
