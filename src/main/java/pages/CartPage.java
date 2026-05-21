package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By checkout = By.xpath("//button[text()='Checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void proceedToCheckout(){
        click(checkout);
        waitForUrl("checkout");
    }
}
