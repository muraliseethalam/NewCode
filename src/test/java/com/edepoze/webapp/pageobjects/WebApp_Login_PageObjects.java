package com.edepoze.webapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;


// Member Login
public class WebApp_Login_PageObjects {

	//OutputData obj=new OutputData();
	ReadConfigPropertiesFile readconfig=new ReadConfigPropertiesFile();

	WebDriver driver;
	By Login = By.xpath("//button[text()='Login']");
	By username = By.xpath("//input[@placeholder='Type your Username']");
	By password = By.xpath("//input[@placeholder='Type your Password']");
	By Validation=By.xpath("//p[text()='Join']");


	public WebApp_Login_PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickonMemberlogin() throws InterruptedException {
		driver.findElement(Login).click();	
	}
	public void NavigateToWebApp() throws InterruptedException {
		String Environment=readconfig.Environment();
		
		if(Environment.contentEquals("sandbox")) {
			driver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");	
		}
		else if(Environment.contentEquals("staging")) {
			driver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");
		}
		else if(Environment.contentEquals("login")) {
			driver.get("https://webapp.edepoze.com/signin");
		}

	}

	public void enterusername() throws Exception {
		driver.findElement(username).sendKeys(OutputData.EnterClientUserName());
	}
	public void enterpassword() throws Exception {
		driver.findElement(password).sendKeys(OutputData.EnterClientPassword());

	}

	public void clickonlogin() {
		driver.findElement(Login).click();
	}
	public void Validation() throws InterruptedException {
		Thread.sleep(1000);
		try {
			if(driver.findElement(By.xpath("//p[text()='Join']")).isDisplayed()) {

				Screenshots.usernamescreenshot(driver, "Memberlogin");
				System.out.println("Member Login Is Success");


			}
		} catch (Exception e) {
			System.out.println("Member Login Failed");	
			Screenshots.usernamescreenshot(driver, "Memberlogin");
		}
	}


	
	
	
	


}