package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OrderHistoryPage;
import pages.OrderProductpage;

public class OrderHistoryTest extends InitialTest {

	HomePage homePageObject ;
	OrderHistoryPage orderHistoryPage;
	OrderProductpage selectObject;
	
	@Test
	public void orderFromHistory() throws InterruptedException{

		homePageObject = new HomePage(driver);
		homePageObject.openhistroypage();
		orderHistoryPage = new OrderHistoryPage(driver);
		orderHistoryPage.reorder();
		selectObject = new OrderProductpage(driver);
		selectObject.reorderCheckout();
		Assert.assertEquals(orderHistoryPage.orderconfirmtxt.getText(), "Your order on My Store is complete.");
		Thread.sleep(3000);
	}
	
}
