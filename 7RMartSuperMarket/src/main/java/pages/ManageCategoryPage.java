package pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")private WebElement categorycreatedalert;

	public void clickOnManageCategory() {
		managecategorylink.click();
	}

	public void clickOnNewButton() {
		newcategorylink.click();
	}

		public void enterCategory(String categoryname) {
		categoryfield.sendKeys(categoryname);
	}

	public void discountSelect() {
		discount.click();
	}

	public void choosefile() throws AWTException {
		choosefilebutton.sendKeys(Constant.IMAGEFILE);
		/*choosefilebutton.click();
		StringSelection selection=new StringSelection(Constant.IMAGEFILE);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot=new Robot();
		robot.delay(2500);
		robot.keyPress (KeyEvent.VK_ENTER);
		robot.keyRelease (KeyEvent.VK_ENTER);
		robot.keyPress (KeyEvent.VK_CONTROL);
		robot.keyPress (KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress (KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);*/
	}
	public void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
				
				js.executeScript("window.scrollBy(0,1550)", "");
	}

	public void showOnTop() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", showontopnobutton);
		//js.executeScript("window.scrollBy(0,350)", "");
		showontopnobutton.click();

	}

	public void showOnLeft() {
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", showonleftno);
		// js.executeScript("window.scrollBy(0,350)", "");
		showonleftno.click();
	}

	public void clickOnSave() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", savebutton);
		// js.executeScript("window.scrollBy(0,400)", "");
		//savebutton.click();
	}
	
	public boolean categoryCreatedAlert()
	{
	return categorycreatedalert.isDisplayed();
	}
}