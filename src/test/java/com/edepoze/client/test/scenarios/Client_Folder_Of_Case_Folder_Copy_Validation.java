package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Folders_Folder_Copy_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Copying Case Folder
public class Client_Folder_Of_Case_Folder_Copy_Validation extends BaseClass{
	@Test
	public void ClientFolderOfCaseFolderCopyValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folders_Folder_Copy_Validation_PageObjects FolderCopy=new Client_Case_Folders_Folder_Copy_Validation_PageObjects(driver);

		login.Clientlogin();
		FolderCopy.ClickOnCase();
		FolderCopy.ClickOnCaseFolder();
		FolderCopy.ClickOnCopyFolder();
		FolderCopy.ScrollDown();
		FolderCopy.ClickOnCopy();
		FolderCopy.ChooseCase();
		FolderCopy.SelectCase();
		FolderCopy.ClickConfirmCopy();
		FolderCopy.ClickOnClose();
		FolderCopy.ClickOnCaseManagement();
		FolderCopy.ClickOnValidateCase();
		FolderCopy.ClickOnCaseFolder();
		FolderCopy.ClickOnCopyFolder();
		FolderCopy.ValidationForFolderCopiedOrNot();

	}
}