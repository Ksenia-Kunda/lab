package com.epam.automation.page;

import com.epam.automation.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kseniya_Kunda on 2/23/2017.
 */
public class HomePage extends PageBase{

    @FindBy(css = "[href=\"/login\"]")
    private WebElement singInButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage pushSingInButton(){
        singInButton.click();
        return new LoginPage(driver);
    }

}
