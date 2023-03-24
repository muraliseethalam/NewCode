package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Copying Session Folder
public class Client_Case_Session_Folder_Copy_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;

	public Client_Case_Session_Folder_Copy_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}

	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='Copy Folder']");
	By ClickOnCopy=By.xpath("(//span[text()='Copy'])[1]");
	By ChooseCase=By.xpath("(//div[@class='field'])[1]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By ChooseSession=By.xpath("(//span[@class='arrow button'])[2]");
	By SelectSession=By.xpath("((//ul[@class='_custom_select_list']))[2]");
	By ClickOncopy=By.xpath("//input[@value='Copy']");
	By Wait=By.xpath("//progress[@value='11']");
	By ClickOnClose=By.xpath("(//input[@value='Close'])[2]");
	By SearchFolder=By.xpath("//div[text()='Copy Folder']");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnCopyDocumnetCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnCopyDocumnetSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnCopyFolder=By.xpath("//div[text()='Copy Folder']");
	By VerifyDocumnet=By.xpath("//div[text()='Copy Folder']");


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

	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}

	public void ClickOnCopy() throws Exception {
		driver.findElement(ClickOnCopy).click();
		logger.info("Clicked on copy");
		
	}
	public void ChooseCase() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
		logger.info("Chossen case");
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
	public void SearchFolder() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(SearchFolder).isDisplayed()){
				System.out.println("Successfully Case Session Folder Copied");
			}

		} catch (Exception e) {
			System.out.println("Failed at Copying Case Session Folder");
		}
		logger.info("Searched folder");
}
	

	public void ClickOnCaseManagement() throws Exception {
		driver.findElement(ClickOnCaseManagement).click();
		logger.info("Clicked on case management");
	}
	public void ClickOnCopyFolderCase() throws Exception {
		driver.findElement(ClickOnCopyDocumnetCase).click();
		logger.info("Clicked on copy case folder document");
	}
	public void ClickOnCopyFolderSession() throws Exception {
		driver.findElement(ClickOnCopyDocumnetSession).click();
		logger.info("Clicked on copy case session document");
	}
	public void VerifyFolderCopiedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Successfully Case Session Folder Copied");
				Thread.sleep(1000);
				Screenshots.usernamescreenshot(driver, "CaseSessionFolderCopyValidation");
			}

		} catch (Exception e) {
			System.out.println("Failed at Copying Case Session Folder");
			Thread.sleep(1000);
			Screenshots.usernamescreenshot(driver, "CaseSessionFolderCopyValidation");
		}
		
		logger.info("Copied case session folder");
	}

}
