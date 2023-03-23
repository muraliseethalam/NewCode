package com.edepoze.client.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Case_Edit_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

/**
 * @author MuraliSeethalam
 */


// Editing Case
public class Client_Case_Edit extends BaseClass{
	@Test
	public void ClientCaseEdit() throws Exception {
		
		Client_Login login=new Client_Login();
		Client_Case_Edit_PageObjects EditCaseName=new Client_Case_Edit_PageObjects(driver);
		login.Clientlogin();
		EditCaseName.MouseMove();
		EditCaseName.ClickOnEdit();
		EditCaseName.ClearName();
		EditCaseName.EnterCaseName();
		EditCaseName.ScrollDown();
		EditCaseName.ClickOnSave();
		EditCaseName.ValidationForEditScenario();	
	}
}
