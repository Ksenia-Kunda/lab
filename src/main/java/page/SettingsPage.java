package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.DbConfig;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import static helper.Locators.get;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class SettingsPage extends PageBase{

    private LoginPage loginPage;

    private static final String URL_SETTINGS_PAGE = "https://github.com/settings/profile";
    private static final By NAME_INPUT = get("SettingsPage.UserProfileNameInput");
    private static final By MAIL_INPUT = get("SettingsPage.PublicEmailInput");
    private static final By LOCATION_INPUT = get("SettingsPage.LocationInput");
    private static final By UPDATE_PROFILE_BUTTON= get("SettingsPage.UpdateProfileButton");
    private static final By UPDATE_CHECK= get("SettingsPage.UpdateCheck");


    public SettingsPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public SettingsPage goToSettingsPage(){
        driver.get(URL_SETTINGS_PAGE);
        singIn();
        return new SettingsPage(driver);
    }

    public void singIn(){
        loginPage.putEmail();
        loginPage.putPassword();
        loginPage.pressSingInButton();
    }

    public void putName() {
        driver.findElement(NAME_INPUT).clear();
        driver.findElement(NAME_INPUT).sendKeys(DbConfig.getValue("profileSettings.Name"));
    }

    public void putEmail() {
        Select select = new Select(driver.findElement(MAIL_INPUT));
        select.selectByValue(DbConfig.getValue("login.email"));
    }

    public void putLocation() {
        driver.findElement(LOCATION_INPUT).clear();
        driver.findElement(LOCATION_INPUT).sendKeys(DbConfig.getValue("profileSettings.Location"));
    }

    public void pushUpdateProfileButton() {
        driver.findElement(UPDATE_PROFILE_BUTTON).click();
    }

    public String updateCheck() {
        return driver.findElement(UPDATE_CHECK).getText();
    }
}
