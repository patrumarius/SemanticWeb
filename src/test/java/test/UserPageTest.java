package test;

import org.junit.Test;

import testdata.models.LoginPageModel;
import testdata.repos.*;

public class UserPageTest extends GeneralTest {

	@Test
	public void userPageTest() throws Exception {
		application.openApp().openLogin().login(LoginPageRepo.insertName, LoginPageRepo.insertPassword)
			.verifierNomUtilisateur(UserAccountPageRepo.setNomUtilisateur);
	}
	
}
