package com.edepoze.client.pageobjects;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;

// Copying Case Folder
public class Client_Case_Folders_Folder_Copy_Validation_PageObjects{
	public static Logger logger;
	WebDriver driver;
	public Client_Case_Folders_Folder_Copy_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnCopyFolder=By.xpath("//div[text()='CopyFolder']");
	By ClickOnCopy=By.xpath("(//span[text()='Copy'])[1]");
	By ChooseCase=By.xpath("(//span[@class='arrow button'])[1]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By ClickOnConfirmCopy=By.xpath("(//input[@class='big-button blue'])[6]");
	By ClickOnClose=By.xpath("(//input[@class='big-button blue'])[6]");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnValidateCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnCopiedFolder=By.xpath("//div[text()='Validate Folder']");
	By CaptureDocumentName1=By.xpath("//table[@class='file_list innerTable']//tr//td[2]");
	
	public void ClickOnCase() {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
		logger.info("Clicked on case folder");
	}
	public void ClickOnCopyFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopyFolder).click();
		logger.info("Clicked on copy folder");
	}
	public void ClickOnCopy() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopy).click();
		Thread.sleep(1000);
		logger.info("Clicked on copy");
		Screenshots.usernamescreenshot(driver, "ClientFolderOfCaseFolderCopyValidation");
		logger.info("Captured screenshot");
		
	}
	public void ChooseCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
		logger.info("Choosed case");
	}
	public void SelectCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectCase).click();
		logger.info("Selected case");
	}	
	public void ClickConfirmCopy() {
		driver.findElement(ClickOnConfirmCopy).click();
		logger.info("Clicked on confirm copy");
	}
	public void ClickOnClose() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(ClickOnClose).click();
		logger.info("Clicked on close");
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
	public void ClickOnCopiedFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopyFolder).click();
		logger.info("Clicked on copy folder");
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		logger.info("Scrolled down");
	}
	
	public void ValidationForFolderCopiedOrNot() throws InterruptedException {
		Thread.sleep(1000);
		try {
			if(driver.findElement(ClickOnCopyFolder).isDisplayed()) {
				System.out.println("Successfully Copied Folder of Case Folder");
			}
			
		} catch (Exception e) {
			System.out.println("Failed To Copy Folder of Case Folder");
		}
		
		
			
		logger.info("Copied folder of client case folder");
		
	}
	
	
	
}