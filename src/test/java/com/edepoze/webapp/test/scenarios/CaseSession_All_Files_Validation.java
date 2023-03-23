package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.CaseSession_All_Files_Validation_PageObjects;

/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Opening All Documents

public class CaseSession_All_Files_Validation extends BaseClass {

	@Test
	public void CaseSessionAllFilesValidation() throws Exception{

		WebApp_Member_Login Memberlogin=new WebApp_Member_Login();
		CaseSession_All_Files_Validation_PageObjects Files=new CaseSession_All_Files_Validation_PageObjects(driver);

		Memberlogin.Memberlogin();
		Files.SwitchFrame();
		Files.ClickOnMemberSession();
		Files.ClickOnMemberFolder();
		Files.DocumentsValidation();

	}
}
