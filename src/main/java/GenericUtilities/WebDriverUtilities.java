package GenericUtilities;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtilities {
	Select select=null;

	public void WaitForPageToLoad(WebDriver  driver, long wait)
	{
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS); 
	}
	
	public void WaitForTitleContains(String element,WebDriver  driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(element));
		
	}
	

	/**
	 * Here it is used to switch from one frame to another frame using index
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * Here it is used to switch from one frame to another frame using id
	 * @param driver
	 * @param id
	 */
	public void SwitchTOFrame(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * Here it is used to switch from one frame to another frame using WebElement
	 * @param driver
	 * @param element
	 */
	public void SwitchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * Here it is used to switch from one frame to parent frame
	 * @param driver
	 */
	public void SwichBackToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * Here is used to switch to alert popup and accept popup
	 * @param driver
	 */
	public void SwitchToAlertPopupAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * Here is used to switch to alert popup and dismiss popup
	 * @param driver
	 */
	public void SwitchToAlertPopupAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * Here it is used to perform mouse over action
	 * @param driver
	 * @param element
	 */
	public void MoveToElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**Here it is used to click Enter button
	 * 
	 * @param driver
	 */
	public void ClickOnEnterButton(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * Here it is used to take screenshot 
	 * @param driver
	 * @param ScreenshotName
	 * @throws Throwable
	 */
	public void TakeScreenShot(WebDriver driver, String ScreenshotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+ScreenshotName+".PNG");
		FileUtils.copyFile(src, dst);
	}
	
	public void DragAndDrop(WebDriver driver, WebElement ele1, WebElement ele2)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(ele1,ele2).perform();
	}
	/**
	 * It is used to double click on the element
	 * @param driver
	 * @param ele
	 */
	public void DoubleClick(WebDriver driver, WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	/**
	 * It is used to Right click on the element
	 * @param driver
	 * @param element
	 */
	public void ContextClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method use to inializae the select class
	 * @param element
	 */
	public void SelectInialization(WebElement element) {

	}
	}

