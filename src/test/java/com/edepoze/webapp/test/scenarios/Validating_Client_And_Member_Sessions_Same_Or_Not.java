/**
 * 
 */
package com.edepoze.webapp.test.scenarios;
/**
 * @author Muralikrishna.Seethalam
 *
 */
import org.testng.annotations.Test;
import com.edepoze.client.test.scenarios.Client_Login;
import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Validating_Client_And_Member_Sessions_Same_Or_Not_PageObjects;

// Validating Client And Member Sessions

public class Validating_Client_And_Member_Sessions_Same_Or_Not extends BaseClass{
	@Test
	public void ValidatingClientAndMemberCaseSessionSameOrNot() throws Exception {

		Validating_Client_And_Member_Sessions_Same_Or_Not_PageObjects ValidatingSessions=new Validating_Client_And_Member_Sessions_Same_Or_Not_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		Client_Login ClientLogin=new Client_Login();

		//		Client login and Capturing Case Sessions
		ClientLogin.Clientlogin();
		ValidatingSessions.ClikOnCase();
		ValidatingSessions.CapturingClientCaseSesionsNames();

		//		Member login and Capturing Cases
		MemberLogin.Memberlogin();
		ValidatingSessions.CapturingMemberCaseSessionsName();

		//		ValidatingClientAndMemberCasesSameOrNot.
		ValidatingSessions.ValidatingClientAndMemberCasesSessionsSameOrNot();




	}


}
