package com.edepoze.client.pageobjects;

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
	}

	public void ClickOnAddNewcase() {
		driver.findElement(ClickOnAddNewcase).click();
	}
	public void EnterCaseName() throws Exception {
		String Casename=faker.name().firstName();
		driver.findElement(CaseName).sendKeys("MAT"+Casename);	
	}
	public void EnterCaseName2() throws Exception {
		driver.findElement(CaseName).sendKeys("MATZ Move Case");	
	}
	public void CaseNumber() {
		String Casenumber=faker.phoneNumber().subscriberNumber(1);
		driver.findElement(CaseNumber).sendKeys(Casenumber);
	}
	public void searchAssignCaseManagers() throws Exception {
		Thread.sleep(2000);
		driver.findElement(AssignCaseManagers).sendKeys(OutputData.RegisterEmailId());
	}
	public void RemoveAssignCaseManager() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@data-fullid=\"mainform.users\"]"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Remove']")).click();
	}

	public void SelectAssignCaseManagers() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(SelectAssignCaseManagers).click();
	}
	public void EnterclientFirstName() throws Exception {
		String Clinetfirstname=faker.name().firstName();
		driver.findElement(clientFirstName).sendKeys(Clinetfirstname);
	}
	public void EnterclientLastName() throws Exception {
		String Clinetlastname=faker.name().lastName();
		driver.findElement(clientLastName).sendKeys(Clinetlastname);
	}
	public void EnterclientPhoneby() throws Exception {
		String ClinetPhonenumber=faker.phoneNumber().subscriberNumber(10);
		driver.findElement(clientPhoneby).sendKeys(ClinetPhonenumber);
	}
	public void EnterclientEmail() throws Exception {
		String Email=faker.name().firstName();
		driver.findElement(clientEmail).sendKeys(Email+"@gmail.com");
	}
	public void EnterclientAddress2() throws Exception {
		Thread.sleep(2000);
		String Address=faker.address().cityName();
		Screenshots.usernamescreenshot(driver, "ClientAddNewCase");
		driver.findElement(clientAddress2).sendKeys(Address);
	}
	public void ScrollDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void ScrollUp() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)");
	}

	public void ClickOnSave() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(ClickOnSave).click();
	}
	
	public void CaptureScreenshot() throws Exception {
		
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "ClientAdd_NewCase");
		}
	
	public void CheckTheCaseCreatedOrNot() throws InterruptedException {
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[text()=' Add New Case']")).isDisplayed())
		{
			System.out.println("Successfully New Case Added");
			Screenshots.usernamescreenshot(driver, "ClientAddNewCase");

		}

		else {
			System.out.println("Failed To Create Add New Case");
			Screenshots.usernamescreenshot(driver, "ClientAddNewCase");
		}
		Thread.sleep(2000);
	}




}
