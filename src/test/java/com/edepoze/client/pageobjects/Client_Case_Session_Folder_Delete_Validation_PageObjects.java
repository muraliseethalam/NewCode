package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Deleting Session Folder
public class Client_Case_Session_Folder_Delete_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	
	public Client_Case_Session_Folder_Delete_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='Delete Folder']");
	By ClickOnDelete=By.xpath("(//span[text()='Delete'])[1]");
	By ClickOnConfirmDelete=By.xpath("//input[@value='Delete']");
	By VerifyDocumnet=By.xpath("//div[text()='Delete Folder']");
		
	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked on session");

	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
		logger.info("Clicked on folder");

	
	}
	public void ClickOnDelete() throws Exception {
		driver.findElement(ClickOnDelete).click();
		logger.info("Clicked on delete");

	}
	public void ClickOnConfirmDelete() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnConfirmDelete).click();
		logger.info("Clicked on confirm delete");

	}
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}
	public void VerifyFolderDeltedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Failed At Deleting Case Session Folder");
				Thread.sleep(1000);
				Screenshots.usernamescreenshot(driver, "CaseSessionFolderDeleteValidation");
				logger.info("Captured screenshot");
			}
			
		} catch (Exception e) {
			System.out.println("Successfully Deleted Case Session Folder");
			Thread.sleep(1000);
			Screenshots.usernamescreenshot(driver, "CaseSessionFolderDeleteValidation");
			logger.info("Captured screenshot");
		}
		
		
		logger.info("Deleted case session folder");
	}


}
