package pages;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import testdata.models.LoginPageModel;

public class LoginPage {
	
	@Inject
	private WebDriver driver;
	
	@FindBy(name ="principal")
	private WebElement name;
	
	@FindBy(name ="password")
	private WebElement password;
	
	@FindBy(className ="actionButton")
	private WebElement button;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(factory, this);
	}
	
	@Step("Login and assert")
	public UserAccountPage login(LoginPageModel nameValue, LoginPageModel passwordValue) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,10, 100);
		wait.withMessage("error").until(ExpectedConditions.visibilityOf(name));
		name.clear();
		name.sendKeys(String.valueOf(nameValue.getName()));
		Thread.sleep(1000);
		password.clear();
		password.sendKeys(String.valueOf(passwordValue.getPassword()));
		Thread.sleep(1000);
		button.click();
		
		return new UserAccountPage(driver);
	}
}
