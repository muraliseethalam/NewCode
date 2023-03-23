package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Documents_Delete_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Deleting Session Documents

public class Client_Case_Session_Documnets_Delete_Validation extends BaseClass {
	@Test
	public void CaseSessionDocumentsDeleteValidation() throws Exception{
		Client_Login login=new Client_Login();
		Client_Case_Session_Documents_Delete_Validation_PageObjects Document=new Client_Case_Session_Documents_Delete_Validation_PageObjects(driver);
		
		login.Clientlogin();
		Document.ClickOnCase();
		Document.ClickOnSession();
		Document.ClickOnFolder();
		Document.ScroollDown();
		Document.ClickOnDocumnet();
		Document.ClickOnDelete();
		Document.ClickOnConfirmDelete();
		Document.VerifyDocumentDeletedOrNot();

	}

}
