package TestNg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Logout_user {
public static WebDriver driver;
public static ChromeOptions options;
	@BeforeMethod
public void beforeMethod() 
{
	System.out.println("common code");
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			 driver = new ChromeDriver();
			 options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver.get("https://automationexercise.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		@Test
		@Parameters({"Name","Email Address"})
		public void method(String Name,String Email_Address) throws InterruptedException 
		{
			System.out.println("application started");
			WebElement Home_page=driver.findElement(By.xpath("//a[contains(text(), \"Home\")]"));
			if(Home_page.isDisplayed())
			{
				WebElement signup_btn=driver.findElement(By.xpath("//a[contains(text(),\" Signup / Login\")]"));
				signup_btn.click();
				WebElement new_user_signup=driver.findElement(By.xpath("//h2[contains(text(),\"New User Signup!\")]"));
				if(new_user_signup.isDisplayed())
					{
						//passing data through parameters Annotation,generate .xml file
						String NameData=Name;
						System.out.println(NameData);
						String EmailData=Email_Address;
						System.out.println(EmailData);
						WebElement Username=driver.findElement(By.xpath("//input[@name=\"name\"]"));
						Username.sendKeys(NameData);
						WebElement Email_addr=driver.findElement(By.xpath("//section[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
						Email_addr.sendKeys(EmailData);
						WebElement sign_btn=driver.findElement(By.xpath("//button[contains(text(),\"Signup\")]"));
						sign_btn.click();
						WebElement enter_accountinfo=driver.findElement(By.xpath("//b[contains(text(),\"Enter Account Information\")]"));
						if(enter_accountinfo.isDisplayed())
						{
							WebElement Title=driver.findElement(By.xpath("//input[@id=\"id_gender1\"]"));
							click(Title,"Mrs.");	
							WebElement password=driver.findElement(By.xpath("//input[@id=\"password\"]"));
							password.sendKeys("January@32");
							WebElement DOB_day=driver.findElement(By.xpath("//select[@id=\"days\"]"));
							selectByValue(DOB_day,"3","Day");
							WebElement DOB_month=driver.findElement(By.xpath("//select[@id=\"months\"]"));
							selectByValue1(DOB_month,"1","Month");
							WebElement DOB_year=driver.findElement(By.xpath("//select[@id=\"years\"]"));
							selectByValue2(DOB_year,"2000","Year");
							WebElement checkbox1=driver.findElement(By.xpath("//label[contains(text(),\"Sign up for our newsletter!\")]"));
							checkbox1.click();
							WebElement checkbox2=driver.findElement(By.xpath("//label[contains(text(),\"Receive special offers from our partners!\")]"));
							checkbox2.click();	
							WebElement first_name=driver.findElement(By.xpath("//input[@id=\"first_name\"]"));
							first_name.sendKeys("virat");
							WebElement last_name=driver.findElement(By.xpath("//input[@id=\"last_name\"]"));
							last_name.sendKeys("kohli");
							WebElement company=driver.findElement(By.xpath("//input[@id=\"company\"]"));
							company.sendKeys("Kyndryl");
							WebElement address1=driver.findElement(By.xpath("//input[@id=\"address1\"]"));
							address1.sendKeys("V.N.R garden street");
							WebElement address2=driver.findElement(By.xpath("//input[@id=\"address2\"]"));
							address2.sendKeys("8-4-1A");
							WebElement country=driver.findElement(By.xpath("//select[@id=\"country\"]"));
							selectByvalue3(country,"India","Country");
							WebElement state=driver.findElement(By.xpath("//input[@id=\"state\"]"));
							state.sendKeys("AndhraPradesh");
							WebElement city=driver.findElement(By.xpath("//input[@id=\"city\"]"));	
							city.sendKeys("Nellore");
							WebElement zipcode=driver.findElement(By.xpath("//input[@id=\"zipcode\"]"));
							zipcode.sendKeys("524137");
							WebElement mobile_no=driver.findElement(By.xpath("//input[@id=\"mobile_number\"]"));
							mobile_no.sendKeys("949312365");
							WebElement createAcc_btn=driver.findElement(By.xpath("//button[contains(text(),\"Create Account\")]"));
							WebDriverWait wait = new WebDriverWait(driver,30);
							wait.until(ExpectedConditions.elementToBeClickable(createAcc_btn)).click();
							
							//Thread.sleep(5000);
							WebElement accountcreate_msg=driver.findElement(By.xpath("//b[contains(text(),\"Account Created!\")]"));
							if(accountcreate_msg.isDisplayed())
							{
							WebElement continue_btn=driver.findElement(By.xpath("/html/body/section/div/div/div/div/a"));
							
							WebDriverWait wait11 = new WebDriverWait(driver,30);
								wait11.until(ExpectedConditions.elementToBeClickable(continue_btn)).click();
							
							WebElement logout_btn=driver.findElement(By.xpath("//a[contains(text(),\" Logout\")]"));
							WebDriverWait wait_time = new WebDriverWait(driver,50);
							wait_time.until(ExpectedConditions.elementToBeClickable(logout_btn)).click();
								WebElement login_accountmsg=driver.findElement(By.xpath("//h2[contains(text(),\"Login to your account\")]"));
								if(login_accountmsg.isDisplayed()) {
									WebElement Email_add=driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/form/input[2]"));
									Email_add.sendKeys(EmailData);
									WebElement pwd=driver.findElement(By.xpath("//input[@name=\"password\"]"));
									pwd.sendKeys("January@32");
									WebElement login_btn=driver.findElement(By.xpath("//button[contains(text(),\"Login\")]"));
									login_btn.click();
									//WebDriverWait wait_success= new WebDriverWait(driver,30);
									//wait_success.until(ExpectedConditions.elementToBeClickable(login_username));
									WebElement logged_username=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a"));
									if(logged_username.isDisplayed())
									{
										WebElement logout_btn1=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"));
										logout_btn1.click();
										WebElement login_page=driver.findElement(By.xpath("//h2[contains(text(),\"Login to your account\")]"));
										if(login_page.isDisplayed())
										{
											System.out.println("user is navigated to Login page ");
										}
									}
								}
							}
						}
						
					}
		}
			
	}

		
	public void click(WebElement Title, String string) 
		{
			// TODO Auto-generated method stub
			try
			{
				if(Title.isDisplayed()||Title.isEnabled())
				{
					Title.click();
				}
			}
			catch(Exception e) 
			{
				Assert.fail("Element is not displayed at this point of time"+e.getMessage());
			}
		}
		public void selectByValue(WebElement DOB_day, String string, String string2) {
			// TODO Auto-generated method stub
			try {
			if(DOB_day.isDisplayed())
			{
				new Select(DOB_day).selectByValue(string);
			}
			}
			catch(Exception e)
			{
				Assert.fail("unable to select value at this point "+e.getMessage());
				
			}
			}
		public void selectByValue1(WebElement DOB_month, String month, String field_name) {
			// TODO Auto-generated method stub
			try {
			if(DOB_month.isDisplayed())
			{
				new Select(DOB_month).selectByValue(month);
			}
			}
			catch(Exception e)
			{
				Assert.fail("unable to select value at this point "+e.getMessage());
			}
		}
			public void selectByValue2(WebElement DOB_year, String year, String field_name)
			{
				// TODO Auto-generated method stub
				try 
				{
					if(DOB_year.isDisplayed())
					{
						new Select(DOB_year).selectByValue(year);
					}
				}
				catch(Exception e)
				{
					Assert.fail("unable to select value at this point "+e.getMessage());
				}
			}	
			
			
	public void selectByvalue3(WebElement country, String countryname, String string2) {
		// TODO Auto-generated method stub
		try
		{
			if(country.isDisplayed())
			{
				new Select(country).selectByValue(countryname);
			}
		}
		catch(Exception e)
		{
			Assert.fail("unable to select value at this point "+e.getMessage());
		}
		
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("close the application");
		driver.close();
	}

	}



		