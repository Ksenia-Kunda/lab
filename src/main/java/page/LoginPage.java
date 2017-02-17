package page;

import base.PageBase;
import helper.DbConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.Locators.get;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class LoginPage extends PageBase{

    private static final By EMAIL_INPUT = get("LoginPage.EmailInput");
    private static final By PASSWORD_INPUT = get("LoginPage.PasswordInput");
    private static final By SING_IN_BUTTON = get("LoginPage.SingInButton");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void putEmail(){
        driver.findElement(EMAIL_INPUT).sendKeys(DbConfig.getValue("login.email"));
    }

    public void putPassword(){
        driver.findElement(PASSWORD_INPUT).sendKeys(DbConfig.getValue("login.password"));
    }

    public void pressSingInButton(){
        driver.findElement(SING_IN_BUTTON).click();
    }

}
