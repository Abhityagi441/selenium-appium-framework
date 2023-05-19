package com.pages.HindustanTimes.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AdvertismentPage extends CommonAdvertismentPage {
    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "//div[@class='adMinHeight313']/following-sibling::p[count(.|//div[@class='adHeight313'][1]/preceding-sibling::p)=count(//div[@class='adHeight313'][1]/preceding-sibling::p)][last()]/following-sibling::div[@class='adHeight313'][1]")
    private static WebElement secondAdvertisement;

    @FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
    private static WebElement openFullStory;

    @FindBy(xpath = "(//div[@class='adMinHeight313'])[1]")
    private static WebElement firstAdvertisement;

    @FindBy(xpath = "(//div[contains(@class,'embed')])[1]")
    private static WebElement embeds;

    @FindBy(xpath = "//div[@class='adMinHeight313']/following-sibling::p[count(.|//div[@class='adHeight313'][1]/preceding-sibling::p)=count(//div[@class='adHeight313'][1]/preceding-sibling::p)]")
    private static List<WebElement> paragraphs;

    @FindBy(xpath = "//section[1]/h2")
    private static WebElement topNews;

    @FindBy(xpath = "(//span[text()='View All'])[1]")
    private static WebElement viewAllText;

    @FindBy(xpath = "//section[contains(@class,'worldSection')][1]")
    private static WebElement topNewsCollection;

    @FindBy(xpath = "//section[2]/h2")
    private static WebElement endOfColl;

    @FindBy(xpath = "//div[@class='adHeight313'][1]")
    private static WebElement adDispAfterColl;

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads_iframe')])[3]")
    private static WebElement clickAdRedirection;

    @FindBy(xpath = "(//iframe[contains(@id,'google_ads_iframe')])[2]")
    private static WebElement adFrame;

    @FindBy(xpath = "(//div[contains(@class,'adHeight')])[1]")
    private static WebElement topAd;

    @FindBy(xpath = "//div[@id='adslot1']")
    private static WebElement beforeFirstAd;

    @FindBy(xpath = "(//div[@class='storyAd ht-ad']//iframe[@title='3rd party ad content'])[1]")
    private static WebElement firstAdAfter3Art;

    @FindBy(xpath = "//div[contains(@id,'adslot')]")
    private static List<WebElement> getAllAdsAfter3Article;

    @FindBy(xpath = "//div[@class='sponsor-ad']")
    private static WebElement sponsoredAd;

    @FindBy(xpath = "(//h2[@class='hdg3'])[3]")
    private static WebElement thirdArticle;

    public  AdvertismentPage(){
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }
    public boolean checkFirstAdVisibility() {
        boolean firstAdv;
        commonFunctions.scrollToElementViewAndClick(openFullStory,20,"Read FullStory");
        commonFunctions.dummyWait(10);
        commonFunctions.scrollUsingAction(firstAdvertisement, "First Advertise visible beneath the Lead Image");
        firstAdv = commonFunctions.isElementDisplayed(firstAdvertisement, 20, "First Advertisement");
        return firstAdv;
    }
    public boolean  wordCountInBetweenAds() {
        boolean count = false;
        boolean isEmbedDisplayed = false;
        try {
            isEmbedDisplayed = commonFunctions.isElementDisplayed(embeds, 20, "Embed In Story");
        } catch (Exception e) {
            e.printStackTrace();
            Utils.logStepInfo(false, "Embed Not Available");
        }
        if (!isEmbedDisplayed == true) {

            String[] words = getWords();
            int wordLength = words.length;
            if (wordLength >= 120) {
                Utils.logStepInfo(true, "words in between ads are " + wordLength);
                count = true;
            }
        } else {
            String[] words = getWords();
            int wordLength = words.length + 80;
            Utils.logStepInfo(true, "words in between ads are " + wordLength);
            count = true;
        }
        return count;
    }
    public String[] getWords() {
        int numberOfParagraphs = paragraphs.size();
        String wordCount = "";
        for (int i = 0; numberOfParagraphs > i; i++) {
            String temp = commonFunctions.getElementText(paragraphs.get(i));
            wordCount = wordCount + temp;
        }
        String[] words = wordCount.split(" ");
        return words;
    }
    public boolean checkSecondAdvisiblity() {
        commonFunctions.scrollToElementView(secondAdvertisement, 20,"Second Advertise after 120 words");
       commonFunctions.dummyWait(10);
        return commonFunctions.isElementDisplayed(secondAdvertisement, 20, "Second Advertisement");
    }


    public boolean scrollDowntoFirstCollectionTopNews()  {
        boolean isTopNewsDisplayed = false;
            commonFunctions.scrollToElementView(topNews, 20, "topNews");
            isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNews, 20, "topNews");
        return isTopNewsDisplayed;
    }

    public boolean scrollDowntoEndOfCollection()  {
        boolean isScrollTOEndOfColl = false;
            isScrollTOEndOfColl = commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
        return isScrollTOEndOfColl;
    }

    public boolean adDisplayingAfterEndofCollection()  {
        boolean isAdDispAfterEndOfColl = false;
            isAdDispAfterEndOfColl = commonFunctions.isElementDisplayed(adDispAfterColl, 20, "adDispAfterColl");
        return isAdDispAfterEndOfColl;
    }

    public boolean isNavigatedToAdPage() {
            commonFunctions.navigateToURL(globalVars.getURL() + "india-news");
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            return currentURL.equals(globalVars.getURL() + "india-news");
    }

    public boolean adAfterEveryThreeArt() {
        boolean isAdDispAfterEvery3Art = false;
            int countOfAdsAfter3Art = getAllAdsAfter3Article.size();
            for (int i = 0; i < countOfAdsAfter3Art; i++) {
                WebElement ad = getAllAdsAfter3Article.get(i);
                commonFunctions.scrollToElementView(getAllAdsAfter3Article.get(i), 20, "getAllAdsAfter3Article");
                if (ad.isEnabled() && ad.isDisplayed()) {
                    commonFunctions.elementToElementDisplayed(ad);
                    isAdDispAfterEvery3Art = true;
                }
            }
        return isAdDispAfterEvery3Art;
    }

    public boolean scrollDownToFirstAdAfter3ArtClickVerify() {
            commonFunctions.scrollToElementView(firstAdAfter3Art, 20, "firstAdAfter3Art");
           return commonFunctions.isElementDisplayed(firstAdAfter3Art, 20, "firstAdAfter3Art");
    }

    public boolean checkAdRedirection(){
        boolean isRedirectionSuccessful;
        commonFunctions.scrollToElementView(firstAdAfter3Art, 10, "Ad redirection");
        isRedirectionSuccessful= commonFunctions.clickElementWithActions(firstAdAfter3Art,20);
        commonFunctions.waitForWindow(2,"new window");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if(!currentURL.isEmpty()) {
            isRedirectionSuccessful = true;
        }
        commonFunctions.closeAllWindowsExceptMasterTabGen();
        return isRedirectionSuccessful ;
    }

    @Override
    public boolean checkAdDisplayingAfterEveryCollection() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean navigateToAdpage = isNavigatedToAdPage();
        boolean sponsoredAdv;
        commonFunctions.scrollUsingAction(thirdArticle,"Sponsored Advertisment");
        sponsoredAdv=commonFunctions.isElementDisplayed(sponsoredAd,10,"Sponsored");
        if (sponsoredAdv==true){
            Utils.logStepInfo(true,"Sponsored Advertise available");
        }else{
            Utils.logStepInfo(false,"Sponsored Advertise not available");
        }
        boolean firstAd = scrollDownToFirstAdAfter3ArtClickVerify();
        boolean adAfterThreeArt = adAfterEveryThreeArt();
        boolean adRedirection=checkAdRedirection();
        return navigateToAdpage && adAfterThreeArt && firstAd && adRedirection ;
    }

    @Override
    public boolean checkAdDisplayingAfterCollection() {return false; }

    @Override
    public boolean checkAdsDisplayInLineStory() {
        commonFunctions.navigateURl(globalVars.getURL());
        commonFunctions.waitForURLToBe(globalVars.getURL());
        commonFunctions.dummyWait(5);
        boolean firstAd = checkFirstAdVisibility();
        boolean secondAd = checkSecondAdvisiblity();
        return firstAd && secondAd;
    }
    public boolean checkfirstAdVisibilityReadFullStory() {
        boolean firstAdv = false;
        commonFunctions.scrollToElementViewAndClick(openFullStory,20,"Read Full Story");
        commonFunctions.scrollUsingAction(firstAdvertisement, "First Advertise visible beneath the Lead Image");
        firstAdv = commonFunctions.isElementDisplayed(firstAdvertisement, 20);
        return firstAdv;
    }

    public boolean isRedirectedToAdPage(){
        boolean isRedirectionSuccessful;
        commonFunctions.scrollToElementView(secondAdvertisement, 10, "Ad redirection");
        isRedirectionSuccessful=commonFunctions.clickElementWithJS(secondAdvertisement,10,"Ad redirection");
        commonFunctions.waitForWindow(2,"new window");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if(!currentURL.isEmpty()) {
            isRedirectionSuccessful = true;
        }
        commonFunctions.closeAllWindowsExceptMasterTabGen();
        return isRedirectionSuccessful ;
        }


    @Override
    public boolean checkAdDisplayingHomePage() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean isScrollToFirst = scrollDowntoFirstCollectionTopNews();
        boolean isScrollToEnd = scrollDowntoEndOfCollection();
        boolean isAdDisplayedEnd = adDisplayingAfterEndofCollection();
        boolean isReadFullStoryAd = checkfirstAdVisibilityReadFullStory();
        boolean isCountDisplayed = wordCountInBetweenAds();
        boolean isRedirectedSuccessful = isRedirectedToAdPage();
        return isScrollToFirst && isScrollToEnd && isAdDisplayedEnd && isReadFullStoryAd
                 && isCountDisplayed && isRedirectedSuccessful;
    }

    @Override
    public boolean checkAdDisplayingAtEndOfFirstCollection() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean homePageLoad=scrollDowntoFirstCollectionTopNews();
        boolean HeaderFooterAds=scrollDowntoEndOfCollection();
        boolean firstAd=adDisplayingAfterEndofCollection();
        return homePageLoad && HeaderFooterAds && firstAd;
    }
    @Override
    public boolean checkAdsInlineStories() {
        return false;
    }

    @Override
    public boolean checkAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkAdDisplayingHomePageTopAd() {
        return false;
    }

    public boolean checkAdDisplayingTopAd() {
        boolean isTopAd;
        commonFunctions.dummyWait(5);
        isTopAd = commonFunctions.isElementDisplayed(topAd, 20, "Top Ad");
        return isTopAd;
    }

    public boolean scrollDownToFirstCollectionTopNews() {
        boolean isTopNewsDisplayed;
        commonFunctions.scrollToElementView(topNews, 20, "topNews");
        isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNews, 20, "topNews");
        return isTopNewsDisplayed;
    }

    public boolean scrollDownToEndOfCollection() {
        boolean isScrollTOEndOfColl;
        commonFunctions.scrollToElementView(beforeFirstAd, 20, "beforeFirstAd");
        commonFunctions.scrollToElementView(adDispAfterColl, 20, "adDispAfterColl");
        isScrollTOEndOfColl = commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
        return isScrollTOEndOfColl;
    }

    public boolean adDisplayingAfterEndOfCollection() {
        boolean isAdDispAfterEndOfColl;
        commonFunctions.scrollToElementView(endOfColl, 20, "endOfColl");
        isAdDispAfterEndOfColl = commonFunctions.isElementDisplayed(adDispAfterColl, 65, "adDispAfterColl");
        return isAdDispAfterEndOfColl;
    }

    public boolean checkSecondAdvisibility() {
        commonFunctions.scrollToElementView(secondAdvertisement, 20,"Second Advertise after 120 words");
        int size=paragraphs.size();
        Utils.logStepInfo("Second Ad using updated locater "+size);
        return commonFunctions.isElementDisplayed(secondAdvertisement, 20);
    }

    public boolean checkAdvRedirection(){
        boolean isRedirectionSuccessful;
        commonFunctions.scrollToElementView(firstAdvertisement, 10, "Ad redirection");
        isRedirectionSuccessful= commonFunctions.clickElementWithActions(firstAdvertisement,20);
        commonFunctions.waitForWindow(2,"new window");
        ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(2));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if(!currentURL.isEmpty()) {
            isRedirectionSuccessful = true;
        }
        commonFunctions.closeAllWindowsExceptMasterTabGen();
        return isRedirectionSuccessful ;
    }

    @Override
    public boolean checkAdDisplayWordCountAndAdRedirection() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean TopAdv=checkAdDisplayingTopAd();
        boolean FirstCollection=scrollDownToFirstCollectionTopNews();
        boolean EndOfCollection=scrollDownToEndOfCollection();
        boolean AdvAtTheEndOfCollection=adDisplayingAfterEndOfCollection();
        boolean FirstAd=checkFirstAdVisibility();
        boolean CorrectWordCount=wordCountInBetweenAds();
        boolean secondAd=checkSecondAdvisibility();
        boolean RedirectionToAdv=checkAdvRedirection();

        return TopAdv && FirstCollection && EndOfCollection && AdvAtTheEndOfCollection &&
                FirstAd && secondAd &&CorrectWordCount && RedirectionToAdv;
    }
    @Override
    public boolean checkHeaderAdsAreDisplayed() {
       commonFunctions.navigateToURL(globalVars.getURL());
        boolean topAdvHomePage = checkAdDisplayingTopAd();
        commonFunctions.navigateToURL(globalVars.getURL()+"entertainment");
        commonFunctions.waitForURLContains("entertainment");
        boolean topAdvSectionPage = checkAdDisplayingTopAd();
        commonFunctions.navigateToURL(globalVars.getURL()+"entertainment/bollywood");
        commonFunctions.waitForURLContains("bollywood");
        boolean topAdvSubSectionPage = checkAdDisplayingTopAd();

        return topAdvHomePage && topAdvSectionPage && topAdvSubSectionPage;
    }

    @Override
    public boolean checkHeaderAdisDisplayed() {
        return false;
    }

    @Override
    public boolean checkHomePageRHSAdsAreDisplayed() {
        return false;
    }

    @Override
    public boolean checkTopAdDisplayOnEverySection() {
        return false;
    }
}
