package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTest extends InitialTest {

	HomePage homePageObject;
	RegistrationPage registrationPageObj;
	LoginPage loginPageObject;

	//generate fake data for user info
	Faker fakeDataObj = new Faker();
	String firstname = fakeDataObj.name().firstName();
	String lastname = fakeDataObj.name().lastName();
	String email = fakeDataObj.internet().emailAddress();
	String password = fakeDataObj.number().digits(8);
	String postcode = fakeDataObj.number().digits(5);
	String phoneNumber = fakeDataObj.phoneNumber().cellPhone();
	String city = fakeDataObj.address().city();
	String address = fakeDataObj.address().streetName();


	String invalidEmail = fakeDataObj.name().firstName();

	// user Redirect To Sign in page
	@Test(priority = 1, alwaysRun = true)
	public void redirectToSigninPage(){

		homePageObject = new HomePage(driver);
		homePageObject.openSigninPage();
	}

	// negative testing: user Enter invalid mail To Register
	@Test(dependsOnMethods = "redirectToSigninPage")
	public void invalidMailUserRegister() {

		registrationPageObj = new RegistrationPage(driver);
		registrationPageObj.createclick(invalidEmail);
	}

	@Test(dependsOnMethods = "invalidMailUserRegister")
	public void checkinvalidMailuserRegister() {

		Assert.assertEquals(registrationPageObj.createaccounterror.getText(),"Invalid email address.");
	}


	// user Enter valid mail To Register
	@Test(dependsOnMethods = "checkinvalidMailuserRegister")
	public void userRegister() {

		registrationPageObj.createclick(email);
		registrationPageObj.userSignUp(firstname, lastname, password, postcode, address, city, phoneNumber);
	}

	@Test(dependsOnMethods = "userRegister")
	public void checkuserRegister() {

		Assert.assertEquals(registrationPageObj.signout.getText(), "Sign out");
		
	}

	@Test(dependsOnMethods = "userRegister")
	public void userLogout() {
		registrationPageObj.userLogout();
		Assert.assertEquals(homePageObject.signin.getText(), "Sign in");
	}

	@Test(dependsOnMethods = "userLogout")
	public void checkuserLogin()  {
		homePageObject.openSigninPage();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin(email, password);
		Assert.assertEquals(registrationPageObj.signout.getText(), "Sign out");
	}
}
