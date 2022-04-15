package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected static WebDriver driver;

    public PageBase(WebDriver passedDriver){
        driver = passedDriver;
        PageFactory.initElements(passedDriver, this);
    }


}
