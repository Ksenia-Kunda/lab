package base;

import org.openqa.selenium.WebDriver;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }
}
