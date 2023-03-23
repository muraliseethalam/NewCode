package com.edepoze.client.test.scenarios;
import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Case_Folder_Refelect_Sessions_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

//Reflecting Of Case Folder In Sessions Folders

public class Client_Case_Folder_Documents_Reflect_Sessions_Validation extends BaseClass  {
	@Test
	public void CaseFolderRefelectSessionsValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folder_Refelect_Sessions_Validation_PageObjects CaseExhibits=new Client_Case_Folder_Refelect_Sessions_Validation_PageObjects(driver);

		login.Clientlogin();
		CaseExhibits.ClickOnCase();
		CaseExhibits.ClickOnCaseFolder();
		CaseExhibits.ClickOnCaseExhibits();
		CaseExhibits.ScrollDown();
		CaseExhibits.ValidatingCaseExhibitsDocumentsInSessions();

	}
}