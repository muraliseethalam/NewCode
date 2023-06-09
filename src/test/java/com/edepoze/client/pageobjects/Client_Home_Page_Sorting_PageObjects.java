package com.edepoze.client.pageobjects;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.edepoze.utilitifiles.Screenshots;

public class Client_Home_Page_Sorting_PageObjects {
	public static Logger logger;
	WebDriver driver;
	static String sort;
	
	By ClickOnCase=By.xpath("//table[@class='tbl_info']/tbody/tr/td[3]");
	By ClickOnSort=By.xpath("//span[@class='sort']");
	By ClickOnNames=By.xpath("//table[@class='tbl_info']/tbody/tr/td[4]");
	By ClickOnSortUp=By.xpath("//span[@class='sort top']");
	
	public  Client_Home_Page_Sorting_PageObjects(WebDriver driver) {
		this.driver = driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	public void ClientHomePageSorting() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(ClickOnSort).click();
		logger.info("Clicked on sort");
		Thread.sleep(3000);
		Screenshots.usernamescreenshot(driver, "ClientHomePageSorting");
		logger.info("Captured screenshot");
		List<WebElement> clname=driver.findElements(ClickOnCase);
		logger.info("Clicked on case");
		String[] beforesort=new String[clname.size()];
		System.out.println("----------BeforeSorting-------------");
		for(int i=0; i<clname.size();i++) {
			beforesort[i]=clname.get(i).getText().trim();
			System.out.println(beforesort[i]);
		}
		System.out.println("----------Assert-------------");
		for(int i=0; i<clname.size();i++) {
			Arrays.sort(beforesort);
			sort=	beforesort[i];
			System.out.println(sort);
		}
		System.out.println("----------AfterSorting-------------");
		Thread.sleep(3000);
		driver.findElement(ClickOnSortUp).click();
		//	    driver.findElement(By.xpath("//span[@class='sort']")).click();
		Thread.sleep(2000);
		Screenshots.usernamescreenshot(driver, "ClientHomePageSorting");
		logger.info("Captured screenshot");
		clname=driver.findElements(ClickOnCase);
		String[] aftersort=new String[clname.size()];
		for(int i=0; i<clname.size();i++) {
			aftersort[i]=clname.get(i).getText().trim();
			System.out.println(aftersort[i]);
		}
		Assert.assertEquals(beforesort, aftersort);
		System.out.println("Successfully Sorted Client Home Page");
		logger.info("Sorted client home page");
	}
}