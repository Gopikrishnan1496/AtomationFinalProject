package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import constants.Constant;
import utilities.ScreenshotUtility;

public class Base {
	Properties prop;
	FileInputStream fs;
	public WebDriver driver; // webdriver is the interface and driver is the reference.
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		prop=new Properties();
		fs=new FileInputStream(Constant.CONFIGFILE);
		prop.load(fs);
	if(browser.equalsIgnoreCase("Chrome"))
				{
			     driver = new ChromeDriver();
				}
	else if(browser.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();
		}
		
	else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver =new FirefoxDriver();
		}
		
		else 
		{
			throw new Exception("Invalid Browser");
		}
	



	
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun=true)
	// public void browserCloseandQuit() {
	// driver.close();
	// driver.quit();
	// }
	public void driverQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) // iTestResult is a predefined interface to
		{
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		// driver.quit();


	}
}
