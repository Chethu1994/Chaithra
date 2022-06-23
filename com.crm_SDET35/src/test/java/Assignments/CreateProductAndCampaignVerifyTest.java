package Assignments;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.objectRepository.CampaignInfoPage;
import com.crm.objectRepository.CampaignsPage;
import com.crm.objectRepository.CreateNewCampaignPage;
import com.crm.objectRepository.CreateNewProductsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.ProductInfoPage;
import com.crm.objectRepository.ProductsPage;

public class CreateProductAndCampaignVerifyTest extends BaseClass {
	@Test(groups= "regression",retryAnalyzer = com.crm.comcast.genericutility.RetryImpAnalyser.class)

	public void createProductAndCampaignVerify() throws Throwable {
		
		String IMAGEPATH = fLib.getpropertyKeyValue("imagepath");
		System.out.println(IMAGEPATH);
        JavaUtility jLib=new JavaUtility();
		int randnum = jLib.getrandomnumber();
        ExcelUtility eLib=new ExcelUtility();
		String Product_Name = eLib.ReadDataFromExcelFile("Sheet1", 2, 2)+randnum;
		String Campaign_Name = eLib.ReadDataFromExcelFile("Sheet1", 11, 2)+randnum;
		System.out.println(Product_Name);
		System.out.println(Campaign_Name);
	
		// click on products link
		HomePage hpage= new HomePage(driver);
		hpage.clickOnProductLink();
		//click on create products button
		ProductsPage prdctpage= new ProductsPage(driver);
		prdctpage.clickOnCreateProductsLkp();
		//enter product name
		CreateNewProductsPage cnewprdctpage= new CreateNewProductsPage(driver);
		cnewprdctpage.enterProductName(Product_Name);
		//enter product category,manufacturer
		cnewprdctpage.selectProductCategory();
		//Select handler
		cnewprdctpage.selectHandler();
		//Select Handler 
		cnewprdctpage.selectGroupHandlerDrpdwn();
		//to upload a product image
		cnewprdctpage.uploadProductImage(IMAGEPATH);
		//to save the product
		cnewprdctpage.clickOnSaveButton();
		//verification
		ProductInfoPage pinfopg=new ProductInfoPage(driver);
		//Assert.fail();
		WebElement ele2 = pinfopg.getProductHeaderTxt();
		System.out.println(ele2);
		String text = ele2.getText();
		if(text.contains(Product_Name))
		{
			System.out.println("Product is created"+"------->"+"Test case Pass");
		}
		else
		{
			System.out.println("Product is  not created"+"------->"+"Test case Fail");
		}
		// fetch parent id
		String parentId = driver.getWindowHandle();
		//mouse over on more 
		hpage.mouseOverOnMore(driver);
		//select campaign link
        hpage.clickOnCmpaignsLink();
        //click on campaign link
		CampaignsPage cpage= new CampaignsPage(driver);
		//click on campaign button 
		cpage.clickOnCampaignButton();
		CreateNewCampaignPage cnewcmpnpage=new CreateNewCampaignPage(driver);
		//enter campaign name
		cnewcmpnpage.enterCampaigName(Campaign_Name);
		//select campaign type
		cnewcmpnpage.selectCmpgnType();
		//select product 
		cnewcmpnpage.clickOnProductLkp(driver);
		wLib.switchToWindow(driver, parentId);
		//enter product name
		cnewcmpnpage.enterProduct(Product_Name);
		//search for created product
		cnewcmpnpage.clickOnSearchBtn();
		//select the product
		cnewcmpnpage.selectAProduct();
		//switch to main window
		cnewcmpnpage.switchToParentWindow(driver,parentId);
		System.out.println("switched");
		//click on save button
		cnewcmpnpage.clickOnSaveButton();
		//verification
		CampaignInfoPage cinfopage= new CampaignInfoPage(driver);
		WebElement ele5 = cinfopage.getCampaignHeaderTxt();
		String text1 = ele5.getText();
		if(text1.contains(Campaign_Name))
		{
			System.out.println("Campaign_Name is  created"+"------->"+"Test case Pass");
		}
		else
		{
			System.out.println("Campaign_Name is not created"+"------->"+"Test case Fail");
		}	   
	}

}





