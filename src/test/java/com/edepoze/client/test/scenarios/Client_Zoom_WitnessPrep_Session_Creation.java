package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Zoom_Sessions_Creations_PageObjects_PageObjects;
import com.edepoze.client.pageobjects.Client_Zoom_Witness_Session_Mail_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Zoom WitnessPrep Session Creation

public class Client_Zoom_WitnessPrep_Session_Creation extends BaseClass {

	@Test
	public void ZoomWitnessPrepSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Zoom_Sessions_Creations_PageObjects_PageObjects ZoomWitnessPrepSession=new Client_Zoom_Sessions_Creations_PageObjects_PageObjects(driver);

		login.Clientlogin();
		ZoomWitnessPrepSession.ClickOnCase();
		ZoomWitnessPrepSession.ClickOnAddSession();
		ZoomWitnessPrepSession.ClickOnWitnessPrep();
		ZoomWitnessPrepSession.EnterWitnessPrepnName();
		ZoomWitnessPrepSession.SearchIntroducingPartyName();
		ZoomWitnessPrepSession.ClickOnIntroducingPartyName();
		ZoomWitnessPrepSession.EnterLocation();
		ZoomWitnessPrepSession.ScrollDown();
		ZoomWitnessPrepSession.ClearSessionPasscode();
		ZoomWitnessPrepSession.EnterSessionPasscode();
		ZoomWitnessPrepSession.ClicOnScheduleaVideoConference();
		ZoomWitnessPrepSession.EnterMeetingsHostEmail();
		ZoomWitnessPrepSession.EnterMeetingRegistrantsEmail();
		ZoomWitnessPrepSession.ClickOnSave();
		ZoomWitnessPrepSession.ClickOnAddfolder();
		ZoomWitnessPrepSession.EnterZoomFolderName();
		ZoomWitnessPrepSession.ClickOnSaveFolder();
		ZoomWitnessPrepSession.FolderValidation();
		ZoomWitnessPrepSession.ClickOnAddDocuments();
		ZoomWitnessPrepSession.UploadDocuments();
		ZoomWitnessPrepSession.ClickOnClose();
		ZoomWitnessPrepSession.DocumentValidation();


		//**Email Verification for zoom meeting**//
		Client_Zoom_Witness_Session_Mail_Validation_PageObjects MailValidation=new Client_Zoom_Witness_Session_Mail_Validation_PageObjects(driver);
		MailValidation.GetLink();
		MailValidation.SessionIdValidation();
		MailValidation.ClickOnArbitrationSessionLink();
		ZoomWitnessPrepSession.MeetingLinkValidation();

	}
}
