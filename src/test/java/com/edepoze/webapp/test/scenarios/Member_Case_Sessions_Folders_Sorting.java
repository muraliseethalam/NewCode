/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_Case_Sessions_Folders_Sorting_PageObjects;

/**
 * @author Muralikrishna.Seethalam
 *
 */

// Case Sessions Folders Sorting
public class Member_Case_Sessions_Folders_Sorting extends BaseClass{
	@Test
	public void MemberCaseSessionsFoldersSorting() throws Exception {

		Member_Case_Sessions_Folders_Sorting_PageObjects FolderSorting=new Member_Case_Sessions_Folders_Sorting_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();

		MemberLogin.Memberlogin();
		FolderSorting.ClickOnSession();
		FolderSorting.Validationforsorting();


	}

}
