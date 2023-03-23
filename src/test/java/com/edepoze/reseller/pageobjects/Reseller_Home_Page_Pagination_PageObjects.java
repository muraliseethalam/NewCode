package com.edepoze.reseller.pageobjects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.edepoze.utilitifiles.Screenshots;

// Reseller Home Page Pagination
public class Reseller_Home_Page_Pagination_PageObjects {
	WebDriver driver;
	static String sort;
	
	By ClickOnArrow=By.xpath("(//span[@class='arrow button'])[2]");
	By ClickOnNames=By.xpath("(//li[text()='10'])[2]");
	By ClickOnPaginator=By.xpath("((//div[@name='paginator'])[2]/a)[2]");
	By Click=By.xpath("//table[@class='tbl_info']/tbody/tr/td[3]");
	By Size=By.xpath("//table[@class='tbl_info']/tbody/tr/td[3]");
	By show=By.xpath("(//div[@class='showing']/div)[2]");
	public  Reseller_Home_Page_Pagination_PageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void HomePagePagination() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(ClickOnArrow).click();
		Thread.sleep(2000);
		driver.findElement(ClickOnNames).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("ClickOnPaginator")).click();
		Screenshots.usernamescreenshot(driver, "ResellerHomePagePagination");
		int PageOne=driver.findElements(Click).size();
		System.out.println(PageOne);
		Thread.sleep(5000);
		
		driver.findElement(ClickOnPaginator).click();
		Thread.sleep(5000);
		Screenshots.usernamescreenshot(driver, "ResellerHomePagePagination");
		int Pagetwo=driver.findElements(Size).size();
		System.out.println(Pagetwo);
		Thread.sleep(5000);
		
		driver.findElement(ClickOnPaginator).click();
		Thread.sleep(5000);
		Screenshots.usernamescreenshot(driver, "ResellerHomePageSortingTest");
		int Pagethree=driver.findElements(Click).size();
		System.out.println(Pagethree);
		
		
		int totalnumers=PageOne+Pagetwo+Pagethree;
		System.out.println("Total Pagination Count is: "+totalnumers);
		String DisplayedCount=driver.findElement(show).getText().split(" ")[4];
		System.out.println("Total Names Displayed Count" + DisplayedCount);
		Assert.assertEquals(DisplayedCount, String.valueOf(totalnumers));
		System.out.println("Success Pagination Validation of Reseller Home Page");
	}
}