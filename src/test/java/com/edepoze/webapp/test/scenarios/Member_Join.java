package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Member_Join_PageObjects;

// Member Joining Session Through Join Button
public class Member_Join extends BaseClass {
	@Test
	public void MemberJoin() throws Exception{
		
		WebApp_Member_Login Memberlogin=new WebApp_Member_Login();
		Member_Join_PageObjects Join = new Member_Join_PageObjects(driver);
		
		Memberlogin.Memberlogin();
		Join.ClickOnMemberSession();
		Join.CaptureMemberSessionId();
		Join.CaptureMemberPassword();	
		Join.ClickOnCases();
		Join.JoinSession();
		Join.JoinSessionValidation();
	}
	
	

}
