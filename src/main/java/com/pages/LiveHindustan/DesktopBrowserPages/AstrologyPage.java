package com.pages.LiveHindustan.DesktopBrowserPages;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonAastrologyPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.json.XML;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AstrologyPage extends CommonAastrologyPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLH commonFunctionsWebLH;

    private static final String dharmInHindi = "धर्म";
    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a[@title='धर्म']")
    private static WebElement astrology;

    @FindBy(xpath = "//*[@class='wdgt-subtitle1']")
    private static List<WebElement> astrologyWidgits;

    @FindBy(xpath = "(//h1[@class='page-hdng'])[1]")
    private static WebElement astrologyWidgitsHeading;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//h2/a")
    private static List<WebElement> allWidgetsLinksOnHomePage;
    @FindBy(xpath = "//nav[contains(@class,'crsel')]//a")
    private static List<WebElement> allSubOptionOnDharamPage;
    @FindBy(xpath = "//span[@class='brd-crum-last']")
    private static WebElement breadcrumbLastWord;
    @FindBy(xpath = "//article[@class='rashis-sngl']//a[@class='read-more']")
    private static WebElement firstRashiPuraPadheyLink;
    @FindBy(xpath = "//div[@id='rashi-crsl']//a")
    private static List<WebElement> rashiFalLinks;
    @FindBy(xpath = "//div[contains(@class,'brd-crum mrgn-lr')]")
    private static WebElement pageBreadcrumb;
    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a")
    private static List<WebElement> topMenuOptions;
    @FindBy(xpath = "//div[contains(@class,'rashifal-wrap')]/h2/span")
    private static WebElement rashifalWidgetHeading;
    @FindBy(xpath = "//article[@class='rashis-sngl']//div[@class='rght']/a")
    private static List<WebElement> rashifalWidgetLinks;
    @FindBy(xpath = "//nav//a[text()='राशिफल']")
    private static WebElement rashifalLink;
    @FindBy(xpath = "//div[contains(@class,'rashifal-wrap common-bg clearfix')]//a[@class='read-more']")
    private static List<WebElement> puraPadheyLinks;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> astrologyL2SubMenu;

    @FindBy(xpath = "//article[@class='rashis-sngl']/div/div[@class='rght']/a")
    private static List<WebElement> rashiList;

    @FindBy(xpath = "//a[@class='read-more']")
    private static List<WebElement> rashiPuraPadheList;

    @FindBy(xpath = "//div[@class='rashi tabs crsel']/a")
    private static List<WebElement> rashiTabsList;

    @FindBy(xpath = "//div[@class='single-rashi-content']/p[not(@class='rashi-date')]")
    private static List<WebElement> rashiTabsParaList;

    @FindBy(xpath = "//div[@class='single-rashi-content']/p[@class='rashi-date']")
    private static List<WebElement> rashiTabsDateList;

    @FindBy(xpath = "//section[@class='rashis-blk']//article")
    private static List<WebElement> rashiCountList;
    @FindBy(xpath = "//section[@class='rashis-blk']//article//a[@class='read-more']")
    private static WebElement firstRashiReadMoreButton;
    private static final String entertainmentHindi = "धर्म";


    public AstrologyPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLH = CommonFunctionsWebLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    @Override
    public boolean checkAstrologyLandingPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollPageWithJS(astrology, 10);
        commonFunctions.clickElementWithJS(astrology, 10, "Astrology");
        commonFunctions.waitForPageToLoad();
        return verifyAstrologyWidgetsLinksStatus();
    }

    public boolean verifyAstrologyWidgetsLinksStatus(){
        boolean flag = false;
        for(int i=0;i<astrologyWidgits.size();i=i+3){
            commonFunctions.scrollToViewElement(astrologyWidgits.get(i), "Widgit", 10);
            String subHeading=astrologyWidgits.get(i).getText().trim();
            String subHeadingArray[]=subHeading.split(" ");
            commonFunctions.clickElementWithJS(astrologyWidgits.get(i), 10, "Widgits");
            commonFunctions.waitForPageToLoad();
            commonFunctions.isElementDisplayed(astrologyWidgitsHeading, 20);
            String heading = astrologyWidgitsHeading.getText().trim();
            int count=0;
            for(int j=0;j<subHeadingArray.length;j++){
                if(heading.contains(subHeadingArray[j])){
                    count = count+1;
                }
            }
            if(count>2){
                flag = true;
                driver.navigate().back();
                commonFunctions.waitForPageToLoad();
                commonFunctions.dummyWait(5);
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
    @Override
    public boolean checkRashiFalLinks() {
        boolean isAllRashifalLinksPresent = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctionsWebLH.clickElementWithGivenText(topMenuOptions, entertainmentHindi);
        commonFunctions.waitForPageToLoad();
        commonFunctions.moveToElementWithActions(rashifalWidgetHeading, 10, rashifalWidgetHeading.getText());
        commonFunctions.dummyWait(2);
        boolean isRashifalWidgetPresent = commonFunctions.isElementDisplayedAndPresent(rashifalWidgetHeading, 10, rashifalWidgetHeading.getText());
        if (rashifalWidgetLinks.size() == 12) {
            for (int i = 0; i < rashifalWidgetLinks.size(); i++)
                isAllRashifalLinksPresent &= commonFunctions.isElementDisplayed(rashifalWidgetLinks.get(i), 10, rashifalWidgetLinks.get(i).getText().trim());
        }
        else
        {
            isAllRashifalLinksPresent = false;
        }
        String expectedURL = commonFunctions.getAttributeValue(rashifalWidgetLinks.get(0), 5, "href");

        commonFunctions.moveToElementWithActions(firstRashiPuraPadheyLink,5,firstRashiPuraPadheyLink.getText());
        commonFunctions.clickElementWithJS(firstRashiPuraPadheyLink);
        commonFunctions.waitForPageToLoad();
        boolean isURLCorrect = commonFunctions.getCurrentURL().contains(expectedURL);
        boolean isRashiFalActive = commonFunctions.compareTexts(rashifalLink.getAttribute("class"), "active");
        return isRashifalWidgetPresent && isAllRashifalLinksPresent && isURLCorrect && isRashiFalActive;
    }

    @Override
    public boolean checkRashiFalPage() {
        boolean isLandingOnToDharamPageTrue = isLandingPageIsAstrology();
        commonFunctionsWebLH.clickElementWithGivenText(allSubOptionOnDharamPage, "राशिफल");
        boolean isUrlChangesTrue = commonFunctions.getCurrentURL().contains("astrology/rashifal/");
        boolean isLandingOnToRashiFalPageTrue = commonFunctions.getElementText(breadcrumbLastWord, 5).contains("राशिफल");
        String urlBeforeClickOnPuraPadheyLink = commonFunctions.getCurrentURL();
        commonFunctions.moveToElementWithActions(puraPadheyLinks.get(0), 10, "First " + puraPadheyLinks.get(0).getText());
        commonFunctions.clickElement(puraPadheyLinks.get(0), 10, "First " + puraPadheyLinks.get(0).getText());
        boolean isUrlChangedAfterClickOnPuraPadheyLink = !commonFunctions.getCurrentURL().equalsIgnoreCase(urlBeforeClickOnPuraPadheyLink);
        return isUrlChangesTrue && isLandingOnToRashiFalPageTrue && isLandingOnToDharamPageTrue && isUrlChangedAfterClickOnPuraPadheyLink;
    }

    public boolean isLandingPageIsAstrology() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctionsWebLH.clickElementWithGivenText(allWidgetsLinksOnHomePage, dharmInHindi);
        boolean isUrlChangesTrue = commonFunctions.getCurrentURL().contains("/astrology/");
        boolean isLandingOnToDharamPageTrue = commonFunctions.getElementText(pageBreadcrumb, 5).contains(dharmInHindi);
        return isLandingOnToDharamPageTrue && isUrlChangesTrue;
    }

    @Override
    public boolean checkAllSubMenuArePresentAndGiving200StatusCodeOnAstrologyPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollPageWithJS(astrology, 10);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(astrology, 10, "Astrology");
        commonFunctions.waitForPageToLoad();
        String astrologyUrl = commonFunctions.getCurrentURL();
        int astrologyL2SubMenuSize = astrologyL2SubMenu.size();
        boolean astrologyStatus = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(astrologyL2SubMenu, astrologyL2SubMenuSize, astrologyUrl);
        return astrologyStatus;
    }

    @Override
    public boolean checkDataIsDisplayedUnderDifferentTabsOnSelectedRashi(){
        boolean paraStatus = true;
        boolean dateStatus = true;
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollPageWithJS(astrology, 10);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(astrology, 10, "Astrology");
        commonFunctions.waitForPageToLoad();
        String astrologyUrl = commonFunctions.getCurrentURL();
        int puraPadheSize = rashiPuraPadheList.size();

        for(int i = 0; i < puraPadheSize; i++){
            commonFunctions.scrollToElement(rashiList.get(i), "Rashi");
            commonFunctions.dummyWait(2);
            String rashiTitle = commonFunctions.getAttributeValue(rashiList.get(i), 10, "title");
            commonFunctions.clickElementWithJS(rashiPuraPadheList.get(i), 10, "Pura Padhe for:- "+rashiTitle);
            commonFunctions.dummyWait(5);
            commonFunctions.waitForPageToLoad();

            int tabSize = rashiTabsList.size();
            for(int j = 0; j < tabSize; j++){
                commonFunctions.scrollToElement(rashiTabsList.get(j), "Tabs");
                commonFunctions.dummyWait(2);
                String tabTitle = commonFunctions.getAttributeValue(rashiTabsList.get(j), 10, "title");
                commonFunctions.clickElementWithJS(rashiTabsList.get(j), 10, tabTitle);
                commonFunctions.dummyWait(2);

                if(commonFunctions.getElementText(rashiTabsDateList.get(j)).trim().isEmpty() || commonFunctions.getElementText(rashiTabsDateList.get(j)).trim() == null || commonFunctions.getElementText(rashiTabsDateList.get(j)).trim().equals("")){
                    if(!tabTitle.trim().equalsIgnoreCase("साप्ताहिक")) {
                        dateStatus &= false;
                        System.out.println(rashiTitle + " --> Date is not displayed for :- " + tabTitle);
                        Utils.logStepInfo(rashiTitle + " --> Date is not displayed for :- " + tabTitle);
                        break;
                    }
                }

                if(commonFunctions.getElementText(rashiTabsParaList.get(j)).trim().isEmpty() || commonFunctions.getElementText(rashiTabsParaList.get(j)).trim() == null || commonFunctions.getElementText(rashiTabsParaList.get(j)).trim().equals("")){
                    paraStatus &= false;
                    System.out.println(rashiTitle+" --> Paragraph is not displayed for :- "+tabTitle);
                    Utils.logStepInfo(rashiTitle+" --> Paragraph is not displayed for :- "+tabTitle);
                    break;
                }

            }

            commonFunctions.navigateToURL(astrologyUrl);
            commonFunctions.waitForPageToLoad();
        }

        return dateStatus && paraStatus;
    }

    public boolean checkClickingOnAnyRashiRedirectsToCorrectURLOnRashifalDetailPage()
    {
        boolean isRashiCountTwelve;
        boolean isLandingOnToDharamPageTrue = isLandingPageIsAstrology();
        commonFunctionsWebLH.clickElementWithGivenText(allSubOptionOnDharamPage, "राशिफल");
        commonFunctions.dummyWait(2);
        commonFunctions.scrollToElement(rashiCountList.get(0),"First Rashi on Astrology Page");
        commonFunctions.dummyWait(2);
        int rashiCount = rashiCountList.size();
        if(rashiCount==12);
        {
            isRashiCountTwelve = true;
        }
        String expectedURL = commonFunctions.getAttributeValue(firstRashiReadMoreButton,2,"href");
        commonFunctions.clickElementWithJS(firstRashiReadMoreButton,5,"First Rashi Read more button");
        commonFunctions.waitForPageToLoad();
        boolean redirectionToRashiPage = commonFunctions.compareTexts(commonFunctions.getCurrentURL(),expectedURL);

        return isLandingOnToDharamPageTrue && isRashiCountTwelve && redirectionToRashiPage;
    }
}
