package TestNg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Verify_Testcasespage {
	WebDriver driver;
	 ChromeOptions options;
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
			if(Home_page.isDisplayed()){
				WebElement Test_casebtn=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[5]/a"));
				Test_casebtn.click();
				driver.navigate().to("https://automationexercise.com/test_cases");
				//WebElement test_casepage=driver.findElement(By.xpath("//b[contains(text(),\"Test Cases\")]"));
				//System.out.println(test_casepage.getText());
				
			}
}
		@AfterMethod
		public void afterMethod() {
			driver.close();
			
		}
		
}