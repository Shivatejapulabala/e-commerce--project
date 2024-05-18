package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_005_RegistrationDDTest extends BaseClass {
	@Test(dataProvider = "registerdata" , dataProviderClass =  DataProviders.class)
      public void verify_registration(String Fname , String Lname , String Email , String Telphone , String pwd , String confirmpwd , String expected)
      {   
		try {
    	  HomePage hp = new HomePage(driver);
    	  hp.ClickAccount();
    	  hp.ClickRegister();
    	  RegistrationPage rp = new RegistrationPage(driver);
    	  rp.setFirstName(Fname);
    	  rp.setLastName(Lname);
    	  rp.setEmail(Email);
    	  rp.setPhonenumber(Telphone);
    	  rp.setPassword(pwd);
    	  rp.setConfirmPassword(confirmpwd);
    	  rp.ClickPrivacyPolicy();
    	  rp.ClickContinue();
    	 //MyAccountPage map = new MyAccountPage(driver);
    	  String status = rp.getConfirmationMsg();
    	  if(expected.toLowerCase().equals("valid"))
    	  {
    		  if(status.equals("Your Account Has Been Created!"))
    		  {   
    			  rp.Logout();
    			  Assert.assertTrue(true);
    		  }else 
    		  {
    			  Assert.fail();
    		  }
    	  }else if(expected.toLowerCase().equals("invalid"))
    	  {
    		  if(status.equals("Your Account Has Been Created!"))
    		  {
    			  rp.Logout();
    			  Assert.fail();
    		  }else
    		  {
    			  Assert.assertTrue(true);
    		  }
    	  }
		}catch(Exception e)
		{
			Assert.fail();
		}
    	
    	  
      }
}
