package com.edepoze.webapp.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Opening All Documents
public class CaseSession_All_Files_Validation_PageObjects {

	WebDriver driver;
	public static Logger logger;

	public CaseSession_All_Files_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");

	}

	By ClickOnMemberSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnMemberFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnDocuments=By.xpath("//div[@id='filesList']//ul//li//p[@class='name']");
	By ClickOnBackButton=By.xpath("//div[@class='back_btn']");


	public void SwitchFrame() {
		driver.switchTo().frame(0);
	}
	public void ClickOnMemberSession() {
		driver.findElement(ClickOnMemberSession).click();
		logger.info("Clicked the member session");
	}

	public void ClickOnMemberFolder() {
		driver.findElement(ClickOnMemberFolder).click();
		logger.info("Clicked the member folder");
	}
	public void ClickOnBackButton() {
		driver.findElement(ClickOnBackButton).click();	
		logger.info("Clicked the back button");
	}
	public void DocumentsValidation() throws InterruptedException {
		int Documnets=driver.findElements(ClickOnDocuments).size();

		for(int i=0; i<Documnets; i++ ) { 
			int file=i+1;
			driver.findElement(By.xpath("(//div[@id='filesList']//ul//li//div[@class='file_info'])"+"["+file+"]")).click();

			driver.switchTo().defaultContent();  
			if(driver.findElement(By.xpath("//div[text()='Loading...']")).isEnabled()){

				System.out.println("File is opened");
			}
			else {
				System.out.println("File is not opened");
			}
			Thread.sleep(25000);
			driver.findElement(ClickOnBackButton).click();	
			driver.switchTo().frame(0);
		}
		logger.info("Validated documents");
	}
}
