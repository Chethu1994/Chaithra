package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Initialization
		public  OrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	//Declaration	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrganizationLkp;
	
	//Utilization
	public void clickOnCreateOrganizationLkp() {
		CreateOrganizationLkp.click();
	}

}
