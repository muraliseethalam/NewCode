package com.edepoze.client.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;

// Copying Case Folder
public class Client_Case_Folders_Folder_Copy_Validation_PageObjects{
	WebDriver driver;
	public Client_Case_Folders_Folder_Copy_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
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
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
	}
	public void ClickOnCopyFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopyFolder).click();
	}
	public void ClickOnCopy() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopy).click();
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "ClientFolderOfCaseFolderCopyValidation");
		
	}
	public void ChooseCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
	}
	public void SelectCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectCase).click();
	}	
	public void ClickConfirmCopy() {
		driver.findElement(ClickOnConfirmCopy).click();
	}
	public void ClickOnClose() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(ClickOnClose).click();
	}
	public void ClickOnCaseManagement() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseManagement).click();
	}
	public void ClickOnValidateCase() {
		driver.findElement(ClickOnValidateCase).click();
	}
	public void ClickOnCopiedFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopyFolder).click();
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
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
		
		
			
		
		
	}
	
	
	
}