package pages;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;

public class App {
	
	@Inject
	public WebDriver driver;
	
	public App(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage openApp() {
		return new HomePage(driver);
	}
}
