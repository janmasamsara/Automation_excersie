package TestNg1;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Add_prodcart {
	public WebDriverWait wait = null;

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
	public void method() throws InterruptedException 
		{
			System.out.println("application started");
			WebElement Home_page=driver.findElement(By.xpath("//a[contains(text(), \"Home\")]"));
			if(Home_page.isDisplayed()) 
			{
				WebElement product_btn=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[2]/a"));
				product_btn.click();
				Actions action=new Actions(driver);
				WebElement mousehover_product1=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]"));
				action.moveToElement(mousehover_product1).build().perform();
			
				WebElement addcart1_btn=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.elementToBeClickable(addcart1_btn)).click();
				//addcart1_btn.click();
				WebElement continue_btn=driver.findElement(By.xpath("//button[contains(text(),\"Continue Shopping\")]"));
				continue_btn.click();
				WebElement mousehover_product2=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]"));
				action.moveToElement(mousehover_product2).build().perform();
				WebElement addcart2_btn=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a"));
				addcart2_btn.click();
				////u[contains(text(),\"View Cart\")]
				WebElement viewcart_btn=driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[1]/div/div/div[2]/p[2]/a/u"));
				viewcart_btn.click();
				List<WebElement> products_count=driver.findElements
						(By.xpath("//table[@id=\"cart_info_table\"]/tbody/tr"));
				int count = products_count.size();
				System.out.println("total products are :" + count);
		       
				Thread.sleep(1000);
				List<WebElement> produts_details=driver.findElements
						(By.xpath("//table[@id=\"cart_info_table\"]/tbody/tr/td[@class='cart_price']"));
				
				for(WebElement we :produts_details) {
					System.out.println(we.getText());
				}
				
				
}
}
}