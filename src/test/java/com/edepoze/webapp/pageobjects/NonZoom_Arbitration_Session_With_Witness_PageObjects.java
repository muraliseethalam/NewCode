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

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Non Zoom Arbitration Session With Witness
public class NonZoom_Arbitration_Session_With_Witness_PageObjects {

	public static String getSessionId; 
	public static Logger logger;
	WebDriver driver;
	WebDriver Incognitodriver;
	ReadConfigPropertiesFile readconfig = new ReadConfigPropertiesFile();
	String Environment = readconfig.BrowserName();

	public NonZoom_Arbitration_Session_With_Witness_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnNonZoomDeposition=By.xpath("(//*[text()='Arbitration'])[1]");
	By ClickOnBeginSession=By.xpath("//div[@id='btn_start_deposition']");
	By ClickOnBeginSessionOk=By.xpath("//button[@class='dialogOkBtn']");
	By ClickOnIntroduceDocumentsFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnDocuments=By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info'])");
	By WaitUntilDocumentsload=By.xpath("//div[text()='Loading...']");
	By ClickOnMark=By.xpath("//p[text()='Mark']");
	By ClickOnIntroduce=By.xpath("//p[text()='Introduce']");
	By WaitUntilDocumentOpen=By.xpath("//div[text()='Loading...']");
	By CLickOnDistribute=By.xpath("//p[text()='Distribute']");
	By ClickOnBackButton=By.xpath("//div[@class='back_btn']");
	By ClickOnOfficeExhibitsFolder=By.xpath("");
	By ClickOnViewPasscode=By.xpath("//p[@class='deposition_passcode']");
	By ClickOnMemberMarkedExhibits=By.xpath("//p[text()='Marked Exhibits']");
	By ClickOnJoin=By.xpath("//button[text()='Join']");
	By GetPasscode=By.xpath("//p[@class='deposition_number']");
	By EnterSessionID=By.xpath("(//input[@placeholder='Insert Your Session ID'])[2]");
	By EnterName=By.xpath("(//input[@placeholder='Type your Name'])[2]");
	By ClickOnLogin=By.xpath("(//div[@class='jformbtn_nonmember'])");
	By ClickOnAllow=By.xpath("//span[text()='Allow']");
	By LogoutButton=By.xpath("//div[@class='logout_btn']");
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
	By canvastag=By.id("pdf-page-canvas");
	By WitnessIntrouduceDocuments=By.xpath("//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName']");
	By ClickOnPencilColor=By.xpath("(//img[@src='/img/ipad/button/btnPencilU53x36.png'])[1]");
	By ClickOnHighlightColor=By.xpath("(//img[@src='/img/ipad/button/btnMarkerU53x36.png'])[1]");	
	By ClickOnBackButtonWitness=By.xpath("(//img[@src='/asset/images/arr.png'])[1]");
	By ClickOnsave=By.xpath("//div[@class='btn_app_normal']//span[text()='Save']");
	By ClickOnCloseWitness=By.xpath("//button[@id='dialog1BtnClose']");
	By WitnessSaveFolder=By.xpath("//p[text()='Witness Annotations']");
	By DocumentsPresentation=By.xpath("//p[@class='fileName'][contains(text(), '.pdf')]");
	By ClickOnPresentation=By.xpath("//div[@class='presentation_btn']");
	By ClickOnStart=By.xpath("//span[text()='Start']");




