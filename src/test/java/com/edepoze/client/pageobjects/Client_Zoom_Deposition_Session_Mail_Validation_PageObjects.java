package com.edepoze.client.pageobjects;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SearchTerm;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.edepoze.utilitifiles.ReadConfigPropertiesFile;



// Getting Client Mail Password Setup Link
public class Client_Zoom_Deposition_Session_Mail_Validation_PageObjects {
	
	WebDriver driver;
	public static String sessionID;
	public static String link;
	public Client_Zoom_Deposition_Session_Mail_Validation_PageObjects(WebDriver driver) {
		this.driver=driver;
	}

	public static void searchEmail(String host, String port, String userName,String password) throws Exception {
	
		
//		OutputData obj=new OutputData();
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
				        String subject = message.getSubject();
				        if (subject.contains("Deposition Of MAT Deposition Session Zoom") || 
				            subject.contains("Session Of MAT Deposition Session Zoom")) {
				            System.out.println("Mail Found");
				            return true;
				        } else {
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
				String messageBody = getTextFromMessage(message);

		        // Print the message body
		        System.out.println("Message Body:\n" + messageBody);
		        
		        String Bodymessage = messageBody;

		        Pattern pattern = Pattern.compile("Session ID: (\\d+)");
		        Matcher matcher = pattern.matcher(Bodymessage);

		        if (matcher.find()) {
		             sessionID = matcher.group(1);
		            System.out.println("Mail Session ID: " + sessionID);
		            
		            
		        } else {
		            System.out.println("Session not found.");
		        }

		        
		        
		        
		        
		        
		        
		        
		        
				


				String str = messageBody;
				String[] arrOfStr = str.split(" ");

				for (String a : arrOfStr)
					if(a.startsWith("http")) {
						 link=a.trim();
						System.out.println(link);
//						obj.WriteExcel("Sheet1", link, 13, 1);

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
	
	 private static String getTextFromMessage(Message message) throws Exception {
		
	        String result = "";
	        if (message.isMimeType("text/plain")) {
	            result = message.getContent().toString();
	        } else if (message.isMimeType("multipart/*")) {
	            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
	            result = getTextFromMimeMultipart(mimeMultipart);
	        }
	        return result;
	    }

	    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
	        String result = "";
	        int count = mimeMultipart.getCount();
	        for (int i = 0; i < count; i++) {
	            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	            if (bodyPart.isMimeType("text/plain")) {
	                result += bodyPart.getContent();
	                break; // stop searching for plain text
	            } else if (bodyPart.isMimeType("text/html")) {
	                String html = (String) bodyPart.getContent();
	                result += Jsoup.parse(html).text(); // extract text from HTML
	            } else if (bodyPart.getContent() instanceof MimeMultipart) {
	                result += getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
	            }
	        }
	        return result;
	    }
	public  void GetLink() throws Exception {
		ReadConfigPropertiesFile Userdetails=new ReadConfigPropertiesFile();
		String host = "imap.gmail.com";
		String port = "993";
		String userName = Userdetails.AddEnterpriseEmail();
		String password = Userdetails.EnterpriseEmailPassword();
		searchEmail(host, port, userName, password);
	}
	public void SessionIdValidation() throws Exception {
		Thread.sleep(2000);
		String SessionID=driver.findElement(By.xpath("//table[@class='view_details_table']//tr//td[2]")).getText();
		System.out.println("UI Session ID: "+SessionID);
		Assert.assertEquals(SessionID, sessionID);
		System.out.println("UI Session ID and Mail Session ID Matched");
	}
	public void ClickOnArbitrationSessionLink() throws Exception {
		driver.get(link);
		}
}


