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

// Case Numbers Sorting
public class Member_CaseNumbers_Sorting_PageObjects {
	WebDriver driver;
	static String sort;
	public static Logger logger;
	public Member_CaseNumbers_Sorting_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
		}


	By ClickOnName=By.xpath("(//div[@class='sortKey'])[1]");
	By ClickOnCaseNumber=By.xpath("//div[text()='Case Number']");
	By ClickOnAssert=By.xpath("(//div[@class='sortArrow up'])[1]");
	By ClickOnUpArrow=By.xpath("(//div[@class='sortArrow'])[1]");
	By CaptureCaseNumbers=By.xpath("//div[@class='caseNumber']");

	public void ClickOnCaseNumber() throws InterruptedException {	

		driver.switchTo().frame(0);
		driver.findElement(ClickOnName).click();
		logger.info("Clicked the name");
		driver.switchTo().defaultContent();
		driver.findElement(ClickOnCaseNumber).click();
		logger.info("Clicked the case number");
	
	}

	public void Validationforsorting() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnAssert).click();
		logger.info("Clicked the up arrow button");
		List<WebElement> CaseNames=driver.findElements(CaptureCaseNumbers);
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
		CaseNames=driver.findElements(CaptureCaseNumbers);
		String[] aftersort=new String[CaseNames.size()];
		for(int i=0; i<CaseNames.size();i++) {
			aftersort[i]=CaseNames.get(i).getText().trim();
			System.out.println(aftersort[i]);
		}
		Assert.assertEquals(BeforeAssert, aftersort);
		System.out.println("Successfully Sorted Member Case Numbers");	
		logger.info("Sorting validated");
		driver.findElement(ClickOnCaseNumber).click();
		logger.info("Clicked the case number");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Name']")).click();
	}
	
}