package com.insticator.automationtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.insticator.automationtask.pagebase.BasePage;
import com.insticator.automationtask.repos.Locators;

public class SearchPage extends BasePage {

	//OR
	
	@FindBy(tagName = Locators.TEES_NAME_IN_DETAILED_SEC)
	private WebElement tshirtName;
	
	@FindBy(id = Locators.SEARCH_LABEL)
	private WebElement searchLabel;
	
	@FindBy(name = Locators.SEARCH)
	private WebElement search;
	
	@FindBy(xpath = Locators.MORE_DETAILS)
	private WebElement productDetails;
	
	public SearchPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	String teesName;
	
	public void selectProduct() {
		isDisplayedThenActionClick(productDetails, "T-Shirt");
	}
	
	public void searchProductByName() {
		teesName = getText(tshirtName);
		scrollToTopPage();
		isDisplayedThenEnterText(searchLabel, "Search Box", teesName);
		isDisplayedThenActionClick(search, "Search");		
	}
	
	public void validateSearchedProduct() {		
		verifyText(tshirtName, teesName);
		
	}
	

}
