package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Case_Folder_Documnets_Move_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Moving Case Folder Documents

public class Client_Case_Folder_Documents_Move_Validation extends BaseClass{
	@Test
	public void FolderDocumnetsMoveValidation() throws Exception{
		
		Client_Login login=new Client_Login();
		Client_Case_Folder_Documnets_Move_Validation_PageObjects MoveDocument=new Client_Case_Folder_Documnets_Move_Validation_PageObjects(driver);

		login.Clientlogin();
		MoveDocument.ClickOnCase();
		MoveDocument.ClickOnCaseFolder();
		MoveDocument.ClickOnDeleteFolder();
		MoveDocument.ClickOnDocument();
		MoveDocument.CaptureDocumentName();
		MoveDocument.ScrollDown();
		MoveDocument.ClickOnMove();
		MoveDocument.ChooseCase();
		MoveDocument.SelectCase();
		MoveDocument.ChooseFolder();
		MoveDocument.SelectFolder();
		MoveDocument.ClickOnConfirmMove();
		MoveDocument.ClickOnCaseManagement();
		MoveDocument.ClickOnValidateCase();
		MoveDocument.ClickOnCaseFolder();
		MoveDocument.ClickOnMoveFolder();
		MoveDocument.ValidationForDocumentMoveedOrNot();

	}
}