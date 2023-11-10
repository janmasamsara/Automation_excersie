package TestNg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Product_quantity13 {
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
		public void Method() {
		System.out.println("application started");
		WebElement Home_page=driver.findElement(By.xpath("//a[contains(text(), \"Home\")]"));
		if(Home_page.isDisplayed())
		{
			WebElement view_product=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a"));
			view_product.click();
			driver.navigate().to("https://automationexercise.com/product_details/1");
			WebElement productdetail=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div"));
			if(productdetail.isDisplayed())
					{
						
						
					}
			
			}
}
}