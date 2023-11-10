package webpages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AutomationSignupWebpages {
@FindBy(how=How.XPATH,using="//a[contains(text(), \\\"Home\\\")]")
public WebElement homepage_btn;
@FindBy(how=How.XPATH,using="//input[@name=\"name\"]")
public WebElement name_Txt;
@FindBy(how=How.XPATH,using="//section[@id=\\\"form\\\"]/div/div/div[3]/div/form/input[3]")
public WebElement Email_address_Txt;
@FindBy(how=How.XPATH,using="//button[contains(text(),\\\"Signup\\\")]")
public WebElement signup_btn;
@FindBy(how=How.XPATH,using="//b[contains(text(),\\\"Enter Account Information\\\")]")
public WebElement enter_accountinfo_btn;


}
