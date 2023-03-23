package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Case_Delete_PageObjecst;
import com.edepoze.utilitifiles.BaseClass;

// Deleting Case
public class Client_Case_Delete extends BaseClass {

	@Test(invocationCount=1)
	public void ClientCaseDelete() throws Exception {
		
		Client_Login login=new Client_Login();
		Client_Case_Delete_PageObjecst DeleteCase=new Client_Case_Delete_PageObjecst(driver);
		
		login.Clientlogin();
		DeleteCase.BeforeCaseCount();
		DeleteCase.MouseMove();
		DeleteCase.ClickOnDelete();
		DeleteCase.Confirmtdelete();
		DeleteCase.AfterCaseCount();
		DeleteCase.Validation();
	}
}
