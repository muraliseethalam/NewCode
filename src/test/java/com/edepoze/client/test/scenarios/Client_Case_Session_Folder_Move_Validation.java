package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Folder_Move_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Moving Session Folder

public class Client_Case_Session_Folder_Move_Validation extends BaseClass{
	@Test
	public void CaseSessionFolderMoveValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Session_Folder_Move_Validation_PageObjects Folder=new Client_Case_Session_Folder_Move_Validation_PageObjects(driver);
		
		login.Clientlogin();
		Folder.ClickOnCase();
		Folder.ClickOnSession();
		Folder.ClickOnFolder();
		Folder.ScrollDown();
		Folder.ClickOnMove();
		Folder.ChooseCase();
		Folder.SelcetCase();	
		Folder.ClickOnmove();
		Folder.ClickOnClose();
		Folder.SearchFolder();
		Folder.ClickOnCaseManagement();
		Folder.ClickOnMoveFolderCase();
		Folder.ClickOnMoveFolderSession();
		Folder.VerifyFolderMovedOrNot();

	}
}
