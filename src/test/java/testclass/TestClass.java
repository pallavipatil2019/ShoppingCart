package testclass;


import org.testng.annotations.Test;
import basicsetup.BaseClass;
import pageobjects.AddToShoppingCartPage;
import java.io.IOException;

public class TestClass extends BaseClass {


	@Test(priority=1, dataProvider="productData", dataProviderClass=DataProviderClass.class)
	public void addProductsToShoppingCart(String product1, String product2) throws IOException {
		AddToShoppingCartPage.addProductToShoppingCart(driver, product1, product2);
	}
	
	
	@Test(priority=2)
	public void validateShoppingCartItems() throws IOException {
		
		AddToShoppingCartPage.validateShoppingCart(driver);
	}
	
}

