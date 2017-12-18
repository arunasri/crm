package org.cucumber.crm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateOpportunityPO {
	
		public CreateOpportunityPO(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Name:')]")
		public WebElement nameLabel;
		@FindBy(how = How.XPATH, using = "//input[@id = 'opportunity_name']")
		public WebElement nameTextboxField;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Stage:')]")
		public WebElement stageLabel;
		@FindBy(how = How.XPATH, using = "//select[@id = 'opportunity_stage']")
		public WebElement stageDropdownfield;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Close date:')]")
		public WebElement closeDateLabel;
		@FindBy(how = How.XPATH, using = "//input[@id = 'opportunity_closes_on']")
		public WebElement closeDatePicker;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Probability (%):')]")
		public WebElement probabilityLabel;
		@FindBy(how = How.XPATH, using = "//input[@id = 'opportunity_probability']")
		public WebElement probabilityTextboxField;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Amount ($):')]")
		public WebElement amountLabel;
		@FindBy(how = How.XPATH, using = "//input[@id = 'opportunity_amount']")
		public WebElement amountTextboxField;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Discount ($):')]")
		public WebElement discountLabel;
		@FindBy(how = How.XPATH, using = "//input[@id = 'opportunity_discount']")
		public WebElement dicountTextboxField;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Account')]")
		public WebElement accountLabel;
		@FindBy(how = How.XPATH, using = "//a[contains(text(), 'select existing')]")
		public WebElement selectExistingLink;
		@FindBy(how = How.XPATH, using = "//input[@id = 'account_name']")
		public WebElement accountAndExistingTextboxField;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Assigned to:')]")
		public WebElement assignedtoLabel;
		@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Unassigned')]")
		public WebElement assignedtoDropdownField;
		@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Campaign:')]")
		public WebElement campaignLabel;
		@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Select a campaign')]")
		public WebElement campaignDropDownField;
		@FindBy(how = How.XPATH, using = "//input[@value = 'Create Opportunity']")
		public WebElement createOpportunityButton;
		@FindBy(how = How.XPATH, using = "//div[@class = 'buttonbar']//a")
		public WebElement cancelLink;
		// //div[@class = 'buttonbar']//input

}
