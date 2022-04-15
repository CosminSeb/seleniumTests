package testCases;

import config.DriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;

    @BeforeTest(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverFactory = ThreadLocal.withInitial(() -> {
            DriverFactory driverFactory = new DriverFactory();
            webDriverThreadPool.add(driverFactory);
            return driverFactory;
        });
    }

    public static RemoteWebDriver getDriver() throws Exception {
        return driverFactory.get().getDriver();
    }

    @AfterTest(alwaysRun = true)
    public static void clearCookies() {
        try {
            driverFactory.get().getStoredDriver().manage().deleteAllCookies();
        } catch (Exception ignored) {
            System.out.println("Unable to clear cookies, driver object is no available...");
        }
    }

    @AfterTest(alwaysRun = true)
    public static void closeDriverObject() {
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
    }
}
