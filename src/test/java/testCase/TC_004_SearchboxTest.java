package testCase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC_004_SearchboxTest  extends BaseClass {
	@Test(groups = {"sanity" , "master"})

  public void verify_search_box()
  {  
	try {
	  HomePage hp = new HomePage(driver);
	  hp.ClickSearchbox();
	  hp.EntertoSearchBox(property.getProperty("productname"));
	  hp.ClickSearchbox();
	  SearchResultsPage sp = new  SearchResultsPage(driver);
	 boolean status = sp.isTitleSame("iphone");
	 Assert.assertEquals(status, true);
	}catch(Exception e) {
		Assert.fail();
	}
}
}
