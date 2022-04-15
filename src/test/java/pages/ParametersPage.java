package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiting;

public class ParametersPage extends PageBase{

    public ParametersPage(WebDriver passedDriver){
        super(passedDriver);
    }

    //---------------------------- Elements

    @FindBy(xpath = "//*[text()='New parameter']")
    private WebElement newParameterBtn;

    //--------------------------- Actions

    public boolean verifyNewParameterBtn(){
        Waiting.visibilityOfElement(driver, newParameterBtn, "New Parameter Button");
        return newParameterBtn.isDisplayed();
    }
}
