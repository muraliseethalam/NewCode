package com.edepoze.client.test.scenarios;


import org.testng.annotations.Test;
import com.edepoze.client.pageobjects.Client_Add_New_Case_PageObjects;
import com.edepoze.client.pageobjects.Client_Non_Zoom_Sessions_Creation_PageObjects;
import com.edepoze.utilitifiles.BaseClass;


// Documents Validation
public class Client_Add_New_Case_For_Documents_Validation extends BaseClass {
	@Test(invocationCount = 1)
	public void ClientAdd_NewCase() throws Exception {
		
		Client_Login login = new Client_Login();
		Client_Add_New_Case_PageObjects AddNewCase = new Client_Add_New_Case_PageObjects(driver);
		Client_Non_Zoom_Sessions_Creation_PageObjects DepositionSession = new Client_Non_Zoom_Sessions_Creation_PageObjects(driver);
		
		login.Clientlogin();
		AddNewCase.ClickOnAddNewcase();
		AddNewCase.EnterCaseName2();
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
		AddNewCase.CaptureScreenshot();


		DepositionSession.ClickOnMATZCase();
		DepositionSession.ClickOnAddSession();
		DepositionSession.ClickOnDeposition();
		DepositionSession.EnterDepositionName();
		DepositionSession.Entervolume();
		DepositionSession.SearchIntroducingPartyName();
		DepositionSession.ClickOnIntroducingPartyName();
		DepositionSession.SelectOnCourtReportingFirmName();
		DepositionSession.EnterLocation();
		DepositionSession.ClearSessionPasscode();
		DepositionSession.EnterSessionPasscode();
		DepositionSession.ScrollDown();
		DepositionSession.ClickOnSave();
		DepositionSession.ClickOnAddfolder();
		DepositionSession.EnterFolderName();
		DepositionSession.ClickOnSaveFolder();
		DepositionSession.FolderValidation();

	}

}
