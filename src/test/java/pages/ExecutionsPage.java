package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiting;

public class ExecutionsPage extends PageBase{

    public ExecutionsPage(WebDriver passedDriver){
        super(passedDriver);
    }

    //---------------------------- Elements

    @FindBy(xpath = "//*[text()=' Execution list ']")
    private WebElement executionListTab;

    //--------------------------- Actions

    public boolean verifyExecutionList(){
        Waiting.visibilityOfElement(driver, executionListTab, "Execution List Tab");
        return executionListTab.isDisplayed();
    }
}
