package com.edepoze.client.pageobjects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Case Session Multiple Documents Download Validation
public class Case_Session_Multiple_Documnets_Download_Validation_PageObjects {
	
	public static Logger logger;
	
	WebDriver driver;
	
	public Case_Session_Multiple_Documnets_Download_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By ClickOnSelectAll=By.xpath("//a[@id='checkAllFiles']");
	By ClickOnDownload=By.xpath("(//span[text()='Download'])[2]");
	By DocumentName=By.xpath("//table[@class='view_details_table']//tr//td[1]");
	
	
	ReadConfigPropertiesFile Downloadpath= new ReadConfigPropertiesFile();
	
	
	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked Add New Case button");
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked Add Session button");
	}
	public void ScroollDown() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
		logger.info("Clicked on folder");
	}
	public void ClickOnSelectAll() throws Exception {
		driver.findElement(ClickOnSelectAll).click();
		logger.info("Clicked on selectall");
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "CaseSessionMultipleDocumentsDownloadValidation");
		logger.info("Screenshot captured");
	}
	public void ClickOnDownload() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDownload).click();
		logger.info("Clicked on Download button");
	}
	public void WaitUntilDownload() throws Exception {
		Thread.sleep(60000);
		logger.info("Documents downloaded");
	}
	
	
	 public void UnzipDownloadDocuments() throws InterruptedException {
		 String Filename=driver.findElement(DocumentName).getText();
	        String zipFilePath = Paths.get("").toAbsolutePath().toString()+"//"+Filename+".zip";
	        File filelocation=new File(System.getProperty("user.dir")+"//"+Filename+".zip");
	       
	       
	        String destDir = System.getProperty("user.dir")+"//"+"unzipfiles";
	        File dir = new File(destDir);
	        // create output directory if it doesn't exist
	        if(!dir.exists()) dir.mkdirs();
	        FileInputStream fis;
	        //buffer for read and write data to file
	        byte[] buffer = new byte[1024];
	        try {
	            fis = new FileInputStream(zipFilePath);
	            ZipInputStream zis = new ZipInputStream(fis);
	            ZipEntry ze = zis.getNextEntry();
	            while(ze != null){
	                String fileName = ze.getName();
	                File newFile = new File(destDir + File.separator + fileName);
	                //create directories for sub directories in zip
	                new File(newFile.getParent()).mkdirs();
	                FileOutputStream fos = new FileOutputStream(newFile);
	                int len;
	                while ((len = zis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	                }
	                fos.close();
	                //close this ZipEntry
	                zis.closeEntry();
	                ze = zis.getNextEntry();
	            }
	            //close last ZipEntry
	            zis.closeEntry();
	            zis.close();
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        logger.info("Unzipped downloaded documents");
	        Thread.sleep(1000);
	        filelocation.delete();
	    }
	
	 public void ValidatingUIAndDownloadedDocumentsAreSameOrNot() throws Exception {
		 Thread.sleep(2000);
		 String Count=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
			String numberOnly= Count.replaceAll("[^0-9]", "");
			System.out.println("UI Documents count is: "+numberOnly);
			ArrayList<String> UIFiles=new ArrayList<String>();
			ArrayList<String> Downloadfiles=new ArrayList<String>();
			File UnzipfolderDelete = new File(System.getProperty("user.dir")+"//"+"unzipfiles");
			
			try {
				
				File dir = new File(System.getProperty("user.dir")+"//"+"unzipfiles");
				for (File file : dir.listFiles()) {
					String FileNames=file.getName();
					Downloadfiles.add(FileNames);
					
				}
				
				
				List<WebElement> ls=driver.findElements(By.xpath("//table[@class='file_list innerTable']//tr//td[2]"));
				for (WebElement ele : ls) {
					String OptionName=ele.getText();
					UIFiles.add(OptionName);
				}
				int UIFilesize=UIFiles.size();
				int DownloadSize=Downloadfiles.size();
				
				
				System.out.println("Downloaded Documents count is: "+DownloadSize);
				
				
				
				
				for(int i=0; i<UIFilesize; i++) {
					
					if(UIFiles.get(i).equals(Downloadfiles.get(i))) {
						System.out.println("Succesfuly UI Documents format and Download Documents format of Case Session matched");
						continue;
						
					}
					else {
						System.out.println("Test fail"+"\n"+"Excpeted file is: "+UIFiles.get(i)+"\n"+"Actuali File Is"+Downloadfiles.get(i));
					
					}
					logger.info("Validated UI and downloaded documents");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(1000);
			FileUtils.deleteDirectory(UnzipfolderDelete);
			
			
			
	
	}
}