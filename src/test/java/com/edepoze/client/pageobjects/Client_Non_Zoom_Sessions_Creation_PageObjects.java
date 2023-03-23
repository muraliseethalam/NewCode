/**
 * 
 */
package com.edepoze.client.pageobjects;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

/**
 * @author MuraliSeethalam
 */

// Non Zoom Session Creation
public class Client_Non_Zoom_Sessions_Creation_PageObjects {


	WebDriver driver;
	WebDriverWait wait;

	By ClickOnCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnMATZCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnAddSession=By.xpath("//span[text()='Add Session']");
	By ClickOnDeposition=By.xpath("//div[text()='Deposition']");
	By EnterDepositionName=By.name("depositionOf");
	By Entervolume=By.name("volume");
	By SearchIntroducingPartyName=By.name("ownerSearch");
	By ClickOnIntroducingPartyName=By.xpath("//div[@class='add_btn']");
	By SelectOnCourtReportingFirmName=By.name("title");
	By EnterLocation=By.name("location");
	By ClearSessionPasscode=By.name("sPasscode");
	By EnterSessionPasscode=By.name("sPasscode");
	By ClickOnSave=By.xpath("//span[text()='Save']");
	By ClickOnAddfolder=By.xpath("//a[@id='addFolderBtn']//span[text()='Add Folder']");
	By EnterFolderName=By.name("folderName");
	By ClickOnSaveFolder=By.xpath("//input[@onclick='saveFolder(0)']");
	By ClickOnAddDocuments=By.xpath("//span[text()='Add Documents']");
	By ClickOnAddFiles=By.xpath("//input[@type='file']");
	By ClickOnClose=By.xpath("//input[@id='btnDone']");	
	By ClickOnWitnessPrep=By.xpath("//div[text()='Witness Prep']");
	By ClicOnTrial=By.xpath("//div[text()='Trial']");
	By ClickOnArbitration=By.xpath("//div[text()='Arbitration']");
	By ClickOnMediation=By.xpath("//div[text()='Mediation']");



