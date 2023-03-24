package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;

// Deleteing Case Folder
public class Client_Case_Folders_Folder_Delete_Validation_PageObjects {
	public static Logger logger;

	WebDriver driver;
	public Client_Case_Folders_Folder_Delete_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnDeleteFolder=By.xpath("//div[text()='DeleteFolder']");
	By ClickOnDelete=By.xpath("(//span[text()='Delete'])[1]");
	By ClickOnConfirmDelete=By.xpath("//input[@value='Delete']");
	
	public void ClickOnCase() {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
		logger.info("Clicked on case folder");
	}
	public void ClickOnDeleteFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDeleteFolder).click();
		logger.info("Clicked on delete folder");
	}
	public void ClickOnDelete() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDelete).click();
		Thread.sleep(1000);
		logger.info("Clicked on delete");
		Screenshots.usernamescreenshot(driver, "ClientFolderOfCaseFolderDeleteValidation");
		logger.info("Captured screenshot");
	}
	
	public void ClickOnConfirmDelete() throws InterruptedException {
		driver.findElement(ClickOnConfirmDelete).click();
		Thread.sleep(1000);
		logger.info("Clicked on confirm delete");
	}	
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		logger.info("Scrolled down");
	}
	public void ValidationForFolderDeletedOrNot() throws InterruptedException {
		
		try {
			if(driver.findElement(ClickOnDeleteFolder).isDisplayed()) {
				System.out.println("Failed To Delete Folder Of Case Folder");
			}
			
		} catch (Exception e) {
			System.out.println("Successfully Deleted Folder Of Case Folder");
		}
		
		
			
		logger.info("Deleted folder of client case folder");
		
	}
	
	
	
}