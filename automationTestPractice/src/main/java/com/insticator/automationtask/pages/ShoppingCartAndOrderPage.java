package com.insticator.automationtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.insticator.automationtask.pagebase.BasePage;
import com.insticator.automationtask.repos.Locators;

public class ShoppingCartAndOrderPage extends BasePage {

	// OR
	@FindBy(xpath = Locators.PROCEED_TO_OUT)
	private WebElement proccedToOut;

	@FindBy(xpath = Locators.PAGE_HEADER)
	private WebElement pageHeader;

	@FindBy(xpath = Locators.ADDRESS_CHECKOUT_BTN)
	private WebElement addressCheckoutBtn;

	@FindBy(xpath = Locators.SHIPPING_CHECKOUT_BTN)
	private WebElement shippingCheckoutBtn;

	@FindBy(tagName = Locators.TERMS_CONDITIONS)
	private WebElement termsAndCond;

	@FindBy(className = Locators.PAY_BY_BANK)
	private WebElement payByBank;

	@FindBy(className = Locators.PAY_BY_CHEQUE)
	private WebElement payByCheque;

	@FindBy(xpath = Locators.BANK_WIRE_PAYMENT)
	private WebElement bankWire;

	@FindBy(xpath = Locators.CHEQUE_PAYMENT)
	private WebElement cheque;

	@FindBy(xpath = Locators.CONFIRM_ORDER)
	private WebElement confirmOrder;

	@FindBy(xpath = Locators.ORDER_SUCCESS_MSG)
	private WebElement orderSuccess;
	
	@FindBy(xpath = Locators.ORDER_SUCCESS_ALERT)
	private WebElement orderSuccessAlert;

	public ShoppingCartAndOrderPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void shoppingCartSummary() {
		String shippingCartHeader = pageHeader.getText().split(" ")[0];
		textCompare(shippingCartHeader, "SHOPPING-CART");
		scrollDownPage();
		isDisplayedThenActionClick(proccedToOut, "Proceed To Checkout");
	}

	public void addressBox() {
		verifyText(pageHeader, "ADDRESSES");
		scrollDownPage();
		isDisplayedThenActionClick(addressCheckoutBtn, "Proceed To Checkout Address");
	}

	public void shippingBox() {
		verifyText(pageHeader, "SHIPPING");
		scrollDownPage();
		isDisplayedThenActionClick(termsAndCond, "Terms & Conditions");
		isDisplayedThenActionClick(shippingCheckoutBtn, "Proceed To Checkout Shipping");
	}

	public void payBankWireAndCheckOrderSummary() {
			verifyText(pageHeader, "PLEASE CHOOSE YOUR PAYMENT METHOD");
			scrollDownPage();
			isDisplayedThenActionClick(payByBank, "Pay by Bank wire");
			verifyText(pageHeader, "ORDER SUMMARY");
			scrollDownPage();
			verifyText(bankWire, "BANK-WIRE PAYMENT.");
			isDisplayedThenActionClick(confirmOrder, "Order Confirmed");
			verifyText(pageHeader, "ORDER CONFIRMATION");
			verifyText(orderSuccess, "Your order on My Store is complete.");

		} 
		
	public void payViaChequeAndCheckOrderSummary() {
			verifyText(pageHeader, "PLEASE CHOOSE YOUR PAYMENT METHOD");
			scrollDownPage();
			isDisplayedThenActionClick(payByCheque, "Pay by Cheque");
			verifyText(pageHeader, "ORDER SUMMARY");
			scrollDownPage();
			verifyText(cheque, "CHECK PAYMENT");
			isDisplayedThenActionClick(confirmOrder, "Order Confirmed");
			verifyText(pageHeader, "ORDER CONFIRMATION");
			verifyText(orderSuccessAlert, "Your order on My Store is complete.");
	}
}
