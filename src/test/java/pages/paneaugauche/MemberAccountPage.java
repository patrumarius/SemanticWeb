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
	
	@FindBy(xpath = "(//*[@class='gwt-InlineLabel'])[7]")
	private WebElement solde;
	
	public MemberAccountPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(factory, this);
	}
	
	@Step("Verifier le solde du compte")
	public MemberAccountPage verifierSoldeCompte() {
		WebDriverWait wait = new WebDriverWait(driver,10, 100);
		wait.withMessage("error").until(ExpectedConditions.visibilityOf(solde));
		//System.out.println(solde.getText());
		assertTrue(solde.getText().equals("Balance: 5.112,94 IU's"));
		return new MemberAccountPage(driver);
	}
	
	
}
