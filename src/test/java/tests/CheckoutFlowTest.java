package tests;

import base.BaseTest;
import pages.*;
import utils.ConfigReader;
import utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutFlowTest extends BaseTest {


    @Test(description = "Complete checkout flow from login to order confirmation", groups = {"regression"})
    public void testCompleteCheckoutFlow() {

        // Step 1 — Login
        ExtentReportManager.getTest().info("Step 1: Logging in with valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
        ExtentReportManager.getTest().pass("Login successful");

        // Step 2 — Add to cart
        ExtentReportManager.getTest().info("Step 2: Adding item to cart");
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart();
        inventoryPage.goToCart();
        ExtentReportManager.getTest().pass("Item added to cart");

        // Step 3 — Checkout
        ExtentReportManager.getTest().info("Step 3: Proceeding to checkout");
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        ExtentReportManager.getTest().pass("Checkout page reached");

        // Step 4 — Fill details
        ExtentReportManager.getTest().info("Step 4: Filling checkout form");
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillDetails("Mohit", "Sharma", "110047");
        checkoutPage.finishOrder();
        ExtentReportManager.getTest().pass("Order placed successfully");

        // Step 5 — Assert
        String msg = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(msg, "Thank you for your order!");
        ExtentReportManager.getTest().pass("✅ Confirmation message verified: " + msg);
    }

}