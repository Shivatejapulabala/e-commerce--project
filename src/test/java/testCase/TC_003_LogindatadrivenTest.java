package testCase;

import testBase.BaseClass;
import utilities.DataProviders;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
public class TC_003_LogindatadrivenTest extends BaseClass {
	   @Test(dataProvider = "logindata" ,dataProviderClass = DataProviders.class)
       public void verify_login(String email , String password , String expected) {
		   logger.info("TC_003_LogindatadrivenTest Started");
		   try {
    	   HomePage hp = new HomePage(driver);
    	   hp.ClickAccount();
    	   hp.ClickLogin();
    	   
    	   LoginPage lp = new LoginPage(driver);
    	   lp.setEmail(email);
    	   lp.setPassword(password);
    	   lp.ClickLogin();
    	    MyAccountPage map = new  MyAccountPage(driver);
    	    boolean status = map.ismsgDisplayed();
    	    if(expected.equalsIgnoreCase("Valid")) {
    	    	if(status == true) {
    	    		map.ClickLogout();
    	    		Assert.assertTrue(true);
    	    	}
    	    	else {
    	    		Assert.fail();
    	    	}
    	    }
    	    if(expected.equalsIgnoreCase("Invalid")) {
    	    	if(status == false) {
    	    		Assert.assertTrue(true);
    	    	}
    	    	else {
    	    		map.ClickLogout();
    	    		Assert.fail();
    	    	}
    	    }	    
    	    
       }catch(Exception e)
		   {
    	   Assert.fail();
		   }
}
}
