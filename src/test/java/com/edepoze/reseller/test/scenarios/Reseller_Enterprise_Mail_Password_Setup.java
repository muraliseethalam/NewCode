package com.edepoze.reseller.test.scenarios;


import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_Enterprise_Mail_Password_Setup_PageObjects;
import com.edepoze.reseller.pageobjects.Reseller_Login_PageObjects;
import com.edepoze.utilitifiles.OutputData;
import com.edepoze.utilitifiles.BaseClass;


// Enterprise Client Account Password Setup Through Mail Setup Link
public class Reseller_Enterprise_Mail_Password_Setup extends BaseClass {
	@Test

	public void PasswordSetup() throws Exception {
		// Getting the link from mail
		Reseller_Enterprise_Mail_Password_Setup_PageObjects Getlink=new Reseller_Enterprise_Mail_Password_Setup_PageObjects(driver);
		Reseller_Login_PageObjects Password=new Reseller_Login_PageObjects(driver);
		driver.get(OutputData.EnterprisePasswordsetuplink());
		
		//Password Setup Page
		Getlink.GetLink();
		Getlink.Loadinglink();
		Password.EnterNewPassword();
		Password.EnterConfirmPassword();
		Password.ClickOnSave();


		//Verifying Password Change Or Not
		Password.EnterEnterpriseUserName();
		Password.EnterEnterprisePassword();
		Password.ClickOnLogin();
		Password.EnterpriseLoginValidation();






	}

}
