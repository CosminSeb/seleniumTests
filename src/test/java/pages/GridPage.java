package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiting;

public class GridPage extends PageBase{

    public GridPage(WebDriver passedDriver){
        super(passedDriver);
    }

    //---------------------------- Elements

    @FindBy(xpath = "//*[text()='Agents']")
    private WebElement agentsTabBtn;

    //--------------------------- Actions

    public boolean verifyAgentsTab(){
        Waiting.visibilityOfElement(driver, agentsTabBtn, "Agents Tab");
        return agentsTabBtn.isDisplayed();
    }
}
