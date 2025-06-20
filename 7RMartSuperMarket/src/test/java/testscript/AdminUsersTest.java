package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	@Test(description="Verify whether user is able to add new admin user")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		AdminUsersPage adminuserspage;
		HomePage homepage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=loginpage.clickOnSubmit();
		
		adminuserspage=homepage.clickOnAdminUsers();
		adminuserspage.clickOnNewButton();
		FakerUtility fakerutility = new FakerUtility();
		String username1 = fakerutility.createRandomUsername();
		String password1 = fakerutility.createRandomPassword();
		adminuserspage.enterUsername(username1).enterPassword(password1).selectUserType().clickOnSave();		
		boolean isuseraddedalertdisplayed= adminuserspage.userAddedAlert();
		Assert.assertTrue(isuseraddedalertdisplayed, Messages.ADMINUSERADDITIONFAILUREERROR);
	}

	@Test(description = "Verify whether the user can search for a user")
	public void verifyWhetherUserIsAbleToSearchForAUser() throws IOException {
		HomePage homepage;
		AdminUsersPage adminuserspage;
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);		
		homepage=loginpage.clickOnSubmit();
		adminuserspage=homepage.clickOnAdminUsers();
		adminuserspage.clickOnSearch();
		String user = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminuserspage.enterUserSearch(user).enterUserTypeSearch().enterSearch();
		
		
		boolean isnewButtondisplayed=adminuserspage.searchAdminUser();
		Assert.assertTrue(isnewButtondisplayed, Messages.ADMINUSERSEARCHFAILUREERROR);
		
		
		
	}
}
