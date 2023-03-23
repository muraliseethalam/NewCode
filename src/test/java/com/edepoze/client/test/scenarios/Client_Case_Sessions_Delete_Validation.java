package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Sessions_Delete_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Deleting Session
 
public class Client_Case_Sessions_Delete_Validation extends BaseClass {

	@Test
	public void ClientCaseSessionsDeleteValidation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Case_Sessions_Delete_PageObjects SessionDelete=new Client_Case_Sessions_Delete_PageObjects(driver);

		login.Clientlogin();
		SessionDelete.ClickOnCase();
		SessionDelete.CaptureCaseID();
		SessionDelete.ClickOnDelete();
		SessionDelete.ConfirmDelete();
		SessionDelete.ValidateSessionDeletedOrNot();

	}

}
