package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name=\"username\"]")	private WebElement usernamefield;
	@FindBy(xpath = "//input[@name=\"password\"]")	private WebElement passwordfield;
	@FindBy(xpath = "//button[@type=\"submit\"]")	private WebElement submitbutton;
	
	public void enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnSubmit() {
		submitbutton.click();
	}
	
}
