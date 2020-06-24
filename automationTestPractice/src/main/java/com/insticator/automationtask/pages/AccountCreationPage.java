package com.insticator.automationtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.insticator.automationtask.pagebase.BasePage;
import com.insticator.automationtask.repos.Locators;
import com.insticator.automationtask.util.PropUtils;

public class AccountCreationPage extends BasePage {
	
	@FindBy(xpath = Locators.PAGE_HEADER)
	private WebElement pageHeader;
	
	@FindBy(xpath = Locators.GENDER_MALE)
	private WebElement genderMale;
	
	@FindBy(xpath = Locators.GENDER_FEMALE)
	private WebElement genderFemale;
	
	@FindBy(id = Locators.CUST_FIRST_NAME)
	private WebElement firstName;
	
	@FindBy(id = Locators.CUST_LAST_NAME)
	private WebElement lastName;
	
	@FindBy(id = Locators.PASSWORD)
	private WebElement password;
	
	@FindBy(id = Locators.DAYS )
	private WebElement days;
	
	@FindBy(id = Locators.MONTHS )
	private WebElement months;
	
	@FindBy(id = Locators.YEARS)
	private WebElement years;
	
	@FindBy(xpath = Locators.NEWS_LETTER)
	private WebElement newsLetter;
	
	@FindBy(xpath = Locators.SPECIAL_OFFERS )
	private WebElement specialOffers;
	
	@FindBy(id = Locators.ADDRESS_FIRST_NAME )
	private WebElement addressFirstName;
	
	@FindBy(id = Locators.ADDRESS_LAST_NAME )
	private WebElement addressLastName;

	@FindBy(id = Locators.COMPANY_NAME )
	private WebElement companyName;
	
	@FindBy(id = Locators.COMPANY_ADDRESS)
	private WebElement companyAddress;
	
	@FindBy(id = Locators.CITY)
	private WebElement city;
	
	@FindBy(id = Locators.STATE)
	private WebElement state;
	
	@FindBy(id = Locators.POST_CODE)
	private WebElement postalCode;
	
	@FindBy(id = Locators.COUNTRY)
	private WebElement country;

	@FindBy(id = Locators.PHONE_NUMBER)
	private WebElement mobileNumber;

	@FindBy(id = Locators.FUTURE_REFERENCE)
	private WebElement futureReferenceAddress;

	@FindBy(id = Locators.REGISTER)
	private WebElement register;
	
	public AccountCreationPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void accountDetailsFillAndRegister() {
		
		String Password = FakerAPI().internet().password(5, 10);
		PropUtils.setProps(testData, inputFile, "Password", Password);
		String FirstName = FakerAPI().name().firstName();
		String LastName = FakerAPI().name().lastName();
		isDisplayed(pageHeader, "CreateAccount Header");
		
		isDisplayedThenClickRadioBtn(genderMale, "Mr.");
		isDisplayedThenEnterText(firstName, "FirstName", FirstName);
		isDisplayedThenEnterText(lastName, "LastName", LastName);
		isDisplayedThenEnterText(password, "Password", Password);
		selectValueRandomly(days, "Days");
		selectValueRandomly(months, "Months");
		selectValueRandomly(years, "Years");
		isDisplayedThenClickCheckBox(newsLetter, "NewsLeter");
		isDisplayedThenClickCheckBox(specialOffers, "Special Offers");
		isDisplayedThenEnterText(addressFirstName, "addressFirstName", FirstName);
		isDisplayedThenEnterText(addressLastName, "addressLastName", LastName);
		isDisplayedThenEnterText(companyName, "companyName", "Insticator");
		isDisplayedThenEnterText(companyAddress, "companyAddress", FakerAPI().address().fullAddress());
		isDisplayedThenEnterText(city, "city", FakerAPI().address().city());
		selectValueRandomly(state, "State");
		isDisplayedThenEnterText(postalCode, "postalCode", "00000");
		isDisplayedThenEnterText(mobileNumber, "mobileNumber", FakerAPI().phoneNumber().cellPhone());
		isDisplayedThenEnterText(futureReferenceAddress, "futureReferenceAddress", FakerAPI().address().streetAddress().substring(1,10));
		isDisplayedThenActionClick(register, "Submit");
		
	}

}
