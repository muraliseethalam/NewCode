package com.edepoze.reseller.test.scenarios;
import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_Home_Page_Sorting_Test_PageObjects;
import com.edepoze.utilitifiles.BaseClass;
/*
 * @author MuraliSeethalam
 *
 */
// Reseller Home Page Sorting
public class Reseller_Home_Page_Sorting_Test extends BaseClass{
	
	@Test
	public void ResellerHomePageSortingTest() throws Exception {
		Reseller_Login login=new Reseller_Login();
		Reseller_Home_Page_Sorting_Test_PageObjects Sorting =new Reseller_Home_Page_Sorting_Test_PageObjects(driver);
		
		login.Resellerlogin();
		Sorting.HomePageSortingValidation();
	
	}
		
}




