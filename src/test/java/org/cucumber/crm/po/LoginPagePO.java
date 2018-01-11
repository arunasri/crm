package org.cucumber.crm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePO {
	public LoginPagePO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "authentication_username")
	private WebElement username;

	@FindBy(how = How.ID, using = "authentication_password")
	private WebElement passwd;

	@FindBy(how = How.NAME, using = "commit")
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "authentication_remember_me")
	public WebElement rememberMeCheckBox;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Forgot Password?")
	public WebElement forgotPasswordLink;

	public void login(String userName, String passWord) {
		this.username.sendKeys(userName);
		this.passwd.sendKeys(passWord);
		this.loginButton.submit();
	}
}



