package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Folder_Single_Document_Downalod_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Downloading Single Documents

public class Client_Case_Folder_Single_Document_Download_Validation extends BaseClass{

	@Test
	public void CaseFolderDocumnetsSingleDocumentDownloadValidation() throws Exception{
		Client_Login login=new Client_Login();
		Client_Case_Folder_Single_Document_Downalod_Validation_PageObjects DocumentDownload=new Client_Case_Folder_Single_Document_Downalod_Validation_PageObjects(driver);

		login.Clientlogin();
		DocumentDownload.ClickOnCase();
		DocumentDownload.ClickOnCaseFolder();
		DocumentDownload.ClickOnDeleteFolder();
		DocumentDownload.ClickOnDocument();
		DocumentDownload.ScrollDown();
		DocumentDownload.ClickOnDownload();
		DocumentDownload.WaituntilDownloed();
		DocumentDownload.ValidatingUIAndDownloadedDocumentsAreSameOrNot();

	}
}