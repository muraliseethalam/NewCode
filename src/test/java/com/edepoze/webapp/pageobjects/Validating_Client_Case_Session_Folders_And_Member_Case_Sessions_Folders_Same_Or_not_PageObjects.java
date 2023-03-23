package com.edepoze.webapp.pageobjects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.Screenshots;
/**
 * @author MuraliKrishna.Seethalam
 *
 */

// Validating Session Folders Of Client And Member
public class Validating_Client_Case_Session_Folders_And_Member_Case_Sessions_Folders_Same_Or_not_PageObjects {
	WebDriver driver;


	By ClickOnClientCase=By.xpath("//table[@class='tbl_info']//tr[1]//td[3]");
	By ClickOnClientSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By CaptureClintFolders=By.xpath("//table[@id='fileMgmtFolderList']//td//div[@class='to_e']");
	By ClickOnMemberCase=By.xpath("//div[@id='casesList']//ul//li[1]//div[@class='caseLabel'][1]");
	By ClickOnMeberSessions=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By CaptureMemberFolders=By.xpath("//div[@id='foldersList']//ul//p[@class='folderName']");

	public Validating_Client_Case_Session_Folders_And_Member_Case_Sessions_Folders_Same_Or_not_PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	ArrayList<String> ClientCaseFolder=new ArrayList<String>();
	ArrayList<String> MemberCaseFolder=new ArrayList<String>();
	ArrayList<String> MemberCaseFolder1=new ArrayList<String>();

	public void ClickOnClientCase() {
		driver.findElement(ClickOnClientCase).click();
	}
	public void ClickOnClientSession() {
		driver.findElement(ClickOnClientSession).click();
	}
	public void SelectAllFolders() {
		int Documnets=driver.findElements(By.xpath("//table[@class='folder_list innerTable']//tr//a")).size();
		for(int i=0; i<Documnets; i++) {
			int krishna=i+1;
			driver.findElement(By.xpath("(//table[@class='folder_list innerTable']//tr//a)["+krishna+"]")).click();

		}
	}
	public void CaptureClintFolders() {
		List<WebElement> FolderNames=driver.findElements(CaptureClintFolders);
		for (WebElement ele : FolderNames) {
			String OptionName=ele.getText();
			System.out.println(OptionName);
			ClientCaseFolder.add(OptionName);
		}
	}
	public void ClickOnMemberCase() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnMemberCase).click();
	}
	public void ClickOnMeberSessions() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnMeberSessions).click();
	}
	public void CaptureMemberFolders() {
		List<WebElement> FolderNames=driver.findElements(CaptureMemberFolders);
		for (WebElement ele : FolderNames) {
			String OptionName=ele.getText();
			System.out.println(OptionName);
			MemberCaseFolder.add(OptionName);
			Screenshots.usernamescreenshot(driver, "ValidatingClientCaseSessionFoldersAndMemberCaseSessionsFoldersSameOrNot");
		}
	}

	public void ValidatingFolders() {
		int UIFilesize=ClientCaseFolder.size();
		int DownloadSize=MemberCaseFolder.size();
		System.out.println("Member Case Session Folders count is: "+DownloadSize);
		System.out.println("Client Case Session Folders count is: "+UIFilesize);

		for(int i=0; i<UIFilesize; i++) {

			if(ClientCaseFolder.get(i).equals(MemberCaseFolder.get(i))) {
				System.out.println("Client Case Sesson Folders ANd Member Case Session Folders Are Same");
				continue;

			}
			else {
				System.out.println("Test fail"+"\n"+"Excpeted file is: "+ClientCaseFolder.get(i)+"\n"+"Actual File Is: "+MemberCaseFolder.get(i));

			}

		}


	}
}