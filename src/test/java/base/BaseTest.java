package base;

import com.aventstack.extentreports.ExtentTest;
import utils.ConfigReader;
import drivers.DriverFactory;
import utils.ExtentReportManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentTest extentTest;

    // ── runs ONCE before all tests ──────────────────────────────────────
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        // initialize report — creates the HTML file structure
        ExtentReportManager.getInstance();
    }

    // ── runs before EACH @Test method ───────────────────────────────────
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser, Method method) {
        // launch browser
        driver = DriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("base.url"));

        // create a test entry in the report with the method name
        extentTest = ExtentReportManager.createTest(method.getName());
//        extentTest.info("Browser launched — " + ConfigReader.get("browser"));
        extentTest.info("Browser launched — " + browser);
        extentTest.info("URL opened — " + ConfigReader.get("base.url"));
    }

    // ── runs after EACH @Test method ────────────────────────────────────
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE){

            String screenshotPath = takeScreenshot(result.getName());

            try {
                ExtentReportManager.getTest()
                        .addScreenCaptureFromPath(screenshotPath)
                        .fail(result.getThrowable());
            }
            catch (Exception e){
                ExtentReportManager.getTest().fail("Screenshot attach failed "+ e.getMessage());
            }
        } else if (result.getStatus()==ITestResult.SUCCESS) {
            ExtentReportManager.getTest().pass("✅ Test Passes");
        }else if (result.getStatus()==ITestResult.SKIP) {
            ExtentReportManager.getTest().skip("Test Skipped");
        }
 if (driver!=null){
     ExtentReportManager.getTest().info("Browser Closed");
     driver.quit();
 }
    }

    // ── runs ONCE after all tests ───────────────────────────────────────
    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        // write everything to the HTML file
        ExtentReportManager.flushReport();
        System.out.println("✅ Report generated at: reports/TestReport.html");
    }

    // ── screenshot helper method ────────────────────────────────────────
    private String takeScreenshot(String testName) {

        //         timestamp so each screenshot has unique name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";

        String folderPath = System.getProperty("user.dir") + "/screenshots/";
        String filePath   = folderPath + fileName;

                try {
        // create screenshots folder if it doesn't exist
        File folder = new File("screenshots");
                    if (!folder.exists()) folder.mkdirs();

        // capture screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);
        FileUtils.copyFile(src, dest);

        System.out.println("📸 Screenshot saved: " + filePath);
                } catch (IOException e) {
                System.out.println("❌ Screenshot failed: " + e.getMessage());
                }
                return filePath;

            }
}