package com.pages.HindustanTimes.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonSocialSharingPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SocialSharingPage extends CommonSocialSharingPage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "(//a[@class='sign-in'])[1]")
    private static WebElement singInButton;
    @FindBy(id = "customBtn")
    private static WebElement continueWithGoogleButton;
    @FindBy(xpath = "//a[text()='Sign in with Apple']")
    private static WebElement continueWithAppleID;
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail") //uemail
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin") //login
    private static WebElement signInButtonMainSignInPage;
    @FindBy(xpath = "//div[text()='Use another account']")
    private static WebElement useAnotherAccountGmailSignInPage;
    @FindBy(id = "identifierId")
    private static WebElement emailOrPhoneGmailSignInPage;
    @FindBy(id = "account_name_text_field")
    private static WebElement emailAppleSignInPage;
    @FindBy(id = "password_text_field")
    private static WebElement passwordAppleSignInPage;
    @FindBy(id = "sign-in")
    private static WebElement appleSignInNextButton;
    @FindBy(id = "email")
    private static WebElement emailOrPhoneFacebookSignInPage;
    @FindBy(id = "pass")
    private static WebElement passwordFacebookSignInPage;
    @FindBy(xpath = "//input[@type='submit']") //input[@value='Log In']
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "(//div[@class='logged-in']//span[2])[1]")
    private static WebElement userNameLabelAfterLogin;
    @FindBy(xpath = "//button[contains(text(),'Continue as')]")
    private static WebElement continueAsFacebookButton;
    @FindBy(xpath = "(//a[@class='sign-out'])[1]")
    private static WebElement LogoutButton;
    @FindBy(id = "generate_otp")
    private static WebElement generateOtpMainSignInPage;
    @FindBy(id = "reGenOtpForgot")
    private static WebElement reGenerateOtpMainSignInPage;
    @FindBy(id = "loginOTP")
    private static WebElement sigInWithOtpButtonMainSignInPage;
    @FindBy(id = "verifyLoginOTP")
    private static WebElement verifyOTPToProceedButton;
    @FindBy(id = "agree")
    private static WebElement acceptCookie;
    @FindBy(className = "contentSec2") //div[@class='notification']
    private static WebElement OTPNotificationSentLabel;
    @FindBy(className = "otp")
    private static List<WebElement> OTPInputBoxList;

    @FindBy(xpath = "(//h3[@class='hdg3']/a)[1]")
    private static WebElement firstStoryTitle;

    @FindBy(xpath = "(//div[@class='shareIcons'])[1]")
    private static WebElement firstStoryShareAllOptions;

    @FindBy(xpath = "//div[@class='copyLink']")
    private static WebElement copyUrlToShareAllOptions;

    @FindBy(xpath = "//amp-social-share[@type='twitter']")
    private static WebElement twitterSharingAllOptions;

    @FindBy(xpath = "//amp-social-share[@type='facebook']")
    private static WebElement facebookSharingAllOptions;

    @FindBy(xpath = "//amp-social-share[@type='whatsapp']")
    private static WebElement whatsappSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']//a[4]")
    private static WebElement linkedinSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']//amp-social-share[@type='twitter']")
    private static WebElement twitterShareOptionInlineStory;

    @FindBy(xpath = "//div[@class='shareIcons']//amp-social-share[@type='facebook']")
    private static WebElement facebookShareOptionInlineStory;

    @FindBy(xpath = "//div[@class='shareIcons']//amp-social-share[@type='whatsapp']")
    private static WebElement whatsappShareOptionInlineStory;

    @FindBy(xpath = "//a[text()='Home']")
    private static WebElement HomeOption;

    @FindBy(xpath = "((//a[@class='readStory'])[1]")
    private static WebElement openFullStory;


    public SocialSharingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean clickOnReadFullStory() {
        boolean isClickOnReadFullStory=false;
        try {
            isClickOnReadFullStory=commonFunctions.scrollToElementViewAndClick(openFullStory, 20, "openFullStory");
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains("amp.html")) {
                isClickOnReadFullStory = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnReadFullStory;
    }

    public boolean checkSharingInlineStoryOnTwitter() {
        boolean isSharingTwitterSuccessful = false;
        try {
            isSharingTwitterSuccessful=commonFunctions.scrollToElementViewAndClick(twitterShareOptionInlineStory, 20, "twitterShareOptionInlineStory");
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains("twitter.com")) {
                isSharingTwitterSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingTwitterSuccessful;
    }

    public boolean checkSharingInlineStoryOnFacebook() {
        boolean isSharingFacebookSuccessful = false;
        try {
            isSharingFacebookSuccessful=commonFunctions.scrollToElementViewAndClick(facebookShareOptionInlineStory, 20, "facebookShareOptionInlineStory");
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains("facebook.com")) {
                isSharingFacebookSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingFacebookSuccessful;
    }

    public boolean checkSharingInlineStoryOnWhatsapp() {
        boolean isSharingWhatsappSuccessful = false;
        try {
            isSharingWhatsappSuccessful=commonFunctions.scrollToElementViewAndClick(whatsappShareOptionInlineStory, 20, "whatsappShareOptionInlineStory");
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains("whatsapp.com")) {
                isSharingWhatsappSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingWhatsappSuccessful;
    }

    @Override
    public boolean checkSocialSharingFunctionality() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean firstStory = clickOnFirstStory();
        boolean sharingFacebook = checkSharingStoryOnSocialMedia(facebookSharingAllOptions, "facebookSharingAllOptions", "m.facebook.com"); //checkSharingStoryOnFacebook();
        boolean sharingTwitter = checkSharingStoryOnSocialMedia(twitterSharingAllOptions, "twitterSharingAllOptions", "twitter.com"); //checkSharingStoryOnTwitter();
        boolean sharingWhatsapp = checkSharingStoryOnSocialMedia(whatsappSharingAllOptions, "whatsappSharingAllOptions", "whatsapp.com");//checkSharingStoryOnWhatsApp();


        return firstStory  && sharingTwitter && sharingFacebook && sharingWhatsapp;
    }

    @Override
    public boolean socialSharingInStoryPage(String params[]) {
        return false;
    }

    @Override
    public boolean checkSocialSharingIconsClickable() {
        return false;
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageBySearch() {
        return false;
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics() {
        return false;
    }

    @Override
	public boolean checkSocialSharingWithWhatsappAndGmail() {
		// TODO Auto-generated method stub
		return false;
	}

    public boolean clickOnFirstStory() {
        boolean isClickOnFirstStory=false;
        try {
            isClickOnFirstStory=commonFunctions.scrollToElementViewAndClick(firstStoryTitle, 20, "firstStoryTitle");
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains(".html")) {
                isClickOnFirstStory = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isClickOnFirstStory;
    }

    public boolean checkSharingStoryOnSocialMedia(WebElement webElement, String element, String socialMedia) {
    	boolean isSharingStorySocialMediaSuccessful = false;
        try {
            commonFunctions.scrollToElementView(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStorySocialMediaSuccessful=commonFunctions.clickElementIfDisplayed(webElement, 20, element);
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL= commonFunctions.getCurrentURL(socialMedia,20);
            if(!currentURL.isEmpty()&& currentURL.contains(socialMedia)) {
            	isSharingStorySocialMediaSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStorySocialMediaSuccessful;
 
    }
    /*public boolean checkSharingStoryOnTwitter() {
        boolean isSharingStoryTwitterSuccessful = false;
        try {
            commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStoryTwitterSuccessful =commonFunctions.clickElementIfDisplayed(twitterSharingAllOptions, 20, "twitterSharingAllOptions");
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains("twitter.com")) {
                isSharingStoryTwitterSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStoryTwitterSuccessful;
    }

    public boolean checkSharingStoryOnFacebook() {
        boolean isSharingStoryFacebookSuccessful = false;
        try {
            commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStoryFacebookSuccessful=commonFunctions.clickElementIfDisplayed(facebookSharingAllOptions, 20, "facebookSharingAllOptions");
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains("m.facebook.com")) {
                isSharingStoryFacebookSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStoryFacebookSuccessful;
    }

    public boolean checkSharingStoryOnLinkedin() {
        boolean isSharingStoryLinkedinSuccessful = false;
        try {
            commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStoryLinkedinSuccessful = commonFunctions.clickElementIfDisplayed(linkedinSharingAllOptions, 20, "linkedinSharingAllOptions");
            commonFunctions.waitForWindow(2, "new window");
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (!currentURL.isEmpty() && currentURL.contains("linkedin.com")) {
                isSharingStoryLinkedinSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStoryLinkedinSuccessful;
    }

    public boolean checkSharingStoryOnWhatsapp() {
        boolean isSharingStoryWhatsappSuccessful = false;
        try {
            commonFunctions.scrollToElementViewAndClick(firstStoryShareAllOptions, 20, "firstStoryShareAllOptions");
            isSharingStoryWhatsappSuccessful=commonFunctions.clickElementIfDisplayed(whatsappSharingAllOptions, 20, "whatsappSharingAllOptions");
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains("whatsapp.com")) {
                isSharingStoryWhatsappSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStoryWhatsappSuccessful;
    }*/
}
