package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;

// Moving Case Folder 
public class Client_Case_Folders_Folder_Move_Validation_PageObjects {
	WebDriver driver;
	public Client_Case_Folders_Folder_Move_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
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
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
	}
	public void ClickOnMoveFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMoveFolder).click();
	}
	public void ClickOnMove() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMove).click();
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "ClientFolderOfCaseFolderMoveValidation");
		
	}
	public void ChooseCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
	}
	public void SelectCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectCase).click();
	}	
	public void ClickOnConfirmMove() throws InterruptedException {
		driver.findElement(ClickOnConfirmMove).click();
		
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
		
		
	}
	public void ClickOnCaseManagement() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseManagement).click();
	}
	public void ClickOnValidateCase() {
		driver.findElement(ClickOnValidateCase).click();
	}
	public void ClickOnMovedFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMovedFolder).click();
		Thread.sleep(1000);
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void ValidationForFolderMovedOrNot() throws InterruptedException {
		
		try {
			if(driver.findElement(ClickOnMove).isDisplayed()) {
				System.out.println("Successfully Moved Folder Of Case Folder");
			}
			
		} catch (Exception e) {
			System.out.println("Failed To Move Folder Of Case Folder");
		}
		
		
			
		
		
	}
	
	
	
}