package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	@Test(description = "Verify whether the user can add a new user")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSubmit();
		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage.clickOnAdminUsers();
		adminpage.clickOnNewButton();
		FakerUtility fakerutility = new FakerUtility();
		String username1 = fakerutility.createRandomUsername();
		adminpage.enterUsername(username1);
		String password1 = fakerutility.createRandomPassword();
		adminpage.enterPassword(password1);
		adminpage.selectUserType();
		adminpage.clickOnSave();
	}

	@Test(description = "Verify whether the user can search for a user")
	public void verifyWhetherUserIsAbleToSearchForAUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSubmit();
		AdminUsersPage adminpage = new AdminUsersPage(driver);
		adminpage.clickOnAdminUsers();
		adminpage.clickOnSearch();
		String user = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		adminpage.enterUserSearch(user);
		adminpage.enterUserTypeSearch();
		adminpage.enterSearch();
	}
}
