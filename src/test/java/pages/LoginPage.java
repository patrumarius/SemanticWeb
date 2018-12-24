package pages;

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
	
	private WebDriver driver;
	
	@FindBy(name ="principal")
	private WebElement password;
	
	@FindBy(name ="password")
	private WebElement name;
	
	@FindBy(className ="actionButton")
	private WebElement button;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(factory, this);
	}
	
	@Step("Login and assert")
	public AccountPage login(LoginPageModel nameValue, LoginPageModel passwordValue) {
		WebDriverWait wait = new WebDriverWait(driver,10, 100);
		wait.withMessage("error").until(ExpectedConditions.visibilityOf(name));
		name.clear();
		name.sendKeys(String.valueOf(nameValue.getName()));
		
		password.clear();
		password.sendKeys(String.valueOf(passwordValue.getPassword()));
		
		button.click();
		
		return new AccountPage(driver);
	}
}
