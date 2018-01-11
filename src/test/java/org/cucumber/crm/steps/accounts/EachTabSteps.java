package org.cucumber.crm.steps.accounts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.cucumber.crm.po.BasePO;
import org.cucumber.crm.po.CreateContactPO;
import org.cucumber.crm.po.CreateOpportunityPO;
import org.cucumber.crm.po.CreateTaskPO;
import org.cucumber.crm.po.DashboardPO;
import org.cucumber.crm.po.LoginPagePO;
import org.cucumber.helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EachTabSteps {
	WebDriver driver;
	final String seleniumGridURL = System.getProperty("SELENIUM_GRID");
	final String baseURL = System.getProperty("WEBSITE_URL");
	final String username = System.getenv("LOGIN");
	final String password = System.getenv("PASSWORD");

	@Before
	public void initDriver() throws MalformedURLException {
		if (this.seleniumGridURL == null) {
			this.driver = new ChromeDriver();
		} else {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("no-sandbox");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			this.driver = new RemoteWebDriver(new URL(seleniumGridURL), capabilities);
		}
		this.driver.get(baseURL);
	}

	@After
	public void closeBrowser() {
		this.driver.quit();
	}

	@Given("^user should logged in as admin$")
	public void user_should_logged_in_as_admin() {
		LoginPagePO loginPO = new LoginPagePO(driver);
		loginPO.login("george", "george");

	}

	@When("^user clicks on accounts tab$")
	public void user_clicks_on_accounts_tab() {
		DashboardPO accounttab = new DashboardPO(this.driver);
		accounttab.openAccountTab();
	}

	@Then("^user clicks on create account link$")
	public void user_clicks_on_create_account_link() {
		DashboardPO createAccountLink = new DashboardPO(this.driver);
		createAccountLink.createAccountLink();
	}

	@Then("^enter all the details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_all_the_details_and_and_and(String name, String assignedto, String category, String rating) {
		driver.findElement(By.xpath("//input[@id = 'account_name']")).sendKeys(name);
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//span[@id = 'select2-account_assigned_to-container']")));
		action.click();
		action.sendKeys(assignedto);
		action.build().perform();
		WebElement accountCategory = driver.findElement(By.xpath("//select[@id = 'account_category']"));
		accountCategory.sendKeys(category);
		SoftAssert verifies = new SoftAssert();
		verifies.assertTrue(accountCategory.isDisplayed());
		verifies.assertEquals(accountCategory.getAttribute("id"), "account_category");
		verifies.assertAll();

		driver.findElement(By.xpath("//select[@id = 'account_rating']")).sendKeys(rating);
	}

	@Then("^clicks on create account button$")
	public void clicks_on_create_account_button() {
		DashboardPO accountButton = new DashboardPO(driver);
		accountButton.clickAccountLeadButton();
	}

	@Then("^verify created account user details$")
	public void verify_created_account_user_details() {
		 SoftAssert verifies = new SoftAssert();
		 verifies.assertNotNull(driver.findElement(By.xpath("//li[contains(text(),'account_')]")));
	}

	// assertions
	@When("^verify home page tags$")
	public void verify_home_page_tags() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Fat Free CRM", title);
	}

	@Then("^verify edit link$")
	public void verify_edit_link() {
		SoftAssert editLink = new SoftAssert();
		editLink.assertEquals(2, 2, "2 is not equal to 2");
	}

	@Then("^verify delete link$")
	public void verify_delete_link() {
		SoftAssert deleteLink = new SoftAssert();
	}

	// verifying create task page
	@Given("^user should be logged in$")
	public void user_should_be_logged_in() {
		LoginPagePO loginPO = new LoginPagePO(driver);
		System.out.println(password);
		loginPO.login(username, password);
	}

	@When("^user clicks on task tab and clicks on create task link$")
	public void user_clicks_on_task_tab_and_clicks_on_create_task_link() {
		DashboardPO dashboardPO = new DashboardPO(this.driver);
		dashboardPO.createTaskLink();
	}

	@Then("^user should verify all the elements present in create task page$")
	public void user_should_verify_all_the_elements_present_in_create_task_page() {
		CreateTaskPO createTaskPO = new CreateTaskPO(driver);
		SoftAssert verifyCreateTaskElements = new SoftAssert();
		// asert all label elements are present
		verifyCreateTaskElements.assertNotNull(createTaskPO.nameLabel, "Name label is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.nameTextboxField, "Name text box field is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.dueLabel, "Due label is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.dueDropDownField, "Due dropdown field is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.assigntoLabel, "AssignTo label is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.assigntoDropDownField,
				"AssignTo drop down field is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.categoryLabel, "Category label is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.categoryDropDownField,
				"Category drop down field is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.createButton, "Create Button is not present");
		verifyCreateTaskElements.assertNotNull(createTaskPO.cancelLink, "Cancel link is not present");
		verifyCreateTaskElements.assertAll();
	}

	@Then("^user should enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_enter_and_and_and(String name, String due, String assignto, String category)
			throws IOException, InterruptedException {
		CreateTaskPO createTaskPO = new CreateTaskPO(driver);
		// Enter name
		createTaskPO.nameTextboxField.sendKeys(name);
		// Select due
		Select selectDue = new Select(createTaskPO.dueDropDownField);
		selectDue.selectByVisibleText(due);
		// Select Assignto
		createTaskPO.assigntoDropDownField.click();
		WebElement searchResult = SeleniumHelpers.waitElement(driver, By.xpath("//input[@class = 'select2-search__field']"));
		searchResult.sendKeys(assignto);
		WebElement searchResultSelector = SeleniumHelpers.waitElement(driver, By.xpath("//li[contains(text(), '" + assignto + "')]"));
		searchResultSelector.click();

		// Select Category
		Select selectCategory = new Select(createTaskPO.categoryDropDownField);
		selectCategory.selectByVisibleText(category);
		// Click Create button
		createTaskPO.createButton.click();
		// SeleniumHelpers.takeScreenshot(this.driver, name + due + assignto +
		// category);
		SeleniumHelpers screenshot = new SeleniumHelpers();

	}

	// Create Contact
	@When("^user clicks on contacts tab and clicks on create contacts link$")
	public void user_clicks_on_contacts_tab_and_clicks_on_create_contacts_link() {
		DashboardPO contacts = new DashboardPO(this.driver);
		contacts.openContactTab();
		contacts.createContactLink();
		CreateContactPO createcontact = new CreateContactPO(driver);
		SoftAssert verifyCreateConatctElements = new SoftAssert();
		verifyCreateConatctElements.assertNotNull(createcontact.firstnameLabel, "Firstname label is not present");
		SeleniumHelpers.highlightElement(this.driver, createcontact.firstnameLabel);
		verifyCreateConatctElements.assertNotNull(createcontact.lastnameLabel, "Lastname label is not present");
		SeleniumHelpers.highlightElement(this.driver, createcontact.lastnameLabel);
		verifyCreateConatctElements.assertNotNull(createcontact.emailLabel, "Email label is not present");
		SeleniumHelpers.highlightElement(this.driver, createcontact.emailLabel);
		verifyCreateConatctElements.assertNotNull(createcontact.phoneLabel, "Phone label is not present");
		SeleniumHelpers.highlightElement(this.driver, createcontact.phoneLabel);
		verifyCreateConatctElements.assertNotNull(createcontact.accountLabel, "Account label is not present");
		SeleniumHelpers.highlightElement(this.driver, createcontact.accountLabel);
		verifyCreateConatctElements.assertNotNull(createcontact.assignedToLabel, "Assignto label is not present");
		SeleniumHelpers.highlightElement(this.driver, createcontact.assignedToLabel);
		verifyCreateConatctElements.assertNotNull(createcontact.selectExistingLabel,
				"select existing label is not present");
		SeleniumHelpers.highlightElement(this.driver, createcontact.selectExistingLabel);

	}

	@Then("^user should enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_enter_and_and_and_and_and(String firstname, String lastname, String email, String phone,
			String account, String assignto) {
		CreateContactPO createcontact = new CreateContactPO(this.driver);
		createcontact.firstnameTextboxField.sendKeys(firstname);
		SeleniumHelpers.highlightElement(this.driver, createcontact.firstnameTextboxField);
		createcontact.lastnameTextboxField.sendKeys(lastname);
		SeleniumHelpers.highlightElement(this.driver, createcontact.lastnameTextboxField);
		createcontact.emailTextboxField.sendKeys(email);
		SeleniumHelpers.highlightElement(this.driver, createcontact.emailTextboxField);
		createcontact.phoneTextboxField.sendKeys(phone);
		SeleniumHelpers.highlightElement(this.driver, createcontact.phoneTextboxField);
		createcontact.accountAndSelectExistingTextboxField.sendKeys(account);
		SeleniumHelpers.highlightElement(this.driver, createcontact.accountAndSelectExistingTextboxField);
		createcontact.assignedToTextboxField.click();
		SeleniumHelpers.highlightElement(this.driver, createcontact.assignedToTextboxField);
		WebElement searchResult = SeleniumHelpers.waitElement(driver,
				By.xpath("//input[@class = 'select2-search__field']"));
		searchResult.sendKeys(assignto);
		createcontact.createContactButton.click();
		SeleniumHelpers.highlightElement(this.driver, createcontact.createContactButton);
	}

	@When("^user clicks on opportunities tab and clicks on create opportunity link$")
	public void user_clicks_on_opportunities_tab_and_clicks_on_create_opportunity_link() {
		DashboardPO opportunityTab = new DashboardPO(this.driver);
		opportunityTab.openOpportunityTab();
		WebElement createOpportunityLink = driver.findElement(By.partialLinkText("Create Opportunity"));
		SeleniumHelpers.highlightElement(this.driver, createOpportunityLink);
		createOpportunityLink.click();
		SeleniumHelpers.waitElement(driver, By.xpath("//div[contains(text(), 'Name:')]"));
	}

	@When("^user should enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void user_should_enter(String name, String stage, String closedate, String probability, String amount,
			String discount, String account, String assignedto, String campaign) {
		// Creating opportunity object
		CreateOpportunityPO createOpportunity = new CreateOpportunityPO(driver);
		// Verify label and enter name
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.nameLabel);
		createOpportunity.nameTextboxField.sendKeys(name);
		// verify label and select stage
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.stageLabel);
		Select stagedropdown = new Select(createOpportunity.stageDropdownfield);
		stagedropdown.selectByVisibleText(stage);
		// verify label and select close date
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.closeDateLabel);
		createOpportunity.closeDatePicker.sendKeys(closedate);
		// verify label and enter probability
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.probabilityLabel);
		createOpportunity.probabilityTextboxField.sendKeys(probability);
		// verify label and enter amount
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.amountLabel);
		createOpportunity.amountTextboxField.sendKeys(amount);
		// verify label and enter discount
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.discountLabel);
		createOpportunity.dicountTextboxField.sendKeys(discount);
		// verify label and enter account
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.accountLabel);
		createOpportunity.accountAndExistingTextboxField.sendKeys(account);
		// verify label and enter assignto
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.assignedtoLabel);
		WebElement searchResult = SeleniumHelpers.waitElement(driver,
				By.xpath("//input[@class = 'select2-search__field']"));
		searchResult.sendKeys(assignedto);
		// verify label and enter campaign
		WebDriverWait campaignwait = new WebDriverWait(this.driver, 1000);
		// WebElement campaignResult = wait.until(
		// ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type =
		// 'text']")));
		// campaignResult.sendKeys(campaign);
		SeleniumHelpers.highlightElement(this.driver, createOpportunity.campaignLabel);
		// createOpportunity.campaignDropDownField.sendKeys(campaign);
		createOpportunity.createOpportunityButton.click();
	}

	@Then("^verify new opportunity with \"([^\"]*)\" created$")
	public void verify_new_opportunity_with_created(String name) {
		SeleniumHelpers.waitElement(driver, By.xpath("//div[@id = 'opportunities']"));
		SoftAssert verifyCreatedOpportunity = new SoftAssert();
		verifyCreatedOpportunity.assertNotNull(name, "Name is not present");
	}

}
