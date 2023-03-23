/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.NonZoom_Trail_Session_With_Witness_PageObjects;

/**
 * @author Muralikrishna.Seethalam
 *
 */

// Non Zoom Trial Session With_Witness

public class Non_Zoom_Trial_Session_With_Witness extends BaseClass{
	@Test
	public void TrailSessionWithWitness() throws Exception {
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		NonZoom_Trail_Session_With_Witness_PageObjects JoinWitness=new NonZoom_Trail_Session_With_Witness_PageObjects(driver);

		MemberLogin.Memberlogin();
		JoinWitness.ClickOnNonZoomDepositionSession();
		JoinWitness.ClickOnIntroduceDocumentsFolder();
//		JoinWitness.BeginSession();
//		JoinWitness.IntroduceDocuments();
		JoinWitness.CaptureSessionIDPassword();
		JoinWitness.Witnesslogin();
		JoinWitness.ClickJoin();
		JoinWitness.EnterSessionID();
		JoinWitness.EnterWitnessName();
		JoinWitness.ClickOnLogin();
		JoinWitness.AcceptWitnesslogin();
		JoinWitness.ClickOnOfficialExhibits();
		JoinWitness.VerifyIntorduceDocuments();
//		JoinWitness.WitenessAnnotationChangeDocuments();
		JoinWitness.VerifyingWitnessSavedDocuments();
		JoinWitness.DocumentsPresentationFolder();
		JoinWitness.DocumentsPresentation();
		JoinWitness.AnnotationsValidation();
		JoinWitness.Driverquit();





	}





}
