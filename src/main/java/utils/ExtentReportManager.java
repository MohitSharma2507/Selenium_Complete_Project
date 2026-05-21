package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager {

    // single instance shared across all tests
//    ExtentReports  →  the MASTER report object
//    collects all test data (pass/fail/skip/logs)
//    think of it as the entire report file in memory
    private static ExtentReports extent;

    // one ExtentTest per @Test method (ThreadLocal = safe for parallel)
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // called ONCE before suite starts — creates the report file
    public static ExtentReports getInstance() {

        if (extent == null) {
//          ExtentSparkReporter  ->  the HTML file generator
//            knows HOW to write the report to disk
//            generates the actual TestReport.html file
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/TestReport.html");

            // report configuration
            reporter.config().setDocumentTitle("Automation Test Report"); //text shown on browser tab
            reporter.config().setReportName("SauceDemo Test Suite"); // heading shown inside the report
            reporter.config().setTheme(Theme.DARK);     // DARK or STANDARD
            reporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss"); //how date/time is shown next to each test
            extent = new ExtentReports(); //Creates the master report object
            extent.attachReporter(reporter); //Connects the brain to the printer

            // environment info shown in report
            extent.setSystemInfo("Application", "SauceDemo");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", ConfigReader.get("browser"));
            extent.setSystemInfo("Tester", "Mohit Sharma");

        }
        return extent;
    }

    // called at start of each @Test — creates test entry in report
    public static ExtentTest createTest(String testName) {
        ExtentTest test = getInstance().createTest(testName);
        extentTest.set(test);
        return test;
    }

    // called anywhere to log steps
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // called ONCE after suite — writes HTML file to disk
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}

//        if (result.getStatus() == ITestResult.FAILURE) {
//
//// 1. take screenshot
//String screenshotPath = takeScreenshot(result.getName());
//
//// 2. log FAIL in report with screenshot attached
//            try {
//                    ExtentReportManager.getTest()
//                        .addScreenCaptureFromPath(screenshotPath)  // attach screenshot
//                        .fail(result.getThrowable());              // attaches screenshot
//
//        } catch (Exception e) {
//        ExtentReportManager.getTest().fail("Screenshot attach failed: " + e.getMessage());
//        }
//
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//        ExtentReportManager.getTest().pass("✅ Test Passed");
//
//        } else if (result.getStatus() == ITestResult.SKIP) {
//        ExtentReportManager.getTest().skip("Test Skipped: " + result.getThrowable());
//        }
//
//        // close browser after every test
//        if (driver != null) {
//        driver.quit();
//            ExtentReportManager.getTest().info("Browser closed");
//        }


