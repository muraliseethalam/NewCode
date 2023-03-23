/**
 * 
 */
package com.edepoze.webapp.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Muralikrishna.Seethalam
 *
 */

// Co-Member Joining Active Session
public class Member_Join_Active_Seesion_PageObects {
	WebDriver driver;
	ReadConfigPropertiesFile readconfig = new ReadConfigPropertiesFile();
	String Environment = readconfig.BrowserName();
	WebDriver Firefoxdriver;
	public Member_Join_Active_Seesion_PageObects(WebDriver driver) {
		this.driver=driver;
	}
	By ClickOnNonZoomDeposition=By.xpath("(//*[text()='Deposition'])[1]");
	By ClickOnIntroduceDocumentsFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnBeginSession=By.xpath("//div[@id='btn_start_deposition']");
	By ClickOnBeginSessionOk=By.xpath("//button[@class='dialogOkBtn']");
	By CaptureSessionId=By.xpath("//p[@class='deposition_number']");
	By ClickOnViewPasscode=By.xpath("//p[@class='deposition_passcode']");
	By ClicokMemberlogin=By.xpath("//button[text()='Login']");
	By Login = By.xpath("//button[text()='Login']");
	By username = By.xpath("//input[@placeholder='Type your Username']");
	By password = By.xpath("//input[@placeholder='Type your Password']");
	By EnterSessionId=By.xpath("//input[@placeholder='Insert Your Session ID']");
	By EnterPassword=By.xpath("//input[@placeholder='Insert Your Session Passcode']");
	By CreateNew=By.xpath("//span[text()='Create New']");
	By Validating=By.xpath("//p[text()='Logout']");
	
	
	ArrayList<String> SessionID=new ArrayList<String>();
	ArrayList<String> SessionPassword=new ArrayList<String>();
	
	
	public void Driverquit() {
		Firefoxdriver.quit();
	}
	public void ClickOnNonZoomDepositionSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnNonZoomDeposition).click();
	}
	public void ClickOnIntroduceDocumentsFolder() {
		driver.findElement(ClickOnIntroduceDocumentsFolder).click();

	}
	
	public void BegeinSession() {
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
	public void CaptureSessionIDPassword() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		String Session=driver.findElement(CaptureSessionId).getText().split(" ")[1];
		SessionID.add(Session);
		driver.findElement(ClickOnViewPasscode).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		String passcode= driver.findElement(By.xpath("//span[@id='passcode']")).getText();
		SessionPassword.add(passcode);
		driver.findElement(By.xpath("//div[@id='dialogDepositionPasscode']")).click();
		Thread.sleep(2000);
		driver.manage().window().setSize(new Dimension(300, 800));
		driver.manage().window().setPosition(new Point(5,5));

	}
	
	public void MemberLogin() {
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
		Firefoxdriver.findElement(ClicokMemberlogin).click();
		Firefoxdriver.manage().window().setSize(new Dimension(300, 800));
		Firefoxdriver.manage().window().setPosition(new Point(900,8));
	}
	
	public void Enterusername() throws Exception {
		Firefoxdriver.findElement(username).sendKeys(readconfig.ClientUserID());
	}
	public void Enterpassword() throws Exception {
		Firefoxdriver.findElement(password).sendKeys(readconfig.ClientPassword());
	}
	public void EnterSessionId() {
		Firefoxdriver.findElement(EnterSessionId).sendKeys(SessionID.toArray(new String[0]));
		System.out.println(SessionID.toArray(new String[0]));
	}
	public void EnterSessionPassword() {
		Firefoxdriver.findElement(EnterPassword).sendKeys(SessionPassword.toArray(new String[0]));
	}
	
	public void clickonlogin() {
		Firefoxdriver.findElement(Login).click();
	}
	public void ClickOnCreateNew() throws InterruptedException {
		Thread.sleep(1000);
		try {
			
			Firefoxdriver.findElement(CreateNew).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void ValidatingMemberlogin() throws InterruptedException {
		Thread.sleep(3000);
		if(Firefoxdriver.findElement(Validating).isDisplayed()) {
			System.out.println("Co-Member Login Is Success");
			
		}
		
		else {
			System.out.println("Co-Member Login Failed");
		}
		
	}
	
	
	
	
	
	
}
