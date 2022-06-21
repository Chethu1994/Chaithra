package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Initialization
		public  ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
@FindBy(xpath="//img[@title='Create Contact...']") private WebElement createContactBtn;

//declaration 
public WebElement getCreateContactBtn() {
	return createContactBtn;
}
 public void clickOnCreateContactBtn() {
	 createContactBtn.click();
 }

}
