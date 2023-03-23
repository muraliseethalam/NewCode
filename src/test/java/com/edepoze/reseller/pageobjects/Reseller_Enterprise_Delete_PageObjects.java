/**
 * 
 */
package com.edepoze.reseller.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;

/**
 * @author MuraliSeethalam
 *
 */
//Deleteing Enterprise Account
public class Reseller_Enterprise_Delete_PageObjects {

	WebDriver driver;

	By MouseOver=By.xpath("(//table[@class='tbl_info']/tbody/tr/td)[3]");
	By ClickOnEdit=By.xpath("(//a[text()='View/Edit'])[1]");
	By ClickOnDelete=By.xpath("(//span[text()='Delete'])[1]");
	By ClickOnConfirmDelete=By.xpath("//input[@value='Delete']");


	By searchText =By.name("searchText");
	By Go =By.name("go");


	public  Reseller_Enterprise_Delete_PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnSearch() throws Exception {
		Thread.sleep(2000);
		driver.findElement(searchText).sendKeys(OutputData.EnterpriseName());
	}
	public void ClicOnGo() throws Exception {
		Thread.sleep(2000);
		driver.findElement(Go).click();
	}
	public void MouseOver() throws InterruptedException {
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(MouseOver)).build().perform();
	}
	public void ClickOnEdit() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnEdit).click();
	}
	public void ClickOnDelete() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnDelete).click();
	}
	public void ClickOnConfirmDelete() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnConfirmDelete).click();
	}

	public void ValidationForDeletedOrNot() throws InterruptedException {
		Thread.sleep(3000);
		Screenshots.usernamescreenshot(driver, "DeleteClientAccounts");
		String Delete=driver.findElement(By.xpath("(//div[@class='showing']/div)[2]")).getText().split(" ")[4];

		int SearchCount=0;
		Assert.assertEquals(Delete, String.valueOf(SearchCount));
		System.out.println("Successfully Enterprise Account is Deleted");

	}

	//	public void AfterDelete() throws InterruptedException {
	//		
	//		String AfterDelete=driver.findElement(By.xpath("(//div[@class='showing']/div)[2]")).getText().split(" ")[4];
	//		System.out.println("Total Clients After Delete: "+ AfterDelete);
	//		
	//		Reseller_Clients_Delete_PageObjects obj=new Reseller_Clients_Delete_PageObjects(driver);
	//	}




}
