
package basicsetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	public WebDriver driver;
	
	@BeforeTest
	public WebDriver setUp() throws IOException {
		
		//Properties file path
  		String path = "D:\\pallaviproj\\ShoppingCart\\src\\test\\java\\testdata.properties";
  		
  		Properties prop = new Properties();
  		
  	    
  		FileInputStream fs = new FileInputStream(path);
  		  		prop.load(fs);
  		
		//chrome driver type and driver path setting
		System.setProperty(prop.getProperty("cdrivertype"), prop.getProperty("cdriverpath"));
		
		//Invoking the browser based on the input provided from the properties file
		if(prop.getProperty("browser").equals("chrome"))
		{
			driver = new ChromeDriver();
			Reporter.log("Running test on chrome browser");
		}
		else
		{
			driver =new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
	@AfterTest
	public void tearDown() throws IOException {
		driver.quit();
	}
	
}
