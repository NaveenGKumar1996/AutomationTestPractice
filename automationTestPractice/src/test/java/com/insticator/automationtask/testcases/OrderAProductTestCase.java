package com.insticator.automationtask.testcases;

import org.testng.annotations.Test;

import com.insticator.automationtask.pages.HomePage;
import com.insticator.automationtask.pages.ShoppingCartAndOrderPage;
import com.insticator.automationtask.pages.SignInPage;
import com.insticator.automationtask.pages.WomensPage;
import com.insticator.automationtask.testbase.BaseTest;

public class OrderAProductTestCase extends BaseTest {

	@Test(priority = 1)
	public void productPurchaseAndValidate() {
		test = extent.createTest("Order A Product", "Order a product and validate it's ordered");
		
		SignInPage signInPage = new SignInPage(driver, test);
		HomePage homePage = new HomePage(driver, test);
		WomensPage womensPage = new WomensPage(driver, test);
		ShoppingCartAndOrderPage shoppingCartPage = new ShoppingCartAndOrderPage(driver, test);
		
		//Login
		homePage.clickSignIn();
		signInPage.headerVerification();
		signInPage.logIn();
		
		//Order the product based on your wish
		womensPage.womensTShirt();
		womensPage.mouseHoverProduct();
		womensPage.addToCartWithChanges();
		
		//Checking Cart, then Payment and check order summary
		shoppingCartPage.shoppingCartSummary();
		shoppingCartPage.addressBox();
		shoppingCartPage.shippingBox();
		shoppingCartPage.payViaChequeAndCheckOrderSummary();
		
		//SignOut
		homePage.clickSignOut();
		
		
	}
}
