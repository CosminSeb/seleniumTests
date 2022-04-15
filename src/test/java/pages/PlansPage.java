package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CommonTask;
import util.Waiting;

public class PlansPage extends PageBase {

    public PlansPage(WebDriver passedDriver){
        super(passedDriver);
    }

    //---------------------------- Elements

    @FindBy(xpath = "//*[text()='New plan']")
    private WebElement newPlanBtn;

    //--------------------------- Actions

    public boolean verifyNewPlanBtn(){
        Waiting.waitForPageLoadComplete(driver, 20);
        Waiting.visibilityOfElement(driver, newPlanBtn, "New Plan Button");
        CommonTask.scrollIntoView(driver, newPlanBtn);
        return newPlanBtn.isDisplayed();
    }
}
