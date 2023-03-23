package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Case_Session_Documnets_Single_Documents_Download_Validation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

// Downloading Single Documents

public class Client_Case_Session_Single_Document_Download_Validation extends BaseClass{

	@Test
	public void CaseSessionSingleDocumentDownloadValidation() throws Exception{

		Client_Login login=new Client_Login();
		Client_Case_Session_Documnets_Single_Documents_Download_Validation_PageObjects Document=new Client_Case_Session_Documnets_Single_Documents_Download_Validation_PageObjects(driver);

		login.Clientlogin();
		Document.ClickOnCase();
		Document.ClickOnSession();
		Document.ClickOnFolder();
		Document.ScroollDown();
		Document.ClickOnDocument();
		Document.ClickOnDownload();
		Document.WaituntilDownloed();
		Document.ValidatingUIAndDownloadedDocumentsAreSameOrNot();
	}


}
