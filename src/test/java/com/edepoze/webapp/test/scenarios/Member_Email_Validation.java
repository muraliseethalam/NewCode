package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_Email_Validation_PageObjects;

// Sending Documents Through Email

public class Member_Email_Validation extends BaseClass {

	@Test
	public void MemberEmailValidation() throws Exception {

		WebApp_Member_Login login=new WebApp_Member_Login();
		Member_Email_Validation_PageObjects Email=new Member_Email_Validation_PageObjects(driver);
		
		login.Memberlogin();
		Email.ClickOnSession();
		Email.ClickOnFolder();
		Email.ClickOnEmailButton();
		Email.ClickOnEmail();
		Email.EnterEmail();
		Email.EnterDescription();
		Email.ClickOnSend();



	}
}