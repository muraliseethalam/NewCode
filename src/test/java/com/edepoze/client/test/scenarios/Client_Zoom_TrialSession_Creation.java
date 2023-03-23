package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Zoom_Sessions_Creations_PageObjects_PageObjects;
import com.edepoze.client.pageobjects.Client_Zoom_Trial_Session_Mail_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Zoom Trial Session Creation

public class Client_Zoom_TrialSession_Creation extends BaseClass {
	@Test
	public void ZoomTrialSessionCreation() throws Exception {

		Client_Login login = new Client_Login();
		Client_Zoom_Sessions_Creations_PageObjects_PageObjects ZoomTrialSession = new Client_Zoom_Sessions_Creations_PageObjects_PageObjects(driver);
		
		login.Clientlogin();
		ZoomTrialSession.ClickOnCase();
		ZoomTrialSession.ClickOnAddSession();
		ZoomTrialSession.ClickOnTrial();
		ZoomTrialSession.ClearDepositionName();
		ZoomTrialSession.EnterTrialName();
		ZoomTrialSession.SearchIntroducingPartyName();
		ZoomTrialSession.ClickOnIntroducingPartyName();
		ZoomTrialSession.EnterLocation();
		ZoomTrialSession.ScrollDown();
		ZoomTrialSession.ClearSessionPasscode();
		ZoomTrialSession.EnterSessionPasscode();
		ZoomTrialSession.ClicOnScheduleaVideoConference();
		ZoomTrialSession.EnterMeetingsHostEmail();
		ZoomTrialSession.EnterMeetingRegistrantsEmail();
		ZoomTrialSession.AgainSearchIntroducingPartyName();
		ZoomTrialSession.ClickOnSave();
		ZoomTrialSession.ClickOnAddfolder();
		ZoomTrialSession.EnterZoomFolderName();
		ZoomTrialSession.ClickOnSaveFolder();
		ZoomTrialSession.FolderValidation();
		ZoomTrialSession.ClickOnAddDocuments();
		ZoomTrialSession.UploadDocuments();
		ZoomTrialSession.ClickOnClose();
		ZoomTrialSession.DocumentValidation();

		// **Email Verification for zoom meeting**/

		Client_Zoom_Trial_Session_Mail_Validation_PageObjects MailValidation = new Client_Zoom_Trial_Session_Mail_Validation_PageObjects(driver);
		MailValidation.GetLink();
		MailValidation.SessionIdValidation();
		MailValidation.ClickOnArbitrationSessionLink();
		ZoomTrialSession.MeetingLinkValidation();

	}
}
