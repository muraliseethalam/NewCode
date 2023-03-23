package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Non_Zoom_Sessions_Creation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Non Zoom Deposition Session Creation

public class Client_Non_Zoom_DepositionSession_Creation extends BaseClass{
	@Test (priority=1)
	public void NonZoomDepositionSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Non_Zoom_Sessions_Creation_PageObjects DepositionSession=new Client_Non_Zoom_Sessions_Creation_PageObjects(driver);

		login.Clientlogin();
		DepositionSession.ClickOnCase();
		DepositionSession.ClickOnAddSession();
		DepositionSession.ClickOnDeposition();
		DepositionSession.EnterDepositionName();
		DepositionSession.Entervolume();
		DepositionSession.SearchIntroducingPartyName();
		DepositionSession.ClickOnIntroducingPartyName();
		DepositionSession.SelectOnCourtReportingFirmName();
		DepositionSession.EnterLocation();
		DepositionSession.ClearSessionPasscode();
		DepositionSession.EnterSessionPasscode();
		DepositionSession.ScrollDown();
		DepositionSession.ClickOnSave();
		DepositionSession.ClickOnAddfolder();
		DepositionSession.EnterFolderName();
		DepositionSession.ClickOnSaveFolder();
		DepositionSession.FolderValidation();
		DepositionSession.ClickOnAddDocuments();
		DepositionSession.UploadDocuments();
		DepositionSession.ClickOnClose();
		DepositionSession.DepositionDocumentValidation();




	}
}
