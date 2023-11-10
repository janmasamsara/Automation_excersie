package testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.GenericMethods;
import webpages.AutomationSignupWebpages;

public class AutomationTestcase extends GenericMethods{
@Test
	public void test() 
{
	//object creation for parent-class
	GenericMethods gm=new GenericMethods();
	//pom pattern
	AutomationSignupWebpages gwebpages=PageFactory.initElements(driver,AutomationSignupWebpages.class);
	gm.click(gwebpages.homepage_btn,"Home");
	gm.input(gwebpages.name_Txt,"virat","Name");
	gm.input(gwebpages.Email_address_Txt,"virat18@gmail.com","Email Address");
	gm.click(gwebpages.signup_btn,"signup button");
	gm.click(gwebpages.enter_accountinfo_btn,"Account Information");
	
}
}
