package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiting;

public class AdminPage extends PageBase{

    public AdminPage(WebDriver passedDriver){
        super(passedDriver);
    }


    //---------------------------- Elements

    @FindBy(xpath = "//*[text()='Add user']")
    private WebElement addUserBtn;

    //--------------------------- Actions

    public boolean verifyAddUserBtn(){
        Waiting.visibilityOfElement(driver, addUserBtn, "Add User Button");
        return addUserBtn.isDisplayed();
    }


}
