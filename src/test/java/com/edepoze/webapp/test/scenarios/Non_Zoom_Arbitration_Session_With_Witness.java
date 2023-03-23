package com.edepoze.webapp.test.scenarios;
import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.NonZoom_Arbitration_Session_With_Witness_PageObjects;

/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Non Zoom Arbitration Session With Witness

public class Non_Zoom_Arbitration_Session_With_Witness extends BaseClass{
	@Test
	public void ArbitrationSessionWithWitness() throws Exception {
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		NonZoom_Arbitration_Session_With_Witness_PageObjects JoinWitness=new NonZoom_Arbitration_Session_With_Witness_PageObjects(driver);

		MemberLogin.Memberlogin();
		JoinWitness.ClickOnNonZoomDepositionSession();
		JoinWitness.ClickOnIntroduceDocumentsFolder();
		JoinWitness.BeginSession();	
		JoinWitness.IntroduceDocuments();
		JoinWitness.OfficialExhibitsDocumentsCaptureOfMember();	
		JoinWitness.WitnessLogin();
		JoinWitness.WitnessLoginValidation();
		JoinWitness.OfficialExhibitsDocumentsCaptureOfWitness();
		JoinWitness.ComparisionBetweenMarkedExibitsOfMemberAndWitness();	
		JoinWitness.WitenessAnnotationChangeDocuments();
		JoinWitness.VerifyingWitnessSavedDocuments();
		JoinWitness.DocumentsPresentationFolder();
		JoinWitness.DocumentsPresentation();
		JoinWitness.AnnotationsValidation();
		JoinWitness.Driverquit();




	}




}