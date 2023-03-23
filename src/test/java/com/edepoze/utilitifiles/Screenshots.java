package com.edepoze.utilitifiles;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


//Capturing ScreenShots For Success and Failure Test Cases
public class Screenshots {
	public static String usernamescreenshot(WebDriver driver,String screenshotname) throws WebDriverException {

		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source= ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotname+".png"));
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotname;
	}

}
