/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.test.scenarios.Client_Login;
import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Validating_Client_Case_Session_Folders_And_Member_Case_Sessions_Folders_Same_Or_not_PageObjects;

/**
 * @author MuraliKrishna.Seethalam
 *
 */

// Validating Client And Member Sessions Folders

public class Validating_Client_Case_Session_Folders_And_Member_Case_Sessions_Folders_Same_Or_Not extends BaseClass{
	@Test
	public void ValidatingClientCaseSessionFoldersAndMemberCaseSessionsFoldersSameOrNot() throws Exception {

		Validating_Client_Case_Session_Folders_And_Member_Case_Sessions_Folders_Same_Or_not_PageObjects Folders=new Validating_Client_Case_Session_Folders_And_Member_Case_Sessions_Folders_Same_Or_not_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		Client_Login ClientLogin=new Client_Login();

		//		Client login and Capturing Folder Names
		ClientLogin.Clientlogin();
		Folders.ClickOnClientCase();
		Folders.ClickOnClientSession();
		Folders.SelectAllFolders();
		Folders.CaptureClintFolders();

		//		Member login and Capturing Folder Names
		MemberLogin.Memberlogin();
		Folders.ClickOnMeberSessions();
		Folders.CaptureMemberFolders();

		//		Validating ValidatingClientCaseSessionFoldersAndMemberCaseSessionsFoldersSameOrNot
		Folders.ValidatingFolders();

	}

}
