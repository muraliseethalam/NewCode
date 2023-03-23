package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Non_Zoom_Sessions_Creation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Non Zoom Deposition Session Creation

public class Client_Non_Zoom_MediationSession_Creation extends BaseClass{
	@Test(priority=5)
	public void NonZoomMediationSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Non_Zoom_Sessions_Creation_PageObjects MediationSessionCreation=new Client_Non_Zoom_Sessions_Creation_PageObjects(driver);

		login.Clientlogin();
		MediationSessionCreation.ClickOnCase();
		MediationSessionCreation.ClickOnAddSession();
		MediationSessionCreation.ClickOnMediation();
		MediationSessionCreation.ClearDepositionName();
		MediationSessionCreation.MediationSessionName();
		MediationSessionCreation.SearchIntroducingPartyName();
		MediationSessionCreation.ClickOnIntroducingPartyName();
		MediationSessionCreation.EnterLocation();
		MediationSessionCreation.ClearSessionPasscode();
		MediationSessionCreation.EnterSessionPasscode();
		MediationSessionCreation.ScrollDown();
		MediationSessionCreation.AgainSearchIntroducingPartyName();
		MediationSessionCreation.ClickOnSave();
		MediationSessionCreation.ClickOnAddfolder();
		MediationSessionCreation.EnterFolderName();
		MediationSessionCreation.ClickOnSaveFolder();
		MediationSessionCreation.FolderValidation();
		MediationSessionCreation.ClickOnAddDocuments();
		MediationSessionCreation.UploadDocuments();
		MediationSessionCreation.ClickOnClose();
		MediationSessionCreation.MediationDocumentValidation();



	}
}
