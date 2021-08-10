package com.insticator.automationtask.repos;

public class Locators {
	
	public static final String NAVIGATION_PAGE = "navigation_page";  //className
	public static final String CREATE_ACCOUNT_HEADER = "//h3[contains(text(),'Create an account')]";  //xpath
	public static final String EMAIL_CREATE = "email_create";  //Id
	public static final String CREATE_ACCOUNT_BTN = "//form[@id='create-account_form']//span[1]"; //xpath
	public static final String EMAIL ="email"; //id
	public static final String PASSWORD = "passwd"; //id
	public static final String SUBMIT = "//p[@class='submit']//span[1]"; //xpath
	public static final String ACCOUNT_CREATION_SUCCESS_MESSAGE =  "info-account"; //className
	public static final String REGISTERED_HEADER = "//h3[contains(text(),'Already registered')]"; //xpath
	
	
	public static final String WOMENS_TAB = "//a[@class='sf-with-ul'][contains(text(),'Women')]"; //xpath
	public static final String T_SHIRT = "//li/a[contains(text(),'Women')]//following::ul/li/a[@title='T-shirts']"; //xpath
	public static final String T_SHIRT_IMAGE = "//a[@class='product_img_link']//img[@class='replace-2x img-responsive']"; //xpath
	public static final String PRODUCT_IMG = "//div[@class='product-image-container']"; //xpath
	public static final String TEES_NAME_IN_NEW_PANEL = "//h1[@itemprop='name']"; //xpath	
	public static final String MORE_DETAILS = "//span[contains(text(),'More')]"; //xpath
	public static final String TEES_NAME = "//a[contains(text(),'Faded Short Sleeve T-shirts')]"; //xpath
	public static final String TEES_NAME_IN_DETAILED_SEC = "h1";//TAG_NAME
	public static final String QUICK_VIEW = "//span[contains(text(),'Quick view')]"; //xpath
	public static final String QUALITY = "quantity_wanted"; //id
	public static final String INCREMENT = "//a[@class='btn btn-default button-plus product_quantity_up']//span"; //xpath
	public static final String SIZE = "//select[@id='group_1']";//xpath
	public static final String BLUE_COLORS = "color_14"; //id
	public static final String ADD_TO_CART = "//span[contains(text(),'Add to cart')]"; //xpath
	public static final String PRODUCT_ORDERED_MSG = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]"; //xpath
	public static final String CHECK_OUT = "//span[contains(text(),'Proceed to checkout')]"; //xpath
    public static final String SHOPPING_CART = "//h1[@id='cart_title']"; //xpath	 
    public static final String PROCEED_TO_OUT = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]"; //xpath
    public static final String CLOSE_PANEL = "//a[@class='fancybox-item fancybox-close']"; //xpath
    
   
    public static final String SIGN_IN = "//a[@class='login']"; //xpath
    public static final String SIGN_OUT = "//a[@class='logout']"; //xpath
    
    
    public static final String PAGE_HEADER = "//h1[@class='page-heading']"; //xpath
    public static final String GENDER_MALE = "//div[@id='uniform-id_gender1']"; //xpath
    public static final String GENDER_FEMALE = "//div[@id='uniform-id_gender2']"; //xpath
    public static final String CUST_FIRST_NAME = "customer_firstname"; //id
    public static final String CUST_LAST_NAME = "customer_lastname"; //id
    public static final String DAYS = "days"; //id
    public static final String MONTHS = "months"; //id
    public static final String YEARS = "years"; //id
    public static final String NEWS_LETTER = "//div[@id='uniform-newsletter']"; //xpath
    public static final String SPECIAL_OFFERS = "//div[@id='uniform-optin']"; //xpath
    public static final String ADDRESS_FIRST_NAME = "firstname"; //id
    public static final String ADDRESS_LAST_NAME = "lastname"; //id
    public static final String COMPANY_NAME = "company"; //id
    public static final String COMPANY_ADDRESS = "address1"; //id
    public static final String CITY = "city"; //id
    public static final String STATE = "id_state"; //id
    public static final String POST_CODE = "postcode"; //id
    public static final String COUNTRY = "id_country"; //id
    public static final String PHONE_NUMBER = "phone_mobile"; //id
    public static final String FUTURE_REFERENCE = "alias"; //id
    public static final String REGISTER = "submitAccount"; //id
    
    public static final String TERMS_CONDITIONS = "label"; //tagName
    public static final String PAY_BY_BANK = "bankwire"; //classname
    public static final String PAY_BY_CHEQUE = "cheque"; //className
    public static final String CONFIRM_ORDER = "//span[contains(text(),'I confirm my order')]"; //xpath
    public static final String ORDER_SUCCESS_MSG = "//p[@class='cheque-indent']/strong[@class='dark']"; //xpath
    public static final String ADDRESS_CHECKOUT_BTN = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]"; //xpath
    public static final String SHIPPING_CHECKOUT_BTN = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]"; //xpath
    public static final String BANK_WIRE_PAYMENT = "//h3[@class='page-subheading']"; //xpath
    public static final String CHEQUE_PAYMENT = "//h3[@class='page-subheading']"; //xpath
    public static final String ORDER_SUCCESS_ALERT = "//p[@class='alert alert-success']"; //xpath
    
    public static final String SEARCH_LABEL = "search_query_top"; //id
    public static final String SEARCH = "submit_search"; //name"
    		
}