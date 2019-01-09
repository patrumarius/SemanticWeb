package pages;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.qameta.allure.Step;

public class HomePage {

	@Inject
	private WebDriver driver;
	
	@FindBy(xpath ="/html/body/div[3]/div[1]/div/ul/li[2]/a/span")
	private WebElement signIn;
	
	@FindBy(className = "pageHeadingText")
	private WebElement headingText;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(factory, this);
	}
	
	@Step("Open HomePage")
	public HomePage isHomePageDisplayed() throws InterruptedException {
		Thread.sleep(1000);
		assertTrue(headingText.getText().equals("Cyclos 4 Demo"));
		return new HomePage(driver);
	}
	
	@Step("Go to login")
	public LoginPage openLogin() throws InterruptedException {
		signIn.click();
		Thread.sleep(1000);
		return new LoginPage(driver);
	}
	
}
