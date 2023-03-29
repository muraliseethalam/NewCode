package com.edepoze.reseller.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	public static Logger logger;

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
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}

	//	Deactive Account Test Process

	public void SearchByClientName() throws Exception {
		driver.findElement(SearchByClientName).sendKeys(OutputData.ClientName());
		Thread.sleep(1000);
		logger.info("Searched by client name");
	}
	public void ClickOnGo() throws Exception {
		driver.findElement(ClickOnGo).click();
		Thread.sleep(1000);
		logger.info("Clicked the go button");
	}
	public void ConfirmDeactivated() throws Exception {
		driver.findElement(ConfirmDeactivated).click();
		logger.info("Clicked the Confirm Deactivated button");
	}
	public void ClickOnDeactivated() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(MouseMove)).build().perform();
		logger.info("Mouse hovered");
		driver.findElement(ClickOnDeactivated).click();
		logger.info("Clicked the deactivated button");
		Thread.sleep(2000);
		driver.findElement(ConfirmDeactivated).click();
		logger.info("Clicked the confirm deactivated button");
		Thread.sleep(2000);

	}

	public void ChecktheAccountDeactivatedorNot() throws Exception {
		WebElement Deactivated= driver.findElement(DeactivatedPath);
		if (Deactivated.isDisplayed()) {
			System.out.println("Account Deactivated Succesfully");
			Screenshots.usernamescreenshot(driver, "DeactiveAccount");
			logger.info("Screenshot captured");
		}
		else {
			System.out.println("Failed Account Deactivation");
			Screenshots.usernamescreenshot(driver, "DeactiveAccount");

		}
		logger.info("Acount deactivated");
	}

	//	Login With DeactiveLogins Test
	public void EnterDeactiveaccountUserID() throws Exception {
		driver.findElement(UserName).sendKeys(OutputData.EnterClientUserName());
		logger.info("Deactive account UserID entered");
	}
	public void EnterDeactiveaccountPaasword() throws Exception {
		driver.findElement(Password).sendKeys(OutputData.EnterClientPassword());
		logger.info("Deactive account password entered");
	}
	public void ClicOnLogin() throws Exception {
		driver.findElement(Login).click();
		logger.info("clicked the login button");
	}
	
	public void CaptureScreenshot() throws Exception {
		
	Thread.sleep(1000);
	Screenshots.usernamescreenshot(driver, "LoginActiveAccount");
	logger.info("Screenshot captured");
	}
	
	public void ValidateAccountDeactivatedorNot() throws Exception {
		Thread.sleep(2000);
		WebElement login=driver.findElement(UserName);
		if(login.isDisplayed()) {
			System.out.println("Success: User unable to login with deactive logins");
			
			Screenshots.usernamescreenshot(driver, "LoginWithDeactiveLogins");
			logger.info("Screenshot captured");
		}
		else {
			System.out.println("Failed: User is able to login with deactive logins");
			Screenshots.usernamescreenshot(driver, "LoginWithDeactiveLogins");

		}
		logger.info("validated account deactivate");

	}

	//	Activate Deactive Account Test Pocess
	public void SearchByDeactiveaccount() throws Exception {
		driver.findElement(SearchByClientName).sendKeys(OutputData.ClientName());
		logger.info("Searched by deactiveaccount");

	}
	public void ClickOnGo1() throws Exception {
		driver.findElement(ClickOnGo).click();
		logger.info("Clicked the on go button");
	}
	public void ClickOnActivateAccount() throws Exception {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(DeactivatedPath)).build().perform();
		logger.info("mouse overed");
		driver.findElement(ClickOnActive).click();
		logger.info("Clicked the activate button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Activate']")).click();
		logger.info("Clicked the confirm activate button button");
		//		driver.findElement(By.xpath("ConfirmActive")).click();
	}
	public void ChecktheAccountActivatedorNot() throws Exception {
		WebElement Deactivated= driver.findElement(ActivePath);
		if (Deactivated.isDisplayed()) {
			System.out.println("Successfully Account Activated");
			Screenshots.usernamescreenshot(driver, "ActivateTheDeactiveAccount");
			logger.info("Screenshot captured");
		}
		else {
			System.out.println("Failed Account Activation");
			Screenshots.usernamescreenshot(driver, "ActivateTheDeactiveAccount");
			logger.info("Screenshot captured");

		}
		logger.info("Validated account activate");
	}

	//     Login Active Account

	public void LoginActivedAccount() throws Exception {
		//		driver.findElement(UserName).sendKeys(readdata.ClientName());
		//		driver.findElement(Password).sendKeys(readdata.password());
		driver.findElement(Login).click();
		Thread.sleep(1000);
		logger.info("Clicked the login button");
		
	}


	public void AcceptTermsConditions() throws Exception {

		//		Thread.sleep(1000);

		try {
			if(driver.findElement(By.xpath("//p[text()='EDEPOZE TERMS OF SERVICE']")).isDisplayed()){
				EventFiringWebDriver scrolldown=new EventFiringWebDriver(driver);
				scrolldown.executeScript("document.querySelector('.tosPopup').scrollTop=1000");
				logger.info("Scroll down");
				//			Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@data-fullid='mainform.termsOfService.btnOK']")).click();
				logger.info("Clicked terms of service button");
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

		logger.info("Validated acount activate");


	}

}
