package TestNg1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Search_Product {
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
public void method() 
	{
		System.out.println("application started");
		WebElement Home_page=driver.findElement(By.xpath("//a[contains(text(), \"Home\")]"));
		if(Home_page.isDisplayed()) 
		{
			WebElement product_btn=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a"));
			product_btn.click();
			driver.navigate().to("https://automationexercise.com/products");
			//WebElement allproducts_page=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));	
			WebElement product_btn1=driver.findElement(By.xpath("//input[@name=\"search\"]"));
			product_btn1.sendKeys("Winter Top");
			WebElement search_bar=driver.findElement(By.xpath("//button[@id=\"submit_search\"]"));
			search_bar.click();
			try 
			{
				Thread.sleep(3000);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement searched_prod =driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));
			if(searched_prod.isDisplayed())
			{
				WebElement product_list=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]"));
				if(product_list.isDisplayed())
				{
					System.out.println("Related search product is displayed");
				}
				
				}
			}
		}


			@AfterMethod
			public void afterMethod() {
				System.out.println("close the connection");
				driver.quit();
			}
}			
			
			