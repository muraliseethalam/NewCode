package com.edepoze.client.pageobjects;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import com.edepoze.utilitifiles.Screenshots;

// Client Case Folder Validation
public class Client_Add_Multiple_Folders_For_CaseFolder_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	public Client_Add_Multiple_Folders_For_CaseFolder_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnAddFolder=By.xpath("//span[text()='Add Folder']");
	By EnterFolderName=By.xpath("//input[@name='folderName']");
	By ClicOnSave=By.xpath("(//input[@type='button'])[8]");
	By ClicOnAddDocuments=By.xpath("//span[text()='Add Documents']");
	By WaitUntilDocumentsupload=By.xpath("//progress[@value='1']");
	By ClickOnclose=By.xpath("//input[@class='big-button green m_r0']");
	By ClickOnAddFiles=By.xpath("//input[@type='file']");
	By ClickOnCaseExhibits=By.xpath("//div[text()='Case Exhibits']");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnValidateCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	
	public void ClickOnCaseExhibits() throws InterruptedException{
		driver.findElement(ClickOnCaseExhibits).click();
		logger.info("Clicked on case exhibits");
	}
	public void ClickOnCaseManagement() throws InterruptedException{
		driver.findElement(ClickOnCaseManagement).click();
		logger.info("Clicked on case maangement");
	}
	public void ClickOnValidateCase() throws InterruptedException{
		driver.findElement(ClickOnValidateCase).click();
		logger.info("Clicked on validate case");
		
	}
	public void ClickOnCase() throws InterruptedException{
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnclose() throws InterruptedException{
		Thread.sleep(13000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(ClickOnclose).click();
		logger.info("Clicked on close");
	}
	public void ClickOnCaseFolder(){
		driver.findElement(ClickOnCaseFolder).click();
		logger.info("Clicked on case folder");
	}
	public void ClickOnAddFolder() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(ClickOnAddFolder).click();
		logger.info("Clicked Add Foldder button");
	}
	public void EnterCopyFolderName() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(EnterFolderName).sendKeys("CopyFolder");
		System.out.println("Successfully CopyFolder Created");
		logger.info("Created copy folder");
	}
	public void EnterMoveFolderName() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(EnterFolderName).sendKeys("MoveFolder");
		System.out.println("Successfully MoveFolder Created");
		logger.info("Created move folder");
	}
	public void EnterDeleteFolderName() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(EnterFolderName).sendKeys("DeleteFolder");
		System.out.println("Successfully DeleteFolder Created");
		logger.info("Created delete folder");
	}
	public void EnterCaseExhibitsName() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(EnterFolderName).sendKeys("EnterCaseExhibitsName");
		System.out.println("Successfully CaseExhibits Folder Created");
		logger.info("Created case exhibits folder");
	}
	public void EnterVlidateCaseFolderName() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(EnterFolderName).sendKeys("Validate Folder");
		System.out.println("Successfully Validate Folder Created");
		logger.info("Created validate folder");
	}
	public void ClicOnSave() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(ClicOnSave).click();
		logger.info("Clicked on save");
	}
	public void ClicOnAddDocuments() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(ClicOnAddDocuments).click();
		logger.info("Clicked Add Documents button");
	}
	public void UplodDocuments() throws InterruptedException{
		Thread.sleep(1000);
		WebElement uploadEle = driver.findElement(ClickOnAddFiles);
		LocalFileDetector detector = new LocalFileDetector();
		((RemoteWebElement)uploadEle).setFileDetector(detector);
		File file1 = detector.getLocalFile("./Sample Upload Documents/EN000001.pdf");
		File file2 = detector.getLocalFile("./Sample Upload Documents/file_example_PPT_250kB.ppt");
		File file3 = detector.getLocalFile("./Sample Upload Documents/fractogene.mp4");
		File file4 = detector.getLocalFile("./Sample Upload Documents/house_sparrow.mp3");
		File file5 = detector.getLocalFile("./Sample Upload Documents/pptx1.pptx");
		File file6 = detector.getLocalFile("./Sample Upload Documents/sample1.docx");
		File file7 = detector.getLocalFile("./Sample Upload Documents/sample1.xlsx");
		File file8 = detector.getLocalFile("./Sample Upload Documents/SampleDOCFile_2000kb.doc");
		File file9 = detector.getLocalFile("./Sample Upload Documents/SampleJPGImage_1mbmb.jpg");
		File file10 = detector.getLocalFile("./Sample Upload Documents/SamplePNGImage_100kbmb.png");
		File file11 = detector.getLocalFile("./Sample Upload Documents/SampleXLSFile_6800kb.xls");
		uploadEle.sendKeys(file1.getAbsolutePath(),"\n",file2.getAbsolutePath(),"\n",file3.getAbsolutePath(),"\n",file4.getAbsolutePath()
				,"\n",file5.getAbsolutePath(),"\n",file6.getAbsolutePath(),"\n",file7.getAbsolutePath(),"\n",file8.getAbsolutePath()
				,"\n",file9.getAbsolutePath(),"\n",file10.getAbsolutePath(),"\n",file11.getAbsolutePath());
		logger.info("Uploaded documents");
	}
	public void DocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully uploaded Case Folder files");
		logger.info("Documents Validated");
		Screenshots.usernamescreenshot(driver, "AddMultipleFoldersForCaseFolderValidation");
		logger.info("Captured screenshot");
	}
}