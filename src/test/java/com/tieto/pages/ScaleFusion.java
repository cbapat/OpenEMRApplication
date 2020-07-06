package com.tieto.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScaleFusion {

	
	////div[@class='recaptcha-checkbox-border']
	
	
	//https://scalefusion.com/
	
	@Test
	public void Launch()
	{
		
		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
	
	driver.get("https://scalefusion.com/");
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//a[@class='free-trial pill']")).click();
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
	
	
	driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
	
	
	
	
	
	}
}
