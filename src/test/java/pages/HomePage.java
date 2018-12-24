package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.qameta.allure.Step;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath ="/html/body/div[3]/div[1]/div/ul/li[2]/a/span")
	private WebElement signIn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(factory, this);
	}
	
	@Step("Go to login")
	public LoginPage openLogin() {
		signIn.click();
		return new LoginPage(driver);
	}
	
}
