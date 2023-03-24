package com.edepoze.reseller.test.scenarios;


import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_Client_Mail_PasswordSetup_PageObjects;
import com.edepoze.reseller.pageobjects.Reseller_Login_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Client Account Password Setup Through Mail Setup Link
public class Reseller_Client_Mail_Password_Setup extends BaseClass {

	@Test
	public void PasswordSetup() throws Exception {

		// Getting the link from mail
		Reseller_Client_Mail_PasswordSetup_PageObjects Getlink=new Reseller_Client_Mail_PasswordSetup_PageObjects(driver);
		Reseller_Login_PageObjects Password=new Reseller_Login_PageObjects(driver);
		


		//Password Setup Page
		Getlink.GetLink();
		Getlink.Loadinglink();
		Password.EnterNewPassword();
		Password.EnterConfirmPassword();
		Password.ClickOnSave();


		//Verifying Password Change Or Not
		Password.EnterClientUsername();
		Password.EnterEnterClientPassword();
		Password.ClickOnLogin();
		Password.AcceptTermsConditions();
		Password.ClientLoginValidation();






	}

}
