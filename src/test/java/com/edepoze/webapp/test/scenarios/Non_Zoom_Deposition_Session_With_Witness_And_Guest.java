/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.NonZoom_Deposition_Session_With_Witness_And_Guest_PageObjects;


/**
 * @author Muralikrishna.Seethalam
 *
 */
// Non Zoom Deposition Session With Witness And Guest

public class Non_Zoom_Deposition_Session_With_Witness_And_Guest extends BaseClass{
	@Test
	public void DepositionSessionWithWitnessAndGuest() throws Exception {
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		NonZoom_Deposition_Session_With_Witness_And_Guest_PageObjects JoinWitness=new NonZoom_Deposition_Session_With_Witness_And_Guest_PageObjects(driver);

//		Member Login
		MemberLogin.Memberlogin();
		JoinWitness.ClickOnNonZoomDepositionSession();
		JoinWitness.ClickOnIntroduceDocumentsFolder();
		JoinWitness.BeginSession();
		JoinWitness.IntroduceDocuments();
		JoinWitness.CaptureSessionIDPassword();
		JoinWitness.Witnesslogin();
//		Witness Login
		JoinWitness.ClickJoin();
		JoinWitness.EnterSessionID();
		JoinWitness.EnterWitnessName();
		JoinWitness.ClickOnLogin();
		JoinWitness.AcceptWitnesslogin();
		JoinWitness.ClickOnOfficialExhibits();
		JoinWitness.VerifyIntroduceDocuments();
		JoinWitness.WitnessAnnotationChangeDocuments();
		JoinWitness.VeryfingWitnessSavedDocuments();
//      Guest Login
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
