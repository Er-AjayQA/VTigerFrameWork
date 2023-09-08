package com.VtigetFrameWork.ObectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.VtigerFrameWork.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(xpath = "//img[contains(@src,'user.PNG')]") private WebElement myAccountIcon;
	@FindBy(xpath = "//a[contains(.,'Sign Out')]") private WebElement signOutBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyAccountIcon() {
		return myAccountIcon;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	// Business Library.
	
	/**
	 * This method is to logout from Vtiger application.
	 * @param driver
	 */
	public void logoutFromVtigerApp(WebDriver driver)
	{
		mouseHoverOnElement(driver, myAccountIcon);
		signOutBtn.click();
	}
	
	/**
	 * This method is to validate the logout.
	 * @param driver
	 * @param expectedTitle
	 */
	public void validateLogout(WebDriver driver, String expectedTitle)
	{
		String actualTitle= driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
