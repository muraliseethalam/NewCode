package com.edepoze.client.pageobjects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;

// Downloading Multiple Documents Of Case Folder
public class Client_Case_Folder_Multiple_Document_Downalod_Validation_PageOjects {
	
	WebDriver driver;
	public Client_Case_Folder_Multiple_Document_Downalod_Validation_PageOjects(WebDriver driver) {
		this.driver=driver;
	}
	
	By ClickOnCase =By.xpath("(//table[@class='tbl_info']//tr//td[3])[1]");
	By ClickOnCaseFolder=By.xpath("//div[@class='icon']");
	By ClickOnDeleteFolder=By.xpath("//div[text()='DeleteFolder']");
	By ClickOnSelectAll=By.xpath("//a[@id='checkAllFiles']");
	By ClickOnDownload=By.xpath("(//span[text()='Download'])[2]");
	
	ReadConfigPropertiesFile Downloadpath= new ReadConfigPropertiesFile();
	
	
	public void ClickOnCase() throws Exception {
		driver.findElement(ClickOnCase).click();
	}
	public void ClickOnCaseFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnCaseFolder).click();
	}
	public void ClickOnDeleteFolder() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDeleteFolder).click();
	}
	public void ClickOnSelectAll() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnSelectAll).click();
	}
	public void ClickOnDownload() throws Exception {
		Thread.sleep(1000);
		driver.findElement(ClickOnDownload).click();
		Thread.sleep(1000);
		Screenshots.usernamescreenshot(driver, "CaseFolderMultipleDocumentDownloadValidation");
	}
	public void WaitUntilDownload() throws Exception {
		Thread.sleep(60000);
		
	}
	
	
	public void ScrollDown() throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void UnzipDownloadDocuments() throws InterruptedException {
		String DisplayedCount=driver.findElement(By.xpath("//div[@class='breadcrumb']")).getText().split(" ")[3];
		 String Filename=DisplayedCount+"-DeleteFolder";
		
	        String zipFilePath = System.getProperty("user.dir")+"\\"+Filename+".zip";
	       File DeleteZipfile=new File(zipFilePath);
	       
	        String destDir = System.getProperty("user.dir")+"\\"+"CaseFoldrUnzipfiles";
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
	        DeleteZipfile.delete();
	      
	    }
	
	 public void ValidatingUIAndDownloadedDocumentsAreSameOrNot() throws Exception {
		 Thread.sleep(2000);
		 String Count=driver.findElement(By.xpath("(//div[@class='sessionView_table_header'])[2]")).getText().split(" ")[1];
			String numberOnly= Count.replaceAll("[^0-9]", "");
			System.out.println("UI Documents count is: "+numberOnly);
			ArrayList<String> UIFiles=new ArrayList<String>();
			ArrayList<String> Downloadfiles=new ArrayList<String>();
			File UnzipFolderDelete = new File(System.getProperty("user.dir")+"\\"+"CaseFoldrUnzipfiles");
//			System.out.println(UnzipFolderDelete);
			UnzipFolderDelete.delete();
			UnzipFolderDelete.deleteOnExit();
			
			try {
				
				File dir = new File(System.getProperty("user.dir")+"\\"+"CaseFoldrUnzipfiles");
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
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(2000);
			FileUtils.deleteDirectory(UnzipFolderDelete);
			
	
	}
}