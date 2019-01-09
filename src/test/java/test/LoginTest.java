package test;

import testdata.models.LoginPageModel;
import testdata.models.UserAccountPageModel;
import testdata.repos.LoginPageRepo;
import testdata.repos.UserAccountPageRepo;

import org.junit.Test;

public class LoginTest extends GeneralTest{

	@Test
	public void loginTest() throws Exception {
		application.openApp().openLogin().login(LoginPageRepo.insertName, LoginPageRepo.insertPassword);
	}
	
	
	
}
