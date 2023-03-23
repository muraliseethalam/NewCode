/**
 * 
 */
package com.edepoze.webapp.test.scenarios;

import org.testng.annotations.Test;

import com.edepoze.utilitifiles.BaseClass;
import com.edepoze.webapp.pageobjects.Validating_Annotations_PageObjects;

/**
 * @author Muralikrishna.Seethalam
 *
 */

// Validating All Annotations

public class Validating_Annotations extends BaseClass{
	@Test
	public void ValidatingAnnotations() throws Exception {
		Validating_Annotations_PageObjects Annotations=new Validating_Annotations_PageObjects(driver);
		WebApp_Member_Login MemberLogin=new WebApp_Member_Login();


		//		Arrow Color Annotations
		MemberLogin.Memberlogin();
		Annotations.ClickOnSession();
		Annotations.ClickOnFolder();
		Annotations.ClickOnDocument();
		Annotations.ArrowColorAnnotations();

		//		Highlight Color Annotations
		Annotations.HighlightColorAnnotations();

		//		Pencil Color Annotations
		Annotations.PenciltColorAnnotations();

		//		Note Color Annotations
		Annotations.NoteAnnotations();

		//		Callout Annotations
		Annotations.CalloutAnnotations();

		//		Erase Annotations	
		Annotations.EraseAnnotations();

		//		Undo Annotations	
		Annotations.UndoAnnotations();

		//		Annotations Validation
		Annotations.AnnotationsValidation();

		//		ShowThumbnails Annotations
		Annotations.ShowThumbnailsAnnotations();
		
//		Pagenumber Validation 
		Annotations.PageNumber();
		Annotations.EnterPageNumber();
		Annotations.GotoPage();
		Annotations.PageNumberValidation();
		
//		Email Validation
		Annotations.ClikOnEmail();
		Annotations.EnterToEmailId();
		Annotations.ClickOnSend();
		Annotations.main(null);

//		Zoomin and ZoomOut Validation
		Annotations.ZoominZoomOut();







	}




}
