package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends pages.InitialPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Sign in")
	public WebElement signin;

	@FindBy(xpath ="//*[@class='icon-list-ol']")
	public WebElement orderhistory;

	@FindBy(xpath ="//*[@class='account']")
	WebElement account;

	public void openSigninPage() {
		clickButton(signin);
	}

	public void openhistroypage() {
		clickButton(account);
		clickButton(orderhistory);
	}

}