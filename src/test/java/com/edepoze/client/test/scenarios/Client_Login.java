package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Login_PageObjects;
import com.edepoze.utilitifiles.BaseClass;


// Client Login

public class Client_Login extends BaseClass {
	@Test
	public void Clientlogin() throws Exception {

		Client_Login_PageObjects Client=new Client_Login_PageObjects(driver);

		
		Client.EnterUsername();
		Client.EnterPassword();
		Client.ClickOnLogin();
	//	Client.ScrollDown();
		Client.AcceptTermsConditions();
		Client.ClientLoginValidation();
		
	


	}
}





