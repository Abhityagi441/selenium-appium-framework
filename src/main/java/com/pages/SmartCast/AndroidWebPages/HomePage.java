package com.pages.SmartCast.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.SmartCast.generic.CommonHomePage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonHomePage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "//a[@class='logo']/img")
    private static WebElement smartCastLogo;
    @FindBy(xpath="//div/small[@class='liner2']")
    private static WebElement hamburgerLinesOpen;
    @FindBy(xpath="//div/small[@class='liner2']")
    private static WebElement hamburgerLinesClosed;
    @FindBy(xpath = "//nav[@class='primaryMenu']/ul/li/a")
    private static List<WebElement> hamburgerTopmost;
    @FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[1]")
    private static WebElement hamburgerHome;
    @FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[2]")
    private static WebElement hamburgerTrending;
    @FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[3]")
    private static WebElement hamburgerPublishers;
    @FindBy(xpath = "(//nav[@class='primaryMenu']/ul/li/a)[4]")
    private static WebElement hamburgerCategories;
    @FindBy(xpath = "//ul[@class='childMenu']/li/a")
    private static List<WebElement> hamburgerCategoriesList;
    @FindBy(xpath = "//div[@class='myListMenu']/p/a")
    private static WebElement hamburgerMyListMenu;
    @FindBy(xpath = "//nav[contains(@class, 'primaryMenu smart-menu')]/ul/li/a")
    private static List<WebElement> hamburgerBottom;
    @FindBy(xpath = "//li[@class='partner-menu ']/a")
    private static WebElement hamburgerPartner;
    @FindBy(xpath = "//li[@class='aboutUsLink ']/a")
    private static WebElement hamburgerAboutUs;
    @FindBy(xpath = "//div//span[@class='errorThumb']/img")
    private static WebElement error;
    @FindBy(xpath = "(//div[contains(@class, 'owl-item active')]//a/img)[1]")
    private static WebElement latestPodcastImage;
    @FindBy(xpath = "(//div[contains(@class, 'owl-item active')]//a)[1]")
    private static WebElement latestPodcastImageTitle;
    @FindBy(xpath = "//div[@class='large-toggle-btn']/i[@class='large-pause-btn']")
    private static WebElement videoPauseButton;
    @FindBy(xpath = "(//div[@class='controls-box']/i)[2]")
    private static WebElement nextTrackButton;
    @FindBy(xpath = "(//div[@class='controls-box']/i)[1]")
    private static WebElement previousTrackButton;
    @FindBy(xpath = "(//a[@class='sharefb'])[1]")
    private static WebElement fbShareIcon;
    @FindBy(xpath = "//input[@id='email']")
    private static WebElement fbUserEmailId;
    @FindBy(xpath = "//input[@id='pass']")
    private static WebElement fbUSerPassword;
    @FindBy(xpath = "//input[@name='login']")
    private static WebElement fbLoginButton;
    @FindBy(xpath = "(//button[@type='submit'])[2]/span")
    private static WebElement fbShareButton;
    @FindBy(xpath = "(//a[@class='sharetw'])[1]")
    private static WebElement twitterShareIcon;
    @FindBy(xpath = "//input[@autocapitalize='none'and@type='text']")
    private static WebElement twitterEmailId;
    @FindBy(xpath = "//input[@autocapitalize='none'and@type='password']")
    private static WebElement twitterPassword;
    @FindBy(xpath = "(//div[@role='button'])[2]")
    private static WebElement twitterLoginButton;
    @FindBy(xpath = "//div[@role='button'and@data-testid='tweetButton']")
    private static WebElement tweetButton;
    @FindBy(xpath = "(//div[@role='alert']//div)[5]")
    private static WebElement twitterError;
    @FindBy(id = "userName")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(id = "signInBtn")
    private static WebElement singInButton;
    @FindBy(xpath = "//a[@id='addRemoveList']")
    private static WebElement bookmarkIcon;
    @FindBy(xpath = "//h1[@class='blockHeading']")
    private static WebElement MyListHeading;
    @FindBy(xpath = "(//span[@class='addList'])[1]")
    private static WebElement bookmarkedElement;
    @FindBy(xpath = "//input[@id='phoneEmail']")
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin")
    private static WebElement signInButtonMainSignInPage;
    @FindBy(xpath = "//div[@class='myListPage']/div/small/a")
    private static WebElement explorePodcast;
    @FindBy(xpath = "//div[@class='shareTools']/div/span")
    private static List<WebElement>  bookmarkedElementToClear;
    @FindBy(xpath = "//h2[@class='blockHeading']")
    private static List<WebElement>  homeSectionTrays;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;
    @FindBy(xpath = "(//h3[@class='heading']/a)[1]")
    private static WebElement podcastImage;
    @FindBy(xpath = "//div[@class='podcastCurrentEpisode']/img")
    private static WebElement podcastInfoImage;
    @FindBy(xpath = "//h1[@class='podcastshow']")
    private static WebElement podcastInfoHeadingText;
    @FindBy(xpath = "//h3[@class='blockHeading']")
    private static List<WebElement>  podcastInfoTrays;
    @FindBy(xpath = "//a[@class='playlist-track']")
    private static List<WebElement>  podcastInfoEpisodesList;
    @FindBy(xpath = "//input[@id='news_email']")
    private static WebElement sharedEmail;
    @FindBy(xpath = "//input[@id='subscribe']")
    private static WebElement sharedEmailSubscribeButton;
    @FindBy(xpath = "//span[@class='closeScroll']")
    private static WebElement sharedEmailSuccess;
    @FindBy(xpath = "//div[@class='myListMenu']/nav/ul/li/a/small")
    private static WebElement bookmarkedElementInMyList;

    public HomePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(allow, 10, "allow notifications");
        if (isElementPresent) { commonFunctions.clickElementIfDisplayed(allow,10,"allow notifications"); }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public String getSmartCastTitle() {
        return commonFunctions.getTitle();
    }

    @Override
    public boolean clickSmartCastLogo() {
        return commonFunctions.clickElementWithJS(smartCastLogo ,5, "smartCast logo");
    }

    @Override
    public boolean checkHamburger() {
        return false;
    }

    @Override
    public boolean checkFacebookSharingFromLatestPodcast(String email, String password) {
        return false;
    }

    @Override
    public boolean checkTwitterSharingFromLatestPodcast(String email, String password) {
        return false;
    }

    @Override
    public boolean bookmarkStoryWithLoggedInUser(String propertyName) {
        return false;
    }

    @Override
    public boolean clearBookmarkStoryWithLoggedInUser(String propertyName) {
        return false;
    }

    @Override
    public boolean checkHomeSectionTrays() {
        return false;
    }

    @Override
    public boolean checkPodcastPlayerFunctions() {
        return false;
    }

    @Override
    public boolean checkPodcastInformation(String propertyName) {
        return false;
    }

    @Override
    public boolean checkShareEmailFunctionality() {
        return false;
    }
}
