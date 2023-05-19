package HindustanTimes;

import com.annotation.Author;
import com.annotation.Description;
import com.base.BaseTest;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.pages.HindustanTimes.generic.CommonStoryPage;
import com.utils.Constants;
import com.utils.GlobalVars;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class StoryTest extends BaseTest {
    private static CommonStoryPage storyPage;
    GlobalVars globalVars = GlobalVars.getInstance();
    private static CommonLoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        storyPage = CommonStoryPage.getInstance();
        loginPage = CommonLoginPage.getInstance();
    }

    @Author(name = "Ravi")
    @Description("QAAUT -518(web),QAAUT-588(android),QAAUT - 627(AndroidAMP),541(mweb),608(iOS),565(iOSmweb),649(iOSamp), 608(iOS-Native): Photo Gallery: Verify content, pagination, popular and Embeds")
    @Test
    public void verifyPhotoContentBookMarkShare() {
        boolean isStepTrue;
        if(globalVars.getPlatformName().equalsIgnoreCase(Constants.ANDROID_AMP)){
            Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPhotoContentBookMarkShare");
            isStepTrue = storyPage.photoHeadLineSummaryBookMarkAndShare(params.get("param1"), params.get("param2"));
            Assert.assertTrue(isStepTrue, "Photo Content Bookmark failed ");
        }
        else {
            Map<String, String> para = globalVars.getParamsDataSinglePropertySingleProperty("verifyLoginWithEmailAndPassword");
            loginPage.loginWithPassword(para.get("email"), para.get("password"), para.get("expectedUserName"));
            Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyPhotoContentBookMarkShare");
            isStepTrue = storyPage.photoHeadLineSummaryBookMarkAndShare(params.get("param1"), params.get("param2"));
            Assert.assertTrue(isStepTrue, "Photo Content Bookmark failed ");
            isStepTrue = loginPage.logout();
            Assert.assertTrue(isStepTrue, "Logout with Email and Password Failed!!");
        }
    }


    @Author(name = "Mahantesh")
    @Description("QAAUT-515(web),QAAUT-624(amp),QAAUT-538(mWeb),605(iOS), QAAUT -562(IOSmweb), QAAUT-646(ios-amp): Liveblog: Verify content, pagination, popular and Embeds")
    @Test
    public void verifyLiveBlogContentPaginationPopularEmbeds() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLiveBlogContentPaginationPopularEmbeds");
        isStepTrue = storyPage.liveBlogContentValidation(params.get("uri"), params.get("address"), params.get("url"));
        Assert.assertTrue(isStepTrue, "liveBlogContent Validation has been Failed");
    }


    @Author(name = "Mahantesh")
    @Description("QAAUT-517(web),QAAUT-587(android), QAAUT-540(mWeb),QAAUT-626(amp),607(iOS),564(ios-mWeb),648(ios-amp) : Video Story: Verify content, pagination, popular and Embeds")
    @Test
    public void verifyVideoStoryContent() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyVideoStoryContent");
        isStepTrue = storyPage.videoStoryContentValidation(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "video Story Content Validation Test Case has been Failed");
    }

    @Author(name = "Mahantesh")
    @Description("QAAUT-512(web): To verify stories dislayed are in order of last published")
    @Test(enabled = false)
    public void verifyStoriesDisplayedInOrderLastPublished() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStoriesDisplayedInOrderLastPublished");
        isStepTrue = storyPage.checkLastPublishedDate(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, " check last published Test Case has been Failed");
    }

    @Author(name = "Sambath Kumar")
    @Description("QAAUT-582(android_native),QAAUT-535(mWeb),QAAUT-621(amp),QAAUT-559(ios-mWeb),643(ios-amp) : To verify stories displayed are in order of last published")
    @Test
    public void verifyStoriesAreDisplayed() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStoriesAreDisplayed");
        isStepTrue = storyPage.checkStoriesDisplayedLastPublished(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "Stories displayed are in order of last published has been Failed");
    }

    @Author(name = "Sambath Kumar")
    @Description("QAAUT-586(android native),QAAUT-539(mWeb),QAAUT-625(amp), 516(Web), 606(iOS), 563(ios-mweb),647(ios-amp): Standard Story: Verify content, pagination, popular and Embeds")
    @Test
    public void verifyStandardStoryContentPagination() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyStandardStoryContentPagination");
        isStepTrue = storyPage.checkStandardStoriesAreDisplayed(params.get("uri"), params.get("address"));
        Assert.assertTrue(isStepTrue, "Standard story content, pagination,popular and Embeds Displaying has been Failed");
    }

    @Author(name = "Sambath Kumar")
    @Description("QAAUT-922(android native): Sign in Wall|| Verify the Sign In Wall on the Story details page")
    @Test
    public void verifySignInWallOnStoryPage() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySignInWallOnStoryPage");
        isStepTrue = storyPage.checkSignInWallOnStoryPage(params.get("readText"), params.get("premium"), params.get("saveArticles"), params.get("signIn"), params.get("signUp"), params.get("skip"));
        Assert.assertTrue(isStepTrue, "Sign in Wall on the Story details page has not been displayed");
    }

    @Author(name = "Sambath Kumar")
    @Description("QAAUT-585(android native): Liveblog: Verify content, images and Embeds")
    @Test
    public void verifyLiveBlogImageContentEmbeds() {
        boolean isStepTrue;
        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifyLiveBlogImageContentEmbeds");
        isStepTrue = storyPage.checkContentImagesAndEmbeds(params.values().toArray(new String[10]));
        Assert.assertTrue(isStepTrue, "Liveblog Content Images And Embeds has not been displayed");
    }

    @Author(name = "Shakeel Alam, Ravinder Singh, Harsh Sharma, Gulshan Tomar, Rohitashva Budhauliya")
    @Description("QAAUT-1467(IOSMweb),QAAUT-1468(Android AMP), QAAUT-1466(Android_MWeb), QAAUT-1465(Web), QAAUT-2217 (ios-Native): To verify lead images are displayed and are clickable")
    @Test
    public void verifyLeadImage() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkLeadImage();
        Assert.assertTrue(isStepTrue, "Lead Image has not been displayed");
    }


    @Author(name = "Shakeel Alam,Ravinder Singh, Gulshan Tomar")
    @Description("QAAUT-1463(IOSMweb), QAAUT-1464(Android AMP),QAAUT-1462(Android_MWeb),QAAUT-1461(Web) : To verify headline is clickable and redirecting to story detail page")
    @Test
    public void verifyHeadlineIsClickable() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkHeadline();
        Assert.assertTrue(isStepTrue, "Headline has not been displayed");
    }

    @Author(name = "Shakeel Alam, Ravinder Singh, Harsh Sharma")
    @Description("QAAUT-1469 (Web), QAAUT-1471(IOSMweb),QAAUT-1472(Android AMP),QAAUT-1470(Android_MWeb): To verify on story is in expanded form and rest are in collapsed form")
    @Test
    public void verifyStoryIsExpanded() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryIsExpanded();
        Assert.assertTrue(isStepTrue, "Expanded Story has not been displayed");
    }

    @Author(name = "Shakeel Alam,Ravinder Singh,Harsh Sharma, Gulshan Tomar, Rohitashva Budhauliya")
    @Description("QAAUT-1443(IOSMweb),QAAUT-1444(Android amp),QAAUT-1442(Android_MWeb), QAAUT-1441(Web), QAAUT-2228 (iOS-Native): To verify date and time are written in story card")
    @Test
    public void verifyDateTime() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkDateTime();
        Assert.assertTrue(isStepTrue, "Date Time in Story has not been displayed");
    }

    @Author(name = "Ravinder Singh, Gulshan Tomar, Shakeel Alam, Harsh Sharma, Rohitashva Budhauliya")
    @Description("QAAUT-1541(Android amp), QAAUT-1481(Web), QAAUT-1517(ios-web), QAAUT-1495(Android-MWeb), QAAUT-2226 (iOS-Native): To verify author name/agency is writen on story detail page")
    @Test
    public void verifyAuthorOrAgencyName() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkAuthorName();
        Assert.assertTrue(isStepTrue, "Author/Agency name in Story has not been displayed");
    }


    @Author(name = "Shakeel Alam,Ravinder Singh, Gulshan Tomar, Harsh Sharma")
    @Description("QAAUT-1514(IOSMweb),QAAUT-1538(Android AMP), QAAUT-1478(Web),QAAUT-1492(Android-MWeb): To verify header in story page is same as of homepage")
    @Test
    public void verifyStoryPageHeader() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkStoryPageHeader();
        Assert.assertTrue(isStepTrue, "Story Header has not been displayed");
    }


    @Author(name = "Shakeel Alam, Gulshan Tomar,Harsh Sharma")
    @Description("QAAUT-1521(ios-web), QAAUT-1484(Web),QAAUT-1499(Android-MWeb): To verify daily newsletter banner is displayed and is clickable")
    @Test
    public void verifyNewsletterBannerDisplayed() {
        boolean isStepTrue;
        isStepTrue = storyPage.checkNewsletterBannerDisplayed();
        Assert.assertTrue(isStepTrue, "Newsletter Banner has not been displayed");
    }

    @Author(name = "Gulshan Tomar,Harsh Sharma,Ravinder Singh")
    @Description("QAAUT-1485 (WEB),QAAUT-1500(Android-MWeb),QAAUT-1545(Android-amp): To verify topics should be displayed and clickable")
    @Test
    public void verifyTrendingTopicsCarouselDispayed() {
        boolean isStepTrue = storyPage.checkTrendingTopicsCarouselDispayed();
        Assert.assertTrue(isStepTrue, "Trending Topics Carousel Displayed Failed");
    }

    @Author(name = "Gulshan Tomar, Harsh Sharma")
    @Description("QAAUT-1483 (WEB),QAAUT-1497(Android-MWeb): To verify full story has close button")
    @Test
    public void verifyFullStoryCLoseButton() {
        boolean isStepTrue = storyPage.checkFullStoryCloseButton();
        Assert.assertTrue(isStepTrue, "Full Story CLose Button Displayed Failed");
    }

    @Author(name = "Gulshan Tomar")
    @Description("QAAUT-1453 (WEB): To verify read full story is visible and is clickable in quick reads")
    @Test
    public void verifyFullStoryIsVisibleAndClickableInQuickReads() {
        boolean isStepTrue = storyPage.checkReadFullStoryClickableinQuickReads();
        Assert.assertTrue(isStepTrue, "Read Full Story in Quick Readds Failed");
    }

    @Author(name = "Gulshan Tomar, Rohitashva Budhauliya")
    @Description("QAAUT-1638, QAAUT-2914 (Android-Native), QAAUT-2229, QAAUT-2913 (iOS-Native): Verify that if there is any Premium Stories inside the Section then on the Image Premium is displayed")
    @Test
    public void verifyImagePremiumIsDisplayed() {
        boolean isStepTrue = storyPage.checkImagePremiumDisplayed();
        Assert.assertTrue(isStepTrue, "Image Premium Not Displayed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1653(iOS-Native): Verify that 3 dot option should display at bottom right on lead photo story")
    @Test
    public void verifyLeadImage3DotOption() {
        boolean isStepTrue = storyPage.checkLeadImage3DotOption();
        Assert.assertTrue(isStepTrue, "3 dot option Not Displayed");
    }

    @Author(name = "Gulshan Tomar, Rohitashva Budhauliya")
    @Description("QAAUT-1659 (Android-Native), QAAUT-2205 (iOS-Native): Verify that After the Header Ad, First story is displayed")
    @Test
    public void verifyFirstStoryAfterHeaderAd() {
        boolean isStepTrue = storyPage.checkAfterHeaderAdFirstStoryIsDisplayed();
        Assert.assertTrue(isStepTrue, "First Story After Header Ad is Not Displayed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1624(iOS-Native): Verify that whatsapp and Twitter option is displayed on the Story details page when user opens the Story details page from the related topic pageion")
    @Test
    public void verifyWhatsAppTwitterRelatedTopicPage() {
        boolean isStepTrue = storyPage.checkWhatsAppTwitterRelatedTopicPage();
        Assert.assertTrue(isStepTrue, "WhatsApp Twitter Option From Related Topic Page Not Displayed");
    }

    @Author(name = "Gulshan Tomar, Shakeel Alam")
    @Description("QAAUT-1647 (Android-Native), QAAUT-2049, QAAUT-2050(iOS): Verify that within the Story, Section name is displayed")
    @Test
    public void verifySectionNameDisplayed() {
        boolean isStepTrue = storyPage.checkSectionNameisDispayed();
        Assert.assertTrue(isStepTrue, "Section name within the story is not displayed");
    }

    @Author(name = "Gulshan Tomar, Rohitashva Budhauliya")
    @Description("QAAUT-1648 (Android-Native), QAAUT-2213 (iOS-Native): Verify that within the Story, if there is no Section then Subsection name is displayed")
    @Test
    public void verifySubSectionNameDisplayed() {
        boolean isStepTrue = storyPage.checkSubSectionNameisDispayed();
        Assert.assertTrue(isStepTrue, "SubSection name within the story is not displayed");
    }

    @Author(name = "Shakeel Alam, Gulshan Tomar")
    @Description("QAAUT-1696,QAAUT-1694(android_Native), QAAUT-1699, QAAUT-1689(iOS-Native): Verify that user is able to share the Story from the three dots")
    @Test
    public void verifyShareStory3DotOption() {
        boolean isStepTrue = storyPage.checkShareStory3DotOption();
        Assert.assertTrue(isStepTrue, "3 dot option share story failed");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-1688(iOS-Native): Verify that when user tap on Cancel button then bottom action sheet should closed")
    @Test
    public void verifyActionSheetCancelOption() {
        boolean isStepTrue = storyPage.checkActionSheetCancelOption();
        Assert.assertTrue(isStepTrue, "ActionSheetCancelOption verification failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1695(Android-Native): Verify that On India Page after tapping on three dots on any story, bottom action sheet should opened")
    @Test
    public void verifyIndiaPageThreeDotTapDisplayBottomAction() {
        boolean isStepTrue = storyPage.checkIndiaPageThreeDotTapDisplayBottomAction();
        Assert.assertTrue(isStepTrue, "3 dot option share story failed on India section page of Explore.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1700(Android-Native): Verify that On Explore Page, when user taps on India then user is redirected to India Page and user will see the different stories.")
    @Test
    public void verifyIndiaPageRedirectionFromExplore() {
        boolean isStepTrue = storyPage.checkIndiaPageRedirectionFromExplore();
        Assert.assertTrue(isStepTrue, "INDIA is not displaying on top of redirection page.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1691(Android-Native): Verify that when user tap on Cancel button then bottom action sheet should closed.")
    @Test
    public void verifyCloseTabCloseBottomActionSheet() {
        boolean isStepTrue = storyPage.checkCloseTabCloseBottomActionSheet();
        Assert.assertTrue(isStepTrue, "Close button do not close.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1873(Android-Native): Verify that On India Page, when user tap on any Story then user is redirected to Story Details Page .")
    @Test
    public void verifyRedirectionOnTappingAnyStoryOnIndiaPage() {
        boolean isStepTrue = storyPage.checkRedirectionOnTappingAnyStoryOnIndiaPage();
        Assert.assertTrue(isStepTrue, "Redirection to related story detail page is failed.");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-1875(Android-Native): Verify that tapping back button from Story Details Page, user is redirected to India Page.")
    @Test
    public void verifyRedirectionFromStoryDetailsPageOnTappingAnyStoryOnIndiaPage() {
        boolean isStepTrue = storyPage.checkRedirectionFromStoryDetailsPageOnTappingAnyStoryOnIndiaPage();
        Assert.assertTrue(isStepTrue, "Redirection to India page is failed.");
    }

    @Author(name = "Shakeel Alam")
    @Description("QAAUT-2027(iOS-Native): Verify that user is able to share the story from the India section")
    @Test
    public void verifyShareStoryFromIndia() {
        boolean isStepTrue = storyPage.checkShareStoryFromIndia();
        Assert.assertTrue(isStepTrue, "Share Story From India failed");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2054(Android-Native): Verify that on the Premium Page, Only Premium Stories is displayed")
    @Test
    public void verifyAllStoriesArePremiumOnPremmiumPage() {
        boolean isStepTrue = storyPage.checkAllStoriesArePremiumOnPremmiumPage();
        Assert.assertTrue(isStepTrue, "All stories on Premium page are not premium!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2173(Android-Native): Verify that tapping on the Premium on the bottom nav, user will be redirected to the Premium Page")
    @Test
    public void verifyPremiumPageDisplay() {
        boolean isStepTrue = storyPage.checkPremiumPageDisplay();
        Assert.assertTrue(isStepTrue, "Premium page redirection failed!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2181(Android-Native): Verify that after the top Ad on the Premium Page, Title 'HT Premium' is displayed")
    @Test
    public void verifyPremiumPageHTPremiumDisplay() {
        boolean isStepTrue = storyPage.checkPremiumPageHTPremiumDisplay();
        Assert.assertTrue(isStepTrue, "Top ad and Premium page redirection failed!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2182 (Android-Native): Verify that after the Title, first lead story is displayed")
    @Test
    public void verifyFirstStoryDisplayAfterTitle() {
        boolean isStepTrue = storyPage.checkFirstStoryDisplayAfterTitle();
        Assert.assertTrue(isStepTrue, "First story display after title failed!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT- 2185(Android-Native): Verify that Premium tag is displayed on the Lead Image on top left of the Image")
    @Test
    public void verifyFirstStoryImageDisplayWithPremiumTag() {
        boolean isStepTrue = storyPage.checkFirstStoryImageDisplayWithPremiumTag();
        Assert.assertTrue(isStepTrue, "Premium tag is not displaying on lead image!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT- 2186 (Android-Native): Verify that After the lead story, all other pemium story is displayed")
    @Test
    public void verifyOtherStoryAreAlsoPremium() {
        boolean isStepTrue = storyPage.checkOtherStoryAreAlsoPremium();
        Assert.assertTrue(isStepTrue, "After lead story, all other story are not displaying!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT- 2200 (Android-Native): Verify that for all other premium story, Premium tag is displayed on the bottom of the image.")
    @Test
    public void verifyAllOtherStoryHavePremiumTagAtBottom() {
        boolean isStepTrue = storyPage.checkAllOtherStoryHavePremiumTagAtBottom();
        Assert.assertTrue(isStepTrue, "All other story do not have Premium tag on it!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT- 2201 (Android-Native): Verify that Section name is displayed just below the title of the Story on the Premium Page")
    @Test
    public void verifyStoryHaveSubSectionBelowTitle() {
        boolean isStepTrue = storyPage.checkStoryHaveSubSectionBelowTitle();
        Assert.assertTrue(isStepTrue, "Section name is not displaying for the story!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-2214(Android-Native): Verify the behaviour when non logged in user goes to the Premium Page")
    @Test
    public void verifyNonLoggedUserOnPremiumPage() {
        boolean isStepTrue = storyPage.checkNonLoggedUserOnPremiumPage();
        Assert.assertTrue(isStepTrue, "Login button not display on story page!!!!!!!!");
    }

    @Author(name = "Harsh Sharma")
    @Description("QAAUT-(Android-Native): ")
    @Test
    public void verifyStoryDisplayOnItsSectionPage() {
        boolean isStepTrue = storyPage.checkStoryDisplayOnItsSectionPage();
        Assert.assertTrue(isStepTrue, "Login button not display on story page!!!!!!!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3839 and QAAUT-3840(Android-Native):Verify that Related Topic heading is displayed on the Story details page ")
    @Test
    public void verifyRelatedTopicHeadingDisplayed() {
        boolean isStepTrue = storyPage.checkRelatedTopicHeadingDisplayed();
        Assert.assertTrue(isStepTrue, "Related Topics heading not displayed!!!!!!!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3841 and QAAUT-3840(Android-Native):Verify that Related Topic heading is displayed on the Story details page ")
    @Test
    public void verifyRelatedTopicsDisplayed() {
        boolean isStepTrue = storyPage.checkRelatedTopicsDisplayed();
        Assert.assertTrue(isStepTrue, "Related Topics not displayed!!!!!!!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3843 and QAAUT-3844(Android-Native):Verify the redirection on tapping any option under related topic")
    @Test
    public void verifyRelatedTopicsRedirection() {
        boolean isStepTrue = storyPage.checkRelatedTopicsRedirection();
        Assert.assertTrue(isStepTrue, "Related Topics redirection failed!!!!!!!");
    }

    @Author(name = "Ravinder Singh")
    @Description("QAAUT-3845 and QAAUT-3846(Android-Native):Verify the redirection on tapping any option under related topic")
    @Test
    public void checkRelatedTopicsPageStoryRedirection() {
        boolean isStepTrue = storyPage.checkRelatedTopicsPageStoryRedirection();
        Assert.assertTrue(isStepTrue, "Related Topics Story redirection failed!!!!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3847 (iOS-Native) and QAAUT-3848 (Android-Native) : Verify the redirection on tapping back button on topic screen")
    @Test
    public void verifyRedirectionOnTopicStoryIfTabOnbBackBtn() {
        boolean isStepTrue = storyPage.checkRedirectionOnTopicStoryIfTabOnbBackBtn();
        Assert.assertTrue(isStepTrue, "Redirection on tapping back button on topic screen failed!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3849 (iOS-native), QAAUT-3850 (AndroidNative) : Verify that user is able to share the story from the topic screen.")
    @Test
    public void verifyShareStoryFromTopicScreen() {
        boolean isStepTrue = storyPage.checkShareStoryFromTopicScreen();
        Assert.assertTrue(isStepTrue, "User is able to share the story from the topic screen failed");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-3857 (iOS-Native) and QAAUT-3858 (Android-Native) : Verify the redirection when user taps on the Section name displayed on the Story")
    @Test
    public void verifyRedirectionOnStoryIfTabOnSectionName() {
        boolean isStepTrue = storyPage.checkRedirectionOnStoryIfTabOnSectionName();
        Assert.assertTrue(isStepTrue, "Redirection when user taps on the Section name displayed on the Story failed!!!!");
    }

    @Author(name = "Rohitashva Budhauliya")
    @Description("QAAUT-4710 (iOS-Native) and QAAUT-4711 (Android-Native) : Verify that Read Aloud is displayed after the Lead Image caption")
    @Test
    public void verifyReadAloudOptionInStoryPage() {
        boolean isStepTrue = storyPage.checkReadAloudOptionInStoryPage();
        Assert.assertTrue(isStepTrue, "Read Aloud displayed in the Story failed!!!!");
    }

    @Author(name = "Nischal Kumar")
    @Description("QAAUT-5740 (Android-Native), QAAUT-5741 (iOS-NAtive): Verify the redirection when the user taps on any story displayed in City Section page")
    @Test
    public void verifyRedirectionWhenUserTapsOnStoryInCitiesSection() {
        boolean isStepTrue = storyPage.checkRedirectionWhenUserTapsOnStoryInCitiesSection();
        Assert.assertTrue(isStepTrue,"Stroy detailing page not displaying");
    }

    @Author(name = "Giridhar Raj")
    @Description("QAAUT- (web): Verify sign in with premium user,(session id:bfdd3ee5ed4cc9b39bcd8408dfcb366acf852949)")
    @Test
    public void verifySignInWithPremiumUser() {
        Map<String, String> param = globalVars.getParamsDataSinglePropertySingleProperty("verifySignInWithPremiumUser");
        boolean isStepTrue = storyPage.checkSubscriptionPaywall(param.get("HTPremiumPageUrl"),param.get("email"),param.get("password"));
        Assert.assertTrue(isStepTrue,"premium user story not displayed");
    }
}