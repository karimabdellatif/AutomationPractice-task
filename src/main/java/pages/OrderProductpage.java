package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderProductpage extends InitialPage {

	public OrderProductpage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		wait= new WebDriverWait(driver, 60);
	}

	@FindBy(linkText = "Women")
	WebElement WomenCategory;
		
	@FindBy(linkText = "Tops")
	WebElement top;

	@FindBy(linkText = "Blouses")
	public WebElement blousecategory;

	@FindBy(linkText = "Blouse")
	WebElement selectedblouse;
	
	@FindBy(id="add_to_cart")
	WebElement addtocart;
	
	@FindBy(linkText ="Proceed to checkout")
	WebElement proceedtocheckout;
	
	@FindBy(id="cgv")
	WebElement agreetoterms;
	
	@FindBy(xpath ="//button[@name='processAddress']")
	WebElement checkoutaddress;
	
	@FindBy(xpath ="//button[@name='processCarrier']")
	WebElement proceedtoshipping;
	
	@FindBy(xpath ="//*[@class='bankwire']")
	WebElement bankwire;

	@FindBy(xpath ="//*[@class='button btn btn-default button-medium']")
	WebElement confirmorder;
	
	@FindBy(xpath ="//*[@class='cheque-indent']")
	public WebElement orderconfirmation;

	//search for blouse
	public void searchforProduct() {
		clickButton(WomenCategory);
		clickButton(top);
		clickButton(blousecategory);
		scrolldown("scrollBy(0,800)");
	}

	// open blouse details
	public void selectblouse() {
		clickButton(selectedblouse);
	}

	// confirming order and checkout
	public void Checkout() {

		scrolldown("scrollBy(0,800)");
		waiting(addtocart);

		clickButton(addtocart);
		clickButton(proceedtocheckout);
		scrolldown("scrollBy(0,2000)");
		clickButton(proceedtocheckout);
		scrolldown("scrollBy(0,2000)");
		clickButton(checkoutaddress);
		scrolldown("scrollBy(0,1500)");
		clickButton(agreetoterms);
		clickButton(proceedtoshipping);
		scrolldown("scrollBy(0,800)");
		clickButton(bankwire);
		scrolldown("scrollBy(0,500)");
		clickButton(confirmorder);
		scrolldown("scrollBy(0,200)");
	
	}

	// check out after Reorder
	public void reorderCheckout() {
		scrolldown("scrollBy(0,2000)");
		clickButton(proceedtocheckout);
		scrolldown("scrollBy(0,2000)");
		clickButton(checkoutaddress);
		scrolldown("scrollBy(0,1500)");
		clickButton(agreetoterms);
		clickButton(proceedtoshipping);
		scrolldown("scrollBy(0,800)");
		clickButton(bankwire);
		scrolldown("scrollBy(0,500)");
		clickButton(confirmorder);
		scrolldown("scrollBy(0,200)");
	}
}
