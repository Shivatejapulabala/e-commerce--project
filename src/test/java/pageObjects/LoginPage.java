package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
   WebDriver driver;
   public LoginPage(WebDriver driver)
  {
	  super(driver);
  }
   
  @FindBy(xpath = "//input[@id='input-email']")
  WebElement txt_email;
  
  @FindBy(xpath = "//input[@id='input-password']")
  WebElement txt_password;
  
  @FindBy(xpath = "//input[@value='Login']")
  WebElement btn_login;
  
  public void setEmail(String email)
  {
	  txt_email.sendKeys(email);
  }
  public void setPassword(String password)
  {
	  txt_password.sendKeys(password);
  }
  public void ClickLogin()
  {
	  WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();
	  
  }

  
  
}
