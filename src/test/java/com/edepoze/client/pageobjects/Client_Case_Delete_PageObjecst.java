package com.edepoze.client.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.edepoze.utilitifiles.Screenshots;

/**
 * @author MuraliSeethalam
 *
 */
// Client Case Delete
public class Client_Case_Delete_PageObjecst {

	WebDriver driver;

	By MouseMove=By.xpath("//div[text()='Sample Case (DEMO)']");
	By ClickOnDelete=By.xpath("(//a[text()='Delete'])[2]");
	By Confirmtdelete=By.xpath("//input[@value='Delete']");
	By RemainingCasesCount=By.xpath("//table[@class='tbl_info']//tr//td[3]");

	public Client_Case_Delete_PageObjecst(WebDriver driver) {
		this.driver=driver;

	}

	public void MouseMove() throws InterruptedException {
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(MouseMove)).build().perform();

	}

	public void ClickOnDelete() throws InterruptedException {
		driver.findElement(ClickOnDelete).click();

	}

	public void Confirmtdelete() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Confirmtdelete).click();
	}

	public int BeforeCaseCount() throws InterruptedException {
		Thread.sleep(2000);
		int BeforeCaseDeleteCount=driver.findElements(RemainingCasesCount).size();
		return BeforeCaseDeleteCount;

	}

	public int AfterCaseCount() throws InterruptedException {
		Thread.sleep(2000);
		int BeforeCaseDeleteCount=driver.findElements(RemainingCasesCount).size();
		return BeforeCaseDeleteCount;
	}

	public void Validation() throws InterruptedException {
		Thread.sleep(2000);
		Client_Case_Delete_PageObjecst validation=new Client_Case_Delete_PageObjecst(driver);
		int before=validation.BeforeCaseCount();
		int After=validation.AfterCaseCount();

		Assert.assertEquals(before, After);

		Screenshots.usernamescreenshot(driver, "ClientCaseDelete");
		System.out.println("Client Case Deleted Successfully");
	}

}
