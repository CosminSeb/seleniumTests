package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiting;

public class SchedulerPage extends PageBase{

    public SchedulerPage(WebDriver passedDriver){
        super(passedDriver);
    }

    //---------------------------- Elements

    @FindBy(xpath = "//*[text()='New task']")
    private WebElement newTaskBtn;

    //--------------------------- Actions

    public boolean verifyNewTaskBtn(){
        Waiting.waitForPageLoadComplete(driver, 10);
        Waiting.visibilityOfElement(driver, newTaskBtn, "New Task Button");
        return newTaskBtn.isDisplayed();
    }
}
