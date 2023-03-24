package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;

// Moving Case Folder 
public class Client_Case_Folders_Folder_Move_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	public Client_Case_Folders_Folder_Move_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnMoveFolder=By.xpath("//div[text()='MoveFolder']");
	By ClickOnMove=By.xpath("(//span[text()='Move'])[1]");
	By ChooseCase=By.xpath("(//span[@class='arrow button'])[1]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By ClickOnConfirmMove=By.xpath("(//input[@class='big-button blue'])[6]");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnValidateCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnMovedFolder=By.xpath("//div[text()='Moved Folder']");
	By CaptureDocumentName1=By.xpath("//table[@class='file_list innerTable']//tr//td[2]");
	
	public void ClickOnCase() {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
		logger.info("Clicked on case folder");
	}
	public void ClickOnMoveFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMoveFolder).click();
		logger.info("Clicked on move folder");
	}
	public void ClickOnMove() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMove).click();
		Thread.sleep(1000);
		logger.info("Clicked on move");
		Screenshots.usernamescreenshot(driver, "ClientFolderOfCaseFolderMoveValidation");
		logger.info("Captured screenshot");
		
	}
	public void ChooseCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
		logger.info("Chossed case");
		
	}
	public void SelectCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectCase).click();
		logger.info("Selected case");
	}	
	public void ClickOnConfirmMove() throws InterruptedException {
		driver.findElement(ClickOnConfirmMove).click();
		logger.info("Clicked on confirm move");
		
	}
	public void SearchMovedFolder() throws InterruptedException {
		Thread.sleep(1000);
		try {
			
			if(driver.findElement(ClickOnMoveFolder).isDisplayed()) {
				System.out.println("Successfully Moved Folder Of Case Folder");
				
			}
			
		} catch (Exception e) {
			System.out.println("Failed To Move Folder Of Case Folder");
		}
		logger.info("Searched move folder");
		
	}
	public void ClickOnCaseManagement() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseManagement).click();
		logger.info("Clicked on case management");
	}
	public void ClickOnValidateCase() {
		driver.findElement(ClickOnValidateCase).click();
		logger.info("Clicked on validate case");
	}
	public void ClickOnMovedFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMovedFolder).click();
		Thread.sleep(1000);
		logger.info("Clicked on move folder");
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		logger.info("Scrolled down");
		
	}
	
	public void ValidationForFolderMovedOrNot() throws InterruptedException {
		
		try {
			if(driver.findElement(ClickOnMove).isDisplayed()) {
				System.out.println("Successfully Moved Folder Of Case Folder");
			}
			
		} catch (Exception e) {
			System.out.println("Failed To Move Folder Of Case Folder");
		}
		
		
		logger.info("Moved folder of client case folder");	
		
		
	}
	
	
	
}