package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends InitialPage {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "order-list")
	public static WebElement table;
	@FindBy(xpath ="//*[@class='cheque-indent']")
	public WebElement orderconfirmtxt;

	// reorder from history page
	public void reorder() {
		WebElement reorder = table.findElement(By.cssSelector("tr.first_item"));
		WebElement item = reorder.findElement(By.linkText("Reorder"));
		item.click();
	}
}
