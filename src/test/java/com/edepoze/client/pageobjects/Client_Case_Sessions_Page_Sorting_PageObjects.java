package com.edepoze.client.pageobjects;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.edepoze.utilitifiles.Screenshots;

public class Client_Case_Sessions_Page_Sorting_PageObjects {
	
	WebDriver driver;
	static String sort;
	By ClickOnCase=By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSort=By.xpath("//span[@class='sort']");
	By ClickOnNames=By.xpath("//table[@class='tbl_info']/tbody/tr/td[4]");
	By ClickOnSortUp=By.xpath("//span[@class='sort top']");
	
	public  Client_Case_Sessions_Page_Sorting_PageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void ClientCaseSessionsPageSorting() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(ClickOnCase).click();
		
		driver.findElement(ClickOnSort).click();
		Screenshots.usernamescreenshot(driver, "ClienCaseSessionsPageSorting");
		Thread.sleep(3000);
		List<WebElement> clname=driver.findElements(ClickOnNames);
		String[] beforesort=new String[clname.size()];
		System.out.println("----------BeforeSorting------------");
		for(int i=0; i<clname.size();i++) {
			beforesort[i]=clname.get(i).getText().trim();
			System.out.println(beforesort[i]);
		}
		System.out.println("-------------Assert----------------");
		for(int i=0; i<clname.size();i++) {
			Arrays.sort(beforesort);
			sort=	beforesort[i];
			System.out.println(sort);
		}
		System.out.println("----------AfterSorting-------------");
		Thread.sleep(3000);
		driver.findElement(ClickOnSortUp).click();
		Screenshots.usernamescreenshot(driver, "ClienCaseSessionsPageSorting");
		Thread.sleep(2000);
		clname=driver.findElements(ClickOnNames);
		String[] aftersort=new String[clname.size()];
		for(int i=0; i<clname.size();i++) {
			aftersort[i]=clname.get(i).getText().trim();
			System.out.println(aftersort[i]);
		}
		Assert.assertEquals(beforesort, aftersort);
		System.out.println("Successfully Sorted Client Case Sessions Page ");
	}
}