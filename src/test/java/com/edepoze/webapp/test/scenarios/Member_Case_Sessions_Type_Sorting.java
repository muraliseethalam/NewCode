package com.edepoze.webapp.test.scenarios;
import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_Case_Sessions_Type_Sorting_PageObjects;

/**
 * @author IndiraSai Kapavarapu
 *
 */

// Cases Session Types Sorting

public class Member_Case_Sessions_Type_Sorting extends BaseClass {

	@Test
	public void MemberCaseSessionsTypeSorting() throws Exception {

		Member_Case_Sessions_Type_Sorting_PageObjects Sorting = new Member_Case_Sessions_Type_Sorting_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();

		MemberLogin.Memberlogin();
		Sorting.ClickOnType();
		Sorting.Validationforsorting();

	}
}


