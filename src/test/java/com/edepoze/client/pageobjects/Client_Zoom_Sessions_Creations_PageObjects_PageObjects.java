package com.edepoze.client.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;


/**
 * @author MuraliSeethalam
 *
 */

// Zoom Session Creation
public class Client_Zoom_Sessions_Creations_PageObjects_PageObjects {

	public static Logger logger;
	WebDriver driver;
	

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
	By ScheduleaVideoConference=By.id("meeting_required");
	By EnterMeetingsHostEmail=By.name("meeting_shost");
	By EnterMeetingRegistrantsEmail=By.name("meeting_registrants");
	By ClickOnSave=By.xpath("//span[text()='Save']");

	By ClickOnAddfolder=By.xpath("//span[text()='Add Folder']");
	By EnterFolderName=By.name("folderName");
	By ClickOnSaveFolder=By.xpath("//input[@onclick='saveFolder(0)']");
	By ClickOnAddDocuments=By.xpath("//span[text()='Add Documents']");
	By ClickOnAddFiles=By.xpath("//input[@type='file']");
	By ClickOnClose=By.xpath("(//input[@value='Close'])[2]");

	By ClickOnSignIn=By.xpath("//a[text()='Sign in']");
	By EnterEmailId	=By.xpath("//input[@autocomplete='username']");
	By ClickOnNext=By.xpath("//span[text()='Next']");
	By EnterPassword=By.name("password");
	By SearchEmail=By.xpath("//input[@placeholder='Search all conversations']");
	By ClickOnEmail=By.xpath("(//span[text()='Deposition Of MAT Deposition Session Zoom'])[2]");
	By ClickOnEmail1=By.xpath("(//span[text()='Deposition Of MAT WitnessPrep Session Zoom'])[2]");
	By ClickOnEmail2=By.xpath("(//span[text()='Deposition Of MAT Trial Session Zoom'])[2]");
	By ClickOnEmail3=By.xpath("(//span[text()='Deposition Of MAT Arbitration Session Zoom'])[2]");
	By ClickOnEmail4=By.xpath("(//span[text()='Deposition Of MAT Mediation Session Zoom'])[2]");
	By ClickOnWitnessPrep=By.xpath("//div[text()='Witness Prep']");
	By ClickOnTrial=By.xpath("//div[text()='Trial']");
	By ClickOnArbitration=By.xpath("//div[text()='Arbitration']");
	By ClickOnMediation=By.xpath("//div[text()='Mediation']");
	By ZoomMailLinkValidation=By.xpath("//img[@src='asset/images/join.png']");

	ReadConfigPropertiesFile readconfig=new ReadConfigPropertiesFile();

	public void EnterDepositonName() throws Exception {
		Thread.sleep(2000);
		driver.findElement(EnterDepositionName).sendKeys("MAT AFolder Validation");;	
		logger.info("Entered session name");

	}

