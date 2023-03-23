
package com.edepoze.webapp.pageobjects;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
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
 * @author Muralikrishna.Seethalam
 *
 */

// Non Zoom Deposition Session With Witness And Guest
public class NonZoom_Deposition_Session_With_Witness_And_Guest_PageObjects {
	WebDriver driver;
	WebDriver Incognitodriver;
	WebDriver Firefoxdriver;
	ReadConfigPropertiesFile readconfig = new ReadConfigPropertiesFile();
	String Environment = readconfig.BrowserName();

	public NonZoom_Deposition_Session_With_Witness_And_Guest_PageObjects(WebDriver driver) {
		this.driver=driver;
	}

	By ClickOnNonZoomDeposition=By.xpath("(//*[text()='Deposition'])[1]");
	By ClickOnBeginSession=By.xpath("//div[@id='btn_start_deposition']");
	By ClickOnBeginSessionOk=By.xpath("//button[@class='dialogOkBtn']");
	By ClickOnIntroduceDocumentsFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnDocuments=By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info'])");
	By WaitUntilDocumentsload=By.xpath("//div[text()='Loading...']");
	By ClickOnIntroduce=By.xpath("//p[text()='Introduce']");
	By WaitUntilDocumentOpen=By.xpath("//div[text()='Loading...']");
	By CLickOnDistribute=By.xpath("//p[text()='Distribute']");
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
	By Waitingforauthorisation=By.xpath("//span[text()='Cancel']");
	By AccepetWitnesslogin=By.xpath("//span[text()='Allow']");
	By ClickOnOfficialExhibits=By.xpath("//p[text()='Official Exhibits']");
	By MemberIntrouduceDocuments=By.xpath("//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName']");
	By WitnessIntrouduceDocuments=By.xpath("//div[@id='filesList']//ul//li//div[@class='file_info']//p[@class='fileName']");
	By ClickOnHighlightColor=By.xpath("(//img[@src='/img/ipad/button/btnMarkerU53x36.png'])[1]");
	By canvastag=By.id("pdf-page-canvas");
	By ClickOnPencilColor=By.xpath("(//img[@src='/img/ipad/button/btnPencilU53x36.png'])[1]");
	By ClickOnsave=By.xpath("//div[@class='btn_app_normal']//span[text()='Save']");
	By ClickOnBackButtonWitness=By.xpath("(//img[@src='/asset/images/arr.png'])[1]");
	By ClickOnCloseWitnessSave=By.xpath("//button[@id='dialog1BtnClose']");
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
		Firefoxdriver.quit();
	}


	public void EnterGuestSessionID() throws InterruptedException {
		Thread.sleep(2000);
		Firefoxdriver.findElement(EnterGuestSessionID).sendKeys(SessionID.toArray(new String[0]));
	}
	public void EnterGuestPassword() {
		Firefoxdriver.findElement(EnterGuestPassword).sendKeys(SessionPassword.toArray(new String[0]));
	}
	public void EnterGuestName() {
		Firefoxdriver.findElement(EnterGuestName).sendKeys("Guest Test");
	}
	public void EnterGuestEmailId() {
		Firefoxdriver.findElement(EnterGuestEmailId).sendKeys("guesttest@gmail.com");
	}
	public void ClickOnGuestlogin() throws InterruptedException {
		Firefoxdriver.findElement(ClickOnGuestlogin).click();

		Thread.sleep(5000);
		if(Firefoxdriver.findElement(By.xpath("//div[@class='logout_btn']")).isDisplayed()) {
			System.out.println("Guest Login Is Success");
		}
		else {
			System.out.println("Guest Login Failed");
		}
		Firefoxdriver.manage().window().setSize(new Dimension(300, 800));
		Firefoxdriver.manage().window().setPosition(new Point(900,8));
	}

	public void Guestlogin() {

		if (Environment.contentEquals("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			Firefoxdriver = new FirefoxDriver();

		}
		else if(Environment.contentEquals("firefox")) {
			WebDriverManager.chromedriver().setup();
			Firefoxdriver = new ChromeDriver();
		}

		else if(Environment.contentEquals("edgedriver")) {
			WebDriverManager.chromedriver().setup();
			Firefoxdriver = new ChromeDriver();
		}

		Firefoxdriver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");
		Firefoxdriver.findElement(WitnessJoin).click();
	}

	public void ClickOnOfficialExhibit() {
		driver.findElement(ClickOnOfficialExhibits).click();

	}

	public void Witnesslogin() {
		driver.manage().window().setSize(new Dimension(300, 800));
		driver.manage().window().setPosition(new Point(5,5));



		if (Environment.contentEquals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			Incognitodriver=new ChromeDriver(options);
		}
		else if(Environment.contentEquals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			Incognitodriver=new FirefoxDriver(options);
		}

		else if(Environment.contentEquals("edgedriver")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("-inprivate");
			Incognitodriver=new EdgeDriver(options);
		}
	}



	public void ClickOnNonZoomDepositionSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnNonZoomDeposition).click();

	}
	public void ClickOnIntroduceDocumentsFolder() {
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();

	}
	public void BeginSession() {
		try {
			if(driver.findElement(ClickOnBeginSession).isDisplayed()) {
				driver.findElement(ClickOnBeginSession).click();	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			driver.switchTo().defaultContent();
			if(driver.findElement(ClickOnBeginSessionOk).isDisplayed()) {
				driver.findElement(ClickOnBeginSessionOk).click();	
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
			driver.findElement(ClickOnIntroduce).click();
			driver.findElement(WaitUntilDocumentOpen);
			Thread.sleep(10000);
			driver.findElement(CLickOnDistribute).click();
			driver.findElement(WaitUntilDocumentOpen);
			driver.findElement(ClickOnBackButton).click();
			driver.switchTo().frame(0);
		}

	}
	public void CaptureSessionIDPassword() throws InterruptedException {
		String Session=driver.findElement(CaptureSessionId).getText().split(" ")[1];
		SessionID.add(Session);
		driver.findElement(ClickOnViewPasscode).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		String passcode= driver.findElement(By.xpath("//span[@id='passcode']")).getText();
		SessionPassword.add(passcode);
		driver.findElement(By.xpath("//div[@id='dialogDepositionPasscode']")).click();

	}


	public void ClickJoin() {
		Incognitodriver.get("https://app-" + readconfig.Environment() + ".edepoze.com/");
		Incognitodriver.findElement(WitnessJoin).click();

	}	
	public void EnterSessionID() {
		Incognitodriver.findElement(EnterWitnessSessionID).sendKeys(SessionID.toArray(new String[0]));
	}
	public void EnterWitnessName() {
		Incognitodriver.findElement(EnterWitnessName).sendKeys("Witness Test");
	}
	public void ClickOnLogin() throws InterruptedException {
		Incognitodriver.findElement(ClickOnLogin).click();

	}
	public void AcceptWitnesslogin() throws InterruptedException {
		Thread.sleep(4000);
		if(Incognitodriver.findElement(Waitingforauthorisation).isDisplayed()) {
			driver.findElement(AccepetWitnesslogin).click();
		}
		Thread.sleep(2000);
		if(Incognitodriver.findElement(By.xpath("//div[@class='logout_btn']")).isDisplayed()) {
			System.out.println("Witnes Login Is Success");
		}
		else {
			System.out.println("Witness Login Failed");
		}
		Incognitodriver.manage().window().setSize(new Dimension(300, 800));
		Incognitodriver.manage().window().setPosition(new Point(500,10));
	}

	public void ClickOnOfficialExhibits() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnOfficialExhibits).click();
	}
	public void ClickOnOfficialExhibitFolder() {
		//driver.switchTo().frame(0);
		driver.findElement(ClickOnOfficialExhibits).click();
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
		Screenshots.usernamescreenshot(Firefoxdriver, "DepositionSessionWithWitnessAndGuest");
		Thread.sleep(2000);
		Assert.assertEquals(MemberCount, WitnesCount);
		System.out.println("Interduce Documents Are Same");
		Firefoxdriver.manage().window().setSize(new Dimension(300, 800));
		Firefoxdriver.manage().window().setPosition(new Point(900,8));
	}

	public void VerifyIntroduceDocuments() throws InterruptedException {

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
		Screenshots.usernamescreenshot(Incognitodriver, "DepositionSessionWithWitnessAndGuest");
		WitnessIntrouduceDocumentNames.removeAll(MemberIntrouduceDocumentNames);
		Assert.assertEquals(WitnessIntrouduceDocumentNames, WitnessIntrouduceDocumentNames1);
		System.out.println("Introduce Documents Are Same");
	}

	public void WitnessAnnotationChangeDocuments() throws InterruptedException {
		Thread.sleep(2000);
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
				Incognitodriver.switchTo().frame(0);
				Incognitodriver.switchTo().frame(0);
				WebElement canvas =Incognitodriver.findElement(canvastag);
				new Actions(Incognitodriver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
				Incognitodriver.switchTo().defaultContent();
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
		Incognitodriver.manage().window().setSize(new Dimension(300, 800));
		Incognitodriver.manage().window().setPosition(new Point(500,10));

		driver.switchTo().defaultContent();
		try {
			driver.findElement(ClickOnCloseWitnessSave).click();
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

	}

	public void DocumentsPresentationFolder() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();

	}
	public void DocumentsPresentation() throws InterruptedException {
		Thread.sleep(1000);
		int Doucmentssize=driver.findElements(DocumentsPresentation).size();
		for(int i=0; i<Doucmentssize; i++) {
			int size=i+1;
			driver.findElement(By.xpath("(//p[@class='fileName'][contains(text(), '.pdf')])["+size+"]")).click();
			driver.switchTo().defaultContent();  
			driver.findElement(WaitUntilDocumentsload);
			driver.findElement(ClickOnPresentation).click();
			Thread.sleep(2000);
			driver.findElement(ClickOnStart).click();
			Thread.sleep(2000);
			System.out.println("Presentation Started");
			Thread.sleep(5000);
			

			//			ArrowColor Annotations
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='pdf-capture']")).click();
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnArrowColor).click();
			Firefoxdriver.switchTo().defaultContent();
			Firefoxdriver.findElement(By.xpath("(//div[@class='app_bttn_new'])[1]")).click();
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			WebElement canvas =driver.findElement(canvastag);
			new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).release().perform();
			System.out.println("Successfully ArrowColor Annotations Are Working");

			// HighlightColor Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnHighlightColor).click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -180, -180).clickAndHold().moveToElement(canvas, -280, -220).release().perform();
			System.out.println("Successfully HighlightColor Annotations Are Working");

			//PencilColor Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnPencilColor).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
			System.out.println("Successfully PencilColor Annotations Are Working");

			//Callout Annotations
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnCallout).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -50, -50).clickAndHold().moveToElement(canvas, -100, 150).release().perform();
			System.out.println("Successfully Callout Annotations Are Working");
			driver.manage().window().setSize(new Dimension(300, 800));
			driver.manage().window().setPosition(new Point(5,5));

			//Erase Annotations
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnErase).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).click().perform();
			System.out.println("Successfully Erase Annotations Are Working");
			driver.manage().window().setSize(new Dimension(300, 800));
			driver.manage().window().setPosition(new Point(5,5));

			//			Undo Annotations
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnUndo).click();
			Thread.sleep(1000);
			System.out.println("Successfully Undo Annotations Are Working");
			Screenshots.usernamescreenshot(driver, "Member Annotations");
			Thread.sleep(2000);
			Screenshots.usernamescreenshot(Incognitodriver, "Witness Annotations");
			driver.manage().window().setSize(new Dimension(300, 800));
			driver.manage().window().setPosition(new Point(5,5));

			//			ShowThumbnails Annotations
			driver.manage().window().maximize();
			driver.findElement(ClickOnShowThumbnails).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			driver.manage().window().maximize();
			String Size=driver.findElement(By.xpath("//span[@id='page-total']")).getText();
			int number = Integer.parseInt(Size);
			Thread.sleep(2000);
			for(int j=0; j<number; j++) {
				driver.findElement(ClickOnNext).click();
			}
			String Text=driver.findElement(By.xpath("(//div[@class='thumb-page-number ng-binding'])[1]")).getText();
			Assert.assertEquals(Size, Text);
			System.out.println("Successfully Show Thumbnails Annotations Are Working");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(ClickOnChatToggle).click();
			Thread.sleep(2000);
			driver.findElement(ClickOnGuest).click();
			Thread.sleep(2000);
			driver.findElement(SendMessage).sendKeys("Hi"+Keys.ENTER);
			
			Firefoxdriver.findElement(ClickOnChatToggle).click();
			Thread.sleep(2000);
			Firefoxdriver.findElement(ClickMembrMessage).click();
			Thread.sleep(2000);
			Firefoxdriver.findElement(SendMessage).sendKeys("Hello"+Keys.ENTER);
			Firefoxdriver.findElement(ClickOnChatToggle).click();
			driver.findElement(ClickOnChatToggle).click();
			
			driver.manage().window().setSize(new Dimension(700, 900));
			driver.manage().window().setPosition(new Point(10,10));
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(StopPresentation).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='back_btn']")).click();
			driver.switchTo().frame(0);
		}


	}
By ClickOnChatToggle=By.xpath("//div[@id='attendee_list_toggle']");
By ClickOnGuest=By.xpath("//div[text()='Guest Test']");
By SendMessage=By.name("chatentry");
By ClickMembrMessage=By.xpath("(//div[@class='attendee_name'])[1]");
	public void AnnotationsValidation() throws IOException {
		BufferedImage BeforeAnnotationImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Screenshots\\Member Annotations.png"));
		BufferedImage AfterAnnotationImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Screenshots\\Witness Annotations.png"));


		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(BeforeAnnotationImage, AfterAnnotationImage);
		if(diff.hasDiff()==true)
		{
			System.out.println("Annotations are Working Successfully");
		}
		else {
			System.out.println("Failed Annotations Are Not Working");

		}

	}




}




















