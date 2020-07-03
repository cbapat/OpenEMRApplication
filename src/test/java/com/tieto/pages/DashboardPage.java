package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	 private  By locMsg =By.xpath("//span[text()='Message Center']");
	 
	 private WebDriver driver;
	 
	 public DashboardPage(WebDriver driver)
	 {
		 this.driver=driver;
		 
	 }
	
	public void waitForMessageCentre()
	{
		WebDriverWait objWait=new WebDriverWait(driver, 30);
		
		objWait.until(ExpectedConditions.presenceOfElementLocated(locMsg));
		
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}

}
