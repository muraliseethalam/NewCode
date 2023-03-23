package com.edepoze.reseller.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;


//Client Activation And Deactivation
public class Reseller_Client_Activate_and_Deactivate_PageObjects {

	WebDriver driver;

	By SearchByClientName = By.xpath("//input[@onkeypress='clickSearch(event);']");
	By ClickOnGo=By.name("go");

	By MouseMove=By.xpath("//td[text()='Active']");
	By ClickOnDeactivated=By.xpath("//a[text()='Deactivate']");
	By ConfirmDeactivated=By.xpath("//input[@value='Deactivate']");

	By DeactivatedPath=By.xpath("//td[text()='Deactivated']");
	By ClickOnActive=By.xpath("//a[text()='Activate']");
	By ConfirmActive=By.xpath("//input[@value='Activate']");
	By ActivePath=By.xpath("//td[text()='Active']");



	By UserName = By.name("username");
	By Password = By.name("password");
	By Login = By.xpath("//button[text()='Login']");


	public Reseller_Client_Activate_and_Deactivate_PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	//	Deactive Account Test Process

	public void SearchByClientName() throws Exception {
		driver.findElement(SearchByClientName).sendKeys(OutputData.ClientName());
		Thread.sleep(1000);
	}
	public void ClickOnGo() throws Exception {
		driver.findElement(ClickOnGo).click();
		Thread.sleep(1000);
	}
	public void ConfirmDeactivated() throws Exception {
		driver.findElement(ConfirmDeactivated).click();
	}
	public void ClickOnDeactivated() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(MouseMove)).build().perform();
		driver.findElement(ClickOnDeactivated).click();
		Thread.sleep(2000);
		driver.findElement(ConfirmDeactivated).click();
		Thread.sleep(2000);

	}

	public void ChecktheAccountDeactivatedorNot() throws Exception {
		WebElement Deactivated= driver.findElement(DeactivatedPath);
		if (Deactivated.isDisplayed()) {
			System.out.println("Account Deactivated Succesfully");
			Screenshots.usernamescreenshot(driver, "DeactiveAccount");
		}
		else {
			System.out.println("Failed Account Deactivation");
			Screenshots.usernamescreenshot(driver, "DeactiveAccount");

		}
	}

	//	Login With DeactiveLogins Test
	public void EnterDeactiveaccountUserID() throws Exception {
		driver.findElement(UserName).sendKeys(OutputData.EnterClientUserName());
	}
	public void EnterDeactiveaccountPaasword() throws Exception {
		driver.findElement(Password).sendKeys(OutputData.EnterClientPassword());
	}
	public void ClicOnLogin() throws Exception {
		driver.findElement(Login).click();
	}
	
	public void CaptureScreenshot() throws Exception {
		
	Thread.sleep(1000);
	Screenshots.usernamescreenshot(driver, "LoginActiveAccount");
	}
	
	public void ValidateAccountDeactivatedorNot() throws Exception {
		Thread.sleep(2000);
		WebElement login=driver.findElement(UserName);
		if(login.isDisplayed()) {
			System.out.println("Success: User unable to login with deactive logins");
			Screenshots.usernamescreenshot(driver, "LoginWithDeactiveLogins");
		}
		else {
			System.out.println("Failed: User is able to login with deactive logins");
			Screenshots.usernamescreenshot(driver, "LoginWithDeactiveLogins");

		}


	}

	//	Activate Deactive Account Test Pocess
	public void SearchByDeactiveaccount() throws Exception {
		driver.findElement(SearchByClientName).sendKeys(OutputData.ClientName());

	}
	public void ClickOnGo1() throws Exception {
		driver.findElement(ClickOnGo).click();
	}
	public void ClickOnActivateAccount() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(DeactivatedPath)).build().perform();
		driver.findElement(ClickOnActive).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Activate']")).click();
		//		driver.findElement(By.xpath("ConfirmActive")).click();
	}
	public void ChecktheAccountActivatedorNot() throws Exception {
		WebElement Deactivated= driver.findElement(ActivePath);
		if (Deactivated.isDisplayed()) {
			System.out.println("Successfully Account Activated");
			Screenshots.usernamescreenshot(driver, "ActivateTheDeactiveAccount");
		}
		else {
			System.out.println("Failed Account Activation");
			Screenshots.usernamescreenshot(driver, "ActivateTheDeactiveAccount");

		}
	}

	//     Login Active Account

	public void LoginActivedAccount() throws Exception {
		//		driver.findElement(UserName).sendKeys(readdata.ClientName());
		//		driver.findElement(Password).sendKeys(readdata.password());
		driver.findElement(Login).click();
		Thread.sleep(1000);
	}


	public void AcceptTermsConditions() throws Exception {

		//		Thread.sleep(1000);

		try {
			if(driver.findElement(By.xpath("//p[text()='EDEPOZE TERMS OF SERVICE']")).isDisplayed()){
				EventFiringWebDriver scrolldown=new EventFiringWebDriver(driver);
				scrolldown.executeScript("document.querySelector('.tosPopup').scrollTop=1000");
				//			Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@data-fullid='mainform.termsOfService.btnOK']")).click();	
			}

		} catch (Exception e) {
			//			System.out.println("No Scroll down");
			// TODO: handle exception
		}


	}

	public void ValiditeAcountActivatedOrNot() throws InterruptedException {
		//		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//span[text()=' Add New Case']")).isDisplayed()){
				System.out.println("Client Login Success");
			}
		} catch (Exception e) {

			// TODO: handle exception
			System.out.println("Client Login Failed");
		}




	}

}
