package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Folders_Folder_Download_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Downloading Case Folder

public class Client_Folder_Of_Case_Folder_Download_Validation extends BaseClass{
	@Test
	public void ClientFolderOfCaseFolderDownloadValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folders_Folder_Download_Validation_PageObjects FolderDownload=new Client_Case_Folders_Folder_Download_Validation_PageObjects(driver);

		login.Clientlogin();
		FolderDownload.ClickOnCase();
		FolderDownload.ClickOnCaseFolder();
		FolderDownload.ClickOnCopyFolder();
		FolderDownload.ScrollDown();
		FolderDownload.ClickOnDownload();
		FolderDownload.WaitUntilDownload();
		FolderDownload.UnzipDownloadDocuments();
		FolderDownload.ValidatingUIAndDownloadedDocumentsAreSameOrNot();

	}
}