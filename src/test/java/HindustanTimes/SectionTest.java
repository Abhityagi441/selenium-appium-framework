package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class SectionTest extends BaseTest {
    private static CommonSectionPage sectionPage;
    private static CommonLoginPage loginPage;
    GlobalVars globalVars = GlobalVars.getInstance();

    @BeforeMethod
    public void beforeMethod() {

        sectionPage = CommonSectionPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1435(IOSWeb),QAAUT-1434(Android_MWeb) :To verify scroll on page is working")
    @Test
    public void verifySectionIndiaNewsScrollable() {
        boolean isSectionIndiaNewsScrollable = sectionPage.checkIsSectionIndiaNewsScrollable();
        Assert.assertTrue(isSectionIndiaNewsScrollable, "Section IndiaNews Scrollable failed");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma, Gulshan Tomar")
    @Description("QAAUT-1439(IOSWeb),QAAUT-1438(Android_MWeb), QAAUT-1437 (Web):To verify section name is displayed and is clickable")
    @Test
    public void verifyIsSectionIndiaNewsDisplayedClickable() {
        boolean isSectionIndiaNewsScrollable = sectionPage.checkIsSectionIndiaNewsDisplayedClickable();
        Assert.assertTrue(isSectionIndiaNewsScrollable, "Section India News Displayed & Clickable failed");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-QAAUT-1440(Android AMP):To verify section name is displayed and is clickable")
    @Test
    public void verifyIsSectionIndiaNewsDisplayedClickableOnAndroidAMP() {
        boolean isSectionIndiaNewsScrollable = sectionPage.checkIsSectionIndiaNewsDisplayedClickable();
        Assert.assertTrue(isSectionIndiaNewsScrollable, "Section India News Displayed & Clickable failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1454(Android_mweb), QAAUT-1455(IOSWeb):To verify read full story is visible and is clickable in quick reads")
    @Test
    public void verifyFullStoryIsVisibleAndClickableInCarousal() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyFullStoryIsVisibleAndClickableInCarousal");
        boolean isSectionIndiaNewsScrollable = sectionPage.checkFullStoryVisisbleAndClickableInQuickRead(params.get("quickReadURL"), params.get("readSFullStoryText"), params.get("target1"), params.get("target2"));
        Assert.assertTrue(isSectionIndiaNewsScrollable, "Read Full Story Displayed & Clickable failed");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1422(web),QAAUT-1424(IOSWeb),QAAUT-1423(Android_MWeb):To verify topic page")
    @Test
    public void verifyTopicPage() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopicPage");
        boolean isSectionIndiaNewsScrollable = sectionPage.checkTopicPage(params.get("topicURL"));
        Assert.assertTrue(isSectionIndiaNewsScrollable, "Read Full Story Displayed & Clickable failed");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1425(web),QAAUT-1427(IOSWeb),QAAUT-1426(Android_MWeb):To verify landing page of topic")
    @Test
    public void verifyTopicLandingPage() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyTopicLandingPage");
        boolean isSectionIndiaNewsScrollable = sectionPage.checkTopicLandingPage(params.get("topicURL"));
        Assert.assertTrue(isSectionIndiaNewsScrollable, "Landing page of topic failed");
    }

    @Author(name = "Shakeel Alam,Harsh Sharma")
    @Description("QAAUT-1421(IOSWeb),QAAUT-1420(Android_MWeb):To verify the L1")
    @Test
    public void verifyL1LandingPage() {
        boolean isSectionIndiaNewsScrollable = sectionPage.checkL1LandingPage();
        Assert.assertTrue(isSectionIndiaNewsScrollable, "L1 Displayed failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1515(IOSWeb):To verify breadcrumb is displayed when user lands from google etc")
    @Test
    public void verifyBreadcrumbFromGoogle() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBreadcrumbFromGoogle");
        boolean isSectionIndiaNewsScrollable = sectionPage.checkBreadcrumbDisplayedFromGoogle(params.get("url"), params.get("searchText"));
        Assert.assertTrue(isSectionIndiaNewsScrollable, "India News breadcrumb verification failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1636(Android-native):Verify that when user Launces the app then Top News Section should be displayed")
    @Test
    public void verifyAppLaunchDisplayTopSection() {
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyBreadcrumbFromGoogle");
        boolean isSectionIndiaNewsScrollable = sectionPage.checkAppLaunchDisplayTopSection();
        Assert.assertTrue(isSectionIndiaNewsScrollable, "Section is not displaying.");
    }

    @Author(name = "Shakeel Alam, Harsh Sharma")
    @Description("QAAUT-1651, QAAUT-1652(iOS),QAAUT-1641(Android-native):Verify that when user is on another section page then on the bottom nav, home is displayed as selected")
    @Test
    public void verifyBottomNavHomeSelected() {
        boolean isBottomNavHomeSelected = sectionPage.checkBottomNavHomeSelected();
        Assert.assertTrue(isBottomNavHomeSelected, "Bottom Navigation & Home Selected verification failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1650(Android-native): Verify that when user is on another section Page then Bottom Nav is displayed")
    @Test
    public void verifyBottomNavDispalyFromAnotherSectionPage() {
        boolean isBottomNavHomeSelected = sectionPage.checkBottomNavDispalyFromAnotherSectionPage();
        Assert.assertTrue(isBottomNavHomeSelected, "Bottom Navigation & Home Selected verification failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1655(Android-native): Verify that when user tap on that Section name,it redirects to that section page")
    @Test
    public void verifySectionRedirectionPage() {
        boolean isBottomNavHomeSelected = sectionPage.checkSectionRedirectionPage();
        Assert.assertTrue(isBottomNavHomeSelected, "Redirection to the section page is failed.");
    }

    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1677(iOS), QAAUT-1671(android_native) :Verify that when user taps on Business from Explore then On Business Page, Matket Statistics should be displayed")
    @Test
    public void verifyBusinessSection() {
        boolean isBusinessSection = sectionPage.checkBusinessSection();
        Assert.assertTrue(isBusinessSection, "Business Section verification failed");
    }

    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1678(iOS), QAAUT-1672(android_native):Verify the redirection when user tap on Daily Sudoku option")
    @Test
    public void verifySudokuSection() {
        boolean isBusinessSection = sectionPage.checkSudokuSection();
        Assert.assertTrue(isBusinessSection, "Sudoku Section verification failed");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1687(Android-native), QAAUT-1891(iOS): Verify the behaviour when user taps on any Section page from explore >> again tap on Explore from bottom nav")
    @Test
    public void verifyClickExplorePageAppearAgain() {
        boolean isBottomNavHomeSelected = sectionPage.checkClickExplorePageAppearAgain();
        Assert.assertTrue(isBottomNavHomeSelected, "Explore page is not display.");
    }

    @Author(name = "Harsh Sharma, Shakeel Alam")
    @Description("QAAUT-1686(Android-native), QAAUT-1893(iOS): Verify that when user tap on down arrow displayed on Explore Page for Cities")
    @Test
    public void verifyClickCityDisplayCitiesInExplore() {
        boolean isBottomNavHomeSelected = sectionPage.checkClickCityDisplayCitiesInExplore();
        Assert.assertTrue(isBottomNavHomeSelected, "List of Cities are not displaying.");
    }

    @Author(name = "Gulshan Tomar, Shakeel Alam")
    @Description("QAAUT-1685 (Android-Native), QAAUT-1895(iOS): Verify the behaviour when user tap on Cities from Explore Page")
    @Test
    public void verifyCitiesSectionNameDisplayed() {
        boolean isStepTrue = sectionPage.checkCitiesSectionNameisDispayed();
        Assert.assertTrue(isStepTrue, "Cities Section name is not displayed");
    }

    @Author(name = "Gulshan Tomar, Shakeel Alam,Ravinder Singh")
    @Description("QAAUT-1684,QAAUT-1789 (Android-Native), QAAUT-1897, QAAUT-1886(iOS: Verify that user is able to go to Noida Subsection")
    @Test
    public void verifyNoidaSubSectionNameDisplayed() {
        boolean isStepTrue = sectionPage.checkNoidaSubSectionNameisDispayed();
        Assert.assertTrue(isStepTrue, "Noida SubSection name is not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1704 (Android-Native): Verify after the header, Heading with text Popular Sections is displayed")
    @Test
    public void verifyPopularSectionsIsDisplayed() {
        boolean isStepTrue = sectionPage.checkPopularSectionsDisplayed();
        Assert.assertTrue(isStepTrue, "Popular Sections is not displayed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1702 (Android-Native): Verify that after the Heading, Sections names is displayed")
    @Test
    public void verifySectionNamesAreDisplayed() {
        boolean isStepTrue = sectionPage.checkSectionNamesDisplayed();
        Assert.assertTrue(isStepTrue, "Section Names not displayed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1639 (Android-Native): Verify that if there is any Live blog inside the Section then a red dot is displayed before the title of the story.")
    @Test
    public void verifySectionLiveBlogWithRedDotOnStory() {
        boolean isStepTrue = sectionPage.checkSectionLiveBlogWithRedDotOnStory();
        Assert.assertTrue(isStepTrue, "Red dot display failed for live blog story.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1892 (Android-Native): Verify that if there is any Premium Stories inside the Section then on the Image Premium tag is displayed.")
    @Test
    public void verifyPremiumStoryInsideSectionPage() {
        boolean isStepTrue = sectionPage.checkPremiumStoryInsideSectionPage();
        Assert.assertTrue(isStepTrue, "Premium story text not visible on any story.");
    }

    @Author(name = "Harsh Sharma, Shakeel, Ravinder Singh")
    @Description("QAAUT-1887 (Android-Native), QAAUT-1888 (iOS-Native): Verify that user can scroll from top to bottom on Top News section .")
    @Test
    public void verifyUserScrollToBottomOfTopNewsPage() {
        boolean isStepTrue = sectionPage.checkUserScrollToBottomOfTopNewsPage();
        Assert.assertTrue(isStepTrue, "Scroll to bottom page is failed!!!!!.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1885 (Android-Native): Verify that if there is any Live blog inside the Section then a text 'LIVE' should be displayed on Image.")
    @Test
    public void verifyForLiveBlogForTopNewsPage() {
        boolean isStepTrue = sectionPage.checkForLiveBlogForTopNewsPage();
        Assert.assertTrue(isStepTrue, "Live blog text not dispaly!!!!!!.");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-2041(iOS-native): Verify the redirection when user taps on the World Section from the Home Page")
    @Test
    public void verifyRedirectionFromWorld() {
        boolean isRedirectionTrue = sectionPage.checkRedirectionFromWorld();
        Assert.assertTrue(isRedirectionTrue, "Redirection to the world section page failed.");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-2043(iOS-native): Verify the redirection when user taps on the Cities option from the Home Page")
    @Test
    public void verifyRedirectionFromCities() {
        boolean isRedirectionTrue = sectionPage.checkRedirectionFromCities();
        Assert.assertTrue(isRedirectionTrue, "Redirection to the cities section page failed.");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-2026(iOS-native): Verify that when user taps on India section then that section is highlighted on top")
    @Test
    public void verifyRedirectionFromIndia() {
        boolean isRedirectionTrue = sectionPage.checkRedirectionFromIndia();
        Assert.assertTrue(isRedirectionTrue, "Redirection to the india section page failed.");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2257 (iOS-Native):Verify that Subsection name is displayed on the Cities section")
    @Test
    public void verifySubSectionNameInCitiesSection() {
        boolean isSubSectionNameInCitiesSection = sectionPage.SubSectionNameInCitiesSection();
        Assert.assertTrue(isSubSectionNameInCitiesSection, "Subsection name is not displayed on the Cities section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2262 (iOS-Native):Verify that World Section is properly displayed on the Dark Mode")
    @Test
    public void verifyWorldSectionInDarkMode() {
        boolean isWorldSectionInDarkMode = sectionPage.WorldSectionInDarkMode();
        Assert.assertTrue(isWorldSectionInDarkMode, "World Section is not properly displayed on the Dark Mode");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2273 (iOS-Native), QAAUT-2413 (Android-Native):Verify the redirection when user taps on the Opinion section from the Home Page")
    @Test
    public void verifyOpinionSectionRedirection() {
        boolean isOpinionSectionRedirection = sectionPage.opinionSectionRedirection();
        Assert.assertTrue(isOpinionSectionRedirection, "Redirection failed when user taps on the Opinion section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2288 (iOS-Native), QAAUT-2414 (Android-Native) : Verify that user can scroll top to bottom on the Opinion section")
    @Test
    public void verifyScrollOnOpinion() {
        boolean isScrollingOnOpinion = sectionPage.checkScrollingOnOpinion();
        Assert.assertTrue(isScrollingOnOpinion, "scroll top to bottom on the Opinion section failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2291 (iOS-Native), QAAUT-2415 (Android-Native) : Verify the redirection when user taps on any story displayed inside the Opinion section")
    @Test
    public void verifyRedirectToStoryFromOpinion() {
        boolean isRedirectToStoryFromOpinion = sectionPage.redirectToStoryFromOpinion();
        Assert.assertTrue(isRedirectToStoryFromOpinion, "Story display failed inside the Opinion section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2292, QAAUT-2915 (iOS-Native), QAAUT-2416, QAAUT-2916 (Android_Native) : Verify that Ad is displayed properly on every section after the five Stories")
    @Test
    public void verifyAdAfterFiveStories() {
        boolean isAdAfterFiveStories = sectionPage.checkAdAfterFiveStories();
        Assert.assertTrue(isAdAfterFiveStories, "Ad is not displayed properly after the five Stories in Opinion");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2295 (iOS-Native), QAAUT-2417 (Android_Native): Verify the redirection when user taps on the Cricket section from the Home Page")
    @Test
    public void verifyRedirectToCricketSection() {
        boolean isRedirectToCricketSection = sectionPage.redirectToCricketSection();
        Assert.assertTrue(isRedirectToCricketSection, "Redirection failed when user taps on the Cricket section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2296 (iOS-Native), QAAUT-2418 (Android_Native) : Verify the redirection when user tap on the entertainment section from the Home Page")
    @Test
    public void verifyRedirectToEntertainmentSection() {
        boolean isRedirectToEntertainmentSection = sectionPage.redirectToEntertainmentSection();
        Assert.assertTrue(isRedirectToEntertainmentSection, "Redirection failed when user taps on the entertainment section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2297 (iOS-Native), QAAUT-2419 (Android-Native) : Verify the redirection when user taps on any story displayed inside the Entertainment section")
    @Test
    public void verifyRedirectToStoryFromEntertainment() {
        boolean isRedirectToStoryFromEntertainment = sectionPage.redirectToStoryFromEntertainment();
        Assert.assertTrue(isRedirectToStoryFromEntertainment, "Redirection failed when user taps on any Story inside the entertainment section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2298 (iOS-Native), QAAUT-2420 (Android-Native) : Verify that on the entertainment section, sub section is displayed")
    @Test
    public void verifySubSectionInEntertainment() {
        boolean isSubSectionInEntertainment = sectionPage.subSectionInEntertainment();
        Assert.assertTrue(isSubSectionInEntertainment, "Redirection failed when user taps on any Story inside the entertainment section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2300 (iOS-Native), QAAUT-2421 (Android-Native) : Verify the redirection when user taps on the any subsection displayed inside the entertainment section page")
    @Test
    public void verifyRedirectToSubSectionInEntertainment() {
        boolean isRedirectToSubSectionInEntertainment = sectionPage.redirectToSubSectionInEntertainment();
        Assert.assertTrue(isRedirectToSubSectionInEntertainment, "Redirection failed when user taps on the any subsection displayed inside the entertainment section page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2301 (iOS-Native), QAAUT-2422 (Android-Native) : Verify the redirection when user taps on the Trending Section from the Home Page")
    @Test
    public void verifyRedirectToTrendingSection() {
        boolean isRedirectToTrendingSection = sectionPage.redirectToToTrendingSection();
        Assert.assertTrue(isRedirectToTrendingSection, "Redirection failed when user taps on the Trending Section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2302 (iOS-Native), QAAUT-2423 (Android-Native) : Verify the redirection when user taps on any story displayed inside the Trending section")
    @Test
    public void verifyRedirectToStoryFromTrendingSection() {
        boolean isRedirectToStoryFromTrendingSection = sectionPage.redirectToStoryFromTrendingSection();
        Assert.assertTrue(isRedirectToStoryFromTrendingSection, "Redirection failed when user taps on any story displayed inside the Trending section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2303 (iOS-Native), QAAUT-2426 (Android-Native) : Verify the redirection when user taps on the Video section from the Home Page")
    @Test
    public void verifyRedirectOnVideoSection() {
        boolean isRedirectOnVideoSection = sectionPage.redirectOnVideoSection();
        Assert.assertTrue(isRedirectOnVideoSection, "Redirection failed when user taps on the Video section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2304 (iOS-Native), QAAUT-2427 (Android-Native) : Verify that Subsection name is displayed on the Videos section page")
    @Test
    public void verifySubSectionNamesInVideoPage() {
        boolean isSubSectionNamesInVideoPage = sectionPage.subSectionNamesInVideoPage();
        Assert.assertTrue(isSubSectionNamesInVideoPage, "Subsection names are failed to display on the Videos section page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2305 (iOS-Native), QAAUT-2429 (Android-Native) : Verify that appearance of the Videos section page should match with the Design")
    @Test
    public void verifyAppearanceOfVideoSectionPage() {
        boolean isAppearanceOfVideoSectionPage = sectionPage.appearanceOfVideoSectionPage();
        Assert.assertTrue(isAppearanceOfVideoSectionPage, "appearance of the Videos section page failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2306 (iOS-Native), QAAUT-2430 (Android-Native) : Verify the redirection when user taps on any story inside the videos section page")
    @Test
    public void verifyRedirectToStoryFromVideoSectionPage() {
        boolean isRedirectToStoryFromVideoSectionPage = sectionPage.redirectToStoryFromVideoSectionPage();
        Assert.assertTrue(isRedirectToStoryFromVideoSectionPage, "redirection failed when user taps on any story inside the videos section page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2307 (iOS-Native), QAAUT-2431 (Android-Native) : Verify that when user taps on the Subsection inside the videos section page, then matching stories should be displayed on that section page")
    @Test
    public void verifyRedirectToSubsectionOfVideoSection() {
        boolean isRedirectToSubsectionOfVideoSection = sectionPage.redirectToSubsectionOfVideoSection();
        Assert.assertTrue(isRedirectToSubsectionOfVideoSection, "Subsection inside the videos section page failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2308 (iOS-Native), QAAUT-2432 (Android-Native) : Verify the redirection on tapping Lifestyle section from the Home Page")
    @Test
    public void verifyRedirectOnLifeStyleSection() {
        boolean isRedirectOnLifeStyleSection = sectionPage.redirectOnLifeStyleSection();
        Assert.assertTrue(isRedirectOnLifeStyleSection, "Redirection failed when user taps on the Lifestyle section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2309 (iOS-Native), QAAUT-2433 (Android-Native) : Verify the redirection when user taps on any subsection displayed inside the Lifestyle section page")
    @Test
    public void verifyRedirectToSubSectionOfLifeStyle() {
        boolean isRedirectToSubSectionOfLifeStyle = sectionPage.redirectToSubSectionOfLifeStyle();
        Assert.assertTrue(isRedirectToSubSectionOfLifeStyle, "Redirection failed when user taps on any subsection displayed inside the Lifestyle section page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2310 (iOS-Native), QAAUT-2434 (Android-Native) : Verify the redirection when user taps on any story displayed inside the Lifestyle section")
    @Test
    public void verifyStoryInLifeStyleSection() {
        boolean isStoryInLifeStyleSection = sectionPage.storyInLifeStyleSection();
        Assert.assertTrue(isStoryInLifeStyleSection, "Redirection failed when user taps on any story displayed inside the Lifestyle section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2311 (iOS-Native), QAAUT-2435 (Android-Native) : Verify the redirection on tapping Education section from the Home Page")
    @Test
    public void verifyRedirectToEducationSection() {
        boolean isRedirectToEducationSection = sectionPage.redirectToEducationSection();
        Assert.assertTrue(isRedirectToEducationSection, "Redirection failed on Education section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2312 (iOS-Native), QAAUT-2436 (Android-Native) : Verify that Sub section is displayed on the Education section page")
    @Test
    public void verifySubSectionOnEducationSection() {
        boolean isSubSectionOnEducationSection = sectionPage.subSectionOnEducationSection();
        Assert.assertTrue(isSubSectionOnEducationSection, "Subsection are not displayed on the Education section page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2313 (iOS-Native), QAAUT-2437 (Android-Native) : Verify the redirection on tapping Sports section from the Home Page")
    @Test
    public void verifyRedirectionOnSportSection() {
        boolean isRedirectionOnSportSection = sectionPage.redirectionOnSportSection();
        Assert.assertTrue(isRedirectionOnSportSection, "redirection failed on tapping Sports section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2314 (iOS-Native), QAAUT-2438 (Android-Native) : Verify the redirection when user taps on any subsection displayed inside the Sports section page")
    @Test
    public void verifyRedirectToSubSectionFromSportSection() {
        boolean isRedirectToSubSectionFromSportSection = sectionPage.redirectToSubSectionFromSportSection();
        Assert.assertTrue(isRedirectToSubSectionFromSportSection, "subsection displayed failed inside the Sports section page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2315 (iOS-Native), QAAUT-2439 (Android-Native) : Verify the redirection when user taps on any story displayed inside the Sports section")
    @Test
    public void verifyRedirectToStoryFromSportSection() {
        boolean isRedirectToStoryFromSportSection = sectionPage.redirectToStoryFromSportSection();
        Assert.assertTrue(isRedirectToStoryFromSportSection, "story displayed failed inside the Sports section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2319 (iOS-Native), QAAUT-2439 (Android-Native) : Verify the redirection on tapping Photos section from the Home Page")
    @Test
    public void verifyRedirectToPhotosSection() {
        boolean isRedirectToSPhotosSection = sectionPage.redirectToPhotosSection();
        Assert.assertTrue(isRedirectToSPhotosSection, "Redirection failed on tapping Photos section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2317 (iOS-Native), QAAUT-2811 (Android-Native) : Verify that user is able to share the story from the Sports section")
    @Test
    public void verifyShareStoryFromSportsSection() {
        boolean isShareStoryFromSportsSection = sectionPage.shareStoryFromSportsSection();
        Assert.assertTrue(isShareStoryFromSportsSection, "Failed redirect to Photos Section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2320 (iOS-Native), QAAUT-2815 (Android-Native) : Verify the appearance of Photos section page")
    @Test
    public void verifyAppearanceOfPhotosSection() {
        boolean isAppearanceOfPhotosSection = sectionPage.appearanceOfPhotosSection();
        Assert.assertTrue(isAppearanceOfPhotosSection, "appearance of Photos section page Failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2321 (iOS-Native), QAAUT-2816 (Android-Native) : Verify that on the Dark Mode, Photos section page is displayed properly")
    @Test
    public void verifyPhotoSectionInDarkMode() {
        boolean isPhotoSectionInDarkMode = sectionPage.photoSectionInDarkMode();
        Assert.assertTrue(isPhotoSectionInDarkMode, "Photos section page is displayed Failed in Dark Mode");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2322 (iOS-Native), QAAUT-2817 (Android-Native) : Verify the redirection on tapping any photo story")
    @Test
    public void verifyRedirectToPhotoSectionStory() {
        boolean isRedirectToPhotoSectionStory = sectionPage.redirectToPhotoSectionStory();
        Assert.assertTrue(isRedirectToPhotoSectionStory, "Redirection failed on tapping any photo story");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2323 (iOS-Native), QAAUT-2818 (Android-Native) : Verify the redirection when user taps on any story displayed inside the Photos section")
    @Test
    public void verifyRedirectToStoryFromPhotosSection() {
        boolean isRedirectToStoryFromPhotosSection = sectionPage.redirectToStoryFromPhotosSection();
        Assert.assertTrue(isRedirectToStoryFromPhotosSection, "Redirection failed when user taps on any story displayed inside the Photos section");
    }

    @Author(name = "Rohitashva Budhauliya, Harsh Sharma")
    @Description("QAAUT-2325 (iOS-Native),QAAUT-2820(Android_Native) : Verify that user is able to share the story from the Photos section")
    @Test
    public void verifyShareStoryFromPhotoSection() {
        boolean isShareStoryFromPhotoSection = sectionPage.shareStoryFromPhotoSection();
        Assert.assertTrue(isShareStoryFromPhotoSection, "Share the story from the Photos section Failed");
    }

    @Author(name = "Rohitashva Budhauliya,Harsh Sharma")
    @Description("QAAUT-2339 (iOS-Native),QAAUT-2822(Android_Native) : Verify the redirection when user taps on the Business section from the Home Page")
    @Test
    public void verifyRedirectToBusinessSection() {
        boolean isRedirectToBusinessSection = sectionPage.redirectToBusinessSection();
        Assert.assertTrue(isRedirectToBusinessSection, "Redirection failed on tapping Business section from the Home Page");
    }

    @Author(name = "Rohitashva Budhauliya,Harsh Sharma")
    @Description("QAAUT-2340 (iOS-Native),QAAUT-2823(Android_Native) : Verify that after the first story, Market Statistics widget is displayed")
    @Test
    public void verifyMarketStatWidgetAfterFirstStory() {
        boolean isMarketStatWidgetAfterFirstStory = sectionPage.marketStatWidgetAfterFirstStory();
        Assert.assertTrue(isMarketStatWidgetAfterFirstStory, "Market Statistics widget is failed to displayed");
    }

    @Author(name = "Rohitashva Budhauliya, Harsh Sharma")
    @Description("QAAUT-2341 (iOS-Native),QAAUT-2824(Android_Native) : Verify that Market Statistics widget has four options like BSE SENSEX, NIFTY 50, NIFTY BANK, GOLD")
    @Test
    public void verifyMarketStatWidgetFourOptions() {
        boolean isMarketStatWidgetFourOptions = sectionPage.marketStatWidgetFourOptions();
        Assert.assertTrue(isMarketStatWidgetFourOptions, "Market Statistics widget four options are failed to displayed");
    }

    @Author(name = "Rohitashva Budhauliya, Harsh Sharma")
    @Description("QAAUT-2342 (iOS-Native), QAAUT-2825 (Android_Native) : Verify that all four option has some values")
    @Test
    public void verifyValuesInMarketStatWidget() {
        boolean ischeckValuesInMarketStatWidget = sectionPage.checkValuesInMarketStatWidget();
        Assert.assertTrue(ischeckValuesInMarketStatWidget, "All four option has some values - Failed");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2834 (Android_Native), QAAUT-2351 (iOS-Native) : Verify the redirection when user taps on the Mumbai News section from the Home Page")
    @Test
    public void verifyRedirectToMumbaiNewsSection() {
        boolean ischeckValuesInMarketStatWidget = sectionPage.redirectToMumbaiNewsSection();
        Assert.assertTrue(ischeckValuesInMarketStatWidget, "Redirection on Mumbai News Page is failed!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya, Harsh Sharma")
    @Description("QAAUT-2345 (iOS-Native), QAAUT-2828(Android_Native) : Verify that after the Market Statistics widget, story is displayed")
    @Test
    public void verifyStoryDisplayedAfterMarketStatWidget() {
        boolean isStoryDisplayedAfterMarketStatWidget = sectionPage.storyDisplayedAfterMarketStatWidget();
        Assert.assertTrue(isStoryDisplayedAfterMarketStatWidget, "After the Market Statistics widget, story are failed to displayed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2346 (iOS-Native), QAAUT-2829(Android-Native) : Verify the redirection on tapping any Business story")
    @Test
    public void verifyRedirectToBusinessStory() {
        boolean isCheckRedirectToBusinessStory = sectionPage.checkRedirectToBusinessStory();
        Assert.assertTrue(isCheckRedirectToBusinessStory, "Redirection on tapping any Business story failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2347 (iOS-Native), QAAUT-2830(Android-Native) : Verify the redirection when user taps on the Delhi News section from the Home Page")
    @Test
    public void verifyRedirectToDelhiNewsSection(){
        boolean isCheckRedirectToDelhiNewsSection= sectionPage.checkRedirectToDelhiNewsSection();
        Assert.assertTrue(isCheckRedirectToDelhiNewsSection, "Redirection failed on Delhi News section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2348 (iOS-Native), QAAUT-2831(Android-Native) : Verify the redirection when user taps on any story displayed inside the Delhi News section")
    @Test
    public void verifyRedirectToStoryFromDelhiNewsSection(){
        boolean isCheckRedirectToStoryFromDelhiNewsSection= sectionPage.checkRedirectToStoryFromDelhiNewsSection();
        Assert.assertTrue(isCheckRedirectToStoryFromDelhiNewsSection, "Redirection failed to story on Delhi News section");
    }

    @Author(name = "Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-2835(Android_Native), QAAUT-2353 (iOS-Native) : Verify the redirection when user taps on any story displayed inside the Mumbai News section")
    @Test
    public void verifyRedirectToStoryOfMumbaiNewsSection() {
        boolean isStoryDisplayedAfterMarketStatWidget = sectionPage.redirectToStoryOfMumbaiNewsSection();
        Assert.assertTrue(isStoryDisplayedAfterMarketStatWidget, "Story redirection for Mumbai News Section is failed!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2349 (iOS-Native), QAAUT-2832(Android-Native) : Verify the redirection when user taps on the TV News section from the Home Page")
    @Test
    public void verifyRedirectToTvNewsSection(){
        boolean isCheckRedirectToTvNewsSection= sectionPage.checkRedirectToTvNewsSection();
        Assert.assertTrue(isCheckRedirectToTvNewsSection, "Redirection failed on TV News section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2350 (iOS-Native), QAAUT-2833(Android-Native) : Verify the redirection when user taps on any story displayed inside the TV News section")
    @Test
    public void verifyRedirectToStoryFromTvNewsSection(){
        boolean isCheckRedirectToStoryFromTTvNewsSection= sectionPage.checkRedirectToStoryFromTTvNewsSection();
        Assert.assertTrue(isCheckRedirectToStoryFromTTvNewsSection, "Redirection Failed when user taps on story displayed inside the TV News section");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2920 (iOS-Native), QAAUT- 2921(Android-Native): Verify that Photos Listing Page should display when user tap on the Photos option displayed on the Explore Section")
    @Test
    public void verifyCameraIconWithNumberOfPhotosInPhotosSection() {
        boolean isStepTrue = sectionPage.checkCameraIconWithNumberOfPhotosInPhotosSection();
        Assert.assertTrue(isStepTrue, "Camera icon with number of photos displayed - Failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-2918 (iOS-Native), QAAUT- 2919(Android-Native): Verify that Photos Listing page should display when user tap on Photos option from top section")
    @Test
    public void verifyCountInleadStoryInPhotosSection() {
        boolean isStepTrue = sectionPage.countInleadStoryInPhotosSection();
        Assert.assertTrue(isStepTrue, "Photos Listing page should display when user tap on Photos option from top section - Failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3284 (iOS-Native), QAAUT-3285 (Android-Native): Verify that Web Stories page should display when user tap Web Stories from top section")
    @Test
    public void verifyWebStoriesSectionFromTopSection() {
        boolean isStepTrue = sectionPage.checkWebStoriesSectionFromTopSection();
        Assert.assertTrue(isStepTrue, "Web Stories page display - Failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3295 (iOS-Native), QAAUT-3296 (Android-Native): Verify that Web Stories Listing Page should be displayed when user tap on the Web Stories option from the Explore Section")
    @Test
    public void verifyWebStoriesSectionFromExplore() {
        boolean isStepTrue = sectionPage.checkWebStoriesSectionFromExplore();
        Assert.assertTrue(isStepTrue, "Web Stories page display - Failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3300 (iOS-Native), QAAUT-3301 (Android-Native): Verify that story images horizontal lines should display on each web story above description")
    @Test
    public void verifyImagesHorizontalLinesInWebStories() {
        boolean isStepTrue = sectionPage.checkImagesHorizontalLinesInWebStories();
        Assert.assertTrue(isStepTrue, "story images horizontal lines display in Web Stories - Failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3305 (iOS-Native), QAAUT-3306 (Android-Native): Verify that App logo should display on each web story at below left")
    @Test
    public void verifyAppLogoInWebStories() {
        boolean isStepTrue = sectionPage.checkAppLogoInWebStories();
        Assert.assertTrue(isStepTrue, "App logo display in Web Stories - Failed!!!!!!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3346 (iOS-Native), QAAUT-3347 (Android-Native): Verify that 3 dot option should display at bottom right on each web story")
    @Test
    public void verifyThreeDotsDislpayedInWebStories() {
        boolean isStepTrue = sectionPage.checkThreeDotsDislpayedInWebStories();
        Assert.assertTrue(isStepTrue, "3 dot option display in Web Stories - Failed!!!!!!!!!!!!");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4007 (Android-Native), QAAUT-4359(iOS-Native): Verify the redirection when user taps on For You Section displayed in L1")
    @Test
    public  void verifyRedirectionOnForYouSection() {
        boolean isStepTrue = sectionPage.checkRedirectionOnForYouSection();
        Assert.assertTrue(isStepTrue,"Redirection on For failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-1779 (Android-Native):Verify that in Dark mode Edit Profile page section should be clearly visible")
    @Test
    public void verifyEditProfilePageInDarkMode() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyEditProfilePageInDarkMode");
        isStepTrue = loginPage.loginWithPassword(params.get("email"), params.get("password"), params.get("expectedUserName"));
        Assert.assertTrue(isStepTrue, "Login with Email and Password Failed");

        isStepTrue = sectionPage.checkEditProfilePageInDarkMode();
        Assert.assertTrue(isStepTrue, "Edit Profile page section clearly displayed on the Dark Mode");

        isStepTrue = loginPage.logout();
        Assert.assertTrue(isStepTrue, "Log out failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4610(Android-Native),QAAUT-4611(iOS-Native): Verify the text on the City Pop Up")
    @Test
    public void verifyTextOnCityPopUp() {
    boolean isStepTrue = sectionPage.checkTextOnCityPopUp();
    Assert.assertTrue(isStepTrue,"Text on city pop up display failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4612(Android-Native),QAAUT-4613(iOS-Native): Verify the redirection when user taps on Cities from L1")
    @Test
    public void verifyRedirectionOnCitiesSection() {
        boolean isStepTrue = sectionPage.checkRedirectionOnCitiesSection();
        Assert.assertTrue(isStepTrue,"Redirection to cities section failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4668(Android-Native),QAAUT-4669(iOS-Native): Verify the redirection when user taps on Got it button")
    @Test
    public void verifyRedirectionWhenTapOnGotItButton() {
        boolean isStepTrue = sectionPage.checkRedirectionWhenTapOnGotItButton();
        Assert.assertTrue(isStepTrue,"Redirection to Got It Button failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4670(Android-Native),QAAUT-4671(iOS-Native): Verify that City pop up should not goes away when user taps on anywhere except Got it button")
    @Test
    public void verifyNoRedirectionWhenTapOnWhenAnyWhereExceptGotItButton() {
        boolean isStepTrue = sectionPage.checkNoRedirectionWhenTapOnWhenAnyWhereExceptGotItButton();
        Assert.assertTrue(isStepTrue,"No redirection failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4672(Android-Native),QAAUT-4673(iOS-Native): Verify that before city name \"+\" is displayed")
    @Test
    public void verifyPlusSignDisplayBeforeCityName() {
        boolean isStepTrue = sectionPage.checkPlusSignDisplayBeforeCityName();
        Assert.assertTrue(isStepTrue,"\"+\" sign before city name display failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4860(Android-Native),QAAUT-4861(iOS-Native): Verify that horizontal line is displayed at the end of the city name")
    @Test
    public void verifyHorizontalLinesAtEndOfCityName() {
        boolean isStepTrue = sectionPage.checkHorizontalLinesAtEndOfCityName();
        Assert.assertTrue(isStepTrue,"Horizontal lines displaying failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4862(Android-Native),QAAUT-4863(iOS-Native): Verify that at the end of screen two options Maybe Later and Save Changes buttons are displayed")
    @Test
    public void verifyMayBeLaterAndSaveChangesButton() {
        boolean isStepTrue = sectionPage.checkMayBeLaterAndSaveChangesButton();
        Assert.assertTrue(isStepTrue, "May be later and save changes Button displaying failed");
    }
    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4864(Android-Native),QAAUT-4865(iOS-Native): Verify the City others are displayed at the end of the cities")
    @Test
    public void verifyOthersOptionInCities() {
        boolean isStepTrue = sectionPage.checkOthersOptionInCities();
        Assert.assertTrue(isStepTrue,"Others option Displaying failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4866(Android-Native),QAAUT-4867(iOS-Native): Verify the behaviour when user taps on \"+\" button on any city")
    @Test
    public void verifyBehaviourWhenUserTapsOnPlusButtonBeforeCityName() {
        boolean isStepTrue = sectionPage.checkBehaviourWhenUserTapsOnPlusButtonBeforeCityName();
        Assert.assertTrue(isStepTrue,"Save changes enabling failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4948(Android-Native),QAAUT-4949(iOS-Native): Verify the behaviour when user taps on Maybe Later option when no city is selected")
    @Test
    public void verifyBehaviourWhenUserTapsOnMayBeLaterButton() {
        boolean isStepTrue = sectionPage.checkBehaviourWhenUserTapsOnMayBeLaterButton();
        Assert.assertTrue(isStepTrue,"Add cities displaying failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4950(Android-Native),QAAUT-4951(iOS-Native): Verify the behaviour when user taps on Save Changes option when no city is selected")
    @Test
    public void verifyBehaviourNoCitySelectedAndTapsOnSaveChangesButton() {
        boolean isStepTrue = sectionPage.checkBehaviourNoCitySelectedAndTapsOnSaveChangesButton();
        Assert.assertTrue(isStepTrue,"Save changes disabling failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4969(Android-Native),QAAUT-4970(iOS-Native): Verify that after selecting the city, a pop up with text \"City Selected Successfully\" is shown at the bottom of the page with OKAY button")
    @Test
    public void verifyPopUpWhenSelectAnyCity() {
        boolean isStepTrue = sectionPage.checkPopUpWhenSelectAnyCity();
        Assert.assertTrue(isStepTrue,"Pop up message enabling failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4992(Android-Native),QAAUT-4993(iOS-Native): Verify the behaviour when user taps on Save Changes option when some cities are selected")
    @Test
    public void verifySelectedCityShownUnderCitiesSection() {
        boolean isStepTrue = sectionPage.checkSelectedCityShownUnderCitiesSection();
        Assert.assertTrue(isStepTrue,"Selected city displaying failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-4995(iOS-Native): Verify the behaviour when user taps on Maybe Later option when some cities are selected")
    @Test
    public void verifyBehaviourWhenUserSelectAnyCityAndTapsOnMayBeLaterButton() {
        boolean isStepTrue = sectionPage.checkBehaviourWhenUserSelectAnyCityAndTapsOnMayBeLaterButton();
        Assert.assertTrue(isStepTrue,"Save changes displaying failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5640(Android-Native),QAAUT-5641(iOS-Native): Verify that after the City name Date is displayed")
    @Test
    public void verifyDateInCitiesAfterSelectedCity() {
        boolean isStepTrue = sectionPage.checkDateInCitiesAfterSelectedCity();
        Assert.assertTrue(isStepTrue, "Date Displaying failed");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5656(Android-Native),QAAUT-5657(iOS-Native): Verify that Temperture is displayed")
    @Test
    public void verifyTemperatureDisplayedInCitiesSection() {
        boolean isStepTrue = sectionPage.checkTemperatureDisplayedInCitiesSection();
        Assert.assertTrue(isStepTrue, "Temperature is not displaying");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5679(Android-Native),QAAUT-5680(iOS-Native): Verify that on the City Listing Page after the top ad Selected city name with News is displayed")
    @Test
    public void verifyCityNameDisplayedAfterAdWithNews() {
        boolean isStepTrue = sectionPage.checkCityNameDisplayedAfterAdWithNews();
        Assert.assertTrue(isStepTrue, "City name not displaying with news");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5682(Android-Native),QAAUT-5683(iOS-Native): Verify the redirection when user taps on some other city from the L2")
    @Test
    public void verifyRedirectionWhenTapOnOtherSelectedCities() {
        boolean isStepTrue = sectionPage.checkRedirectionWhenTapOnOtherSelectedCities();
        Assert.assertTrue(isStepTrue,"Other selected cities news not displaying");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5689(Android-Native),QAAUT-5690(iOS-Native): Verify that when user select multiple cities then after tapping on Save changes button, top city is selected by default")
    @Test
    public void verifyRedirectionWhenTapOnMultipleCities() {
        boolean isStepTrue = sectionPage.checkRedirectionWhenTapOnMultipleCities();
        Assert.assertTrue(isStepTrue,"Top city related news not displaying");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5829(Android-Native),QAAUT-5830(iOS-Native): Verify that when the user deselects the city then that city is not displayed in L2")
    @Test
    public void verifyBehaviourWhenUserDeselectAnySelectedCity() {
        boolean isStepTrue = sectionPage.checkBehaviourWhenUserDeselectAnySelectedCity();
        Assert.assertTrue(isStepTrue,"Deselection of selected city failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify first story should be in card view")
    @Test
    public void verifyFirstStoryInCardView() {
        boolean isStepTrue = sectionPage.checkFirstStoryInCardView();
        Assert.assertTrue(isStepTrue,"first story in card view failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify Fourth story must be partnered story")
    @Test
    public void verifyFourthStoryPartneredStory() {
        boolean isStepTrue = sectionPage.checkFourthStoryPartneredStory();
        Assert.assertTrue(isStepTrue,"fourth story Partnered story failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify ads after every three stories excluding partnered story")
    @Test
    public void verifyAdsAfterEveryThreeStory() {
        boolean isStepTrue = sectionPage.checkAdsAfterEveryThreeStory();
        Assert.assertTrue(isStepTrue,"ads after every three story failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Page must have 30 story including partnered")
    @Test
    public void verifyThirtyStoryOnSectionPage() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyThirtyStoryOnSectionPage");
        boolean isStepTrue = sectionPage.checkThirtyStoryOnSectionPage(param.get("worldNewsUrl"));
        Assert.assertTrue(isStepTrue,"30 story on section page failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify pagination")
    @Test
    public void verifyPagination() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyPagination");
        boolean isStepTrue = sectionPage.checkPagination(param.get("secondPageUrl"),param.get("worldNewsUrl"));
        Assert.assertTrue(isStepTrue,"pagination failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify LHS and RHS data")
    @Test
    public void verifyCollectionStoriesLHSRHS() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyCollectionStoriesLHSRHS");
        boolean isStepTrue = sectionPage.checkLHSAndRHSData(param.get("indiaNewsUrl"));
        Assert.assertTrue(isStepTrue,"collection LHS and RHS data failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify match card")
    @Test
    public void verifyMatchCard() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyMatchCard");
        boolean isStepTrue = sectionPage.checkMatchCard(param.get("cricketUrl"));
        Assert.assertTrue(isStepTrue,"match card failed");
    }

    @Author(name = "Giridhar Raj")
    @Description("web: Verify on click redirection of View full scorecard")
    @Test
    public void verifyViewFullScorecard() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifyViewFullScorecard");
        boolean isStepTrue = sectionPage.checkViewFullScorecard(param.get("cricketUrl"),param.get("liveScorecard"));
        Assert.assertTrue(isStepTrue,"view full scorecard failed");
    }




}