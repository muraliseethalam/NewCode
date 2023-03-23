package com.edepoze.client.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;

// Deleting Client Case Folder Documents
public class Client_Case_Folder_Documnets_Delete_Validation_PageObjects {
	WebDriver driver;
	String name=new String();
	public Client_Case_Folder_Documnets_Delete_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
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
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
	}
	
	
	
	
	public void ClickOnDeleteFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDeleteFolder).click();
	}
	public void ClickOnDocument() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDocument).click();
	}
	public void CaptureDocumentName() throws Exception {
		String DocumentName=driver.findElement(CaptureDocumentName).getText();
		DeleteDocumentName=DocumentName;

	}
	public void ClickOnDelete() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDelete).click();
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "FolderDocumnetsDeleteValidation");
	}
	
	public void ClickOnConfirmDelete() {
		driver.findElement(ClickOnConfirmDelete).click();
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	
	public void ValidationForDocumentDeletedOrNot() throws Exception {
		
		try {
			
			if(driver.findElement(By.xpath("//div[text()='"+DeleteDocumentName+"']")).isDisplayed()) {
				System.out.println("Failed To Delete Case Folder Document");
				
			}
			
		} catch (Exception e) {
			System.out.println("Successfully Deleted Case Folder Documnet");
		}
		
		
	}
}