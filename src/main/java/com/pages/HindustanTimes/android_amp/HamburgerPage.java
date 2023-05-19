package com.pages.HindustanTimes.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamburgerPage extends CommonHamburgerPage {

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

    @FindBy(xpath="//div[@class='btnExplore']/button")
    private static WebElement hamburgerButton;

    @FindBy(className = "crossicon")
    private static WebElement crossBtn;

    @FindBy(xpath="//div[@class='nav-sec']//a//em")
    private static List<WebElement> hamburgerMenuOptions;

    @FindBy(xpath="//a[@data-vars-event-label='Entertainment']//em")
    private static WebElement entertainmentOption;

    @FindBy(xpath="//a[contains(@data-id,'world-news')]/em")
    private static WebElement worldNewsOption;

    @FindBy(xpath="//ul[contains(@class,'nav-expanded')]")
    private static WebElement exploreHT;

    @FindBy(xpath="//ul[contains(@class,'nav-expanded')]//li//a[@href]")
    private static List<WebElement> exploreHTList;


    public HamburgerPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean clickOnHamburgerButton() {
        boolean isExplorermenuClickSuccessful=false;
        try{
            isExplorermenuClickSuccessful= commonFunctions.clickElementWithJS(hamburgerButton, 20,"hamburgerButton");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExplorermenuClickSuccessful;
    }

    public boolean checkHamburgerMenuAllOptionDisplayed()  {
        boolean isHamburgerMenuAllOptionsDisplayed=false;
        try{
            int menuNamesCount = hamburgerMenuOptions.size();
            for(int i=0;i< 10;i++) {
                String menuName = hamburgerMenuOptions.get(i).getText();
                if(!menuName.isEmpty()) {
                    isHamburgerMenuAllOptionsDisplayed=hamburgerMenuOptions.get(i).isDisplayed();
                    if(isHamburgerMenuAllOptionsDisplayed) {
                        commonFunctions.elementToTextDisplayed(menuName);
                    } else {
                        isHamburgerMenuAllOptionsDisplayed=false;
                    }
                }

            }
        }catch(Exception e){
            e.printStackTrace();
            isHamburgerMenuAllOptionsDisplayed =false;
        }
        return isHamburgerMenuAllOptionsDisplayed;
    }

    public boolean clickOnEntertainmentSection()  {
        boolean isClickOnEntertainmentSuccessful=false;
        try{
            isClickOnEntertainmentSuccessful = commonFunctions.clickElementWithJS(entertainmentOption, 20,"entertainmentOption");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isClickOnEntertainmentSuccessful;
    }

    public boolean clickOnWorldNewsSection()  {
        boolean isClickOnWorldNewsSuccessful=false;
        try{
            isClickOnWorldNewsSuccessful = commonFunctions.clickElementWithJS(worldNewsOption, 20,"worldNewsOption");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isClickOnWorldNewsSuccessful;
    }

    public boolean checkRedirectionToEntertainmentSection()  {
        boolean isRedirectToEntertainmentSuccessful=false;
        try{
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL Successful");
            if(currentURL.equals(globalVars.getProdUrl()+"entertainment/amp")) {
                isRedirectToEntertainmentSuccessful = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isRedirectToEntertainmentSuccessful;
    }

    public boolean checkRedirectionToWorldNewsSection()  {
        boolean isRedirectToWorldNewsSuccessful=false;
        try{
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL Successful");
            System.out.println("CurrentURL = "+currentURL);
            System.out.println("Redirect URL = "+globalVars.getURL()+"world-news");
            if(currentURL.contains("world-news")) {
                isRedirectToWorldNewsSuccessful = true;
                Utils.logStepInfo(isRedirectToWorldNewsSuccessful, "Redirect to Work News page");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isRedirectToWorldNewsSuccessful;
    }
    @Override
    public boolean checkAnySectionPage() {
        return false;
    }

    @Override
    public boolean checkIndiaNewsPageScrollable() {
        return false;
    }

    @Override
    public boolean checkHamburgerElementsClickable() {
        commonFunctions.navigateToURL(globalVars.getURL());
        boolean clickOnHamburger=clickOnHamburgerButton();
        boolean checkHamburgerMenuOptions=checkHamburgerMenuAllOptionDisplayed();
        boolean clickEntertainmentSection=clickOnEntertainmentSection();
        boolean checkEntertainmentRedirection=checkRedirectionToEntertainmentSection();
        commonFunctions.pressAndroidBackKey();

        return clickOnHamburger && checkHamburgerMenuOptions && clickEntertainmentSection && checkEntertainmentRedirection;
    }

	@Override
	public boolean checkHamberburgerCases() {
		return false;
	}

	@Override
	public boolean clickOnExplorerMenu() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationIndiaNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean breadcrumbDisplayedOtherThanHomePage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationPopularNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationCricketNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationEditorialNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationEntertainmentNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationCitiesNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNavigationLatestNews() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed(){
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean clickWorldNewsSectionOnHamburgerMenu() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(hamburgerButton, 20,"hamburgerButton");
        boolean clickWorldNewsSection = clickOnWorldNewsSection();
        boolean checkWorldNewsSectionRedirection = checkRedirectionToWorldNewsSection();
        commonFunctions.pressAndroidBackKey();
        return clickWorldNewsSection && checkWorldNewsSectionRedirection;
    }

    @Override
    public boolean checkExploreHTOptionDisplayedOnHamburgerMenu() {
        return commonFunctionsMobile.verifyExploreOptionsInHamburger(hamburgerButton, exploreHT, exploreHTList);
        /*commonFunctions.navigateToURL(globalVars.getURL());
        clickOnHamburgerButton();
        commonFunctions.scrollToElement(exploreHT,"Explore HT options");
        boolean isCheckExploreHTOptionDisplayedOnHamburgerMenu = commonFunctions.isElementDisplayed(exploreHT,20,"Explore HT");
        isCheckExploreHTOptionDisplayedOnHamburgerMenu &= commonFunctions.scrollToViewElementWithLinks(exploreHTList);
        return isCheckExploreHTOptionDisplayedOnHamburgerMenu;*/
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionsDisplayed() {
        return false;
    }


}
