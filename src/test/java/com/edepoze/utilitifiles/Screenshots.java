package com.edepoze.utilitifiles;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
    public static String usernamescreenshot(WebDriver driver, String screenshotname) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Create a folder with today's date
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
            Date currentDate = new Date();
            String folderName = dateFormat.format(currentDate);
            File folder = new File("./Screenshots/" + folderName);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Save the screenshot under the folder with the provided name
            File screenshot = new File(folder, screenshotname + ".png");
            FileUtils.copyFile(source, screenshot);
            return screenshot.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
