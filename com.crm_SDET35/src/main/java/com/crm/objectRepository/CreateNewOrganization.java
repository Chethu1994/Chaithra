package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebdriverUtility;

public class CreateNewOrganization extends WebdriverUtility {
	//Initialization
	public CreateNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnztnName;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement orgnznType;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement assignedTo;
	
	@FindBy(name="phone")
	private WebElement phoneNo;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	
	
	public WebElement getSave() {
		return save;
	}



	public WebElement getPhoneNo() {
		return phoneNo;
	}
//Utilization
public WebElement getOrgnztnName() {
		return orgnztnName;
	}



	public WebElement getOrgnznType() {
	return orgnznType;
}



	public WebElement getIndustry() {
		return industry;
	}



public WebElement getAssignedTo() {
		return assignedTo;
	}



public void clickOnOrganztnName(String orgName)	{
	orgnztnName.sendKeys(orgName);
	selectDropdown(industry, "Education");
	}
 
public void selectOrgType() {
	selectDropdown(orgnznType, "Customer");
}

public void selectPhoneNo(String MobNo)
{
	phoneNo.sendKeys(MobNo);
}

public void selectAssignedTo() {
	assignedTo.click();
	}

public void toClickOnSave() {
save.click();
}
}
