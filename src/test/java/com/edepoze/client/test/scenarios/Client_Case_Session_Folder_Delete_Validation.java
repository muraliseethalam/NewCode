package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Folder_Delete_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Deleting Session Folders

public class Client_Case_Session_Folder_Delete_Validation extends BaseClass{
	@Test
	public void CaseSessionFolderDeleteValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Session_Folder_Delete_Validation_PageObjects Folder=new Client_Case_Session_Folder_Delete_Validation_PageObjects(driver);

		login.Clientlogin();
		Folder.ClickOnCase();
		Folder.ClickOnSession();
		Folder.ClickOnFolder();
		Folder.ScrollDown();
		Folder.ClickOnDelete();
		Folder.ClickOnConfirmDelete();
		Folder.VerifyFolderDeltedOrNot();

	}
}
