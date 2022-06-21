package Assignments;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.objectRepository.ContactInfoPage;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.CreateNewCntctPage;
import com.crm.objectRepository.HomePage;
@Listeners(com.crm.comcast.genericutility.ListImplementClass.class)
public class CreateContactVerifyTest extends BaseClass {
	@Test(retryAnalyzer = com.crm.comcast.genericutility.RetryImpAnalyser.class)
	public  void createContactVerify() throws Throwable {
	
		//to get random number
		int randnum = jLib.getrandomnumber();
		String FirstName = eLib.ReadDataFromExcelFile("Sheet1", 7, 2)+randnum;
		String LastName = eLib.ReadDataFromExcelFile("Sheet1", 7, 3)+randnum;
		String Birthday = eLib.ReadDataFromExcelFile("Sheet1", 7, 4);
		//click on contacts link
		HomePage hpage= new HomePage(driver);
		hpage.clickOnContactsLink();
		//click on create contact 
		ContactPage cpage= new ContactPage(driver);
	    cpage.createContact().click();
		CreateNewCntctPage cnewpage= new CreateNewCntctPage(driver);
        cnewpage.createContact(FirstName, LastName);
		ContactInfoPage cinfopage= new ContactInfoPage(driver);
        WebElement ele2 = cinfopage.getContactHeaderTxt();
      //  Assert.fail();
		System.out.println(ele2);
		String text = ele2.getText();
		assertTrue(text.contains(LastName) );
		System.out.println("contact is created\"+\"------->\"+\"Test case Pass");
		
		}
}




