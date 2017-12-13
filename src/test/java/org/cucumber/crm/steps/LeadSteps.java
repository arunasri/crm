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

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LeadSteps {
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
	
	@Given("^user should logged in as admin user$")
	public void user_should_logged_in_as_admin_user() {
		LoginPagePO loginPO = new LoginPagePO(driver);
		loginPO.login("george", "george");
	}

	@When("^user clicks on Leads tab$")
	public void user_clicks_on_Leads_tab() {
		driver.findElement(By.partialLinkText("Leads")).click();
	}

	@Then("^user clicks on create Lead link$")
	public void user_clicks_on_create_Lead_link() {
		driver.findElement(By.partialLinkText("Create Lead")).click();
	}

	@Then("^enter all the details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_all_the_details_and_and_and(String firstname, String lastname, String email, String phone) {
	    
	}

	@Then("^clicks on create lead button$")
	public void clicks_on_create_lead_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^verify created lead$")
	public void verify_created_lead() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
