package com.edepoze.webapp.pageobjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.edepoze.utilitifiles.Screenshots;

// Member Joining After Through Join Button

public class Member_Join_PageObjects {
	WebDriver driver;
	public static Logger logger;
	public Member_Join_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}


	By ClickOnMemberSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnBeginSession=By.xpath("//div[@id='btn_start_deposition']");
	By ClickOnBeginSessionOk=By.xpath("//button[@class='dialogOkBtn']");
	By ClickOnViewPasscode=By.xpath("//p[@class='deposition_passcode']");
	By CaptureSessionId=By.xpath("//p[@class='deposition_number']");
	By ClickOnCases=By.xpath("//div[@class='cases_btn']");
	By ClickOnJoinButton=By.xpath("//div[@class='join_btn']");
	By EnterSessionID=By.xpath("//input[@name='data[EDUser][depositionID]']");
	By EnterSessionPassword=By.xpath("//input[@name='data[EDUser][depositionPasscode]']");
	By ClickOnJoin=By.xpath("(//div[@class='app_bttn_new'])[2]");

	ArrayList<String> JoinSessionID=new ArrayList<String>();
	ArrayList<String> SessionPassword=new ArrayList<String>();
	ArrayList<String> SessionID=new ArrayList<String>();

	public void ClickOnMemberSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnMemberSession).click();
		logger.info("Clicked the member sesssion");
		Screenshots.usernamescreenshot(driver, "CaseSessionIDAndPasswordValidation");
		logger.info("Captured screenshot");
	}

	public void CaptureMemberSessionId()  {

		String Session=driver.findElement(CaptureSessionId).getText().split(" ")[1];
		SessionID.add(Session);
		logger.info("Captured member session ID");

	}

	public void CaptureMemberPassword() throws InterruptedException {
		try {
			if(driver.findElement(ClickOnBeginSession).isDisplayed()) {
				driver.findElement(ClickOnBeginSession).click();	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			//	driver.switchTo().defaultContent();
			if(driver.findElement(ClickOnBeginSessionOk).isDisplayed()) {
				driver.findElement(ClickOnBeginSessionOk).click();
				//		driver.switchTo().frame(0);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		logger.info("Captured member session password");
		driver.findElement(ClickOnViewPasscode).click();
		logger.info("Clciked the view password");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		String passcode= driver.findElement(By.xpath("//span[@id='passcode']")).getText();
		SessionPassword.add(passcode);
		driver.findElement(By.xpath("//div[@id='dialogDepositionPasscode']")).click();

	}


	public void ClickOnCases() {
		driver.findElement(ClickOnCases).click();
		logger.info("Clciked the cases");
	}	

	public void JoinSession() throws InterruptedException {	
		driver.findElement(ClickOnJoinButton).click();
		logger.info("Clciked the join button");
		driver.findElement(EnterSessionID).sendKeys(SessionID.toArray(new String[0]));
		logger.info("Entered the session ID");
		driver.findElement(EnterSessionPassword).sendKeys(SessionPassword.toArray(new String[0]));
		logger.info("Clciked the sessiom password");
		driver.findElement(ClickOnJoin).click();
		logger.info("Clciked the join");

	}

	public void JoinSessionValidation() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		String JoinSession=driver.findElement(CaptureSessionId).getText().split(" ")[1];
	    JoinSessionID.add(JoinSession);	
	    logger.info("Captured session ID");
		int SessionIDsize=SessionID.size();

		for(int i=0; i<SessionIDsize; i++) {

			if(SessionID.equals(JoinSessionID)) {
				
				System.out.println("Successfully Member Joined Session");

			}
			else {
				System.out.println("Failed To Join Session");
			}
		}
		 logger.info("Validated join session");
	}
}





