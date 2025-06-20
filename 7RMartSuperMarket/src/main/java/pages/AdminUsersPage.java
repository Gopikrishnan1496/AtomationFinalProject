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

	
	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]")private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")	private WebElement usernamefield;
	@FindBy(xpath = "//input[@id='password']")	private WebElement passwordfield;
	@FindBy(xpath = "//select[@id='user_type']")	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")	private WebElement savebutton;
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-primary\']")	private WebElement searchbutton;
	@FindBy(xpath = "//input[@id='un']")	private WebElement usernamesearch;
	@FindBy(xpath = "//select[@id='ut']")	private WebElement usertypesearch;
	@FindBy(xpath = "//button[@name='Search']")	private WebElement clicksearch;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")private WebElement useraddedalert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement searchadminuser;
	

	

	public AdminUsersPage clickOnNewButton() {
		newbutton.click();
		return this;
	}

	public AdminUsersPage enterUsername(String username1) {
		usernamefield.click();
		usernamefield.sendKeys(username1);
		return this;
	}

	public AdminUsersPage enterPassword(String password1) {
		passwordfield.click();
		passwordfield.sendKeys(password1);
		return this;
	}

	public AdminUsersPage selectUserType() {
		Select select = new Select(usertype);
		select.selectByValue("admin");
		return this;
	}

	public AdminUsersPage clickOnSave() {
		savebutton.click();
		return this;
	}

	public AdminUsersPage clickOnSearch() {
		searchbutton.click();
		return this;
	}

	public AdminUsersPage enterUserSearch(String user) {
		usernamesearch.sendKeys(user);
		return this;
	}

	public AdminUsersPage enterUserTypeSearch() {
		Select select = new Select(usertypesearch);
		select.selectByValue("admin");
		return this;
	}

	public AdminUsersPage enterSearch() {
		clicksearch.click();
		return this;
	}
	
	public boolean userAddedAlert()
	{
		return useraddedalert.isDisplayed();
	}
	
	public boolean searchAdminUser()
	{
		return searchadminuser.isDisplayed();
	}
}
