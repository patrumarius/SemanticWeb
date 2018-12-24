package pages;

import org.openqa.selenium.WebDriver;

public class App {
	
	public WebDriver driver;
	
	public App(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage openApp() {
		return new HomePage(driver);
	}
}
