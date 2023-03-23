package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Folder_Multiple_Document_Downalod_Validation_PageOjects;
import com.edepoze.utilitifiles.BaseClass;

// Downloading Multiple Documents
public class Client_Case_Folder_Multiple_Document_Download_Validation extends BaseClass{
	@Test
	public void CaseFolderMultipleDocumentDownloadValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Folder_Multiple_Document_Downalod_Validation_PageOjects DownloadMultipleDocuments=new Client_Case_Folder_Multiple_Document_Downalod_Validation_PageOjects(driver);

		login.Clientlogin();
		DownloadMultipleDocuments.ClickOnCase();
		DownloadMultipleDocuments.ClickOnCaseFolder();
		DownloadMultipleDocuments.ClickOnDeleteFolder();
		DownloadMultipleDocuments.ClickOnSelectAll();
		DownloadMultipleDocuments.ScrollDown();
		DownloadMultipleDocuments.ClickOnDownload();
		DownloadMultipleDocuments.WaitUntilDownload();
		DownloadMultipleDocuments.UnzipDownloadDocuments();
		DownloadMultipleDocuments.ValidatingUIAndDownloadedDocumentsAreSameOrNot();

	}
}