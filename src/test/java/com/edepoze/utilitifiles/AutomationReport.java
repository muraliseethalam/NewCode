package com.edepoze.utilitifiles;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;


public class AutomationReport{
	@Test
//	Send Automation Report Resepective Email ID's(Team Members)

	public  void report() throws Exception {
//		OutputData FileName=new OutputData();
		ReadConfigPropertiesFile Environment=new ReadConfigPropertiesFile();
		Properties props = new Properties();
		final String ExtentMailId=Environment.ExtentreportMailID();
		final String ExtentMailIdPassword=Environment.ExtentreportPassword();
		final String RecipientsMailid=Environment.RecipientsMailid();
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(ExtentMailId, ExtentMailIdPassword);

					}

				});

		try {

			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ExtentMailId));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(RecipientsMailid));
            
            
			message.setSubject("eDepoze WebManager and WebApp "+Environment.Environment()+" Environment Automation Testing Report");
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Hi Team,"+"\n"+"This mail is auto genarated through autmation."+"\n"+"Please find the below attachment of eDepoze WebManager and WebApp "+Environment.Environment()+ " environment automation testing report.");
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename =OutputData.ExtentReportFileName();
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			messageBodyPart2.setFileName(filename);
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			Transport.send(message);

			System.out.println("Successfully Email Sent");

		} catch (MessagingException e) {
			System.out.println("Failed Email Doesn't Sent");
			throw new RuntimeException(e);

		}
		
//		Deleting Old ScreenShots And Output Folder After Sending The Report 
		File ScreenShotsFolderDelete = new File(System.getProperty("user.dir")+"\\"+"Screenshots");
		FileUtils.deleteDirectory(ScreenShotsFolderDelete);
		File filelocation=new File(System.getProperty("user.dir")+"\\"+"test-output");
		filelocation.delete();
		
		

	}

}