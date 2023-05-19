package com.pages.LiveMint.commonFunctions;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.utils.GlobalVars;
import com.utils.RestUtils;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class CommonFunctionsWebLM {
    private static int tryCount = 0;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWebLM commonFunctionsWeb;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsMobile commonFunctionsMob;
    private static DriverController driverController;

    public static CommonFunctionsWebLM getInstance() {
        driverController = DriverController.getInstance();
        if (commonFunctionsWeb == null) {
            commonFunctionsWeb = new CommonFunctionsWebLM();
        }
        return commonFunctionsWeb;
    }

    public CommonFunctionsWebLM() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsMob = CommonFunctionsMobile.getInstance();
    }



    public boolean checkShareIconsPolitics(WebElement explore, WebElement politics, WebElement firstStory, WebElement iconsBox, List<WebElement> iconsList) {
        boolean isShowing=commonFunctionsMob.clickElementWithJS(explore,10,"explore" );
        commonFunctions.dummyWait(2);
        commonFunctionsMob.scrollToElement(politics, 15, "Politics Section");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctionsMob.clickElementWithJS(politics, 10, "Politics");
        commonFunctions.dummyWait(2);
        commonFunctionsMob.scrollToElement(firstStory, 15, "Politics first story");
        commonFunctionsMob.dummyWait(5);
        commonFunctions.isElementDisplayedAndPresent(firstStory,10,"first story");
        isShowing &=commonFunctionsMob.clickElementWithJS(firstStory, 10, "Politics First Story");
        commonFunctionsMob.dummyWait(5);
        commonFunctionsMob.scrollToElement(iconsBox, "Share Icons Box");
        isShowing &=commonFunctions.isElementDisplayedOfListOfElements(iconsList, "Social Share Icons");
        return isShowing;
    }

    public boolean navigateToPageThroughLhsNav(WebElement pagetoOpen, String pageName) {
        boolean topNavpageOpened = false;
        commonFunctions.navigateToURL(globalVars.getURL());
       commonFunctions.clickElementWithJS(pagetoOpen, 10, pageName + " link in Top Nav");
       commonFunctions. checkTextContainByCurrentURL(pageName, pageName);

        return topNavpageOpened;
    }
    public boolean checkStory(WebElement FistStory,WebElement FirstStoryHeadline)
    {
        boolean isShowing=commonFunctions.isElementDisplayed(FistStory,10,"Page On First Story");
        String Headline = commonFunctions.getElementText(FistStory);
        String Header =commonFunctions.getElementText(FirstStoryHeadline);
        isShowing = commonFunctions.checkTextContains(Header,Headline,"First Story verified list/card view");

        return isShowing;
    }
    public boolean checkWSJ (WebElement pageLogo, WebElement exploreMenu, WebElement ePaper,  WebElement NotificationIcon,  WebElement timestamp,WebElement PageTitle)
    {
        boolean isLinkDisplayed = false;
        try {

            isLinkDisplayed = commonFunctions.isElementDisplayed(pageLogo, 10, "Mintlogo");
            isLinkDisplayed &=commonFunctions. isElementDisplayed(exploreMenu, 10, "Exploremenu ");
            isLinkDisplayed &=commonFunctions. isElementDisplayed(ePaper, 10, "Epaper CTA");
            isLinkDisplayed &=commonFunctions. isElementDisplayed(timestamp, 10, "Current Date WSJ");
            isLinkDisplayed &=commonFunctions. isElementDisplayed(NotificationIcon, 10, "Notification CAT");
            isLinkDisplayed &=commonFunctions.isElementDisplayed(PageTitle,10,"PageTitle");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return isLinkDisplayed;

    }


    public boolean checkParagraphOnPoliticsPageStory(WebElement explore, WebElement politics, WebElement firstStoryImg, WebElement firstPara) {
        boolean isShowing=commonFunctionsMob.clickElementWithJS(explore,10,"explore" );
        commonFunctionsMob.scrollToElement(politics, 15, "Politics Section");
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctionsMob.clickElement(politics, 10, "Politics");
        isShowing &=commonFunctionsMob.clickElementWithJS(firstStoryImg, 10, "First Story");
        commonFunctionsMob.dummyWait(5);
        commonFunctionsMob.scrollToElement(firstPara, 20, "Story Page First Para");
        isShowing &=commonFunctionsMob.isElementDisplayed(firstPara, 10, "Story Page First Para");
        return isShowing;
    }




    public boolean checkShareIconsOnCompaniesStory(WebElement explore, WebElement companies, WebElement firstStory, WebElement iconsBox, List<WebElement> iconsList) {
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 15, "Explore" );
        commonFunctions.scrollToElement(companies, "Companies Section");
        isShowing &=commonFunctions.clickElementWithJS(companies, 10, "Companies");
        isShowing &=commonFunctions.clickElementWithJS(firstStory, 10, "First Story");
        commonFunctions.scrollToElement(iconsBox, "Share Icons Box");
        isShowing &=commonFunctions.isElementDisplayedOfListOfElements(iconsList, "Social Share Icons");
        return isShowing;
    }


    public boolean checkCompaniesPageLayout(WebElement explore, WebElement companies, WebElement firstStory, WebElement firstHeadline,WebElement secondStory,WebElement secondStoryHeadline) {
        boolean isShowing=commonFunctions.clickElementWithJS(explore, 15, "Explore" );
        commonFunctions.scrollToElement(companies, "Companies Section");
        isShowing &=commonFunctions.clickElementWithJS(companies, 10, "Companies");
        isShowing &=commonFunctions.isElementDisplayed(firstStory, 10, "First Story");
        isShowing &=commonFunctions.isElementDisplayed(firstHeadline, 10, "First Story Headline");
        isShowing &=commonFunctions.isElementDisplayed(secondStory, 10, "Second Story");
        isShowing &=commonFunctions.isElementDisplayed(secondStoryHeadline, 10, "Second Story Headline");
        return isShowing;
    }
    public boolean TopNav(WebElement pageTitle, WebElement iconMenu, WebElement epaperIcon) {
        boolean isShowing =commonFunctions.isElementDisplayed(pageTitle, 10, "mint logo");
        isShowing &= commonFunctions.isElementDisplayed(iconMenu, 30, "Icon Menu should be displayed");
        isShowing &= commonFunctions.isElementDisplayed(epaperIcon, 30, "Epaper icon need to be displayed in top Nav");
        return isShowing;
    }


    public boolean checkSummaryOnCompaniesPage(WebElement explore, WebElement companies, WebElement firstStoryImg, WebElement summary) {
        boolean isShowing=commonFunctionsMob.clickElementWithJS(explore,10,"explore" );
        commonFunctionsMob.scrollToViewElement(companies, "Companies Section", 15);
        isShowing &=commonFunctionsMob.clickElementWithJS(companies, 10, "Companies");
        commonFunctionsMob.dummyWait(3);
        commonFunctionsMob.scrollToViewElement(firstStoryImg, "first story Section", 15);
        commonFunctionsMob.dummyWait(3);
        isShowing &=commonFunctionsMob.clickElementWithJS(firstStoryImg, 10, "First Story");
        commonFunctionsMob.dummyWait(5);
        isShowing &=commonFunctionsMob.scrollToElementView(summary, 20, "Story Page Summary");
        return isShowing;
    }


    public boolean checkParagraphOnCompaniesStory(WebElement explore, WebElement companies, WebElement firstStoryImg, WebElement firstPara) {
        boolean isShowing=commonFunctionsMob.clickElementWithJS(explore,10,"explore" );
        commonFunctionsMob.scrollToElement(companies, 15, "Companies Section");
        isShowing &=commonFunctionsMob.clickElementWithJS(companies, 10, "Companies");
        commonFunctionsMob.scrollToElement(firstStoryImg, 15, "first story Section");
        commonFunctionsMob.dummyWait(5);
        isShowing &=commonFunctionsMob.clickElementWithJS(firstStoryImg, 10, "First Story");
        commonFunctionsMob.dummyWait(5);
        commonFunctionsMob.scrollToElement(firstPara, 20, "Story Page First Para");
        isShowing &=commonFunctionsMob.isElementDisplayed(firstPara, 10, "Story Page First Para");
        return isShowing;
    }


    public boolean checkMastHeadOnOpinionPage(WebElement explore, WebElement opinion, WebElement mastHeadAd) {
        boolean isShowing=commonFunctionsMob.clickElementWithJS(explore,10,"explore" );
        commonFunctionsMob.scrollDownToElement(opinion);
        isShowing &=commonFunctionsMob.clickElementWithJS(opinion, 10, "Opinion");
        commonFunctionsMob.dummyWait(5);
        isShowing &=commonFunctionsMob.isElementDisplayed(mastHeadAd, 10, "Mast Head");
        return isShowing;
    }



    public boolean checkSummaryOnPoliticsPageStory(WebElement explore, WebElement politics, WebElement firstStoryImg, WebElement summary) {
        boolean isShowing=commonFunctionsMob.clickElementWithJS(explore,10,"explore" );
        commonFunctions.dummyWait(2);
        commonFunctionsMob.scrollToElement(politics, 15, "Politics Section");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctionsMob.clickElement(politics, 10, "Politics");
        commonFunctions.dummyWait(5);
        commonFunctionsMob.scrollToElement(firstStoryImg, 10, "first story image");
        commonFunctions.dummyWait(2);
        isShowing &=commonFunctionsMob.clickElementWithJS(firstStoryImg, 10, "First Story");
        commonFunctionsMob.dummyWait(5);
        commonFunctionsMob.scrollToElement(summary, 20, "Story Page Summary");
        isShowing &=commonFunctionsMob.isElementDisplayed(summary, 10, "Story Page Summary");
        return isShowing;
    }



    public boolean checkSubNavOnPremiumPage(WebElement premium, List <WebElement> subNavTab) {
        boolean isShowing=commonFunctionsMob.clickElementWithJS(premium,10,"Premium" );
        commonFunctions.dummyWait(5);
        isShowing &=commonFunctionsMob.isElementDisplayedOfListOfWebElements(subNavTab, "Premium Page Sub Nav");
        return isShowing;
    }
    public String getOTPForLogin(String apiURI ,String refreshAPI, String cookie,String accessAccount,Boolean OTPLimitReched)
    {
        String OTP="";
        boolean otpStatusCode = false;
        boolean refreshStatusCode=true;
        int otpAttempt=0;
        HashMap<String,String> header =new HashMap<>();
        header.put("Content-Type","application/json");
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
            Response response = RestUtils.sendGetRequestWithHeader(apiURI, "", header);
            otpStatusCode = response.getStatusCode() == 200;
            while (!(otpStatusCode && otpAttempt <= 1)) {
                response = RestUtils.sendGetRequestWithHeader(apiURI, "", header);
                otpAttempt++;
            }
            try{
            OTP = RestUtils.getValueFromResponse(response, "data");}
            catch (Exception e)
            {
                e.printStackTrace();
                OTP = "";
            }
        }
        return OTP;
    }
    public boolean checkL1NavMenu(WebElement pageTitle, WebElement homeNav, WebElement latestNav, WebElement newsnav, WebElement marketsNav, WebElement premiumNav, WebElement moneyNav, WebElement mutualFundsNav, WebElement industryNav, WebElement companiesNav, WebElement technologyNav, WebElement opinionNav,WebElement webStoriesNav){
        boolean isShowing =commonFunctions.isElementDisplayed(pageTitle, 10, "mint logo");
        isShowing &=commonFunctions.isElementClickable(homeNav,10,"Home nav visibility");
        isShowing &=commonFunctions.isElementClickable(latestNav,10,"latest nav");
        isShowing &=commonFunctions.isElementClickable(newsnav,10,"news nav visibility");
        isShowing &=commonFunctions.isElementClickable(marketsNav,10,"market nav visibility");
        isShowing &=commonFunctions.isElementClickable(premiumNav,10,"Premium nav visibility");
        isShowing &=commonFunctions.isElementClickable(moneyNav,10,"money nav visibility");
        isShowing &=commonFunctions.isElementClickable(mutualFundsNav,10,"Mutual funds nav visibility");
        isShowing &=commonFunctions.isElementClickable(industryNav,10,"Industry nav visibility");
        isShowing &=commonFunctions.isElementClickable(companiesNav,10,"Companies nav visibility");
        isShowing &=commonFunctions.isElementClickable(technologyNav,10,"technology nav visibility");
        isShowing &=commonFunctions.isElementClickable(opinionNav,10,"Opinion nav visibility");
        isShowing &=commonFunctions.isElementClickable(webStoriesNav,10,"webstories nav visibility");

        return isShowing;


    }

    public boolean openExploremenu(WebElement explore,  WebElement photos)
    {
        boolean isShowing=commonFunctions.clickElement(explore, 15, "Explore" );
       commonFunctions.scrollToViewElement(photos,"Photos section",10);
       isShowing &=commonFunctions.clickElementWithJS(photos,10,"photos");
        return isShowing;
    }

    public boolean topNavElments(WebElement pageTitle, WebElement iconMenu, WebElement epaperIcon, WebElement Searchiocn) {
        boolean isShowing =commonFunctions.isElementDisplayed(pageTitle, 10, "mint logo");
        isShowing &= commonFunctions.isElementDisplayed(iconMenu, 30, "Icon Menu should be displayed");
        isShowing &= commonFunctions.isElementDisplayed(epaperIcon, 30, "Epaper icon need to be displayed in top Nav");
       isShowing &= commonFunctions.isElementDisplayed(Searchiocn,30,"Searchiocn icon need to be displayed on the top nav");
        return isShowing;
    }
    public boolean checkLHSWidgetDisplayed(String pageName,String widgetName, WebElement widgetContainer,WebElement widgetDate, List<WebElement> widgetDataLinks, WebElement lhsWidgetCTA1, WebElement lhsWidgetCTA2)
    {
        boolean isElementDisplayed;
        String pageURL= globalVars.getURL()+pageName;
        commonFunctions.navigateToURL(pageURL);
        commonFunctions.scrollToElementView(widgetContainer,10,widgetName+" widget");
        isElementDisplayed=commonFunctions.isElementDisplayed(widgetContainer,10,widgetName +" Widget");
        isElementDisplayed &= commonFunctions.isElementDisplayed(widgetDate,10,widgetName+" date");
        switch (widgetName){
            case "GainerLoser" :
                isElementDisplayed &= widgetDataLinks.size()==10;
                isElementDisplayed &= commonFunctions.isElementDisplayed(lhsWidgetCTA1,10,widgetName+" CTA1");
                isElementDisplayed &= commonFunctions.isElementDisplayed(lhsWidgetCTA2,10,widgetName+" CTA2");
                break;
            case "52WeekHighLow":
                isElementDisplayed &= widgetDataLinks.size()<=10;
                isElementDisplayed &= commonFunctions.isElementDisplayed(lhsWidgetCTA1,10,widgetName+" CTA1");
                isElementDisplayed &= commonFunctions.isElementDisplayed(lhsWidgetCTA2,10,widgetName+" CTA2");
                break;
            case "ActiveStocks":
                isElementDisplayed &= widgetDataLinks.size()==10;
                break;

        }

        return isElementDisplayed;

    }




}

