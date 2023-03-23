package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Case_Session_Multiple_Documnets_Download_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Downloading Multiple Documents

public class Client_Case_Session_Multiple_Documents_Download_Validation extends BaseClass {
	@Test
	public void CaseSessionMultipleDocumentsDownloadValidation() throws Exception{

		Client_Login login=new Client_Login();
		Case_Session_Multiple_Documnets_Download_Validation_PageObjects Document=new Case_Session_Multiple_Documnets_Download_Validation_PageObjects(driver);
		
		login.Clientlogin();
		Document.ClickOnCase();
		Document.ClickOnSession();
		Document.ClickOnFolder();
		Document.ClickOnSelectAll();
		Document.ScroollDown();
		Document.ClickOnDownload();
		Document.WaitUntilDownload();
		Document.UnzipDownloadDocuments();
		Document.ValidatingUIAndDownloadedDocumentsAreSameOrNot();


	}

}
