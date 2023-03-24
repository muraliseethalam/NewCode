package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;

/**
 * @author MuraliSeethalam
 *
 */

// Deleting Session
public class Client_Case_Sessions_Delete_PageObjects {
	public static Logger logger;
	WebDriver driver;
	OutputData obj=new OutputData();
	public Client_Case_Sessions_Delete_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");

	}

	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By MouseOver=By.xpath("(//table[@class='tbl_info'])[2]//tr[4]//td[9]");
	By ClickOnDelete=By.xpath("(//a[text()='Delete'])[4]");
	By ConfirmDelte=By.xpath("//input[@value='Delete']");
	By CaseID=By.xpath("(//table[@class='tbl_info'])[2]//tr[4]//td[2]");

   public static String SessionID=null;

	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnDelete() throws Exception {
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(MouseOver)).build().perform();
		logger.info("Mouse hovered");
		driver.findElement(ClickOnDelete).click();
		logger.info("Clicked on delete");
	}
	public void ConfirmDelete() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ConfirmDelte).click();
		logger.info("Clicked on confirm delete");
	}
	public void CaptureCaseID() throws Exception {
		Thread.sleep(1000);
		String CasId=driver.findElement(CaseID).getText();
		SessionID=CasId;
		logger.info("Captured case ID");
		
	}
	public void ValidateSessionDeletedOrNot() throws Exception {
		Thread.sleep(2000);
		//		WebElement Xpath=driver.findElement(By.xpath("//td[text()='"+CaseId+"']"));
		//		System.out.println(Xpath);
		try {

			if(driver.findElement(By.xpath("//td[text()='"+SessionID+"']")).isDisplayed()) {
				System.out.println("Failed at deleting Session");
				Screenshots.usernamescreenshot(driver, "ClientCaseSessionsDeleteValidation");
			}

		} catch (Exception e) {
			System.out.println("Successfully Deleted Session");
			Screenshots.usernamescreenshot(driver, "ClientCaseSessionsDeleteValidation");
		}
	
		logger.info("Deleted case session");
	
	}
	
	


}
