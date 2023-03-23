package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;
import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_CaseSession_Documents_Download_Validation_PageObjects;

// Downloading Case Sessions Dosuments

public class Member_CaseSession_Documents_Download_Validation extends BaseClass {

	@Test
	public void MemberCaseSessionDocumentsDownloadValidation() throws Exception{



		WebApp_Member_Login Memberlogin=new WebApp_Member_Login();
		Member_CaseSession_Documents_Download_Validation_PageObjects CaseSessionDocuments=new Member_CaseSession_Documents_Download_Validation_PageObjects(driver);

		Memberlogin.Memberlogin();
		CaseSessionDocuments.ClickOnMemberSession();
		CaseSessionDocuments.ClickOnMemberFolder();
		CaseSessionDocuments.MemberCaseSessionDocumentsCapture();
		CaseSessionDocuments.ClickOnDownload();
		CaseSessionDocuments.WaitUntilDownload();
		CaseSessionDocuments.UnzipDownloadDocuments();
		CaseSessionDocuments.ValidatingUIAndDownloadedDocuments();


	}
}