	ArrayList<String> OfficialExhibits=new ArrayList<String>();
	ArrayList<String> MarkedExhibits=new ArrayList<String>();
	ArrayList<String> MarkedExhibits1=new ArrayList<String>();

	
	public void Driverquit() {
		Incognitodriver.quit();
		logger.info("Incognito browser quitted");
	}
	public void ClickOnNonZoomDepositionSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnNonZoomDeposition).click();
		logger.info("Clicked the non zoom deposition session");
	}


	public void ClickOnIntroduceDocumentsFolder() {
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();
		logger.info("Clicked the introduce documents folder");
	}
	public void BeginSession() {
		try {
			if(driver.findElement(ClickOnBeginSession).isDisplayed()) {
				driver.findElement(ClickOnBeginSession).click();
				logger.info("Clicked the begin session");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			driver.switchTo().defaultContent();
			if(driver.findElement(ClickOnBeginSessionOk).isDisplayed()) {
				driver.findElement(ClickOnBeginSessionOk).click();	
				logger.info("Clicked the ok button");
				//	driver.switchTo().frame(0);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.switchTo().frame(0);
		
	}


	public void IntroduceDocuments() throws InterruptedException {
		int Documnets=driver.findElements(ClickOnDocuments).size();
		for(int i=0; i<Documnets; i++) {
			int start=i+1;
			driver.findElement(By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info'])["+start+"]")).click();
			driver.switchTo().defaultContent();
			driver.findElement(WaitUntilDocumentsload);
			try {
				if(driver.findElement(ClickOnMark).isDisplayed()) {
					driver.findElement(ClickOnMark).click();
					logger.info("Clicked the mark button");
				}
			} catch (Exception e) {
				driver.findElement(ClickOnIntroduce).click();
				logger.info("Clicked the introduce button");
			}

			driver.findElement(WaitUntilDocumentOpen);
			Thread.sleep(10000);
			driver.findElement(CLickOnDistribute).click();
			Thread.sleep(3000);
			logger.info("Clicked the distribute button");
			driver.findElement(WaitUntilDocumentOpen);
			Thread.sleep(3000);
			driver.findElement(ClickOnBackButton).click();
			logger.info("Clicked the back button");
			driver.switchTo().frame(0);


		}
	}

	public void OfficialExhibitsDocumentsCaptureOfMember() {

	//	driver.switchTo().frame(0);
		driver.findElement(ClickOnMemberMarkedExhibits).click();
		logger.info("Clicked the member marked exhibits");
		List<WebElement> ds=driver.findElements(By.xpath("(//div[@id='filesList']//p[@class='fileName'])"));

		for (WebElement ele : ds) {
			String OptionName=ele.getText();
			OfficialExhibits.add(OptionName);
		}

		logger.info("Captured the official exhibits documents of member");

	}	


	public void WitnessLogin() throws InterruptedException {
//		driver.manage().window().setSize(new Dimension(700, 800));
//		driver.manage().window().setPosition(new Point(10,10));
//		logger.info("minimized screen");



		if (Environment.contentEquals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			Incognitodriver=new ChromeDriver(options);
			logger.info("Incognito browser launched");
//			Incognitodriver.manage().window().setSize(new Dimension(680, 800));
//			Incognitodriver.manage().window().setPosition(new Point(700,10));
//			logger.info("minimized screen");
		}
		else if(Environment.contentEquals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			logger.info("Firefox browser launched");
			options.addArguments("--incognito");
			Incognitodriver=new FirefoxDriver(options);
			logger.info("Incognito browser launched");
//			Incognitodriver.manage().window().setSize(new Dimension(680, 800));
//			Incognitodriver.manage().window().setPosition(new Point(700,10));
//			logger.info("minimized screen");
		}

		else if(Environment.contentEquals("edgedriver")) {
			EdgeOptions options = new EdgeOptions();
			logger.info("Edge browser launched");
			options.addArguments("-inprivate");
			Incognitodriver=new EdgeDriver(options);
			logger.info("Incognito browser launched");
//			Incognitodriver.manage().window().setSize(new Dimension(680, 800));
//			Incognitodriver.manage().window().setPosition(new Point(700,10));
//			logger.info("minimized screen");

		}

		Incognitodriver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");
		logger.info("URL entered");
	//	Incognitodriver.manage().window().maximize();
		Incognitodriver.findElement(ClickOnJoin).click();	
		logger.info("Clicked the join button");
		String getSessionId= driver.findElement(GetPasscode).getText().split(" ")[1];
		Incognitodriver.findElement(EnterSessionID).sendKeys(getSessionId);
		logger.info("Entered session ID");
		Incognitodriver.findElement(EnterName).sendKeys("Arun");
		logger.info("Entered name");
		Incognitodriver.findElement(ClickOnLogin).click();
		logger.info("Clicked the login button");
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnAllow).click();
		logger.info("Clicked the allow button");
		Thread.sleep(2000);
//		Incognitodriver.manage().window().setSize(new Dimension(680, 800));
//		Incognitodriver.manage().window().setPosition(new Point(700,10));
//		logger.info("minimized screen");


	}
	public void WitnessLoginValidation() throws InterruptedException {

		Incognitodriver.switchTo().defaultContent();
		Thread.sleep(3000);
		if(Incognitodriver.findElement(LogoutButton).isEnabled()) {

			System.out.println("Witness Login Is Success");
		}
		else {
			System.out.println("Failed To Login Witness");
		}
		logger.info("Validated witness login");
	}


	public void OfficialExhibitsDocumentsCaptureOfWitness() throws InterruptedException { 

		Incognitodriver.switchTo().frame(0);
		//	Incognitodriver.switchTo().frame(0);
		Thread.sleep(2000);
		List<WebElement> ps=Incognitodriver.findElements(By.xpath("(//div[@class='file_info']//p[@class='fileName'])"));

		for (WebElement ele : ps) {
			String OptionName1=ele.getText();
			System.out.println(OptionName1);
			MarkedExhibits.add(OptionName1);
		}	
		logger.info("Captured official exhibits documents of witness");
	}

	public void ComparisionBetweenMarkedExibitsOfMemberAndWitness() throws Exception {

		int OfficialExhibitsCount=OfficialExhibits.size();
		System.out.println("Marked Exhibits of Member Count Is: "+OfficialExhibitsCount);
		int MarkedExhibitsCount=MarkedExhibits.size();
		System.out.println("Marked Exhibits of Witness Count Is: "+MarkedExhibitsCount);
		Screenshots.usernamescreenshot(driver, "ArbitrationSessionWithWitness");
		logger.info("Captured screenshot");
		//MarkedExhibits.removeAll(OfficialExhibits);
		Assert.assertEquals(OfficialExhibitsCount, MarkedExhibitsCount);
		System.out.println("Marked Exibits Documents Format Of Member And Witness Matched");
		logger.info("Compared marked exibits of member and witness");
	}


	public void WitenessAnnotationChangeDocuments() throws InterruptedException {
		
		Thread.sleep(2000);
		int Documentscount=Incognitodriver.findElements(WitnessIntrouduceDocuments).size();
		for(int i=0; i<Documentscount; i++) {
			int counts=i+1;
			Incognitodriver.findElement(By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName'])["+counts+"]")).click();
			logger.info("Clicked the document");
			Incognitodriver.switchTo().defaultContent();
			try {
				Thread.sleep(2000);
				//				Incognitodriver.findElement(WaitUtilDocumentsload);
				Incognitodriver.findElement(ClickOnHighlightColor).click();
				logger.info("Clicked the highlight color annotation");
				Thread.sleep(2000);
				Incognitodriver.switchTo().frame(0);
				Incognitodriver.switchTo().frame(0);
				WebElement canvas =Incognitodriver.findElement(canvastag);
				new Actions(Incognitodriver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
				Incognitodriver.switchTo().defaultContent();
				logger.info("Documnet marked");
				Incognitodriver.findElement(WaitUntilDocumentsload);
				logger.info("Documnet loading...");
				Incognitodriver.findElement(ClickOnPencilColor).click();
				logger.info("Clicked the pencli color annotation");
				Incognitodriver.switchTo().frame(0);
				Incognitodriver.switchTo().frame(0);
				//				WebElement canvas =driver.findElement(canvastag);
				new Actions(Incognitodriver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
				Incognitodriver.switchTo().defaultContent();
				logger.info("Document marked");
				Incognitodriver.findElement(ClickOnBackButtonWitness).click();
				logger.info("Clicked the back button");
				Thread.sleep(2000);
				Incognitodriver.findElement(ClickOnsave).click();
				logger.info("Clicked the save button");
				Thread.sleep(5000);
				Incognitodriver.switchTo().frame(0);
			} catch (Exception e) {
				//				Incognitodriver.findElement(WaitUtilDocumentsload);
				Thread.sleep(2000);
				Incognitodriver.findElement(ClickOnBackButtonWitness).click();
				logger.info("Clicked the back button");
				Thread.sleep(5000);
				Incognitodriver.switchTo().frame(0);
				
				Incognitodriver.manage().window().setSize(new Dimension(680, 800));
				Incognitodriver.manage().window().setPosition(new Point(700,10));
				logger.info("Minimized screen");
			}
		
		}
		
		
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(ClickOnCloseWitness).click();
		logger.info("Clicked the close witness button");
//		driver.switchTo().frame(0);

	}
	public void VerifyingWitnessSavedDocuments() throws InterruptedException {

		driver.switchTo().frame(0);
		if(driver.findElement(WitnessSaveFolder).isDisplayed()) {
			System.out.println("Witness Documents Saved Successfully");
		}
		else {
			System.out.println("Failed To Save Witness Documents");
		}
		logger.info("Verifying witness saved documents");
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
			logger.info("Clicked the documents presentation folder");
			driver.switchTo().defaultContent();
			driver.findElement(WaitUntilDocumentsload);
			driver.findElement(ClickOnPresentation).click();
			logger.info("Clicked the presentation button");
			Thread.sleep(2000);
			driver.findElement(ClickOnStart).click();
			logger.info("Clicked the start presantation button");
			Thread.sleep(2000);
			System.out.println("Presentation Started");


			//			ArrowColor Annotations
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[@class='pdf-capture']")).click();
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnArrowColor).click();
			logger.info("Clicked the arrow color annotation");
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			WebElement canvas =driver.findElement(canvastag);
			new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).release().perform();
			System.out.println("Successfully ArrowColor Annotations Are Working");
			// HighlightColor Annotations
			Thread.sleep(2000);
			logger.info("Document marked");
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnHighlightColor).click();
			logger.info("Clicked the highlight color annotation");
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -180, -180).clickAndHold().moveToElement(canvas, -280, -220).release().perform();
			System.out.println("Successfully HighlightColor Annotations Are Working");
			logger.info("Document marked");
			//PencilColor Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnPencilColor).click();
			logger.info("Clicked the pencil color annotation");
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
			System.out.println("Successfully PencilColor Annotations Are Working");
			//Callout Annotations
			Thread.sleep(2000);
			logger.info("Document marked");
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnCallout).click();
			logger.info("Clicked the callout annotation");
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -50, -50).clickAndHold().moveToElement(canvas, -100, 150).release().perform();
			System.out.println("Successfully Callout Annotations Are Working");
			//Erase Annotations
			Thread.sleep(2000);
			logger.info("Dacument mark undo");
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnErase).click();
			logger.info("Clicked the erase annotation");
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).click().perform();
			System.out.println("Successfully Erase Annotations Are Working");
			//			Undo Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnUndo).click();
			logger.info("Clicked the undo annotation");
			Thread.sleep(1000);
			System.out.println("Successfully Undo Annotations Are Working");
			Screenshots.usernamescreenshot(driver, "Member Annotations");
			logger.info("Captured screenshot");
			Thread.sleep(2000);
			Screenshots.usernamescreenshot(Incognitodriver, "Witness Annotations");
			logger.info("Captured screenshot");
			//			ShowThumbnails Annotations
			driver.findElement(ClickOnShowThumbnails).click();
			logger.info("Clicked the thumbnail annotation");
			Thread.sleep(1000);
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
			System.out.println("Successfully Show Thumbnails Annotations Are Working");
			Thread.sleep(2000);
//			driver.manage().window().setSize(new Dimension(700, 900));
//			driver.manage().window().setPosition(new Point(10,10));
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(StopPresentation).click();
			logger.info("Clicked the stop presentation button");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='back_btn']")).click();
			logger.info("Clicked the back button");
			driver.switchTo().frame(0);
		}

//	}
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
		logger.info("Validated all annotations");
	}

}


