package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Non_Zoom_Sessions_Creation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Non Zoom Arbitration Session Creation

public class Client_Non_Zoom_ArbitrationSession_Creation extends BaseClass {

	@Test(priority=4)
	public void NonZoomArbitrationSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Non_Zoom_Sessions_Creation_PageObjects ArbitrationSession=new Client_Non_Zoom_Sessions_Creation_PageObjects(driver);

		login.Clientlogin();
		ArbitrationSession.ClickOnCase();
		ArbitrationSession.ClickOnAddSession();
		ArbitrationSession.ClickOnArbitration();
		ArbitrationSession.ClearDepositionName();
		ArbitrationSession.ArbitrationSessionName();
		ArbitrationSession.SearchIntroducingPartyName();
		ArbitrationSession.ClickOnIntroducingPartyName();
		ArbitrationSession.EnterLocation();
		ArbitrationSession.ClearSessionPasscode();
		ArbitrationSession.EnterSessionPasscode();
		ArbitrationSession.ScrollDown();
		ArbitrationSession.AgainSearchIntroducingPartyName();
		ArbitrationSession.ClickOnSave();
		ArbitrationSession.ClickOnAddfolder();
		ArbitrationSession.EnterFolderName();
		ArbitrationSession.ClickOnSaveFolder();
		ArbitrationSession.FolderValidation();
		ArbitrationSession.ClickOnAddDocuments();
		ArbitrationSession.UploadDocuments();
		ArbitrationSession.ClickOnClose();	
		ArbitrationSession.ArbitrationDocumentValidation();




	}
}
