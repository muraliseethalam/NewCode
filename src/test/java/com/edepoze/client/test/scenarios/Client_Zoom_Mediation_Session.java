package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Zoom_Mediation_Session_Mail_Validation_PageObjects;
import com.edepoze.client.pageobjects.Client_Zoom_Sessions_Creations_PageObjects_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Zoom Mediation Session Creation

public class Client_Zoom_Mediation_Session extends BaseClass{
	@Test(priority=5)
	public void ZoomMediationSession() throws Exception {

		Client_Login login=new Client_Login();
		Client_Zoom_Sessions_Creations_PageObjects_PageObjects ZoomMediationSession=new Client_Zoom_Sessions_Creations_PageObjects_PageObjects(driver);

		login.Clientlogin();
		ZoomMediationSession.ClickOnCase();
		ZoomMediationSession.ClickOnAddSession();
		ZoomMediationSession.ClickOnMediation();
		ZoomMediationSession.ClearDepositionName();
		ZoomMediationSession.EnterMediationnName();
		ZoomMediationSession.SearchIntroducingPartyName();
		ZoomMediationSession.ClickOnIntroducingPartyName();
		ZoomMediationSession.EnterLocation();
		ZoomMediationSession.ScrollDown();
		ZoomMediationSession.ClearSessionPasscode();
		ZoomMediationSession.EnterSessionPasscode();
		ZoomMediationSession.ClicOnScheduleaVideoConference();
		ZoomMediationSession.EnterMeetingsHostEmail();
		ZoomMediationSession.EnterMeetingRegistrantsEmail();
		ZoomMediationSession.AgainSearchIntroducingPartyName();
		ZoomMediationSession.ClickOnSave();
		ZoomMediationSession.ClickOnAddfolder();
		ZoomMediationSession.EnterZoomFolderName();
		ZoomMediationSession.ClickOnSaveFolder();
		ZoomMediationSession.FolderValidation();
		ZoomMediationSession.ClickOnAddDocuments();
		ZoomMediationSession.UploadDocuments();
		ZoomMediationSession.ClickOnClose();
		ZoomMediationSession.DocumentValidation();

		//**Email Verification for zoom meeting**/
		Client_Zoom_Mediation_Session_Mail_Validation_PageObjects MailValidation=new Client_Zoom_Mediation_Session_Mail_Validation_PageObjects(driver);
		MailValidation.GetLink();
		MailValidation.SessionIdValidation();
		MailValidation.ClickOnArbitrationSessionLink();
		ZoomMediationSession.MeetingLinkValidation();

	}
}
