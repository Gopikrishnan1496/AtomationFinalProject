package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")	private WebElement managenewslink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")	private WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")	private WebElement newsfield;
	@FindBy(xpath = "//button[@type='submit']")	private WebElement savebutton;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")	private WebElement searchbutton;
	@FindBy(xpath = "//input[@class='form-control']")	private WebElement searchnewsfield;
	@FindBy(xpath = "//button[@name='Search']")	private WebElement submitsearch;

	public void clickManageNews() {
		managenewslink.click();
	}

	public void clickNewButton() {
		newbutton.click();
	}

	public void newNewsField(String newsdata) {
		newsfield.click();
		newsfield.sendKeys(newsdata);
	}

	public void clickSave() {
		savebutton.click();
	}

	public void clickSearchNews() {
		managenewslink.click();
		searchbutton.click();
	}

	public void searchNewsFiled(String searchnews) {
		searchnewsfield.click();
		searchnewsfield.sendKeys(searchnews);
	}

	public void searchsubmit() {
		submitsearch.click();
	}

}
