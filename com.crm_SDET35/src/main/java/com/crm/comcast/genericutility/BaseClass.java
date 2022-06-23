package com.crm.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static  WebDriver SDriver;
public WebDriver driver;
public DataBaseUtility dLib= new DataBaseUtility();
public ExcelUtility eLib= new ExcelUtility();
public FileUtility fLib= new FileUtility();
public JavaUtility jLib= new JavaUtility();
public WebdriverUtility wLib= new WebdriverUtility();


/**
 * connecting to database
 */
@BeforeSuite(groups= {"smoke","regression"})
public void dbConfig() {
	dLib.connectToDB();
}
//@Parameters( "BROWSER")
@BeforeClass(groups= {"smoke","regression"})
public void launchTheBrowser() throws Throwable {
	String BROWSER = System.getProperty("browser");
	String URL = System.getProperty("url");
	//String BROWSER = fLib.getpropertyKeyValue("browser");
	//String URL = fLib.getpropertyKeyValue("url");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
	else {
		driver= new ChromeDriver();
	}
	SDriver= driver;
	//implicitely wait
	wLib.waitForPageToLoad(driver);
	//enter the URL of the application
	SDriver.get(URL);
	//maximize the window
	driver.manage().window().maximize();
	
}
/**
 * login to application 
 * @throws Throwable 
 */
@BeforeMethod(groups= {"smoke","regression"})
public void loginToApplctn() throws Throwable {
	String USERNAME = fLib.getpropertyKeyValue("username");
	String PASSWORD = fLib.getpropertyKeyValue("password");
	
	LoginPage lpage= new LoginPage(driver);
	lpage.loginToAppli(USERNAME, PASSWORD);
}
/**
 * logout from application 
 */
@AfterMethod(groups= {"smoke","regression"})
public void logoutFromApplctn() {
	HomePage hpage= new HomePage(driver);
	hpage.getAdministratorLink1(driver);
	hpage.clickOnSignoutLink();
}
/**
 * close the browser
 */

@AfterClass(groups= {"smoke","regression"})
public void closeTheBrowser() {
	driver.quit();
}
/**
 * close the Database
 */
@AfterSuite(groups= {"smoke","regression"})
public void closeDBconfig() {
	dLib.closeDB();
}}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

