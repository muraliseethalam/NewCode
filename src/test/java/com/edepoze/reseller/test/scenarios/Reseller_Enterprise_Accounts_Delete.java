package com.edepoze.reseller.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_Enterprise_Delete_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

/**
 * @author MuraliSeethalam
 *
 */

// Deleting Enterprise Account
public class Reseller_Enterprise_Accounts_Delete extends BaseClass{

	@Test(invocationCount=1)
	public void DeleteClientAccounts() throws Exception {
		Reseller_Login login=new Reseller_Login();
		Reseller_Enterprise_Delete_PageObjects DeleteClientCases=new Reseller_Enterprise_Delete_PageObjects(driver);
	
		login.Resellerlogin();
		DeleteClientCases.ClickOnSearch();
		DeleteClientCases.ClicOnGo();
		DeleteClientCases.MouseOver();
		DeleteClientCases.ClickOnEdit();
		DeleteClientCases.ClickOnDelete();
		DeleteClientCases.ClickOnConfirmDelete();
		DeleteClientCases.ClickOnSearch();
		DeleteClientCases.ClicOnGo();
		DeleteClientCases.ValidationForDeletedOrNot();

	}

}
