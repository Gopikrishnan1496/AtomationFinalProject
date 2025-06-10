package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class=\"fas fa-arrow-circle-right\"]")private WebElement adminuserslink;
	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]")private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")	private WebElement usernamefield;
	@FindBy(xpath = "//input[@id='password']")	private WebElement passwordfield;
	@FindBy(xpath = "//select[@id='user_type']")	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")	private WebElement savebutton;
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-primary\']")	private WebElement searchbutton;
	@FindBy(xpath = "//input[@id='un']")	private WebElement usernamesearch;
	@FindBy(xpath = "//select[@id='ut']")	private WebElement usertypesearch;
	@FindBy(xpath = "//button[@name='Search']")	private WebElement clicksearch;

	public void clickOnAdminUsers() {
		adminuserslink.click();
	}

	public void clickOnNewButton() {
		newbutton.click();
	}

	public void enterUsername(String username1) {
		usernamefield.sendKeys(username1);
	}

	public void enterPassword(String password1) {
		passwordfield.sendKeys(password1);
	}

	public void selectUserType() {
		Select select = new Select(usertype);
		select.selectByValue("admin");
	}

	public void clickOnSave() {
		savebutton.click();
	}

	public void clickOnSearch() {
		searchbutton.click();
	}

	public void enterUserSearch(String user) {
		usernamesearch.sendKeys(user);
	}

	public void enterUserTypeSearch() {
		Select select = new Select(usertypesearch);
		select.selectByValue("admin");
	}

	public void enterSearch() {
		clicksearch.click();
	}
}
