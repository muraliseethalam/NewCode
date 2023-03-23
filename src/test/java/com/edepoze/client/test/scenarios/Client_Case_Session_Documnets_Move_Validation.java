package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Documents_Move_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Moving Session Documents

public class Client_Case_Session_Documnets_Move_Validation extends BaseClass {

	@Test
	public void CaseSessionDocumentsMoveValidation() throws Exception{
		Client_Login login=new Client_Login();
		Client_Case_Session_Documents_Move_Validation_PageObjects Document=new Client_Case_Session_Documents_Move_Validation_PageObjects(driver);
		
		login.Clientlogin();
		Document.ClickOnCase();
		Document.ClickOnSession();
		Document.ClickOnFolder();
		Document.ScrollDown();
		Document.ClickOnDocumnet();	
		Document.ClickOnMove();
		Document.ChooseCase();
		Document.SelcetCase();	
		Document.ChooseSession();
		Document.ChooseSession();
		Document.ChooseFolder();
		Document.SelectFolder();
		Document.ClickOnmove();
		Document.ClickOnClose();
		Document.SearchDocumnet();
		Document.ClickOnCaseManagement();
		Document.ClickOnMovedDocumnetCase();
		Document.ClickOnMovedDocumnetSession();
		Document.ClickOnMovedFolder();
		Document.VerifyDocumnetMovedOrNot();

	}

}
