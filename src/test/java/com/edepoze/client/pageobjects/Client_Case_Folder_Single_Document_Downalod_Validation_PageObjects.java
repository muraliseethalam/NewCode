package com.edepoze.client.pageobjects;
import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Downloading Single Document 
public class Client_Case_Folder_Single_Document_Downalod_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	
	public Client_Case_Folder_Single_Document_Downalod_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnDeleteFolder=By.xpath("//div[text()='DeleteFolder']");
	By ClickOnDocument=By.xpath("//table[@class='file_list innerTable']//tr[3]//td[1]");
	By CaptureDocumentName=By.xpath("//table[@class='file_list innerTable']//tr[3]//td[2]");
	By ClickOnDownload=By.xpath("(//span[text()='Download'])[2]");
	
	ReadConfigPropertiesFile Downloadpath= new ReadConfigPropertiesFile();
	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	
	public void ClickOnCaseFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseFolder).click();
		logger.info("Clicked on case folder");
	}
	public void ClickOnDeleteFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDeleteFolder).click();
		logger.info("Clicked on delete folder");
	}
	public void ClickOnDocument() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDocument).click();
		logger.info("Clicked on document");
	}
	public void ClickOnDownload() throws Exception {
		Thread.sleep(3000);
		driver.findElement(ClickOnDownload).click();
		Thread.sleep(3000);
		logger.info("Clicked on downloads");
		Screenshots.usernamescreenshot(driver, "CaseFolderDocumnetsSingleDocumentDownloadValidation");
		logger.info("Captured screenshot");
	}
	
	public void WaituntilDownloed() throws Exception {
		Thread.sleep(10000);
		logger.info("Downloaded document");
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
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
		
		logger.info("Validated UI and downloaded document");
		
		filelocation.delete();
		}
	
}