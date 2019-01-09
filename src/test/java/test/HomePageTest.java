package test;

import org.junit.Test;

public class HomePageTest extends GeneralTest{

	@Test
	public void verifyHomePageIsDisplayed() throws InterruptedException {
		application.openApp().isHomePageDisplayed();
	}
	
	
}
