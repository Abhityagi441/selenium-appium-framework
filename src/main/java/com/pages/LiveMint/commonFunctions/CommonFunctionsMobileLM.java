package com.pages.LiveMint.commonFunctions;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import com.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.restassured.response.Response;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class CommonFunctionsMobileLM {
    private static AppiumDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobileLM commonFunctionsMobile;
    private static CommonFunctionsMobile commonFunctions;
    private static DriverController driverController;

    public static CommonFunctionsMobileLM getInstance() {
        if (commonFunctionsMobile == null) {
            commonFunctionsMobile = new CommonFunctionsMobileLM();
        }
        driver = globalVars.getAppiumDriver();
        driverController = DriverController.getInstance();
        return commonFunctionsMobile;
    }

    public CommonFunctionsMobileLM() {
        globalVars = GlobalVars.getInstance();
        commonFunctions = CommonFunctionsMobile.getInstance();
    }

    public boolean checkOpenAppStory(WebElement firstImage, WebElement openApp) {
        boolean isShowing=commonFunctions.clickElementWithJS(firstImage, 10, "Story" );
        isShowing &=commonFunctions.isElementDisplayed(openApp, 10, "Open App");
        return isShowing;
    }

    public boolean checkOpenAppSection(WebElement markets, WebElement openApp) {
        boolean isShowing=commonFunctions.clickElementWithJS(markets, 10, "Story" );
        isShowing &=commonFunctions.isElementDisplayed(openApp, 10, "Open App");
        return isShowing;
    }

    public boolean checkOpenAppSubSection(WebElement explore,WebElement companiesDown,WebElement companiesNews,WebElement openApp) {
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 15, "Explore" );
        isShowing &=commonFunctions.clickElementWithJS(companiesDown, 10, "Companies Menu" );
        isShowing &=commonFunctions.clickElementWithJS(companiesNews, 10, "Companies News Subsection" );
        isShowing &=commonFunctions.isElementClickable(openApp, 10, "Open App");
        return isShowing;
    }

    public boolean checkMarketsTopNav(WebElement markets, WebElement mintLogo, WebElement explore, WebElement getApp, WebElement epaperIcon, WebElement signIn) {
        boolean isShowing=commonFunctions.clickElementWithJS(markets, 15, "Markets" );
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctions.isElementDisplayed(mintLogo, 5, "Mint Logo on markets page");
        isShowing &=commonFunctions.isElementDisplayed(explore, 5, "Explore Menu on markets page");
        isShowing &=commonFunctions.isElementDisplayed(getApp, 5, "Get App button on markets page");
        isShowing &=commonFunctions.isElementDisplayed(epaperIcon, 5, "Epaper Icon on markets page");
//        isShowing &=commonFunctions.isElementDisplayed(signIn, 5, "SignIn Button on markets page");
        return isShowing;

    }

    public boolean clickOnExploreHamburger(MobileElement homeBtn, MobileElement exploreBtn, MobileElement explorePage) {
        commonFunctions.clickElement(homeBtn, 10, "home tab");
        commonFunctions.clickElement(exploreBtn, 10, "Explore Bottom");
        return commonFunctions.isElementDisplayedWithoutTryCatch(explorePage, 10, "explore page title");
    }

    public boolean clickOnExploreMarketDashboardAndVerifyPage(MobileElement marketDashboardBtn,MobileElement marketDashboardPage) {
        boolean isShowing = commonFunctions.isElementDisplayed(marketDashboardBtn, 10, "market dashboard");
        commonFunctions.clickElement(marketDashboardBtn, 10, "market Dashboard");
        isShowing &= commonFunctions.isElementDisplayed(marketDashboardPage, 10, "market page title");
        return isShowing;
    }

    public boolean clickOnExploreMintPremiumAndVerifyPage(MobileElement mintPremiumBtn,MobileElement premiumPage) {
        boolean isShowing = commonFunctions.isElementDisplayed(mintPremiumBtn, 10, "mint premium");
        commonFunctions.clickElement(mintPremiumBtn, 10, "mint premium");
        isShowing &= commonFunctions.isElementDisplayed(premiumPage, 10, "premium page title");
        return isShowing;
    }

    public boolean clickOnExplorePodcastAndVerifyPage(MobileElement podcastBtn,MobileElement podcastPage) {
        boolean isShowing = commonFunctions.isElementDisplayed(podcastBtn, 10, "podcast");
        commonFunctions.clickElement(podcastBtn, 10, "podcast");
        isShowing &= commonFunctions.isElementDisplayed(podcastPage, 10, "podcast page title");
        return isShowing;
    }
    public boolean freeNewslettersSubscriptionFlow(WebElement freeNewslettersCard,WebElement getCryptoNotesPlusIcon,WebElement singInButton){
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(freeNewslettersCard,10,"Free Newsletters card");
        isShowing &= commonFunctions.clickElementWithJS(getCryptoNotesPlusIcon, 10, "cryptonotes subscribe button");
        isShowing &= commonFunctions.isElementDisplayed(singInButton, 10, "login page");
        isShowing &= commonFunctions.clickElementWithJS(getCryptoNotesPlusIcon, 10, "cryptonotes subscribe button");
        commonFunctions.navigateBack();
        return isShowing;
    }
    public boolean paidNewslettersSubscriptionFlow(WebElement paidNewslettersCard,WebElement getMintMoneyPlusIcon,WebElement planPage ){
        boolean isShowing;
        isShowing = commonFunctions.isElementDisplayed(paidNewslettersCard,10,"Paid Newsletters card");
        isShowing &= commonFunctions.clickElementWithJS(getMintMoneyPlusIcon, 10, "editor choice subscribe button");
        isShowing &=commonFunctions.isElementDisplayed(planPage, 10, "Plan page");
        commonFunctions.navigateBack();
        return isShowing;
    }
    public boolean checkStory(WebElement FistStory,WebElement FirstStoryHeadline)
    {
        boolean isShowing=commonFunctions.isElementDisplayed(FistStory,10,"Page On First Story");
        String Headline = commonFunctions.getElementText(FistStory);
        String Header =commonFunctions. getElementText(FirstStoryHeadline);
        isShowing = commonFunctions.checkTextContains(Header,Headline,"First Story verified list view");

        return isShowing;
    }

    public boolean navigateToPageThroughExploremenu(WebElement explore, WebElement pagetoOpen, String pageName) {
        boolean SectionpageOpened;
        commonFunctions.navigateToURL(globalVars.getURL());
        SectionpageOpened = commonFunctions.clickElementWithJS(explore, 10, "Explore link");
        commonFunctions.scrollToViewElement(pagetoOpen, "Scroll to Element View",15);
        SectionpageOpened &= commonFunctions.clickElement(pagetoOpen, 10, pageName + " link in Explore Menu");
        return SectionpageOpened;
    }
    public boolean checkMwebPagelout(WebElement pagelogo, WebElement exploreMenu, WebElement ePaper, WebElement getAppCta,WebElement PageTitle) {

        boolean isLinkDisplayed = false;
        try {

            isLinkDisplayed = commonFunctions.isElementDisplayed(pagelogo, 10, "mint logo");
            isLinkDisplayed &=commonFunctions. isElementDisplayed(exploreMenu, 10, "Icon Menu should be displayed ");
            isLinkDisplayed &=commonFunctions. isElementDisplayed(ePaper, 10, "Epaper icon need to be displayed in top Nav");
            isLinkDisplayed &=commonFunctions. isElementDisplayed(getAppCta, 10, "Open App");
            isLinkDisplayed &=commonFunctions.isElementDisplayed(PageTitle,10,"PageTitle");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isLinkDisplayed;

    }
    public boolean waitForURLContains(String text) {
        boolean urlFound=false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains(text));
            urlFound=true;

        } catch (Exception e) {
            e.printStackTrace();
            urlFound=false;
        }
        return urlFound;
    }

    public boolean clickNotificationPopUpOnInterceptException(WebElement element,String elementName, int timeout)
    {
        boolean notificationClicked;
        try {
            commonFunctions.clickElement(element,timeout, elementName);
            notificationClicked=true;
        }
            catch(Exception e)
            {e.printStackTrace();
                notificationClicked=false;
        }

        return notificationClicked;
    }

    public boolean clickElement(WebElement element,WebElement interceptElement, int timeOut, String elementName,String interceptelementName) {
        boolean elementClicked;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));

            elementClicked=commonFunctions.clickElementWithJS(element,timeOut,elementName);


        }
        catch(org.openqa.selenium.ElementClickInterceptedException ie)
        {
            clickNotificationPopUpOnInterceptException(interceptElement,interceptelementName,timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Utils.logStepInfo(true, "click on " + elementName + " successfully");
            elementClicked=true;

        }
        return elementClicked;
    }

    public void clickElementIgnoringStaleElementReferenceException(WebElement element, int timeOut, String elementName) {

        Actions actions = new Actions(driver);
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOut)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        //actions.moveToElement(element).click().build().perform();
        element.click();
        Utils.logStepInfo(true, "click on " + elementName + " successfully");
    }
    public boolean isElementDisplayed(WebElement element, int timeOut, String elementName) {
        boolean isElementDisplayed = false;
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                isElementDisplayed = true;
                Utils.logStepInfo(true, elementName + " displayed successfully");
            } else {
                Utils.logStepInfo(false, elementName + " displayed failed");
            }
        } catch (Exception e) {
            Utils.logStepInfo(false, elementName + " displayed failed");
            System.out.println("************** Exception in isElementDisplayed() method : " + e.getMessage());

        }
        return isElementDisplayed;
    }
    public String getOTPForLogin(String apiURI ,String refreshAPI, String cookie,String accessAccount,Boolean OTPLimitReched)
    {
        String OTP="";
        boolean otpStatusCode = false;
        boolean refreshStatusCode=true;
        int otpAttempt=0;
        HashMap<String,String> header =new HashMap<>();
        //header.put("Content-Type","application/json");
        header.put("Cookie",cookie);
        header.put("accessAccount", accessAccount);
        if(OTPLimitReched) {
            /*Refresh OTP count API*/
            header.remove("Cookie",cookie);
            Response response1 = RestUtils.sendGetRequestWithHeader(refreshAPI,"",header);
            refreshStatusCode=response1.getStatusCode()==200;
        }
        if(refreshStatusCode) {
            /*get OTP from API*/
            header.put("Cookie",cookie);
            Response response = RestUtils.sendGetRequestWithHeader(apiURI, "", header);
            otpStatusCode = response.getStatusCode() == 200;
            while (!otpStatusCode && otpAttempt <= 1) {
                response = RestUtils.sendGetRequestWithHeader(apiURI, "", header);
                otpAttempt++;
            }
            try{
            OTP = RestUtils.getValueFromResponse(response, "data");}
            catch (Exception e)
            {
                OTP="";
                e.printStackTrace();
            }
        }
        else{
            Utils.logStepInfo(false,"status code for refresh call is not 200 but : "+ refreshStatusCode);
        }
        return OTP;
    }


    public String getOTPForLogin(String apiURI , String cookie,String accessAccount)
    {
        String OTP="";
        HashMap<String,String> header =new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Cookie",cookie);
        header.put("accessAccount", accessAccount);
            /*get OTP from API*/
            Response response = RestUtils.sendGetRequestWithHeader(apiURI,"",header);
            OTP = RestUtils.getValueFromResponse(response, "data");
        return OTP;
    }

    public void doubleBackToHomePage() {
       commonFunctions.navigateBack();
       commonFunctions.dummyWait(2);
       commonFunctions.navigateBack();
   }
    public boolean topNavpalace(WebElement pageTitle, WebElement iconMenu, WebElement epaperIcon,WebElement Searchiocn) {
        boolean isShowing =commonFunctions.isElementDisplayed(pageTitle, 10, "mint logo");
        isShowing &= commonFunctions.isElementDisplayed(iconMenu, 30, "Icon Menu should be displayed");
        isShowing &= commonFunctions.isElementDisplayed(epaperIcon, 30, "Epaper icon need to be displayed in top Nav");
        isShowing &= commonFunctions.isElementDisplayed(Searchiocn,30,"Searchiocn icon need to be displayed on the top nav");
        return isShowing;
    }

}


