package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogInOrSignUp {
	@FindBy(id = "email")
	private WebElement EmailBox;

	@FindBy(id = "pass")
	private WebElement PasswordBox;

	@FindBy(name = "login")
	private WebElement LoginButton;

	@FindBy(xpath = "//a[text()='Forgotten password?']")
	private WebElement ForgotLink;

	@FindBy(xpath = "(//div/a[@role='button'])[2]")
	private WebElement CreateAcc;

	public PageLogInOrSignUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailBox() {
		return EmailBox;
	}

	public WebElement getPasswordBox() {
		return PasswordBox;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getForgotLink() {
		return ForgotLink;
	}

	public WebElement getCreateAcc() {
		return CreateAcc;
	}

}
