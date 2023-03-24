package com.edepoze.reseller.pageobjects;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.edepoze.utilitifiles.Screenshots;

// Reseller Home Page Pagination
public class Reseller_Home_Page_Pagination_PageObjects {
	WebDriver driver;
	static String sort;
	public static Logger logger;
	
	By ClickOnArrow=By.xpath("(//span[@class='arrow button'])[2]");
	By ClickOnNames=By.xpath("(//li[text()='10'])[2]");
	By ClickOnPaginator=By.xpath("((//div[@name='paginator'])[2]/a)[2]");
	By Click=By.xpath("//table[@class='tbl_info']/tbody/tr/td[3]");
	By Size=By.xpath("//table[@class='tbl_info']/tbody/tr/td[3]");
	By show=By.xpath("(//div[@class='showing']/div)[2]");
	public  Reseller_Home_Page_Pagination_PageObjects(WebDriver driver) {
		this.driver = driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	public void HomePagePagination() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scroll down");
		driver.findElement(ClickOnArrow).click();
		Thread.sleep(2000);
		logger.info("Clicked the arrow button");
		driver.findElement(ClickOnNames).click();
		Thread.sleep(3000);
		logger.info("Getting names");
		driver.findElement(By.xpath("ClickOnPaginator")).click();
		logger.info("Clicked on pagination 1 page ");
		Screenshots.usernamescreenshot(driver, "ResellerHomePagePagination");
		logger.info("Screenshot captured");
		int PageOne=driver.findElements(Click).size();
		logger.info("1st page names caliculated");
		System.out.println(PageOne);
		Thread.sleep(5000);
		
		driver.findElement(ClickOnPaginator).click();
		Thread.sleep(5000);
		logger.info("Clicked pagination 2 page");
		Screenshots.usernamescreenshot(driver, "ResellerHomePagePagination");
		logger.info("Screen shot captured");
		int Pagetwo=driver.findElements(Size).size();
		logger.info("2nd page names caliculated");
		System.out.println(Pagetwo);
		Thread.sleep(5000);
		
		driver.findElement(ClickOnPaginator).click();
		Thread.sleep(5000);
		logger.info("Clicked pagination 3 page");
		Screenshots.usernamescreenshot(driver, "ResellerHomePageSortingTest");
		int Pagethree=driver.findElements(Click).size();
		logger.info("2nd page names caliculated");
		System.out.println(Pagethree);
		
		
		int totalnumers=PageOne+Pagetwo+Pagethree;
		System.out.println("Total Pagination Count is: "+totalnumers);
		String DisplayedCount=driver.findElement(show).getText().split(" ")[4];
		System.out.println("Total Names Displayed Count" + DisplayedCount);
		Assert.assertEquals(DisplayedCount, String.valueOf(totalnumers));
		System.out.println("Success Pagination Validation of Reseller Home Page");
		logger.info("Validated pagination");
	}
}