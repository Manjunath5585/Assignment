package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	//Declaration
	@FindBy(id="username")
	private WebElement unTf;
	
	@FindBy(id="password")
	private WebElement pwdTf;
	
	@FindBy(id="log-in")
	private WebElement lgnBtn;
	
	//Initialization
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUnTf() {
		return unTf;
	}

	public WebElement getPwdTf() {
		return pwdTf;
	}

	public WebElement getLgnBtn() {
		return lgnBtn;
	}
	
	public void Login_App(String username,String password)
	{
		unTf.sendKeys(username);
		pwdTf.sendKeys(password);
		lgnBtn.click();
	}
	

}
