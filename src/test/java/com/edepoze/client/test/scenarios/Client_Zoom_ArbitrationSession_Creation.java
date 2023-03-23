package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Zoom_Arbitration_Session_Mail_Validation_PageObjects;
import com.edepoze.client.pageobjects.Client_Zoom_Sessions_Creations_PageObjects_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Zoom Arbitration Session Creation

public class Client_Zoom_ArbitrationSession_Creation extends BaseClass{
	@Test
	public void ZoomArbitrationSessionCreation() throws Exception {

		Client_Login login=new Client_Login();
		Client_Zoom_Sessions_Creations_PageObjects_PageObjects ZoomArbitrationSession=new Client_Zoom_Sessions_Creations_PageObjects_PageObjects(driver);

		login.Clientlogin();
		ZoomArbitrationSession.ClickOnCase();
		ZoomArbitrationSession.ClickOnAddSession();
		ZoomArbitrationSession.ClickOnArbitration();
		ZoomArbitrationSession.ClearDepositionName();
		ZoomArbitrationSession.EnterArbitrationName();
		ZoomArbitrationSession.SearchIntroducingPartyName();
		ZoomArbitrationSession.ClickOnIntroducingPartyName();
		ZoomArbitrationSession.EnterLocation();
		ZoomArbitrationSession.ScrollDown();
		ZoomArbitrationSession.ClearSessionPasscode();
		ZoomArbitrationSession.EnterSessionPasscode();
		ZoomArbitrationSession.ClicOnScheduleaVideoConference();
		ZoomArbitrationSession.EnterMeetingsHostEmail();
		ZoomArbitrationSession.EnterMeetingRegistrantsEmail();
		ZoomArbitrationSession.AgainSearchIntroducingPartyName();
		ZoomArbitrationSession.ClickOnSave();
		ZoomArbitrationSession.ClickOnAddfolder();
		ZoomArbitrationSession.EnterZoomFolderName();
		ZoomArbitrationSession.ClickOnSaveFolder();
		ZoomArbitrationSession.FolderValidation();
		ZoomArbitrationSession.ClickOnAddDocuments();
		ZoomArbitrationSession.UploadDocuments();
		ZoomArbitrationSession.ClickOnClose();
		ZoomArbitrationSession.DocumentValidation();

		//**Email Verification for zoom meeting**/

		Client_Zoom_Arbitration_Session_Mail_Validation_PageObjects MailValidation=new Client_Zoom_Arbitration_Session_Mail_Validation_PageObjects(driver);
		MailValidation.GetLink();
		MailValidation.SessionIdValidation();
		MailValidation.ClickOnArbitrationSessionLink();
		ZoomArbitrationSession.MeetingLinkValidation();
	


	}
}
