package com.edepoze.utilitifiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;


public class BaseClass {
	public static WebDriver driver;
	WebDriver Incognitodriver;
	WebDriver Firefoxdriver;
//	public static Logger logger;
	
	private static final Logger logger = Logger.getLogger(BaseClass.class);
	SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
    Date currentDate = new Date();
    String logDir = dateFormat.format(currentDate);
   
	@BeforeMethod
//	LaunchingThe Respective Browser
	public void Browserlaunch() throws Exception {
		 File folder = new File("./Logs");
		
		ReadConfigPropertiesFile readconfig = new ReadConfigPropertiesFile();
		String Environment = readconfig.BrowserName();
		
		 System.setProperty("log.dir", folder+"//"+logDir);
		
//		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Borwser launched");

		if (Environment.contentEquals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", System.getProperty("user.dir"));
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get("https://" + readconfig.Environment() + ".edepoze.com/");
		}
		else if (Environment.contentEquals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "./Browsers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("browser.download.dir", System.getProperty("user.dir"));
			fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/zip");
			fp.setPreference("browser.download.folderList", 2);
			fp.setPreference("browser.download.manager.showWhenStarting", false);
			options.setProfile(fp);

			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://" + readconfig.Environment() + ".edepoze.com/");
		} else if (Environment.contentEquals("edgedriver")) {
			WebDriverManager.edgedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();  
			prefs.put("download.default_directory", System.getProperty("user.dir"));    
			EdgeOptions option=new EdgeOptions();
			option.setExperimentalOption("prefs", prefs);    

			driver=new EdgeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://" + readconfig.Environment() + ".edepoze.com/");	
		} else if (Environment.contentEquals("safari")) {
			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://" + readconfig.Environment() + ".edepoze.com/");
		}
	}
	
	
//	@AfterMethod
//	public void quit(){
//
//		driver.quit();
//	logger.info("Borwser closed");
//	}
	@AfterMethod
	public void FaildScreenshotCapture1(ITestResult tr){
		if(ITestResult.FAILURE==tr.getStatus()) {
			String timeStamp = new SimpleDateFormat(" yyyy.MM.dd.HH.mm.ss").format(new Date());
			FailScreenShotsCapture.usernamescreenshot(driver, tr.getName()+timeStamp);
		}
		

	}
	
}