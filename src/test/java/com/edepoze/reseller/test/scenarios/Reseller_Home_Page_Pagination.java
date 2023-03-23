package com.edepoze.reseller.test.scenarios;
import org.testng.annotations.Test;

import com.edepoze.reseller.pageobjects.Reseller_Home_Page_Pagination_PageObjects;
import com.edepoze.utilitifiles.BaseClass;


// Reseller Home Page Pagination
public class Reseller_Home_Page_Pagination extends BaseClass {
	@Test
	public void ResellerHomePagePagination() throws Exception {
	
		Reseller_Login login=new Reseller_Login();
		Reseller_Home_Page_Pagination_PageObjects Pagination = new Reseller_Home_Page_Pagination_PageObjects(driver);
	
		login.Resellerlogin();
		Pagination.HomePagePagination();
		
		
	}
}



