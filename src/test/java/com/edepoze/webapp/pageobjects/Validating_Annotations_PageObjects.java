
package com.edepoze.webapp.pageobjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

/**
 * @author MuraliKrishna.Seethalam
 *
 */

// Validating All Annotations
public class Validating_Annotations_PageObjects {
	public static Logger logger;
	WebDriver driver;

	By ClickOnSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnDocument=By.xpath("(//p[@class='fileName'][contains(text(), '.pdf')])[1]");
	By ClickOnArrowColor=By.xpath("(//img[@src='/img/ipad/button/btnArrowU53x36.png'])[1]");
	By ClickOnHighlightColor=By.xpath("(//img[@src='/img/ipad/button/btnMarkerU53x36.png'])[1]");
	By ClickOnPencilColor=By.xpath("(//img[@src='/img/ipad/button/btnPencilU53x36.png'])[1]");
	By ClickOnNote=By.xpath("//img[@src='/img/ipad/button/btnNoteU53x36.png']");
	By EnterNote=By.xpath("//textarea[@ng-model='toolbar.draw.note.edit.note']");
	By ClickOnCloseNote=By.xpath("//button[text()='Close']");
	By ClickOnCallout=By.xpath("//img[@src='/img/ipad/button/btnCalloutU188x154.png']");
	By ClickOnErase=By.xpath("//img[@src='/img/ipad/button/btnEraseU44x36.png']");
	By ClickOnUndo=By.xpath("//img[@src='/img/ipad/button/btnUndoU44x36.png']");
	By ClickOnShowThumnails=By.xpath("//img[@src='/img/ipad/icons/thumb.png']");
	By ThumbnailCount=By.xpath("//div[@id='thumb-carousel']");
	By ClickOnNext=By.xpath("//div[@id='arrow-next-container']//button[@id='arrow-next-button']");
	By Pagenumbers=By.xpath("//div[@id='pgNumBanner']");
	By EnterPageNumber=By.xpath("//input[@id='jump-to']");
	By GotoPage=By.xpath("//button[text()='Go to Page']");
	By ClikOnEmail=By.xpath("//div[@class='email_btn']");
	By ToEmailId=By.name("sendTo");
	By ClickOnSend=By.id("dlgActionSend");
	By GetSubject=By.name("sendSubject");
	By ClickZoomin=By.id("scale-select");
	By ZoomInZoomOut=By.xpath("//select[@id='scale-select']//option");
	
	
	
	





	By canvastag=By.id("pdf-page-canvas");

