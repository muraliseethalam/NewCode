/**
 *
 */
package com.edepoze.webapp.pageobjects;
/**
 * @author Muralikrishna.Seethalam
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.edepoze.utilitifiles.Screenshots;

// Validating Client Sessions And Member Sessions
public class Validating_Client_And_Member_Sessions_Same_Or_Not_PageObjects {
	public static Logger logger;
	WebDriver driver;
	By ClikOnCase = By.xpath("//div[@class='scrollTable']//table//tr//td[3]");
	By ClientCaseSessions = By.xpath("//div[@class='scrollTable']//table//tr//td[4]");
	By MemberCaseSessions = By.xpath("//div[@id='deposList']//ul//li//div[@class='witness']");
	public Validating_Client_And_Member_Sessions_Same_Or_Not_PageObjects(WebDriver driver) {
		this.driver = driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	ArrayList<String> ClientCaseSession = new ArrayList<String>();
	ArrayList<String> MemberCaseSession=new ArrayList<String>();
	ArrayList<String> MemberCaseSession1=new ArrayList<String>();
	public void ClikOnCase() {
		driver.findElement(ClikOnCase).click();
		logger.info("Clicked on case");
	}
	public void CapturingClientCaseSesionsNames() {
		List<WebElement> CapturingClientCaseSesionsNames = driver.findElements(ClientCaseSessions);
		for (WebElement WebElement : CapturingClientCaseSesionsNames) {
			String ClientCaseSessionList = WebElement.getText();
			ClientCaseSession.add(ClientCaseSessionList);
			logger.info("Captured client case session names");
		}
	}
	public void CapturingMemberCaseSessionsName() {
		driver.switchTo().frame(0);
		List<WebElement> CapturingMemberSessionName=driver.findElements(MemberCaseSessions);
		for (WebElement WebElement : CapturingMemberSessionName) {
			String MemberCaseSessionList=WebElement.getText();
			MemberCaseSession.add(MemberCaseSessionList);
			logger.info("Captured member case session names");
			Screenshots.usernamescreenshot(driver, "ValidatingClientAndMemberCaseSessionSameOrNot");
			logger.info("Captured screenshot");
		}
	}


	//	Compare two arraylists – find missing elements
	public void ValidatingClientAndMemberCasesSessionsSameOrNot() {
		MemberCaseSession.removeAll(ClientCaseSession);
		Assert.assertEquals(MemberCaseSession1, MemberCaseSession);
		Screenshots.usernamescreenshot(driver, "ValidatingClientAndMemberCaseSessionSameOrNot");
		logger.info("Captured screenshot");
		System.out.println("Client And Member Case Sessions Are Same");
		logger.info("Validated client case sessions and member case session");

	}
}