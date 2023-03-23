package com.edepoze.reseller.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_AddEnterprise_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

/**
 * @author MuraliSeethalam
 */

//Adding Enterprise Client Account

public class Reseller_Add_Enterprise extends BaseClass {

	@Test(invocationCount=1)

	public void AddEnterpriseClient() throws Exception {
		Reseller_Login login=new Reseller_Login();
		Reseller_AddEnterprise_PageObjects AddEnterprise=new Reseller_AddEnterprise_PageObjects(driver);

		// Add Enterprise Basic Information Page
		login.Resellerlogin();
		AddEnterprise.ClickOnAddEnterprise();
		AddEnterprise.EnterClientName();
		AddEnterprise.EnterContactName();
		AddEnterprise.EnterEmail();
		AddEnterprise.EnterContactPhone();
		AddEnterprise.SelectCountryCode();
		AddEnterprise.ScroollDown();
		AddEnterprise.Enteraddress();
		AddEnterprise.Entercity();
		AddEnterprise.SelectState();
		AddEnterprise.EnterZip();
		AddEnterprise.EnterURL();
		AddEnterprise.Changetextcolor();
		AddEnterprise.ChangeBanarColor();
		AddEnterprise.ClickOnNext();


		// Add Enterprise Admin Setup Page
		AddEnterprise.EnterFirstName();
		AddEnterprise.BasicInformationValidaiton();
		AddEnterprise.EnterLastName();
		AddEnterprise.EnterEmail1();
		AddEnterprise.EnterUsername();
		AddEnterprise.EnterPassword();
		AddEnterprise.EnterConfirPassword();
		AddEnterprise.ClickOnSave();
		AddEnterprise.AdminSetupValidation();

		//Validation For Client Account Created Or Not
		AddEnterprise.EnterClientID();
		AddEnterprise.ClikOnSearch();
		AddEnterprise.ValidationForClientCreatedorNot();






	}

}
