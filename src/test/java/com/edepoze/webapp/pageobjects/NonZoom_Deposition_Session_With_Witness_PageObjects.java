/**
 * 
 */
package com.edepoze.webapp.pageobjects;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
 * @author Muralikrishna.Seethalam
 *
 */

// Non Zoom Deposition Session With Witness
public class NonZoom_Deposition_Session_With_Witness_PageObjects {
	WebDriver driver;
	WebDriver Incognitodriver;
	ReadConfigPropertiesFile readconfig = new ReadConfigPropertiesFile();
	String Environment = readconfig.BrowserName();

	public NonZoom_Deposition_Session_With_Witness_PageObjects(WebDriver driver) {
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
	By EnterWitnessName=By.xpath("(//input[@placeholder='Type your Name'])[2]");
	By ClickOnLogin=By.xpath("//div[@class='jformbtn_nonmember']");
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



	public void Driverquit() {
		Incognitodriver.quit();
	}
	public void ClickOnNonZoomDepositionSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnNonZoomDeposition).click();
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();

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
		driver.switchTo().frame(0);
	}

	public void IntroduceDocuments() throws InterruptedException {
		
		int Documnets=driver.findElements(ClickOnDocuments).size();

		for(int i=0; i<Documnets; i++) {
			int start=i+1;
			driver.findElement(By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info'])["+start+"]")).click();
			driver.switchTo().defaultContent();  
			driver.findElement(WaitUntilDocumentsload);
			driver.findElement(ClickOnIntroduce).click();
			Thread.sleep(3000);
			driver.findElement(WaitUntilDocumentOpen);
			Thread.sleep(5000);
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

	public void Witnesslogin() {
		driver.manage().window().setSize(new Dimension(700, 900));
		driver.manage().window().setPosition(new Point(10,10));



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
		Incognitodriver.manage().window().setSize(new Dimension(680, 900));
		Incognitodriver.manage().window().setPosition(new Point(700,10));


	}
	public void AcceptWitnesslogin() throws InterruptedException {
		Thread.sleep(2000);
		if(Incognitodriver.findElement(Waitingforauthorisation).isDisplayed()) {
			driver.findElement(AccepetWitnesslogin).click();
		}
	}

	public void ClickOnOfficialExhibits() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnOfficialExhibits).click();
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
		Screenshots.usernamescreenshot(driver, "DepositionSessionWithWitness");
		WitnessIntrouduceDocumentNames.removeAll(MemberIntrouduceDocumentNames);
		Assert.assertEquals(WitnessIntrouduceDocumentNames, WitnessIntrouduceDocumentNames1);
		System.out.println("Introduce Documents Are Same");
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
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnCloseWtnessSave).click();
		driver.switchTo().frame(0);


	}
	public void VerifyingWitnessSavedDocuments() {
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
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
			System.out.println("Successfully PencilColor Annotations Are Working");

			//Callout Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnCallout).click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -50, -50).clickAndHold().moveToElement(canvas, -100, 150).release().perform();
			System.out.println("Successfully Callout Annotations Are Working");
	
			//Erase Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnErase).click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).click().perform();
			System.out.println("Successfully Erase Annotations Are Working");

			//			Undo Annotations
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(ClickOnUndo).click();
			System.out.println("Successfully Undo Annotations Working");
			Screenshots.usernamescreenshot(driver, "Member Annotations");
			Thread.sleep(2000);
			Screenshots.usernamescreenshot(Incognitodriver, "Witness Annotations");

			//			ShowThumbnails Annotations
			driver.findElement(ClickOnShowThumbnails).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			String Size=driver.findElement(By.xpath("//span[@id='page-total']")).getText();
			int number = Integer.parseInt(Size);
			Thread.sleep(2000);
			for(int j=0; j<number; j++) {
				driver.findElement(ClickOnNext).click();
			}
			
			String Text=driver.findElement(By.xpath("(//div[@class='thumb-page-number ng-binding'])[1]")).getText();
			Assert.assertEquals(Size, Text);
			System.out.println("Successfully Show Thumbnails Annotations Working");
			Thread.sleep(2000);
			for(int j=0; j<number; j++) {
				driver.findElement(By.id("arrow-prev-button")).click();
			}
			Thread.sleep(2000);
			driver.findElement(By.id("pdf-thumb1")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//div[@class='pdf-capture']")).click();
			driver.manage().window().setSize(new Dimension(700, 900));
			driver.manage().window().setPosition(new Point(10,10));
			driver.switchTo().defaultContent();

			driver.findElement(PausePresentation).click();
			Thread.sleep(2000);
			//PencilColor Annotations
		
			driver.findElement(ClickOnPencilColor).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			WebElement canvas1 =driver.findElement(canvastag);
			new Actions(driver).moveToElement(canvas1, -190, -190).clickAndHold().moveToElement(canvas1, -290, -230).release().perform();
			System.out.println("Successfully PencilColor Annotations Are Working");
	
			driver.switchTo().defaultContent();
			driver.findElement(PlayPresentatiom).click();
			Thread.sleep(2000);
			
			driver.findElement(PassAnnotationRole).click();
			Thread.sleep(2000);
			Incognitodriver.switchTo().defaultContent();
			Incognitodriver.findElement(ClickOnHighlightColor).click();
			Thread.sleep(2000);
			Incognitodriver.switchTo().frame(0);
			Incognitodriver.switchTo().frame(0);
			WebElement canvas2 =Incognitodriver.findElement(canvastag);
			new Actions(Incognitodriver).moveToElement(canvas2, -180, -180).clickAndHold().moveToElement(canvas2, -280, -220).release().perform();
			System.out.println("Successfully HighlightColor Annotations Are Working");
			
			Thread.sleep(2000);
			Incognitodriver.switchTo().defaultContent();
			Incognitodriver.findElement(ClickOnPencilColor).click();
			Thread.sleep(1000);
			Incognitodriver.switchTo().frame(0);
			Incognitodriver.switchTo().frame(0);
			new Actions(Incognitodriver).moveToElement(canvas2, -120, -120).clickAndHold().moveToElement(canvas2, -270, -220).release().perform();
			System.out.println("Successfully PencilColor Annotations Are Working");
			
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='pdf-capture']")).click();
			driver.switchTo().defaultContent();
			driver.findElement(RevokeAnnotationRole).click();
			Thread.sleep(2000);
			driver.findElement(StopPresentation).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='back_btn']")).click();
			driver.findElement(ClickOnDontSave).click();
			driver.switchTo().frame(0);
		}


	}

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

	
	
	
	
	

By PausePresentation=By.className("pause_btn");
By PlayPresentatiom=By.className("play_btn");
By PassAnnotationRole=By.xpath("//div[@class='annotator_btn']");
By RevokeAnnotationRole=By.xpath("//div[@class='annotator_btn revoke']");
By ClickOnDontSave=By.className("btn_app_extra");

}






















