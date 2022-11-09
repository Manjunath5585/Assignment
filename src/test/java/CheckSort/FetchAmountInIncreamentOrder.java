package CheckSort;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClassUtilities;
import ObjectRepository.Home_page;



public class FetchAmountInIncreamentOrder extends BaseClassUtilities
{

	static String sort;
	@Test
	public void FetchAmount() throws InterruptedException 
	{
	Home_page H = new Home_page(driver);
		
		//Click on the Amonut Button
		H.Home_Page();
		
		
		List<WebElement> s2 = driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody/tr/td[5]"));
		String[] aftersort=new String[s2.size()];
		
		
		System.out.println("Sorting values in the application");
		for(int i=0;i<s2.size();i++)
		{
			aftersort[i]=s2.get(i).getText().replace("USD", "").trim();
			System.out.println(aftersort[i]);
		}
		
		ArrayList<Float> al=new ArrayList<Float>();
		
		for(int i=0;i<aftersort.length; i++)
		{
			try
			{
				
		    //Convert String in Float
			float f = Float.parseFloat(aftersort[i]);
			al.add(f);
			}
			
			catch(NumberFormatException e)
			{
				
			} 
			
		}
		
		boolean flag = true;
		for(int i=1;i<al.size();i++)
		{
			if(al.get(i)<al.get(i-1))
			{
				flag=false;
				break;
			}
		}
		
		System.out.println(flag);
		
		//Validating by using assertion 
		Assert.assertTrue(flag);
		System.out.println("Testcase  pass");
	
		
	}
	
}
