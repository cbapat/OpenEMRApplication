package com.tieto.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;

public class AddPatientTest extends WebDriverWrapper{
	
	
	@Test
	public void createPatient() throws InterruptedException
	
	
	
	
	{
		
		
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select sDropDown=new Select(driver.findElement(By.name("languageChoice")));
		sDropDown.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath(".//button")).click();
		
		/*
		
        driver.findElement(By.xpath("//div[@class='menuLabel' and contains(.,'Patient/')]")).click();
		
		driver.findElement(By.xpath("//div[@class='menuLabel' and contains(.,'Patients')]")).click();
		
		driver.switchTo().frame("fin");
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("create_patient_btn1")).click();
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("pat");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("form_fname")).sendKeys("asfasfsdfsdf");
		
		driver.findElement(By.id("form_lname")).sendKeys("afaBapatsd");
		
		driver.findElement(By.id("form_DOB")).sendKeys("2012-07-02");
		
		Select selSex=new Select(driver.findElement(By.id("form_sex")));
		
		selSex.selectByVisibleText("Male");
		
		driver.findElement(By.id("create")).click();
		
		//modalframe
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("modalframe");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.alertIsPresent());
		
        Alert alt=driver.switchTo().alert();
		
		String altText= alt.getText();
		
		Thread.sleep(2000);
		
		System.out.println("Alert Text: "+altText);
		
		alt.accept();
		
		driver.findElement(By.className("closeDlgIframe")).click();*/
	}

}
