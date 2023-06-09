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

// NonZoom_Mediation_Session_With_Witness_PageObjects
public class NonZoom_Mediation_Session_With_Witness_PageObjects {

	public static String getSessionId; 
	public static Logger logger;
	WebDriver driver;
	WebDriver Incognitodriver;
	ReadConfigPropertiesFile readconfig = new ReadConfigPropertiesFile();
	String Environment = readconfig.BrowserName();

	public NonZoom_Mediation_Session_With_Witness_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnNonZoomDeposition=By.xpath("(//*[text()='Mediation'])[1]");
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
	By ClickOnViewPasscode=By.xpath("//p[@class='deposition_passcode']");
	By ClickOnMemberMarkedExibits=By.xpath("//p[text()='Marked Exhibits']");
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
	By ClickOnCloseWitnessSave=By.xpath("//button[@id='dialog1BtnClose']");
	By WitnessSaveFolder=By.xpath("//p[text()='Witness Annotations']");
	By DocumentsPresentation=By.xpath("//p[@class='fileName'][contains(text(), '.pdf')]");
	By ClickOnPresentation=By.xpath("//div[@class='presentation_btn']");
	By ClickOnStart=By.xpath("//span[text()='Start']");




	ArrayList<String> OfficialExhibits=new ArrayList<String>();
	ArrayList<String> MarkedExhibits=new ArrayList<String>();
	ArrayList<String> MarkedExhibits1=new ArrayList<String>();


