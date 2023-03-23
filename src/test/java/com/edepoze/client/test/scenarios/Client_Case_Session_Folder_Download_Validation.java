package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Folder_Download_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Downloading Session Folder

public class Client_Case_Session_Folder_Download_Validation extends BaseClass{

	@Test
	public void CaseSessionFolderDownloadValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Session_Folder_Download_Validation_PageObjects FolderDownload=new Client_Case_Session_Folder_Download_Validation_PageObjects(driver);

		login.Clientlogin();
		FolderDownload.ClickOnCase();
		FolderDownload.ClickOnSession();
		FolderDownload.ClickOnFolder();
		FolderDownload.ScroollDown();
		FolderDownload.ClickOnDownload();
		FolderDownload.WaitUntilDownload();
		FolderDownload.UnzipDownloadDocuments();
		FolderDownload.ValidatingUIAndDownloadedDocumentsAreSameOrNot();
	}
}
