package com.epam.automation.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class TestBase {

    protected static WebDriver driver;
    private static final String URL = "https://github.com/";

    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

    }

//    @AfterMethod
//    public void close(){
//        driver.quit();
//    }
}
