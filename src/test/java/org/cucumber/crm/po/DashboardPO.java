package org.cucumber.crm.po;

import org.cucumber.helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPO extends BasePO {
	public DashboardPO(WebDriver driver) {
		super(driver);
	}

	// Clicking Tabs
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Tasks")
	private WebElement tasksTab;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Team')]")
	private WebElement teamTab;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Accounts")
	private WebElement accountTab;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Campaigns")
	private WebElement campaignTab;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Leads")
	private WebElement leadTab;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Contacts")
	private WebElement contactTab;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Opportunities")
	private WebElement opportunityTab;
	// Creating Link
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Task")
	private WebElement createTaskLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Account")
	private WebElement createAccountLink;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Lead")
	private WebElement createLeadLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Campaign")
	private WebElement createCampaignLink;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Create Contact")
	private WebElement createContactLink;

	// Buttons
	@FindBy(how = How.XPATH, using = "//div[@class = 'buttonbar']//input")
	private WebElement createLeadButton;
	@FindBy(how = How.XPATH, using = "//input[@value = 'Create Account']")
	private WebElement createAccountButton;

	public void openTaskTab() {
		this.tasksTab.click();
	}

	public void openOpportunityTab() {
		this.opportunityTab.click();
		SeleniumHelpers.highlightElement(this.driver, opportunityTab);
		opportunityTab.click();
	}

	public void openTeamTab() {
		this.teamTab.click();
	}

	public void openAccountTab() {
		this.accountTab.click();
	}

	public void openCampaignTab() {
		this.campaignTab.click();
	}

	public void openLeadTab() {
		this.leadTab.click();
	}

	public void openContactTab() {
		this.contactTab.click();
	}

	// Buttons
	public void clickCreateLeadButton() {
		this.createLeadButton.click();
	}
	public void clickAccountLeadButton() {
		this.createAccountButton.click();
	}

	// Creating links
	public void createTaskLink() {
		this.openTaskTab();
		this.createTaskLink.click();
		this.wait(By.xpath("//input[@id = 'task_name']"));
		}

	public void createLeadLink() {
		this.createLeadLink.click();
	}

	public void createCampaignLink() {
		this.createCampaignLink.click();
	}

	public void createAccountLink() {
		this.createAccountLink.click();
		this.wait(By.xpath("//div[contains(text(),'Tags:')]"));

	}

	public void createContactLink() {
		this.createContactLink.click();
		this.wait(By.xpath("//div[contains(text(), 'First name:')]"));
	}
}
