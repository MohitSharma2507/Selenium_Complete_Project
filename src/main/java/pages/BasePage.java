package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

protected WebDriver driver ;
protected WebDriverWait wait;

public BasePage(WebDriver driver){
    this.driver = driver;
    this. wait = new WebDriverWait(driver,Duration.ofSeconds(10));
}

protected void click(By locator){
wait.until(ExpectedConditions.elementToBeClickable(locator));
driver.findElement(locator).click();
}

protected void type(By locator, String text){
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
}
protected String getText(By locator){
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return driver.findElement(locator).getText();
}
protected void waitForUrl(String urlPart){
    wait.until(ExpectedConditions.urlContains(urlPart));
}

}
