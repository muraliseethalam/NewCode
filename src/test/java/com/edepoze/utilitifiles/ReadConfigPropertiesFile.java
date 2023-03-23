package com.edepoze.utilitifiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


//Reading Config Proparety File
public class ReadConfigPropertiesFile {
	Properties propertie;

	public  ReadConfigPropertiesFile() {

		File src=new File("./src/main/resources/Propertiesfile/config.properties");

		try {
			FileInputStream fis =new FileInputStream(src);
			propertie=new Properties();
			propertie.load(fis);
		}
		catch(Exception e){
			System.out.println("Exception is" + e.getMessage());

		}
	}

	public String ResellerUsername() {
		String ResellerUsername=propertie.getProperty("ResellerUserName");
		return ResellerUsername;
	}
	public String ResellerPassword() {
		String ResellerPassword=propertie.getProperty("ResellerPassword");
		return ResellerPassword;
	}
	public String Environment() {
		String Environment=propertie.getProperty("Environment");
		return Environment;
	}
	public String BrowserName() {
		String BrowserName=propertie.getProperty("BrowserName");
		return BrowserName;
	}
	public String AddClientEmail() {
		String AddClientEmail=propertie.getProperty("AddClientEmail");
		return AddClientEmail;
	}
	public String ClientEmailPassword() {
		String ClientEmailPassword=propertie.getProperty("ClientEmailPassword");
		return ClientEmailPassword;
	}
	public String AddEnterpriseEmail() {
		String AddEnterpriseEmail=propertie.getProperty("AddEnterpriseEmail");
		return AddEnterpriseEmail;
	}
	public String EnterpriseEmailPassword() {
		String EnterpriseEmailPassword=propertie.getProperty("EnterpriseEmailPassword");
		return EnterpriseEmailPassword;
	}
	public String CourtReportingFirmName() {
		String CourtReportingFirmName=propertie.getProperty("CourtReportingFirmName");
		return CourtReportingFirmName;
	}
	public String ExtentreportMailID() {
		String ExtentreportMailID=propertie.getProperty("GmailID");
		return ExtentreportMailID;
	}
	public String ExtentreportPassword() {
		String ExtentreportPassword=propertie.getProperty("Password");
		return ExtentreportPassword;
	}
	public String RecipientsMailid() {
		String RecipientsMailid=propertie.getProperty("RecipientsMailid");
		return RecipientsMailid;
	}
	public String ClientUserID() {
		String ClientUserName=propertie.getProperty("ClientUserName");
		return ClientUserName;
	}
	public String ClientPassword() {
		String ClientPassword=propertie.getProperty("ClientPassword");
		return ClientPassword;
	}
	
	

}
