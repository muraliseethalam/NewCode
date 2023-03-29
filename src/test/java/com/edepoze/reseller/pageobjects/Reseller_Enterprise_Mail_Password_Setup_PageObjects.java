package com.edepoze.reseller.pageobjects;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;

import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.ReadConfigPropertiesFile;

// Getting Enterprise Setup Password Link
public class Reseller_Enterprise_Mail_Password_Setup_PageObjects {
	public static Logger logger;
	public static String link; 
	WebDriver driver;
	public Reseller_Enterprise_Mail_Password_Setup_PageObjects(WebDriver driver) {
		this.driver=driver;
	}
	public static void searchEmail(String host, String port, String userName, String password) throws Exception {
		OutputData obj=new OutputData();
		Properties properties = new Properties();

		// server setting
		properties.put("mail.imap.host", host);
		properties.put("mail.imap.port", port);

		// SSL setting
		properties.setProperty("mail.imap.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.socketFactory.fallback", "false");
		properties.setProperty("mail.imap.socketFactory.port",
				String.valueOf(port));

		Session session = Session.getDefaultInstance(properties);

		try {
			// connects to the message store
			Store store = session.getStore("imap");
			store.connect(userName, password);

			// opens the inbox folder
			Folder folderInbox = store.getFolder("INBOX");
			folderInbox.open(Folder.READ_ONLY);

			// creates a search criterion
			SearchTerm searchCondition = new SearchTerm() {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean match(Message message) {
					try {
						if (message.getSubject().contains("eDepoze - Password setup")) {
							System.out.println("Mail Found");
							logger.info("Mail found");
							return true;
						}
						else {
							System.out.println("Mail Not Found");
						}
					} catch (MessagingException ex) {
						ex.printStackTrace();
					}
					return false;
				}
			};

			// performs search through the folder
			Message[] foundMessages = folderInbox.search(searchCondition);

			for (int i = 0; i < foundMessages.length; i++) {
				Message message = foundMessages[i];
				String subject = message.getSubject();
				System.out.println("Subject" + ": " + subject);

				String plainText= Jsoup.parse(message.getContent().toString()).text();
				//				System.out.println(plainText);

				String str = plainText;
				String[] arrOfStr = str.split(" ");

				for (String a : arrOfStr)
					if(a.startsWith("http")) {
						 link=a.trim();
						System.out.println("PasswoSetup Link: "+link);
						obj.WriteExcel("Sheet1", link, 11, 1);

					}

			}

			// disconnect
			folderInbox.close(false);
			store.close();
		} catch (NoSuchProviderException ex) {
			ex.printStackTrace();
			System.out.println("No provider.");
		} catch (MessagingException ex) {
			ex.printStackTrace();
			System.out.println("Could not connect to the message store.");
		}
	}

	
	public void GetLink() throws Exception {
		logger = Logger.getLogger("eDepoze");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Mail logged");
		ReadConfigPropertiesFile Userdetails=new ReadConfigPropertiesFile();
		String host = "imap.gmail.com";
		String port = "993";
		String userName = Userdetails.AddEnterpriseEmail();
		String password = Userdetails.EnterpriseEmailPassword();
		searchEmail(host, port, userName, password);
		logger.info("Getting the password setup link..");
	}
	public void Loadinglink() throws Exception {
		driver.get(link);
		}
}
