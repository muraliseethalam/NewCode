package com.edepoze.webapp.pageobjects;

import java.util.ArrayList;
/**
 * @author IndiraSai.Kapavarapu
 *
 */
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.edepoze.utilitifiles.Screenshots;

// Validating Case Session ID And Password 

public class CaseSession_ID_And_Password_Validation_PageObjects {

	WebDriver driver;
	public static Logger logger;
	public CaseSession_ID_And_Password_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");

	}

	By ClickOnClientCase=By.xpath("//table[@class='tbl_info']//tr[1]//td[3]");
	By ClickOnClientSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnMemberSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnBeginSession=By.xpath("//div[@id='btn_start_deposition']");
	By ClickOnBeginSessionOk=By.xpath("//button[@class='dialogOkBtn']");
	By ClickOnViewPasscode=By.xpath("//p[@class='deposition_passcode']");

	ArrayList<String> ClientCaseSessionID=new ArrayList<String>();
	ArrayList<String> ClientCaseSessionPassword=new ArrayList<String>();
	ArrayList<String> MemberCaseSessionID=new ArrayList<String>();
	ArrayList<String> MemberCaseSessionPassword=new ArrayList<String>();


	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scroll down");
	}

	public void ClickOnClientCase() {
		driver.findElement(ClickOnClientCase).click();
		logger.info("Clicked the client case");
	}

	public void ClickOnClientSession() {
		driver.findElement(ClickOnClientSession).click();
		logger.info("Clicked the client session");
		Screenshots.usernamescreenshot(driver, "CaseSessionIDAndPasswordValidation");
		logger.info("Screenshot captured");
	}

	public void ClientCaseSessionIDCapture() throws Exception {
		List<WebElement> ls=driver.findElements(By.xpath(" //table[@class='view_details_table']//tr[2]//td[2]"));
		for (WebElement ele : ls) {
			String OptionName=ele.getText();
			ClientCaseSessionID.add(OptionName);
		}
		logger.info("Captured client case session ID");
	}

	public void ClientCaseSessionPasswordCapture() throws Exception {
		List<WebElement> ps=driver.findElements(By.xpath("//table[@class='view_details_table']//tr[2]//td[3]"));
		for (WebElement ele : ps) {
			String OptionName1=ele.getText();
			ClientCaseSessionPassword.add(OptionName1);
		}
		logger.info("Captured client case session password");
	}

	public void ClickOnMemberSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnMemberSession).click();
		logger.info("clicked the member session");
		Screenshots.usernamescreenshot(driver, "CaseSessionIDAndPasswordValidation");
		logger.info("Screenshot captured");
	}

	public void CaptureMemberSessionId() {
		String getSessionId= driver.findElement(By.xpath("//p[@class='deposition_number']")).getText().split(" ")[1];
		MemberCaseSessionID.add(getSessionId);
		logger.info("Captured member session ID");
	}

	public void CaptureMemberPassword() {
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
		logger.info("Captured member session password");
	}
	public void PasswordCapture() throws InterruptedException {

		driver.findElement(ClickOnViewPasscode).click();
		logger.info("Clicked the view passcode");
		driver.switchTo().defaultContent();  
		Thread.sleep(3000);
		Screenshots.usernamescreenshot(driver, "CaseSessionIDAndPasswordValidation");
		logger.info("Screenshot captured");
		List<WebElement> pws=driver.findElements(By.xpath("//span[@id='passcode']"));
		for (WebElement ele : pws) {
			String OptionName2=ele.getText();
			MemberCaseSessionPassword.add(OptionName2);
		}
		logger.info("Captured password");
	}


	public void ComparisionBetweenCaseSessionIDofClientAndMember() throws Exception {
		int ClientCaseSessionIDsize=ClientCaseSessionID.size();

		for(int i=0; i<ClientCaseSessionIDsize; i++) {

			if(ClientCaseSessionID.equals(MemberCaseSessionID)) {
				System.out.println("Client Case Session ID and Member Case Session Id are matched");

			}
			else {
				System.out.println("Client Case Session ID and Member Case Session Id does not match");
			}
		}
		logger.info("Compared between case session ID of client and member");
	}

	public void ComparisionBetweenCaseSessionPasswordofClientAndMember() throws Exception {
		int ClientCaseSessionPasswordsize=ClientCaseSessionPassword.size();

		for(int j=0; j<ClientCaseSessionPasswordsize; j++) {

			if(ClientCaseSessionPassword.equals(MemberCaseSessionPassword)) {
				System.out.println("Client Case Session Passcode and Member Case Session passcode are matched");

			}
			else {
				System.out.println("Client Case Session Passcode and Member Case Session passcode does not match");
			}
		}
		logger.info("Compared between case session password of client and member");
	}
}





