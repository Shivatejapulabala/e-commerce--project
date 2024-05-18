package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{
		WebDriver driver;
    public RegistrationPage(WebDriver driver)
    {
    	super(driver);
    } 
    
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txt_firstname;
    
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txt_lastname;
    
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_email;
    
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txt_phonenumber;
    
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password;
    
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txt_confirmpassword;
    
    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkbox_privacypolicy;
    
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_continue;
    
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btn_Logout;
    
    
    public void setFirstName(String fname)
    {
    	txt_firstname.sendKeys(fname);
    }
    public void setLastName(String lname)
    {
    	txt_lastname.sendKeys(lname);
    }
    public void setEmail(String email)
    {
    	txt_email.sendKeys(email);
    }
    public void setPhonenumber(String pnumber)
    {
    	txt_phonenumber.sendKeys(pnumber);
    }
    public void setPassword(String pword)
    {
    	txt_password.sendKeys(pword);
    }
    public void setConfirmPassword(String pword)
    {
    	txt_confirmpassword.sendKeys(pword);
    }
    public void ClickPrivacyPolicy()
    {
    	chkbox_privacypolicy.click();
    }
    public void ClickContinue()
    {
    	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(btn_continue));
    	btn_continue.click();
    
    }
    public void Logout()
    {

    	WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(btn_Logout));
    	btn_Logout.click();
    }
    public String getConfirmationMsg()
    {
    	try {
    		return msgConfirmation.getText();
    	}
    	catch(Exception e) {
    		return e.getMessage();
    	}
    }
    
    
    
    
    
    
    
    
}
