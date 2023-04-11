
package com.edepoze.webapp.pageobjects;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Non Zoom WitnessPrep Session With Witness And Guest
public class NonZoom_WitnessPrep_Session_With_Witness_And_Guest_PageObjects {
	public static Logger logger;
	WebDriver driver;
	WebDriver Incognitodriver;
	WebDriver Firefoxdriver;
	ReadConfigPropertiesFile readconfig = new ReadConfigPropertiesFile();
	String Environment = readconfig.BrowserName();

	public NonZoom_WitnessPrep_Session_With_Witness_And_Guest_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}

	By ClickOnNonZoomDeposition=By.xpath("(//*[text()='Witness Prep'])[1]");
	By ClickOnBeginSession=By.xpath("//div[@id='btn_start_deposition']");
	By ClickOnBeginSessionOk=By.xpath("//button[@class='dialogOkBtn']");
	By ClickOnIntroduceDocumentsFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnDocuments=By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info'])");
	By WaitUntilDocumentsload=By.xpath("//div[text()='Loading...']");
	By ClickOnIntroduce=By.xpath("//p[text()='Introduce']");
	By WaitUntilDocumentOpen=By.xpath("//div[text()='Loading...']");
	By CLickOnDistribute=By.xpath("//button[@id='dialogTextInputClose']");
	By ClickOnBackButton=By.xpath("//div[@class='back_btn']");
	By CaptureSessionId=By.xpath("//p[@class='deposition_number']");
	By ClickOnViewPasscode=By.xpath("//p[@class='deposition_passcode']");
	By WitnessJoin=By.xpath("//button[text()='Join']");
	By EnterWitnessSessionID=By.xpath("(//input[@placeholder='Insert Your Session ID'])[2]");
	By EnterGuestSessionID=By.xpath("(//input[@placeholder='Insert Your Session ID'])[1]");
	By EnterGuestPassword=By.xpath("(//input[@placeholder='Insert Your Session Passcode'])[1]");
	By EnterWitnessName=By.xpath("(//input[@placeholder='Type your Name'])[2]");
	By EnterGuestName=By.xpath("(//input[@placeholder='Type your Name'])[1]");
	By EnterGuestEmailId=By.xpath("(//input[@placeholder='Type your Email'])[1]");
	By ClickOnLogin=By.xpath("//div[@class='jformbtn_nonmember']");
	By ClickOnGuestlogin=By.xpath("//div[@class='lformbtn_nonmember']");
	By ClickOnSkip=By.xpath("(//div[@class='app_bttn_new'])[1]");
	By Waitingforauthorisation=By.xpath("//span[text()='Cancel']");
	By AcceptWitnesslogin=By.xpath("//span[text()='Allow']");
	By ClickOnOfficialExhibits=By.xpath("//p[text()='Introduced']");
	By MemberIntrouduceDocuments=By.xpath("//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName']");
	By WitnessIntrouduceDocuments=By.xpath("//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName']");
	By ClickOnHighlightColor=By.xpath("(//img[@src='/img/ipad/button/btnMarkerU53x36.png'])[1]");
	By canvastag=By.id("pdf-page-canvas");
	By ClickOnPencilColor=By.xpath("(//img[@src='/img/ipad/button/btnPencilU53x36.png'])[1]");
	By ClickOnsave=By.xpath("//div[@class='btn_app_normal']//span[text()='Save']");
	By ClickOnBackButtonWitness=By.xpath("(//img[@src='/asset/images/arr.png'])[1]");
	By ClickOnCloseWtnessSave=By.xpath("//button[@id='dialog1BtnClose']");
	By WitnessSaveFolder=By.xpath("//p[text()='Witness Annotations']");
	By DocumentsPresentation=By.xpath("//p[@class='fileName'][contains(text(), '.pdf')]");
	By ClickOnPresentation=By.xpath("//div[@class='presentation_btn']");
	By ClickOnStart=By.xpath("//span[text()='Start']");
	By ClickOnNoteAnnotation=By.xpath("//img[@src='/img/ipad/button/btnNoteU53x36.png']");
	By EnterNote=By.xpath("//textarea[@placeholder='Enter Note']");
	By ClickOnCloseNote=By.xpath("//button[text()='Close']");
	By ClickOnCallout=By.xpath("//img[@src='/img/ipad/button/btnCalloutU188x154.png']");
	By ClickOnErase=By.xpath("//img[@src='/img/ipad/button/btnEraseU44x36.png']");
	By ClickOnUndo=By.xpath("//img[@src='/img/ipad/button/btnUndoU44x36.png']");
	By ClickOnShowThumbnails=By.xpath("//img[@src='/img/ipad/icons/thumb.png']");
	By ThumbnailCount=By.xpath("//div[@id='thumb-carousel']");
	By ClickOnNext=By.xpath("//div[@id='arrow-next-container']");
	By ClickOnArrowColor=By.xpath("(//img[@src='/img/ipad/button/btnArrowU53x36.png'])[1]");
	By StopPresentation=By.xpath("//div[@class='presentation_btn active']");

	ArrayList<String> SessionID=new ArrayList<String>();
	ArrayList<String> SessionPassword=new ArrayList<String>();
	ArrayList<String> MemberIntrouduceDocumentNames=new ArrayList<String>();
	ArrayList<String> WitnessIntrouduceDocumentNames=new ArrayList<String>();
	ArrayList<String> WitnessIntrouduceDocumentNames1=new ArrayList<String>();

	ArrayList<String> MemberIntrouduceDocumentToGuest=new ArrayList<String>();
	ArrayList<String> GuestIntrouduceDocumentNames=new ArrayList<String>();


	public void Driverquit() {
		Incognitodriver.quit();
		logger.info("Incognito browser quitted");
		Firefoxdriver.quit();
		logger.info("Firefox browser quitted");
	}

	public void EnterGuestSessionID() throws InterruptedException {
		Thread.sleep(2000);
		Firefoxdriver.findElement(EnterGuestSessionID).sendKeys(SessionID.toArray(new String[0]));
		logger.info("Entered guest session ID");
	}
	public void EnterGuestPassword() {
		Firefoxdriver.findElement(EnterGuestPassword).sendKeys(SessionPassword.toArray(new String[0]));
		logger.info("Entered guest password");
	}
	public void EnterGuestName() {
		Firefoxdriver.findElement(EnterGuestName).sendKeys("Guest Test");
		logger.info("Entered guest name");
	}
	public void EnterGuestEmailId() {
		Firefoxdriver.findElement(EnterGuestEmailId).sendKeys("guesttest@gmail.com");
		logger.info("Entered guest email");
	}
	public void ClickOnGuestlogin() throws InterruptedException {
		Firefoxdriver.findElement(ClickOnGuestlogin).click();
		logger.info("Clicked on guest login");

		Thread.sleep(5000);
		if(Firefoxdriver.findElement(By.xpath("//div[@class='logout_btn']")).isDisplayed()) {
			System.out.println("Guest Login Is Success");
		}
		else {
			System.out.println("Guest Login Failed");
		}
		
		logger.info("Guest logged in");
	}

	public void Guestlogin() {

		if (Environment.contentEquals("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			Firefoxdriver = new FirefoxDriver();
			logger.info("Firefox browser launched");


		}
		else if(Environment.contentEquals("firefox")) {
			WebDriverManager.chromedriver().setup();
			Firefoxdriver = new ChromeDriver();
			logger.info("Chrome browser launched");
		}

		else if(Environment.contentEquals("edgedriver")) {
			WebDriverManager.chromedriver().setup();
			Firefoxdriver = new ChromeDriver();
			logger.info("Edge browser launched");
		}

		Firefoxdriver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");
		logger.info("URL entered");
		Firefoxdriver.findElement(WitnessJoin).click();
		logger.info("Clicked on witness join button");
	}

	public void ClickOnOfficialExhibit() {
		driver.findElement(ClickOnOfficialExhibits).click();
		logger.info("Clicked on official exhibits");


	}
	public void Witnesslogin() {
		driver.manage().window().setSize(new Dimension(300, 800));
		driver.manage().window().setPosition(new Point(5,5));
		logger.info("Browser minimized");


		if (Environment.contentEquals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			Incognitodriver=new ChromeDriver(options);
			logger.info("Chrome browser launched");
		}
		else if(Environment.contentEquals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			Incognitodriver=new FirefoxDriver(options);
			logger.info("Firefox browser launched");
		}

		else if(Environment.contentEquals("edgedriver")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("-inprivate");
			Incognitodriver=new EdgeDriver(options);
			logger.info("edege browser launched");
		}
	}



	public void ClickOnNonZoomDepositionSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnNonZoomDeposition).click();
		logger.info("Clicked on non zoom deposition session");

	}
	public void ClickOnIntroduceDocumentsFolder() {
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();
		logger.info("Clicked on introduce documents folder");
	}
	public void BeginSession() {
		try {
			if(driver.findElement(ClickOnBeginSession).isDisplayed()) {
				driver.findElement(ClickOnBeginSession).click();	
				logger.info("Clicked on begin session button");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			driver.switchTo().defaultContent();
			if(driver.findElement(ClickOnBeginSessionOk).isDisplayed()) {
				driver.findElement(ClickOnBeginSessionOk).click();
				logger.info("Clicked on ok button");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void IntroduceDocuments() throws InterruptedException {
		driver.switchTo().frame(0);
		int Documnets=driver.findElements(ClickOnDocuments).size();

		for(int i=0; i<Documnets; i++) {
			int start=i+1;
			driver.findElement(By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info'])["+start+"]")).click();
			driver.switchTo().defaultContent();  
			driver.findElement(WaitUntilDocumentsload);
			logger.info("loading..");
			driver.findElement(ClickOnIntroduce).click();
			logger.info("Clicked on introduce button");
			driver.findElement(WaitUntilDocumentOpen);
			Thread.sleep(10000);
			driver.findElement(CLickOnDistribute).click();
			logger.info("Clicked on distribute button");
			try {
				driver.findElement(By.xpath("//div[@id='replace']")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			driver.findElement(WaitUntilDocumentOpen);
			driver.findElement(ClickOnBackButton).click();
			logger.info("Clicked on back button");
			driver.switchTo().frame(0);
		}

	}
	public void CaptureSessionIDPassword() throws InterruptedException {
		String Session=driver.findElement(CaptureSessionId).getText().split(" ")[1];
		SessionID.add(Session);
		logger.info("Captured Session ID");
		driver.findElement(ClickOnViewPasscode).click();
		logger.info("Clicked on view passode button");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		String passcode= driver.findElement(By.xpath("//span[@id='passcode']")).getText();
		SessionPassword.add(passcode);
		logger.info("Captured password");
		driver.findElement(By.xpath("//div[@id='dialogDepositionPasscode']")).click();

	}


	public void ClickJoin() {
		Incognitodriver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");
		logger.info("URL entered");
		Incognitodriver.findElement(WitnessJoin).click();
		logger.info("Clicked the witness join button");
	}	
	public void EnterSessionID() {
		Incognitodriver.findElement(EnterWitnessSessionID).sendKeys(SessionID.toArray(new String[0]));
		logger.info("Entered the session ID");
	}
	public void EnterWitnessName() {
		Incognitodriver.findElement(EnterWitnessName).sendKeys("Witness Test");
		logger.info("Entered the witness name");
	}
	public void ClickOnLogin() throws InterruptedException {
		Incognitodriver.findElement(ClickOnLogin).click();
		logger.info("Clicked the log in button");
		Incognitodriver.manage().window().setSize(new Dimension(300, 800));
		Incognitodriver.manage().window().setPosition(new Point(500,10));		
		logger.info("Browser minimized");
	}
	public void ClickOnSkip() throws InterruptedException {
		//Incognitodriver.switchTo().frame(0);
		Thread.sleep(2000);
		Incognitodriver.findElement(ClickOnSkip).click();
		logger.info("Clicked on skip");
	}
	public void AccepetWitnesslogin() throws InterruptedException {
		Thread.sleep(4000);
		if(Incognitodriver.findElement(Waitingforauthorisation).isDisplayed()) {
			driver.findElement(AcceptWitnesslogin).click();
			logger.info("Clicked on accepet witness button");
		}
		Thread.sleep(2000);
		if(Incognitodriver.findElement(By.xpath("//div[@class='logout_btn']")).isDisplayed()) {
			System.out.println("Witnes Login Is Success");
		}
		else {
			System.out.println("Witness Login Failed");
		}
		logger.info("Witness logged in");
		
	}

	public void ClickOnOfficialExhibits() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnOfficialExhibits).click();
		logger.info("Clicked on officeal exhibits");
	}
	public void ClickOnOfficialExhibitFolder() {
		//driver.switchTo().frame(0);
		driver.findElement(ClickOnOfficialExhibits).click();
		logger.info("Clicked on officeal exhibits folder");
	}
	public void VerifyIntorduceGuestDocuments() throws InterruptedException {

		List<WebElement> MemberIntrouduceDocumentsnames=driver.findElements(MemberIntrouduceDocuments);
		for (WebElement webElements : MemberIntrouduceDocumentsnames) {
			String MemberIntrouduceDocumentsname=webElements.getText();
			MemberIntrouduceDocumentToGuest.add(MemberIntrouduceDocumentsname);	
		}

		Thread.sleep(2000);
		Firefoxdriver.switchTo().frame(0);
		Thread.sleep(2000);
		List<WebElement> WitnessIntrouduceDocumentsnames=Firefoxdriver.findElements(WitnessIntrouduceDocuments);
		for (WebElement el : WitnessIntrouduceDocumentsnames) {
			String WitnessIntrouduceDocumentsname=el.getText();
			GuestIntrouduceDocumentNames.add(WitnessIntrouduceDocumentsname);
		}

		int MemberCount=MemberIntrouduceDocumentToGuest.size();
		System.out.println("Member Introduce Documents Count is: " +MemberCount);
		int WitnesCount=GuestIntrouduceDocumentNames.size();
		System.out.println("Guest Introduce Documents Count is: " +WitnesCount);
		Screenshots.usernamescreenshot(Firefoxdriver, "WitnessPrepSessionWithWitnessAndGuest");
		logger.info("Captured screenshot");
		Thread.sleep(2000);
		Assert.assertEquals(MemberCount, WitnesCount);
		System.out.println("Introduce Documents Are Same");
		Firefoxdriver.manage().window().setSize(new Dimension(300, 800));
		Firefoxdriver.manage().window().setPosition(new Point(900,8));
		logger.info("Browser minimized");
		logger.info("Verified introduce guest documents");
	}

	public void VerifyIntorduceDocuments() throws InterruptedException {

		List<WebElement> MemberIntrouduceDocumentsnames=driver.findElements(MemberIntrouduceDocuments);
		for (WebElement webElements : MemberIntrouduceDocumentsnames) {
			String MemberIntrouduceDocumentsname=webElements.getText();
			MemberIntrouduceDocumentNames.add(MemberIntrouduceDocumentsname);	
		}

		Thread.sleep(2000);
		Incognitodriver.switchTo().frame(0);
		Thread.sleep(2000);
		List<WebElement> WitnessIntrouduceDocumentsnames=Incognitodriver.findElements(WitnessIntrouduceDocuments);
		for (WebElement el : WitnessIntrouduceDocumentsnames) {
			String WitnessIntrouduceDocumentsname=el.getText();
			WitnessIntrouduceDocumentNames.add(WitnessIntrouduceDocumentsname);
		}

		int MemberCount=MemberIntrouduceDocumentNames.size();
		System.out.println("Member Introduce Documents Count is: " +MemberCount);
		int WitnesCount=WitnessIntrouduceDocumentNames.size();
		System.out.println("Witness Introduce Documents Count is: " +WitnesCount);
		logger.info("Captured screenshot");
		Screenshots.usernamescreenshot(Incognitodriver, "WitnessPrepSessionWithWitnessAndGuest");
		WitnessIntrouduceDocumentNames.removeAll(MemberIntrouduceDocumentNames);
		Assert.assertEquals(WitnessIntrouduceDocumentNames, WitnessIntrouduceDocumentNames1);
		System.out.println("Introduce Documents Are Same");
	    logger.info("Verified introduced documents");
	}

	public void WitenessAnnotationChangeDocuments() throws InterruptedException {
		int Documentscount=Incognitodriver.findElements(WitnessIntrouduceDocuments).size();

		for(int i=0; i<Documentscount; i++) {

			int counts=i+1;
			Incognitodriver.findElement(By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName'])["+counts+"]")).click();
			Incognitodriver.switchTo().defaultContent();

			try {
				Thread.sleep(2000);
				//				Incognitodriver.findElement(WaitUtilDocumentsload);
				Incognitodriver.findElement(ClickOnHighlightColor).click();
				logger.info("Clicked on highlight annotation button");
				Thread.sleep(2000);
				Incognitodriver.switchTo().frame(0);
				Incognitodriver.switchTo().frame(0);
				WebElement canvas =Incognitodriver.findElement(canvastag);
				new Actions(Incognitodriver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
				logger.info("Document marked");
				Incognitodriver.switchTo().defaultContent();
				Incognitodriver.findElement(WaitUntilDocumentsload);
				Incognitodriver.findElement(ClickOnPencilColor).click();
				logger.info("Clicked on pencil annotation button");
				Incognitodriver.switchTo().frame(0);
				Incognitodriver.switchTo().frame(0);
				//				WebElement canvas =driver.findElement(canvastag);
				new Actions(Incognitodriver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
				Incognitodriver.switchTo().defaultContent();
				Incognitodriver.findElement(ClickOnBackButtonWitness).click();
				Thread.sleep(2000);
				logger.info("Clicked on back button");
				Incognitodriver.findElement(ClickOnsave).click();
				Thread.sleep(5000);
				logger.info("Clicked the save button");
				Incognitodriver.switchTo().frame(0);

			} catch (Exception e) {
				//				Incognitodriver.findElement(WaitUtilDocumentsload);
				Thread.sleep(2000);
				Incognitodriver.findElement(ClickOnBackButtonWitness).click();
				Thread.sleep(5000);
				logger.info("Clicked on back button");
				Incognitodriver.switchTo().frame(0);
			}


		}
		Incognitodriver.manage().window().setSize(new Dimension(300, 800));
		Incognitodriver.manage().window().setPosition(new Point(500,10));
		logger.info("Browser minimized");
		driver.switchTo().defaultContent();

		try {
			driver.findElement(ClickOnCloseWtnessSave).click();
			logger.info("Clicked on close witness save button");
		} catch (Exception e) {
			// TODO: handle exception
		}

		driver.switchTo().frame(0);

	}
	public void VeryfingWitnessSavedDocuments() {
		if(driver.findElement(WitnessSaveFolder).isDisplayed()) {
			System.out.println("Witness Documents Are Saved Successfuly");
		}
		else {

			System.out.println("Failed To Save Witness Documents");
		}
		logger.info("Verified witness saved documents");
	}

	public void DocumentsPresentationFolder() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();
		logger.info("Clicked the documents presentation folder");

	}
	public void DocumentsPresentation() throws InterruptedException {
		Thread.sleep(1000);
		int Doucmentssize=driver.findElements(DocumentsPresentation).size();
//		for(int i=0; i<Doucmentssize; i++) {
//			int size=i+1;
			driver.findElement(By.xpath("(//p[@class='fileName'][contains(text(), '.pdf')])[1]")).click();
			driver.switchTo().defaultContent();  
			driver.findElement(WaitUntilDocumentsload);
			driver.findElement(ClickOnPresentation).click();
			logger.info("Clicked the presentation folder");
			Thread.sleep(2000);
			driver.findElement(ClickOnStart).click();
			Thread.sleep(2000);
			logger.info("Clicked the start button");
			System.out.println("Presentation Started");
			Thread.sleep(7000);
			Firefoxdriver.switchTo().defaultContent();
			Firefoxdriver.findElement(By.xpath("(//div[@class='app_bttn_new'])[1]")).click();

			//			ArrowColor Annotations
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='pdf-capture']")).click();
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnArrowColor).click();
			logger.info("Clicked on arrow annotation button");
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			WebElement canvas =driver.findElement(canvastag);
			new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).release().perform();
			System.out.println("Success ArrowColor Annotations Working");
			logger.info("Document marked");

			// HighlightColor Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnHighlightColor).click();
			Thread.sleep(2000);
			logger.info("Clicked on highlight annotation button");
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -180, -180).clickAndHold().moveToElement(canvas, -280, -220).release().perform();
			System.out.println("Success HighlightColor Annotations Working");
			logger.info("Document marked");
			
			//PencilColor Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnPencilColor).click();
			Thread.sleep(1000);	
			logger.info("Clicked on pencil annotation button");	
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
			System.out.println("Success PencilColor Annotations Working");
			logger.info("Document marked");
			
			//Callout Annotations
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnCallout).click();
			logger.info("Clicked on pencil annotation button");
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -50, -50).clickAndHold().moveToElement(canvas, -100, 150).release().perform();
			System.out.println("Success Callout Annotations Working");
			logger.info("Document marked");
			driver.manage().window().setSize(new Dimension(300, 800));
			driver.manage().window().setPosition(new Point(5,5));

			//Erase Annotations
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnErase).click();
			logger.info("Clicked on erase annotation button");
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).click().perform();
			System.out.println("Success Erase Annotations Working");
			logger.info("Document marked");
			driver.manage().window().setSize(new Dimension(300, 800));
			driver.manage().window().setPosition(new Point(5,5));

			//			Undo Annotations
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnUndo).click();
			Thread.sleep(1000);
			logger.info("Clicked on undo annotation button");
			System.out.println("Success Undo Annotations Working");
			Screenshots.usernamescreenshot(driver, "Member Annotations");
			Thread.sleep(2000);
			Screenshots.usernamescreenshot(Incognitodriver, "Witness Annotations");
			logger.info("Captured screenshot");
			driver.manage().window().setSize(new Dimension(300, 800));
			driver.manage().window().setPosition(new Point(5,5));

			//			ShowThumbnails Annotations
			driver.manage().window().maximize();
			driver.findElement(ClickOnShowThumbnails).click();
			Thread.sleep(1000);
			logger.info("Clicked on show thumbnail annotation button");
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			driver.manage().window().maximize();
			String Size=driver.findElement(By.xpath("//span[@id='page-total']")).getText();
			int number = Integer.parseInt(Size);
			Thread.sleep(2000);
			for(int j=0; j<number; j++) {
				driver.findElement(ClickOnNext).click();
				logger.info("Clicked the next button");
			}
			String Text=driver.findElement(By.xpath("(//div[@class='thumb-page-number ng-binding'])[1]")).getText();
			Assert.assertEquals(Size, Text);
			System.out.println("Success ShowThumbnails Annotations Working");
			Thread.sleep(2000);
			driver.manage().window().setSize(new Dimension(700, 900));
			driver.manage().window().setPosition(new Point(10,10));
			logger.info("Browser minimized");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(StopPresentation).click();
			logger.info("Clicked on stop presenation button");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='back_btn']")).click();
			logger.info("Clicked on back button");
			driver.switchTo().frame(0);
		}


	//}

	public void AnnotationsValidation() throws IOException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
        Date currentDate = new Date();
        String folderName = dateFormat.format(currentDate);
		BufferedImage BeforeAnnotationImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Screenshots\\"+folderName+"\\"+"Member Annotations.png"));
		BufferedImage AfterAnnotationImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Screenshots\\"+folderName+"\\"+"Witness Annotations.png"));
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(BeforeAnnotationImage, AfterAnnotationImage);
		if(diff.hasDiff()==true)
		{
			System.out.println("Annotations are Working Successfully");
		}
		else {
			System.out.println("Failed Annotations Are Not Working");

		}
		logger.info("Validated annotations");

	}




}




















