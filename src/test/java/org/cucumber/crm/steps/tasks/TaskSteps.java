package org.cucumber.crm.steps.tasks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.cucumber.crm.po.DashboardPO;
import org.cucumber.crm.po.LoginPagePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskSteps {
	WebDriver driver;
	String seleniumGridURL = System.getProperty("SELENIUM_GRID");
	String baseURL = System.getProperty("WEBSITE_URL");

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

	@Given("^User should logged in as admin user$")
	public void user_should_logged_in_as_Admin_user() {
		LoginPagePO loginPO = new LoginPagePO(driver);
		loginPO.login("george", "george");
	}

	@Given("^I am tasks tab$")
	public void i_am_tasks_tab() throws Throwable {
		DashboardPO taskTab = new DashboardPO(this.driver);
		taskTab.openTaskTab();
		
	}

	@When("^I create Task$")
	public void i_create_Task() throws Throwable {
		this.driver.findElement(By.partialLinkText("Create Task"));
	}

	@Then("^I should see the newly created task$")
	public void i_should_see_the_newly_created_task() throws Throwable {
	}
	
	@When("^User clicks on Team tab$")
	public void user_clicks_on_Team_tab()  {
		DashboardPO teamTab = new DashboardPO(this.driver);
		teamTab.openTeamTab();
	    
	}

	@Then("^User should see Aaron Assembler$")
	public void user_should_see_Aaron_Assembler()  {
		
	}

	@When("^User clicks on Accounts tab$")
	public void user_clicks_on_Accounts_tab() {
		DashboardPO accountTab = new DashboardPO(this.driver);
		accountTab.openAccountTab();
	}

	@Then("^User should see the Create Account link$")
	public void user_should_see_the_Create_Account_link() {
		driver.findElement(By.partialLinkText("Create Account"));

	}
	
	@When("^User clicks on campaigns tab$")
	public void user_clicks_on_campaigns_tab() {
		DashboardPO campaignTab = new DashboardPO(this.driver);
		campaignTab.openAccountTab();
	}

	@Then("^User should see the Create Campaigns link$")
	public void user_should_see_the_Create_Campaigns_link() {
		driver.findElement(By.partialLinkText("Create Campaign"));
	}

	@When("^User clicks on Leads tab$")
	public void user_clicks_on_Leads_tab() {
		DashboardPO leadTab = new DashboardPO(this.driver);
		leadTab.openLeadTab();
	}

	@Then("^User should see the Create Leads link$")
	public void user_should_see_the_Create_Leads_link() {
		driver.findElement(By.partialLinkText("Create Lead"));
	}
	//Contacts
	@When("^User clicks on Contacts tab$")
	public void user_clicks_on_Contacts_tab() {
		DashboardPO ContactTab = new DashboardPO(this.driver);
		ContactTab.openContactTab();
	}

	@Then("^User should see the Create Contacts link$")
	public void user_should_see_the_Create_Contacts_link() {
		driver.findElement(By.partialLinkText("Create Contact"));
	}
	//Opportunities
	@When("^User clicks on Opportunities tab$")
	public void user_clicks_on_Opportunities_tab() {
		DashboardPO opportunityTab = new DashboardPO(this.driver);
		opportunityTab.openOpportunityTab();
	}

	@Then("^User should see the Create Opportunity link$")
	public void user_should_see_the_Create_Opportunity_link() {
		driver.findElement(By.partialLinkText(""));
	}
	//Create campaigns
	@Then("^User clicks on create campaign link$")
	public void user_clicks_on_create_campaign_link() {
		DashboardPO campaign = new DashboardPO(this.driver);
		campaign.createCampaignLink();
	}
	@Then("^Verify user is on create campaign page$")
	public void verify_user_is_on_create_campaign_page() {
	   //driver.findElement(By.xpath("//div[contains(text(), 'Name:')]"));
	}
	//Create Leads
	@Then("^User clicks on create Lead link$")
	public void user_clicks_on_create_lead_link() {
		DashboardPO createLead = new DashboardPO(this.driver);
		createLead.clickCreateLeadButton();
	}
	@Then("^Verify user is on Create Lead page$")
	public void verify_user_is_on_create_lead_page() {
		driver.findElement(By.xpath("//div[contains(text(), 'Lead Statuses')]"));
	}
	
	//Leads creating

	@And("^enter all the details$")
	public void enter_all_the_details() {
		Timeouts timeouts = driver.manage().timeouts();
		timeouts.implicitlyWait(5, TimeUnit.SECONDS);
		
		
	    driver.findElement(By.xpath("//input[@id = 'lead_first_name']")).sendKeys("Adam");
	    driver.findElement(By.xpath("//input[@id = 'lead_last_name']")).sendKeys("vim");
	    driver.findElement(By.xpath("//input[@id = 'lead_email']")).sendKeys("test123@gmail.com");
	    driver.findElement(By.xpath("//input[@id = 'lead_phone']")).sendKeys("1112223333");
	}

	@And("^clicks on create lead button$")
	public void clicks_on_create_lead_button() {
		DashboardPO leadButton = new DashboardPO(this.driver);
		leadButton.clickCreateLeadButton();
	}

	@And("^verify created lead$")
	public void verify_created_lead() {
		SoftAssert checkAssert = new SoftAssert();
	    WebElement lead = driver.findElement(By.xpath("//div[@class = 'list']"));
	    checkAssert.assertEquals(lead.getText(), "Adam", "Adam is created");
	}
}
