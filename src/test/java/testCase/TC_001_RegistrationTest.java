package testCase;
import testBase.BaseClass;
import java.time.Duration;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_001_RegistrationTest extends BaseClass {
	@Test(groups = {"regression" , "master"})
	public void verify_account_registration() {
		try {
		logger.info("Test Started");
		HomePage hp =new HomePage(driver);
		hp.ClickAccount();
		logger.info("clicked on account link");
		hp.ClickRegister();
		logger.info("clicked on register link");
		logger.debug("entering data into form");
		RegistrationPage rp = new RegistrationPage(driver);
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString() + "@gmail.com");
		rp.setPhonenumber(randomnumbers());
		rp.setPassword("admin@123");
		rp.setConfirmPassword("admin@123");
		rp.ClickPrivacyPolicy();
		rp.ClickContinue();
		Assert.assertEquals(rp.getConfirmationMsg() ,"Your Account Has Been Created!");
		logger.info("Test Passed");
		}
		catch(Exception e) {
			Assert.fail();
			logger.info("test Failed");
		}
	}
     
}
