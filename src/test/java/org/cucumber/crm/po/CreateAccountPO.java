package org.cucumber.crm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountPO extends BasePO {
	public CreateAccountPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Create Account')]")
	public WebElement createAccountLink;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Name:')]")
	public WebElement nameLabel;
	@FindBy(how = How.ID, using = "account_name")
	public WebElement nameTextboxField;
	@FindBy(how = How.ID, using = "select2-account_assigned_to-container")
	public WebElement assignedToDropDownField;
	@FindBy(how = How.ID, using = "account_category")
	public WebElement accountDropDownField;
	@FindBy(how = How.ID, using = "account_rating")
	public WebElement ratingDropDownField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Tags:')]")
	public WebElement tagsLabel;
	@FindBy(how = How.XPATH, using = "//td[@colspan = '3']//following-sibling::span[@class = 'select2 select2-container select2-container--default']")
	public WebElement tagsTextboxField;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), ' Comment')]")
	public WebElement commentLink;
	@FindBy(how = How.ID, using = "comment_body")
	public WebElement commentTextarea;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), ' Contact Information')]")
	public WebElement contactInformationLink;
	@FindBy(how = How.ID, using = "account_toll_free_phone")
	public WebElement tollFreeTextBox;
	@FindBy(how = How.ID, using = "account_phone")
	public WebElement phoneTextbox;
	@FindBy(how = How.ID, using = "account_fax")
	public WebElement faxTextbox;
	@FindBy(how = How.ID, using = "account_website")
	public WebElement websiteTextbox;
	@FindBy(how = How.ID, using = "account_email")
	public WebElement emailTextbox;
	// Billing Address
	@FindBy(how = How.ID, using = "account_billing_address_attributes_street1")
	public WebElement billingAddressStreet1Textbox;
	@FindBy(how = How.ID, using = "account_billing_address_attributes_street2")
	public WebElement billingAddressStreet2Textbox;
	@FindBy(how = How.ID, using = "account_billing_address_attributes_city")
	public WebElement billingAddressCityTextbox;
	@FindBy(how = How.ID, using = "account_billing_address_attributes_state")
	public WebElement billingAddressStateTextbox;
	@FindBy(how = How.ID, using = "account_billing_address_attributes_zipcode")
	public WebElement billingAddressZipcodeTextbox;
	@FindBy(how = How.ID, using = "select2-account_billing_address_attributes_country-container")
	public WebElement billingAddressCountryDropDown;
	// Shipping Address
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'same as billing')]")
	public WebElement sameAsBillingAddressLink;
	@FindBy(how = How.ID, using = "account_shipping_address_attributes_street1")
	public WebElement shippingAddressStreet1Textbox;
	@FindBy(how = How.ID, using = "account_shipping_address_attributes_street2")
	public WebElement shippingAddressStreet2Textbox;
	@FindBy(how = How.ID, using = "account_shipping_address_attributes_city")
	public WebElement shippingAddressCityTextbox;
	@FindBy(how = How.ID, using = "account_shipping_address_attributes_state")
	public WebElement shippingAddressStateTextbox;
	@FindBy(how = How.ID, using = "account_shipping_address_attributes_zipcode")
	public WebElement shippingAddressZipcodeTextbox;
	@FindBy(how = How.ID, using = "select2-account_shipping_address_attributes_country-container")
	public WebElement shippingAddressCountryDropDown;
	// Permission
	@FindBy(how = How.XPATH, using = "//a[contains(text(), ' Permissions')]")
	public WebElement permissionsLink;
	@FindBy(how = How.ID, using = "account_access_private")
	public WebElement permissionsPrivateRadioButton;
	@FindBy(how = How.ID, using = "account_access_public")
	public WebElement permissionsPublicRadioButton;
	@FindBy(how = How.ID, using = "account_access_shared")
	public WebElement permissionsSharedRadioButton;
	@FindBy(how = How.XPATH, using = "//input[@value = 'Create Account']")
	public WebElement createAccountButton;
	@FindBy(how = How.ID, using = "//div[@class = 'buttonbar']//a")
	public WebElement cancelLink;

}
