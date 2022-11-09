package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ObjectRepository.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassUtilities {

	
	public static WebDriver sdriver;
	public WebDriver driver;
	public FileUtilities fLib=new FileUtilities();
	public WebDriverUtilities wLib=new WebDriverUtilities();
	public DataBaseUtilities dLib=new DataBaseUtilities();
	
	@BeforeSuite 
	public void dbconfig()
	{
		dLib.ConnectToDB();
	}
    
	@BeforeClass
	public void launchTheBrowse() throws Throwable
	{
		
			String URL = fLib.getproperetykeyvalue("url");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				//Maximize the window
				driver.manage().window().maximize();
				
				//Use impicitly wait
				wLib.WaitForPageToLoad(driver, 10);
			//Enter the URL
			driver.get(URL);	    	
			
}
		
		@BeforeMethod  
		public void loginToAppln() throws Throwable
		{
		String USERNAME = fLib.getproperetykeyvalue("username");
		String PASSWORD = fLib.getproperetykeyvalue("password");
		
		Login_Page Lp=new Login_Page(driver);
		
		//Login to the application
		Lp.Login_App(USERNAME, PASSWORD);
		System.out.println("Login to the application");
		}
	
		
		
		@AfterMethod 
		public void LogoutFromAppln()
		{
			
			System.out.println("Logout of application");
		}
		
		
		
		@AfterClass   
		public void closeTheBrowser()
		{
			driver.quit();
		}
		@AfterSuite   
		public void closeDBConfig()
		{
			dLib.closeDB();
		}
	}
