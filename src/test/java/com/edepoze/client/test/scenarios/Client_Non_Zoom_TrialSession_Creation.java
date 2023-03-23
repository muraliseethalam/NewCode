package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Non_Zoom_Sessions_Creation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

//Non Zoom Trail Session Creation

public class Client_Non_Zoom_TrialSession_Creation extends BaseClass {
	@Test(priority=3)
	public void NonZoomTrialSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Non_Zoom_Sessions_Creation_PageObjects TrialSession=new Client_Non_Zoom_Sessions_Creation_PageObjects(driver);

		login.Clientlogin();
		TrialSession.ClickOnCase();
		TrialSession.ClickOnAddSession();
		TrialSession.ClicOnTrial();
		TrialSession.ClearDepositionName();
		TrialSession.TrialSessionName();
		TrialSession.SearchIntroducingPartyName();
		TrialSession.ClickOnIntroducingPartyName();
		TrialSession.EnterLocation();
		TrialSession.ClearSessionPasscode();
		TrialSession.EnterSessionPasscode();
		TrialSession.ScrollDown();
		TrialSession.AgainSearchIntroducingPartyName();
		TrialSession.ClickOnSave();
		TrialSession.ClickOnAddfolder();
		TrialSession.EnterFolderName();
		TrialSession.ClickOnSaveFolder();
		TrialSession.FolderValidation();
		TrialSession.ClickOnAddDocuments();
		TrialSession.UploadDocuments();
		TrialSession.ClickOnClose();
		TrialSession.TrailDocumentValidation();


	}
}
