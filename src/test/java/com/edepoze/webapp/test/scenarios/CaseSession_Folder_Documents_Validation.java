package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.test.scenarios.Client_Login;
import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.CaseSession_Folder_Documents_Validation_PageObjects;

// Validating Client Documents And Member Documents

public class CaseSession_Folder_Documents_Validation extends BaseClass {
	@Test

	public void CaseSessionFolderDocumentsValidation() throws Exception{


		Client_Login login=new Client_Login();
		WebApp_Member_Login Memberlogin=new WebApp_Member_Login();
		CaseSession_Folder_Documents_Validation_PageObjects FolderDocuments=new CaseSession_Folder_Documents_Validation_PageObjects(driver);

		//Client Case Session Documents Capturing
		login.Clientlogin();
		FolderDocuments.ClickOnClientCase();
		//	FolderDocuments.ScrollDown();
		FolderDocuments.ClickOnClientSession();
		FolderDocuments.ClickOnClientFolder();
		FolderDocuments.ClientCaseSessionDocumentsCapture();

		//Member Case Session Documents Capturing
		Memberlogin.Memberlogin();
		FolderDocuments.ComparisionBetweenCaseSessionDocumentsOfClientAndMember();
		FolderDocuments.ClickOnMemberSession();
		FolderDocuments.ClickOnMemberFolder();
		FolderDocuments.MemberCaseSessionDocumentsCapture();

		//Documents Validation
		FolderDocuments.ComparisionBetweenCaseSessionDocumentsOfClientAndMember();







	}

}