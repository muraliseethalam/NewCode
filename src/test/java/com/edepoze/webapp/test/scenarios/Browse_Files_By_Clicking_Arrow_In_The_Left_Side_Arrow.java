/**
 * 
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Browse_Files_By_Clicking_Arrow_In_The_Left_Side_Arrow_PageObjects;

/**
 * @author MuralikrishnaSeethalam
 *
 */

// Browsing Files(Left Side Arrow) After Starting Sessins
public class Browse_Files_By_Clicking_Arrow_In_The_Left_Side_Arrow extends BaseClass{
	@Test
	public void BrowseFilesByClickingArrowInTheLeftSideArrow() throws Exception {
		
	WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
	Browse_Files_By_Clicking_Arrow_In_The_Left_Side_Arrow_PageObjects FilesAandDocuments=new Browse_Files_By_Clicking_Arrow_In_The_Left_Side_Arrow_PageObjects(driver);
	
	MemberLogin.Memberlogin();
	FilesAandDocuments.ClickOnMemberSession();
	FilesAandDocuments.ClickOnIntroduceDocumentsFolder();
	FilesAandDocuments.CapturingFolderNames();
	FilesAandDocuments.CapturingDocumentNames();
	FilesAandDocuments.ClickOnPresentationDocumentsFolder();
	FilesAandDocuments.WaitUnitlDocumnetload();
	FilesAandDocuments.ClickOnLeftSideArrow();
	FilesAandDocuments.CapturingLeftsideFolderName();
	FilesAandDocuments.CapturingLeftsideDocumentsName();
	FilesAandDocuments.ValidationFolderandDocuments();
	
	
	
	
	}
}
