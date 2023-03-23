package com.edepoze.client.test.scenarios;
import org.testng.annotations.Test;

import com.edepoze.client.pageobjects.Client_Home_Page_Sorting_PageObjects;
import com.edepoze.utilitifiles.BaseClass;

/**
 * @author MuraliSeethalam
 *
 */
public class Client_Home_Page_Sorting extends BaseClass{
	
	@Test
	public void ClientHomePageSorting() throws Exception {
		
		Client_Login login=new Client_Login();
		Client_Home_Page_Sorting_PageObjects Sorting = new Client_Home_Page_Sorting_PageObjects(driver);
		
		login.Clientlogin();
		Sorting.ClientHomePageSorting();
		
	
}
}