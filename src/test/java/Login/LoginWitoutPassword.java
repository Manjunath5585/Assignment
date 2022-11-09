package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericUtilities.FileUtilities;
import ObjectRepository.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWitoutPassword {

	FileUtilities fLib=new FileUtilities();
	
	
	@Test
	public void loginwithoutun() throws Throwable
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String URL = fLib.getproperetykeyvalue("url");
		driver.get(URL);
		String USERNAME = fLib.getproperetykeyvalue("username");
		
		
		
		System.out.println("Login to the application");
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("log-in")).click();
		
		String s1 = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
		
		
		Assert.assertEquals("Password must be present", s1);
		driver.quit();
		
	}
}
