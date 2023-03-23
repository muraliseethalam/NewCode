package com.edepoze.reseller.test.scenarios;


import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_Login_PageObjects;
import com.edepoze.utilitifiles.BaseClass;



// Reseller Login
public class Reseller_Login extends BaseClass {

	@Test
	public void   Resellerlogin() throws Exception {
		Reseller_Login_PageObjects Reseller=new Reseller_Login_PageObjects(driver);

		Reseller.EnterUsername();
		Reseller.EnterPassword();
		Reseller.ClickOnLogin();
		Reseller.LoginValidation();


	}


}
