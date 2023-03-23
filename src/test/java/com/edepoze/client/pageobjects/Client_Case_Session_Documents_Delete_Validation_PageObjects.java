package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.Screenshots;


// Deleting Session Documents
public class Client_Case_Session_Documents_Delete_Validation_PageObjects {
	WebDriver driver;

	public Client_Case_Session_Documents_Delete_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}

	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By ClickOnDocumnet=By.xpath("(//table[@class='file_list innerTable']//tr//td[1])[5]");
	By ClickOnDelete=By.xpath("(//span[text()='Delete'])[2]");
	By ClickOndelete=By.xpath("//input[@value='Delete']");
	By Wait=By.xpath("//progress[@value='1']");
	By SearchDocumnet=By.xpath("(//div[text()='pptx1.pptx'])[2]");

	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
	}
	public void ClickOnDocumnet() throws Exception {
		driver.findElement(ClickOnDocumnet).click();
	}
	public void ClickOnDelete() throws Exception {
		driver.findElement(ClickOnDelete).click();
	}
	public void ClickOnConfirmDelete() throws Exception {
		Thread.sleep(2000);
		driver.findElement(ClickOndelete).click();
		Screenshots.usernamescreenshot(driver, "CaseSessionDocumentsDeleteValidation");
	}
	public void ScroollDown() throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void VerifyDocumentDeletedOrNot() throws Exception {
		Thread.sleep(1000);
		try {
			if(driver.findElement(SearchDocumnet).isDisplayed()){
				System.out.println("Failed At Deleting Case Session Document");
			}

		} catch (Exception e) {
			System.out.println("Successfully Case Session Document Deleted");
		}
	}
}
