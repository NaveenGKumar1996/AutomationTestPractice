package com.insticator.automationtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.insticator.automationtask.pagebase.BasePage;
import com.insticator.automationtask.repos.Locators;
import com.insticator.automationtask.util.PropUtils;


public class SignInPage extends BasePage {
	
	//WebElements  OR(Object Repos)
	
	@FindBy(className = Locators.NAVIGATION_PAGE)
	private WebElement signInHeader;
	
	@FindBy(xpath = Locators.CREATE_ACCOUNT_HEADER)
	private WebElement createAcctHeader;
	
	@FindBy(id = Locators.EMAIL_CREATE)
	private WebElement emailAddress;
	
	@FindBy(xpath = Locators.CREATE_ACCOUNT_BTN)
	private WebElement createAcctBtn;
	
	@FindBy(id = Locators.EMAIL)
	private WebElement emailLogIn;
	
	@FindBy(id = Locators.PASSWORD)
	private WebElement PasswordLogIn;
	
	@FindBy(xpath = Locators.SUBMIT)
	private WebElement signInSubmit;
	
	@FindBy(className = Locators.ACCOUNT_CREATION_SUCCESS_MESSAGE)
	private WebElement accCreationSuccessMsg;
	
	@FindBy(xpath = Locators.REGISTERED_HEADER)
	private WebElement registeredHeader;
	
	
	public SignInPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	
	public void headerVerification() {
		isDisplayed(signInHeader, "Authentication Text");
		isDisplayed(createAcctHeader, "Create An Account Header");
		isDisplayed(registeredHeader, "Already Registered?");		
	}
	

	public void createAnEmailForAccount() {
		String emailId = FakerAPI().internet().emailAddress();
		PropUtils.setProps(testData, inputFile, "Email-ID", emailId);
		isDisplayedThenEnterText(emailAddress, "Email", emailId);
		isDisplayedThenActionClick(createAcctBtn, "Create an Account Button");
		
	}
	public void successAccountCreation() {
		isDisplayed(accCreationSuccessMsg, "Account Created");
		String msg = getText(accCreationSuccessMsg);
		textCompare(msg, "Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	
	public void logIn() {
		isDisplayedThenEnterText(emailLogIn, "Email", PropUtils.getPropValue(testData, "Email-ID"));
		isDisplayedThenEnterText(PasswordLogIn, "Password", PropUtils.getPropValue(testData, "Password"));
		isDisplayedThenActionClick(signInSubmit, "Logged In");
	}
	
	

}
