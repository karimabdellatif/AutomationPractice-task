package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pages.InitialPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signinbutton;

	public void userLogin(String mail, String passwd) {

		setElementText(email, mail);
		setElementText(password, passwd);
		clickButton(signinbutton);

	}

}
