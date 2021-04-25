package stepDefinitions;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetUp {
	
	public static WebDriver driver=null; 
    
	
	@Before
	public static WebDriver setup() throws Exception
	{
		FileReader reader=new FileReader(System.getProperty("user.dir")+"/src/main/java/pageObjects/config.properties");
	    Properties p=new Properties(); 
	    p.load(reader);
		//Use Of Singleton Concept and Initilize webDriver
	      if(driver == null)
	      {
	         if(p.getProperty("Browser").equalsIgnoreCase("chrome"))
	         {
	        	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
	            driver=new ChromeDriver();
	         }
	         else if(p.getProperty("Browser").equalsIgnoreCase("Firefox"))
	         {
	            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/firefoxdriver");
	            driver=new FirefoxDriver();
	         }
	         else if(p.getProperty("Browser").equalsIgnoreCase("IE"))
	         {
	            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/drivers/iedriver");
	            driver=new InternetExplorerDriver();
	         }
	      }
	      driver.manage().deleteAllCookies();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.get(p.getProperty("URL"));
	      
	      return driver;
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}

}
