package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebdriverUtility;

public class CreateNewCampaignPage extends WebdriverUtility {
	
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;
	
	@FindBy(name="campaigntype")
	private WebElement campaignType;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productLkp;
	
	@FindBy(xpath="//b[.='Campaign Information']/ancestor::tr/preceding-sibling::tr//div/input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="search_txt")
	private WebElement productSearch;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement ProductNameLink;

	
 




	public WebElement getProductNameLink() {
		return ProductNameLink;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}

	public WebElement getProductLkp() {
		return productLkp;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getProduct() {
		return productLkp;
	}

	public WebElement getCampaignType() {
		return campaignType;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}
	
	public void enterCampaigName(String Campaign_Name) {
		campaignName.sendKeys(Campaign_Name);
		
	}
	
	public void selectCmpgnType() {
		selectDropdown(campaignType, "Telemarketing");
		
	}
	
	public void clickOnProductLkp(WebDriver driver) {
		productLkp.click();
		
		switchToWindow(driver, "Products&action");
		
		
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
		}
	public void enterProduct(String Product_Name) {
		 productSearch.sendKeys(Product_Name);

	
	}
	public void switchBackToMainWindow(WebDriver driver) {
	switchToWindow(driver,"Campaigns&action");
	}
	
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	 public void selectAProduct() {
		 ProductNameLink.click();
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

