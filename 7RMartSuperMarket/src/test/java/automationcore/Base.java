package automationcore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver; // webdriver is the interface and driver is the reference.

	@BeforeMethod
	public void initializeBrowser() {
		driver = new ChromeDriver(); // ChromeDriver is the default browser class for chrome
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
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
