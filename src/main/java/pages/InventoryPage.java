package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    private By addtocart = By.xpath("//div[text()='29.99']/following-sibling::button");
    private By cartIcon = By.xpath("//a[@data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public void addItemToCart(){
        click(addtocart);
    }
    public void goToCart(){
        click(cartIcon);
        waitForUrl("cart");
    }
}
