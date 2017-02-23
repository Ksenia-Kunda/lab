package com.epam.automation.page;

import com.epam.automation.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kseniya_Kunda on 2/23/2017.
 */
public class UserMainPage extends PageBase{

    @FindBy(linkText = "Settings")
    private WebElement settingsButton;

    @FindBy(css = ".header-nav-link.name>span")
    private WebElement menuButton;

    @FindBy(css = ".btn-primary")
    private WebElement newRepositoryButton;

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public SettingsPage goToSettingsPage(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(menuButton));
        menuButton.click();
        settingsButton.click();
        return new SettingsPage(driver);
    }

    public NewRepositoryPage clickNewRepositoryButton(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(newRepositoryButton));
        newRepositoryButton.click();
        return new NewRepositoryPage(driver);
    }
}
