package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;



public class AddToShoppingCartPage {
	public static WebElement element = null;
	public static long IMPLICIT_WAIT = 50;
	public static long IMPLICIT_WAIT1 = 150;
	public static void enterProductToSearch(WebDriver driver, String product) {
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	Select searchDropDown= new Select(driver.findElement(By.id("searchDropdownBox")));
		searchDropDown.selectByValue("search-alias=aps");
		
	    
		
		Reporter.log("Searching for head fir1111111111111st book", true);
		element = driver.findElement(By.id("twotabsearchtextbox"));
		
		
		
		element.clear();
		element.sendKeys(product);
	}
	
	public static void clickSearchButton(WebDriver driver) {
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
	}
	
	public static void addToShoppingCart(WebDriver driver) {
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	}
	
	public static void clickOnShoppingCart(WebDriver driver) {
		driver.findElement(By.id("nav-cart-count")).click();
	}

	public static void clickOnProceedCheckout(WebDriver driver) {
		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
	}
	
	public static void clickOnProduct1(WebDriver driver) {
		driver.findElement(By.xpath("//div[@data-asin='B07Q3YDR1C']")).click();
	}

	public static void clickOnProduct2(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElements(By.xpath("//a[./span[contains(text(),'Head First Python: A Brain-Friendly Guide')]]")).get(0).click();
	}
	
	public static void addProductToShoppingCart(WebDriver driver, String product1, String product2 ) {
		  Reporter.log("Searching for dell 5400 charger", true);
		  enterProductToSearch(driver, product1); clickSearchButton(driver);
		  clickOnProduct1(driver); addToShoppingCart(driver);
		  Reporter.log("Searched dell 5400 charger and added to the shopping cart",
		  true);
		 
		 Reporter.log("Searching for head first python", true);
		 enterProductToSearch(driver, product2);
		 clickSearchButton(driver);
		 clickOnProduct2(driver);
		 addToShoppingCart(driver);
		 Reporter.log("Searched head first python and added to the shopping cart", true);
		
		 
	}
	
//	Method to validate the shopping cart
	public static void validateShoppingCart(WebDriver driver) {
		Reporter.log("Checking for items in the shopping cart", true);
		clickOnShoppingCart(driver);
		clickOnProceedCheckout(driver);
		Reporter.log("found items in shopping cart and clicked on proceed to check out", true);
	}
}






