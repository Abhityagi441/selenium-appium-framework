package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonProfilePage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends CommonProfilePage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static ApiValidation apiValidation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Home']")
    private static MobileElement home;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(id = "Explore")
    private static MobileElement exploreButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Profile']")
    private static MobileElement profileButton;

    @iOSXCUITFindBy(id = "Welcome back,")
    private static MobileElement userDetails;

    @iOSXCUITFindBy(id = "Edit")
    private static MobileElement editProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='EDIT PROFILE']")
    private static MobileElement editProfilePage;

    @iOSXCUITFindBy(id = "back new")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField[@enabled='true'])[1]")
    private static MobileElement editPasswordField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='editPasswordButton'])[1]")
    private static MobileElement editPasswordBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == 'Type New Password'`]")
    private static MobileElement enterNewPass;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == 'Type New Password Again'`]")
    private static MobileElement enterConfirmPass;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Reset']")
    private static MobileElement resetPassword;

    @iOSXCUITFindBy(id = "Reset Password")
    private static MobileElement resetPasswordPage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Set Password'`]")
    private static MobileElement setPassword;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[1]")
    private static MobileElement editGender;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == ' Female'`]")
    private static MobileElement genderFemale;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Save Changes']")
    private static MobileElement saveChanges;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[3]")
    private static MobileElement pencilButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Edit'])[2]")
    private static MobileElement editName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@enabled='true']")
    private static MobileElement editNameField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[4]")
    private static MobileElement userNameLabelAfterLogin;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='About Us']")
    private static MobileElement aboutUs;

    @iOSXCUITFindBy(id = "ABOUT US")
    private static MobileElement aboutUsPage;

    @iOSXCUITFindBy(id = "Privacy Policy")
    private static MobileElement privacyPolicy;

    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name='PRIVACY POLICY']")
    private static MobileElement privacyPolicyPage;

    @iOSXCUITFindBy(id = "Contact Us")
    private static MobileElement contactUs;

    @iOSXCUITFindBy(id = "Ok")
    private static MobileElement okPrompt;

    @iOSXCUITFindBy(id = "Display & Text Size")
    private static MobileElement displayTextSize;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DISPLAY & TEXT SIZE']")
    private static MobileElement displayTextSizePage;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[`value == '50%'`]")
    private static MobileElement mediumText;

    @iOSXCUITFindBy(id = "ACCOUNT")
    private static MobileElement profilePage;

    @iOSXCUITFindBy(id = "Build Version 5.47")
    private static MobileElement buildVersion;

    @iOSXCUITFindBy(id = "Explore Apps")
    private static MobileElement exploreApps;

    @iOSXCUITFindBy(id = "Share App")
    private static MobileElement shareApp;

    @iOSXCUITFindBy(id = "Rate App")
    private static MobileElement rateApp;

    @iOSXCUITFindBy(id = "Feedback")
    private static MobileElement feedback;

    @iOSXCUITFindBy(id = "LIKED THE APP")
    private static MobileElement likedTheApp;

    @iOSXCUITFindBy(id = "EXPLORE APPS")
    private static MobileElement exploreAppsPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Download Now'])[1]")
    private static MobileElement hindustan;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Download Now'])[2]")
    private static MobileElement mint;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Download Now'])[3]")
    private static MobileElement healthshots;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Share']")
    private static MobileElement bottomShareSheet;

    @iOSXCUITFindBy(id = "Bookmarks")
    private static MobileElement bookmarks;

    @iOSXCUITFindBy(id = "BOOKMARKS")
    private static MobileElement bookmarkPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No Bookmarked Articles']")
    private static MobileElement noBookmarkedArticle;

    @iOSXCUITFindBy(xpath =  "//XCUIElementTypeStaticText[@name='BOOKMARKS']")
    private static MobileElement bookMarksCenterHeading;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement homeById;

    @iOSXCUITFindBy(id = "profileBarButton")
    private static MobileElement profileButtonById;
    public ProfilePage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        apiValidation=ApiValidation.getInstance();
        /*commonFunctions.clickElementIfDisplayed(allowTracking,10,"Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 10, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(continueButton,10,"Continue Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,10,"Later Button");
        commonFunctions.clickElementIfDisplayed(skip,10,"Skip Button");*/
    }


    @Override
    public boolean checkEditProfilePage(String password, String newPassword) {
        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElementIfDisplayed(profileButtonById, 20, "Profile");
        boolean isUserDetailsDisplayed=commonFunctions.isElementDisplayed(userDetails, 10, "User Details");
        commonFunctions.clickElement(editProfile, 20, "Edit Option");
        boolean isEditProfileDisplayed=commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        commonFunctions.clickElement(resetPassword, 20, "Reset Password Option");
        boolean isResetPasswordDisplayed=commonFunctions.isElementDisplayed(resetPasswordPage, 10, "Reset Password Page");
        //Reset Password disabled for now as Set Password Button is not working
        //boolean checkPasswordChangeStatus = changePassword(newPassword,password);
        commonFunctions.clickElement(back, 20, "Go back");
        commonFunctions.clickElement(back, 20, "Go back");

        return isUserDetailsDisplayed&&isEditProfileDisplayed&&isResetPasswordDisplayed;
    }

    @Override
    public boolean checkPasswordRevert(String password, String newPassword) {
        commonFunctions.clickElementIfDisplayed(home, 30, "Home Button");
        commonFunctions.clickElement(profileButton, 20, "Profile");
        boolean isUserDetailsDisplayed=commonFunctions.isElementDisplayed(userDetails, 10, "User Details");
        commonFunctions.clickElement(editProfile, 20, "Edit Option");
        boolean isEditProfileDisplayed=commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        commonFunctions.clickElement(resetPassword, 20, "Reset Password Option");
        boolean checkPasswordChangeBackStatus = changePassword(password,newPassword);
        commonFunctions.clickElement(back, 20, "Go back");
        return isUserDetailsDisplayed&&isEditProfileDisplayed&&checkPasswordChangeBackStatus;
    }


    public boolean changePassword(String newPassword, String oldPassword) {
        boolean changePasswordStatus;
        commonFunctions.clickElementIfDisplayed(resetPassword, 10, "Reset Password Option");
        commonFunctions.clickElement(editPasswordField, 5, "Current Password ");
        commonFunctions.sendKey(editPasswordField, oldPassword, 5);
        commonFunctions.dummyWait(20);
        //commonFunctions.clickElement(enterNewPass, 5, "new Password ");
        commonFunctions.sendKey(enterNewPass, newPassword, 5);
        commonFunctions.dummyWait(20);
        //commonFunctions.clickElement(enterConfirmPass, 5, "confirm Password ");
        commonFunctions.sendKey(enterConfirmPass, newPassword, 5);
        //The following line for saving the updated password is not working at present, hence using coordinates
        //commonFunctions.clickElement(setPassword, 5, "Set Password ");
        commonFunctions.clickByCoordinates(196,661);
        commonFunctions.clickElementWithCoordinates(196,661);
        commonFunctions.dummyWait(5);
        changePasswordStatus = commonFunctions.isElementDisplayed(editProfilePage, 5, "Edit Profile Page");
        return changePasswordStatus;
    }
    @Override
    public boolean checkEditGender() {
        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile");
        boolean isUserDetailsDisplayed=commonFunctions.isElementDisplayed(userDetails, 10, "User Details");
        commonFunctions.clickElement(editProfile, 20, "Edit Option");
        boolean isEditProfileDisplayed=commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        boolean isEditGenderDisplayed=commonFunctions.isElementDisplayed(editGender, 10, "Edit Gender");
        commonFunctions.clickElement(editGender, 20, "Edit Gender Option");
        boolean genderFemaleSelected=commonFunctions.clickElementWithCoordinates(63,405);//commonFunctions.clickElement(genderFemale, 20, "Select Gender Female Option");
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(saveChanges, 20, "Save gender Option");
        commonFunctions.clickElement(back, 20, "Go back");
        return isUserDetailsDisplayed&&isEditProfileDisplayed&&isEditGenderDisplayed&&genderFemaleSelected;
    }

    @Override
    public boolean checkPencilButton() {
        commonFunctions.clickElementIfDisplayed(home, 30, "Home Button");
        commonFunctions.clickElement(profileButton, 20, "Profile");
        boolean isUserDetailsDisplayed=commonFunctions.isElementDisplayed(userDetails, 10, "User Details");
        commonFunctions.clickElement(editProfile, 20, "Edit Option");
        boolean isEditProfileDisplayed=commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        boolean isPencilButtonDisplayed=commonFunctions.isElementDisplayed(pencilButton, 10, "Pencil Button");
        commonFunctions.clickElement(back, 20, "Go back");
        return isUserDetailsDisplayed&&isEditProfileDisplayed&&isPencilButtonDisplayed;
    }

    @Override
    public boolean checkEditName(String newUserName, String expectedUserName) {
        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElementIfDisplayed(profileButtonById, 20, "Profile");
        boolean isUserDetailsDisplayed=commonFunctions.isElementDisplayed(userDetails, 10, "User Details");
        commonFunctions.clickElement(editProfile, 20, "Edit Option");
        boolean isEditProfileDisplayed=commonFunctions.isElementDisplayed(editProfilePage, 10, "Edit Profile Page");
        boolean isEditGenderDisplayed=commonFunctions.isElementDisplayed(editName, 10, "Edit Name");
        commonFunctions.clickElement(editName, 20, "Edit Name Option");
        editNameField.clear();
        commonFunctions.sendKey(editNameField, newUserName, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(saveChanges, 20, "Save name Option");
        boolean isNameUpdateSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, newUserName, 20, "user name");
        commonFunctions.clickElement(editName, 20, "Edit Name Back Option");
        editNameField.clear();
        commonFunctions.sendKey(editNameField, expectedUserName, 5);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElement(saveChanges, 20, "Save name Option");
        boolean isNameRevertSuccessful = commonFunctions.checkElementText(userNameLabelAfterLogin, expectedUserName, 20, "user name");
        commonFunctions.clickElement(back, 20, "Go back");

        return isUserDetailsDisplayed&&isEditProfileDisplayed&&isEditGenderDisplayed&&isNameUpdateSuccessful&&isNameRevertSuccessful;
    }
    @Override
    public boolean checkAboutUsRedirection() {
        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile");
        boolean isAboutUsDisplayed=commonFunctions.isElementDisplayed(aboutUs, 10, "About Us");
        commonFunctions.clickElement(aboutUs, 20, "About Us");
        boolean isAboutUsPageDisplayed=commonFunctions.isElementDisplayed(aboutUsPage, 10, "About Us Page");
        commonFunctions.clickElement(back, 20, "Go back");
        return isAboutUsDisplayed&&isAboutUsPageDisplayed;
    }

    @Override
    public boolean checkAboutHTOptions() {

        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile");
        commonFunctions.checkElementVisibilityByScrolling(contactUs,"Conntact us");
        boolean isAboutUsDisplayed=commonFunctions.isElementDisplayed(aboutUs, 10, "About Us");
        boolean isPrivacyPolicyDisplayed=commonFunctions.isElementDisplayed(privacyPolicy, 10, "Privacy Policy");
        boolean isContactUsPageDisplayed=commonFunctions.isElementDisplayed(contactUs, 10, "Contact Us");
        return isAboutUsDisplayed&&isPrivacyPolicyDisplayed&&isContactUsPageDisplayed;
    }
    @Override
    public boolean checkDefaultTextSize() {

        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElementIfDisplayed(profileButtonById, 20, "Profile");
        commonFunctions.clickElement(displayTextSize, 10, "Display & TextSize");
        boolean isRedirectionTrue=commonFunctions.isElementDisplayed(displayTextSizePage, 10, "Display & TextSize");
        boolean defaultTextSize=commonFunctions.isElementDisplayed(mediumText, 10, "Medium Text");
        commonFunctions.clickElement(back, 20, "Back to Profile");
        boolean isProfileDisplayed=commonFunctions.isElementDisplayed(profilePage, 10, "Profile Page");
        return isRedirectionTrue && defaultTextSize && isProfileDisplayed;
    }

    @Override
    public boolean checkBuildVersionDisplayed() {

        commonFunctions.clickElementIfDisplayed(home, 30, "Home Button");
        commonFunctions.clickElement(profileButton, 20, "Profile");
        commonFunctions.scrollUntilElementFound(buildVersion);
        //commonFunctions.scrollToBottomOniOSNative();
        boolean isBuildVersionDisplayed=commonFunctions.isElementDisplayed(buildVersion, 10, "Build version");
        commonFunctions.clickElement(home, 20, "Back");
        return isBuildVersionDisplayed ;
    }

    @Override
    public boolean checkExploreAppsOption() {

        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElementIfDisplayed(profileButtonById, 20, "Profile");
        commonFunctions.scrollUntilElementFound(exploreApps);
        commonFunctions.clickElement(exploreApps, 20, "Explore Apps");
        boolean isExploreAppsPage=commonFunctions.isElementDisplayed(exploreAppsPage, 10, "Explore Apps Heading");
        boolean isHindustanDisplayed=commonFunctions.isElementDisplayed(hindustan, 10, "hindustan");
        boolean isMintDisplayed=commonFunctions.isElementDisplayed(mint, 10, "mint");
        commonFunctions.scrollUntilElementFound(healthshots);
        boolean isHealthShotsDisplayed=commonFunctions.isElementDisplayed(healthshots, 10, "healthshots");
        commonFunctions.clickElement(back, 20, "Back");
        return isExploreAppsPage&&isHindustanDisplayed&&isMintDisplayed&&isHealthShotsDisplayed ;
    }

    @Override
    public boolean checkLikedAppSection() {

        commonFunctions.clickElementIfDisplayed(homeById, 30, "Home Button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile");
        boolean isUserDisplayed=commonFunctions.isElementDisplayed(profilePage, 10, "User");
        commonFunctions.checkElementVisibilityByScrolling(exploreApps,"Explore apps");
        boolean isLikedAppDisplayed=commonFunctions.isElementDisplayed(likedTheApp, 10, "Liked the App");
        boolean isExploreAppsDisplayed=commonFunctions.isElementDisplayed(exploreApps, 10, "Explore Apps");
        boolean isShareAppDisplayed=commonFunctions.isElementDisplayed(shareApp, 10, "Share App");
        boolean isRateAppDisplayed=commonFunctions.isElementDisplayed(rateApp, 10, "Rate App");
        commonFunctions.scrollUntilElementFound(feedback);
        boolean isFeedbackDisplayed=commonFunctions.isElementDisplayed(feedback, 10, "Feedback");
        return isLikedAppDisplayed&&isUserDisplayed&&isExploreAppsDisplayed&&isShareAppDisplayed&&isRateAppDisplayed&&isFeedbackDisplayed ;
    }

    @Override
    public boolean checkBookmarkOptionOnProfilePage() {
        commonFunctions.clickElementIfDisplayed(homeById, 20, "HT home button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile button on home page");
        return commonFunctions.isElementDisplayed(bookmarks, 20, "Bookmarks option on Profile page");
    }

    @Override
    public boolean checkBookmarkOptionRedirectionPage() {
        commonFunctions.clickElementIfDisplayed(homeById, 20, "HT home button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile button on home page");
        commonFunctions.clickElement(bookmarks, 20, "Bookmarks option on Profile page");
        return commonFunctions.getElementText(bookMarksCenterHeading, 20).contains("BOOKMARKS");
    }

    @Override
    public boolean checkBookmarkOptionRedirectionHaveNoBookmarks() {
        commonFunctions.clickElementIfDisplayed(homeById, 20, "HT home button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile button on home page");
        commonFunctions.clickElement(bookmarks, 20, "Bookmarks option on Profile page");
        boolean isBookmarkPageDisplayed=commonFunctions.isElementDisplayed(bookmarkPage,10,"BookMark Page");
        boolean isNoBookmarkArticleDisplay = commonFunctions.getElementText(noBookmarkedArticle, 20).contains("No Bookmarked Articles");
        return isBookmarkPageDisplayed && isNoBookmarkArticleDisplay;

    }

    @Override
    public boolean checkRedirectionTapOnContactUs() {
        commonFunctions.clickElementIfDisplayed(homeById, 20, "Home button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile button");
        commonFunctions.clickElement(contactUs, 20, "Contact Us button in Profile page");
        boolean isShareRelatedOptionDisplay = commonFunctions.isElementDisplayed(okPrompt, 20, "Ok prompt");
        commonFunctions.clickElement(okPrompt, 20, "Ok prompt");
        commonFunctions.clickElementIfDisplayed(home, 20, "Back");
        return isShareRelatedOptionDisplay;
    }

    @Override
    public boolean checkRedirectionTapOnPrivacyPolicy() {
        commonFunctions.clickElementIfDisplayed(homeById, 20, "Home button");
        commonFunctions.clickElement(profileButtonById, 20, "Profile button");
        commonFunctions.clickElement(privacyPolicy, 20, "Privacy Policy button in Profile page");
        boolean isPrivacyPageDisplayed=commonFunctions.isElementDisplayed(privacyPolicyPage, 20,"Privacy Policy Page");
        return isPrivacyPageDisplayed;

    }

    @Override
    public boolean checkBuildVersionDisplay() {
        return false;
    }

    @Override
    public boolean checkDefaultTextSizeIsMedium() {
        return false;
    }

    @Override
    public boolean checkRedirectionForMintAppByTapDownload() {
        return false;
    }

    @Override
    public boolean checkRedirectionForHindustanAppByTapDownload() {
        return false;
    }

    @Override
    public boolean checkRedirectionForHealthShotsAppByTapDownload() {
        return false;
    }

    @Override
    public boolean checkExploreAppsPageDisplayHindustanLiveMintHealthshotsApp() {
        return false;
    }

    @Override
    public boolean checkRedirectionTapOnExploreApps() {
        return false;
    }

    @Override
    public boolean checkRedirectionTapOnAboutUs() {
        return false;
    }

    @Override
    public boolean checkAboutHindustanTimesHaveAboutUsPrivacyPolicyContactUs() {
        return false;
    }

    @Override
    public boolean checkRedirectionByBackArrowFromDisplayAndTextSizePage() {
        return false;
    }

    @Override
    public boolean selectDarkThemeAndBackToHomePage() {
        return false;
    }
}
