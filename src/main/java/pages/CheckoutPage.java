package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private By firstNameField  = By.xpath("//input[@placeholder='First Name']");
    private By lastNameField   = By.xpath("//input[@placeholder='Last Name']");
    private By zipCodeField    = By.xpath("//input[@placeholder='Zip/Postal Code']");
    private By continueBtn     = By.id("continue");
    private By finishBtn       = By.id("finish");
    private By backHomeBtn     = By.xpath("//button[text()='Back Home']");
    private By confirmationMsg = By.className("complete-header");


    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public void fillDetails(String firstname, String lastname, String zip) {

        type(firstNameField, firstname);
        type(lastNameField, lastname);
        type(zipCodeField, zip);
        click(continueBtn);
        waitForUrl("checkout-step-two");
    }
    public void finishOrder(){
        click(finishBtn);
        waitForUrl("checkout-complete");
    }
    public void goBackHome(){
        click(backHomeBtn);
        waitForUrl("inventory");
    }
    public String getConfirmationMessage(){
      return getText(confirmationMsg);
    }
}
