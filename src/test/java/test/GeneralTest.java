package test;

import java.net.URI;

import javax.inject.Inject;

//import org.apache.xerces.util.URI;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import core.WebDriverConfig;
import pages.App;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(classes = WebDriverConfig.class)
public class GeneralTest {
	
	@Inject
	WebDriver driver;
	
	@Inject
	URI baseUrl;
	
	protected App application;
	//private SoftAssertions softAssertions;
	
	@Before
	public void setUp() throws Exception{
		driver.get(baseUrl.toString());
		application = new App(driver);
		//softAssertions = new SoftAssertions();
		
	}
	
}
