package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.WebdriverUtility;

public class CreateNewCntctPage extends WebdriverUtility {
	
	
	//declaration
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement fndrpdwn;
	
	@FindBy(name="firstname")
	private WebElement fn;
	
	@FindBy(name="lastname")
	private WebElement ln;
	
	@FindBy(xpath="//img[@id='jscal_trigger_support_start_date']")
	private WebElement startdate;
	
	@FindBy(xpath="//td[.='29']")
	private WebElement date;
	
	@FindBy(name="imagename")
	public WebElement contactimg;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save;
//initialization
	public CreateNewCntctPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement handleFnDrpdwn()
	{
		return fndrpdwn ;
		}
	public WebElement enterFirstname() {
		return fn;
		
	}
	public WebElement enterlastName()
	{
		return ln;
}
	
	public WebElement enterDate()
	{
		return date;
	}
	public WebElement uploadImage()
	{
		return contactimg;		
	}
	public WebElement SaveConsendtact()
	{
		return save;
	}
	/**
	 * @param username
	 * @param password
	 * click on submit button 
	 * @throws Throwable 
	 */
	public void createContact(String FirstName ,String LastName ) throws Throwable
	{
		selectDropdown(fndrpdwn, "Mr.");
	    fn.sendKeys(FirstName);
		ln.sendKeys(LastName);
		startdate.click();
		date.click();
	    save.click();
		}
	public void selectFnDrpdwn(String c1,String c2) {
		selectDropdown(fndrpdwn, "Mr.");
		fn.sendKeys(c1);
		ln.sendKeys(c2);
		}
	public void enterImagePath(String imagepath ) {
	contactimg.sendKeys(imagepath);
	}
	public void clickOnSaveBtn() {
		save.click();
	}
	
}
	


