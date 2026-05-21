package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends  BasePage{

    private By usernameField = By.xpath("//input[@placeholder='Username']");
    private By passwordField = By.xpath("//input[@placeholder='Password']");
    private By loginBtn = By.xpath("//input[@type='submit']");

    private By errorMessage  = By.cssSelector("[data-test='error']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username , String password){
        type(usernameField,username);
        type(passwordField,password);
        click(loginBtn);
//        waitForUrl("inventory");
    }

    public String getErrorMessage() {
        return getText(errorMessage);  // uses BasePage.getText()
    }
}
