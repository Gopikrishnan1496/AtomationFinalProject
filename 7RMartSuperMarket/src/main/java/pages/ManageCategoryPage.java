package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class ManageCategoryPage {
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")	private WebElement managecategorylink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")	private WebElement newcategorylink;
	@FindBy(xpath = "//input[@id='category']")	private WebElement categoryfield;
	@FindBy(xpath = "//li[@id='134-selectable']")	private WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")	private WebElement choosefilebutton;
	@FindBy(xpath = "//input[@name='top_menu'and@value='no']")	private WebElement showontopnobutton;
	@FindBy(xpath = "//input[@value='no']")	private WebElement showonleftno;
	@FindBy(xpath = "//button[text()='Save']")	private WebElement savebutton;

	public void clickOnManageCategory() {
		managecategorylink.click();
	}

	public void clickOnNewButton() {
		newcategorylink.click();
	}

	public void clickCategoryfield() {
		categoryfield.click();
		categoryfield.sendKeys("Cooking Essentials");
	}

	public void enterCategory(String categoryname) {
		categoryfield.sendKeys(categoryname);
	}

	public void discountSelect() {
		discount.click();
	}

	public void choosefile() {
		choosefilebutton.sendKeys(Constant.IMAGEDATAFILE);
	}

	public void showOnTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", showontopnobutton);
		js.executeScript("window.scrollBy(0,350)", "");
		// showontopnobutton.click();

	}

	public void showOnLeft() {
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", showonleftno);
		// js.executeScript("window.scrollBy(0,350)", "");
		showonleftno.click();
	}

	public void clickOnSave() {
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", savebutton);
		// js.executeScript("window.scrollBy(0,400)", "");
		savebutton.click();
	}
}