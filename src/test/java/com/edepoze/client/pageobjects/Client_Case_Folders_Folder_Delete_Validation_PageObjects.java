package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;

// Deleteing Case Folder
public class Client_Case_Folders_Folder_Delete_Validation_PageObjects {
	WebDriver driver;
	public Client_Case_Folders_Folder_Delete_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnDeleteFolder=By.xpath("//div[text()='DeleteFolder']");
	By ClickOnDelete=By.xpath("(//span[text()='Delete'])[1]");
	By ClickOnConfirmDelete=By.xpath("//input[@value='Delete']");
	
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
	public void ClickOnDelete() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDelete).click();
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "ClientFolderOfCaseFolderDeleteValidation");
	}
	
	public void ClickOnConfirmDelete() throws InterruptedException {
		driver.findElement(ClickOnConfirmDelete).click();
		Thread.sleep(1000);
	}	
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	public void ValidationForFolderDeletedOrNot() throws InterruptedException {
		
		try {
			if(driver.findElement(ClickOnDeleteFolder).isDisplayed()) {
				System.out.println("Failed To Delete Folder Of Case Folder");
			}
			
		} catch (Exception e) {
			System.out.println("Successfully Deleted Folder Of Case Folder");
		}
		
		
			
		
		
	}
	
	
	
}