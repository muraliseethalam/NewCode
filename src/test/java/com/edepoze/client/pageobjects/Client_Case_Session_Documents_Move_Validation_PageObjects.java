package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Moving Session Documents
public class Client_Case_Session_Documents_Move_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;

	public Client_Case_Session_Documents_Move_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
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
		logger.info("Clicked on case");
	}
	public void ChooseFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ChooseFolder).click();
		logger.info("Chossed folder");
	}
	public void SelectFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(SelectFolder).click();
		logger.info("Selected folder");
	}
	
	
	
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked on session");
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
		logger.info("Clicked on folder");
	}
	public void ClickOnDocumnet() throws Exception {
		driver.findElement(ClickOnDocumnet).click();
		logger.info("Clicked on document");
	}
	public void ClickOnMove() throws Exception {
		driver.findElement(ClickOnMove).click();
		logger.info("Clicked on move");
	}
	public void ChooseCase() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='field'])[1]")).click();
		logger.info("Chossed case");
	}
	public void SelcetCase() throws Exception {
		Thread.sleep(2000);
		driver.findElement(SelectCase).click();	
		logger.info("Selected case");
	}
	public void ChooseSession() throws Exception {
		driver.findElement(ChooseSession).click();
		logger.info("Choosed session");
	}

	
	public void ClickOnmove() throws Exception {
		driver.findElement(ClickOnmove).click();
		logger.info("Clicked on move");
	}
	public void ClickOnClose() throws Exception {
		Thread.sleep(2000);
		driver.findElement(Wait);
		Thread.sleep(2000);
		driver.findElement(ClickOnClose).click();
		logger.info("Clicked on close");
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
		logger.info("Searched document");
	}
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}
	public void ClickOnCaseManagement() throws Exception {
		driver.findElement(ClickOnCaseManagement).click();
		logger.info("Clicked on case management");
	}
	public void ClickOnMovedDocumnetCase() throws Exception {
		driver.findElement(ClickOnMovedDocumnetCase).click();
		logger.info("Clicked on moved case document");
	}
	public void ClickOnMovedDocumnetSession() throws Exception {
		driver.findElement(ClickOnMovedDocumnetSession).click();
		logger.info("Clicked on moved case session");
	}
	public void ClickOnMovedFolder() throws Exception {
		driver.findElement(ClickOnMovedFolder).click();
		logger.info("Clicked on moved folder");
	}
	public void VerifyDocumnetMovedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Successfully Case Session Document Moved");
				Screenshots.usernamescreenshot(driver, "CaseSessionDocumentsMoveValidation");
				logger.info("Captured screenshot");
			}

		} catch (Exception e) {
			System.out.println("Failed: Case Session Document Doesn't Move");
			Screenshots.usernamescreenshot(driver, "CaseSessionDocumentsMoveValidation");
			logger.info("Captured screenshot");
		}
	
		logger.info("Moved client case session documents");
		
	}

}
