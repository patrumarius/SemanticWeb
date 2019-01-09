package test;

import org.junit.Test;

import testdata.repos.LoginPageRepo;

public class SoldeTest extends GeneralTest{

	@Test
	public void loginTest() throws Exception {
		application.openApp().openLogin().login(LoginPageRepo.insertName, LoginPageRepo.insertPassword)
				.acceserSoldeCompte().verifierSoldeCompte();
	}
	
}
