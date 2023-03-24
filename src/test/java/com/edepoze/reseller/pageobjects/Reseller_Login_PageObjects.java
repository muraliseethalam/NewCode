package com.edepoze.reseller.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Reseller Login
public class Reseller_Login_PageObjects {
	
	public static Logger logger;
	
	OutputData obj=new OutputData();
	
	//	eDepoze_Read_Config_File out=new eDepoze_Read_Config_File();
	ReadConfigPropertiesFile readconfig=new ReadConfigPropertiesFile();
	
	
	
	WebDriver driver;
	By UserName = By.name("username");
	By Password = By.name("password");
	By NewPassword = By.name("password");
	By ConfirmPassword = By.name("password2");
	By ClickOnSave = By.xpath("//span[text()='Save']");
	By Login = By.xpath("//button[text()='Login']");
	By ForgotPassword = By.xpath("//button[text()='Forgot Password?']");


	public Reseller_Login_PageObjects(WebDriver driver) {
		this.driver = driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
//		logger.info("Borwser launched");
	}
	public void EnterNewPassword() throws Exception {
		driver.findElement(NewPassword).sendKeys(OutputData.EnterClientPassword());
		logger.info("Borwser launched");
	}
	public void ClickOnSave() throws Exception {
		driver.findElement(ClickOnSave).click();
		logger.info("Clicked the save button");
	}
	public void EnterConfirmPassword() throws Exception {
		driver.findElement(ConfirmPassword).sendKeys(OutputData.EnterClientPassword());
		logger.info("Confirm password entered");
	}

	public void EnterClientUsername() throws Exception {
		driver.findElement(UserName).sendKeys(OutputData.EnterClientUserName());
		logger.info("Client username entered");
	}
	public void EnterEnterClientPassword() throws Exception {
		driver.findElement(Password).sendKeys(OutputData.EnterClientPassword());
		logger.info("Client password entered");
	}
	public void EnterEnterpriseUserName() throws Exception {
		driver.findElement(UserName).sendKeys(OutputData.EnterEnterpriseUserName());
		logger.info("Enterprise unsername entered");
	}
	public void EnterEnterprisePassword() throws Exception {
		driver.findElement(Password).sendKeys(OutputData.EnterEnterprisePassword());
		logger.info("Enterprise password entered");
	}

	public void EnterUsername() throws Exception {
		
		driver.findElement(UserName).sendKeys(readconfig.ResellerUsername());
		logger.info("Username Entered");
	}
	public void EnterPassword() throws Exception {
		Thread.sleep(2000);
		driver.findElement(Password).sendKeys(readconfig.ResellerPassword());
		logger.info("Password Entered ");
	}

	public void Getpassword() throws Exception {
		String Getpassword=driver.findElement(UserName).getAttribute("value");
		System.out.println(Getpassword);
		obj.WriteExcel("Sheet1", Getpassword, 0, 1);
		logger.info("Password getting..");

		//		String Getpassword=driver.findElement(UserName).getText();
		//		gettext.outdata(Getpassword);

	}

	public void ClickOnLogin() throws InterruptedException {
		driver.findElement(Login).click();
		logger.info("Clicked the login button");
	}
	public void ForgotPassword() {
		driver.findElement(ForgotPassword).click();
		logger.info("Clicked the forgot password");
	}

	public void LoginValidation() throws InterruptedException {
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//span[text()='Add Client']")).isDisplayed()){

				Screenshots.usernamescreenshot(driver, "Resellerlogin");
				System.out.println("Reseller Login Is Success");
			}
		} catch (Exception e) {

			Screenshots.usernamescreenshot(driver, "Resellerlogin");
			System.out.println("Reseller Login Failed");
		}

		logger.info("Reseller logedin successfully");

	}


	public void ClientLoginValidation() throws InterruptedException {
		//		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//span[text()=' Add New Case']")).isDisplayed()){
				System.out.println("Client Login is Success");
			}
		} catch (Exception e) {

			// TODO: handle exception
			System.out.println("Client Login Failed");
		}
		logger.info("Validated client login");



	}

	public void EnterpriseLoginValidation() throws InterruptedException {
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//span[text()='Add Client']")).isDisplayed()){

				Screenshots.usernamescreenshot(driver, "Resellerlogin");
				logger.info("Screenshot captured");
				System.out.println("Enterprise Login Failed");
			}
		} catch (Exception e) {

			Screenshots.usernamescreenshot(driver, "Resellerlogin");
			logger.info("Screenshot captured");
			System.out.println("Enterprise Login is Success");
		}

		logger.info("Validated enterprise login");
	}

	public void AcceptTermsConditions() throws Exception {

		Thread.sleep(1000);
		EventFiringWebDriver scrolldown=new EventFiringWebDriver(driver);
		scrolldown.executeScript("document.querySelector('.tosPopup').scrollTop=1000");
		logger.info("Scroll down");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-fullid='mainform.termsOfService.btnOK']")).click();	
		logger.info("Clicked the terms of service button");

	}



}
