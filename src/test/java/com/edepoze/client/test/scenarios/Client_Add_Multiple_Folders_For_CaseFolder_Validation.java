package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Add_Multiple_Folders_For_CaseFolder_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;


// Case Folder Valiudation
public class Client_Add_Multiple_Folders_For_CaseFolder_Validation extends BaseClass {
	@Test
	public void AddMultipleFoldersForCaseFolderValidation() throws Exception {

		Client_Login login = new Client_Login();
		Client_Add_Multiple_Folders_For_CaseFolder_Validation_PageObjects Folders = new Client_Add_Multiple_Folders_For_CaseFolder_Validation_PageObjects(driver);
		
		login.Clientlogin();
		Folders.ClickOnCase();
		Folders.ClickOnCaseFolder();
		Folders.ClickOnAddFolder();
		Folders.EnterCopyFolderName();
		Folders.ClicOnSave();
		Folders.ClicOnAddDocuments();
		Folders.UplodDocuments();
		Folders.ClickOnclose();
		Folders.DocumentValidation();

		Folders.ClickOnAddFolder();
		Folders.EnterMoveFolderName();
		Folders.ClicOnSave();
		Folders.ClicOnAddDocuments();
		Folders.UplodDocuments();
		Folders.ClickOnclose();
		Folders.DocumentValidation();

		Folders.ClickOnAddFolder();
		Folders.EnterDeleteFolderName();
		Folders.ClicOnSave();
		Folders.ClicOnAddDocuments();
		Folders.UplodDocuments();
		Folders.ClickOnclose();
		Folders.DocumentValidation();

		Folders.ClickOnCaseExhibits();
		Folders.ClicOnAddDocuments();
		Folders.UplodDocuments();
		Folders.ClickOnclose();
		Folders.DocumentValidation();

		Folders.ClickOnCaseManagement();
		Folders.ClickOnValidateCase();
		Folders.ClickOnCaseFolder();
		Folders.ClickOnAddFolder();
		Folders.EnterVlidateCaseFolderName();
		Folders.ClicOnSave();

	}
}