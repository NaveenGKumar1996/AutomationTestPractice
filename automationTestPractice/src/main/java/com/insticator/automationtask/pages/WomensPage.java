package com.insticator.automationtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.insticator.automationtask.pagebase.BasePage;
import com.insticator.automationtask.repos.Locators;

public class WomensPage extends BasePage {

	// OR
	@FindBy(xpath = Locators.WOMENS_TAB)
	private WebElement womensTab;

	@FindBy(xpath = Locators.T_SHIRT)
	private WebElement tshirt;

	@FindBy(xpath = Locators.T_SHIRT_IMAGE)
	private WebElement tshirtImage;

	@FindBy(xpath = Locators.MORE_DETAILS)
	private WebElement moreDetails;

	@FindBy(tagName = Locators.TEES_NAME_IN_DETAILED_SEC)
	private WebElement teesNameInDetailedSec;

	@FindBy(xpath = Locators.QUICK_VIEW)
	private WebElement quickView;

	@FindBy(id = Locators.QUALITY)
	private WebElement quality;

	@FindBy(xpath = Locators.INCREMENT)
	private WebElement increment;

	@FindBy(xpath = Locators.SIZE)
	private WebElement size;

	@FindBy(id = Locators.BLUE_COLORS)
	private WebElement blueColor;

	@FindBy(xpath = Locators.ADD_TO_CART)
	private WebElement addToCart;

	@FindBy(xpath = Locators.PRODUCT_ORDERED_MSG)
	private WebElement productOrderedMsg;

	@FindBy(xpath = Locators.CHECK_OUT)
	private WebElement checkOut;

	public WomensPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void womensTShirt() {
		mouseHover(womensTab);
		isDisplayedThenActionClick(tshirt, "T-Shirt");
	}
	
	public void mouseHoverProduct() {
		scrollDownPage();
		mouseHover(tshirtImage);
	}

	public void addToCartWithChanges() {
		isDisplayedThenActionClick(moreDetails, "More Details");
		if (quality.getAttribute("value").equals("1")) {
			actionClick(increment);
		} else {
			isDisplayedThenEnterText(quality, "Quantity Wanted", "2");
		}
		selectDropDownByText(size, "L");
		isDisplayedThenActionClick(blueColor, "Blue Color");
		isDisplayedThenActionClick(addToCart, "Add to Cart");
		verifyText(productOrderedMsg, "Product successfully added to your shopping cart");
		isDisplayedThenActionClick(checkOut, "Proceed To Checkout");
	}

}
