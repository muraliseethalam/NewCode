/**
 * 
 */
package com.edepoze.webapp.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author MuraliKIrshnaSeethalam
 *
 */

//  Browsing Folders And Documents After Starting Session
public class Browse_Files_By_Clicking_Arrow_In_The_Left_Side_Arrow_PageObjects {
	WebDriver driver;
	public static Logger logger;

	public Browse_Files_By_Clicking_Arrow_In_The_Left_Side_Arrow_PageObjects(WebDriver driver) {
		this.driver=driver;	
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
		
	}




	By ClickOnMemberSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnCase=By.xpath("//div[@class='cases_btn']");
	By CapturingFolderNames=By.xpath("//div[@id='foldersList']//li//p[@class='folderName']");
	By ClickOnIntroduceDocumentsFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By CapturingDocumentNames=By.xpath("//div[@id='filesList']//li//p[@class='fileName']");
	By ClikOnDocument=By.xpath("(//p[@class='fileName'][contains(text(), '.pdf')])[1]");
	By WaitUntilDocumentsload=By.xpath("//div[text()='Loading...']");
	By ClickOnPresentation=By.xpath("//div[@class='presentation_btn']");
	By ClickOnStart=By.xpath("//span[text()='Start']");
	By ClickOnLeftSideArrow=By.xpath("//div[@id='openDragHandle']");
	By CaptureArrowFolderNames=By.xpath("//div[@id='fsFoldersList']//li//div[@class='folderLabel']");
	By CaptureArrowDocumentNames=By.xpath("//div[@id='fsFilesList']//li//div[@class='fileLabel']");




	ArrayList<String> CaptureFolderName=new ArrayList<String>();
	ArrayList<String> CaptureDocumentName=new ArrayList<String>();


	ArrayList<String> CaptureLeftsideFolderName=new ArrayList<String>();
	ArrayList<String> CaptureLeftDocumentNames=new ArrayList<String>();




	public void ClickOnMemberSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnMemberSession).click();
		logger.info("Clicked the member session");
	}
	public void ClickOnIntroduceDocumentsFolder() {
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();
		logger.info("Clicked introduce documents folder");
	}
	public void CapturingFolderNames() {
		List<WebElement> CaptureFolderNames=driver.findElements(CapturingFolderNames);
		for (WebElement Names : CaptureFolderNames) {
			String FolderNamess=Names.getText();
			CaptureFolderName.add(FolderNamess);
			System.out.println(FolderNamess);
			logger.info("Captured folder names");
		}
	}
	public void CapturingDocumentNames() {
		List<WebElement> CaptureDocumentNames=driver.findElements(CapturingDocumentNames);
		for (WebElement Names : CaptureDocumentNames) {
			String DocumentNamess=Names.getText();
			CaptureDocumentName.add(DocumentNamess);
			System.out.println(DocumentNamess);
			logger.info("Captured folder names");
		}
	}
	public void ClickOnPresentationDocumentsFolder() {
		driver.findElement(ClikOnDocument).click();	
		logger.info("Clicked the presentation documents folder");
	}
	public void WaitUnitlDocumnetload() {
		driver.switchTo().defaultContent();  
		driver.findElement(WaitUntilDocumentsload);
	}
	public void ClickOnLeftSideArrow() {
		driver.switchTo().defaultContent();  
		driver.findElement(ClickOnLeftSideArrow).click();
		logger.info("Clicked the left side arrow");


	}
	public void CapturingLeftsideFolderName() throws InterruptedException {
//		System.out.println("Krishna");
		Thread.sleep(2000);
		List<WebElement> CaptureLeftsideFolderNames=driver.findElements(CaptureArrowFolderNames);
		for (WebElement Names : CaptureLeftsideFolderNames) {
			String LeftsideFolderNames=Names.getText();
			CaptureLeftsideFolderName.add(LeftsideFolderNames);
			System.out.println(LeftsideFolderNames);
			logger.info("Captured left side folder names");

		}
	}
	public void CapturingLeftsideDocumentsName() {
		System.out.println("Murali");
		List<WebElement> CaptureLeftsidedocumentsNames=driver.findElements(CaptureArrowDocumentNames);
		for (WebElement Names : CaptureLeftsidedocumentsNames) {
			String LeftsideDocumentsNames=Names.getText();
			CaptureLeftDocumentNames.add(LeftsideDocumentsNames);
			System.out.println(LeftsideDocumentsNames);
			logger.info("Captured left side document names");

		}
	}
	public void ValidationFolderandDocuments() {
		Assert.assertEquals(CaptureDocumentName, CaptureLeftDocumentNames);
		Assert.assertEquals(CaptureFolderName, CaptureLeftsideFolderName);
		System.out.println("Folders And Documents Are Matched Successfully");
		logger.info("Validated folderand documents");


	}

}
