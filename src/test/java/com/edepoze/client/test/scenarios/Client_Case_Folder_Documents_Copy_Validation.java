package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Case_Folder_Documnets_Copy_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Copying Case Folder Documetns

public class Client_Case_Folder_Documents_Copy_Validation extends BaseClass{
	@Test
	public void CaseFolderDocumnetsCopyValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folder_Documnets_Copy_Validation_PageObjects CopyDocument=new Client_Case_Folder_Documnets_Copy_Validation_PageObjects(driver);
		
		login.Clientlogin();
		CopyDocument.ClickOnCase();
		CopyDocument.ClickOnCaseFolder();
		CopyDocument.ClickOnDeleteFolder();
		CopyDocument.ClickOnDocument();
		CopyDocument.CaptureDocumentName();
		CopyDocument.ScrollDown();
		CopyDocument.ClickOnCpy();
		CopyDocument.ChooseCase();
		CopyDocument.SelectCase();
		CopyDocument.ChooseFolder();
		CopyDocument.SelectFolder();
		CopyDocument.ClickConfirmCopy();
		CopyDocument.ClickOnClose();
		CopyDocument.ClickOnCaseManagement();
		CopyDocument.ClickOnValidateCase();
		CopyDocument.ClickOnCaseFolder();
		CopyDocument.ClickOnCopyFolder();
		CopyDocument.CaptureDocumentName1();
		CopyDocument.ValidationForDocumentCopiedOrNot();

	}
}