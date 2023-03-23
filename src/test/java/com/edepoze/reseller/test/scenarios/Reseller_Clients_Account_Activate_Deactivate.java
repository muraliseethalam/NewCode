package com.edepoze.reseller.test.scenarios;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_Client_Activate_and_Deactivate_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

/**
 * @author MuraliSeethalam
 */

// Client Acount Activation and Deactivation

public class Reseller_Clients_Account_Activate_Deactivate extends BaseClass{

	@Test(priority=1)
	public void DeactiveAccount() throws Exception {
		Reseller_Login login=new Reseller_Login();
		Reseller_Client_Activate_and_Deactivate_PageObjects DeactiveAcount=new Reseller_Client_Activate_and_Deactivate_PageObjects(driver);

		//Deactivate Account  
		login.Resellerlogin();
		DeactiveAcount.SearchByClientName();
		DeactiveAcount.ClickOnGo();
		DeactiveAcount.ClickOnDeactivated();
		DeactiveAcount.ChecktheAccountDeactivatedorNot();

	}


	//	Login With Deactive Logins 

	@Test(priority=2)
	public void LoginWithDeactiveLogins() throws Exception {


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reseller_Client_Activate_and_Deactivate_PageObjects LoginWithDeactiveLogins=new Reseller_Client_Activate_and_Deactivate_PageObjects(driver);

		LoginWithDeactiveLogins.EnterDeactiveaccountUserID();
		LoginWithDeactiveLogins.EnterDeactiveaccountPaasword();
		LoginWithDeactiveLogins.ClicOnLogin();
		LoginWithDeactiveLogins.ValidateAccountDeactivatedorNot();

	}


	//	Activating The Deactive Account 

	@Test(priority=3)
	public void ActivateTheDeactiveAccount() throws Exception {


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reseller_Login login=new Reseller_Login();
		login.Resellerlogin();
		Reseller_Client_Activate_and_Deactivate_PageObjects ActivateDeactiveAccount=new Reseller_Client_Activate_and_Deactivate_PageObjects(driver);

		ActivateDeactiveAccount.SearchByDeactiveaccount();
		ActivateDeactiveAccount.ClickOnGo1();
		ActivateDeactiveAccount.ClickOnActivateAccount();
		ActivateDeactiveAccount.ChecktheAccountActivatedorNot();


	}


	//	Login Activated Account

	@Test(priority=4)
	public void LoginActiveAccount() throws Exception {


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reseller_Client_Activate_and_Deactivate_PageObjects LoginActivecredentials=new Reseller_Client_Activate_and_Deactivate_PageObjects(driver);

		LoginActivecredentials.EnterDeactiveaccountUserID();
		LoginActivecredentials.EnterDeactiveaccountPaasword();
		LoginActivecredentials.ClicOnLogin();
		LoginActivecredentials.AcceptTermsConditions();
		LoginActivecredentials.CaptureScreenshot();
		LoginActivecredentials.ValiditeAcountActivatedOrNot();





	}
}
