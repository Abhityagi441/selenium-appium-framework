package com.pages.HindustanTimes.android_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonProfilePage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends CommonProfilePage {
    private static AndroidDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @AndroidFindBy(id = "com.ht.news:id/tvSkip")
    private static MobileElement skipButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_welcomeBack")
    private static MobileElement welcomeBackLoginUser;

    @AndroidFindBy(id = "com.ht.news:id/tv_editText")
    private static MobileElement editLoginUser;

    @AndroidFindBy(id = "com.ht.news:id/toolbarText")
    private static MobileElement editUserProfilePageHeader;

    @AndroidFindBy(id = "com.ht.news:id/navigation_home_section")
    private static MobileElement homeButton;

    @AndroidFindBy(id = "com.ht.news:id/darkTV")
    private static MobileElement darkThemes;

    @AndroidFindBy(id = "com.ht.news:id/profile")
    private static MobileElement profileButton;

    @AndroidFindBy(id = "com.ht.news:id/radioBtnFemale")
    private static MobileElement femaleRadioButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_edit_gender")
    private static MobileElement genderEditBtn;

    @AndroidFindBy(id = "com.ht.news:id/btnSave")
    private static MobileElement saveChangesBtn;

    @AndroidFindBy(id = "com.ht.news:id/txtViewGender")
    private static MobileElement userSelectedGender;

    @AndroidFindBy(id = "com.ht.news:id/continueBtn")
    private static MobileElement continueButton;

    @AndroidFindBy(id = "com.ht.news:id/btn_continue")
    private static MobileElement startReadingNews;

    @AndroidFindBy(id = "com.ht.news:id/tv_mayBeLeterMain")
    private static MobileElement laterButton;

    @AndroidFindBy(id = "com.ht.news:id/tv_edit_password")
    private static MobileElement resetPassword;

    @AndroidFindBy(id = "com.ht.news:id/forgot_password_heading_tv")
    private static MobileElement resetPasswordPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore Apps']")
    private static MobileElement exploreAppsProfilePageBtn;

    @AndroidFindBy(id = "com.ht.news:id/ivHindustanHindiLogo")
    private static MobileElement hindustanLogo;

    @AndroidFindBy(id = "com.ht.news:id/ivMintLogo")
    private static MobileElement liveMintLogo;

    @AndroidFindBy(id = "com.ht.news:id/ivHealthShotLogo")
    private static MobileElement healthShots;

    @AndroidFindBy(id = "com.ht.news:id/btnMintDownload")
    private static MobileElement liveMintDownloadNowBtn;

    @AndroidFindBy(id = "com.ht.news:id/btnLHDownload")
    private static MobileElement hidustanDownloadNowBtn;

    @AndroidFindBy(id = "android:id/button_once")
    private static MobileElement justOnceBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chrome']")
    private static MobileElement chromeOption;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign in']")
    private static MobileElement signInBtnPlayStor;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Us']")
    private static MobileElement contactUsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bookmarks']")
    private static MobileElement bookmarksProfilePage;

    @AndroidFindBy(id = "com.google.android.gm:id/welcome_tour_skip")
    private static MobileElement gmailRelatedSkipBtn;

    @AndroidFindBy(id = "com.ht.news:id/no_bookmark")
    private static MobileElement noBookmarkArticle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About Us']")
    private static MobileElement aboutUsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private static MobileElement privacyPolicy;

    @AndroidFindBy(id = "com.ht.news:id/aboutHtTv")
    private static MobileElement aboutHindustanTimeSectionText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private static MobileElement loginProfilePageBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Display & Text Size']")
    private static MobileElement displayAndTextSizeBtn;

    @AndroidFindBy(id = "com.ht.news:id/tv_edit_name")
    private static MobileElement editName;

    @AndroidFindBy(id = "com.ht.news:id/editTextName")
    private static MobileElement editNameField;

    @AndroidFindBy(id = "com.ht.news:id/tv_profileName")
    private static MobileElement userNameLabelAfterLogin;

    @AndroidFindBy(id = "com.ht.news:id/buildVersionTv")
    private static MobileElement buildVersion;

    @AndroidFindBy(id = "com.ht.news:id/btnHealthShotDownload")
    private static MobileElement healthshotsDownloadNow;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@text='1.0']")
    private static MobileElement textSizeAreaDefault;

    public ProfilePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
