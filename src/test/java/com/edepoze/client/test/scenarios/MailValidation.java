package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Zoom_Trial_Session_Mail_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Revoke Gmail API OAuth Token

public class MailValidation extends BaseClass{
	@Test
	
	public void Mailvalidation() throws Exception {
		
		Client_Zoom_Trial_Session_Mail_Validation_PageObjects MailValidation = new Client_Zoom_Trial_Session_Mail_Validation_PageObjects(driver);
		MailValidation.GetLink();

	


}
}