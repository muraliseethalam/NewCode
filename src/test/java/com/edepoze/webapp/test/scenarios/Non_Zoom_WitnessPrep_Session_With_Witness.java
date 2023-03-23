/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.NonZoom_WitnessPrep_Session_With_Witness_PageObjects;

/**
 * @author Muralikrishna.Seethalam
 *
 */
// Non Zoom WitnessPrep Session With Witness

public class Non_Zoom_WitnessPrep_Session_With_Witness extends BaseClass{
	@Test
	public void WitnessPrepSessionWithWitness() throws Exception {
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		NonZoom_WitnessPrep_Session_With_Witness_PageObjects JoinWitness=new NonZoom_WitnessPrep_Session_With_Witness_PageObjects(driver);

		MemberLogin.Memberlogin();
		JoinWitness.ClickOnNonZoomDepositionSession();
		JoinWitness.ClickOnIntroduceDocumentsFolder();
//		JoinWitness.BegeinSession();
//		JoinWitness.IntroduceDocuments();
		JoinWitness.CaptureSessionIDPassword();
		JoinWitness.Witnesslogin();
		JoinWitness.ClickJoin();
		JoinWitness.EnterSessionID();
		JoinWitness.EnterWitnessName();
		JoinWitness.ClickOnLogin();
		JoinWitness.AccepetWitnesslogin();
		JoinWitness.ClickOnOfficialExhibits();
		JoinWitness.VerifyIntorduceDocuments();
//		JoinWitness.WitenessAnnotationChangeDocuments();
		JoinWitness.VeryfingWitnessSavedDocuments();
		JoinWitness.DocumentsPresentationFolder();
		JoinWitness.DocumentsPresentation();
		JoinWitness.AnnotationsValidation();
		JoinWitness.Driverquit();




	}





}
