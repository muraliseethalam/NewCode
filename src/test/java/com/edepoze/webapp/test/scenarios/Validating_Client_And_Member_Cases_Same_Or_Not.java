/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.test.scenarios.Client_Login;
import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Validating_Client_And_Member_Cases_Same_or_Not_PageObjects;

/**
 * @author Muralikrishna.Seethalam
 *
 */

// Validating Client And Member Cases

public class Validating_Client_And_Member_Cases_Same_Or_Not extends BaseClass{
	@Test
	public void ValidatingClientAndMemberCasesSameOrNot() throws Exception {
		
		Validating_Client_And_Member_Cases_Same_or_Not_PageObjects ValidatingCases=new Validating_Client_And_Member_Cases_Same_or_Not_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		Client_Login ClientLogin=new Client_Login();

		//		Client login and Capturing Cases
		ClientLogin.Clientlogin();
		ValidatingCases.CapturingClientCases();

		//		Member login and Capturing Cases
		MemberLogin.Memberlogin();
		ValidatingCases.CapturingMemberCases();

		//		ValidatingClientAndMemberCasesSameOrNot.
		ValidatingCases.ValidatingClientAndMemberCasesSameOrNot();

	}

}
