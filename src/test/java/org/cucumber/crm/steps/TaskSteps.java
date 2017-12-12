package org.cucumber.crm.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.cucumber.crm.po.LoginPagePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
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
		this.driver.findElement(By.partialLinkText("Tasks")).click();
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
	    driver.findElement(By.xpath("//a[contains(text(), 'Team')]")).click();
	}

	@Then("^User should see Aaron Assembler$")
	public void user_should_see_Aaron_Assembler()  {
		
}

	@When("^User clicks on Accounts tab$")
	public void user_clicks_on_Accounts_tab() {
		driver.findElement(By.partialLinkText("Accounts")).click();

	}

	@Then("^User should see the Create Account link$")
	public void user_should_see_the_Create_Account_link() {
		driver.findElement(By.partialLinkText("Create Account"));

	}
	
	@When("^User clicks on campaigns tab$")
	public void user_clicks_on_campaigns_tab() {
		driver.findElement(By.partialLinkText("Campaigns")).click();
	}

	@Then("^User should see the Create Campaigns link$")
	public void user_should_see_the_Create_Campaigns_link() {
		driver.findElement(By.partialLinkText("Create Campaign"));
	}

	@When("^User clicks on Leads tab$")
	public void user_clicks_on_Leads_tab() {
		driver.findElement(By.partialLinkText("Leads")).click();
	}

	@Then("^User should see the Create Leads link$")
	public void user_should_see_the_Create_Leads_link() {
		driver.findElement(By.partialLinkText("Create Lead"));
	}
	//Contacts
	@When("^User clicks on Contacts tab$")
	public void user_clicks_on_Contacts_tab() {
		driver.findElement(By.partialLinkText("Contacts")).click();
	}

	@Then("^User should see the Create Contacts link$")
	public void user_should_see_the_Create_Contacts_link() {
		driver.findElement(By.partialLinkText("Create Contact"));
	}
	//Opportunities
	@When("^User clicks on Opportunities tab$")
	public void user_clicks_on_Opportunities_tab() {
		driver.findElement(By.partialLinkText("")).click();
	}

	@Then("^User should see the Create Opportunity link$")
	public void user_should_see_the_Create_Opportunity_link() {
		driver.findElement(By.partialLinkText(""));
	}
	//Create campaigns
	@Then("^User clicks on create campaign link$")
	public void user_clicks_on_create_campaign_link() {
	   driver.findElement(By.partialLinkText("Create Campaign")).click();
	}
	
}
