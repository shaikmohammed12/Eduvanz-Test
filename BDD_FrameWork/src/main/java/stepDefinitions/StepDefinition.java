package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.PageObjects;
import resouces.ElementAction;
import resouces.functions;

@SuppressWarnings("deprecation")
public class StepDefinition extends PageObjects {

	WebDriver driver;
	functions function = new functions();
	ElementAction action = new ElementAction();

	@Given("user is on home page")
	public void user_is_on_home_page() throws Exception {
		driver = SetUp.setup();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("user not landed on home page", "My Store", title);
	}

	@When("sign in to your account")
	public void sign_in_to_your_account() throws IOException, InterruptedException {
	   driver.findElement(SignInlink).click();
	   action.waitForPageLoad(driver, "Login - My Store");
	   driver.findElement(EmailId).sendKeys(action.getValueFromPropertyFile("userid"));
	   driver.findElement(Password).sendKeys(action.getValueFromPropertyFile("password"));
	   driver.findElement(SignInButton).click();
	}
	
	@When("search for the required product {string} {string} {string}")
	public void search_for_the_required_product(String cloth, String colors, String sizes) throws InterruptedException {

		driver.findElement(WomensSection).click();
		action.waitForPageLoad(driver, "Women - My Store");
		action.waitForElementVisible(driver, ProductsList);
		List<WebElement> items = driver.findElements(Dresses);
		Map<String, String> itemdetails = new HashMap<String, String>();
		int i;
		for (i = 0; i < items.size(); i++)
		{
			itemdetails = function.getItemDetails(driver, items.get(i), i);
			System.out.println(itemdetails);
			Float price = Float.parseFloat(itemdetails.get("price").substring(1));
			if (itemdetails.get("description").contains(cloth) && price < 50)
			{
				System.out.println("cotton dress");
				if (function.check_Expectedsize_availability(function.getAvailableItemSizes(driver, ItemSize),sizes))
				{
					function.selectItemSize(driver, ItemSize, sizes, function.getAvailableItemSizes(driver, ItemSize));
					System.out.println("size selected");
					if (function.check_Expectedcolor_availability(function.getAvailableItemcolors(driver, ItemColors),colors))
					{
						function.selectItemColor(driver, ItemColors, colors,function.getAvailableItemcolors(driver, ItemColors));
						System.out.println("color selected");
					} 
					else
					{
						System.out.println("Expected color is not available");
						Assert.assertTrue("Expected color is not available", false);
					}
				} 
				else
				{
					System.out.println("exected size is not available");
					Assert.assertTrue("Expected size is not available", false);
				}

				break;
			} else {
				System.out.println("this is not a cotton dress or not under $50");
				driver.switchTo().defaultContent();
				driver.findElement(CloseIcon).click();
			}
			if(i==items.size())
				Assert.assertTrue("Expected dress is not available", false);

		}
	}

	@Then("add it to cart and place the order")
	public void add_it_to_cart_and_place_the_order() throws InterruptedException {

		driver.findElement(AddtoCart).click();
		driver.switchTo().defaultContent();
		//Assert.assertEquals("Product successfully added to your shopping cart",driver.findElement(AddcartSucessMsg).getText().trim());
		System.out.println("Product successfully added to your shopping cart");
		driver.findElement(CheckoutButton).click();
		action.scrollToElement(driver, CartCheckout);
		driver.findElement(CartCheckout).click();
		driver.findElement(AddressCheckout).click();
		driver.findElement(TermsofServiceCheckbox).click();
		driver.findElement(ShippingCheckout).click();
		driver.findElement(PaybyBankWire).click();
		driver.findElement(IconfirmOrderBtn).click();
		Assert.assertEquals("order is not completed","Your order on My Store is complete.", driver.findElement(OrderCompleteMsg).getText());
		System.out.println("Order completed Sucessfully");
	}

}