	public void Driverquit() {
		Incognitodriver.quit();
		logger.info("Browser quitted");
	}
	public void ClickOnNonZoomDepositionSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnNonZoomDeposition).click();
		logger.info("Clicked the non zoom deposition");
	}


	public void ClickOnIntroduceDocumentsFolder() {
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();
		logger.info("Clicked the introduce documents folder");
	}
	public void BeginSession() {
		try {
			if(driver.findElement(ClickOnBeginSession).isDisplayed()) {
				driver.findElement(ClickOnBeginSession).click();	
				logger.info("Clicked the begin session button");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			driver.switchTo().defaultContent();
			if(driver.findElement(ClickOnBeginSessionOk).isDisplayed()) {
				driver.findElement(ClickOnBeginSessionOk).click();	
				logger.info("Clicked the begin session Ok button");
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
			logger.info("Clicked the distribute button");
			driver.findElement(WaitUntilDocumentOpen);
			driver.findElement(ClickOnBackButton).click();
			logger.info("Clicked the back button");
			driver.switchTo().frame(0);


		}
	}

	public void OfficialExhibitsDocumentsCaptureOfMember() {

		driver.findElement(ClickOnMemberMarkedExibits).click();
		List<WebElement> ds=driver.findElements(By.xpath("(//div[@id='filesList']//p[@class='fileName'])"));

		for (WebElement ele : ds) {
			String OptionName=ele.getText();
			OfficialExhibits.add(OptionName);
		}

		logger.info("Captured official exhibits documents of member");

	}	


	public void WitnessLogin() throws InterruptedException {
		driver.manage().window().setSize(new Dimension(700, 800));
		driver.manage().window().setPosition(new Point(10,10));
		logger.info("Captured official exhibits documents of member");



		if (Environment.contentEquals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			Incognitodriver=new ChromeDriver(options);
			logger.info("Chrome browser launched");
			Incognitodriver.manage().window().setSize(new Dimension(680, 800));
			Incognitodriver.manage().window().setPosition(new Point(700,10));
			logger.info("Browser minimized");
		}
		else if(Environment.contentEquals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			Incognitodriver=new FirefoxDriver(options);
			logger.info("Firefox browser launched");
			Incognitodriver.manage().window().setSize(new Dimension(680, 800));
			Incognitodriver.manage().window().setPosition(new Point(700,10));
			logger.info("Browser minimized");
		}

		else if(Environment.contentEquals("edgedriver")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("-inprivate");
			Incognitodriver=new EdgeDriver(options);
			logger.info("Edge browser launched");
			Incognitodriver.manage().window().setSize(new Dimension(680, 800));
			Incognitodriver.manage().window().setPosition(new Point(700,10));
			logger.info("Browser minimized");


		}

		Incognitodriver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");
		logger.info("URl entered");
		Incognitodriver.manage().window().maximize();
		Incognitodriver.findElement(ClickOnJoin).click();
		logger.info("Clicked the join button");
		String getSessionId= driver.findElement(GetPasscode).getText().split(" ")[1];
		Incognitodriver.findElement(EnterSessionID).sendKeys(getSessionId);
		logger.info("Entered Session ID");
		Incognitodriver.findElement(EnterName).sendKeys("Arun");
		logger.info("Entered name");
		Incognitodriver.findElement(ClickOnLogin).click();
		Thread.sleep(4000);
		logger.info("Clicked the login button");
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnAllow).click();
		Thread.sleep(2000);
		logger.info("Clicked the allow button");
		Incognitodriver.manage().window().setSize(new Dimension(680, 800));
		Incognitodriver.manage().window().setPosition(new Point(700,10));
		logger.info("Browser minimized");
	}


	public void WitnessLoginValidation() {
		if(Incognitodriver.findElement(LogoutButton).isEnabled()) {

			System.out.println("Witness Login Is Success");
		}
		else {
			System.out.println("Failed to Login Witness");
		}
		logger.info("Validated witness login");
	}	

	public void OfficialExhibitsDocumentsCaptureOfWitness() throws InterruptedException { 
		Incognitodriver.switchTo().frame(0);
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
		Screenshots.usernamescreenshot(driver, "MediationSessionWithWitness");
		logger.info("Captured screenshot");
		//MarkedExhibits.removeAll(OfficialExhibits);
		Assert.assertEquals(OfficialExhibitsCount, MarkedExhibitsCount);
		System.out.println("Marked Exibits Documents Format Of Member And Witness Matched");
		logger.info("Compared marked exibits of member and witness");

	}


	public void WitnessAnnotationChangeDocuments() throws InterruptedException {
		int Documentscount=Incognitodriver.findElements(WitnessIntrouduceDocuments).size();
		for(int i=0; i<Documentscount; i++) {
			int counts=i+1;
			Incognitodriver.findElement(By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName'])["+counts+"]")).click();
			Incognitodriver.switchTo().defaultContent();
			try {
				Thread.sleep(2000);
				//				Incognitodriver.findElement(WaitUtilDocumentsload);
				Incognitodriver.findElement(ClickOnHighlightColor).click();
				Thread.sleep(2000);
				logger.info("Clicked highlight color button");
				Incognitodriver.switchTo().frame(0);
				Incognitodriver.switchTo().frame(0);
				WebElement canvas =Incognitodriver.findElement(canvastag);
				new Actions(Incognitodriver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
				Incognitodriver.switchTo().defaultContent();
				logger.info("Document marked");
				Incognitodriver.findElement(WaitUntilDocumentsload);
				Incognitodriver.findElement(ClickOnPencilColor).click();
				Incognitodriver.switchTo().frame(0);
				Incognitodriver.switchTo().frame(0);
				//				WebElement canvas =driver.findElement(canvastag);
				new Actions(Incognitodriver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
				Incognitodriver.switchTo().defaultContent();
				Incognitodriver.findElement(ClickOnBackButtonWitness).click();
				Thread.sleep(2000);
				Incognitodriver.findElement(ClickOnsave).click();
				Thread.sleep(5000);
				Incognitodriver.switchTo().frame(0);
			} catch (Exception e) {
				//				Incognitodriver.findElement(WaitUtilDocumentsload);
				Thread.sleep(2000);
				Incognitodriver.findElement(ClickOnBackButtonWitness).click();
				Thread.sleep(5000);
				Incognitodriver.switchTo().frame(0);
			}
		}
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnCloseWitnessSave).click();


	}
	public void VerifyingWitnessSavedDocuments() throws InterruptedException {
		driver.switchTo().frame(0);
		if(driver.findElement(WitnessSaveFolder).isDisplayed()) {
			System.out.println("Witness Documents Are Saved Successfuly");
		}
		else {
			System.out.println("Failed To Save Witness Documents");
		}
	}
	public void DocumentsPresentationFolder() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();
		logger.info("Clicked the presentation folder");

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
		logger.info("Clicked the presentation button");
		Thread.sleep(2000);
		driver.findElement(ClickOnStart).click();
		logger.info("Clicked the start presentation button");
		Thread.sleep(2000);
		System.out.println("Presentation Started");
		

		//			ArrowColor Annotations
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='pdf-capture']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnArrowColor).click();
		logger.info("Clicked arrow annotation button");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement canvas =driver.findElement(canvastag);
		new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).release().perform();
		System.out.println("Successfully ArrowColor Annotations Are Working");
		// HighlightColor Annotations
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnHighlightColor).click();
		logger.info("Clicked the highlight annotation button");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		new Actions(driver).moveToElement(canvas, -180, -180).clickAndHold().moveToElement(canvas, -280, -220).release().perform();
		System.out.println("Successfully HighlightColor Annotations Are Working");
		//PencilColor Annotations
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnPencilColor).click();
		logger.info("Clicked the pencil annotation button");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		new Actions(driver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
		System.out.println("Successfully PencilColor Annotations Are Working");
		//Callout Annotations
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnCallout).click();
		logger.info("Clicked the callout annotation button");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		new Actions(driver).moveToElement(canvas, -50, -50).clickAndHold().moveToElement(canvas, -100, 150).release().perform();
		System.out.println("Success Callout Annotations Working");
		//Erase Annotations
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnErase).click();
		logger.info("Clicked the erase annotation button");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).click().perform();
		System.out.println("Successfully Erase Annotations Are Working");
		//			Undo Annotations
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnUndo).click();
		logger.info("Clicked the undo annotation button");
		Thread.sleep(1000);
		System.out.println("Successfully Undo Annotations Are Working");
		Screenshots.usernamescreenshot(driver, "Member Annotations");
		Thread.sleep(2000);
		Screenshots.usernamescreenshot(Incognitodriver, "Witness Annotations");
		//			ShowThumbnails Annotations
		driver.findElement(ClickOnShowThumbnails).click();
		logger.info("Clicked the show thumbnails button");
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
		System.out.println("Success ShowThumbnails Annotations Working");
		Thread.sleep(2000);
		driver.manage().window().setSize(new Dimension(700, 900));
		driver.manage().window().setPosition(new Point(10,10));
		logger.info("Browser minimized");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(StopPresentation).click();
		logger.info("Clicked the stop presentation button");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='back_btn']")).click();
		logger.info("Clicked the back button");
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

	logger.info("Validated all annotations");
}


}


