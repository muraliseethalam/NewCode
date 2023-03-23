package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.NonZoom_Mediation_Session_With_Witness_PageObjects;

/**
 * @author IndiraSai.Kapavarapu
 *
 */

// Non Zoom Mediation Session With Witness

public class Non_Zoom_Mediation_Session_With_Witness extends BaseClass {

	@Test

	public void MediationSessionWithWitness() throws Exception {

		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();
		NonZoom_Mediation_Session_With_Witness_PageObjects JoinWitness =new NonZoom_Mediation_Session_With_Witness_PageObjects(driver);

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
		JoinWitness.WitnessAnnotationChangeDocuments();
		JoinWitness.VerifyingWitnessSavedDocuments();
		JoinWitness.DocumentsPresentationFolder();
		JoinWitness.DocumentsPresentation();
		JoinWitness.AnnotationsValidation();
		JoinWitness.Driverquit();


	}
}






