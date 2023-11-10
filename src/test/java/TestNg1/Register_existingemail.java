package TestNg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Register_existingemail {
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
						String NameData=Name;
						System.out.println(NameData);
						String EmailData=Email_Address;
						System.out.println(EmailData);
						WebElement Username=driver.findElement(By.xpath("//input[@name=\"name\"]"));
						Username.sendKeys(NameData);
						WebElement Email_addr=driver.findElement(By.xpath("//section[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
						Email_addr.sendKeys(EmailData);
						WebElement signup=driver.findElement(By.xpath("//button[contains(text(),\"Signup\")]"));
						signup.click();
						WebElement email_existsmsg=driver.findElement(By.xpath("//p[contains(text(),\"Email Address already exist!\")]"));
						if(email_existsmsg.isDisplayed())
						{
							System.out.println(email_existsmsg.getText());
						}
						}
}
			}

			}