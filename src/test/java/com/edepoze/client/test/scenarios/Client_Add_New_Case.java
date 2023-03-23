package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Add_New_Case_PageObjects;
import com.edepoze.utilitifiles.BaseClass;


// Adding New Case
public class Client_Add_New_Case extends BaseClass{
	@Test(invocationCount=1)
	public void ClientAddNewCase() throws Exception {

		Client_Login login=new Client_Login();
		Client_Add_New_Case_PageObjects AddNewCase=new Client_Add_New_Case_PageObjects(driver);
		
		login.Clientlogin();
		AddNewCase.ClickOnAddNewcase();
		AddNewCase.EnterCaseName();
		AddNewCase.CaseNumber();
		AddNewCase.searchAssignCaseManagers();
		AddNewCase.SelectAssignCaseManagers();
		AddNewCase.EnterclientFirstName();
		AddNewCase.EnterclientLastName();
		AddNewCase.EnterclientPhoneby();
		AddNewCase.EnterclientEmail();
		AddNewCase.EnterclientAddress2();
		AddNewCase.ScrollDown();
		AddNewCase.ScrollUp();
		AddNewCase.RemoveAssignCaseManager();
		AddNewCase.searchAssignCaseManagers();
		AddNewCase.SelectAssignCaseManagers();
		AddNewCase.ScrollDown();
		AddNewCase.ClickOnSave();
		AddNewCase.CheckTheCaseCreatedOrNot();


	}

}
