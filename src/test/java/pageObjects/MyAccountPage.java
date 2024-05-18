package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage{
	WebDriver driver;
    public MyAccountPage(WebDriver driver)
    {
   	 super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgHeading;
    
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogout;
    
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myaccount;
    public boolean ismsgDisplayed()
    {
    	try {
    		return (msgHeading.isDisplayed());
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    public void ClickLogout()
    {
    	myaccount.click();
    	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(lnkLogout)).click();
    	//lnkLogout.click();
    }
}
