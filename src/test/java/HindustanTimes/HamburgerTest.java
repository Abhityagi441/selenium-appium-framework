package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HamburgerTest extends BaseTest {
    private static CommonHamburgerPage hamburgerPage;
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod(){
        hamburgerPage=CommonHamburgerPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Mahantesh,Imran")
    @Description("QAAUT-519(web),QAAUT-543(mweb), QAAUT-629(amp), QAAUT-589(Android),QAAUT-567(ios-mWeb),QAUTH-651(ios-amp), 609(iOS): To verify hamburger is clickable and elements are clickable")
    @Test
    public void verifyHamburgerIsClickableAndElementsAreClickable() {
        boolean isStepTrue;
        isStepTrue=hamburgerPage.checkHamburgerElementsClickable();
        Assert.assertTrue(isStepTrue,"Hamburger cases failed");

    }
    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1407(WEB): Verify user is able to click on any section from hamburger")
    @Test
    public void verifyAnySectionPage() {
        boolean isStepTrue = false;
        isStepTrue=hamburgerPage.checkAnySectionPage();
        Assert.assertTrue(isStepTrue,"Verify Any Section Page Failed");

    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1433(WEB): To verify scroll on page is working")
    @Test
    public void verifyScrollOnPage() {
        boolean isStepTrue = false;
        isStepTrue=hamburgerPage.checkIndiaNewsPageScrollable();
        Assert.assertTrue(isStepTrue,"Verify Any Section Page Failed");

    }

    @Author(name = "Ravinder Singh,Harsh Sharma")
    @Description("QAAUT-1410,QAAUT-1408(Android-MWeb): Verify user is able to click on any section from hamburger")
    @Test
    public void verifySectionPageOnHamburgerMenu() {
        boolean isStepTrue;
        isStepTrue=hamburgerPage.clickWorldNewsSectionOnHamburgerMenu();
        Assert.assertTrue(isStepTrue,"Click Random section on Hamburger page failed");

    }

    @Author(name = "Ravinder Singh, Gulshan Tomar,Harsh Sharma")
    @Description("QAAUT-1418, QAAUT-1415(Web),QAAUT-1416(Android-MWeb): To verify explore options in hamburger")
    @Test
    public void verifyExploreOptionOnHamburgerMenu() {
        boolean isStepTrue;
        isStepTrue=hamburgerPage.checkExploreHTOptionDisplayedOnHamburgerMenu();
        Assert.assertTrue(isStepTrue,"Explore HT Options in Hamburger failed");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1703(iOS): Verify after the header, Heading with text 'Popular Sections' is displayed")
    @Test
    public void verifyPopularSectionsDisplayed() {
        boolean isStepTrue;
        isStepTrue=hamburgerPage.checkPopularSectionsDisplayed();
        Assert.assertTrue(isStepTrue,"Popular Options in Hamburger failed");

    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1701(iOS): Verify that after the Heading, Sections names is displayed")
    @Test
    public void verifySectionsDisplayed() {
        boolean isStepTrue;
        isStepTrue=hamburgerPage.checkSectionsDisplayed();
        Assert.assertTrue(isStepTrue,"Popular Options in Hamburger failed");

    }

}
