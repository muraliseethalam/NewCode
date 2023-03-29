package com.edepoze.webapp.pageobjects;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.edepoze.utilitifiles.Screenshots;

/**
 * @author IndiraSai Kapavarapu
 *
 */

// Session Types Sorting

public class Member_Case_Sessions_Type_Sorting_PageObjects {
	WebDriver driver;
	static String sort;
	public static Logger logger;
	public Member_Case_Sessions_Type_Sorting_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
		}


	By ClickOnName=By.xpath("(//div[@class='sortKey'])[2]");
	By ClickOnType=By.xpath("//div[text()='Type']");
	By ClickOnAssert=By.xpath("(//div[@class='sortArrow up'])[2]");
	By ClickOnUpArrow=By.xpath("(//div[@class='sortArrow'])");
	By CaptureCaseSessionType=By.xpath("//div[@id='deposList']//ul//li[@class='section']");



	public void ClickOnType() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnName).click();
		logger.info("Clicked the name");
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnType).click();
		logger.info("Clicked the type");
	}
	public void Validationforsorting() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnAssert).click();
		logger.info("Clicked the up arrow button");
		List<WebElement> CaseNames=driver.findElements(CaptureCaseSessionType);
		String [] BeforeAssert=new String[CaseNames.size()];
		System.out.println("----------BeforeSorting-------------");

		for(int i=0; i<CaseNames.size(); i++ ) {
			BeforeAssert[i]=CaseNames.get(i).getText().trim();
			System.out.println(BeforeAssert[i]);
		}
		System.out.println("----------Assert-------------");
		for(int i=0; i<CaseNames.size();i++) {
			Arrays.sort(BeforeAssert);
			sort=	BeforeAssert[i];
			System.out.println(sort);
		}
		System.out.println("----------AfterSorting-------------");
		driver.findElement(ClickOnUpArrow).click();
		logger.info("Clicked the down arrow button");
		Screenshots.usernamescreenshot(driver, "MemberCasesSorting");
		logger.info("Screenshot captured");
		CaseNames=driver.findElements(CaptureCaseSessionType);
		String[] aftersort=new String[CaseNames.size()];
		for(int i=0; i<CaseNames.size();i++) {
			aftersort[i]=CaseNames.get(i).getText().trim();
			System.out.println(aftersort[i]);
		}
		Assert.assertEquals(BeforeAssert, aftersort);
		System.out.println("Successfully Sorted Type Of Member Case Session");
		logger.info("Sorting validated");
		driver.findElement(ClickOnType).click();
		logger.info("Clicked the type");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Name']")).click();
	}
}