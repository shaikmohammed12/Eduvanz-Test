package resouces;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementAction {

	WebDriver driver;
	
	/**
	 * wait until element is visible
	 * @param driver
	 * @param xpath
	 */
	public void waitForElementVisible(WebDriver driver, By xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
	}
	
	/**
	 * wait until page is loaded
	 * @param driver
	 * @param title
	 */
	public void waitForPageLoad(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public String getValueFromPropertyFile(String key) throws IOException
	{
		FileReader reader=new FileReader(System.getProperty("user.dir")+"/src/main/java/pageObjects/config.properties");
	    Properties p=new Properties(); 
	    p.load(reader);
	    return p.getProperty(key);
	}
	
	public void scrollToElement(WebDriver driver, By xpath)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//js.executeScript("window.scrollBy(0,1000)");
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(xpath));
		 
	}
	
	public void clickToElement(WebDriver driver, By xpath)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", driver.findElement(xpath));
	}
}
