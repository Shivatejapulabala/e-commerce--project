package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
   WebDriver driver;
  public SearchResultsPage(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(xpath = "//a[normalize-space()='iPhone']")
   WebElement product_txt;
   public boolean isTitleSame(String exp_result)
   {
	  try {
	 String result_title =  product_txt.getText().toLowerCase();
	 if(exp_result.toLowerCase().equals(result_title)) {
		 return true;
	 }else {
		 return false;
	 }
	  }catch(Exception e) {
		  return false;
	  }
    
}
}