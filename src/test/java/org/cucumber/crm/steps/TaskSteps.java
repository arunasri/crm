package org.cucumber.crm.steps;

import org.cucumber.crm.po.LoginPagePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskSteps {
	WebDriver driver;

	@Before
	public void initDriver() {
		this.driver = new ChromeDriver();
		this.driver.get("https://qacrm.herokuapp.com");
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
