package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description = "Verify whether the user can logout successfully")
	public void verifywhetherUserIsAbleToLogoutSuccessfully() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSubmit();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdmin();
		homepage.clickOnLogout();
		
		boolean issupermarketdisplayed=homepage.Supermarket();
		Assert.assertTrue(issupermarketdisplayed, Messages.HOMEPAGELOGOUTERROR);
		

	}
}
