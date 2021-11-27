package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrderProductpage;


public class SearchProductTest extends InitialTest {

	
	OrderProductpage searchProductObject;

	@Test
	public void searchBlouses() {
	
		searchProductObject = new OrderProductpage(driver);
		
		searchProductObject.searchforProduct();
	
	}
	@Test(dependsOnMethods = "searchBlouses")
	public void selectResultedProduct() {
		
		searchProductObject.selectblouse();
		
	}
		
	@Test (dependsOnMethods = "selectResultedProduct")
	public void checkProceedCheckoutSuccessfully() throws InterruptedException {
		
		searchProductObject.Checkout();
		Assert.assertEquals(searchProductObject.orderconfirmation.getText(), "Your order on My Store is complete.");
		Thread.sleep(3000);
	}
}
