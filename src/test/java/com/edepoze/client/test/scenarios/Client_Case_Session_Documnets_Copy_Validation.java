package com.edepoze.client.test.scenarios;



import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Documents_Copy_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;


// Copying Session Documents

public class Client_Case_Session_Documnets_Copy_Validation extends BaseClass {
	@Test
	public void CaseDocumentsCopyValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Session_Documents_Copy_Validation_PageObjects Document=new Client_Case_Session_Documents_Copy_Validation_PageObjects(driver);
	
		login.Clientlogin();
		Document.ClickOnCase();
		Document.ClickOnSession();
		Document.ClickOnFolder();
		Document.ClickOnDocumnet();
		Document.ScroollDown();
		Document.ClickOnCopy();
		Document.ChooseCase();
		Document.SelcetCase();	
		Document.ClickOncopy();
		Document.ClickOnClose();
		Document.SearchDocumnet();
		Document.ClickOnCaseManagement();
		Document.ClickOnMovedDocumnetCase();
		Document.ClickOnMovedDocumnetSession();
		Document.ClickOnMovedFolder();
		Document.VerifyDocumnetCopiedOrNot();

	}

}
