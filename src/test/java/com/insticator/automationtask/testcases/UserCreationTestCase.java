package com.insticator.automationtask.testcases;


import org.testng.annotations.Test;

import com.insticator.automationtask.pages.AccountCreationPage;
import com.insticator.automationtask.pages.HomePage;
import com.insticator.automationtask.pages.SignInPage;
import com.insticator.automationtask.testbase.BaseTest;

public class UserCreationTestCase extends BaseTest {
	
	@Test(priority = 1)
	public void createUserAndValidate() {
		test = extent.createTest("Create User", "Create User and Validate User was created");
		
		AccountCreationPage accountCreationPage = new AccountCreationPage(driver, test);
		HomePage homePage = new HomePage(driver, test);
		SignInPage signInPage = new SignInPage(driver, test);
		
		//Create User and Sign In
		homePage.clickSignIn();
		signInPage.headerVerification();
		signInPage.createAnEmailForAccount();
		accountCreationPage.accountDetailsFillAndRegister();
		signInPage.successAccountCreation();
		
		//Sign Out
		homePage.clickSignOut();
		signInPage.headerVerification();
	}
	
	
}
