import com.epam.automation.base.TestBase;
import com.epam.automation.page.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class FeatureTest extends TestBase{

    private HomePage homePage;
    private LoginPage loginPage;
    private UserMainPage userMainPage;
    private SettingsPage settingsPage;
    private NewRepositoryPage newRepositoryPage;
    private static final String successfulUpdating = "Profile updated successfully — view your profile.";

    @BeforeMethod
    public void setup(){
        super.setup();
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        userMainPage = PageFactory.initElements(driver, UserMainPage.class);
        settingsPage = PageFactory.initElements(driver, SettingsPage.class);
        newRepositoryPage = PageFactory.initElements(driver, NewRepositoryPage.class);

    }

    @Test
    public void changePublicProfileSettings(){
        homePage.pushSingInButton();
        loginPage.login();
        userMainPage.goToSettingsPage();
        settingsPage.changeData();

        Assert.assertEquals(successfulUpdating, settingsPage.updateCheck(), "Data doesn't update.");
    }

    @Test
    public void createNewRepository() {
        homePage.pushSingInButton();
        loginPage.login();
        userMainPage.clickNewRepositoryButton();
        newRepositoryPage.putRepositoryName();
        newRepositoryPage.pushCreateRepositoryButton();

        Assert.assertTrue(newRepositoryPage.pageTitleContainsRepositoryName(), "Repository doesn't exist.");
    }

}
