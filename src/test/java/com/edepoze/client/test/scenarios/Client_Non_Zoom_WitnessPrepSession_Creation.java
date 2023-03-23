package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Non_Zoom_Sessions_Creation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Non Zoom WitnessPrep Session Creation

public class Client_Non_Zoom_WitnessPrepSession_Creation extends BaseClass {
	@Test(priority=2)
	public void NonZoomWitnessPrepSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Non_Zoom_Sessions_Creation_PageObjects WitnessPrepSession=new Client_Non_Zoom_Sessions_Creation_PageObjects(driver);

		login.Clientlogin();
		WitnessPrepSession.ClickOnCase();
		WitnessPrepSession.ClickOnAddSession();
		WitnessPrepSession.ClickOnWitnessPrep();
		WitnessPrepSession.WitnessPrepSessionName();
		WitnessPrepSession.SearchIntroducingPartyName();
		WitnessPrepSession.ClickOnIntroducingPartyName();
		WitnessPrepSession.EnterLocation();
		WitnessPrepSession.ClearSessionPasscode();
		WitnessPrepSession.EnterSessionPasscode();
		WitnessPrepSession.ScrollDown();
		WitnessPrepSession.ClickOnSave();
		WitnessPrepSession.ClickOnAddfolder();
		WitnessPrepSession.EnterFolderName();
		WitnessPrepSession.ClickOnSaveFolder();
		WitnessPrepSession.FolderValidation();
		WitnessPrepSession.ClickOnAddDocuments();
		WitnessPrepSession.UploadDocuments();
		WitnessPrepSession.ClickOnClose();
		WitnessPrepSession.WitnessPrepDocumentValidation();
	}

}
