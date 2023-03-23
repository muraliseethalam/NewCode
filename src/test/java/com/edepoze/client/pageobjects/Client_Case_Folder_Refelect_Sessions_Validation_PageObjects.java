package com.edepoze.client.pageobjects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.Screenshots;
// Reflecting Of Case Folder In Sessions Folders
public class Client_Case_Folder_Refelect_Sessions_Validation_PageObjects {
	
	WebDriver driver;
	
	public Client_Case_Folder_Refelect_Sessions_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		
	}
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnCaseExhibits=By.xpath("//div[text()='Case Exhibits']");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	
	
	
	public void ClickOnCase() {
		driver.findElement(ClickOnCase).click();
	}
	public void ClickOnCaseFolder() {
		driver.findElement(ClickOnCaseFolder).click();
	}
	public void ClickOnCaseExhibits() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseExhibits).click();
		Screenshots.usernamescreenshot(driver, "Client Case Folder Documents");
	}
	public void ScrollDown() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void ValidatingCaseExhibitsDocumentsInSessions() throws InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> CaseExhibits=new ArrayList<String>();
		ArrayList<String> SessionCaseExhibits=new ArrayList<String>();
		try {
		List<WebElement> is=driver.findElements(By.xpath("//table[@class='file_list innerTable']//tr//td[2]"));
			for (WebElement ele : is) {
				String DocumentNames=ele.getText();
				CaseExhibits.add(DocumentNames);
			}
			driver.findElement(ClickOnSession).click();
			driver.findElement(ClickOnCaseExhibits).click();
			
			
			List<WebElement> es=driver.findElements(By.xpath("//table[@class='file_list innerTable']//tr//td[2]"));
			Screenshots.usernamescreenshot(driver, "CaseFolderRefelectSessionsValidation");
			for (WebElement s : es) {
				String SessionDocumentName=s.getText();
				SessionCaseExhibits.add(SessionDocumentName);
			}
			int CaseExhibitsCount=CaseExhibits.size();
//			int SessionCaseExhibitsCount=SessionCaseExhibits.size();
			
			
			
			for(int i=0; i<CaseExhibitsCount; i++) {
				if(CaseExhibits.get(i).equals(SessionCaseExhibits.get(i))) {
					System.out.println("CaseExhibits Documents format and Session CaseExhibits Documents format matched");
					
				}
				else {
					System.out.println("Test fail"+"\n"+"Excpeted file is: "+CaseExhibits.get(i)+"\n"+"Actuali File Is"+SessionCaseExhibits.get(i));
					
				}
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		
		}
	}
	
}