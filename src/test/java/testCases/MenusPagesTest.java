package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import util.TestData;

import java.util.ArrayList;
import java.util.List;

public class MenusPagesTest extends DriverBase {

    List<WebElement> menus = new ArrayList<>();


    @BeforeClass()
    public void loginOnSiteAndGetMenus() throws Exception {
        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);

        driver.get("http://localhost:8080/#/root/plans/list");
        driver.manage().window().maximize();
        loginPage.loginUsingUserAndPass(TestData.username, TestData.password);

        Thread.sleep(5000); // not working without any other option for now
        menus = getDriver().findElements(By.xpath("//li[@ng-class]"));
    }

    @Test
    public void verifyPlansPage() throws Exception {
        PlansPage plansPage = new PlansPage(getDriver());

        menus.get(0).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("plans"));
        Assert.assertTrue(plansPage.verifyNewPlanBtn());
    }

    @Test(priority = 1)
    public void verifyKeywordsPage() throws Exception {
        KeywordsPage keywordsPage = new KeywordsPage(getDriver());

        menus.get(1).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("functions"));
        Assert.assertTrue(keywordsPage.verifyNewKeywordBtn());
    }

    @Test(priority = 2)
    public void verifyParametersPage() throws Exception {
        ParametersPage parametersPage = new ParametersPage(getDriver());

        menus.get(2).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("parameters"));
        Assert.assertTrue(parametersPage.verifyNewParameterBtn());
    }


    @Test(priority = 3)
    public void verifyExecutionsPage() throws Exception {
        ExecutionsPage executionsPage = new ExecutionsPage(getDriver());

        menus.get(3).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("executions"));
        Assert.assertTrue(executionsPage.verifyExecutionList());
    }

    @Test(priority = 4)
    public void verifySchedulerPage() throws Exception {
        SchedulerPage schedulerPage = new SchedulerPage(getDriver());

        menus.get(4).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("scheduler"));
        Assert.assertTrue(schedulerPage.verifyNewTaskBtn());
    }

    @Test(priority = 5)
    public void verifyGridPage() throws Exception {
        GridPage gridPage = new GridPage(getDriver());

        menus.get(5).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("grid"));
        Assert.assertTrue(gridPage.verifyAgentsTab());
    }

    @Test(priority = 6)
    public void verifyAdminPage() throws Exception {
        AdminPage adminPage = new AdminPage(getDriver());

        menus.get(6).click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("admin"));
        Assert.assertTrue(adminPage.verifyAddUserBtn());
    }

    @AfterClass
    public void teardown(){
        closeDriverObject();
    }

}

