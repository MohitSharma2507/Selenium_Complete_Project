package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory
{
  public static WebDriver getDriver(String browser){

//      String browser = ConfigReader.get("browser");

      if(browser.equalsIgnoreCase("chrome")){
          WebDriverManager.chromedriver().setup();
          return new ChromeDriver();
      }

      else if(browser.equalsIgnoreCase("edge")){
          WebDriverManager.edgedriver().setup();
          return new EdgeDriver();
      }
      else {
           throw new RuntimeException("Browser not found"+ browser);
      }
  }
}