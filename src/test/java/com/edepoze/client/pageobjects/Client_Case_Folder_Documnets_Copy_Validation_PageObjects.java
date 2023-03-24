package com.edepoze.client.pageobjects;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.Screenshots;

// Case Folder Documents Copy
public class Client_Case_Folder_Documnets_Copy_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	public Client_Case_Folder_Documnets_Copy_Validation_PageObjects(WebDriver driver) {
		
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnDeleteFolder=By.xpath("//div[text()='DeleteFolder']");
	By ClickOnDocument=By.xpath("//table[@class='file_list innerTable']//tr[2]//td[1]");
	By CaptureDocumentName=By.xpath("//table[@class='file_list innerTable']//tr[2]//td[2]");
	By ClickOnCpy=By.xpath("(//span[text()='Copy'])[2]");
	By ChooseCase=By.xpath("(//span[@class='arrow button'])[1]");
	By ChooseFolder=By.xpath("(//span[@class='arrow button'])[2]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By SelectFolder=By.xpath("//li[text()='Validate Folder']");
	By ClickOnConfirmCopy=By.xpath("(//input[@class='big-button blue'])[6]");
	By ClickOnClose=By.xpath("(//input[@class='big-button blue'])[6]");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnValidateCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnCopyFolder=By.xpath("//div[text()='Validate Folder']");
	By CaptureDocumentName1=By.xpath("//table[@class='file_list innerTable']//tr//td[2]");
	ArrayList<String>DocumnetCapture=new ArrayList<String>();
	ArrayList<String>CopyDocumnetCapture=new ArrayList<String>();
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
	public void CaptureDocumentName() {
		List<WebElement>Krishna=driver.findElements(CaptureDocumentName);
		for (WebElement webElement1 : Krishna) {
			String CaptureName=webElement1.getText();
			DocumnetCapture.add(CaptureName);
			logger.info("Captured documents");
		}
	}
	public void ClickOnCpy() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCpy).click();
		Thread.sleep(1000);
		logger.info("Clicked on copy");
		Screenshots.usernamescreenshot(driver, "CaseFolderDocumnetsCopyValidation");
		logger.info("Captured screenshot");
		
	}
	public void ChooseCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
		logger.info("Choosed case");
	}
	public void ChooseFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ChooseFolder).click();
		logger.info("Choosed folder");
	}
	
	
	public void SelectCase() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectCase).click();
		logger.info("Selected case");
	}
	public void SelectFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SelectFolder).click();
		logger.info("Selected folder");
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
	}
	public void ClickOnCopyFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopyFolder).click();
		logger.info("Clicked on copy folder");
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}
	
	public void CaptureDocumentName1() throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement>Krishna=driver.findElements(CaptureDocumentName1);
		for (WebElement webElement1 : Krishna) {
			String CaptureName=webElement1.getText();
			CopyDocumnetCapture.add(CaptureName);
			logger.info("Captured document name");
		}
	}
	
	public void ValidationForDocumentCopiedOrNot() throws InterruptedException {
		Thread.sleep(1000);
		
		int CaptureSize=DocumnetCapture.size();
//		int CopyDocumnetCaptureName=CopyDocumnetCapture.size();
		
		for(int i=0; i<CaptureSize; i++) {
			if(DocumnetCapture.get(i).equals(CopyDocumnetCapture.get(i))) {
				System.out.println("Successfully Case Folder Document Copied");
				
			}
			else {
				System.out.println("Test Fail: Excepeted Document is "+DocumnetCapture.get(i)+" Actual Document is: "+CopyDocumnetCapture.get(i));
			}
		}
			
		logger.info("Copied case folder documents");
		
	}
	
	
	
}