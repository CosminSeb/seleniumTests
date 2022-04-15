package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlansPage;
import util.TestData;

public class LoginPageTest extends DriverBase{


    @Test
    public void loginUsingCorrectCredentials() throws Exception {
        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);
        PlansPage plansPage = new PlansPage(driver);

        driver.get("http://localhost:8080/#/root/plans/list");
        driver.manage().window().maximize();
        loginPage.loginUsingUserAndPass(TestData.username, TestData.password);
        getDriver().navigate().refresh();
        Thread.sleep(2000);
        Assert.assertTrue(plansPage.verifyNewPlanBtn());


    }

    @AfterTest
    public void teardown(){
        closeDriverObject();
    }
}
