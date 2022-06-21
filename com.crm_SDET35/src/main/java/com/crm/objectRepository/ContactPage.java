package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcstmr;
	
	//Initialization
	public  ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
//Utilization
	public WebElement createContact()
	{
		return createcstmr; 
	}
}
