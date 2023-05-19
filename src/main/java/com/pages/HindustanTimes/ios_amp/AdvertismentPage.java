package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonAdvertismentPage;
import com.pages.HindustanTimes.generic.CommonBreadCrumbsPage;
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

    @FindBy(xpath = "//a[text()='Entertainment']")
    private static WebElement entertainment;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(xpath = "(//div[@class='storyAd'])[1]")
    private static WebElement topAd;

    @FindBy(xpath = "(//div[@class='storyAd'])[3]")
    private static WebElement adAfterColl;

    @FindBy(xpath = "//div[@class='storyAd']/amp-ad")
    private static List<WebElement> adDispAfterColl;

    @FindBy(xpath = "//div[@id='adslot1']")
    private static WebElement beforeFirstAd;
    @FindBy(xpath = "(//div[@class='storyAd'])[3]")
    private static WebElement adAfterTopNewsColl;

    @FindBy(xpath = "//section[1]//section[1]//section[1]//div[@class='viewMoreButton']")
    private static WebElement endOfColl;

    @FindBy(className = "viewMoreButton")
    private static WebElement endOfCollAmp;
    @FindBy(xpath = "(//div[@class='viewMoreButton'])[1]")
    private static WebElement topNewsCollEnd;

    @FindBy(xpath = "(//div[@class='secHdg'])[1]")
    private static WebElement topNews;

    @FindBy(xpath = "//li//a[text()='Latest']")
    private static WebElement latestNews;

    @FindBy(xpath = "//a[text()='Most Read']")
    private static WebElement popularStory;

    @FindBy(xpath = "//div[@class='container']//button")
    private static WebElement hamBurger;

    @FindBy(className = "breadcrumbs")
    private static WebElement breadCrumbsName;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    private static WebElement redirectToHomepage;

    @FindBy(xpath = "//a//em[text()='Cricket']")
    private static WebElement cricket;

    @FindBy(xpath = "//a[text()='Editorials']")
    private static WebElement editorials;

    @FindBy(xpath = "//em[text()='Cities']")
    private static WebElement cities;

    @FindBy(xpath = "(//div[@class='storyAd'])[2]")
    private static WebElement firstAdvertisement;
    @FindBy(xpath = "(//div[@class='storyAd'])[2]/amp-ad")
    private static WebElement FirstAdImg;

    @FindBy(xpath = "(//img[@class='i-amphtml-fill-content i-amphtml-replaced-content'])[3]")
    private static WebElement embeds;

    @FindBy(xpath = "(//div[contains(@class,'storyAd')])[3]")
    private static WebElement secondAdvertisement;

    @FindBy(xpath="//div[contains(@class,'bigCart')]/h3/a")
    private static WebElement openFullStory;

    @FindBy(xpath="//a[contains(@data-id,'India')]")
    private static WebElement indiaNews;

    @FindBy(xpath = "//div[@class='detail']/p")
    private static List<WebElement> paragraphs;

    @FindBy(xpath = "//div[@class='storyAd']//amp-ad")
    private static List<WebElement> getAllAdsAfter3Article;

    @FindBy(xpath = "(//div[@class='storyAd']//amp-ad)[3]")
    private static WebElement thirdAdAfter3Art;

    @FindBy(xpath = "//h3[@class='hdg3']")
    private static List<WebElement> articles;

    @FindBy(xpath = "(//div[contains(@class,'cartHolder listView')])[2]")
    private static WebElement beforeSponsoredAd;

    @FindBy(className = "sponsor-ad")
    private static WebElement sponsoredAd;

    @FindBy(xpath="(//div[@class='storyAd']//amp-ad)[1]")
    private static WebElement loadPage;

    @FindBy(xpath = "(//div[@class='storyAd']//amp-ad)[2]")
    private static WebElement normalAd;


    public AdvertismentPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }


    @Override
    public boolean checkAdDisplayingAfterCollection() {
        return false;
    }

    @Override
    public boolean checkAdsDisplayInLineStory() {
        boolean firstAd = checkfirstAdVisibility();
        boolean correctWordCount = wordCountInBetweenAds();
        boolean secondAd = checkSecondAdvisiblity();
        return firstAd && correctWordCount && secondAd;
    }

    @Override
    public boolean checkAdDisplayingHomePage() {
        return false;
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

    @Override
    public boolean checkAdDisplayingAtEndOfFirstCollection() {
            boolean homePageLoad=scrollDowntoFirstCollectionTopNews();
            boolean HeaderFooterAds=scrollDowntoEndOfCollection();
            boolean firstAd=adDisplayingAfterEndofCollection();
            return homePageLoad && HeaderFooterAds && firstAd;
    }

    public boolean scrollDowntoFirstCollectionTopNews()  {
        boolean isTopNewsDisplayed = false;
        commonFunctions.scrollToElementView(topNews, 20, "topNews");
        isTopNewsDisplayed = commonFunctions.isElementDisplayed(topNews, 20, "topNews");
        return isTopNewsDisplayed;
    }


    public boolean scrollDowntoEndOfCollection()  {
        boolean isScrollTOEndOfColl = false;
        isScrollTOEndOfColl = commonFunctions.scrollToElementView(topNewsCollEnd, 20, "endOfColl");
        return isScrollTOEndOfColl;
    }


    public boolean adDisplayingAfterEndofCollection()  {
        boolean isAdDispAfterEndOfColl = false;
        commonFunctions.clickElementIfDisplayed(acceptCookie, 5, "accept cookie button");
        isAdDispAfterEndOfColl = commonFunctions.isElementDisplayed(adAfterTopNewsColl, 20, "adDispAfterColl");
        return isAdDispAfterEndOfColl;
    }

    public boolean checkfirstAdVisibility() {
        boolean firstAdv = false;
        commonFunctions.scrollToElementViewAndClick(openFullStory,10,"Read FullStory");
        commonFunctions.isElementDisplayed(topAd, 15, "First Ad");
        firstAdv =commonFunctions.scrollToElementView(firstAdvertisement,15,"Ad after 1st Para");
        return firstAdv;
    }

    public boolean  wordCountInBetweenAds() {
        boolean count = false;
        boolean isEmbedDisplayed = false;
        try {
            isEmbedDisplayed = commonFunctions.isElementDisplayed(embeds, 70, "Embed In Story");
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
            if (wordLength >= 120) {
                Utils.logStepInfo(true, "words in between ads are " + wordLength);
                count = true;
            }
        }
        return count;
    }

    public boolean checkSecondAdvisiblity() {
        commonFunctions.scrollToElementView(secondAdvertisement, 20,"Second Advertise after 120 words");
        return commonFunctions.isElementDisplayed(secondAdvertisement, 20);
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

    public boolean isNavigatedToIndiaNewsPage() {
        boolean isIndiaNewsClicked = false;
        try {
            commonFunctions.navigateToURL(globalVars.getAmpUrl());
            commonFunctions.clickElementWithJS(indiaNews, 15, "India News Amp");
            commonFunctions.dummyWait(5);
            String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
            if (currentURL.contains("india-news/amp")) {
                isIndiaNewsClicked = true;
            }
            /*Observation has found that sometime loading ads will take time and it will not load until refresh*/
            commonFunctions.refreshPage();
            commonFunctions.refreshPage();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isIndiaNewsClicked;
    }

    public boolean adAfterEveryThreeArt() {
        boolean isAdDispAfterEvery3Art = false;
        try {
            int countOfAdsAfter3Art = getAllAdsAfter3Article.size();
            for (int i = 0; i < countOfAdsAfter3Art-1; i++) {
                if(i>=2) {
                    int countArticles=articles.size();
                    for(int x =0; x< countArticles-1;x=x+3) {
                        if (x % 3 == 0) {
                            WebElement ad = getAllAdsAfter3Article.get(i);
                            commonFunctions.scrollToElementView(getAllAdsAfter3Article.get(i), 20, "getAllAdsAfter3Article");
                            if (ad.isEnabled() && ad.isDisplayed()) {
                                isAdDispAfterEvery3Art = true;
                                i++;
                                if(i== countOfAdsAfter3Art){
                                    break;
                                }
                            }
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdDispAfterEvery3Art;
    }

    public boolean clickOnAdAndCheckRedirection() {

        boolean isAdRedirectionSuccessful = false;
        try {
            commonFunctions.scrollToElementView(thirdAdAfter3Art, 20,"thirdAdAfter3Art");
            isAdRedirectionSuccessful = commonFunctions.isElementDisplayed(thirdAdAfter3Art, 20, "thirdAdAfter3Art");

           } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdRedirectionSuccessful;
    }

    public boolean scrollDownToFirstAdAfter3ArtClickVerify() {
        commonFunctions.scrollToElementView(normalAd, 20, "firstAdAfter3Art");
        return commonFunctions.isElementDisplayed(normalAd, 20, "firstAdAfter3Art");
    }

    @Override
    public boolean checkAdDisplayingAfterEveryCollection() {
        boolean navigateToIndiaNewspage = isNavigatedToIndiaNewsPage();
        boolean sponsoredAdv;
        commonFunctions.scrollToElementView(beforeSponsoredAd,15, "Scrolled till thirdArticle");
        sponsoredAdv=commonFunctions.isElementDisplayed(sponsoredAd,10,"Sponsored");
        if (sponsoredAdv==true){
            Utils.logStepInfo(true,"Sponsored Advertise available");
        }else{
            Utils.logStepInfo(false,"Sponsored Advertise not available");
        }
        boolean firstAd=scrollDownToFirstAdAfter3ArtClickVerify();
        boolean adAfterThreeArt = adAfterEveryThreeArt();
        boolean checkAdRedirection = clickOnAdAndCheckRedirection();
        return navigateToIndiaNewspage &&firstAd && adAfterThreeArt && checkAdRedirection;
    }

    @Override
    public boolean checkAdDisplayWordCountAndAdRedirection() {
        boolean TopAdv= checkAdDisplayingTopAd();
        boolean FirstCollection=scrollDownToFirstCollectionTopNews();
        boolean EndOfCollection=scrollDownToEndOfCollection();
        boolean AdvAtTheEndOfCollection=adDisplayingAfterEndOfCollection();
        boolean FirstAd=checkfirstAdVisibility();
        boolean CorrectWordCount=wordCountInBetweenAds();
        boolean secondAd=checkSecondAdvisibility();
        boolean RedirectionToAdv=checkAdvRedirection();

        return TopAdv && FirstCollection && EndOfCollection && AdvAtTheEndOfCollection &&
                FirstAd && secondAd &&CorrectWordCount && RedirectionToAdv;
    }

    @Override
    public boolean checkHeaderAdsAreDisplayed() {
        return false;
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

    public boolean checkAdDisplayingTopAd() {
        boolean isTopAd;
        isTopAd = commonFunctions.isElementDisplayed(topAd, 20, "topAd");
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
        isScrollTOEndOfColl = commonFunctions.scrollToElementView(adAfterColl, 20, "endOfColl");
        return isScrollTOEndOfColl;
    }


    public boolean adDisplayingAfterEndOfCollection() {
        boolean isAdDispAfterEndOfColl;
        commonFunctions.scrollToElementView(adDispAfterColl.get(1), 20, "endOfColl");
        isAdDispAfterEndOfColl = commonFunctions.isElementDisplayed(adDispAfterColl.get(1), 65, "adDispAfterColl");
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
        commonFunctions.scrollToElementView(FirstAdImg, 10, "Ad redirection");

        isRedirectionSuccessful= commonFunctions.clickElementWithJS(FirstAdImg,20);
        commonFunctions.waitForWindow(1,"new window");
        /*ArrayList<String> windowsList=new ArrayList<>(commonFunctions.getWindowHandlesWithExpectedNumberOfWindows(1));
        commonFunctions.switchToWindow(windowsList.get(windowsList.size()-1));*/
        String currentURL = commonFunctions.getCurrentURL("URL", "getCurrentURL successful");
        if(!currentURL.isEmpty()) {
            isRedirectionSuccessful = true;
        }
        commonFunctions.closeAllWindowsExceptMasterTabGen();
        return isRedirectionSuccessful ;
    }

}