package com.edepoze.client.pageobjects;

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
	}
	public void ClickOnEdit() throws InterruptedException {
		driver.findElement(ClickOnEdit).click();
	}
	public void ClearName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClearName).clear();
	}

	public void EnterCaseName() throws Exception {
		Thread.sleep(2000);
		String CaseName=faker.name().firstName();
		driver.findElement(ClearName).sendKeys("A"+CaseName);
		Thread.sleep(1000);
		String ReName=driver.findElement(ClearName).getAttribute("value");
		obj.WriteExcel("Sheet1", ReName, 9, 1);

	}
	public void ScrollDown() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void ClickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnSave).click();
	}
	public void ValidationForEditScenario() throws Exception {
		Thread.sleep(1000);
		boolean editcase=driver.getPageSource().contains(OutputData.ReName());

		if(editcase==true) {
			System.out.println("Case Name Edited Successfully");
			Screenshots.usernamescreenshot(driver, "ClientCaseEdit");
		}
		else {
			System.out.println("Failed at Case Name Editing");
			Screenshots.usernamescreenshot(driver, "ClientCaseEdit");
		}
	}


	public Client_Case_Edit_PageObjects(WebDriver driver) {
		this.driver=driver;
	}


}
