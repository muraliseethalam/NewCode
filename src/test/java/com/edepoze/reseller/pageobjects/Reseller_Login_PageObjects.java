package com.edepoze.reseller.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Reseller Login
public class Reseller_Login_PageObjects {

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
	}
	public void EnterNewPassword() throws Exception {
		driver.findElement(NewPassword).sendKeys(OutputData.EnterClientPassword());
	}
	public void ClickOnSave() throws Exception {
		driver.findElement(ClickOnSave).click();
	}
	public void EnterConfirmPassword() throws Exception {
		driver.findElement(ConfirmPassword).sendKeys(OutputData.EnterClientPassword());
	}

	public void EnterClientUsername() throws Exception {
		driver.findElement(UserName).sendKeys(OutputData.EnterClientUserName());
	}
	public void EnterEnterClientPassword() throws Exception {
		driver.findElement(Password).sendKeys(OutputData.EnterClientPassword());
	}
	public void EnterEnterpriseUserName() throws Exception {
		driver.findElement(UserName).sendKeys(OutputData.EnterEnterpriseUserName());
	}
	public void EnterEnterprisePassword() throws Exception {
		driver.findElement(Password).sendKeys(OutputData.EnterEnterprisePassword());
	}

	public void EnterUsername() throws Exception {
		driver.findElement(UserName).sendKeys(readconfig.ResellerUsername());
		
	}
	public void EnterPassword() throws Exception {
		Thread.sleep(2000);
		driver.findElement(Password).sendKeys(readconfig.ResellerPassword());
	}

	public void Getpassword() throws Exception {
		String Getpassword=driver.findElement(UserName).getAttribute("value");
		System.out.println(Getpassword);
		obj.WriteExcel("Sheet1", Getpassword, 0, 1);

		//		String Getpassword=driver.findElement(UserName).getText();
		//		gettext.outdata(Getpassword);

	}

	public void ClickOnLogin() throws InterruptedException {
		driver.findElement(Login).click();
	}
	public void ForgotPassword() {
		driver.findElement(ForgotPassword).click();
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




	}

	public void EnterpriseLoginValidation() throws InterruptedException {
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//span[text()='Add Client']")).isDisplayed()){

				Screenshots.usernamescreenshot(driver, "Resellerlogin");
				System.out.println("Enterprise Login Failed");
			}
		} catch (Exception e) {

			Screenshots.usernamescreenshot(driver, "Resellerlogin");
			System.out.println("Enterprise Login is Success");
		}


	}

	public void AcceptTermsConditions() throws Exception {

		Thread.sleep(1000);
		EventFiringWebDriver scrolldown=new EventFiringWebDriver(driver);
		scrolldown.executeScript("document.querySelector('.tosPopup').scrollTop=1000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@data-fullid='mainform.termsOfService.btnOK']")).click();	

	}



}
