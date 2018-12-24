package testdata.repos;

import testdata.models.LoginPageModel;

public class LoginPageRepo {

	public static final LoginPageModel insertName = new LoginPageModel().setName("demo");
	
	public static final LoginPageModel insertPassword = new LoginPageModel().setPassword("1234");
}
