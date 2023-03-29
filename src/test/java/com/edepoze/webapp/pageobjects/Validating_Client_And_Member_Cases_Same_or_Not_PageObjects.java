/**
 * 
 */
package com.edepoze.webapp.pageobjects;


/**
 * @author Muralikrishna.Seethalam
 *
 */


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.edepoze.utilitifiles.Screenshots;

// Validating Client Cases And Member Cases

public class Validating_Client_And_Member_Cases_Same_or_Not_PageObjects {
	public static Logger logger;
	WebDriver driver;

	By ClientCases=By.xpath("//div[@class='scrollTable']//table//tr//td[3]");
	By MemberCases=By.xpath("//div[@id='casesList']//ul//li//div[@class='caseLabel']");

	public Validating_Client_And_Member_Cases_Same_or_Not_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}

	ArrayList<String> ClientCase=new ArrayList<String>();
	ArrayList<String>MemberCase=new ArrayList<String>();

	public void CapturingClientCases() {
		List<WebElement> ListOfClientCases=driver.findElements(ClientCases);
		for (WebElement WebElement : ListOfClientCases) {
			String ClientCasesNames=WebElement.getText();
			ClientCase.add(ClientCasesNames);	
			logger.info("Captured client cases");
		}
	}

	public void CapturingMemberCases() {
		driver.switchTo().frame(0);
		List<WebElement> LidtOfMemberCases=driver.findElements(MemberCases);
		for (WebElement WebElement : LidtOfMemberCases) {
			String MemberCaseNames=WebElement.getText();
			MemberCase.add(MemberCaseNames);	
			logger.info("Captured member cases");
			Screenshots.usernamescreenshot(driver, "ValidatingClientAndMemberCasesSameOrNot");
			logger.info("Captured screenshot");
		}	
	}
	public void ValidatingClientAndMemberCasesSameOrNot() {
		int ClientCasesCount=ClientCase.size();
		System.out.println("Client Cases Count Is: "+ClientCasesCount);

		int MemberCaseCount=MemberCase.size();
		System.out.println("Member Cases Count Is: "+MemberCaseCount);

		for(int i=0; i<ClientCasesCount; i++) {

			if(ClientCase.get(i).equals(MemberCase.get(i))) {
				System.out.println("Successfully Client Cases And Member Cases Are Matching");
			}
			else {
				System.out.println("Test Fail"+"\n"+"Excpeted Case is: "+ClientCase.get(i)+"\n"+"Actual Case Is: "+MemberCase.get(i));
			}
			logger.info("Validated client cases and member cases");
		}

	}


}



