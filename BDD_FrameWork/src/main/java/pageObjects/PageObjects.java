package pageObjects;

import org.openqa.selenium.By;

public class PageObjects {
	
	public static final By WomensSection = By.xpath("//a[@title='Women']");
	public static final By Dresses = By.xpath("//a[@class='product_img_link']");
	public static final By QuickviewButtons= By.xpath("//a[@class='quick-view']");
	public static final By ItemName= By.xpath("//h1[@itemprop='name']");
	public static final By ItemPrice= By.xpath("//span[@id='our_price_display']");
	public static final By ItemSize= By.xpath("//select[@id='group_1']");
	public static final By ItemColors= By.xpath("//ul[@id='color_to_pick_list']/li/a");
	public static final By ItemDescription = By.xpath("//div[@id='short_description_content']/p");
	public static final By AddtoCart= By.xpath("//button[@name='Submit']");
	public static final By CloseIcon= By.xpath("//a[@title='Close']");
	public static final By ProductsList= By.xpath("//ul[@class='product_list grid row']");
	public static final By Breadcrum = By.xpath("//div[@class='breadcrumb clearfix']");
	public static final By ItemDetailsFrame= By.xpath("//iframe[@class='fancybox-iframe']");
	public static final By AddcartSucessMsg= By.xpath("//i[@class='icon-ok']/..");
	public static final By CheckoutButton= By.xpath("//a[@title='Proceed to checkout']");
	public static final By CartCheckout = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
	public static final By AddressCheckout = By.xpath("//button[@name='processAddress']");
	public static final By ShippingCheckout = By.xpath("//button[@name='processCarrier']");
	public static final By SignInlink= By.xpath("//a[@class='login']");
	public static final By EmailId= By.xpath("//input[@id='email']");
	public static final By Password= By.xpath("//input[@id='passwd']");
	public static final By SignInButton= By.xpath("//button[@id='SubmitLogin']");
	public static final By TermsofServiceCheckbox = By.xpath("//input[@id='cgv']");
	public static final By PaybyBankWire = By.xpath("//a[@class='bankwire']");
	public static final By IconfirmOrderBtn = By.xpath("//p[@id='cart_navigation']//button[@type='submit']");
	public static final By OrderCompleteMsg = By.xpath("//p[@class='cheque-indent']/strong[@class='dark']");
}
