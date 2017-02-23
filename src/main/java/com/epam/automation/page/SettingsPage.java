package com.epam.automation.page;

import com.epam.automation.base.PageBase;
import com.epam.automation.helper.DataConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class SettingsPage extends PageBase{

    private LoginPage loginPage;

    @FindBy(css = "#user_profile_name")
    private WebElement userProfileNameInput;

    @FindBy(css = "#user_profile_email")
    private WebElement publicEmailInput;

    @FindBy(css = "#user_profile_location")
    private WebElement locationInput;

    @FindBy(css = "p .btn")
    private WebElement updateProfileButton;

    @FindBy(css = "#js-flash-container .container")
    private WebElement updateCheck;

    public SettingsPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void changeData() {
        userProfileNameInput.clear();
        userProfileNameInput.sendKeys(DataConfig.getValue("profileSettings.Name"));
        Select select = new Select(publicEmailInput);
        select.selectByValue(DataConfig.getValue("login.email"));
        locationInput.clear();
        locationInput.sendKeys(DataConfig.getValue("profileSettings.Location"));
        updateProfileButton.click();
    }

    public String updateCheck() {
        return updateCheck.getText();
    }
}
