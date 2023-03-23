/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_Cases_Sorting_PageObjects;

/**
 * @author Muralikrishna.Seethalam
 *
 */

// Cases Sorting

public class Member_Cases_Sorting extends BaseClass{
	@Test
	public void MemberCasesSorting() throws Exception {

		Member_Cases_Sorting_PageObjects Sorting= new Member_Cases_Sorting_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();

		MemberLogin.Memberlogin();
		Sorting.Validationforsorting();
	}

}
