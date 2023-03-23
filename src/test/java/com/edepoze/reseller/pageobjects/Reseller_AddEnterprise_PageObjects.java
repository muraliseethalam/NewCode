/**
 * 
 */
package com.edepoze.reseller.pageobjects;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;
import com.github.javafaker.Faker;

/**
 * @author MuraliKrishna
 * 
 * Page Objects For Reseller Add Enterprise 
 *
 */

//Adding Reseller Enterprise Client
public class Reseller_AddEnterprise_PageObjects {

	WebDriver driver;
	By AddClient = By.xpath("//span[text()='Add Enterprise']");
	By ClientName = By.name("name");
	By contactName = By.name("contactName");
	By contactEmail = By.name("contactEmail");
	By contactPhone = By.name("contactPhone");
	By address1 = By.name("address1");
	By city = By.name("city");
	By ZIP = By.name("ZIP");
	By URL=By.name("URL");
	By Changetextcolor=By.xpath("//span[text()='Change text color']");
	By ClickTextcolor=By.xpath("(//div[@rgbcolor='#FF0000'])[1]");
	By ChangeBanarColor=By.xpath("//span[text()='Change banner color']");
	By ClickBanarColor=By.xpath("(//div[@rgbcolor='#FF0033'])[1]");
	By ClickOnNext=By.className("btn_blue_r");

	By firstName=By.name("firstName");
	By lastName=By.name("lastName");
	By email=By.name("email");
	By username=By.name("username");
	By password=By.name("password");
	By confirmPassword=By.name("confirmPassword");
	By Save=By.xpath("(//span[text()='Save'])[1]");
	By classname=By.className("active");
	By searchText =By.name("searchText");
	By Go =By.name("go");
	By Visible=By.xpath("//div[text()='Enterprise']");

	Faker faker=new Faker();
	OutputData obj=new OutputData();
	Random RandomData=new Random();

	ReadConfigPropertiesFile readconfig=new ReadConfigPropertiesFile();

	public  Reseller_AddEnterprise_PageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void ClickOnAddEnterprise() throws Exception {
		driver.findElement(AddClient).click();
	}
	public void EnterClientName() throws Exception {
		String CName=faker.name().firstName();
		driver.findElement(ClientName).sendKeys("MAT"+CName);
		Thread.sleep(1000);
		String GetClientName = driver.findElement(ClientName).getAttribute("value");
		obj.WriteExcel("Sheet1", GetClientName, 8, 1);

	}
	public void EnterContactName() throws Exception {
		String CName1=faker.name().nameWithMiddle();
		driver.findElement(contactName).sendKeys(CName1);
	}
	public void ScroollDown() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public void EnterEmail() throws Exception {
		String Email=RandomData.nextInt()+"@gmail.com";
		driver.findElement(contactEmail).sendKeys(Email);
	}
	public void EnterContactPhone() throws Exception {
		String ContactPhone=faker.number().digits(10);
		driver.findElement(contactPhone).sendKeys(ContactPhone);
	}
	public void SelectCountryCode() throws Exception {
		WebElement coutry = driver.findElement(By.name("countryCode"));
		Thread.sleep(2000);
		Select select =new Select(coutry);
		select.selectByVisibleText("United States");
		Thread.sleep(2000);
	}
	public void Enteraddress() throws Exception {
		String Address=faker.address().state();
		driver.findElement(address1).sendKeys(Address);
	}
	public void Entercity() throws Exception {
		String CityName=faker.address().cityName();
		driver.findElement(city).sendKeys(CityName);
	}
	public void SelectState() throws Exception {
		WebElement coutry1 = driver.findElement(By.name("state"));
		Thread.sleep(2000);
		Select select1 =new Select(coutry1);
		select1.selectByVisibleText("AK");
	}
	public void EnterZip() throws Exception {
		String ZipNumber=faker.address().zipCode();
		driver.findElement(ZIP).sendKeys(ZipNumber);
	}
	public void EnterURL() throws Exception {
		String URl=driver.findElement(ClientName).getAttribute("value");
		driver.findElement(URL).sendKeys(URl);
	}

	public void Changetextcolor() throws Exception {
		driver.findElement(Changetextcolor).click();
		Thread.sleep(2000);
		driver.findElement(ClickTextcolor).click();	
	}
	public void ChangeBanarColor() throws Exception {
		driver.findElement(ChangeBanarColor).click();
		Thread.sleep(2000);
		driver.findElement(ClickBanarColor).click();

	}
	public void ClickOnNext() throws Exception {
		driver.findElement(ClickOnNext).click();
	}

	public void EnterFirstName() throws Exception {
		String firstname=faker.name().firstName();
		driver.findElement(firstName).sendKeys(firstname);
	}
	public void EnterLastName() throws Exception {
		String lastname=faker.name().lastName();
		driver.findElement(lastName).sendKeys(lastname);
	}
	public void EnterEmail1() throws Exception {
		driver.findElement(email).sendKeys(readconfig.AddEnterpriseEmail());

	}
	public void EnterUsername() throws Exception {

		String Username=faker.name().username();
		driver.findElement(username).sendKeys("MAT"+Username);
		Thread.sleep(2000);
		String GetuserName=driver.findElement(username).getAttribute("value");
		obj.WriteExcel("Sheet1", GetuserName, 6, 1);
	}
	
	public void EnterPassword() throws Exception {
		Thread.sleep(5000);
		driver.findElement(password).sendKeys("abc.123!");
		String GetPassword="abc.123!";
		obj.WriteExcel("Sheet1", GetPassword, 7, 1);
	}
	
	public void EnterConfirPassword() throws Exception {
		driver.findElement(confirmPassword).sendKeys("abc.123!");
	}
	public void ClickOnSave() throws Exception {
		driver.findElement(Save).click();
		Thread.sleep(5000);
	}
	public void RandamUserName() {
		Random Username=new Random();
		String strinusername="sa"+ Username.nextInt();
		driver.findElement(username).sendKeys(strinusername);

		//		String username=Random()+"sd";

	}
	public void BasicInformationValidaiton() throws Exception {

		if(driver.findElement(ZIP).isDisplayed()) {
			System.out.println("Failed at Basic Information page while creating a Enterprise Account");
			Screenshots.usernamescreenshot(driver, "AddEnterpriseClient");
		}
		else {
			System.out.println("Success at Basic Information page while creating a Enterprise Account");

		}
	}
	public void AdminSetupValidation() throws Exception {

		if(driver.findElement(classname).isDisplayed()) {
			System.out.println("Enterprise Account Created Successfully");
		}
		else {
			System.out.println("Failed at creating Enterprise Account");
			Screenshots.usernamescreenshot(driver, "AddEnterpriseClient");

		}
	}
	public void EnterClientID() throws Exception {
		driver.findElement(searchText).sendKeys(OutputData.EnterpriseName());

		Thread.sleep(3000);
	}
	public void ClikOnSearch() throws InterruptedException {
		driver.findElement(Go).click();
		Thread.sleep(3000);
		Screenshots.usernamescreenshot(driver, "AddEnterpriseClient");
	}



	public void ValidationForClientCreatedorNot() throws Exception {
		
		if(driver.findElement(By.xpath("//div[text()='"+OutputData.EnterpriseName()+"']")).isDisplayed()) {
			System.out.println("Enterprise Account Created Successfully");
		}
		else {
			System.out.println("Failed: Enterprise Account Not Created Successfully");
		}
			
	}



}
