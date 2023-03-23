package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;

/**
 * @author MuraliSeethalam

 */

// Client Login
public class Client_Login_PageObjects {

	WebDriver driver;

	By Username=By.name("username");
	By Password=By.name("password");
	By Login=By.xpath("//button[text()='Login']");



	public Client_Login_PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void EnterUsername() throws Exception {
		driver.findElement(Username).sendKeys(OutputData.EnterClientUserName());
	}
	public void EnterPassword() throws Exception {
		driver.findElement(Password).sendKeys(OutputData.EnterClientPassword());
	}
	public void ClickOnLogin() throws Exception {
		driver.findElement(Login).click();
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void ClientLoginValidation() throws InterruptedException {

		try {
			if(driver.findElement(By.xpath("//span[text()=' Add New Case']")).isDisplayed()){
				Screenshots.usernamescreenshot(driver, "Clientlogin");
				System.out.println("Client Login is Success");
			}
		} catch (Exception e) {

			Screenshots.usernamescreenshot(driver, "Clientlogin");
			System.out.println("Client Login Failed");
		}


	}

	public void AcceptTermsConditions() throws Exception {
		
		try {
			if(driver.findElement(By.xpath("//p[text()='EDEPOZE TERMS OF SERVICE']")).isDisplayed()){
				EventFiringWebDriver scrolldown=new EventFiringWebDriver(driver);
				scrolldown.executeScript("document.querySelector('.tosPopup').scrollTop=1000");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@data-fullid='mainform.termsOfService.btnOK']")).click();	
			}

		} catch (Exception e) {

		}


	}


}
