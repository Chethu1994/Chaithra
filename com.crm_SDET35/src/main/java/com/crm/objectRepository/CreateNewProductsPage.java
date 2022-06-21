package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebdriverUtility;

public class CreateNewProductsPage extends WebdriverUtility  {
	
	//Initialization
	public CreateNewProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="productname") private WebElement productName;
	@FindBy(name="productcategory") private WebElement productCatgry;
	@FindBy(name="manufacturer") private WebElement manufacturer;
	@FindBy(xpath="//input[@value='T']") private WebElement handler;
	@FindBy(xpath="//select[@name='assigned_group_id']") private WebElement groupdrpdwn;
	@FindBy(xpath="//input[@id='my_file_element']") private WebElement productImage;
	@FindBy(xpath="//input[@value='  Save  ']") private WebElement savebutton;
	
	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getGroupdrpdwn() {
		return groupdrpdwn;
	}

	public WebElement getProductImage() {
		return productImage;
	}

	public WebElement getHandler() {
		return handler;
	}

	public WebElement getManufacturer() {
		return manufacturer;
	}

	public WebElement getProductCatgry() {
		return productCatgry;
	}

	public WebElement getProductName() {
		return productName;
	}
	
	//Utilization
	public void enterProductName(String Product_Name){
		productName.sendKeys(Product_Name);
	}
	public void selectProductCategory()
		{
			selectDropdown(productCatgry, "Software");
			selectDropdownByVtext(manufacturer, "MetBeat Corp");
		}
	
	public void selectHandler() {
		handler.click();
	}
	
	public void selectGroupHandlerDrpdwn() {
		selectDropdown(groupdrpdwn, "4");
	}
	 
	public void uploadProductImage(String IMAGEPATH)
	{
	fileUploadPopup(productImage,IMAGEPATH);
	}
	
	public void clickOnSaveButton()
	{
		savebutton.click(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}


