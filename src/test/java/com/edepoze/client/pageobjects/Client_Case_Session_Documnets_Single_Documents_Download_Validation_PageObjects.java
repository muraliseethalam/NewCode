package com.edepoze.client.pageobjects;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Downloading Session Single Documents
public class Client_Case_Session_Documnets_Single_Documents_Download_Validation_PageObjects {
	
	public Client_Case_Session_Documnets_Single_Documents_Download_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		
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
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
	}
	public void ScroollDown() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
	}
	public void ClickOnDocument() throws Exception {
		driver.findElement(ClickOnDocument).click();
	}
	public void ClickOnDownload() throws Exception {
		driver.findElement(ClickOnDownload).click();
		Thread.sleep(1000);
		
	}
	public void WaituntilDownloed() throws Exception {
		Thread.sleep(10000);
		Screenshots.usernamescreenshot(driver, "CaseSessionSingleDocumentDownloadValidation");
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
		filelocation.delete();
		}
		}