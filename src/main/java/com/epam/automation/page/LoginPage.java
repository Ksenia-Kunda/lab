package com.epam.automation.page;

import com.epam.automation.base.PageBase;
import com.epam.automation.helper.DataConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class LoginPage extends PageBase{

    @FindBy(css = "#login_field")
    private WebElement emailInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = ".btn-block")
    private WebElement singInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public UserMainPage login(){
        emailInput.sendKeys(DataConfig.getValue("login.email"));
        passwordInput.sendKeys(DataConfig.getValue("login.password"));
        singInButton.click();
        return new UserMainPage(driver);
    }

}
