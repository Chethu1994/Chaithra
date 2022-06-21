package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
//Initialization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductLkp;

	public WebElement getCreateProductLkp() {
		return createProductLkp;
	}
	
	public void clickOnCreateProductsLkp() {
		createProductLkp.click();
	}
}
