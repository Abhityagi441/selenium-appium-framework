package com.pages.HindustanTimes.web;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.HindustanTimes.generic.CommonMoreFromSectionPage;
import com.utils.ApiValidation;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MoreFromSectionPage extends CommonMoreFromSectionPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static ApiValidation apiValidation;
    public static String storyName;

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


    @FindBy(xpath = "//span[contains(@class,'bookmark-candidate')]")
    private static WebElement bookmarkButton;

    @FindBy(xpath = "//a[text()='Saved']")
    private static WebElement savedLink;


    @FindBy(xpath = "//span[contains(@class,'bookmark-candidate')]//preceding::h3//a")
    private static WebElement storyTitle;

    @FindBy(xpath = "//span[contains(@class,'bookmark morebm')]//preceding::h3//a")
    private static WebElement savedStoryTitle;

 //   @FindBy(xpath = "(//div[contains(@class,'readFull')])[1]")
    @FindBy(xpath ="//a[contains(text(),'READ FULL')]")
   // @FindBy(xpath = "//div[@class='actionDiv']/div[2]")
    private static WebElement openFullStory;

    @FindBy(xpath = "//div[@class='storyShortDetail']//div[contains(@class,'catName')]")
    private static WebElement section;

    @FindBy(xpath = "//div[@class='storyShortDetail']//h3[@class='hdg3']")
    private static WebElement headline;

    @FindBy(xpath = "//div[@class='storyShortDetail']//div[@class='sortDec']")
    private static WebElement summary;

    @FindBy(xpath = "//a[contains(text(),'READ')]")
    private static WebElement openFullStorySaved;

    @FindBy(xpath = "//div[contains(@class,'storyDetails')]//div//p")
    private static WebElement paragraph;

    @FindBy(xpath = "//div[contains(@class,'shareIcons')]")
    private static WebElement shareIcons;

    @FindBy(xpath = "//div[contains(@class,'storyTopics')]")
    private static WebElement topics;

    //@FindBy(xpath = "//a[contains(@class,'closeStory')]")
    @FindBy(xpath = "//a[contains(@class,'closeStory close-btn')]")
    private static WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class,'hdg2')]")
    private static WebElement moreFromSection;

    @FindBy(xpath = "//div[@class='storyBy']")
    private static WebElement storyBy;

    /*public static String qaaut513 = "/api/articles/";
    Response response;*/


    public  MoreFromSectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();

        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    public boolean clickReadFullStory(){
        boolean isStep=false;
        commonFunctions.scrollUsingAction(openFullStory,"");
        storyName=commonFunctions.getElementText(storyTitle);
        isStep=commonFunctions.clickElement(openFullStory);
        Utils.logStepInfo(isStep, "read full story successful");
        return isStep;
    }

    public boolean checkMoreFromSection(String expectedUserName) {
        boolean isMoreFromThisSection;
        isMoreFromThisSection = commonFunctions.checkElementText(moreFromSection, expectedUserName, 20, "More from this section");
        return isMoreFromThisSection;

    }

    public boolean checkClose() {

        boolean isStep = false;
        commonFunctions.scrollUsingAction(closeButton,"");
        isStep = commonFunctions.clickElement(closeButton);
        Utils.logStepInfo(isStep, "check close button successful");
        return isStep;
    }


}

