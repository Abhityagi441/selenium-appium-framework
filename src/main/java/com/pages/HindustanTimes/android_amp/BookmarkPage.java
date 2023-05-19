package com.pages.HindustanTimes.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonLoginPage;
import com.utils.GlobalVars;
import com.utils.MailReader;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookmarkPage extends CommonBookmarkPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;


    public BookmarkPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkAdToBookmarkAndVerify(String uri, String address) {
        return false;
    }

    @Override
    public boolean checkBookmarkIconIsClickableAndDisplay(String uri, String address) {
        return false;
    }

    @Override
    public boolean checkBookMarkWorkingFine(String[] params) {
        return false;
    }

    @Override
    public boolean checkRemoveAllLinkBookMarkPage(String[] params) {
        return false;
    }

    @Override
    public boolean checkClickThreeDotDisplayDifferentOptions() {
        return false;
    }

    @Override
    public boolean checkBookMarkRedirectionLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkBookMarkRedirectionNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkOptionsInSettings() {
        return false;
    }

    @Override
    public boolean checkBottomActionPageOnIndiaPage() {
        return false;
    }

    @Override
    public boolean checkBookmark3DotOption() {
        return false;
    }

    @Override
    public boolean checkRedirectionOnTapBackFromBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkSomeArticleIsBookmarked() {
        return false;
    }

    @Override
    public boolean checkBookmarkPageHeadingInCenter() {
        return false;
    }

    @Override
    public boolean checkTextDisplayAfterBookmarkPageHeading() {
        return false;
    }

    @Override
    public boolean checkRedirectionStoryPageOnTap() {
        return false;
    }

    @Override
    public boolean checkRedirectionSectionPageOfStoryOnTap() {
        return false;
    }

    @Override
    public boolean checkBottomNavDisplayOnBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkHomeisSelectedBottomNavOnBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkIconDisplayBeforeImageStory() {
        return false;
    }

    @Override
    public boolean checkTapOnBookmarkIconAtBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookmarkStoryDisplay() {
        return false;
    }

    @Override
    public boolean checkBookmarkStoryDisplayForAnySectionSavedArticles() {
        return false;
    }

    @Override
    public boolean bookMarkStoryFromSportsSection() {
        return false;
    }

    @Override
    public boolean sportStoryInBookMarkedArtical() {
        return false;
    }

    @Override
    public boolean bookMarkStoryFromPhotosSection() {
        return false;
    }

    @Override
    public boolean photoStoryInBookMarkedArtical() {
        return false;
    }

    @Override
    public boolean checkCountOfBookMarkedStoriesSame() {
        return false;
    }

    @Override
    public boolean checkBookMarkMsgForLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkBookMarkMsgBoxForNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryOfVideoSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkedStoryFromVideoSection() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryOfPhotosSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromSectionListingPage() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryInBookmarkSectionFromSectionListingPage() {
        return false;
    }

    @Override
    public boolean checkBackRedirectionFromBookmarkPage() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromSearchPage() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryFromSearchPage() {
        return false;
    }

    @Override
    public boolean checkSearchBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkDailyDigestUnBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkStoryFromTopicPage() {
        return false;
    }

    @Override
    public boolean checkUnBookMarkStoryFromTopicPage() {
        return false;
    }

    @Override
    public boolean checkTopicBookMarkStoryDisplayedInBookMarkSection() {
        return false;
    }

    @Override
    public boolean checkBookMarkedStoryFromDailyDigest() {
        return false;
    }


}
