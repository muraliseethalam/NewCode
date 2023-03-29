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
 * @author Muralikrishna.Seethalam
 *
 */

// Case Session Folders Sorting
public class Member_Case_Sessions_Folders_Sorting_PageObjects {
	WebDriver driver;
	static String sort;
	public static Logger logger;

	public Member_Case_Sessions_Folders_Sorting_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	By ClickOnSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnAssert=By.xpath("(//div[@class='sortArrow up'])[1]");
	By ClickOnUpArrwo=By.xpath("(//div[@class='sortArrow'])[1]");
	By CaptureCases=By.xpath("//div[@id='foldersList']//ul//li//div[@class='folderLabel']");



	public void ClickOnSession() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked the session");
		Thread.sleep(3000);
	}

	public void Validationforsorting() throws InterruptedException {
		//		driver.switchTo().defaultContent();
		driver.findElement(ClickOnAssert).click();
		logger.info("Clicked the up arrwo button");
		List<WebElement> CaseNames=driver.findElements(CaptureCases);
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
		driver.findElement(ClickOnUpArrwo).click();
		logger.info("Clicked the down arrwo button");
		Screenshots.usernamescreenshot(driver, "MemberCaseSessionsFoldersSorting");
		logger.info("Screenshot captured");
		CaseNames=driver.findElements(CaptureCases);
		String[] aftersort=new String[CaseNames.size()];
		for(int i=0; i<CaseNames.size();i++) {
			aftersort[i]=CaseNames.get(i).getText().trim();
			System.out.println(aftersort[i]);
		}
		Assert.assertEquals(BeforeAssert, aftersort);
		System.out.println("Successfully Sorted Sessions Folder Cases");
		logger.info("Validated sorting");


	}





}