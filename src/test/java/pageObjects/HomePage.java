package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {
	public WebDriver driver;
     public HomePage(WebDriver driver)
    {
    	super(driver);
    } 
   
    
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkaccount;
    
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkregister;
    
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement lnkLogin;
    
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement txt_searchbox_input;
    
    
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement btn_searchbox;
   
    public void ClickAccount()
    {
    	lnkaccount.click();
    }
    public void ClickRegister()
    {
    	lnkregister.click();
    }
    public void ClickLogin()
    {
    	lnkLogin.click();
    }
    public void ClickSearchbox()
    {
    	txt_searchbox_input.click();
    }
    public void EntertoSearchBox(String productname)
    {
    	txt_searchbox_input.sendKeys(productname);
    }
    public void ClicktoSearch()
    {
    	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
  	  wait.until(ExpectedConditions.elementToBeClickable(btn_searchbox)).click();

    }
}

