package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {

	//Declaration
	@FindBy(id="amount")
	private WebElement AmtTf;
	
	//Initialization
	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Utilization
	public WebElement getAmtTf() {
		return AmtTf;
	}
	
	
	public void Home_Page()
	{
		AmtTf.click();
	}
	
}
