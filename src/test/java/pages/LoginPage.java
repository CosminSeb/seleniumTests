package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiting;

import static util.CommonTask.*;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver passedDriver){
        super(passedDriver);
    }

    //---------------------------- Elements

    @FindBy(name = "username")
    private WebElement userField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//*[text()='Login']")
    private WebElement loginInBtn;

    //--------------------------- Actions

    public void loginUsingUserAndPass(String user, String password){
        Waiting.visibilityOfElement(driver, userField, "User Field");
        clearElement(userField, "User Field");
        clearElement(passwordField, "Password Field");
        sendKeys(userField, user, "User Field");
        sendKeys(passwordField, password, "Password Field");
        clickElement(driver, loginInBtn, "Sign in Button");
    }

}
