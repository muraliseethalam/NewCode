package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Zoom_Deposition_Session_Mail_Validation_PageObjects;
import com.edepoze.client.pageobjects.Client_Zoom_Sessions_Creations_PageObjects_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Zoom Deposition Session Creation

public class Client_Zoom_Deposition_Sessions_Creation extends BaseClass{
	@Test(priority=1)
	public void ZoomDepositionSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Zoom_Sessions_Creations_PageObjects_PageObjects ZoomDepositionSession=new Client_Zoom_Sessions_Creations_PageObjects_PageObjects(driver);

		login.Clientlogin();
		ZoomDepositionSession.ClickOnCase();
		ZoomDepositionSession.ClickOnAddSession();
		ZoomDepositionSession.ClickOnDeposition();
		ZoomDepositionSession.EnterDepositionName();
		ZoomDepositionSession.Entervolume();
		ZoomDepositionSession.SearchIntroducingPartyName();
		ZoomDepositionSession.ClickOnIntroducingPartyName();
		ZoomDepositionSession.SelectOnCourtReportingFirmName();
		ZoomDepositionSession.EnterLocation();
		ZoomDepositionSession.ScrollDown();
		ZoomDepositionSession.ClearSessionPasscode();
		ZoomDepositionSession.EnterSessionPasscode();
		ZoomDepositionSession.ClicOnScheduleaVideoConference();
		ZoomDepositionSession.EnterMeetingsHostEmail();
		ZoomDepositionSession.EnterMeetingRegistrantsEmail();
		ZoomDepositionSession.ScrollDown();
		ZoomDepositionSession.ClickOnSave();
		ZoomDepositionSession.ClickOnAddfolder();
		ZoomDepositionSession.EnterZoomFolderName();
		ZoomDepositionSession.ClickOnSaveFolder();
		ZoomDepositionSession.FolderValidation();
		ZoomDepositionSession.ClickOnAddDocuments();
		ZoomDepositionSession.UploadDocuments();
		ZoomDepositionSession.ClickOnClose();
		ZoomDepositionSession.DocumentValidation();


		//**Email Verification for zoom meeting**//
		Client_Zoom_Deposition_Session_Mail_Validation_PageObjects MailValidaiton=new Client_Zoom_Deposition_Session_Mail_Validation_PageObjects(driver);
		MailValidaiton.GetLink();
		MailValidaiton.SessionIdValidation();
		MailValidaiton.ClickOnArbitrationSessionLink();
		ZoomDepositionSession.MeetingLinkValidation();


	}
}
