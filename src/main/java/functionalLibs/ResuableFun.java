package functionalLibs;
//import org.openqa.selenium.By;
import org.testng.Assert;

import utilities.GenericMethods;
public class ResuableFun extends GenericMethods {
	////windows related code will be placed in switchToWindow method
	public void switchToWindow(String WindowId)
	{
		try
		{
			driver.switchTo().window(WindowId);
		}
		catch(Exception e)
		{
			Assert.fail("unable to switch the window "+e.getMessage());
		}
	}
	//alert related code will be placed in  switchToAlert method
	public void switchToAlert() 
	{
		try
		{
			driver.switchTo().alert();
			
		}
		catch(Exception e)
		{
			Assert.fail("unable to switch the Alert "+e.getMessage());
		}
		
	}
}
