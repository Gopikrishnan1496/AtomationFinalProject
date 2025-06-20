package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src=\"https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png\"]")
	private WebElement adminlink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement logoutlink;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")private WebElement supermarket;
	@FindBy(xpath = "//i[@class=\"fas fa-arrow-circle-right\"]")
	private WebElement adminuserslink;

	public HomePage clickOnAdmin() {
		adminlink.click();
		return this;
	}

	public LoginPage clickOnLogout() {
		logoutlink.click();
		return new LoginPage(driver);
	}
	
	public boolean Supermarket()
	{
		return supermarket.isDisplayed();
	}

	public AdminUsersPage clickOnAdminUsers() {
		adminuserslink.click();
		return new AdminUsersPage(driver);
	}
}