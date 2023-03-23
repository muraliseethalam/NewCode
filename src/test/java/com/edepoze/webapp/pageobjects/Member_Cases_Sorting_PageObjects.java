package com.edepoze.webapp.pageobjects;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.edepoze.utilitifiles.Screenshots;
/**
 * @author Muralikrishna.Seethalam
 *
 */

// Cases Sorting
public class Member_Cases_Sorting_PageObjects {
	WebDriver driver;
	static String sort;
	public Member_Cases_Sorting_PageObjects(WebDriver driver) {
		this.driver=driver;}

	By ClickOnAssert=By.xpath("(//div[@class='sortArrow up'])[1]");
	By ClickOnUpArrwo=By.xpath("(//div[@class='sortArrow'])[1]");
	By CaptureCases=By.xpath("//div[@id='casesList']//ul//li//div[@class='caseLabel']");





	public void Validationforsorting() throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnAssert).click();
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
		Screenshots.usernamescreenshot(driver, "MemberCasesSorting");
		CaseNames=driver.findElements(CaptureCases);
		String[] aftersort=new String[CaseNames.size()];
		for(int i=0; i<CaseNames.size();i++) {
			aftersort[i]=CaseNames.get(i).getText().trim();
			System.out.println(aftersort[i]);
		}
		Assert.assertEquals(BeforeAssert, aftersort);
		System.out.println("Successfully Sorted Member Cases");


	}
}