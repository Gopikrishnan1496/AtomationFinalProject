package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	@Test(description = "Verify whether the user can add new category")
	public void verifywhetherUserIsAbleToAddNewCategory() throws IOException, AWTException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSubmit();
		ManageCategoryPage managecategory = new ManageCategoryPage(driver);
		managecategory.clickOnManageCategory();
		managecategory.clickOnNewButton();
		// managecategory.clickCategoryfield();
		String categoryname = ExcelUtility.getStringData(0, 0, "ManageCategoryPage");
		managecategory.enterCategory(categoryname);
		managecategory.discountSelect();
		managecategory.scrolldown();
		managecategory.choosefile();
		managecategory.scrolldown();
		managecategory.scrolldown();
		managecategory.showOnTop();
		managecategory.showOnLeft();
		managecategory.scrolldown();
		managecategory.clickOnSave();
        boolean iscategoryaddeddisplayed=managecategory.categoryCreatedAlert();
        Assert.assertTrue(iscategoryaddeddisplayed, Messages.CATEGORYADDITIONFAILUREERROR);
	}
}
