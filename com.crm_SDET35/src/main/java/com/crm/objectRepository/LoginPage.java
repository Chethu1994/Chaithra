package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	 //declaration
		@FindBy(name="user_name")
		private WebElement usernametextedit;
		
		@FindBy(name="user_password")
		private WebElement passwordtextedit;
		
		@FindBy(id="submitButton")
		private WebElement submtbtn;
		
		//initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			}
		
		//utilization
		public WebElement getUsernametxtEdt()
		{
			return usernametextedit;
		}

		public WebElement getPasswordtextedit() {
			return passwordtextedit;
		}

		public WebElement getSubmtbtn() {
			return submtbtn;
		}
		/**
		 * This method use to navigate to the vtiger application
		 * @param username
		 * @param password
		 * click on submit button 
		 */
		
		public void loginToAppli(String USERNAME,String PASSWORD)
		{
			usernametextedit.sendKeys(USERNAME);
			passwordtextedit.sendKeys(PASSWORD);
			submtbtn.click();
		}
}


