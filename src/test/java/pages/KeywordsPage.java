package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiting;

public class KeywordsPage extends PageBase{

    public KeywordsPage(WebDriver passedDriver){
        super(passedDriver);
    }

    //---------------------------- Elements

    @FindBy(xpath = "//*[text()='New keyword']")
    private WebElement newKeywordBtn;

    //--------------------------- Actions

    public boolean verifyNewKeywordBtn(){
        Waiting.visibilityOfElement(driver, newKeywordBtn, "New Keyword Button");
        return newKeywordBtn.isDisplayed();
    }
}
