package org.cucumber.crm.po;

import org.cucumber.helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {
	WebDriver driver;

	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void wait(By byElement) {
		SeleniumHelpers.waitElement(driver, byElement);
	}
}
