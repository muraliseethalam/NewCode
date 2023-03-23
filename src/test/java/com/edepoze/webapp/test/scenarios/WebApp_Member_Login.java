package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.WebApp_Login_PageObjects;

// Member Login

public class WebApp_Member_Login extends BaseClass {


	@Test
	public void  Memberlogin() throws Exception {

		WebApp_Login_PageObjects WebApp = new WebApp_Login_PageObjects(driver);
		WebApp.NavigateToWebApp();
		WebApp.clickonMemberlogin();
		WebApp.enterusername();
		WebApp.enterpassword();
		WebApp.clickonlogin();
		WebApp.Validation();
	}
}