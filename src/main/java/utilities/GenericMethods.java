package utilities;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GenericMethods {
//declarations
	public static String timeStamp = null;
	//public Properties prop;
	public WebDriverWait wait=null;
	protected static WebDriver driver=null;
	@BeforeClass(alwaysRun=true)
	@Parameters({ "browser", "app" })
	public void setUp(String name,String url)
	{
		selectBrowser(name);
		initApplication(url);
		
	}
	@AfterClass(alwaysRun=true)
	public void tearDown() {
System.out.println("close the application");
		//driver.close();
	}
//screenshot code
	public static void captureScreen() 
	{
		String fileName = (new Date()).toString().replace(" ", "_").replace(":", "-").trim()+ ".png";
		String destinationFilePath = System.getProperty("user.dir")+
		File.separator+"Screenshots/" +fileName;
		System.out.println(destinationFilePath);
		try 
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination=new File(destinationFilePath);
			FileUtils.copyFile(source, destination);
		}
		catch (Exception e) 
		{
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}

	}
	//take screenshot when the testcase is failed
	@AfterMethod(alwaysRun=true)
	public void verifyStatus(ITestResult result) throws Exception 
	{
		if (result.getStatus() == ITestResult.SUCCESS) 
		{

			System.out.println("Test case is Successfully Executed");
			//captureScreen();
		}
		else if (result.getStatus() == ITestResult.FAILURE) 
		{
			captureScreen();
		} 
		else if (result.getStatus() == ITestResult.SKIP) 
		{
			System.out.println("This test case is not executed/skipped  due to time out issue.... ");
			
		}

	}
	//browser specific,common-code
	public void selectBrowser(String name) {

		switch (name) {
		case "chrome":			
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-orignis=*");			
			System.setProperty(Constants.chromeKey, Constants.chromeExe);
			driver =new ChromeDriver(opt);
			//WebDriverManager.chromedriver().setup();
			break;
		case "firefox":
			/*
			 * System.setProperty(Constants.firefoxKey, Constants.fireFoxExe); driver = new
			 * GeckoDriverInfo();
			 */
			break;
		case "ie":
			/*
			 * System.setProperty(Constants.IEKey, Constants.IEExe); driver = new
			 * IEDriverINFo();
			 */
			
			break;
		default:
			Assert.fail("Please pass the  valid browser name");
			break;
		}
	}
	//common URL code
	public void initApplication(String url) {
		switch (url) {
		case "automation":
			driver.get("https://automationexercise.com/");
			break;
		case "guru":
			driver.get("https://www.demo.guru99.com/v4");
			break;
		case "amazon":
			driver.get("https://www.amazon.in/");
			break;
		case "DMVI":
			driver.get("https://dmvi-staging.demo.secomind.ai/login?next=/");
			break;
		case "facebook":
			driver.get("https://www.facebook.com/r.php");
			break;
		case "OpenMRS":
			driver.get("https://dmvi-staging.demo.secomind.ai/login?next=/");
			break;
		case "HRM":
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			break;
		case "Google":
			driver.get("https://www.google.com/");
			break;
		case "Greencart":
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			break;
			
		default:
			Assert.fail("Please select valid Application");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
  ////genericMethods.input(gwebpages.name_Txt,"virat","Name")
	public void input(WebElement ele, String data, String fieldName) 
	{
		try 
		{
			System.out.print("1");
			if (ele.isDisplayed()) 
			{
				ele.clear();
				ele.sendKeys(data);
				
			}
		} 
		catch (Exception e) 
		{
			Assert.fail("Element is Not Displayed at this point of time " + e.getMessage());
		}
	}
	//click() method
	public void click(WebElement ele, String fieldname) 
	{
		try 
		{
			if (ele.isDisplayed() || ele.isEnabled()) 
			{
				ele.click();
			
			}
		} 
		catch (Exception e) 
		{
			// logger.log(Status.FAIL, "Element is Not Displaye at this point of time");
			Assert.fail("Element is Not Displayed at this point of time " + e.getMessage());
		}
	}
// radio buttons,checkboxes,dropdownlist
		public void selectVisibleText(WebElement ele, String data, String fieldName) {
	try
		{
				if (ele.isDisplayed()) 
				{
					new Select(ele).selectByVisibleText(data);
					
				}

			} 
			catch (Exception e) 
			{
				// logger.log(Status.FAIL, "Unable to Select Value at this point of time");
				Assert.fail("Unable to Select Value at this point of time " + e.getMessage());
			}
		}
		public String getText(WebElement ele) {
			String data = null;
			try {
				data = ele.getText();
			} catch (Exception e) {
				// logger.log(Status.FAIL, "Unable to Fetch the data");
				Assert.fail("Unable to Fetch the data " + e.getMessage());
			}
			return data;
		}

		public String getAttributeValue(WebElement ele) {
			String data = null;
			try {
				data = ele.getAttribute("value");
			} catch (Exception e) {
				// logger.log(Status.FAIL, "Unable to Fetch the data");
				Assert.fail("Unable to Fetch the data " + e.getMessage());
			}
			return data;
		}

		public String getAttributeInnerText(WebElement ele) {
			String data = null;
			try {
				data = ele.getAttribute("innerHTML");
			} catch (Exception e) {
				// logger.log(Status.FAIL, "Unable to Fetch the data");
				Assert.fail("Unable to Fetch the data " + e.getMessage());
			}
			return data;
		}
		//explicit wait 	  
		 public void elementToBeClickable(WebElement ele) 
		  { 
			  
			wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.elementToBeClickable(ele)); 
		  }
		   	
		public void visibilityOfElement(WebElement ele)
		{
			
			 wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(ele));
			
		}
		/*//12 to 15
		public String readValidations(String name) {
			
			try {
				File src = new File(Constants.propPath);
				FileInputStream fin = new FileInputStream(src);
				prop = new Properties();
				prop.load(fin);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return prop.getProperty(name);
			
		}
	*/


}
