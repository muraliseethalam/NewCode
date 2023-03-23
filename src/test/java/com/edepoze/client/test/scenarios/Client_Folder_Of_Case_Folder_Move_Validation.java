package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Folders_Folder_Move_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Moving Case Folder

public class Client_Folder_Of_Case_Folder_Move_Validation extends BaseClass{
	@Test
	public void ClientFolderOfCaseFolderMoveValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folders_Folder_Move_Validation_PageObjects FolderMove=new Client_Case_Folders_Folder_Move_Validation_PageObjects(driver);
	
		login.Clientlogin();
		FolderMove.ClickOnCase();
		FolderMove.ClickOnCaseFolder();
		FolderMove.ClickOnMoveFolder();
		FolderMove.ScrollDown();
		FolderMove.ClickOnMove();
		FolderMove.ChooseCase();
		FolderMove.SelectCase();
		FolderMove.ClickOnConfirmMove();
		FolderMove.ClickOnCaseManagement();
		FolderMove.ClickOnValidateCase();
		FolderMove.ClickOnCaseFolder();
		FolderMove.ClickOnMoveFolder();
		FolderMove.ValidationForFolderMovedOrNot();

	}
}