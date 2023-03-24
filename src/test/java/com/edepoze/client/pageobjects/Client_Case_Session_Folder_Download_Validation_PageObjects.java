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

// Downloading Session Folder
public class Client_Case_Session_Folder_Download_Validation_PageObjects {
	public static Logger logger;
	WebDriver driver;
	
	public Client_Case_Session_Folder_Download_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnSession=By.xpath("(//table[@class='tbl_info']//tr//td[4])[1]");
	By ClickOnFolder=By.xpath("//div[text()='MAT Non Zoom Folder']");
	By ClickOnDownload=By.xpath("(//span[text()='Download'])[1]");
	
	ReadConfigPropertiesFile Downloadpath= new ReadConfigPropertiesFile();
	
	
	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
		logger.info("Clicked on case");
	}
	public void ClickOnSession() throws Exception {
		driver.findElement(ClickOnSession).click();
		logger.info("Clicked on session");
	}
	public void ScroollDown() throws Exception {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Scrolled down");
	}
	public void ClickOnFolder() throws Exception {
		driver.findElement(ClickOnFolder).click();
		Thread.sleep(1000);
		logger.info("Clicked on folder");
		Screenshots.usernamescreenshot(driver, "CaseSessionFolderDownloadValidation");
		logger.info("Captured screenshot");
	}
	
	public void ClickOnDownload() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDownload).click();
		logger.info("Clicked on download");

	}
	public void WaitUntilDownload() throws Exception {
		Thread.sleep(60000);
		logger.info("Downloaded documents");		
	}
	
	
	 public void UnzipDownloadDocuments() throws InterruptedException {
		 Thread.sleep(2000);
		 String Filename=driver.findElement(ClickOnFolder).getText();
	        String zipFilePath = Paths.get("").toAbsolutePath().toString()+"\\"+Filename+".zip";
	       
	        File ZipfileDelete= new File(System.getProperty("user.dir")+"\\"+Filename+".zip");
	        String destDir = System.getProperty("user.dir")+"\\"+"folderunzipfiles";
	        File dir = new File(destDir);
	        if(!dir.exists()) dir.mkdirs();
	        FileInputStream fis;
	        byte[] buffer = new byte[1024];
	        try {
	            fis = new FileInputStream(zipFilePath);
	            ZipInputStream zis = new ZipInputStream(fis);
	            ZipEntry ze = zis.getNextEntry();
	            while(ze != null){
	                String fileName = ze.getName();
	                File newFile = new File(destDir + File.separator + fileName);
	                new File(newFile.getParent()).mkdirs();
	                FileOutputStream fos = new FileOutputStream(newFile);
	                int len;
	                while ((len = zis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	                }
	                fos.close();
	             
	                zis.closeEntry();
	                ze = zis.getNextEntry();
	            }
	           
	            zis.closeEntry();
	            zis.close();
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        Thread.sleep(1000);
			logger.info("Unzipped documents");
	        ZipfileDelete.delete();
	       
	    }
	
	 public void ValidatingUIAndDownloadedDocumentsAreSameOrNot() throws Exception {
		 Thread.sleep(2000);
		 String Count=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
			String numberOnly= Count.replaceAll("[^0-9]", "");
			System.out.println("UI Documents Count is: "+numberOnly);
			ArrayList<String> UIFiles=new ArrayList<String>();
			ArrayList<String> Downloadfiles=new ArrayList<String>();
			File FolderDelete = new File(System.getProperty("user.dir")+"\\"+"folderunzipfiles");
			
			try {
				
				File dir = new File(System.getProperty("user.dir")+"\\"+"folderunzipfiles");
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
				
				
				System.out.println("Downloaded Documents Count is: "+DownloadSize);
				
				
				
				
				for(int i=0; i<UIFilesize; i++) {
					
					if(UIFiles.get(i).equals(Downloadfiles.get(i))) {
						System.out.println("Successfully UI Documents format and download documents format of Case Session Folder Matched");
						continue;
						
					}
					else {
						System.out.println("Test fail"+"\n"+"Excpeted file is: "+UIFiles.get(i)+"\n"+"Actuali File Is"+Downloadfiles.get(i));
					
					}
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(1000);
			logger.info("Validated UI documents and downloaded documents");
			FileUtils.deleteDirectory(FolderDelete);
			
	
	}
}