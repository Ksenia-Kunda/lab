package page;

import base.PageBase;
import helper.DbConfig;
import helper.Randomazer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helper.Locators.get;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class NewRepositoryPage extends PageBase {

    private static final String NEW_REPOSITORY_PAGE = "https://github.com/new";
    private static final By REPOSITORY_NAME_INPUT = get("NewRepositoryPage.RepositoryName");
    private static final By CREATE_REPOSITORY_BUTTON = get("NewRepositoryPage.RepositoryButton");
    private static final By REPOSITORY_TITLE = get("NewRepositoryPage.RepositoryTitle");
    private static final By SUCCESSFUL_NAME = get("NewRepositoryPage.SaccessfulName");
    private Boolean title = false;

    private String repositoryName;
    private LoginPage loginPage;

    public NewRepositoryPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public NewRepositoryPage goToNewRepositoryPage() {
        driver.get(NEW_REPOSITORY_PAGE);
        singIn();
        return new NewRepositoryPage(driver);
    }

    public void singIn() {
        loginPage.putEmail();
        loginPage.putPassword();
        loginPage.pressSingInButton();
    }

    public void createName() {
        repositoryName = DbConfig.getValue("Repository.Name") + Randomazer.getRandomNumber();
    }

    public void putRepositoryName() {
        driver.findElement(REPOSITORY_NAME_INPUT).sendKeys(repositoryName);
    }

    public void pushCreateRepositoryButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(SUCCESSFUL_NAME));
        driver.findElement(CREATE_REPOSITORY_BUTTON).click();
    }

    public Boolean getTitle() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(REPOSITORY_TITLE));
        if (driver.getTitle().contains(repositoryName)) {
            title = true;
        }
        return title;
    }
}
