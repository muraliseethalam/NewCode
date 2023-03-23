package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Moving Session Folder
public class Client_Case_Session_Folder_Move_Validation_PageObjects {
	WebDriver driver;

	public Client_Case_Session_Folder_Move_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}

	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='Move Folder']");
	By ClickOnMove=By.xpath("(//span[text()='Move'])[1]");
	By ChooseCase=By.xpath("(//div[@class='field'])[1]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By ChooseSession=By.xpath("(//span[@class='arrow button'])[2]");
	By ClickOnmove=By.xpath("//input[@value='Move']");
	By Wait=By.xpath("//progress[@value='11']");
	By ClickOnClose=By.xpath("(//input[@value='Close'])[2]");
	By SearchFolder=By.xpath("//div[text()='Move Folder']");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnMoveDocumnetCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnMoveDocumnetSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By VerifyDocumnet=By.xpath("//div[text()='Move Folder']");


	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
		
	}
	public void ClickOnMove() throws Exception {
		driver.findElement(ClickOnMove).click();
	}
	public void ChooseCase() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
	}
	public void SelcetCase() throws Exception {
		Thread.sleep(2000);
		driver.findElement(SelectCase).click();	
	}
	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void ClickOnmove() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOnmove).click();
	}
	public void ClickOnClose() throws Exception {

		Thread.sleep(2000);
		driver.findElement(ClickOnClose).click();
	}

	public void SearchFolder() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(SearchFolder).isDisplayed()){
				System.out.println("Failed At Moving Case Session Folder");
			}

		} catch (Exception e) {
			System.out.println("Successfully Case Session Folder Moved");
		}
	}

	public void ClickOnCaseManagement() throws Exception {
		driver.findElement(ClickOnCaseManagement).click();
	}
	public void ClickOnMoveFolderCase() throws Exception {
		driver.findElement(ClickOnMoveDocumnetCase).click();
	}
	public void ClickOnMoveFolderSession() throws Exception {
		driver.findElement(ClickOnMoveDocumnetSession).click();
	}

	public void VerifyFolderMovedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Successfully Case Session Folder Moved");
				Screenshots.usernamescreenshot(driver, "CaseSessionFolderMoveValidation");
			}

		} catch (Exception e) {
			System.out.println("Failed At Moving Case Session Folder");
			Screenshots.usernamescreenshot(driver, "CaseSessionFolderMoveValidation");
		}
	}


}
