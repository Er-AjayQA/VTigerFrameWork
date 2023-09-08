package com.VtigerFrameWork.GenericUtilities;

/**
 * @author Ajay Kumar
 * WebDriverUtility class consist of all the browser methods.
 */

import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class WebDriverUtility {

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
}
