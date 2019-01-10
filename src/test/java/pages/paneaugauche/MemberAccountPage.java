package pages.paneaugauche;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class MemberAccountPage {

	@Inject
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@class='pageHeadingText']")
	private WebElement memberAccount;
	
	public MemberAccountPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(factory, this);
	}
	
	@Step("Verifier le solde du compte")
	public MemberAccountPage membreCompte() throws InterruptedException {
		System.out.println(memberAccount.getText());
		WebDriverWait wait = new WebDriverWait(driver,10, 100);
		wait.withMessage("error").until(ExpectedConditions.visibilityOf(memberAccount));
		assertTrue(memberAccount.getText().equals("Member account"));
		return new MemberAccountPage(driver);
	}
	
	
}
