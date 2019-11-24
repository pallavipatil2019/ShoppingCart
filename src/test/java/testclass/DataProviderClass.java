
package testclass;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "productData")
	public static Object[][] getProductData() {
		return new Object[][] {
			{"dell 5400 charger", "head first python"}
			};
	}
	
}


