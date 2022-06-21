package com.crm.comcast.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * contains all reusable Actions of Webdriver
 * @author chethu
 *
 */
public class WebdriverUtility {
	/**
	 * its an implicitely wait always wait for element in DOM document and release the control  if element is available
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * it will wait for js element
	 * @param driver
	 */
	public void waitforPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10,  TimeUnit.SECONDS);	
	}
	/**
	 * its an explicitely wait for page to be loaded and available in GUI
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * it is an Explicitely wait always wait for page to be loaded andavailable in GUI
	 */
	public void waitForTitleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10) ;
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * here we can change the polling time from default 500ms to any polling time
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver  ,int pollingTime,WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * here we are giving custom timeout
	 * @param element
	 * @throws interruptedExceptions
	 */
	public void waitAndClick(WebElement element)throws InterruptedException{
		int count=0;
		while(count<10)
		{
			try {
				element.click();
			}catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	public void switchToParentWindow(WebDriver driver,String parentId)
	{
		driver.switchTo().window(parentId);
	}
	/**
	 * It is used to switch to any Window based on window Title
	 * @param driver
	 * @param partial window Title
	 */
	public void switchToWindow(WebDriver driver,String partialwindow) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currentWindow = driver.getTitle();
			if(currentWindow.contains(partialwindow))
			{
				break;
			}
		}
	}
	/**
	 * switch from one frame to another frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * switching from one frame to another frame by using id_attribute
	 * @param driver
	 * @param id_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_attribute)
	{
		driver.switchTo().frame(id_attribute);
	}
	/**
	 * switch from one frame to another frame by using absolute path 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * it is used to switch back from one child frame to parent frame
	 */
	public void switchBackToMainFrame(WebDriver driver )
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * it is used  switch to  alert pop up and accept
	 * @param driver
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * it is used to switch to alert popup and dismiss
	 * @param driver
	 */
	public void switchToAlertAndDismiss( WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * it is used to switch to dropdown  by using index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * it is used to select dropdown by using value 
	 * @param element
	 * @param value
	 */
	public void selectDropdown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * it is used to select dropdown by using visible_text
	 * @param element
	 * @param visible_text
	 */
	public void selectDropdownByVtext(WebElement element,String visible_text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(visible_text);
	}

	/**
	 * it is used to mouse over an element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * it is used to mouse over an element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * it is used to click on enter button using keyboard actions
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * it is used to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable 
	 */
	public void takeScreenShot(WebDriver driver, String screenshotName) throws Throwable	{
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot");
		Files.copy(src, dst);
	}
	/**
	 * it is used to perform scrollBar Actions
	 * @param driver
	 */							
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollby(0,500)");
	}
	/**
	 * 
	 */
	public void fileUploadPopup(WebElement element,String path)
	{
		element.sendKeys(path);
	}


}























































