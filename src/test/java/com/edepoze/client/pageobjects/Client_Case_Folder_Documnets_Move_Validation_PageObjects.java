package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;

// Moving Client Case Folder Documents
public class Client_Case_Folder_Documnets_Move_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	String name=new String();
	public Client_Case_Folder_Documnets_Move_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
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
		logger.info("Clicked on case");
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
		logger.info("Clicked on case folder");
	}
	public void ClickOnConfirmMove() {
		driver.findElement(ClickOnConfirmMove).click();
		logger.info("Clicked on confirm move");
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
		MoveDocumentName=DocumentName;	
		logger.info("Clicked on capture document name");
	}
	public void ClickOnMove() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMove).click();
		Thread.sleep(1000);
		logger.info("Clicked on move");
		Screenshots.usernamescreenshot(driver, "FolderDocumnetsMoveValidation");
		logger.info("Captured sceenshot");
	}
	public void ChooseCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
		logger.info("Clicked on choose case");
	}
	public void ChooseFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseFolder).click();
		logger.info("Clicked on choose folder");
	}
	
	
	public void SelectCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectCase).click();
		logger.info("Clicked on select case");
	}
	public void SelectFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectFolder).click();
		logger.info("Clicked on select folder");
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
	public void ClickOnMoveFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMoveFolder).click();
		logger.info("Clicked on move folder");
	}
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
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
		
		logger.info("Moved case folder documents");
	}
	
	
	
}