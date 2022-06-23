package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcontactlkp;
	
	//Initialization
	public  ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontactlkp() {
		return createcontactlkp;
	}
	
	public void clickOnCreateContactLkp() {
		createcontactlkp.click();
	}

	
}
