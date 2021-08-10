package com.insticator.automationtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.insticator.automationtask.pagebase.BasePage;
import com.insticator.automationtask.repos.Locators;


public class HomePage extends BasePage {

	// OR
	@FindBy(xpath = Locators.SIGN_IN)
	private WebElement signIn;
	
	@FindBy(xpath = Locators.SIGN_OUT)
	private WebElement signOut;
	

	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	//Click SignIn Link
	public void clickSignIn() {
		isDisplayedThenActionClick(signIn, "SignIn");
	}
	
	public void clickSignOut() {
		isDisplayedThenActionClick(signOut, "SignOut");
	}

}
