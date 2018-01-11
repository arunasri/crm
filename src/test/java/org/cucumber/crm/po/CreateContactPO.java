package org.cucumber.crm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPO extends BasePO {
	public CreateContactPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'First name:')]")
	public WebElement firstnameLabel;
	@FindBy(how = How.XPATH, using = "//input[@id = 'contact_first_name']")
	public WebElement firstnameTextboxField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Last name:')]")
	public WebElement lastnameLabel;
	@FindBy(how = How.XPATH, using = "//input[@id = 'contact_last_name']")
	public WebElement lastnameTextboxField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Email:')]")
	public WebElement emailLabel;
	@FindBy(how = How.XPATH, using = "//input[@id = 'contact_email']")
	public WebElement emailTextboxField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Phone:')]")
	public WebElement phoneLabel;
	@FindBy(how = How.XPATH, using = "//input[@id = 'contact_phone']")
	public WebElement phoneTextboxField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Account')]")
	public WebElement accountLabel;
	@FindBy(how = How.XPATH, using = "//input[@id = 'account_name']")
	public WebElement accountAndSelectExistingTextboxField;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'select existing')]")
	public WebElement selectExistingLabel;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Assigned to:')]")
	public WebElement assignedToLabel;

	@FindBy(how = How.XPATH, using = "//span[@id = 'select2-contact_assigned_to-container']")
	public WebElement assignedToTextboxField;

	@FindBy(how = How.XPATH, using = "//input[@value = 'Create Contact']")
	public WebElement createContactButton;

	public void openCreateContactPO() {
		
	}
}
