package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Folders_Folder_Delete_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Deleting Case Folder

public class Client_Folder_Of_Case_Folder_Delete_Validation extends BaseClass{
	@Test
	public void ClientFolderOfCaseFolderDeleteValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folders_Folder_Delete_Validation_PageObjects FolderDelete=new Client_Case_Folders_Folder_Delete_Validation_PageObjects(driver);

		login.Clientlogin();
		FolderDelete.ClickOnCase();
		FolderDelete.ClickOnCaseFolder();
		FolderDelete.ClickOnDeleteFolder();
		FolderDelete.ScrollDown();
		FolderDelete.ClickOnDelete();
		FolderDelete.ClickOnConfirmDelete();
		FolderDelete.ValidationForFolderDeletedOrNot();

	}
}
