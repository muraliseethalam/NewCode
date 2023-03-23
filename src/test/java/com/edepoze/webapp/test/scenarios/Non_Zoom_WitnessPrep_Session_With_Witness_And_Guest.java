/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.NonZoom_WitnessPrep_Session_With_Witness_And_Guest_PageObjects;

/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Non Zoom WitnessPrep Session With Witness And Guest

public class Non_Zoom_WitnessPrep_Session_With_Witness_And_Guest extends BaseClass{
	@Test
	public void WitnessPrepSessionWithWitnessAndGuest() throws Exception {
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		NonZoom_WitnessPrep_Session_With_Witness_And_Guest_PageObjects JoinWitness=new NonZoom_WitnessPrep_Session_With_Witness_And_Guest_PageObjects(driver);

		
//		Member Login
		MemberLogin.Memberlogin();
		JoinWitness.ClickOnNonZoomDepositionSession();
		JoinWitness.ClickOnIntroduceDocumentsFolder();
		JoinWitness.BeginSession();
		JoinWitness.IntroduceDocuments();
		JoinWitness.CaptureSessionIDPassword();
//		Witness Login
		JoinWitness.Witnesslogin();
		JoinWitness.ClickJoin();
		JoinWitness.EnterSessionID();
		JoinWitness.EnterWitnessName();
		JoinWitness.ClickOnLogin();
		JoinWitness.ClickOnSkip();
		JoinWitness.AccepetWitnesslogin();
		JoinWitness.ClickOnOfficialExhibits();
		JoinWitness.VerifyIntorduceDocuments();
		JoinWitness.WitenessAnnotationChangeDocuments();
		JoinWitness.VeryfingWitnessSavedDocuments();
//		Guest Login
		JoinWitness.Guestlogin();
		JoinWitness.EnterGuestSessionID();
		JoinWitness.EnterGuestPassword();
		JoinWitness.EnterGuestName();
		JoinWitness.EnterGuestEmailId();
		JoinWitness.ClickOnGuestlogin();
		JoinWitness.ClickOnOfficialExhibitFolder();
		JoinWitness.VerifyIntorduceGuestDocuments();
		JoinWitness.DocumentsPresentationFolder();
		JoinWitness.DocumentsPresentation();
		JoinWitness.AnnotationsValidation();
		JoinWitness.Driverquit();




	}





}
