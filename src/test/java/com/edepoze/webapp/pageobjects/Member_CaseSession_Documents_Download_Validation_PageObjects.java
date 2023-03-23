package com.edepoze.webapp.pageobjects;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;
import com.edepoze.utilitifiles.Screenshots;
/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Documents Download Validation
public class Member_CaseSession_Documents_Download_Validation_PageObjects {

	WebDriver driver;

	public Member_CaseSession_Documents_Download_Validation_PageObjects(WebDriver driver) {

		this.driver=driver;

	}

	By ClickOnMemberSession=By.xpath("//div[text()='MAT AFolder Validation Session']");
	By ClickOnMemberFolder=By.xpath("//p[text()='MAT Non Zoom Folder']");
	By ClickOnDownload=By.xpath("//div[@class='downloadBtn']");
	By DocumentName=By.xpath("//p[@class='deposition_name']");

	ArrayList<String> UIFiles=new ArrayList<String>();
	ArrayList<String> Downloadfiles=new ArrayList<String>();

	ReadConfigPropertiesFile Downloadpath= new ReadConfigPropertiesFile();


	public void ClickOnMemberSession() {
		driver.switchTo().frame(0);
		driver.findElement(ClickOnMemberSession).click();
	}

	public void ClickOnMemberFolder() {
		driver.findElement(ClickOnMemberFolder).click();
		Screenshots.usernamescreenshot(driver, "MemberCaseSessionDocumentsDownloadValidation");
	}


	public void MemberCaseSessionDocumentsCapture() {

		List<WebElement> ds=driver.findElements(By.xpath("//div[@id='filesList']//li//div//p[@class='fileName']"));
		for (WebElement ele : ds) {
			String OptionName=ele.getText();
			UIFiles.add(OptionName);
		}	
	}	

	public void ClickOnDownload() {

		driver.findElement(ClickOnDownload).click();

	}

	public void WaitUntilDownload() throws Exception {
		Thread.sleep(60000);

	}

	public void UnzipDownloadDocuments() throws InterruptedException, IOException {
		String Filename="MAT Non Zoom Folder";
		String zipFilePath = Paths.get("").toAbsolutePath().toString()+"//"+Filename+".zip";
		File filelocation=new File(System.getProperty("user.dir")+"//"+Filename+".zip");


		String destDir = System.getProperty("user.dir")+"//"+"unzipfiles";
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
		filelocation.delete();
	}



	public void ValidatingUIAndDownloadedDocuments() throws Exception {

		Thread.sleep(2000);
		String Count=driver.findElement(By.xpath("(//div[@class='legend'])[2]")).getText().split(" ")[1];
		String numberOnly= Count.replaceAll("[^0-9]", "");
		System.out.println("UI Documents count is: "+numberOnly);
		File UnzipfolderDelete = new File(System.getProperty("user.dir")+"//"+"unzipfiles");

		try {

			File dir = new File(System.getProperty("user.dir")+"//"+"unzipfiles");
			for (File file : dir.listFiles()) {
				String FileNames=file.getName();
				Downloadfiles.add(FileNames);

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
					System.out.println("Test fail"+"\n"+"Excpeted file is: "+UIFiles.get(i)+"\n"+"Actual File Is"+Downloadfiles.get(i));

				}

			}

		} catch (Exception e) {

		}
		Thread.sleep(1000);
		FileUtils.deleteDirectory(UnzipfolderDelete);


	}

}
