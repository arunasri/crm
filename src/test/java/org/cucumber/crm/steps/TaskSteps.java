package org.cucumber.crm.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.cucumber.crm.po.LoginPagePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("no-sandbox");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new RemoteWebDriver(new URL(seleniumGridURL), capabilities);
		this.driver.get(baseURL);
	}

	@After
	public void closeBrowser() {
		this.driver.quit();
	}

	@Given("^I logged in as admin user$")
	public void i_logged_in_as_admin_user() throws Throwable {
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
}
