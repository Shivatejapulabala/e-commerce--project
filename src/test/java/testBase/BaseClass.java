package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties property;
    @BeforeClass(groups = {"sanity" , "regression" , "master"})
    @Parameters({"os" , "browser"})
    public void setup(String os , String brname) throws IOException
    {
    	if(brname.toLowerCase().equals("chrome")) {
    		 driver = new ChromeDriver();
    	}
    	else if(brname.toLowerCase().equals("edge")){
    		driver = new EdgeDriver();
    	}
    	else {
    		System.out.println("not matching any browser");
    	}
    	FileReader file = new FileReader(".//src//test//resources//config.properties");
    	property = new Properties();
    	property.load(file);
     logger = LogManager.getLogger(this.getClass());
   	
   	 driver.manage().window().maximize();
   	 driver.manage().deleteAllCookies();
   	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   	 driver.get(property.getProperty("appUrl"));
    }
    @AfterClass(groups = {"sanity" , "regression" , "master"})
   public void tearDown()
    {
   	 driver.quit();
    }
    
    public String randomString()
    {
    	String randomstringdata = RandomStringUtils.randomAlphabetic(5);
    	return randomstringdata;
    }
    public String randomnumbers()
    {
    	String randomnumbers = RandomStringUtils.randomNumeric(5);
    	return randomnumbers;
    }
    public String randomalphanumerics()
    {
    	String randomstringdata1 = RandomStringUtils.randomAlphabetic(5);
    	String randomnumbers1 = RandomStringUtils.randomNumeric(5);
    	return(randomstringdata1+ randomnumbers1);  	
}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}

