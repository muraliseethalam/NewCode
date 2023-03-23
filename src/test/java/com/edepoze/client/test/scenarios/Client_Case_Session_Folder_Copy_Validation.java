package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Folder_Copy_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Copying Session Folder

public class Client_Case_Session_Folder_Copy_Validation extends BaseClass{
	@Test
	public void CaseSessionFolderCopyValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Session_Folder_Copy_Validation_PageObjects Folder=new Client_Case_Session_Folder_Copy_Validation_PageObjects(driver);
		
		login.Clientlogin();
		Folder.ClickOnCase();
		Folder.ClickOnSession();
		Folder.ClickOnFolder();
		Folder.ScrollDown();
		Folder.ClickOnCopy();
		Folder.ChooseCase();
		Folder.SelcetCase();	
		Folder.ClickOncopy();
		Folder.ClickOnClose();
		Folder.SearchFolder();
		Folder.ClickOnCaseManagement();
		Folder.ClickOnCopyFolderCase();
		Folder.ClickOnCopyFolderSession();
		Folder.VerifyFolderCopiedOrNot();

	}
}
