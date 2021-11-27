package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialPage {

    public static  JavascriptExecutor js;
    public static WebDriverWait wait ;
	public WebDriver driver;


	public InitialPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public static void clickButton(WebElement button) {
		button.click();
	}
	public static void setElementText (WebElement settxtElement , String txt) {
		//settxtElement.sendKeys(txt);
		settxtElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), txt); //to overwrite not concatenate

	}
	public static void scrolldown(String distance) {
		js.executeScript(distance);
	}
	public static void waiting(WebElement button) {
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}

}
