package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;
import com.github.javafaker.Faker;

/**
 * @author MuraliSeethalam
 *
 */

// Editing Client Case 
public class Client_Case_Edit_PageObjects {
	public static Logger logger;
	WebDriver driver;
	OutputData obj=new OutputData();

	Faker faker=new Faker();

	By MouseMove=By.xpath("(//table[@class='tbl_info']/tbody/tr/td[3])[1]");
	By ClickOnEdit=By.xpath("(//a[text()='Edit'])[1]");
	By ClearName=By.name("name");
	By ClickOnSave=By.className("btn_blue_r");

	public void MouseMove() throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(MouseMove)).build().perform();
		logger.info("Mouse hovered");
	}
	public void ClickOnEdit() throws InterruptedException {
		driver.findElement(ClickOnEdit).click();
		logger.info("Client on edit");
	}
	public void ClearName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClearName).clear();
		logger.info("Cleared name");
	}

	public void EnterCaseName() throws Exception {
		Thread.sleep(2000);
		String CaseName=faker.name().firstName();
		driver.findElement(ClearName).sendKeys("A"+CaseName);
		Thread.sleep(1000);
		String ReName=driver.findElement(ClearName).getAttribute("value");
		obj.WriteExcel("Sheet1", ReName, 9, 1);
		logger.info("Entered case name");

	}
	public void ScrollDown() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}

	public void ClickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnSave).click();
		logger.info("Clicked on Save button");
	}
	public void ValidationForEditScenario() throws Exception {
		Thread.sleep(1000);
		boolean editcase=driver.getPageSource().contains(OutputData.ReName());

		if(editcase==true) {
			System.out.println("Case Name Edited Successfully");
			Screenshots.usernamescreenshot(driver, "ClientCaseEdit");
			logger.info("Captured screenshot");
		}
		else {
			System.out.println("Failed at Case Name Editing");
			Screenshots.usernamescreenshot(driver, "ClientCaseEdit");
			logger.info("Captured screenshot");

		}
		logger.info("Edited case");

	}


	public Client_Case_Edit_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}


}
