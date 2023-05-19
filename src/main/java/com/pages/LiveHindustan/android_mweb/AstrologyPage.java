package com.pages.LiveHindustan.android_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.ConstantPackage.LHConstants;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonAastrologyPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class AstrologyPage extends CommonAastrologyPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobileLH;

    @FindBy(xpath = "//nav[@class='wrap hdr-menu']/a[@title='धर्म']")
    private static WebElement astrology;

    @FindBy(xpath = "//*[@class='wdgt-subtitle1']")
    private static List<WebElement> astrologyWidgits;

    @FindBy(xpath = "(//h1[@class='page-hdng'])[1]")
    private static WebElement astrologyWidgitsHeading;
    @FindBy(xpath = "//div[contains(@class,'wdgt-nav pg-nav')]//a")
    private static List<WebElement> allSubOptionOnDharamPage;
    @FindBy(xpath = "//span[@class='brd-crum-last']")
    private static WebElement breadcrumbLastWord;
    @FindBy(xpath = "//article[@class='rashis-sngl']//a[@class='read-more']")
    private static WebElement firstRashiPuraPadheyLink;
    @FindBy(xpath = "//div[@id='rashi-crsl']//a")
    private static List<WebElement> rashiFalLinks;
    @FindBy(xpath = "//a[@title='धर्म']/ancestor::div/child::div[@class='wdgt-wrap']//a")
    private static List<WebElement> dharamRelatedStoryLinks;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='धर्म']")
    private static WebElement dharamWidgetTitle;
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

    @FindBy(xpath = "//a[@class='read-more']")
    private static List<WebElement> rashiPuraPadheList;

    @FindBy(xpath = "//div[@class='rashi tabs crsel']/a")
    private static List<WebElement> rashiTabsList;

    @FindBy(xpath = "//div[@class='single-rashi-content']/p[not(@class='rashi-date')]")
    private static List<WebElement> rashiTabsParaList;

    @FindBy(xpath = "//div[@class='single-rashi-content']/p[@class='rashi-date']")
    private static List<WebElement> rashiTabsDateList;

    @FindBy(xpath = "//article[@class='rashis-sngl']/div/div[@class='rght']/a")
    private static List<WebElement> rashiList;

    @FindBy(xpath = "//section[@class='rashis-blk']//article")
    private static List<WebElement> rashiCountList;
    @FindBy(xpath = "//section[@class='rashis-blk']//article//a[@class='read-more']")
    private static WebElement firstRashiReadMoreButton;
    private static final String entertainmentHindi = "धर्म";

    public AstrologyPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkAstrologyLandingPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(astrology, "धर्म");
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

        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        return commonFunctionsMobileLH.checkRashiFalLinksForMweb(topMenuOptions,entertainmentHindi,rashifalWidgetHeading,rashifalWidgetLinks,firstRashiPuraPadheyLink,rashifalLink);
    }
    @Override
    public boolean checkRashiFalPage() {
        boolean isLandingOnToDharamPageTrue = isLandingPageIsAstrology();
        commonFunctionsMobileLH.clickElementWithGivenText(allSubOptionOnDharamPage, "राशिफल");
        return commonFunctionsMobileLH.checRashiFalPageOnMweb(breadcrumbLastWord,puraPadheyLinks) && isLandingOnToDharamPageTrue;
    }

    public boolean isLandingPageIsAstrology() {
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.scrollDownToElement(dharamRelatedStoryLinks.get(0));
        commonFunctions.clickElementWithJS(dharamWidgetTitle, 10, LHConstants.DHARM_IN_HINDI);
        boolean isUrlChangesTrue = commonFunctions.getCurrentURL().contains("/astrology/");
        boolean isLandingOnToDharamPageTrue = commonFunctions.getElementText(pageBreadcrumb, 5).contains(LHConstants.DHARM_IN_HINDI);
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
        boolean astrologyStatus = commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(astrologyL2SubMenu, astrologyL2SubMenuSize, astrologyUrl, "MenuValuesForRandomNumber");
        return astrologyStatus;
    }

    @Override
    public boolean checkDataIsDisplayedUnderDifferentTabsOnSelectedRashi(){
        boolean paraStatus = true;
        boolean dateStatus = true;

        int startingPoint;
        int increasingPoint;

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("PuriKhabarPadheValuesForRandomNumber");
        String startingMinValue = params.get("StartingMinValue");
        String startingMaxValue = params.get("StartingMaxValue");
        String incresingMinValue = params.get("IncresingMinValue");
        String incresingMaxValue = params.get("IncresingMaxValue");
        String startingDefaultValue = params.get("StartingDefaultValue");
        String increasingDefaultValue = params.get("IncreasingDefaultValue");

        String randomFlag = params.get("RandomFlagValue");

        if(randomFlag.trim().equalsIgnoreCase("y")) {

            int startingMin = Integer.parseInt(startingMinValue);
            int startingMax = Integer.parseInt(startingMaxValue);
            int incresingMin = Integer.parseInt(incresingMinValue);
            int incresingMax = Integer.parseInt(incresingMaxValue);
            int startingDefault = Integer.parseInt(startingDefaultValue);
            int increasingDefault = Integer.parseInt(increasingDefaultValue);

            if (startingMin == startingMax || startingMin > startingMax) {
                startingPoint = startingDefault;
            } else {
                startingPoint = commonFunctionsMobileLH.returnRandomInt(startingMin, startingMax);
            }

            if (incresingMin == incresingMax || incresingMin > incresingMax) {
                increasingPoint = increasingDefault;
            } else {
                increasingPoint = commonFunctionsMobileLH.returnRandomInt(incresingMin, incresingMax);
                if (increasingPoint == 0) {
                    increasingPoint = increasingDefault;
                }
            }

            if (increasingPoint == 0) {
                increasingPoint = 1;
            }
        }else{
            startingPoint = 0;
            increasingPoint = 1;
        }


        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollPageWithJS(astrology, 10);
        commonFunctions.dummyWait(2);
        commonFunctions.clickElementWithJS(astrology, 10, "Astrology");
        commonFunctions.waitForPageToLoad();
        String astrologyUrl = commonFunctions.getCurrentURL();
        int puraPadheSize = rashiPuraPadheList.size();

        for(int i = startingPoint; i < puraPadheSize; i = i+increasingPoint){
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
        boolean isLandingOnToDharamPageTrue = isLandingPageIsAstrology();
        return isLandingOnToDharamPageTrue && commonFunctionsMobileLH.checkClickingOnAnyRashiRedirectsToCorrectURLOnRashifalDetailPageOnMweb(allSubOptionOnDharamPage,rashiCountList,firstRashiReadMoreButton);
    }
}
