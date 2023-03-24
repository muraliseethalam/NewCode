package com.edepoze.client.pageobjects;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;

// Deleting Client Case Folder Documents
public class Client_Case_Folder_Documnets_Delete_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	String name=new String();
	public Client_Case_Folder_Documnets_Delete_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnDeleteFolder=By.xpath("//div[text()='DeleteFolder']");
	By ClickOnDocument=By.xpath("//table[@class='file_list innerTable']//tr[3]//td[1]");
	By CaptureDocumentName=By.xpath("//table[@class='file_list innerTable']//tr[3]//td[2]");
	By ClickOnDelete=By.xpath("(//span[text()='Delete'])[2]");
	By ClickOnConfirmDelete=By.xpath("//input[@value='Delete']");
	
	OutputData obj=new OutputData();
	public static String DeleteDocumentName=null;
	
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
	public void ClickOnDocument() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDocument).click();
		logger.info("Clicked on document");
	}
	public void CaptureDocumentName() throws Exception {
		String DocumentName=driver.findElement(CaptureDocumentName).getText();
		DeleteDocumentName=DocumentName;
		logger.info("Captured document name");

	}
	public void ClickOnDelete() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDelete).click();
		Thread.sleep(1000);
		logger.info("Clicked on delete");
		Screenshots.usernamescreenshot(driver, "FolderDocumnetsDeleteValidation");
		logger.info("Captured screenshot");
	}
	
	public void ClickOnConfirmDelete() {
		driver.findElement(ClickOnConfirmDelete).click();
		logger.info("Clicked on confirm delete");
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}
	
	
	public void ValidationForDocumentDeletedOrNot() throws Exception {
		
		try {
			
			if(driver.findElement(By.xpath("//div[text()='"+DeleteDocumentName+"']")).isDisplayed()) {
				System.out.println("Failed To Delete Case Folder Document");
				
			}
			
		} catch (Exception e) {
			System.out.println("Successfully Deleted Case Folder Documnet");
		}
		
		logger.info("Deleted case folder documents");
	}
}