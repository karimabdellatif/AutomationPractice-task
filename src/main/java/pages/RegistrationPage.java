package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends InitialPage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath ="//input[@name='email_create']")
	WebElement accountemail;

	@FindBy(id = "SubmitCreate")
	WebElement createbutton;

	@FindBy(xpath = "//*[@id='create_account_error']/ol/li")
	public WebElement createaccounterror;

	@FindBy(linkText = "Sign out")
	public WebElement signout;

	@FindBy(xpath="//input[@name='id_gender']")
	WebElement gender;

	@FindBy(id ="customer_firstname")
	WebElement firstname;

	@FindBy(id ="customer_lastname")
	WebElement lastname;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "postcode")
	WebElement postalcode;
	
	@FindBy(id = "id_state")
	WebElement selectstate;

	@FindBy(id = "phone_mobile")
	WebElement mobilenumber;

	@FindBy(id = "submitAccount")
	WebElement registerbutton;



	public void userSignUp(String first_name, String last_name, String pass, String post_code, String addr , String city_name, String phone) {

		clickButton(gender);
		setElementText(firstname, first_name);
		setElementText(lastname, last_name);
		setElementText(password, pass);
		setElementText(address, addr);
		setElementText(postalcode, post_code);
		setElementText(city, city_name);

		Select states = new Select(selectstate);
		states.selectByVisibleText("Hawaii");

		setElementText(mobilenumber, phone);
		clickButton(registerbutton);
	}
	// create account button click
	public void createclick(String email) {

		setElementText(accountemail, email);
		clickButton(createbutton);
	}
	//  account logout click
	public void userLogout() {
		clickButton(signout);
	}
}