	public void ClickOnMediation() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnMediation).click();	
		logger.info("Clicked on mediation");

	}

	public void ClickOnTrial() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnTrial).click();	
		logger.info("Clicked on trail");

	}
	public void ClickOnArbitration() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnArbitration).click();		
		logger.info("Clicked on arbitration");

	}
	public void ClickOnEmail1() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnEmail1).click();
		logger.info("Clicked on email - 1");

		
	}
	public void ClickOnEmail2() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnEmail2).click();
		logger.info("Clicked on email - 2");

	}
	public void ClickOnEmail3() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnEmail3).click();
		logger.info("Clicked on email - 3");

	}
	public void ClickOnEmail4() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnEmail4).click();
		logger.info("Clicked on email - 4");

	}
	public void ClickOnWitnessPrep() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnWitnessPrep).click();		
		logger.info("Clicked on witness prep");

	}
	public void ClickOnSignIn() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnSignIn).click();	
		logger.info("Clicked on signin");

	}
	public void ClickOnNext() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnNext).click();
		logger.info("Clicked on next");

	}
	public void SearchEmail() throws Exception {
		Thread.sleep(2000);
		driver.findElement(SearchEmail).sendKeys("noreply@edepoze.com", Keys.ENTER);
		logger.info("Searched email");

	}
	public void ClickOnEmail() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnEmail).click();
		logger.info("Clicked on email");

	}
	public void ClickOnCase() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnCase).click();	
		logger.info("Clicked on case");

	}
	public void ClickOnAddSession() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnAddSession).click();	
		logger.info("Clicked on Add Session Button");

	}
	public void ClickOnDeposition() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnDeposition).click();	
		logger.info("Clicked on deposition");

	}
	public void ClearDepositionName() throws InterruptedException {

		driver.findElement(EnterDepositionName).clear();	
		logger.info("Cleared session name");

	}
	public void EnterTrialName() throws InterruptedException {

		driver.findElement(EnterDepositionName).sendKeys("MAT Trial Session Zoom");	
		logger.info("Entered trail session name");

	}
	public void EnterDepositionName() throws InterruptedException {

		driver.findElement(EnterDepositionName).sendKeys("MAT Deposition Session Zoom");	
		logger.info("Entered deposition session name");

	}
	public void EnterWitnessPrepnName() throws InterruptedException {

		driver.findElement(EnterDepositionName).sendKeys("MAT WitnessPrep Session Zoom");	
		logger.info("Entered WitnessPrep session name");

	}
	public void EnterArbitrationName() throws InterruptedException {

		driver.findElement(EnterDepositionName).sendKeys("MAT Arbitration Session Zoom");	
		logger.info("Entered arbitration session name");

	}
	public void EnterMediationnName() throws InterruptedException {

		driver.findElement(EnterDepositionName).sendKeys("MAT Mediation Session Zoom");	
		logger.info("Entered mediation session name");

	}

	public void Entervolume() throws InterruptedException {

		driver.findElement(Entervolume).sendKeys("2");	
		logger.info("Entered volume");

	}
	public void SearchIntroducingPartyName() throws Exception {
		Thread.sleep(1000);
		driver.findElement(SearchIntroducingPartyName).sendKeys(OutputData.RegisterEmailId());	
		logger.info("Searched introducing party name");

	}
	public void AgainSearchIntroducingPartyName() throws Exception {
		Thread.sleep(1000);
		driver.findElement(SearchIntroducingPartyName).sendKeys("hgf");	
		logger.info("Again searched introducing party name");

	}

	public void ClickOnIntroducingPartyName() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnIntroducingPartyName).click();
		logger.info("Cliked on introducing party name");

	}
	public void SelectOnCourtReportingFirmName() throws InterruptedException {
		Thread.sleep(1000);
		WebElement coutry = driver.findElement(SelectOnCourtReportingFirmName);
		Thread.sleep(1000);
		Select select =new Select(coutry);
		select.selectByVisibleText(readconfig.CourtReportingFirmName());
		logger.info("Selected court reporting firm name");

	}
	public void EnterLocation() throws InterruptedException {
//System.out.println("Test");
		driver.findElement(EnterLocation).sendKeys("New York");
		logger.info("Entered location");

		
	}
	public void ScrollDown() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");

	}
	public void ClearSessionPasscode() throws InterruptedException {

		driver.findElement(ClearSessionPasscode).clear();
		logger.info("Cleared session passcode");

	}
	public void EnterSessionPasscode() throws InterruptedException {

		driver.findElement(EnterSessionPasscode).sendKeys("12345");
		logger.info("Entered session passcode");

	}
	public void ClicOnScheduleaVideoConference() throws InterruptedException {

		driver.findElement(ScheduleaVideoConference).click();
		logger.info("Clicked on shedule video conference");

	}
	public void EnterMeetingsHostEmail() throws InterruptedException {

		driver.findElement(EnterMeetingsHostEmail).sendKeys("murali.seethalam@genysoft.com");
		logger.info("Entered meeting host e-mail ID");

	}
	public void EnterMeetingRegistrantsEmail() throws InterruptedException {

		driver.findElement(EnterMeetingRegistrantsEmail).sendKeys("edepozeautomationtesting@gmail.com");
		logger.info("Entered meeting registrant e-mail ID");

	}
	public void ClickOnSave() throws InterruptedException {
		Thread.sleep(500);
		WebElement SaveButton=driver.findElement(ClickOnSave);
		boolean Button=SaveButton.isDisplayed();
		if(Button) {
			//System.out.println("Save Button Displayed");
			driver.findElement(ClickOnSave).click();
		}
		else {
			System.out.println("Not Displayed");
		}

		Thread.sleep(5000);
		logger.info("Clicked on save");

		//driver.findElement(ClickOnSave).click();
	}
	public void ClickOnAddfolder() throws InterruptedException {

		driver.findElement(ClickOnAddfolder).click();
		logger.info("Clicked on Add Folder button");

	}

	//	public void EnterNonZoomFolderName() throws InterruptedException {
	//		Thread.sleep(2000);
	//		driver.findElement(EnterFolderName).sendKeys("Non Zoom Deposition Session");
	//	}

	public void EnterZoomFolderName() throws InterruptedException {

		driver.findElement(EnterFolderName).sendKeys("MAT Zoom Folder");
		logger.info("Entered folder name");

	}
	public void ClickOnSaveFolder() throws InterruptedException {

		driver.findElement(ClickOnSaveFolder).click();
		logger.info("Clicked on save folder");

	}
	public void ClickOnAddDocuments() throws InterruptedException {

		driver.findElement(ClickOnAddDocuments).click();
		logger.info("Clicked on add documents");

	}

	public void UploadDocuments() throws InterruptedException, IOException {
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
		logger.info("Click on close");

	}
	public void DocumentValidation() throws InterruptedException {
		Thread.sleep(2000);
		String DisplayedCount=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
		String str=DisplayedCount;
		String numberOnly= str.replaceAll("[^0-9]", "");

		//		System.out.println("Total Names Displayed Coumt: " + numberOnly);
		Assert.assertEquals("11", numberOnly);
		System.out.println("Successfully Uploaded Files");
		logger.info("Uploaded documents");

	
	}
	public void FolderValidation() throws InterruptedException {
		Thread.sleep(3000);
		String newfolder="MAT Zoom Folder";
		List<WebElement> folder=driver.findElements(By.xpath("//table[@class='folder_list innerTable']/tbody/tr/td[3]"));
		String[] beforesort=new String[folder.size()];

		for(int i=0; i<folder.size();i++) {
			beforesort[i]=folder.get(i).getText().trim();
			System.out.println(beforesort[i]);
			if(newfolder.matches(beforesort[i])) {
				System.out.println("Sucessfully Created Folder");
			}
		}

	}
	public Client_Zoom_Sessions_Creations_PageObjects_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");

	}
	public void MeetingLinkValidation() throws InterruptedException {

		Thread.sleep(2000);
		
		if(driver.findElement(ZoomMailLinkValidation).isDisplayed()) {
		   System.out.println("Succefully Navigating To Session Join Page");	
		}
		else {
			System.out.println("Mail link Verification Vaild");	
		}
		
		logger.info("Validated meeting link");
		Screenshots.usernamescreenshot(driver, "ZoomDepositionSessionCreation");
		logger.info("Captured Screenshot");

	}
	

	public void ArbitrationMeetingLinkValidation() throws InterruptedException {

		Thread.sleep(2000);
		Screenshots.usernamescreenshot(driver, "ZoomArbitrationSessionCreation");
		logger.info("Captured Screenshot");

	}

	public void MediationMeetingLinkValidation() throws InterruptedException {

		Thread.sleep(2000);
		Screenshots.usernamescreenshot(driver, "ZoomMediationSession");
		logger.info("Captured Screenshot");

	}

	public void TrailMeetingLinkValidation() throws InterruptedException {

		Thread.sleep(2000);
		Screenshots.usernamescreenshot(driver, "ZoomTrialSessionCreation");
		logger.info("Captured Screenshot");

	}

	public void WitnessPrepMeetingLinkValidation() throws InterruptedException {

		Thread.sleep(2000);
		Screenshots.usernamescreenshot(driver, "ZoomWitnessPrepSessionCreation");
		logger.info("Captured Screenshot");

	}


}
