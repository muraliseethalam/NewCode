package com.edepoze.client.pageobjects;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Downloading Single Document 
public class Client_Case_Folder_Single_Document_Downalod_Validation_PageObjects {
	WebDriver driver;
	
	public Client_Case_Folder_Single_Document_Downalod_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
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
	}
	
	public void ClickOnCaseFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseFolder).click();
	}
	public void ClickOnDeleteFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDeleteFolder).click();
	}
	public void ClickOnDocument() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDocument).click();
	}
	public void ClickOnDownload() throws Exception {
		Thread.sleep(3000);
		driver.findElement(ClickOnDownload).click();
		Thread.sleep(3000);
		Screenshots.usernamescreenshot(driver, "CaseFolderDocumnetsSingleDocumentDownloadValidation");
	}
	
	public void WaituntilDownloed() throws Exception {
		Thread.sleep(10000);
	}
	
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
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
		filelocation.delete();
		}
	
}