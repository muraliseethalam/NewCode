package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Deleting Session Folder
public class Client_Case_Session_Folder_Delete_Validation_PageObjects {
	WebDriver driver;
	
	public Client_Case_Session_Folder_Delete_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='Delete Folder']");
	By ClickOnDelete=By.xpath("(//span[text()='Delete'])[1]");
	By ClickOnConfirmDelete=By.xpath("//input[@value='Delete']");
	By VerifyDocumnet=By.xpath("//div[text()='Delete Folder']");
		
	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
	
	}
	public void ClickOnDelete() throws Exception {
		driver.findElement(ClickOnDelete).click();
	}
	public void ClickOnConfirmDelete() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnConfirmDelete).click();
	}
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void VerifyFolderDeltedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Failed At Deleting Case Session Folder");
				Thread.sleep(1000);
				Screenshots.usernamescreenshot(driver, "CaseSessionFolderDeleteValidation");
			}
			
		} catch (Exception e) {
			System.out.println("Successfully Deleted Case Session Folder");
			Thread.sleep(1000);
			Screenshots.usernamescreenshot(driver, "CaseSessionFolderDeleteValidation");
		}
	}

}
