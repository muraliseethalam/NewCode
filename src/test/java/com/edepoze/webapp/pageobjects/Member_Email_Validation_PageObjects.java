package com.edepoze.webapp.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Sending Documents Through Email

public class Member_Email_Validation_PageObjects  {

	WebDriver driver;
	public static Logger logger;
	public Member_Email_Validation_PageObjects(WebDriver driver) {

		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}


	By ClickOnSession=By.xpath("//div[text()='MAT Witness PrepSession Non Zoom']");
	By ClickOnFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnEmailButton=By.xpath("//div[@class='emailBtn']");
	By ClickOnEmail=By.xpath("//div[@class='okayBtn']");

	By EnterEmail = By.xpath("//input[@id='sendTo']");
	By EnterDescription = By.xpath("//textarea[@id='sendContents']");
	By ClickOnSend = By.xpath("//button[@id='dlgActionSend']");


	public void ClickOnSession() throws InterruptedException {

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked the member sesssion");
	}

	public void ClickOnFolder() {
		driver.findElement(ClickOnFolder).click();
		logger.info("Clicked the folder");
	}

	public void ClickOnEmailButton() throws InterruptedException {
		driver.findElement(ClickOnEmailButton).click();
		logger.info("Clicked the email button");

	}
	public void ClickOnEmail() throws InterruptedException {
		driver.findElement(ClickOnEmail).click();
		logger.info("Clicked the email");
	}

	public void EnterEmail() {
		driver.switchTo().defaultContent();
		driver.findElement(EnterEmail).sendKeys("indira.kapavarapu@genysoft.com");
		logger.info("Entered Email ID");
	}

	public void EnterDescription(){

		driver.findElement(EnterDescription).sendKeys("Hi,"+"\n"+"Please find the below attachment of eDepoze Documents");
		logger.info("Entered Description");
	}

	public void ClickOnSend() {

		driver.findElement(ClickOnSend).click();
		logger.info("Clicked on send");
	}




}
