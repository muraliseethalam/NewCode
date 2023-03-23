package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;

// Moving Client Case Folder Documents
public class Client_Case_Folder_Documnets_Move_Validation_PageObjects {
	WebDriver driver;
	String name=new String();
	public Client_Case_Folder_Documnets_Move_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnDeleteFolder=By.xpath("//div[text()='DeleteFolder']");
	By ClickOnDocument=By.xpath("//table[@class='file_list innerTable']//tr[3]//td[1]");
	By CaptureDocumentName=By.xpath("//table[@class='file_list innerTable']//tr[3]//td[2]");
	By ClickOnMove=By.xpath("(//span[text()='Move'])[2]");
	By ChooseCase=By.xpath("(//span[@class='arrow button'])[1]");
	By ChooseFolder=By.xpath("(//span[@class='arrow button'])[2]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By SelectFolder=By.xpath("//li[text()='Validate Folder']");
	By ClickOnConfirmMove=By.xpath("//input[@value='Move']");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnValidateCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnMoveFolder=By.xpath("//div[text()='Validate Folder']");
	By CaptureDocumentName1=By.xpath("//table[@class='file_list innerTable']//tr//td[2]");
	
	
	OutputData obj=new OutputData();
	public static String MoveDocumentName=null;
	
	public void ClickOnCase() {
		driver.findElement(ClickOnCase).click();
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
	}
	public void ClickOnConfirmMove() {
		driver.findElement(ClickOnConfirmMove).click();
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
		MoveDocumentName=DocumentName;	
	}
	public void ClickOnMove() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMove).click();
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "FolderDocumnetsMoveValidation");
	}
	public void ChooseCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
	}
	public void ChooseFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseFolder).click();
	}
	
	
	public void SelectCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectCase).click();
	}
	public void SelectFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectFolder).click();
	}
	
	
	
	
	public void ClickOnCaseManagement() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseManagement).click();
	}
	public void ClickOnValidateCase() {
		driver.findElement(ClickOnValidateCase).click();
	}
	public void ClickOnMoveFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMoveFolder).click();
	}
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void ValidationForDocumentMoveedOrNot() throws Exception {
		Thread.sleep(1000);
		WebElement Moved=driver.findElement(By.xpath("//div[text()='"+MoveDocumentName+"']"));
		
		try {
			if(Moved.isDisplayed()) {
				System.out.println("Successfully Case Folder Documnet Moved");
			}
			
			
		} catch (Exception e) {
			System.out.println("Failed to Move Case Folder Document");
		}
		
		
	}
	
	
	
}