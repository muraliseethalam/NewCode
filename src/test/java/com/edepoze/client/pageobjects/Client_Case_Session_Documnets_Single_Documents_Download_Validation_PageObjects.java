package com.edepoze.client.pageobjects;
import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Downloading Session Single Documents
public class Client_Case_Session_Documnets_Single_Documents_Download_Validation_PageObjects {
	public static Logger logger;
	
	public Client_Case_Session_Documnets_Single_Documents_Download_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	WebDriver driver;
	
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By ClickOnDocument=By.xpath("//table[@class='file_list innerTable']//tr[2]//td[1]");
	By CaptureDocumentName=By.xpath("//table[@class='file_list innerTable']//tr[2]//td[2]");
	By ClickOnDownload=By.xpath("(//span[text()='Download'])[2]");
	
	ReadConfigPropertiesFile Downloadpath= new ReadConfigPropertiesFile();
	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked on session");
	}
	public void ScroollDown() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
		logger.info("Clicked on folder");
	}
	public void ClickOnDocument() throws Exception {
		driver.findElement(ClickOnDocument).click();
		logger.info("Clicked on document");
	}
	public void ClickOnDownload() throws Exception {
		driver.findElement(ClickOnDownload).click();
		Thread.sleep(1000);
		logger.info("Clicked on download");
		
	}
	public void WaituntilDownloed() throws Exception {
		Thread.sleep(10000);
		logger.info("Downloaded documents");
		Screenshots.usernamescreenshot(driver, "CaseSessionSingleDocumentDownloadValidation");
		logger.info("Captutred screenshot");
	}
	public void ValidatingUIAndDownloadedDocumentsAreSameOrNot() throws Exception {
		String Krishna=driver.findElement(CaptureDocumentName).getText();
		File filelocation=new File(System.getProperty("user.dir")+"\\"+Krishna);
		
		
		if(filelocation.exists()) {
			System.out.println("Successfully UI Documents format and Download Documents format of Case Session matched");
		}
		else {
			System.out.println("Failed: No File Found");
		}
		Thread.sleep(1000);
		
		logger.info("Validated UI and downloaded document");
		
		filelocation.delete();
		}
		}