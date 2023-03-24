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

// Validating Client Documents And Member Documents 
public class CaseSession_Folder_Documents_Validation_PageObjects {

	WebDriver driver;
 public static Logger logger;

	public CaseSession_Folder_Documents_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}

	By ClickOnClientCase=By.xpath("//table[@class='tbl_info']//tr[1]//td[3]");
	By ClickOnClientSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnClientFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");

	By ClickOnMemberSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnMemberFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");

	ArrayList<String> ClientCaseSessionDocuments=new ArrayList<String>();
	ArrayList<String> MemberCaseSessionDocuments=new ArrayList<String>();

	public void ClickOnClientCase() {
		driver.findElement(ClickOnClientCase).click();
		logger.info("Clicked the client case");
	}
	public void ClickOnClientSession() {
		driver.findElement(ClickOnClientSession).click();
		logger.info("Clicked the client session");
	}

	public void ClickOnClientFolder() {
		driver.findElement(ClickOnClientFolder).click();
		logger.info("Clicked the client folder");
		Screenshots.usernamescreenshot(driver, "CaseSessionFolderDocumentsValidation");
		logger.info("Screenshot captured");
		
	}

	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scroll down");
	}

	public void ClientCaseSessionDocumentsCapture() {

		List<WebElement> ls=driver.findElements(By.xpath("//table[@class='file_list innerTable']//tr/td[2]"));
		for (WebElement ele : ls) {
			String OptionName=ele.getText();
			ClientCaseSessionDocuments.add(OptionName);
		}
		logger.info("Captured client case session documents");

	}

	public void ClickOnMemberSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnMemberSession).click();
		logger.info("Clicked the member session");

	}

	public void ClickOnMemberFolder() {
		driver.findElement(ClickOnMemberFolder).click();
		logger.info("Clicked the member folder");
		Screenshots.usernamescreenshot(driver, "CaseSessionFolderDocumentsValidation");
		logger.info("Screenshot captured");

	}

	public void MemberCaseSessionDocumentsCapture() {

		List<WebElement> ds=driver.findElements(By.xpath("//div[@id='filesList']//li//div//p[@class='fileName']"));

		for (WebElement ele : ds) {
			String OptionName1=ele.getText();
			MemberCaseSessionDocuments.add(OptionName1);
		}
		logger.info("Capture member case session documents");

	}	

	public void ComparisionBetweenCaseSessionDocumentsOfClientAndMember() throws Exception {

		int MemberCaseSessionDocumentssize=MemberCaseSessionDocuments.size();
		//	    int ClientCaseSessionDocumentssize=ClientCaseSessionDocuments.size();

		for(int i=0; i<MemberCaseSessionDocumentssize; i++) {

			if(MemberCaseSessionDocuments.get(i).equals(ClientCaseSessionDocuments.get(i))) {
				System.out.println("Client CaseSession Documents format and Member CaseSession documents format Matched");
				continue;

			}
			else {
				System.out.println("Test fail"+"\n"+"Expected file is: "+MemberCaseSessionDocuments.get(i)+"\n"+"Actual File Is: "+ClientCaseSessionDocuments.get(i));

			}


		}
		logger.info("Compared between case session documents of client and member");

	}



}



