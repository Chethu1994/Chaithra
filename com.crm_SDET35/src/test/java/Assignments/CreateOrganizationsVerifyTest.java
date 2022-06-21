package Assignments;


	

	import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.objectRepository.CreateNewOrganization;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganizationInfoPage;
import com.crm.objectRepository.OrganizationPage;

	public class CreateOrganizationsVerifyTest extends BaseClass {
		@Test(groups= "smoke")
		public  void CreateOrganizationsVerify() throws Throwable {
			JavaUtility jLib =new JavaUtility();
			  int randnum = jLib.getrandomnumber();
			ExcelUtility eLib=new ExcelUtility();
			String OrgName = eLib.ReadDataFromExcelFile("Sheet1", 4, 2)+randnum;
			String MobNo = eLib.ReadIntDataFromExcelFile("Sheet1", 14, 1);
			System.out.println(MobNo);
		    System.out.println(OrgName);
		    //create organisation
		     HomePage hpage= new HomePage(driver); 
            hpage.clickOnOrganizationLnk();
		     OrganizationPage opage= new OrganizationPage(driver);
             opage.clickOnCreateOrganizationLkp();
		     CreateNewOrganization cneworgpage= new CreateNewOrganization(driver);
			cneworgpage.clickOnOrganztnName(OrgName); 
	        //industry type
			cneworgpage.selectOrgType();
			//Assert.fail();
	        cneworgpage.selectAssignedTo();
			cneworgpage.selectPhoneNo(MobNo);
			cneworgpage.toClickOnSave();
	       OrganizationInfoPage orginfopage= new OrganizationInfoPage(driver);
            WebElement ele4 = orginfopage.getOrganznHeaderTxt();
	         String text = ele4.getText();
	       if(text.contains(OrgName))
	  	     {
	  		  System.out.println("Organisations is  created"+"------->"+"Test case Pass");
	  	     }
	  	  else
	  	     {
	  		  System.out.println("Organisations is not created"+"------->"+"Test case Fail");
	  	  }   
		}
	}


