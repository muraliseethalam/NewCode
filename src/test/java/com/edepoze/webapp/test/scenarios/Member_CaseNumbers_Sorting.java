package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_CaseNumbers_Sorting_PageObjects;

/**
 * @author IndiraSai Kapavarapu
 *
 */

// Case Numbers Sorting

public class Member_CaseNumbers_Sorting extends BaseClass {

	@Test
	public void MemberCaseNumbersSorting() throws Exception {

		Member_CaseNumbers_Sorting_PageObjects Sorting = new Member_CaseNumbers_Sorting_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		
		MemberLogin.Memberlogin();
		Sorting.ClickOnCaseNumber();
		Sorting.Validationforsorting();
	
}

}