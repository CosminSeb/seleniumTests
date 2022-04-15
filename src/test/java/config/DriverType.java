package config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

public enum DriverType implements DriverSetup{

    CHROME{
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities){
            System.setProperty("webdriver.chrome.driver","src//test//resources//drivers//chromedriver");
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", false);
            chromePreferences.put("safebrowsing.enabled", "false");

            ChromeOptions options = new ChromeOptions();
            options.merge(capabilities);
            options.addArguments(String.valueOf(HEADLESS));
            options.addArguments("chrome.switches","--disable-extensions");
            options.addArguments("--disable-save-password");
            options.addArguments("disable-infobars");
            return new ChromeDriver(options);
        }
    };

    public final static boolean HEADLESS = Boolean.getBoolean("headless");

    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}
