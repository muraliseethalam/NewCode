/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_Join_Active_Seesion_PageObects;

/**
 * @author Muralikrishna.Seethalam
 *
 */

// Co-Member Joining Active Session
public class Member_Join_Active_Seesion extends BaseClass {
	
	@Test
	public void MemberJoinActiveSeesion() throws Exception {
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		Member_Join_Active_Seesion_PageObects AnotherMemberlogin=new Member_Join_Active_Seesion_PageObects(driver);
		
		MemberLogin.Memberlogin();
		AnotherMemberlogin.ClickOnNonZoomDepositionSession();
		AnotherMemberlogin.ClickOnIntroduceDocumentsFolder();
		AnotherMemberlogin.BegeinSession();
		AnotherMemberlogin.CaptureSessionIDPassword();
		
		AnotherMemberlogin.MemberLogin();
		AnotherMemberlogin.Enterusername();
		AnotherMemberlogin.Enterpassword();
		AnotherMemberlogin.EnterSessionId();
		AnotherMemberlogin.EnterSessionPassword();
		AnotherMemberlogin.clickonlogin();
		AnotherMemberlogin.ClickOnCreateNew();
		AnotherMemberlogin.ClickOnCreateNew();
		AnotherMemberlogin.ValidatingMemberlogin();
		AnotherMemberlogin.Driverquit();
		
	}

}
