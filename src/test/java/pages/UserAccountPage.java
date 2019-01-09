package pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pages.paneaugauche.MemberAccountPage;
import testdata.models.LoginPageModel;
import testdata.models.UserAccountPageModel;
import testdata.repos.UserAccountPageRepo;

public class UserAccountPage {

	@Inject
	private WebDriver driver;
	
	@FindBy(className = "horizontalMenuContent")
	private WebElement menuHorisontalPrincipal;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[4]/a/span")
	private WebElement nomUtilisateurCourant;
	
	@FindBy(className = "dashboardStatusGroup")
	private List<WebElement> paneauGaucheListOptions;
	
	@FindBy(className = "dashboardActionLabel")
	private WebElement lienOperationsUtilisateur;
	
	@FindBy(className = "pageSectionHeading")
	private WebElement messageAccueil;
	
	@FindBy(className = "dashboardStatusLinkValue")
	private WebElement lastlogin;
	
	
	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
		PageFactory.initElements(factory, this);
	}
	
	@Step("Verifier le nom de l'utilisateur courant") 
	public UserAccountPage verifierNomUtilisateur(UserAccountPageModel nom) {
		WebDriverWait wait = new WebDriverWait(driver,10, 100);
		wait.withMessage("error").until(ExpectedConditions.visibilityOf(nomUtilisateurCourant));
		assertTrue(nomUtilisateurCourant.getText().equals(nom.getName()));
		return new UserAccountPage(driver);
	}
	
	@Step("Acceser le solde du compte")
	public MemberAccountPage acceserSoldeCompte() {
		paneauGaucheListOptions.get(0).click();
		System.out.println("OK");
		return new MemberAccountPage(driver);
	}
	
	
}
