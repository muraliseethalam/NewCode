package com.edepoze.client.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.Screenshots;
import com.github.javafaker.Faker;

/**
 * @author MuraliSeethalam
 */

// Client Add New Case
public class Client_Add_New_Case_PageObjects{
	
	public static Logger logger;

	WebDriver driver;

	By ClickOnAddNewcase=By.xpath("//span[text()=' Add New Case']");	
	By CaseName=By.name("name");
	By CaseNumber=By.name("number");
	By AssignCaseManagers=By.name("userSearch");
	By SelectAssignCaseManagers=By.xpath("//div[@class='add_btn']");
	By clientFirstName=By.name("clientFirstName");
	By clientLastName=By.name("clientLastName");
	By clientPhoneby=By.name("clientPhone");
	By clientEmail=By.name("clientEmail");
	By clientAddress2=By.name("clientAddress2");
	By ClickOnSave=By.className("btn_blue_r");


	Faker faker=new Faker();


	public Client_Add_New_Case_PageObjects(WebDriver driver) {
		this.driver = driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}

	public void ClickOnAddNewcase() {
		driver.findElement(ClickOnAddNewcase).click();
		logger.info("Clicked Add New Case button");
	}
	public void EnterCaseName() throws Exception {
		String Casename=faker.name().firstName();
		driver.findElement(CaseName).sendKeys("MAT"+Casename);	
		logger.info("Entered case name");
	}
	public void EnterCaseName2() throws Exception {
		driver.findElement(CaseName).sendKeys("MATZ Move Case");	
		logger.info("Entered case name");
	}
	public void CaseNumber() {
		String Casenumber=faker.phoneNumber().subscriberNumber(1);
		driver.findElement(CaseNumber).sendKeys(Casenumber);
		logger.info("Entered case number");

	}
	public void searchAssignCaseManagers() throws Exception {
		Thread.sleep(2000);
		driver.findElement(AssignCaseManagers).sendKeys(OutputData.RegisterEmailId());
		logger.info("Searched assign case manager");

	}
	public void RemoveAssignCaseManager() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@data-fullid=\"mainform.users\"]"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Remove']")).click();
		logger.info("Removed assign case manager");

	}

	public void SelectAssignCaseManagers() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(SelectAssignCaseManagers).click();
		logger.info("Selected assign case manager");

	}
	public void EnterclientFirstName() throws Exception {
		String Clinetfirstname=faker.name().firstName();
		driver.findElement(clientFirstName).sendKeys(Clinetfirstname);
		logger.info("Entered client first name");

	}
	public void EnterclientLastName() throws Exception {
		String Clinetlastname=faker.name().lastName();
		driver.findElement(clientLastName).sendKeys(Clinetlastname);
		logger.info("Entered client last name");

	}
	public void EnterclientPhoneby() throws Exception {
		String ClinetPhonenumber=faker.phoneNumber().subscriberNumber(10);
		driver.findElement(clientPhoneby).sendKeys(ClinetPhonenumber);
		logger.info("Entered client first number");

	}
	public void EnterclientEmail() throws Exception {
		String Email=faker.name().firstName();
		driver.findElement(clientEmail).sendKeys(Email+"@gmail.com");
		logger.info("Entered client Email ID");

	}
	public void EnterclientAddress2() throws Exception {
		Thread.sleep(2000);
		String Address=faker.address().cityName();
		Screenshots.usernamescreenshot(driver, "ClientAddNewCase");
		driver.findElement(clientAddress2).sendKeys(Address);
		logger.info("Entered client address");

	}
	public void ScrollDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}

	public void ScrollUp() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)");
		logger.info("Scrolled up");
	}

	public void ClickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnSave).click();
		logger.info("Clicked on save");
	}
	
	public void CaptureScreenshot() throws Exception {
		
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "ClientAdd_NewCase");
		logger.info("Captured screenshot");
		}
	
	public void CheckTheCaseCreatedOrNot() throws InterruptedException {
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[text()=' Add New Case']")).isDisplayed())
		{
			System.out.println("Successfully New Case Added");
			Screenshots.usernamescreenshot(driver, "ClientAddNewCase");
			logger.info("Captured screenshot");

		}

		else {
			System.out.println("Failed To Create Add New Case");
			Screenshots.usernamescreenshot(driver, "ClientAddNewCase");
			logger.info("Captured screenshot");
		}
		Thread.sleep(2000);
		logger.info("Added new case");
	}




}