	public Validating_Annotations_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");

	}

	ArrayList<String>SubjectName=new ArrayList<String>();
	public static String Subjectline=null;

	public void ClickOnSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked on session");
	}
	public void ClickOnFolder() {
		driver.findElement(ClickOnFolder).click();
		logger.info("Clicked on folder");
	}
	public void ClickOnDocument() {
		driver.findElement(ClickOnDocument).click();
		logger.info("Clicked on document");
	}
	public void ArrowColorAnnotations() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Loading...']"));
		Thread.sleep(3000);
		Screenshots.usernamescreenshot(driver, "Before Annotations");
		logger.info("Captured screenshot");
		driver.findElement(ClickOnArrowColor).click();
		logger.info("Clicked on arrow annotation button");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement canvas =driver.findElement(canvastag);
		//		Dimension canvasdim=canvas.getSize();
		//		System.out.println(canvasdim);
		//		int canv_x=canvasdim.getWidth()/6;
		//		System.out.println("width: "+canv_x);
		//		System.out.println("Height: "+canv_y);
		//		int button_x=(canv_x/6)*2;
		//		System.out.println("width3: "+button_x);
		//		int button_y=(canv_y/6)*2;
		//		System.out.println("High3: "+button_y);
		new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).release().perform();
	}

	public void HighlightColorAnnotations() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnHighlightColor).click();
		logger.info("Clicked on highlight annotation button");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement canvas =driver.findElement(canvastag);
		new Actions(driver).moveToElement(canvas, -180, -180).clickAndHold().moveToElement(canvas, -280, -220).release().perform();
		System.out.println("Success HighlightColor Annotations Working");
	}
	public void PenciltColorAnnotations() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnPencilColor).click();
		logger.info("Clicked on pencil annotationbutton");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement canvas =driver.findElement(canvastag);
		new Actions(driver).moveToElement(canvas, -120, -120).clickAndHold().moveToElement(canvas, -270, -220).release().perform();
		System.out.println("Success PencilColor Annotations Working");
	}
	public void NoteAnnotations() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnNote).click();
		logger.info("Clicked on note annotation button");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement canvas =driver.findElement(canvastag);
		new Actions(driver).moveToElement(canvas, -100, -100).clickAndHold().moveToElement(canvas, -150, -100).release().perform();
		driver.findElement(EnterNote).sendKeys("Sample Test Note");
		logger.info("Entered note");
		driver.findElement(ClickOnCloseNote).click();
		logger.info("Clicked on close note button");
		System.out.println("Success Note Annotations Working");
	}
	public void CalloutAnnotations() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnCallout).click();
		logger.info("Clicked on callout button");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement canvas =driver.findElement(canvastag);
		new Actions(driver).moveToElement(canvas, 50, 50).clickAndHold().moveToElement(canvas, -50, -90).release().perform();
		System.out.println("Success Callout Annotations Working");
	}
	public void EraseAnnotations() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnErase).click();
		logger.info("Clicked on erase annotation button");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		WebElement canvas =driver.findElement(canvastag);
		new Actions(driver).moveToElement(canvas, -150, -150).clickAndHold().moveToElement(canvas, -250, -200).click().perform();
		System.out.println("Success Erase Annotations Working");
	}
	public void UndoAnnotations() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnUndo).click();
		logger.info("Clicked on undo annotation button");
		System.out.println("Success Undo Annotations Working");
		Screenshots.usernamescreenshot(driver, "After Annotations");
		logger.info("Captured screenshot");
	}
	public  void ShowThumbnailsAnnotations() throws InterruptedException{
		driver.findElement(ClickOnShowThumnails).click();
		logger.info("Clicked on show thumbnails annotation button");
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		String Size=driver.findElement(By.xpath("//span[@id='page-total']")).getText();
		Thread.sleep(2000);
		int number = Integer.parseInt(Size);
		for(int i=0; i<number; i++) {
			driver.findElement(ClickOnNext).click();
			logger.info("Clicked on next");
		}
		String Text=driver.findElement(By.xpath("(//div[@class='thumb-page-number ng-binding'])[1]")).getText();
		Assert.assertEquals(Size, Text);
		System.out.println("Successfullty ShowThumbnails Annotations Working");
	}


	public void AnnotationsValidation() throws IOException {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
          Date currentDate = new Date();
          String folderName = dateFormat.format(currentDate);
		BufferedImage BeforeAnnotationImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Screenshots\\"+folderName+"\\"+"Before Annotations.png"));
		BufferedImage AfterAnnotationImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Screenshots\\"+folderName+"\\"+"After Annotations.png"));


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
	public void PageNumber() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//img[@src='/img/ipad/icons/page.png']")).click();
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		driver.findElement(Pagenumbers).click();
		logger.info("Clicked on  page number button");
	}
	public void EnterPageNumber() {
		driver.findElement(EnterPageNumber).sendKeys("2");
		logger.info("Entered page number");
	}
	public void GotoPage() {
		driver.findElement(GotoPage).click();
		logger.info("Clicked on go to page button");
	}
	public void PageNumberValidation() {
		String Size=driver.findElement(By.xpath("//span[@id='page-num']")).getText();
		String Enternumber="2";
		Assert.assertEquals(Size, Enternumber);
		System.out.println("Successfullty PageNumber Working");
		logger.info("Validated page numbers");
	}

	public void ClikOnEmail() {
		driver.switchTo().defaultContent();
		driver.findElement(ClikOnEmail).click();
		logger.info("Clicked on email");
	}
	public void EnterToEmailId() throws InterruptedException {
		driver.findElement(ToEmailId).sendKeys("edepozeautomation@gmail.com");
		logger.info("Entered Email ID");
		Thread.sleep(2000);
		String GetSubjectName=driver.findElement(By.xpath("//li[@class='type_pdf']")).getText();
		Subjectline=GetSubjectName;
		SubjectName.add(GetSubjectName);
			
	}
	public void ClickOnSend() throws InterruptedException {
		driver.findElement(ClickOnSend).click();
		logger.info("Clicked on send");
		System.out.println("Successfully Mail Sent");
		Thread.sleep(5000);
	}
	public void ZoominZoomOut() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		driver.findElement(ClickZoomin).click();
		logger.info("Clicked on zoom in and zoom out annotation button");
		int ZoomSize=driver.findElements(ZoomInZoomOut).size();
		
		for(int i=0; i<ZoomSize; i++) {
			Thread.sleep(2000);
			int zooms=i+1;
			driver.findElement(ClickZoomin).click();
			logger.info("Clicked on zoom in and zoom out annotation button");
			driver.findElement(By.xpath("(//select[@id='scale-select']//option)["+zooms+"]")).click();
			
		}
		
	
		
	}
	
	
	
	
	public void searchEmail(String host, String port, String userName,String password) throws Exception {
		Properties properties = new Properties();

		// server setting
		properties.put("mail.imap.host", host);
		properties.put("mail.imap.port", port);

		// SSL setting
		properties.setProperty("mail.imap.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.socketFactory.fallback", "false");
		properties.setProperty("mail.imap.socketFactory.port",
				String.valueOf(port));

		Session session = Session.getDefaultInstance(properties);

		try {
			// connects to the message store
			Store store = session.getStore("imap");
			store.connect(userName, password);

			// opens the inbox folder
			Folder folderInbox = store.getFolder("INBOX");
			folderInbox.open(Folder.READ_ONLY);

			// creates a search criterion
			SearchTerm searchCondition = new SearchTerm() {
				private static final long serialVersionUID = 1L;

				
				@Override
				public boolean match(Message message) {

					try {
						if (message.getSubject().contains(Subjectline)) {
						
							System.out.println("Mail Found");
							return true;
						}
						else {
							System.out.println("Mail Not Found");
						
						}
					} catch (MessagingException ex) {
						ex.printStackTrace();
					}
					return false;
				}
			};

			// performs search through the folder

			Message[] foundMessages = folderInbox.search(searchCondition);

			for (int i = 0; i < foundMessages.length; i++) {
				Message message = foundMessages[i];
				String subject = message.getSubject();
				System.out.println("Subject" + ": " + subject);

				String plainText= Jsoup.parse(message.getContent().toString()).text();

//				JsonPath jp = new JsonPath(message.toString());

				//                String krishna = jp.getString("payload.headers.find { it.name == 'Subject' }.value");
				//                String body = Jsoup.parse(new String(Base64.getUrlDecoder().decode(jp.getString("payload.parts[0].body.data")))).text();
				//                System.out.println(body);

				String str = plainText;
				String[] arrOfStr = str.split(" ");

				for (String a : arrOfStr)
					if(a.startsWith("http")) {
						String link=a.trim();
						System.out.println(link);

					}

			}

			// disconnect
			folderInbox.close(false);
			store.close();
		} catch (NoSuchProviderException ex) {
			ex.printStackTrace();
			System.out.println("No provider.");
		} catch (MessagingException ex) {
			ex.printStackTrace();
			System.out.println("Could not connect to the message store.");
		}
		
		logger.info("Serched email");
	}

	/**
	 * Test this program with a Gmail's account
	 * @throws Exception 
	 */

	public  void main(String[] args) throws Exception {
		ReadConfigPropertiesFile Userdetails=new ReadConfigPropertiesFile();
		String host = "imap.gmail.com";
		String port = "993";
		String userName = Userdetails.AddClientEmail();
		String password = Userdetails.ClientEmailPassword();
		searchEmail(host, port, userName, password);
	}

	
	





}
