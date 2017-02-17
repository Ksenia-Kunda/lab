import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.NewRepositoryPage;
import page.SettingsPage;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class FeatureTest extends TestBase{

    private SettingsPage settingsPage;
    private NewRepositoryPage newRepositoryPage;
    private static final String successfulUpdating = "Profile updated successfully — view your profile.";

    @BeforeMethod
    public void setup(){
        super.setup();
        settingsPage = new SettingsPage(driver);
        newRepositoryPage = new NewRepositoryPage(driver);
    }

    @Test
    public void changePublicProfileSettings(){
        settingsPage.goToSettingsPage();
        settingsPage.putName();
        settingsPage.putEmail();
        settingsPage.putLocation();
        settingsPage.pushUpdateProfileButton();

        Assert.assertEquals(successfulUpdating, settingsPage.updateCheck(), "Data doesn't update.");
    }

    @Test
    public void createNewRepository() {
        newRepositoryPage.goToNewRepositoryPage();
        newRepositoryPage.createName();
        newRepositoryPage.putRepositoryName();
        newRepositoryPage.pushCreateRepositoryButton();

        Assert.assertTrue(newRepositoryPage.getTitle(), "Repository doesn't exist.");

    }

}
