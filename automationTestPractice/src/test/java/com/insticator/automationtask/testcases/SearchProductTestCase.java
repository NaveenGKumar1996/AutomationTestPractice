package com.insticator.automationtask.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.insticator.automationtask.pages.HomePage;
import com.insticator.automationtask.pages.SearchPage;
import com.insticator.automationtask.pages.SignInPage;
import com.insticator.automationtask.pages.WomensPage;
import com.insticator.automationtask.testbase.BaseTest;

public class SearchProductTestCase extends BaseTest {
	
	@Test(priority = 1)
	public void seachProductAndValidate() {
		
		test = extent.createTest("Search Product", "Search Product And Validate it's available");
				
		SignInPage signInPage = new SignInPage(driver, test);
		HomePage homePage = new HomePage(driver, test);
		WomensPage womensPage = new WomensPage(driver, test);
		SearchPage searchPage = new SearchPage(driver, test);
		
		//Login
		homePage.clickSignIn();
		signInPage.headerVerification();
		signInPage.logIn();
		
		//Search product based on it's name and validate
		womensPage.womensTShirt();
		womensPage.mouseHoverProduct();
		searchPage.selectProduct();
		searchPage.searchProductByName();
		womensPage.mouseHoverProduct();
		searchPage.selectProduct();
		searchPage.validateSearchedProduct();
		
		//SignOut
		homePage.clickSignOut();
		
	}

}
