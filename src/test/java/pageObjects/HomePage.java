package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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
}

