package com.pages.LiveMint.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveMint.genericPages.CommonNewsInNumberPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewsInNumberPage extends CommonNewsInNumberPage {

    static AndroidDriver<MobileElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Home']")
    private static MobileElement homeButton;
    @FindBy(xpath = "//android.widget.TextView[@text='NEWS IN NUMBERS']")
    private static MobileElement widgetNewsInNumber;
    @AndroidFindBy(id = "com.htmedia.mint:id/rvNewsInNumber")
    private static MobileElement widgetNewsInNumberSection;
    @FindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/rvNewsInNumber']//following::*[@resource-id='com.htmedia.mint:id/tvDetails']")
    private static List<MobileElement> widgetNewsInNumberSectionDetailDes;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEWS IN NUMBERS']")
    private static MobileElement newsInNumberListingPage;
    @AndroidFindBy(id = "com.htmedia.mint:id/into_tab_layout")
    private static MobileElement newsInNumberListingPage3Dots;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_numbers_which")
    private static MobileElement newsInNumberListingPageSubTitle;
    @AndroidFindBy(xpath = "//*[@resource-id='com.htmedia.mint:id/view_pager_news_in_numbers']//following-sibling::*[@resource-id='com.htmedia.mint:id/cardview_item_details']")
    private static List<MobileElement> newsInNumberListingPageCardCount;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvViewAll")
    private static MobileElement widgetNewsInNumberViewAll;
    @FindBy(xpath = "//android.widget.TextView[@text='Back']")
    private static MobileElement backBtn;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvNew")
    private static MobileElement widgetNewsInNumberNewTag;
    @AndroidFindBy(id = "com.htmedia.mint:id/img_share")
    private static MobileElement newsInNumberListingPageShareIcon;
    @FindBy(id = "android:id/title")
    private static MobileElement ShareHeading;
    @FindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private static MobileElement messagesIcon;
    @FindBy(xpath = "//android.widget.TextView[@text='Bluetooth']")
    private static MobileElement facebookIcon;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
    private static MobileElement gmailIcon;
    @AndroidFindBy(id = "com.htmedia.mint:id/tvDate")
    private static MobileElement widgetsNewsInNumberDate;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_content")
    private static MobileElement listingPageDetailCardText;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_read_full_story")
    private static MobileElement readFullStoryBtn;
    @AndroidFindBy(id = "com.htmedia.mint:id/img_right_arrow")
    private static MobileElement imgRightArrow;
    @AndroidFindBy(id = "com.htmedia.mint:id/img_left_arrow")
    private static MobileElement imgLeftArrow;
    @AndroidFindBy(id = "com.htmedia.mint:id/txt_swipe_for_next_story")
    private static MobileElement swipeForNextStoryText;
    @AndroidFindBy(id = "com.htmedia.mint:id/txtViewDetailNewsHeadline")
    private static MobileElement detailPageHeadline;


    public NewsInNumberPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    @Override
    public boolean checkNewsInNumberWidgetOnHomePage() {
        commonFunctions.clickElement(homeButton, 5, "home tab");
        boolean isShowing = commonFunctions.scrollToElementDown(widgetNewsInNumber);
        commonFunctions.swipeElementUsingTouchAction(441,1740,434,1613);
        isShowing &= commonFunctions.checkElementVisibilityByScrolling(widgetNewsInNumberSection, "news in number section");
        return isShowing;
    }

    public boolean CheckNewsInNumberListingPage() {
        boolean isShowing = checkNewsInNumberWidgetOnHomePage();
        commonFunctions.clickElement(widgetNewsInNumberViewAll, 5, "news in number: view all");
        isShowing = commonFunctions.isElementDisplayed(newsInNumberListingPage, 10, "News in Number listing page");
        return isShowing;
    }

    @Override
    public boolean checkOnlyOneCardVisibleOnNewsInNumberListingPage() {
        boolean isShowing = CheckNewsInNumberListingPage();
        isShowing &= commonFunctions.isElementDisplayed(newsInNumberListingPageCardCount.get(0), 5, "only one card");
        int cardCount = newsInNumberListingPageCardCount.size();
        if (cardCount == 1) {
            isShowing &= true;
            Utils.logStepInfo(true, "On Listing Page Number of card count is : " + cardCount + " displayed successfully");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "On Listing Page Number of card count is not 1, Actual Card Count. : " + cardCount + " Verification failed ********");
        }
        return isShowing;
    }

    @Override
    public boolean checkThreeDotsAndBackFunctionalityOnNewsInNumberListingPage() {
        boolean isShowing = CheckNewsInNumberListingPage();
        isShowing &= commonFunctions.isElementDisplayed(newsInNumberListingPage3Dots, 10, "3 dots pagination");
        commonFunctions.clickElement(backBtn, 10, "Back button in Caps");
        isShowing &= commonFunctions.isElementDisplayed(widgetNewsInNumberSection, 10, "news in number section");
        return isShowing;
    }

    @Override
    public boolean checkTitleAndSubTitleOnNewsInNumberListingPage() {
        boolean isShowing = CheckNewsInNumberListingPage();
        isShowing &= commonFunctions.isElementDisplayed(newsInNumberListingPageSubTitle, 10, "news in Number: sub title");
        return isShowing;
    }

    @Override
    public boolean checkDiffCardInfoOnWidgetNewsInNumber() {
        boolean isShowing = checkNewsInNumberWidgetOnHomePage();
        String firstCardInfo = commonFunctions.getElementText(widgetNewsInNumberSectionDetailDes.get(0));
        String secondCardInfo = commonFunctions.getElementText(widgetNewsInNumberSectionDetailDes.get(1));
        if (firstCardInfo != secondCardInfo) {
            isShowing = true;
            Utils.logStepInfo(true, "Each card have different information Verification Successfully !!!!!!!!!!");
        } else {
            isShowing = false;
            Utils.logStepInfo(true, "Each card have same information Verification failed *********");
        }
        return isShowing;
    }

    @Override
    public boolean checkNewTagAndTitleOnWidgetNewsInNumber() {
        boolean isShowing = checkNewsInNumberWidgetOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(widgetNewsInNumberNewTag, 5, "New tag");
        return isShowing;
    }

    @Override
    public  boolean checkShareIconAndFunctionalityOnNewsInNumberListingPage() {
        boolean isShowing = checkNewsInNumberWidgetOnHomePage();
        commonFunctions.clickElement(widgetNewsInNumberSectionDetailDes.get(0));
        isShowing &= commonFunctions.isElementDisplayed(newsInNumberListingPage, 10, "News in Number listing page");
        isShowing &= commonFunctions.isElementDisplayed(newsInNumberListingPageShareIcon, 5, "share icon");
        commonFunctions.clickElement(newsInNumberListingPageShareIcon, 5, "share icon");
        isShowing &= commonFunctions.isElementDisplayed(ShareHeading, 10, "SHARE");
        isShowing &= commonFunctions.isElementDisplayed(messagesIcon, 10, "Messages Icon");
        isShowing &= commonFunctions.isElementDisplayed(facebookIcon, 10, "Facebook Icon");
        isShowing &= commonFunctions.isElementDisplayed(gmailIcon, 10, "Gmail Icon");
        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkLatestDataOnNewsInNumberWidget() {
        boolean isShowing = checkNewsInNumberWidgetOnHomePage();
        isShowing &= commonFunctions.isElementDisplayed(widgetsNewsInNumberDate, 5, "news in number: Date");
        String data = commonFunctions.getElementText(widgetNewsInNumberSectionDetailDes.get(0));
        if (!data.isEmpty()) {
            isShowing = true;
            Utils.logStepInfo(true, "card have latest data Verification Successfully !!!!!!!!!!");
        } else {
            isShowing = false;
            Utils.logStepInfo(true, "card have not latest data Verification failed *********");
        }
        return isShowing;
    }

    @Override
    public boolean checkCardVisibilityOnNewsInNumberWidget() {
        boolean isShowing = checkNewsInNumberWidgetOnHomePage();
        commonFunctions.scrollDownToElement(widgetNewsInNumberSection, 1);
        if (widgetNewsInNumberSectionDetailDes.size()==2) {
            isShowing = true;
            Utils.logStepInfo(true, "card visibility Verification Successfully !!!!!!!!!!");
        } else {
            isShowing = false;
            Utils.logStepInfo(true, "card visibility Verification failed *********");
        }
        return isShowing;
    }

    @Override
    public boolean checkViewAllFunctionality() {
        return CheckNewsInNumberListingPage();
    }

    @Override
    public boolean checkCardSwipeFunctionality() {
        boolean isShowing = CheckNewsInNumberListingPage();
        String cardText1 = commonFunctions.getElementText(listingPageDetailCardText, 5);
        commonFunctions.swipeElementUsingTouchAction(1004, 844, 99, 829);
        commonFunctions.dummyWait(1);
        String cardText2 = commonFunctions.getElementText(listingPageDetailCardText, 5);
        if (isShowing &= cardText1 != cardText2) {
            isShowing &= true;
            Utils.logStepInfo(true, "card swipe Verification Successfully !!!!!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(true, "card not swipe Verification failed *********");
        }
        commonFunctions.navigateBack();
        isShowing &= commonFunctions.isElementDisplayed(widgetNewsInNumber, 10, "widgets news in number");
        commonFunctions.scrollDownToElement(widgetNewsInNumberSection, 1);
        int firstEle[] = commonFunctions.getListOfElementXYCoordinate(widgetNewsInNumberSectionDetailDes, 0, "first card detail ");
        int secondEle[] = commonFunctions.getListOfElementXYCoordinate(widgetNewsInNumberSectionDetailDes, 1, "second card detail ");
        String secondStoryText = commonFunctions.getElementText(widgetNewsInNumberSectionDetailDes.get(1), 10);
        commonFunctions.swipeElementUsingTouchAction(secondEle[0], secondEle[1], firstEle[0], firstEle[1]);
        String thirdStoryText = commonFunctions.getElementText(widgetNewsInNumberSectionDetailDes.get(1), 10);
        if (isShowing &= secondStoryText != thirdStoryText) {
            isShowing &= true;
            Utils.logStepInfo(true, "card swipe successfully !!!!!!!!!!!");
        } else {
            isShowing &= false;
            Utils.logStepInfo(false, "card Not swipe verification failed *******");
        }
        return isShowing;
    }

    @Override
    public boolean checkReadFullStoryButtonAndFunctionality() {
        boolean isShowing = CheckNewsInNumberListingPage();
        commonFunctions.clickElement(readFullStoryBtn, 10, "read full story button");
        commonFunctions.dummyWait(2);
        commonFunctions.clickByCoordinates(374, 173);
        isShowing &= commonFunctions.isElementDisplayed(detailPageHeadline, 10, "story detail page");
        return isShowing;
    }

    @Override
    public boolean checkSwipeTextAtButton() {
        boolean isShowing = CheckNewsInNumberListingPage();
        isShowing &= commonFunctions.isElementDisplayed(imgRightArrow, 5, "image Right Arrow");
        isShowing &= commonFunctions.isElementDisplayed(imgLeftArrow, 5, "image Left Arrow");
        isShowing &= commonFunctions.isElementDisplayed(swipeForNextStoryText, 5, "swipe For Next Story Text");
        return isShowing;
    }


}

