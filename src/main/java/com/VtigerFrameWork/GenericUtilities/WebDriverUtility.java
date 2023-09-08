package com.VtigerFrameWork.GenericUtilities;

/**
 * @author Ajay Kumar
 * WebDriverUtility class consist of all the browser methods.
 */

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	
	/**
	 * This method is to open the given url in browser.
	 * @param driver
	 * @param url
	 */
	public void openGivenUrl(WebDriver driver, String url)
	{
		driver.get(url);
	}

	/**
	 * This method is to maximize the browser.
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is to provide the "implicit Wait" for the page to load.
	 * @param driver
	 * @param timeInSec
	 */
	public void implicitWait(WebDriver driver, int timeInSec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));
	}
	
	/**
	 * This method is to hover the mouse cursor over any webPage element.
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
}