	public void ClickOnMediation() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnMediation).click();	
	}
	public void EnterDepositionName() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(EnterDepositionName).sendKeys("MAT Folder Validation Session");;	
	}
	public void EnterDepositionName1() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(EnterDepositionName).sendKeys("MAT AFolder Validation Session");;	
	}


	public void ClickOnMATZCase() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnMATZCase).click();		
	}



	public void ClickOnArbitration() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnArbitration).click();	
	}
	public void ClickOnWitnessPrep() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnWitnessPrep).click();	
	}
	public void ClicOnTrial() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClicOnTrial).click();	
	}
	public void ClearDepositionName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(EnterDepositionName).clear();
	}

	public void ClickOnCase() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnCase).click();	
	}
	public void ClickOnAddSession() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnAddSession).click();	
	}
	public void ClickOnDeposition() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnDeposition).click();	
	}

	public void Entervolume() throws InterruptedException {
		driver.findElement(Entervolume).sendKeys("2");	
	}
	public void SearchIntroducingPartyName() throws Exception {
		Thread.sleep(1000);
		driver.findElement(SearchIntroducingPartyName).sendKeys(OutputData.RegisterEmailId());	
	}
	public void AgainSearchIntroducingPartyName() throws Exception {
		Thread.sleep(1000);
		driver.findElement(SearchIntroducingPartyName).sendKeys(OutputData.RegisterEmailId());	
	}
	public void ClickOnIntroducingPartyName() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnIntroducingPartyName).click();
	}
	public void SelectOnCourtReportingFirmName() throws InterruptedException {
		Thread.sleep(1000);
		ReadConfigPropertiesFile readconfig=new ReadConfigPropertiesFile();
		WebElement coutry = driver.findElement(SelectOnCourtReportingFirmName);
		Thread.sleep(2000);
		Select select =new Select(coutry);
		select.selectByVisibleText(readconfig.CourtReportingFirmName());
	}
	public void EnterLocation() throws InterruptedException {
		driver.findElement(EnterLocation).sendKeys("New York");
	}
	public void ScrollDown() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void ClearSessionPasscode() throws InterruptedException {
		driver.findElement(ClearSessionPasscode).clear();
	}
	public void EnterSessionPasscode() throws InterruptedException {
		driver.findElement(EnterSessionPasscode).sendKeys("12345");
	}
	public void ClickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnSave).click();
	}
	public void ClickOnAddfolder() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(ClickOnAddfolder).click();
	}
	public void EnterFolderName() throws InterruptedException {
		
		driver.findElement(EnterFolderName).sendKeys("MAT Non Zoom Folder");
	}
	public void EnterMoveFolderName() throws InterruptedException {
		driver.findElement(EnterFolderName).sendKeys("Move Folder");
	}
	public void EnterCopyFolderName() throws InterruptedException {
		driver.findElement(EnterFolderName).sendKeys("Copy Folder");
	}
	public void EnterDeleteFolderName() throws InterruptedException {
		driver.findElement(EnterFolderName).sendKeys("Delete Folder");
	}
	public void ClickOnSaveFolder() throws InterruptedException {
		driver.findElement(ClickOnSaveFolder).click();
	}
	public void ClickOnAddDocuments() throws InterruptedException {
		driver.findElement(ClickOnAddDocuments).click();
	}

	public void UploadDocuments() throws InterruptedException, IOException, AWTException {
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

	}
	public void ClickOnClose() throws InterruptedException {
		By ClickOnclose=By.xpath("//input[@class='big-button green m_r0']");
		Thread.sleep(13000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(ClickOnclose).click();
	}
	public void ArbitrationDocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully Uploaded Files");
		Screenshots.usernamescreenshot(driver, "NonZoomArbitrationSessionCreation");
	}
	
	public void DepositionDocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully Uploaded Files");
		Screenshots.usernamescreenshot(driver, "NonZoomDepositionSessionCreation");
	}
	
	public void MediationDocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully Uploaded Files");
		Screenshots.usernamescreenshot(driver, "NonZoomMediationSessionCreation");
	}
	
	public void TrailDocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully Uploaded Files");
		Screenshots.usernamescreenshot(driver, "NonZoomTrialSessionCreation");
	}

	public void WitnessPrepDocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully Uploaded Files");
		Screenshots.usernamescreenshot(driver, "NonZoomWitnessPrepSessionCreation");
	}
	
	
	public void DocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully Uploaded Files");
		Screenshots.usernamescreenshot(driver, "DepositionSessionCreation");
	}

	

	public void WitnessPrepSessionName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(EnterDepositionName).sendKeys("MAT Witness PrepSession Non Zoom");	
	}
	public void TrialSessionName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(EnterDepositionName).sendKeys("MAT Trial Session Non Zoom");	
	}
	public void ArbitrationSessionName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(EnterDepositionName).sendKeys("MAT Arbitration Session Non Zoom");	
	}
	public void MediationSessionName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(EnterDepositionName).sendKeys("MAT Mediation Session Non Zoom");	
	}
	public void FolderValidation() throws InterruptedException {
		Thread.sleep(3000);
		String newfolder="MAT Non Zoom Folder";
		List<WebElement> folder=driver.findElements(By.xpath("//table[@class='folder_list innerTable']/tbody/tr/td[3]"));
		String[] beforesort=new String[folder.size()];

		for(int i=0; i<folder.size();i++) {
			beforesort[i]=folder.get(i).getText().trim();
			System.out.println(beforesort[i]);
			if(newfolder.matches(beforesort[i])) {
				System.out.println("Sucessfully Folder is Created");
			}
		}

	}
	public void MoveFolderValidation() throws InterruptedException {
		Thread.sleep(3000);
		String newfolder="Move Folder";
		List<WebElement> folder=driver.findElements(By.xpath("//table[@class='folder_list innerTable']/tbody/tr/td[3]"));
		String[] beforesort=new String[folder.size()];

		for(int i=0; i<folder.size();i++) {
			beforesort[i]=folder.get(i).getText().trim();
			System.out.println(beforesort[i]);
			if(newfolder.matches(beforesort[i])) {
				System.out.println("Sucessfully MoveFolder is Created");
			}
		}

	}
	public void CopyFolderValidation() throws InterruptedException {
		Thread.sleep(3000);
		String newfolder="Copy Folder";
		List<WebElement> folder=driver.findElements(By.xpath("//table[@class='folder_list innerTable']/tbody/tr/td[3]"));
		String[] beforesort=new String[folder.size()];

		for(int i=0; i<folder.size();i++) {
			beforesort[i]=folder.get(i).getText().trim();
			System.out.println(beforesort[i]);
			if(newfolder.matches(beforesort[i])) {
				System.out.println("Sucessfully CopyFolder is Created");
			}
		}

	}
	public void DeleteFolderValidation() throws InterruptedException {
		Thread.sleep(3000);
		String newfolder="Delete Folder";
		List<WebElement> folder=driver.findElements(By.xpath("//table[@class='folder_list innerTable']/tbody/tr/td[3]"));
		String[] beforesort=new String[folder.size()];

		for(int i=0; i<folder.size();i++) {
			beforesort[i]=folder.get(i).getText().trim();
			System.out.println(beforesort[i]);
			if(newfolder.matches(beforesort[i])) {
				System.out.println("Sucessfully DeleteFolder is Created");
			}
		}

	}



	public Client_Non_Zoom_Sessions_Creation_PageObjects(WebDriver driver) {
		this.driver=driver;

	}

}
