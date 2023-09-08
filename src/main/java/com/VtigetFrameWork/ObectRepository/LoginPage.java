package com.VtigetFrameWork.ObectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	@FindBy(xpath = "//input[@type='text']") private WebElement userNameTextField;
	@FindBy(xpath = "//input[@type='password']") private WebElement passwordTextField;
	@FindBy(xpath = "//input[@type='submit']") private WebElement loginbutton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	// Business library.
	
	/**
	 * This method is to login to VTiger application by taking "UserName and Password" as argument.
	 * @param username
	 * @param passWord
	 */
	public void loginToVtigerApplication(String username, String passWord)
	{
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(passWord);
		loginbutton.click();
	}
	
	/**
	 * This method is to validate the login.
	 * @param driver
	 * @param expectedPageTitle
	 */
	public void validateLogin(WebDriver driver, String expectedPageTitle)
	{
		String actualPageTitle= driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}
}
