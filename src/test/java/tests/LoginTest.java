package tests;

import base.BaseTest;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelDataProvider;
import utils.ExcelReader;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest {

    //Makes method act as data supplier.
    @DataProvider(name = "excelLoginData")
    public Object[][] getLoginData(){
        return ExcelDataProvider.getLoginData();
    }

    @Test(dataProvider = "excelLoginData", groups = {"regression", "dataDriven"})

    public void testLoginWithMultipleUsers(String username,String password,String expectedResult){
        ExtentReportManager.getTest().info("Testing -> Username: ["+username+"] Password: ["+password +"]");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        if (expectedResult.equalsIgnoreCase("pass")){
            boolean isOnInventory = driver.getCurrentUrl().contains("inventory");
            Assert.assertTrue(isOnInventory,"Expected login to PASS but failed for user: " + username);
            ExtentReportManager.getTest().pass("✅ Login passed for: " + username);
        }
        else{

            String error = loginPage.getErrorMessage();
            Assert.assertFalse(error.isEmpty(),"Expected error message but none shown for user: " + username);
            ExtentReportManager.getTest().pass("✅ Error shown correctly for: " + username + " → " + error);
        }
    }
    @Test(description = "Login with valid credential" ,groups = {"smoke"})
    public  void testValidLogin(){

        ExtentReportManager.getTest().info("Step 1: Logging in with valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
        ExtentReportManager.getTest().pass("✅  Login successful");
    }

    @Test(description = "Login with invalid credentials should show error" , groups = {"regression"})
    public void testInvalidLogin() {
        ExtentReportManager.getTest().info("Step 2: Testing login with wrong credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_pass");

        // assert error message appears
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"));
        ExtentReportManager.getTest().pass("Error message displayed correctly: " + error);
    }

}
