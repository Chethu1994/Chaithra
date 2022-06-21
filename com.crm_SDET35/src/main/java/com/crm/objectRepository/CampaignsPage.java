package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignsBtn;


	public WebElement getCreateCampaignsBtn() {
		return createCampaignsBtn;
	}

	public void clickOnCampaignButton() {
		createCampaignsBtn.click();
	}
	
	
}
