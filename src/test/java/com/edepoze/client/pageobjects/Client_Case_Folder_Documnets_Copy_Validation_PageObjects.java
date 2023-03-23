package com.edepoze.client.pageobjects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.Screenshots;

// Case Folder Documents Copy
public class Client_Case_Folder_Documnets_Copy_Validation_PageObjects {
	WebDriver driver;
	public Client_Case_Folder_Documnets_Copy_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
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
	public void CaptureDocumentName() {
		List<WebElement>Krishna=driver.findElements(CaptureDocumentName);
		for (WebElement webElement1 : Krishna) {
			String CaptureName=webElement1.getText();
			DocumnetCapture.add(CaptureName);
		}
	}
	public void ClickOnCpy() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCpy).click();
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "CaseFolderDocumnetsCopyValidation");
		
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
	public void ClickOnCopyFolder() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCopyFolder).click();
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void CaptureDocumentName1() throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement>Krishna=driver.findElements(CaptureDocumentName1);
		for (WebElement webElement1 : Krishna) {
			String CaptureName=webElement1.getText();
			CopyDocumnetCapture.add(CaptureName);
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
			
		
		
	}
	
	
	
}