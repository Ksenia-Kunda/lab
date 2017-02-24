package com.epam.automation.page;

import com.epam.automation.base.PageBase;
import com.epam.automation.helper.DataConfig;
import com.epam.automation.helper.Randomizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class NewRepositoryPage extends PageBase {

    private String repositoryName;
    private LoginPage loginPage;

    @FindBy(css = "#repository_name")
    private WebElement repositoryNameInput;

    @FindBy(css = ".first-in-line")
    private WebElement createRepositoryButton;

    @FindBy(css = ".author")
    private WebElement repositoryTitle;

    @FindBy(css = ".is-autocheck-successful")
    private WebElement successfulName;

    public NewRepositoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void putRepositoryName() {
        repositoryName = DataConfig.getValue("Repository.Name") + Randomizer.getNumber();
        repositoryNameInput.sendKeys(repositoryName);
    }

    public void pushCreateRepositoryButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(successfulName));
        createRepositoryButton.click();
    }

    public Boolean pageTitleContainsRepositoryName() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(repositoryTitle));
        return driver.getTitle().contains(repositoryName);
    }
}
