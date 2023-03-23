package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.test.scenarios.Client_Login;
import com.edepoze.utilitifiles.BaseClass;

// Validating Case Session ID And Password

public class CaseSession_ID_And_Password_Validation extends BaseClass{

	@Test

	public void CaseSessionIDAndPasswordValidation() throws Exception{

		Client_Login login=new Client_Login();
		WebApp_Member_Login Memberlogin=new WebApp_Member_Login();
		com.edepoze.webapp.pageobjects.CaseSession_ID_And_Password_Validation_PageObjects IDandPassword=new com.edepoze.webapp.pageobjects.CaseSession_ID_And_Password_Validation_PageObjects(driver);

		//Client Session ID and Password Capturing
		login.Clientlogin();
		IDandPassword.ClickOnClientCase();
		//	IDandPassword.ScrollDown();
		IDandPassword.ClickOnClientSession();
		IDandPassword.ClientCaseSessionIDCapture();
		IDandPassword.ClientCaseSessionPasswordCapture();

		//Member Session ID and password Capturing
		Memberlogin.Memberlogin();
		IDandPassword.ClickOnMemberSession();
		IDandPassword.CaptureMemberSessionId();
		IDandPassword.CaptureMemberPassword();	
		IDandPassword.PasswordCapture();


		//Session Ids Validation
		IDandPassword.ComparisionBetweenCaseSessionIDofClientAndMember();
		IDandPassword.ComparisionBetweenCaseSessionPasswordofClientAndMember();

	}
}
