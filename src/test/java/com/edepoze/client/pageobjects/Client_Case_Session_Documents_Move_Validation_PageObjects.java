package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Moving Session Documents
public class Client_Case_Session_Documents_Move_Validation_PageObjects {
	WebDriver driver;

	public Client_Case_Session_Documents_Move_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}

	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By ClickOnDocumnet=By.xpath("(//table[@class='file_list innerTable']//tr//td[1])[11]");
	By ClickOnMove=By.xpath("(//span[text()='Move'])[2]");
	By ChooseCase=By.xpath("(//span[@class='arrow button'])[1]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By ChooseSession=By.xpath("(//span[@class='arrow button'])[2]");
	By ChooseFolder=By.xpath("(//span[@class='arrow button'])[3]");
	By SelectFolder=By.xpath("//li[text()='MAT Non Zoom Folder']");
	By ClickOnmove=By.xpath("//input[@value='Move']");
	By Wait=By.xpath("//progress[@value='1']");
	By ClickOnClose=By.xpath("(//input[@value='Close'])[2]");
	By SearchDocumnet=By.xpath("(//div[text()='SampleXLSFile_6800kb.xls'])[2]");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnMovedDocumnetCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnMovedDocumnetSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnMovedFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By VerifyDocumnet=By.xpath("//div[text()='SampleXLSFile_6800kb.xls']");


	public void ClickOnCase() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnCase).click();
	}
	public void ChooseFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ChooseFolder).click();
	}
	public void SelectFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(SelectFolder).click();
	}
	
	
	
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
	}
	public void ClickOnDocumnet() throws Exception {
		driver.findElement(ClickOnDocumnet).click();
	}
	public void ClickOnMove() throws Exception {
		driver.findElement(ClickOnMove).click();
	}
	public void ChooseCase() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='field'])[1]")).click();
	}
	public void SelcetCase() throws Exception {
		Thread.sleep(2000);
		driver.findElement(SelectCase).click();	
	}
	public void ChooseSession() throws Exception {
		driver.findElement(ChooseSession).click();
	}

	
	public void ClickOnmove() throws Exception {
		driver.findElement(ClickOnmove).click();
	}
	public void ClickOnClose() throws Exception {
		Thread.sleep(2000);
		driver.findElement(Wait);
		Thread.sleep(2000);
		driver.findElement(ClickOnClose).click();
	}
	public void SearchDocumnet() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(SearchDocumnet).isDisplayed()){
				System.out.println("Failed: Case Session Document Doesn't Move");
			}

		} catch (Exception e) {
			System.out.println("Successfully Case Session Document Moved");
		}
	}
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void ClickOnCaseManagement() throws Exception {
		driver.findElement(ClickOnCaseManagement).click();
	}
	public void ClickOnMovedDocumnetCase() throws Exception {
		driver.findElement(ClickOnMovedDocumnetCase).click();
	}
	public void ClickOnMovedDocumnetSession() throws Exception {
		driver.findElement(ClickOnMovedDocumnetSession).click();
	}
	public void ClickOnMovedFolder() throws Exception {
		driver.findElement(ClickOnMovedFolder).click();
	}
	public void VerifyDocumnetMovedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Successfully Case Session Document Moved");
				Screenshots.usernamescreenshot(driver, "CaseSessionDocumentsMoveValidation");
			}

		} catch (Exception e) {
			System.out.println("Failed: Case Session Document Doesn't Move");
			Screenshots.usernamescreenshot(driver, "CaseSessionDocumentsMoveValidation");
		}
	}




}
