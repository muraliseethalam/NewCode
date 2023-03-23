package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Copying Session Folder
public class Client_Case_Session_Folder_Copy_Validation_PageObjects {
	WebDriver driver;

	public Client_Case_Session_Folder_Copy_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}

	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='Copy Folder']");
	By ClickOnCopy=By.xpath("(//span[text()='Copy'])[1]");
	By ChooseCase=By.xpath("(//div[@class='field'])[1]");
	By SelectCase=By.xpath("//li[text()='MATZ Move Case']");
	By ChooseSession=By.xpath("(//span[@class='arrow button'])[2]");
	By SelectSession=By.xpath("((//ul[@class='_custom_select_list']))[2]");
	By ClickOncopy=By.xpath("//input[@value='Copy']");
	By Wait=By.xpath("//progress[@value='11']");
	By ClickOnClose=By.xpath("(//input[@value='Close'])[2]");
	By SearchFolder=By.xpath("//div[text()='Copy Folder']");
	By ClickOnCaseManagement=By.xpath("//a[text()='Case Management']");
	By ClickOnCopyDocumnetCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[2]");
	By ClickOnCopyDocumnetSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnCopyFolder=By.xpath("//div[text()='Copy Folder']");
	By VerifyDocumnet=By.xpath("//div[text()='Copy Folder']");


	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
	
	}

	public void ScrollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void ClickOnCopy() throws Exception {
		driver.findElement(ClickOnCopy).click();
		
	}
	public void ChooseCase() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ChooseCase).click();
	}
	public void SelcetCase() throws Exception {
		Thread.sleep(2000);
		driver.findElement(SelectCase).click();	
	}


	public void ClickOncopy() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOncopy).click();
	}
	public void ClickOnClose() throws Exception {
		Thread.sleep(1000);
		driver.findElement(Wait);
		Thread.sleep(2000);
		driver.findElement(ClickOnClose).click();
	}
	public void SearchFolder() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(SearchFolder).isDisplayed()){
				System.out.println("Successfully Case Session Folder Copied");
			}

		} catch (Exception e) {
			System.out.println("Failed at Copying Case Session Folder");
		}
	}

	public void ClickOnCaseManagement() throws Exception {
		driver.findElement(ClickOnCaseManagement).click();
	}
	public void ClickOnCopyFolderCase() throws Exception {
		driver.findElement(ClickOnCopyDocumnetCase).click();
	}
	public void ClickOnCopyFolderSession() throws Exception {
		driver.findElement(ClickOnCopyDocumnetSession).click();
	}
	public void VerifyFolderCopiedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(VerifyDocumnet).isDisplayed()){
				System.out.println("Successfully Case Session Folder Copied");
				Thread.sleep(1000);
				Screenshots.usernamescreenshot(driver, "CaseSessionFolderCopyValidation");
			}

		} catch (Exception e) {
			System.out.println("Failed at Copying Case Session Folder");
			Thread.sleep(1000);
			Screenshots.usernamescreenshot(driver, "CaseSessionFolderCopyValidation");
		}
	}

}
