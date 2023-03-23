package com.edepoze.reseller.pageobjects;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;
import com.github.javafaker.Faker;


//Adding Reseller Client 
public class Reseller_AddClient_PageObjects {

	OutputData getdata=new OutputData();

	WebDriver driver;
	By AddClient = By.xpath("//span[text()='Add Client']");
	By ClientName = By.name("name");
	By contactName = By.name("contactName");
	By contactEmail = By.name("contactEmail");
	By contactPhone = By.name("contactPhone");
	By countrycode=By.name("state");
	By address1 = By.name("address1");
	By city = By.name("city");
	By ZIP = By.name("ZIP");
	By Next = By.xpath("(//span[text()='Next'])[1]");
	By firstName = By.name("firstName");
	By lastName = By.name("lastName");
	By Email = By.name("email");
	By username = By.name("username");
	By password = By.name("password");
	By confirmPassword = By.name("confirmPassword");
	By Save = By.xpath("(//span[text()='Save'])[1]");
	By searchText =By.name("searchText");
	By Go =By.name("go");
	By Visible=By.xpath("(//div[text()='sdmr1a12'])[1]");
	By classnaem=By.className("active");

	Faker faker=new Faker();
	OutputData obj=new OutputData();
	Random RandomData=new Random();

	ReadConfigPropertiesFile readconfig=new ReadConfigPropertiesFile();

	public  Reseller_AddClient_PageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void getdata() throws Exception {
		driver.findElement(AddClient).click();

	}	
	public void ClickOnAddClient() throws Exception {
		driver.findElement(AddClient).click();
	}
	public void EnterClientName() throws Exception {
		String CName=faker.name().firstName();
		driver.findElement(ClientName).sendKeys("MAT"+CName);
		Thread.sleep(1000);
		String GetClientName = driver.findElement(ClientName).getAttribute("value");
		obj.WriteExcel("Sheet1", GetClientName, 3, 1);
	}
	public void EnterContactName() throws Exception {
		String CName1=faker.name().nameWithMiddle();
		driver.findElement(contactName).sendKeys("MAT"+CName1);
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
		WebElement coutry1 = driver.findElement(countrycode);
		Thread.sleep(2000);
		Select select1 =new Select(coutry1);
		select1.selectByVisibleText("AK");
	}
	public void EnterZip() throws Exception {
		String ZipNumber=faker.address().zipCode();
		driver.findElement(ZIP).sendKeys(ZipNumber);
	}
	public void ClickOnNext() throws Exception {
		driver.findElement(Next).click();
	}
	public void BasicInformationValidation() throws Exception {
		//	 boolean Zip =driver.findElement(ZIP).isDisplayed();
		Thread.sleep(3000);
		if(driver.findElement(ZIP).isDisplayed()) {
			System.out.println("Failed At Basic Information To Create Client Account");
			Screenshots.usernamescreenshot(driver, "AddClient");

		}
		else {
			System.out.println("Success At Basic Information To Create Client Account");
			Screenshots.usernamescreenshot(driver, "AddClient");


		}

		//		boolean content=driver.getPageSource().contains("Address*");
		//				
		//				if(content==true) {
		//					System.out.println("Failed At Admin Setup To Create Client Account");
		//					shots.usernamescreenshot(driver, "Failed At Basic Information To Create Client Account");
		//					
		//				}
		//				else {
		//					System.out.println("Success At Basic Information To Create Client Account");
		//					shots.usernamescreenshot(driver, "Success At Basic Information To Create Client Account");
		//					
		//					
		//				}

	}

	public void EnterFirstName() throws Exception {
		String firstname=faker.name().firstName();
		driver.findElement(firstName).sendKeys(firstname);
	}
	public void EnterLastName() throws Exception {
		String lastname=faker.name().lastName();
		driver.findElement(lastName).sendKeys(lastname);
	}
	public void Enteremail() throws Exception {
		driver.findElement(Email).sendKeys(readconfig.AddClientEmail());
		Thread.sleep(2000);
		String Getemail=driver.findElement(Email).getAttribute("value");
		obj.WriteExcel("Sheet1", Getemail, 4, 1);

	}
	public void RandamUsername() {
		Random Username=new Random();
		String strinusername="sb"+ Username.nextInt();
		driver.findElement(username).sendKeys(strinusername);

		//		String username=Random()+"sd";

	}

	public void EnterUsername() throws Exception {
		String Username=faker.name().username();
		driver.findElement(username).sendKeys("MAT"+Username);
		Thread.sleep(2000);
		String GetuserName=driver.findElement(username).getAttribute("value");
		obj.WriteExcel("Sheet1", GetuserName, 1, 1);
	}
	public void Getusername() throws Exception {
		driver.findElement(username).getText();

	}
	public void EnterPassword() throws Exception {
		driver.findElement(password).sendKeys("abc.123!");
		String GetPassword="abc.123!";
		obj.WriteExcel("Sheet1", GetPassword, 2, 1);
	}
	public void EnterConfirmPassword() throws Exception {
		driver.findElement(confirmPassword).sendKeys("abc.123!");
//		String GetPassword="abc.123!";
	}
	public void ClickOnSave() throws Exception {
		driver.findElement(Save).click();
	}
	public void AdminSetupValidation() throws Exception {

		//		driver.findElement(By.className("active"));

		if(driver.findElement(classnaem).isDisplayed()) {
			System.out.println("Success At Admin Setup To Create Client Account");
			Screenshots.usernamescreenshot(driver, "AddClient");

		}
		else {
			System.out.println("Failed At Admin Setup To Create Client Account");
			Screenshots.usernamescreenshot(driver, "AddClient");


		}


	}

	public void EnterClientID() throws Exception {
		driver.findElement(searchText).sendKeys(OutputData.ClientName());
		Thread.sleep(3000);
	}
	public void ClikOnSearch() throws InterruptedException {
		driver.findElement(Go).click();
		Thread.sleep(3000);
		Screenshots.usernamescreenshot(driver, "AddClient");
	}
	//	public void ValidationForClientCreatedorNot() {
	//		if(driver.findElement(Visible).isDisplayed()) {
	//			System.out.println("Client Account Created Successfully");
	//			shots.usernamescreenshot(driver, "Client Account Created Successfully");
	//		}
	//		else {
	//			System.out.println("Failed: Client Account Not Created Successfully");
	//			shots.usernamescreenshot(driver, "Failed: Client Account Not Created Successfully");
	//			
	//		}
	//		
	//	}
	public void ValidationForClientCreatedorNot() throws InterruptedException {
		int SearchCount=driver.findElements(By.xpath("//table[@class='tbl_info']/tbody/tr/td[3]")).size();
		int EqualCount= 1;

		Assert.assertEquals(SearchCount, EqualCount, "Client Account Created Successfully");
		System.out.println("Successfully Created Client Account");
	}


}


