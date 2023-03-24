package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Copying Session Documents
public class Client_Case_Session_Documents_Copy_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;

	public Client_Case_Session_Documents_Copy_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}

	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By ClickOnDocumnet=By.xpath("(//table[@class='file_list innerTable']//tr//td[1])[7]");
	By ClickOnCopy=By.xpath("(//span[text()='Copy'])[2]");
	By ChooseCase=By.xpath("(//span[@class='arrow button'])[1]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By ChooseSession=By.xpath("(//span[@class='arrow button'])[2]");
	By SelectSession=By.xpath("((//ul[@class='_custom_select_list']))[2]");
	By ClickOncopy=By.xpath("//input[@value='Copy']");
	By Wait=By.xpath("//progress[@value='1']");
	By ClickOnClose=By.xpath("(//input[@value='Close'])[2]");
	By SearchDocumnet=By.xpath("//div[text()='sample1.xlsx']");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnCopiedDocumnetCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnCopiedDocumnetSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnCopiedFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By VerifyDocumnet=By.xpath("//div[text()='sample1.xlsx']");

	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
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

	public void ClickOnCopy() throws Exception {
		driver.findElement(ClickOnCopy).click();
		logger.info("Clicked on copy");
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


	public void ClickOncopy() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOncopy).click();
		logger.info("Clicked on copy");
	}
	public void ClickOnClose() throws Exception {
		Thread.sleep(1000);
		driver.findElement(Wait);
		Thread.sleep(2000);
		driver.findElement(ClickOnClose).click();
		logger.info("Clicked on close");
	}
	public void SearchDocumnet() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(SearchDocumnet).isDisplayed()){
				System.out.println("Successfully Document Copied");
			}

		} catch (Exception e) {
			System.out.println("Failed At Copying Document");
		}
		
		logger.info("Searched document");
	}
	public void ScroollDown() throws Exception {
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
		driver.findElement(ClickOnCopiedDocumnetCase).click();
		logger.info("Clicked on move document case");
	}
	public void ClickOnMovedDocumnetSession() throws Exception {
		driver.findElement(ClickOnCopiedDocumnetSession).click();
		logger.info("Clicked on move document session");
	}
	public void ClickOnMovedFolder() throws Exception {
		driver.findElement(ClickOnCopiedFolder).click();
		logger.info("Clicked on copied folder");
	}
	public void VerifyDocumnetCopiedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Successfully Document Copied");
				Screenshots.usernamescreenshot(driver, "CaseDocumentsCopyValidation");
			}

		} catch (Exception e) {
			System.out.println("Failed At Copying Document");
			Screenshots.usernamescreenshot(driver, "CaseDocumentsCopyValidation");
		}
	
		logger.info("Copied client case session documents");
		
	}
}
