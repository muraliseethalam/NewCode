package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Non_Zoom_Sessions_Creation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Folder Validation

public class Client_Add_New_Session_For_Folder_Validation extends BaseClass{
	@Test (priority=1)
	public void DepositionSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Non_Zoom_Sessions_Creation_PageObjects SessionCreation=new Client_Non_Zoom_Sessions_Creation_PageObjects(driver);
		
		login.Clientlogin();
		SessionCreation.ClickOnCase();
		SessionCreation.ClickOnAddSession();
		SessionCreation.ClickOnDeposition();
		SessionCreation.EnterDepositionName1();

		SessionCreation.Entervolume();
		SessionCreation.SearchIntroducingPartyName();
		SessionCreation.ClickOnIntroducingPartyName();
		SessionCreation.SelectOnCourtReportingFirmName();
		SessionCreation.EnterLocation();
		SessionCreation.ClearSessionPasscode();
		SessionCreation.EnterSessionPasscode();
		SessionCreation.ScrollDown();
		SessionCreation.ClickOnSave();

		SessionCreation.ClickOnAddfolder();
		SessionCreation.EnterMoveFolderName();
		SessionCreation.ClickOnSaveFolder();
		SessionCreation.MoveFolderValidation();
		SessionCreation.ClickOnAddDocuments();
		SessionCreation.UploadDocuments();
		SessionCreation.ClickOnClose();
		SessionCreation.DocumentValidation();

		SessionCreation.ClickOnAddfolder();
		SessionCreation.EnterCopyFolderName();
		SessionCreation.ClickOnSaveFolder();
		SessionCreation.CopyFolderValidation();
		SessionCreation.ClickOnAddDocuments();
		SessionCreation.UploadDocuments();
		SessionCreation.ClickOnClose();
		SessionCreation.DocumentValidation();

		SessionCreation.ClickOnAddfolder();
		SessionCreation.EnterDeleteFolderName();
		SessionCreation.ClickOnSaveFolder();
		SessionCreation.DeleteFolderValidation();
		SessionCreation.ClickOnAddDocuments();
		SessionCreation.UploadDocuments();
		SessionCreation.ClickOnClose();
		SessionCreation.DocumentValidation();

		SessionCreation.ClickOnAddfolder();
		SessionCreation.EnterFolderName();
		SessionCreation.ClickOnSaveFolder();
		SessionCreation.FolderValidation();
		SessionCreation.ClickOnAddDocuments();
		SessionCreation.UploadDocuments();
		SessionCreation.ClickOnClose();
		SessionCreation.DocumentValidation();


	}
}
