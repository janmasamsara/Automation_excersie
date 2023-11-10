package TestNg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Contact_us {
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
		public void method() {
			System.out.println("application started");
			WebElement Home_page=driver.findElement(By.xpath("//a[contains(text(), \"Home\")]"));
			if(Home_page.isDisplayed())
			{
				WebElement contact_formbtn=driver.findElement(By.xpath("//a[contains(text(),\" Contact us\")]"));
				contact_formbtn.click();
				WebElement get_intouch=driver.findElement(By.xpath("//h2[contains(text(),\"Get In Touch\")]"));
				if(get_intouch.isDisplayed())
				{
					WebElement name=driver.findElement(By.xpath("//input[@name=\"name\"]"));
					name.sendKeys("virat");
					WebElement Email=driver.findElement(By.xpath("//input[@name=\"email\"]"));
					Email.sendKeys("Kohilbatsman718@gmail.com");
					WebElement subject=driver.findElement(By.xpath("//input[@name=\"subject\"]"));
					subject.sendKeys("Logout functionality");
					WebElement ur_msg=driver.findElement(By.xpath("//textarea[@name=\"message\"]"));
					ur_msg.sendKeys("Taking long-time to load");
					WebElement submit_btn=driver.findElement(By.xpath("//input[@name=\"submit\"]"));
					submit_btn.click();
					driver.switchTo().alert().accept();
					WebElement succcess_msg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]"));
					if(succcess_msg.isDisplayed())
					{
						
						WebElement Home_btn=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]/a"));
						Home_btn.click();
						WebElement home_page=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[1]/a"));
						if(home_page.isDisplayed())
						{
							System.out.println("sublitted the contactus form");
						}
					}

					
				}
			}
		}
}
