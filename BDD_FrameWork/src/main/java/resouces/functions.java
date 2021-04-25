package resouces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pageObjects.PageObjects;

public class functions extends PageObjects {

	WebDriver driver;

	public Map<String, String> getItemDetails(WebDriver driver, WebElement element, int index) throws InterruptedException {
		Map<String, String> itemdetails = new HashMap<String, String>();
		element.click();
		if(driver.findElement(Breadcrum).isDisplayed()==false)
			driver.switchTo().frame(driver.findElement(ItemDetailsFrame));
		itemdetails.put("itemname", driver.findElement(ItemName).getText());
		itemdetails.put("description", driver.findElement(ItemDescription).getText());
		itemdetails.put("price", driver.findElement(ItemPrice).getText());
		return itemdetails;
	}

	public List<String> getAvailableItemSizes(WebDriver driver, By xpath) {
		List<String> sizes = new ArrayList<String>();
		Select sizeoptions = new Select(driver.findElement(xpath));
		for (int i = 0; i < sizeoptions.getOptions().size(); i++)
			sizes.add(sizeoptions.getOptions().get(i).getText());
		return sizes;
	}
	public boolean check_Expectedsize_availability(List<String> availablesizes, String Expectedsize)
	{
		String[] sizes = Expectedsize.split(",");
		for(int i=0;i<sizes.length;i++)
		{
			for(int j=0;j<availablesizes.size();j++)
			{
				if(sizes[i].equalsIgnoreCase(availablesizes.get(j)))
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean check_Expectedcolor_availability(List<String> availablecolors, String Expectedcolor)
	{
		String[] sizes = Expectedcolor.split(",");
		for(int i=0;i<sizes.length;i++)
		{
			for(int j=0;j<availablecolors.size();j++)
			{
				if(sizes[i].equalsIgnoreCase(availablecolors.get(j)))
				{
					return true;
				}
			}
		}
		return false;
	}
	public void selectItemSize(WebDriver driver, By xpath, String Expectedsize, List<String> availablesizes) throws InterruptedException {
		Select sizeoptions = new Select(driver.findElement(xpath));
		String[] sizes = Expectedsize.split(",");
		for(int i=0;i<sizes.length;i++)
		{
			for(int j=0;j<availablesizes.size();j++)
			{
				if(sizes[i].equalsIgnoreCase(availablesizes.get(j)))
				{
					sizeoptions.selectByVisibleText(availablesizes.get(j));
					break;
				}
				Thread.sleep(3000);
			}
		}
		
	}

	public List<String> getAvailableItemcolors(WebDriver driver, By xpath) {
		List<String> colors = new ArrayList<String>();
		List<WebElement> colours = driver.findElements(xpath);
		for (int i = 0; i < colours.size(); i++)
			colors.add(colours.get(i).getAttribute("title"));
		return colors;
	}
	
	public void selectItemColor(WebDriver driver, By xpath, String Expectedcolor, List<String> Availablecolors) throws InterruptedException {
		List<WebElement> colours = driver.findElements(ItemColors);
		String[] colors = Expectedcolor.split(",");
		for(int i=0;i<colors.length;i++)
		{
			for(int j=0;j<Availablecolors.size();j++)
			{
				if(colors[i].equalsIgnoreCase(Availablecolors.get(j)))
				{
					colours.get(j).click();
					break;
				}
				Thread.sleep(3000);
			}
		}
		
	}
}