//        commonFunctions.clickElement(skipButton, 8);
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(laterButton, 5, "Maybe Later Button");
        commonFunctions.clickElementIfDisplayed(startReadingNews, 5, "Start Reading News");
        /*commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(206, 1950);
        commonFunctions.clickByCoordinates(650, 515);
        commonFunctions.clickByCoordinates(110, 2120);//As skip/next button in the prompt locator is not available*/
        System.out.println("****************** Test started ******************");
        System.out.println("******************" +globalVars.getProjectName()  + "******************");

    }

    @Override
    public boolean checkEditProfilePage(String password, String newPassword) {
        commonFunctions.clickElementIfDisplayed(homeButton, 5, "Home Button");
        commonFunctions.clickElement(profileButton, 5, "Profile");
        boolean isUserDetailsDisplayed = commonFunctions.getElementText(welcomeBackLoginUser, 5).contains("Welcome back,");
        commonFunctions.clickElement(editLoginUser, 5, "Edit Option for logged in user");
        boolean isEditProfileDisplayed = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EDIT PROFILE");
        commonFunctions.clickElement(resetPassword, 5, "Reset Password Option");
        boolean isResetPasswordDisplayed = commonFunctions.isElementDisplayed(resetPasswordPage, 5, "Reset Password Page");
        isResetPasswordDisplayed &= commonFunctions.getElementText(resetPasswordPage, 5).contains("Reset Password");
        commonFunctions.pressAndroidBackKey();
        return isUserDetailsDisplayed && isEditProfileDisplayed && isResetPasswordDisplayed;
    }

    @Override
    public boolean checkPasswordRevert(String password, String newPassword) {
        return false;
    }


    @Override
    public boolean checkEditGender() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile");
        boolean isUserDetailsDisplayed = commonFunctions.getElementText(welcomeBackLoginUser, 5).contains("Welcome back,");
        commonFunctions.clickElement(editLoginUser, 5, "Edit Option for logged in user");
        boolean isEditProfileDisplayed = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EDIT PROFILE");
        commonFunctions.clickElement(genderEditBtn, 5, "Gender edit button on Edit Page");
        commonFunctions.clickElement(femaleRadioButton, 5, "Female gender edit button on Edit Gender");
        commonFunctions.clickElement(saveChangesBtn, 5, "Save selected gender on Edit gender page");
        boolean isGenderFemaleTrue = commonFunctions.getElementText(userSelectedGender, 5).contains("Female");
        commonFunctions.pressAndroidBackKey();
        return isUserDetailsDisplayed && isEditProfileDisplayed && isGenderFemaleTrue;
    }

    @Override
    public boolean checkPencilButton() {
        return false;
    }

    @Override
    public boolean checkEditName(String newUserName, String expectedUserName) {
        commonFunctions.clickElementIfDisplayed(homeButton, 5, "Home Button");
        commonFunctions.clickElement(profileButton, 5, "Profile");
        boolean isUserDetailsDisplayed = commonFunctions.getElementText(welcomeBackLoginUser, 5).contains("Welcome back,");
        commonFunctions.clickElement(editLoginUser, 5, "Edit Option for logged in user");
        boolean isEditProfileDisplayed = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EDIT PROFILE");
        boolean isEditGenderDisplayed = commonFunctions.isElementDisplayed(editName, 5, "Edit Name");
        commonFunctions.clickElement(editName, 5, "Edit Name Option");
        editNameField.clear();
        commonFunctions.sendKey(editNameField, newUserName, 5);

        commonFunctions.clickElement(saveChangesBtn, 5, "Save name Option");

        commonFunctions.pressAndroidBackKey();
        boolean isNameUpdateSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, newUserName, 5, "user name");
        commonFunctions.clickElement(editLoginUser, 5, "Edit Option for logged in user");
        commonFunctions.clickElement(editName, 5, "Edit Name Back Option");
        editNameField.clear();
        commonFunctions.sendKey(editNameField, expectedUserName, 5);

        commonFunctions.clickElement(saveChangesBtn, 5, "Save name Option");
        commonFunctions.dummyWait(5);
        commonFunctions.pressAndroidBackKey();
        boolean isNameRevertSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 5, "user name");
        Utils.logStepInfo(true, "isUserDetailsDisplayed = "+isUserDetailsDisplayed);
        Utils.logStepInfo(true, "isEditProfileDisplayed = "+isEditProfileDisplayed);
        Utils.logStepInfo(true, "isEditGenderDisplayed = "+isEditGenderDisplayed);
        Utils.logStepInfo(true, "isNameUpdateSuccessful = "+isNameUpdateSuccessful);
        Utils.logStepInfo(true, "isNameRevertSuccessful = "+isNameRevertSuccessful);
        return isUserDetailsDisplayed && isEditProfileDisplayed && isEditGenderDisplayed && isNameUpdateSuccessful && isNameRevertSuccessful;

    }

    @Override
    public boolean checkAboutUsRedirection() {
        return false;
    }

    @Override
    public boolean checkAboutHTOptions() {
        return false;
    }

    @Override
    public boolean checkRedirectionForMintAppByTapDownload() {
        boolean isAllLogoDisplayOnExploreAppsPageTrue = true;
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.scrollDownToElement(exploreAppsProfilePageBtn,homeButton);
        commonFunctions.clickElement(exploreAppsProfilePageBtn, 5, "Explore Apps button on Profile page");
        boolean isExploreAppPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EXPLORE APP");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(hindustanLogo, 5, "Hindustan Times Logo on Explore Page");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(liveMintLogo, 5, "Live Mint Logo on Explore Page");
        commonFunctions.scrollDownToElement(healthShots,homeButton);
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(healthShots, 5, "Health Shots Logo on Explore Page");
        commonFunctions.scrollUpToElementDisplayedWithCoordinates(liveMintDownloadNowBtn);
        commonFunctions.clickElement(liveMintDownloadNowBtn, 5, "Live Mint download button on Explore Apps page");
        commonFunctions.clickElement(chromeOption, 5, "Chrome browser option after tap on Live Mind Download button");
        commonFunctions.clickElement(justOnceBtn, 5, "Just once after selecting browser option");
        commonFunctions.dummyWait(5);
        commonFunctions.changeDriverContextToNative();
        boolean isPlayStoreSignInBtnDisplay = commonFunctions.isElementDisplayed(signInBtnPlayStor, 5, "Sign in button at play store");
        commonFunctions.pressAndroidBackKey();
        return isExploreAppPageDisplay && isAllLogoDisplayOnExploreAppsPageTrue && isPlayStoreSignInBtnDisplay;
    }

    @Override
    public boolean checkRedirectionForHindustanAppByTapDownload() {
        boolean isAllLogoDisplayOnExploreAppsPageTrue = true;
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.scrollDownToElement(exploreAppsProfilePageBtn,homeButton);
        commonFunctions.clickElement(exploreAppsProfilePageBtn, 5, "Explore Apps button on Profile page");
        boolean isExploreAppPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EXPLORE APP");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(hindustanLogo, 5, "Hindustan Times Logo on Explore Page");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(liveMintLogo, 5, "Live Mint Logo on Explore Page");
        commonFunctions.scrollDownToElement(healthShots,homeButton);
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(healthShots, 5, "Health Shots Logo on Explore Page");
        commonFunctions.scrollUpToElementDisplayedWithCoordinates(hidustanDownloadNowBtn);
        commonFunctions.clickElement(hidustanDownloadNowBtn, 5, "Hindustan App download button on Explore Apps page");
        commonFunctions.clickElement(chromeOption, 5, "Chrome browser option after tap on Live Mind Download button");
        commonFunctions.clickElement(justOnceBtn, 5, "Just once after selecting browser option");
        commonFunctions.dummyWait(5);
        String getCurrentActivity = driver.currentActivity();
        boolean isPlayStoreSignInBtnDisplay = commonFunctions.isElementDisplayed(signInBtnPlayStor, 5, "Sign in button at play store");
        commonFunctions.pressAndroidBackKey();
        return isExploreAppPageDisplay && isAllLogoDisplayOnExploreAppsPageTrue && isPlayStoreSignInBtnDisplay;
    }

    @Override
    public boolean checkRedirectionForHealthShotsAppByTapDownload() {
        boolean isAllLogoDisplayOnExploreAppsPageTrue = true;
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.scrollDownToElement(exploreAppsProfilePageBtn,homeButton);
        commonFunctions.clickElement(exploreAppsProfilePageBtn, 5, "Explore Apps button on Profile page");
        boolean isExploreAppPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EXPLORE APP");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(hindustanLogo, 5, "Hindustan Times Logo on Explore Page");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(liveMintLogo, 5, "Live Mint Logo on Explore Page");
        commonFunctions.scrollDownToElement(healthShots,homeButton);
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(healthShots, 5, "Health Shots Logo on Explore Page");
        commonFunctions.clickElement(healthshotsDownloadNow, 5, "Healthshots download button on Explore Apps page");
        commonFunctions.clickElement(chromeOption, 5, "Chrome browser option after tap on Live Mind Download button");
        commonFunctions.clickElement(justOnceBtn, 5, "Just once after selecting browser option");
        commonFunctions.dummyWait(5);
        String getCurrentActivity = driver.currentActivity();
        boolean isPlayStoreSignInBtnDisplay = commonFunctions.isElementDisplayed(signInBtnPlayStor, 5, "Sign in button at play store");
        commonFunctions.pressAndroidBackKey();
        return isExploreAppPageDisplay && isAllLogoDisplayOnExploreAppsPageTrue && isPlayStoreSignInBtnDisplay;

    }

    @Override
    public boolean checkExploreAppsPageDisplayHindustanLiveMintHealthshotsApp() {
        boolean isAllLogoDisplayOnExploreAppsPageTrue = true;
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.scrollDownToElement(exploreAppsProfilePageBtn,homeButton);
        commonFunctions.clickElement(exploreAppsProfilePageBtn, 5, "Explore Apps button on Profile page");
        boolean isExploreAppPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EXPLORE APP");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(hindustanLogo, 5, "Hindustan Times Logo on Explore Page");
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(liveMintLogo, 5, "Live Mint Logo on Explore Page");
        commonFunctions.scrollDownToElement(healthShots,homeButton);
        isAllLogoDisplayOnExploreAppsPageTrue &= commonFunctions.isElementDisplayed(healthShots, 5, "Health Shots Logo on Explore Page");
        return isExploreAppPageDisplay && isAllLogoDisplayOnExploreAppsPageTrue;
    }

    @Override
    public boolean checkRedirectionTapOnExploreApps() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.scrollDownToElement(exploreAppsProfilePageBtn,homeButton);
        commonFunctions.clickElement(exploreAppsProfilePageBtn, 5, "Explore Apps button on Profile page");
        return commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("EXPLORE APP");
    }

    @Override
    public boolean checkRedirectionTapOnContactUs() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(contactUsBtn, 5, "Contact Us button in Profile page");
        boolean isShareRelatedOptionDisplay = commonFunctions.isElementDisplayed(gmailRelatedSkipBtn, 5, "Contact us want to operate with share option");
        commonFunctions.pressAndroidBackKey();
        return isShareRelatedOptionDisplay;
    }

    @Override
    public boolean checkRedirectionTapOnPrivacyPolicy() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(privacyPolicy, 5, "Privacy Policy button in Profile page");
        return commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("PRIVACY POLICY");
    }

    @Override
    public boolean checkRedirectionTapOnAboutUs() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(aboutUsBtn, 5, "About Us button in Profile page");
        return commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("ABOUT US");
    }

    @Override
    public boolean checkAboutHindustanTimesHaveAboutUsPrivacyPolicyContactUs() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        boolean isAboutHTSectionDisplay = commonFunctions.isElementDisplayed(aboutHindustanTimeSectionText, 5, "About Hindustan Times");
        isAboutHTSectionDisplay &= commonFunctions.getElementText(aboutHindustanTimeSectionText).contains("ABOUT HINDUSTAN TIMES");
        boolean isAboutHTSectionAllOptionsDisplay = commonFunctions.isElementDisplayed(aboutUsBtn, 5, "About Us button in Profile page");
        isAboutHTSectionAllOptionsDisplay &= commonFunctions.isElementDisplayed(privacyPolicy, 5, "Privacy Policy button in Profile page");
        isAboutHTSectionAllOptionsDisplay &= commonFunctions.isElementDisplayed(contactUsBtn, 5, "Contact Us button in Profile page");

        return isAboutHTSectionAllOptionsDisplay && isAboutHTSectionDisplay;
    }

    @Override
    public boolean checkRedirectionByBackArrowFromDisplayAndTextSizePage() {
        commonFunctions.clickElement(homeButton, 5, "Home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(displayAndTextSizeBtn, 5, "Display & Text Size button on Profile page");
        boolean isDisplayAndTextSizePageDisplay = commonFunctions.getElementText(editUserProfilePageHeader).contains("DISPLAY & TEXT SIZE");
        commonFunctions.pressAndroidBackKey();
        boolean isProfilePageDisplayWithLoginBtn = commonFunctions.isElementDisplayed(homeButton, 5, "Home button on Profile page");
        return isProfilePageDisplayWithLoginBtn && isDisplayAndTextSizePageDisplay;
    }

    @Override
    public boolean selectDarkThemeAndBackToHomePage() {
        boolean isHomePageDisplayed = false;
        commonFunctions.clickElement(homeButton, 10, "Home");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(displayAndTextSizeBtn, 5, "Display & Text Size button on Profile page");
        commonFunctions.clickElement(darkThemes, 10, "Dark Theme");
        commonFunctions.dummyWait(10);
        isHomePageDisplayed=commonFunctions.clickElementIfDisplayed(homeButton, 10, "Home");
        return isHomePageDisplayed;
    }

    @Override
    public boolean checkDefaultTextSize() {
        return false;
    }

    @Override
    public boolean checkBuildVersionDisplay() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.scrollDownToElement(buildVersion,homeButton);
        return commonFunctions.getElementText(buildVersion, 5).contains("Build");
    }

    @Override
    public boolean checkDefaultTextSizeIsMedium() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button");
        commonFunctions.clickElement(displayAndTextSizeBtn, 5, "Display & Text Size button in profile page");
        boolean isHeaderTextTrue = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("DISPLAY & TEXT SIZE");
        boolean isTextSizeByDefaultMedium = commonFunctions.isElementDisplayed(textSizeAreaDefault, 5, "Text size by default");
        return isHeaderTextTrue && isTextSizeByDefaultMedium;
    }

    @Override
    public boolean checkBuildVersionDisplayed() {
        return false;
    }

    @Override
    public boolean checkExploreAppsOption() {
        return false;
    }

    @Override
    public boolean checkLikedAppSection() {
        return false;
    }

    @Override
    public boolean checkBookmarkOptionOnProfilePage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        return commonFunctions.isElementDisplayed(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
    }

    @Override
    public boolean checkBookmarkOptionRedirectionPage() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        return commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
    }

    @Override
    public boolean checkBookmarkOptionRedirectionHaveNoBookmarks() {
        commonFunctions.clickElement(homeButton, 5, "HT home button");
        commonFunctions.clickElement(profileButton, 5, "Profile button on home page");
        commonFunctions.clickElement(bookmarksProfilePage, 5, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplay = commonFunctions.getElementText(editUserProfilePageHeader, 5).contains("BOOKMARKS");
        boolean isNoBookmarkArticleDisplay = commonFunctions.getElementText(noBookmarkArticle, 5).contains("No Bookmarked Articles");
        return isBookmarkPageDisplay && isNoBookmarkArticleDisplay;
    }
}
