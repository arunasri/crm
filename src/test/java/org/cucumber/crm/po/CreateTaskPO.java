package org.cucumber.crm.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateTaskPO {
	public CreateTaskPO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Name:')]")
	public WebElement nameLabel;
	@FindBy(how = How.XPATH, using = "//input[@id = 'task_name']")
	public WebElement nameTextboxField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Due')]")
	public WebElement dueLabel;
	@FindBy(how = How.XPATH, using = "//select[@name = 'task[bucket]']")
	public WebElement dueDropDownField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Assign to:')]")
	public WebElement assigntoLabel;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Unassigned')]")
	public WebElement assigntoDropDownField;
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Category:')]")
	public WebElement categoryLabel;
	@FindBy(how = How.XPATH, using = "//select[@id = 'task_category']")
	public WebElement categoryDropDownField; 
	@FindBy(how = How.XPATH, using = "//div[@class = 'buttonbar']//following-sibling::input")
	public WebElement createButton;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Cancel')]")
	public WebElement cancelLink;
	
	
}