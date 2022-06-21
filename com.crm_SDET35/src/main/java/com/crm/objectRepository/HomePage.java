package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebdriverUtility;

public class HomePage extends WebdriverUtility {
	//declaration
@FindBy(xpath="//a[.='Contacts']") 
private WebElement contacts;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement getAdministratorLink;

@FindBy(xpath="//a[.='Sign Out']")
private WebElement signoutLink;

@FindBy(xpath="//a[.='Organizations']")
private WebElement organizationLink;

@FindBy(linkText="Products")
private WebElement productsLink;

@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']") 
private WebElement moreDropdown;

@FindBy(name="Campaigns")
private WebElement campaignsLink;




public WebElement getCampaignsLink() {
	return campaignsLink;
}
public WebElement getContacts() {
	return contacts;
}
public WebElement getGetAdministratorLink() {
	return getAdministratorLink;
}
public WebElement getOrganizationLink() {
	return organizationLink;
}
public WebElement getMoreDropdown() {
	return moreDropdown;
}
//initialization
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Utilization
public  void getAdministratorLink1(WebDriver driver)
{
	mouseOverAnElement(driver,getAdministratorLink);
}
public WebElement getSignoutLink()
{
	return signoutLink;
}

public WebElement  getContactLink()
{
	  return contacts;
}



public WebElement getProductsLink() {
	return productsLink;
}

	//signoutLink.click();

public void clickOnOrganizationLnk() {
	organizationLink.click();
}

public void clickOnProductLink() {
	productsLink.click();
	
}

public void mouseOverOnMore(WebDriver driver){
	mouseOverAnElement(driver, moreDropdown);
	
}

public void clickOnCmpaignsLink() {
	campaignsLink.click();
}

public void clickOnSignoutLink() {
	signoutLink.click();
	
}

public void clickOnContactsLink() {
	contacts.click();
}










}

