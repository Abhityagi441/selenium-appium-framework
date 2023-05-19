package com.pages.HindustanTimes.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonSocialSharingPage;
import com.utils.GlobalVars;
import com.utils.Utils;
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
    private static CommonFunctionsMobileHt commonFunctionsMobile;

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

    @FindBy(xpath = "//div[@class='btnExplore']")
    private static WebElement explore;

    @FindBy(xpath = "//div[contains(@class,'bigCart')]/h3/a")
    private static WebElement firstStoryTitle;

    @FindBy(xpath = "//section[contains(@class,'ht-ad-holder')][1]//div[@data-vars-orderid='1']//span[@title='share']")
    private static WebElement firstStoryShareAllOptions;

    @FindBy(xpath = "//div[@class='new__socialIcons']/div[2]/div/div[2]/div[2]")
    private static WebElement copyUrlToShareAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']/a[1]")
    private static WebElement whatsappSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']/a[2]")
    private static WebElement twitterSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']/a[3]")
    private static WebElement facebookSharingAllOptions;

    @FindBy(xpath = "//div[@class='shareIcons']/a[4]")
    private static WebElement linkedinSharingAllOptions;

    @FindBy(xpath = "(//div[@class='shareArticle']//a[@class='tw'])[1]")
    private static WebElement twitterShareOptionInlineStory;

    @FindBy(xpath = "(//div[@class='shareArticle']//a[@class='fb'])[1]")
    private static WebElement facebookShareOptionInlineStory;

    @FindBy(xpath = "(//div[@class='shareArticle']//a[@class='wt'])[1]")
    private static WebElement whatsappShareOptionInlineStory;

    @FindBy(xpath = "//ul[@class='leftFixedNav']//a")
    private static WebElement homeOption;

    @FindBy(xpath = "//div[@class='nav-sec']//li[2]/a")
    private static WebElement indiaNews;

    @FindBy(className = "shareIcons")
    private static WebElement firstStoryShareAllOptionsSocialSharing;

    @FindBy(xpath = "//div[@class='shareIcons']/a[3]")
    private static WebElement twitterSharingAllOptionsSocial;

    @FindBy(xpath = "//div[@class='shareIcons']/a[2]")
    private static WebElement facebookSharingAllOptionsSocial;

    @FindBy(xpath = "//div[@class='shareIcons']/a[4]")
    private static WebElement linkedinSharingAllOptionsSocial;

    @FindBy(xpath = "//div[@class='shareIcons']/a[1]")
    private static WebElement whatsappSharingAllOptionsSocial;

    @FindBy(xpath="(//span[contains(@class,'share-candidate')])[2]")
    private static WebElement shareBtn;

    @FindBy(xpath = "//span[@class='crossicon']")
    private static WebElement closeOption;

    @FindBy(xpath = "(//span[@class = 'share share-candidate'])[1]")
    private static WebElement shareIcon;

    @FindBy(xpath = "//div[@class='new__socialIcons']/div[2]/div/div[1]/div[2]/a")
    private static List<WebElement> listOfSharingOption;

    public SocialSharingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean backToHomePage() {
        boolean isBackToHomePageSuccessful = false;
        try {
            commonFunctions.navigateBack();
            commonFunctions.dummyWait(10);
            isBackToHomePageSuccessful=commonFunctions.scrollToElementViewAndClick(homeOption, 60, "HomeOption");
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains(globalVars.getProdUrl())) {
                isBackToHomePageSuccessful = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isBackToHomePageSuccessful;
    }

    public boolean checkSharingStoryOnSocialMedia(WebElement webElement, String element, String socialMedia) {
    	boolean isSharingStorySocialMediaSuccessful = false;
        try {
            commonFunctions.clickElementIfDisplayed(shareIcon,5,"Share icon");
            commonFunctions.scrollToElement(webElement,element);
            isSharingStorySocialMediaSuccessful=commonFunctions.clickElementWithJS(webElement, 10, element);
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains(socialMedia)) {
            	isSharingStorySocialMediaSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingStorySocialMediaSuccessful;

    }
    
    public boolean checkSharingInlineStoryOnSocialMedia(WebElement webElement, String element, String title, int ExpectedNumberOfWindows ) {
        boolean isSharingInlineStoryTwSuccessful = false;
        try {
            commonFunctions.clickElementIfDisplayed(shareIcon,5,"Share icon");
            isSharingInlineStoryTwSuccessful=commonFunctions.scrollToElementViewAndClick(webElement, 20, element);
            commonFunctions.dummyWait(5);
            commonFunctions.waitForWindow(2,"new window");
            ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(ExpectedNumberOfWindows));
            commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
            commonFunctions.dummyWait(5);
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL successful");
            if(!currentURL.isEmpty()&& currentURL.contains(title)) {
                isSharingInlineStoryTwSuccessful = true;
            }
            commonFunctions.closeAllWindowsExceptMasterTabGen();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSharingInlineStoryTwSuccessful;
    }

    
    @Override
    public boolean  checkSocialSharingFunctionality() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean firstStory = commonFunctionsMobile.clickOnFirstStory(firstStoryTitle);
        commonFunctions.clickElementIfDisplayed(closeOption,5,"Cross Icon");
        commonFunctions.clickElementIfDisplayed(acceptCookie,5,"Accept Cookies");
        commonFunctions.scrollToElementView(shareIcon, 20, "Share Icon");
        commonFunctions.clickElementIfDisplayed(shareIcon, 5, "Share Icon");
        boolean inLineStoryTwitter = commonFunctions.isElementDisplayed(listOfSharingOption.get(2),5,"Twitter share Option in Story");
        //checkSharingInlineStoryOnSocialMedia(listOfSharingOption.get(2), "twitterShareOptionInlineStory", "twitter.com",2);
        boolean inLineStoryFacebook = commonFunctions.isElementDisplayed(listOfSharingOption.get(1), 5, "Twitter share Option in Story");
        boolean copyUrl = commonFunctionsMobile.clickOnCopyIconAndCheckUrlCopied(shareIcon,copyUrlToShareAllOptions);
        boolean sharingLinkedin = checkSharingStoryOnSocialMedia(listOfSharingOption.get(3), "linkedinSharingAllOptions", "linkedin.com");
        return copyUrl && sharingLinkedin && inLineStoryTwitter && inLineStoryFacebook;
    }
	@Override
	public boolean checkSocialSharingWithWhatsappAndGmail() {
		// TODO Auto-generated method stub
		return false;
	}
    @Override
    public boolean socialSharingInStoryPage(String params[]) {
        return false;
    }

    @Override
    public boolean checkSocialSharingIconsClickable() {
        return commonFunctionsMobile.checkSocialSharingIconsClickableMWeb(explore, indiaNews, firstStoryTitle, shareIcon, listOfSharingOption, copyUrlToShareAllOptions);
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageBySearch() {
        return false;
    }

    @Override
    public boolean checkTwitterWhatsappDisplayInStoryPageFromRelatedTopics() {
        return false;
    }
}
