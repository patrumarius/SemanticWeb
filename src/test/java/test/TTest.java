package test;

import testdata.models.LoginPageModel;
import testdata.repos.LoginPageRepo;
import org.junit.Test;

public class TTest extends GeneralTest{

	@Test
	public void loginTest() throws Exception {
		application.openApp().openLogin().login(LoginPageRepo.insertName, LoginPageRepo.insertPassword);
	}
	
}
