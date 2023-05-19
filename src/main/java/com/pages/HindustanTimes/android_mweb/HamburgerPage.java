package com.pages.HindustanTimes.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonBookmarkPage;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.Utils;

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
    @FindBy(id = "fbmBtn")
    private static WebElement continueWithFacebookButton;
    @FindBy(id = "phoneEmail") 
    private static WebElement emailTextBoxMainSignInPage;
    @FindBy(id = "btSubmit")
    private static WebElement continueButtonSignInPage;
    @FindBy(id = "upass")
    private static WebElement passwordTextBoxMainSignInPage;
    @FindBy(id = "btnLogin") 
    private static WebElement signInButtonMainSignInPage;
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
    @FindBy(xpath = "//input[@type='submit']") 
    private static WebElement loginButtonFacebookSignInPage;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private static WebElement nextButtonGmailSignInPage;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private static WebElement nextButtonGmailPasswordPage;
    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private static WebElement passwordTextBoxGmailSignInPage;
    @FindBy(xpath = "(//div[@class='logged-in']//span[2])[1]")
    private static WebElement userNameLabelAfterLogin;
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

    @FindBy(xpath="//div[@class='btnExplore']")
    private static WebElement hamburgerButton;

    @FindBy(xpath="//div[@class='nav-sec']//a//em")
    private static List<WebElement> hamburgerMenuOptions;

    @FindBy(xpath="//div[@class='nav-sec']//em[text()='Entertainment']")
    private static WebElement entertainmentOption;

    @FindBy(xpath="//ul[contains(@class,'nav-expanded')]//li//a[@href]")
    private static List<WebElement> exploreHTList;

    @FindBy(xpath="//ul[contains(@class,'nav-expanded')]")
    private static WebElement exploreHT;

    @FindBy(xpath="//a[contains(@data-id,'world-news')]/em")
    private static WebElement worldNewsOption;


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
                    isHamburgerMenuAllOptionsDisplayed = hamburgerMenuOptions.get(i).isDisplayed();
                    commonFunctions.scrollToElementView(hamburgerMenuOptions.get(i),20,"hamburgerOptions");
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
            isClickOnEntertainmentSuccessful = commonFunctions.clickElement(entertainmentOption, 20,"entertainmentOption");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isClickOnEntertainmentSuccessful;
    }

    public boolean checkRedirectionToEntertainmentSection()  {
        boolean isRedirectToEntertainmentSuccessful=false;
        try{
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL Successful");
            if(currentURL.equals(globalVars.getProdUrl()+"entertainment")) {
                isRedirectToEntertainmentSuccessful = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isRedirectToEntertainmentSuccessful;
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

        return clickOnHamburger && checkHamburgerMenuOptions && clickEntertainmentSection && checkEntertainmentRedirection;
    }

	@Override
	public boolean checkHamberburgerCases() {
		return false;
	}

	@Override
	public boolean clickOnExplorerMenu() throws Exception {
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
	public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public boolean clickWorldNewsSectionOnHamburgerMenu() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(hamburgerButton,20,"Hamburger menu button");
//        boolean clickOnHamburger=clickOnHamburgerButton();
        boolean clickWorldNewsSection=clickOnWorldNewsSection();
        boolean checkWorldNewsSectionRedirection=checkRedirectionToWorldNewsSection();
        commonFunctions.pressAndroidBackKey();

        return clickWorldNewsSection && checkWorldNewsSectionRedirection;
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

    public boolean checkRedirectionToWorldNewsSection()  {
        boolean isRedirectToWorldNewsSuccessful=false;
        try{
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL Successful");
            if(currentURL.equals(globalVars.getProdUrl()+"world-news")) {
                isRedirectToWorldNewsSuccessful = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isRedirectToWorldNewsSuccessful;
    }

    @Override
    public boolean checkExploreHTOptionDisplayedOnHamburgerMenu() {
        return commonFunctionsMobile.verifyExploreOptionsInHamburger(hamburgerButton, exploreHT, exploreHTList);
        /*boolean isCheckExploreHTOptionDisplayedOnHamburgerMenu=true;
        commonFunctions.navigateToURL(globalVars.getURL());
        clickOnHamburgerButton();
        commonFunctions.scrollToElement(exploreHT,"Explore HT");
        isCheckExploreHTOptionDisplayedOnHamburgerMenu &= commonFunctions.isElementDisplayed(exploreHT,20,"Explore HT");
        isCheckExploreHTOptionDisplayedOnHamburgerMenu &= scrollToViewElementWithLinks(exploreHTList);
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

    public boolean scrollToViewElementWithLinks(List<WebElement> elementList)
    {
        boolean isElementDisplayTrue = false;
        String text=null;
        for(WebElement ele: elementList)
        {
            text=commonFunctions.getElementText(ele,20);
            commonFunctions.scrollToElement(ele,text);
            if(ele.isDisplayed())
            {
                isElementDisplayTrue=true;
            }
            else
            {
                isElementDisplayTrue=false;
            }
        }
        return isElementDisplayTrue;
    }
}
