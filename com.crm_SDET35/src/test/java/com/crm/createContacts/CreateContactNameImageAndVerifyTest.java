package com.crm.createContacts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateNewCntctPage;
import com.crm.objectRepository.HomePage;

public class CreateContactNameImageAndVerifyTest extends BaseClass {
@Test
	public  void CreateContactNameImageAndVerify() throws Throwable {
		//to get random number
		int randnum = jLib.getrandomnumber();
		ExcelUtility eLib= new ExcelUtility();
		String c1 = eLib.ReadDataFromExcelFile("Sheet1", 11, 0)+randnum;
		String c2 = eLib.ReadDataFromExcelFile("Sheet1", 11, 1)+randnum;
		String imagepath = eLib.ReadDataFromExcelFile("Sheet1", 15, 0);
		//click on contacts link
		HomePage hpage = new HomePage(driver);
		hpage.clickOnContactsLink();
		//click on create contact
		ContactsPage cpage= new ContactsPage(driver);
		cpage.clickOnCreateContactBtn();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		CreateNewCntctPage cnewpage= new CreateNewCntctPage(driver);
		//to enter firstname and lastname
		cnewpage.selectFnDrpdwn(c1, c2);
		//to select contact image
		cnewpage.enterImagePath(imagepath);
		//click on save button
		cnewpage.clickOnSaveBtn();

	}

}
