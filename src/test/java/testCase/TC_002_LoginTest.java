package testCase;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
public class TC_002_LoginTest extends BaseClass {
	   @Test(groups = {"sanity" , "master"})
       public void verify_login() {
		   logger.info("TC_002_LoginTest Started");
		   try {
    	   HomePage hp = new HomePage(driver);
    	   hp.ClickAccount();
    	   hp.ClickLogin();
    	   
    	   LoginPage lp = new LoginPage(driver);
    	   lp.setEmail(property.getProperty("email"));
    	   lp.setPassword(property.getProperty("password"));
    	   lp.ClickLogin();
    	    MyAccountPage map = new  MyAccountPage(driver);
    	    boolean status = map.ismsgDisplayed();
    	    if(status == true) {
    	    	Assert.assertTrue(true);
    	    	logger.info("test passed");
    	    }else {
    	    	Assert.fail();
    	    	logger.error("test failed");
    	    }
		   }catch(Exception e)
		   {
			   Assert.fail();
			   logger.error("test failed");
		   }
       }
}
