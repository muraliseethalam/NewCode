package com.edepoze.webapp.pageobjects;

import java.util.ArrayList;
/**
 * @author IndiraSai.Kapavarapu
 *
 */
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.edepoze.utilitifiles.Screenshots;

// Validating Client Documents And Member Documents 
public class CaseSession_Folder_Documents_Validation_PageObjects {

	WebDriver driver;

	public CaseSession_Folder_Documents_Validation_PageObjects(WebDriver driver) {

		this.driver=driver;

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
	}
	public void ClickOnClientSession() {
		driver.findElement(ClickOnClientSession).click();
	}

	public void ClickOnClientFolder() {
		driver.findElement(ClickOnClientFolder).click();
		Screenshots.usernamescreenshot(driver, "CaseSessionFolderDocumentsValidation");

	}

	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void ClientCaseSessionDocumentsCapture() {

		List<WebElement> ls=driver.findElements(By.xpath("//table[@class='file_list innerTable']//tr/td[2]"));
		for (WebElement ele : ls) {
			String OptionName=ele.getText();
			ClientCaseSessionDocuments.add(OptionName);
		}

	}

	public void ClickOnMemberSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnMemberSession).click();

	}

	public void ClickOnMemberFolder() {

		driver.findElement(ClickOnMemberFolder).click();
		Screenshots.usernamescreenshot(driver, "CaseSessionFolderDocumentsValidation");

	}

	public void MemberCaseSessionDocumentsCapture() {

		List<WebElement> ds=driver.findElements(By.xpath("//div[@id='filesList']//li//div//p[@class='fileName']"));

		for (WebElement ele : ds) {
			String OptionName1=ele.getText();
			MemberCaseSessionDocuments.add(OptionName1);
		}

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


	}



}



