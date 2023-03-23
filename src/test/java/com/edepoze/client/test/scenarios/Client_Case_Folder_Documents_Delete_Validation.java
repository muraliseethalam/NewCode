package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Case_Folder_Documnets_Delete_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Deleting Case Folder Documents

public class Client_Case_Folder_Documents_Delete_Validation extends BaseClass{
	@Test
	public void FolderDocumnetsDeleteValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folder_Documnets_Delete_Validation_PageObjects DeleteDocument=new Client_Case_Folder_Documnets_Delete_Validation_PageObjects(driver);
		
		login.Clientlogin();
		DeleteDocument.ClickOnCase();
		DeleteDocument.ClickOnCaseFolder();
		DeleteDocument.ClickOnDeleteFolder();
		DeleteDocument.ClickOnDocument();
		DeleteDocument.CaptureDocumentName();
		DeleteDocument.ScrollDown();
		DeleteDocument.ClickOnDelete();
		DeleteDocument.ClickOnConfirmDelete();
		DeleteDocument.ValidationForDocumentDeletedOrNot();

	}
}