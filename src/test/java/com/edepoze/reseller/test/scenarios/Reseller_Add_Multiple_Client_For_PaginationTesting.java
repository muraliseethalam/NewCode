package com.edepoze.reseller.test.scenarios;


import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_AddClient_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

/**
 * @author Murali.Seethalam
 */
// Reseller Pagination
public class Reseller_Add_Multiple_Client_For_PaginationTesting extends BaseClass{

	@Test(invocationCount=5)

	public void AddMultipleClient() throws Exception {
		Reseller_Login login=new Reseller_Login();
		Reseller_AddClient_PageObjects AddClient=new Reseller_AddClient_PageObjects(driver);


		//In Add Client Basic Infrmation Page
		login.Resellerlogin();
		AddClient.ClickOnAddClient();
		AddClient.EnterClientName();
		AddClient.EnterContactName();
		AddClient.EnterEmail();
		AddClient.ScroollDown();
		AddClient.EnterContactPhone();
		AddClient.SelectCountryCode();
		AddClient.Enteraddress();
		AddClient.Entercity();
		AddClient.SelectState();
		AddClient.EnterZip();
		AddClient.ClickOnNext();


		//In Add Client Admin Setup Page
		AddClient.EnterFirstName();
		AddClient.BasicInformationValidation();
		AddClient.EnterLastName();
		AddClient.Enteremail();
		AddClient.EnterUsername();
		AddClient.EnterPassword();
		AddClient.EnterConfirmPassword();
		AddClient.ClickOnSave();
		AddClient.AdminSetupValidation();


		//Validation For Client Account Created Or Not
		AddClient.EnterClientID();
		AddClient.ClikOnSearch();
		AddClient.ValidationForClientCreatedorNot();


	}



}
