package com.pages.LiveMint.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveMint.commonFunctions.CommonFunctionsWebLM;
import com.pages.LiveMint.genericPages.CommonNewsLettersPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class NewsLettersPage extends CommonNewsLettersPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLM commonFunctionsLM;

    @FindBy(xpath = "//a[@href='/newsletters']")
    private static WebElement explorenewsletter;

    @FindBy(id = "hamburgerElement")
    private static WebElement explore;

    @FindBy(xpath = "//a[@title='mint']")
    private static WebElement pageTitle;

    @FindBy(id = "hamburgerElement")
    private static WebElement hamburgericon;

    @FindBy(xpath = "//div[@class='headContent']")
    private static WebElement NewsletterHeadContent;

    @FindBy(xpath = "//div[@class='nlHolder'][1]")
    private static WebElement FreeNewsletters;
    @FindBy(xpath = "//div[@class='nlHolder'][2]")
    private static WebElement SubscriberOnlyNewsletters;
    @FindBy(xpath = "//div[@class='nlHolder'][3]")
    private static WebElement SubscribedNewsletters;

    @FindBy(xpath = "//div[@class='cardholder']")
    private static WebElement SubscriptionBanner;

    @FindBy(xpath = "//div[@class='nl_pp']")
    private static WebElement PrivacyPloicyTextDisplayed;

    @FindBy(xpath = "//div[@class='icoMenu']")
    private static WebElement iconMenu;
    @FindBy(xpath = "//div[@onclick='topSearch()']")
    private static WebElement SearchIcon;

    @FindBy(xpath = "//a[@class='icoBell iconSprite']")
    private static WebElement NotificationBellIcon;

    @FindBy(xpath = "//a[@class='epaperheader']")
    private static WebElement EpaperIcon;

    @FindBy(xpath = "//a[contains(@class,'userSignin')]")
    private static WebElement singInButton;

    @FindBy(xpath = "//div[@id='RFUHomeFeed']")
    private static WebElement rhsRFU;

    @FindBy(xpath = "//div[@class='rightBlock']")
    private static WebElement rhsPopularVideos;

    @FindBy(xpath = "//div[@id='rhsWSJ']")
    private static WebElement rhsWSJ;

    @FindBy(xpath = "//a[@id='fixedNav_home']")
    private static WebElement LHSHome;

    @FindBy(xpath = "//a[@id='fixedNav_latest']")
    private static WebElement LHSLatest;

    @FindBy(xpath = "//a[@id='fixedNav_popular']")
    private static WebElement LHSMarket;

    @FindBy(xpath = "//a[@id='exclusive']")
    private static WebElement LHSPremium;

    @FindBy(xpath = "//a[@id='fixedNav_foryou']")
    private static WebElement LHSForYou;

    @FindBy(xpath = "//li[@id='32']/div[2]/span/img")
    private static WebElement TOTMLogo;

    @FindBy(xpath = "//h2[@id='title_32']")
    private static WebElement TOTMTitle;

    @FindBy(xpath = "//li[@id='32']/p")
    private static WebElement TOTMDescr;

    @FindBy(xpath = "//li[@id='32']/div[3]/a")
    private static WebElement TOTMPreview;

    @FindBy(xpath = "//li[@id='32']/div[2]/a")
    private static WebElement TOTMPlusIcon;

    @FindBy(xpath = "//li[@id='32']/div[1]")
    private static WebElement daysOfWeek;

    @FindBy(xpath = "//li[@id='36']/div[1]")
    private static WebElement easynomicsDayOfWeeks;

    @FindBy(xpath = "//li[@id='35']/div[1]")
    private static WebElement cryptoNotesDaysOfWeeks;

    @FindBy(xpath = "//li[@id='34']/div[1]")
    private static WebElement companyOutsiderDaysOfWeeks;

    @FindBy(xpath = "//li[@id='33']/div[1]")
    private static WebElement tickerDaysOfWeeks;

    @FindBy(xpath = "//li[@id='161']/div[1]")
    private static WebElement saturdayDaysOfWeeks;

    @FindBy(xpath = "//li[@id='31']/div[1]")
    private static WebElement getEditorsDaysOfWeeks;

    @FindBy(xpath = "//li[@id='30']/div[1]")
    private static WebElement getMintMonetDaysOfWeeks;

    @FindBy(xpath = "//li[@id='29']/div[1]")
    private static WebElement getMintTechDaysOfWeeks;

    @FindBy(xpath = "//li[@id='28']/div[1]")
    private static WebElement getMintPrimerDaysOfWeeks;

    @FindBy(xpath = "//li[@id='27']/div[1]")
    private static WebElement getPlainFactsDaysOfWeeks;

    @FindBy(xpath = "//li[@id='26']/div[1]")
    private static WebElement getMarkToMarketDaysOfWeeks;

    @FindBy(xpath = "//li[@id='165']/div[1]")
    private static WebElement getTwichDaysOfWeeks;

    @FindBy(xpath = "//li[@id='164']/div[1]")
    private static WebElement getlikeShareSubscribeDaysOfWeeks;

    @FindBy(xpath = "//li[@id=36]/div[2]/span/img")
    private static WebElement easynomicslogo;

    @FindBy(xpath = "//li[@id='35']/div[2]/span/img")
    private static WebElement getCryptonotesLogo;

    @FindBy(xpath = "//li[@id='34']/div[2]/span/img")
    private static WebElement getCompanyOutsiderLogo;

    @FindBy(xpath = "//li[@id='33']/div[2]/span/img")
    private static WebElement getTickerLogo;

    @FindBy(xpath = "//li[@id='161']/div[2]/span/img")
    private static WebElement getSaturdaysLogo;

    @FindBy(xpath = "//li[@id='31']/div[2]/span/img")
    private static WebElement getEditorLogo;

    @FindBy(xpath = "//li[@id='30']/div[2]/span/img")
    private static WebElement getMintMoneyLogo;

    @FindBy(xpath = "//li[@id='29']/div[2]/span/img")
    private static WebElement getMintTechLogo;

    @FindBy(xpath = "//li[@id='28']/div[2]/span/img")
    private static WebElement getMintPrimerLogo;

    @FindBy(xpath = "//li[@id='27']/div[2]/span/img")
    private static WebElement getPlainFactsLogo;

    @FindBy(xpath = "//li[@id='26']/div[2]/span/img")
    private static WebElement getMarkToMarketLogo;

    @FindBy(xpath = "//li[@id='165']/div[2]/span/img")
    private static WebElement getTwichLogo;

    @FindBy(xpath = "//li[@id='164']/div[2]/span/img")
    private static WebElement getLikeShareSubscribeLogo;

    @FindBy(xpath = "//h2[@id='title_36']")
    private static WebElement easynomicsTitle;

    @FindBy(xpath = "//h2[@id='title_31']")
    private static WebElement getEditorTitle;

    @FindBy(xpath = "//h2[@id='title_30']")
    private static WebElement getMintMoneyTitle;

    @FindBy(xpath = "//h2[@id='title_29']")
    private static WebElement getMintTechTitle;

    @FindBy(xpath = "//h2[@id='title_28']")
    private static WebElement getMintPrimerTitle;

    @FindBy(xpath = "//h2[@id='title_27']")
    private static WebElement getPlainsFactsTitle;

    @FindBy(xpath = "//h2[@id='title_26']")
    private static WebElement getMarkToMarketTitle;

    @FindBy(xpath = "//h2[@id='title_165']")
    private static WebElement getTwichTitle;

    @FindBy(xpath = "//h2[@id='title_164']")
    private static WebElement getLikeShareSubscribeTitle;

    @FindBy(xpath = "//h2[@id='title_35']")
    private static WebElement getCryptoNotesTitle;

    @FindBy(xpath = "//h2[@id='title_34']")
    private static WebElement getCompanyOutsiderTitle;

    @FindBy(xpath = "//h2[@id='title_33']")
    private static WebElement getTickerTitle;

    @FindBy(xpath = "//h2[@id='title_161']")
    private static WebElement getSaturdayTitle;

    @FindBy(xpath = "//li[@id='36']/p")
    private static WebElement easynomicsDescr;

    @FindBy(xpath = "//li[@id='35']/p")
    private static WebElement getCryptoNotesDescr;

    @FindBy(xpath = "//li[@id='34']/p")
    private static WebElement getCompanyOutsiderDescr;

    @FindBy(xpath = "//li[@id='33']/p")
    private static WebElement getTickerDescr;

    @FindBy(xpath = "//li[@id='31']/p")
    private static WebElement getEditorDescr;

    @FindBy(xpath = "//li[@id='30']/p")
    private static WebElement getMintMoneyDescr;

    @FindBy(xpath = "//li[@id='29']/p")
    private static WebElement getMintTechDescr;

    @FindBy(xpath = "//li[@id='28']/p")
    private static WebElement getMintPrimerDescr;

    @FindBy(xpath = "//li[@id='27']/p")
    private static WebElement getPlainsFactsDescr;

    @FindBy(xpath = "//li[@id='26']/p")
    private static WebElement getMarkToMarketDescr;

    @FindBy(xpath = "//li[@id='165']/p")
    private static WebElement getTwichDescr;

    @FindBy(xpath = "//li[@id='164']/p")
    private static WebElement getLikeShareSubscribeDescr;
    @FindBy(xpath = "//li[@id='161']/p")
    private static WebElement getSaturdayDescr;

    @FindBy(xpath = "//li[@id='36']/div[3]/a")
    private static WebElement easynomicsPreview;

    @FindBy(xpath = "//li[@id='35']/div[3]/a")
    private static WebElement getCryptoNotesPreviewq;

    @FindBy(xpath = "//li[@id='34']/div[3]/a")
    private static WebElement getCompanyOutsiderPreviewq;

    @FindBy(xpath = "//li[@id='33']/div[3]/a")
    private static WebElement getTickerPreviewq;

    @FindBy(xpath = "//li[@id='161']/div[3]/a")
    private static WebElement getSaturdayPreview;

    @FindBy(xpath = "//li[@id='31']/div[3]/a")
    private static WebElement getEditorPreview;

    @FindBy(xpath = "//li[@id='30']/div[3]/a")
    private static WebElement getMintMoneyPreview;

    @FindBy(xpath = "//li[@id='29']/div[3]/a")
    private static WebElement getMintTechPreview;

    @FindBy(xpath = "//li[@id='28']/div[3]/a")
    private static WebElement getMintPrimerPreview;

    @FindBy(xpath = "//li[@id='27']/div[3]/a")
    private static WebElement getPlainsFactPreview;

    @FindBy(xpath = "//li[@id='26']/div[3]/a")
    private static WebElement getMarkToMarketPreview;

    @FindBy(xpath = "//li[@id='165']/div[3]/a")
    private static WebElement getTwichPreview;

    @FindBy(xpath = "//li[@id='164']/div[3]/a")
    private static WebElement getLikeShareSubscribePreview;

    @FindBy(xpath = "//li[@id='36']/div[2]/a")
    private static WebElement easynomicsPlusIcon;

    @FindBy(xpath = "//li[@id='35']/div[2]/a")
    private static WebElement getCryptoNotesPlusIcon;

    @FindBy(xpath = "//li[@id='34']/div[2]/a")
    private static WebElement getCompanyOutsiderPlusIcon;

    @FindBy(xpath = "//li[@id='33']/div[2]/a")
    private static WebElement getTickerPlusIcon;

    @FindBy(xpath = "//li[@id='161']/div[2]/a")
    private static WebElement getSaturdayPlusIcon;

    @FindBy(xpath = "//li[@id='31']/div[2]/a")
    private static WebElement getEditorPlusIcon;

    @FindBy(xpath = "//li[@id='30']/div[2]/a")
    private static WebElement getMintMoneyPlusIcon;

    @FindBy(xpath = "//li[@id='29']/div[2]/a")
    private static WebElement getMintTechPlusIcon;

    @FindBy(xpath = "//li[@id='28']/div[2]/a")
    private static WebElement getMintPrimerPlusIcon;

    @FindBy(xpath = "//li[@id='27']/div[2]/a")
    private static WebElement getPlainsFactPlusIcon;

    @FindBy(xpath = "//li[@id='26']/div[2]/a")
    private static WebElement getMarkToMarketPlusIcon;

    @FindBy(xpath = "//li[@id='165']/div[2]/a")
    private static WebElement getTwichPlusIcon;

    @FindBy(xpath = "//li[@id='164']/div[2]/a")
    private static WebElement getLikeShareSubscribePlusIcon;

    @FindBy(xpath = "//li[@id='31']/span")
    private static WebElement getPremiumTagOnEditor;

    @FindBy(xpath = "//li[@id='30']/span")
    private static WebElement getPremiumTagOnMintMoney;

    @FindBy(xpath = "//li[@id='29']/span")
    private static WebElement getPremiumTagOnMintTech;

    @FindBy(xpath = "//li[@id='28']/span")
    private static WebElement getPremiumTagOnMintPrimer;

    @FindBy(xpath = "//li[@id='27']/span")
    private static WebElement getPremiumTagOnPlainsFacts;

    @FindBy(xpath = "//li[@id='26']/span")
    private static WebElement getPremiumTagOnMarkToMarket;

    @FindBy(xpath = "//li[@id='165']/span")
    private static WebElement getPremiumTagOnTwich;

    @FindBy(xpath = "//li[@id='164']/span")
    private static WebElement getPremiumTagOnLikeShareSubscribe;
    @FindBy(xpath = "//div[@class='rightAd rightBlock'][1]")
    private static WebElement rhsTopAds;
    @FindBy(xpath = " //div[@id='trendingRHSFeed']")
    private static WebElement trendingOnRHS;

    @FindBy(xpath = " //div[@id='latestRHSFeed']")
    private static WebElement latestOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][2]")
    private static WebElement secondADSOnRHS;

    @FindBy(xpath = "//div[@id='topicRHSFeed-primer']")
    private static WebElement primerOnRHS;

    @FindBy(xpath = "//div[@id='topicRHSFeed-long-story']")
    private static WebElement longStoryOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][3]")
    private static WebElement thirdAdsOnRHS;

    @FindBy(xpath = "//div[@id='premiumRHSFeed']")
    private static WebElement premiumOnRhs;

    @FindBy(xpath = "//div[@id='rhsPopularVideosNotAdFree']")
    private static WebElement popularVideosOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][4]")
    private static WebElement fourthAdsOnRHS;

    @FindBy(xpath = "//div[@id='sectionRHSFeed-companies']")
    private static WebElement companiesOnRHS;

    @FindBy(xpath = "//div[@id='rhsWsjNotAdFree']")
    private static WebElement wsjOnRHS;

    @FindBy(xpath = "//div[@class='rightAd rightBlock'][5]")
    private static WebElement fifthAdsOnRHS;

    @FindBy(xpath = "//div[@id='personalFinance']")
    private static WebElement personalFinanceOnRHS;

    @FindBy(xpath = "//div[@id='rhsTrendingSticky']")
    private static WebElement rhsTrendingSticky;

    @FindBy(xpath = "//div[@class='rightAd rightBlock lastBlockAd']")
    private static WebElement lastAdsOnRHS;

    @FindBy(xpath = "//li[@id='35']/div[3]/a")
    private static WebElement previewLink;

    @FindBy(xpath = "(//table[@class='table_scale'])[4]//img")
    private static WebElement mintLogoOnPreviewPage;

    @FindBy(xpath = "//table[@class='table_scale']")
    private static WebElement contentOnPreviewpage;
    @FindBy(xpath = "//div[@class='nlHolder'][1]")
    private static WebElement freeNewslettersCard;

    @FindBy(xpath = "//div[@class='nlHolder'][2]")
    private static WebElement paidNewslettersCard;

    @FindBy(xpath = "//a[@onclick='subscribeBtnClickCTA()']")
    private static WebElement planPage;



    public NewsLettersPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        globalVars.getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsLM= CommonFunctionsWebLM.getInstance();

        //commonFunctions.clickElementIfDisplayed(acceptCookie, 10, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    @Override
    public boolean checkNewsLetterFunctionality() {
        return false;
    }

    @Override
    public boolean checkFirstNewsLettersOption() {
        return false;
    }

    @Override
    public boolean checkFreeNewsLettersTypes() {
        return false;
    }

    @Override
    public boolean checkPreviewFunctionality() {
        return false;
    }

    @Override
    public boolean checkLoginPopUpForSubscribeFreeNewsLetters() {
        return false;
    }

    @Override
    public boolean checkLoginPopUpForSubscribePaidNewsLetters() {
        return false;
    }

    @Override
    public boolean checkPlanPageForPaidNewsLettersSubscribeButton() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagForFreeNewsLetters() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagForPaidNewsLetters() {
        return false;
    }

    @Override
    public boolean checkPrivacyPolicyNewsLetters() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagForPaidAndFreeNewsLetters() {
        return false;
    }

    @Override
    public boolean checkNoSubscribedNewsLettersIsShowing() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagAndUnSubscribedPaidAndFreeNewsLetters() {
        return false;
    }

    public boolean checkNewsletterPageLayout() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean headerContentVisibility = commonFunctions.newslettersCardContentVisiblity(pageTitle, NewsletterHeadContent, FreeNewsletters, SubscriberOnlyNewsletters);
        commonFunctions.isElementDisplayed(SubscriptionBanner, 10, "Subscription banner Displayed");
        if (headerContentVisibility) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkNewsletterPageLayoutForSubscribedUsers() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean headerContentVisibility = commonFunctions.newslettersCardContentVisiblity(pageTitle, NewsletterHeadContent, FreeNewsletters, SubscriberOnlyNewsletters);
        commonFunctions.isElementNotDisplayed(SubscriptionBanner, 10, "Subscription banner Displayed");
        commonFunctions.isElementDisplayed(SubscribedNewsletters, 10, "Subscribed Newsletters list should be displayed");
        commonFunctions.isElementDisplayed(PrivacyPloicyTextDisplayed, 10, "Newsletters may offer personalized content or advertisements");
        commonFunctions.scrollToBottom();
        if (headerContentVisibility) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkNewslettersTopNav() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean mintLogoDisplayed = commonFunctions.isElementDisplayed(pageTitle, 10, "mint logo");
        boolean iconMenuDisplayed = commonFunctions.isElementDisplayed(iconMenu, 10, "Icon Menu should be displayed");
        boolean searchIconDisplayed = commonFunctions.isElementDisplayed(SearchIcon, 10, "Search icon need to be displayed");
        boolean notificationIconDisplayed = commonFunctions.isElementDisplayed(NotificationBellIcon, 10, "Notification icon need to be displayed in top Nav");
        boolean epaperIconDisplayed = commonFunctions.isElementDisplayed(EpaperIcon, 10, "Epaper icon need to be displayed in top Nav");
        boolean SigninlinkDisplayed = commonFunctions.isElementDisplayed(singInButton, 10, "Sign in button need to be displayed in top nav");
        if (mintLogoDisplayed && iconMenuDisplayed && searchIconDisplayed && notificationIconDisplayed && epaperIconDisplayed && SigninlinkDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkRHSOnNewslettersSubscribedUsers() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean mintLogoDisplayed = commonFunctions.isElementDisplayed(pageTitle, 10, "mint logo");
        commonFunctions.scrollToElementView(rhsRFU, 10, "RFU should displayed in RHS");
        boolean rhsRFUDisplayed = commonFunctions.isElementDisplayed(rhsRFU, 10, "RFU should displayed in RHS");
        commonFunctions.scrollToElementView(rhsPopularVideos, 10, "rhs popular vidoes");
        boolean popularVideoDisplayed = commonFunctions.isElementDisplayed(rhsPopularVideos, 10, "Popular Videos need to be displayed in RHS");
        boolean rhsWSJdisplayed = true;
        try {
            commonFunctions.scrollToElementView(rhsWSJ, 10, "WSJ need to be displayed");
            commonFunctions.isElementDisplayed(rhsWSJ, 10, "WSJ need to be displayed in RHS");

        } catch (Exception e) {
            System.out.println(rhsWSJdisplayed);
        }
        if (mintLogoDisplayed && rhsRFUDisplayed && popularVideoDisplayed && rhsWSJdisplayed) {

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkLHSOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean homeOnLHSDisplayed = commonFunctions.isElementDisplayed(LHSHome, 10, "Home should be displayed on LHS Side");
        boolean latestOnLHSDisplayed = commonFunctions.isElementDisplayed(LHSLatest, 10, "Latest should be displayed on LHS Side");
        boolean marketsOnLSHDisplayed = commonFunctions.isElementDisplayed(LHSMarket, 10, "Market should be displayed on LHS Side");
        boolean premiumOnLHSDisplayed = commonFunctions.isElementDisplayed(LHSPremium, 10, "Premium should be displayed on LHS Side ");
        boolean forYouLHSDisplayed = commonFunctions.isElementDisplayed(LHSForYou, 10, "For You should be displayed on LHS Side");
        if (homeOnLHSDisplayed && latestOnLHSDisplayed && marketsOnLSHDisplayed && premiumOnLHSDisplayed && forYouLHSDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkTOTMOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean daysOfWeekOnTOTM = commonFunctions.isElementDisplayed(daysOfWeek, 10, "Verify the days must be written on top i.e Monday-Friday");
        boolean TOTMLogoDisplayed = commonFunctions.isElementDisplayed(TOTMLogo, 10, "Logo should be displayed");
        commonFunctions.scrollToElementView(TOTMTitle, 10, "Verify the title of the newsletter.");
        boolean TOTMTitleDisplayed = commonFunctions.isElementDisplayed(TOTMTitle, 10, "Verify the title of the newsletter.");
        boolean TOTMDescriptionDisplayed = commonFunctions.isElementDisplayed(TOTMDescr, 10, "Verify the description of the newsletter. ");
        boolean TOTMPreviewDisplayed = commonFunctions.isElementDisplayed(TOTMPreview, 10, ".Verify the preview link.");
        boolean TOTMSubscribeCTADisplayed = commonFunctions.isElementDisplayed(TOTMPlusIcon, 10, "Verify the subscribe CTA.button");
        if (daysOfWeekOnTOTM && TOTMLogoDisplayed && TOTMTitleDisplayed && TOTMDescriptionDisplayed && TOTMPreviewDisplayed && TOTMSubscribeCTADisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkEasynomicsOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean easynomicsDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(easynomicsDayOfWeeks, 10, "Verify the days must be written on top i.e Friday");
        boolean easynomicsLogoDisplayed = commonFunctions.isElementDisplayed(easynomicslogo, 10, "Logo should be displayed");
        commonFunctions.scrollToElementView(easynomicsTitle, 10, "Verify the title of the newsletter.");
        boolean easynomicsTitleDisplayed = commonFunctions.isElementDisplayed(easynomicsTitle, 10, "Verify the title of the newsletter.");
        boolean easynomicsDescriptionDispayed = commonFunctions.isElementDisplayed(easynomicsDescr, 10, "Verify the description of the newsletter. ");
        boolean easynomicsPreviewDisplayed = commonFunctions.isElementDisplayed(easynomicsPreview, 10, ".Verify the preview link.");
        boolean easynomicsPlusIconDisplayed = commonFunctions.isElementDisplayed(easynomicsPlusIcon, 10, "Verify the subscribe CTA.button");
        if (easynomicsDaysOfWeeksDisplayed && easynomicsLogoDisplayed && easynomicsTitleDisplayed && easynomicsDescriptionDispayed && easynomicsPreviewDisplayed && easynomicsPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkCryptoNotesOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean cryptonotesDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(cryptoNotesDaysOfWeeks, 10, "Verify the days must be written on top i.e Wednesday");
        boolean cryptonotesLogoDisplayed = commonFunctions.isElementDisplayed(getCryptonotesLogo, 10, "Logo should be displayed");
        commonFunctions.scrollToElementView(getCryptoNotesTitle, 10, "Verify the title of the newsletter.");
        boolean cryptonotesTitleDisplayed = commonFunctions.isElementDisplayed(getCryptoNotesTitle, 10, "Verify the title of the newsletter.");
        boolean cryptonotesDescriptionDispayed = commonFunctions.isElementDisplayed(getCryptoNotesDescr, 10, "Verify the description of the newsletter. ");
        boolean cryptonotesPreviewDisplayed = commonFunctions.isElementDisplayed(getCryptoNotesPreviewq, 10, ".Verify the preview link.");
        boolean cryptonotesPlusIconDisplayed = commonFunctions.isElementDisplayed(getCryptoNotesPlusIcon, 10, "Verify the subscribe CTA.button");
        if (cryptonotesDaysOfWeeksDisplayed && cryptonotesLogoDisplayed && cryptonotesTitleDisplayed && cryptonotesDescriptionDispayed && cryptonotesPreviewDisplayed && cryptonotesPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkCompanyOutsiderOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean companyOutsidersDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(companyOutsiderDaysOfWeeks, 10, "Verify the days must be written on top i.e Tuesday");
        boolean companyOutsidersLogoDisplayed = commonFunctions.isElementDisplayed(getCompanyOutsiderLogo, 10, "Logo should be displayed");
        commonFunctions.scrollToElementView(getCompanyOutsiderTitle, 10, "Verify the title of the newsletter.");
        boolean companyOutsidersTitleDisplayed = commonFunctions.isElementDisplayed(getCompanyOutsiderTitle, 10, "Verify the title of the newsletter.");
        boolean companyOutsidersDescriptionDispayed = commonFunctions.isElementDisplayed(getCompanyOutsiderDescr, 10, "Verify the description of the newsletter. ");
        boolean companyOutsidersPreviewDisplayed = commonFunctions.isElementDisplayed(getCompanyOutsiderPreviewq, 10, ".Verify the preview link.");
        boolean companyOutsidersPlusIconDisplayed = commonFunctions.isElementDisplayed(getCompanyOutsiderPlusIcon, 10, "Verify the subscribe CTA.button");
        if (companyOutsidersDaysOfWeeksDisplayed && companyOutsidersLogoDisplayed && companyOutsidersTitleDisplayed && companyOutsidersDescriptionDispayed && companyOutsidersPreviewDisplayed && companyOutsidersPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkTickerOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean tickerDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(tickerDaysOfWeeks, 10, "Verify the days must be written on top i.e Monday");
        boolean tickeLogoDisplayed = commonFunctions.isElementDisplayed(getTickerLogo, 10, "Logo should be displayed");
        commonFunctions.scrollToElementView(getTickerTitle, 10, "Verify the title of the newsletter.");
        boolean tickerTitleDisplayed = commonFunctions.isElementDisplayed(getTickerTitle, 10, "Verify the title of the newsletter.");
        boolean tickerDescriptionDispayed = commonFunctions.isElementDisplayed(getTickerDescr, 10, "Verify the description of the newsletter. ");
        boolean tickerPreviewDisplayed = commonFunctions.isElementDisplayed(getTickerPreviewq, 10, ".Verify the preview link.");
        boolean tickePlusIconDisplayed = commonFunctions.isElementDisplayed(getTickerPlusIcon, 10, "Verify the subscribe CTA.button");
        if (tickerDaysOfWeeksDisplayed && tickeLogoDisplayed && tickerTitleDisplayed && tickerDescriptionDispayed && tickerPreviewDisplayed && tickePlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkSaturdayFeelingOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean saturdayFeelingDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(saturdayDaysOfWeeks, 10, "Verify the days must be written on top i.e Saturday");
        boolean saturdayFeelingLogoDisplayed = commonFunctions.isElementDisplayed(getSaturdaysLogo, 10, "Logo should be displayed");
        commonFunctions.scrollToElementView(getSaturdayTitle, 10, "Verify the title of the newsletter.");
        boolean saturdayFeelingTitleDisplayed = commonFunctions.isElementDisplayed(getSaturdayTitle, 10, "Verify the title of the newsletter.");
        boolean saturdayFeelingDescriptionDispayed = commonFunctions.isElementDisplayed(getSaturdayDescr, 10, "Verify the description of the newsletter. ");
        boolean saturdayFeelingPreviewDisplayed = commonFunctions.isElementDisplayed(getSaturdayPreview, 10, ".Verify the preview link.");
        boolean saturdayFeelingPlusIconDisplayed = commonFunctions.isElementDisplayed(getSaturdayPlusIcon, 10, "Verify the subscribe CTA.button");
        if (saturdayFeelingDaysOfWeeksDisplayed && saturdayFeelingLogoDisplayed && saturdayFeelingTitleDisplayed && saturdayFeelingDescriptionDispayed && saturdayFeelingPreviewDisplayed && saturdayFeelingPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkEditorChoiceOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean editorsChoiceDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getEditorsDaysOfWeeks, 10, "Verify the days must be written on top i.e Sunday");
        boolean editorsChoiceLogoDisplayed = commonFunctions.isElementDisplayed(getEditorLogo, 10, "Logo should be displayed");
        boolean editorsChoicePremiumTagDisplayed = commonFunctions.isElementDisplayed(getPremiumTagOnEditor, 10, "Premium tag should be Displayed On Editor Card");
        commonFunctions.scrollToElementView(getEditorTitle, 10, "Verify the title of the newsletter.");
        boolean editorsChoiceTitleDisplayed = commonFunctions.isElementDisplayed(getEditorTitle, 10, "Verify the title of the newsletter.");
        boolean editorsChoiceDescriptionDispayed = commonFunctions.isElementDisplayed(getEditorDescr, 10, "Verify the description of the newsletter. ");
        boolean editorsChoicegPreviewDisplayed = commonFunctions.isElementDisplayed(getEditorPreview, 10, ".Verify the preview link.");
        boolean editorsChoicePlusIconDisplayed = commonFunctions.isElementDisplayed(getEditorPlusIcon, 10, "Verify the subscribe CTA.button");
        if (editorsChoiceDaysOfWeeksDisplayed && editorsChoiceLogoDisplayed && editorsChoicePremiumTagDisplayed && editorsChoiceTitleDisplayed && editorsChoiceDescriptionDispayed && editorsChoicegPreviewDisplayed && editorsChoicePlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkMintMoneyOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean mintMoneyDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getMintMonetDaysOfWeeks, 10, "Verify the days must be written on top i.e Friday");
        boolean mintMoneyLogoDisplayed = commonFunctions.isElementDisplayed(getMintMoneyLogo, 10, "Logo should be displayed");
        boolean mintMoneyPremiumTagDisplayed = commonFunctions.isElementDisplayed(getPremiumTagOnMintMoney, 10, "Premium tag should be displayed On Mint Money");
        commonFunctions.scrollToElementView(getMintMoneyTitle, 10, "Verify the title of the newsletter.");
        boolean mintMoneyTitleDisplayed = commonFunctions.isElementDisplayed(getMintMoneyTitle, 10, "Verify the title of the newsletter.");
        boolean mintMoneyDescriptionDispayed = commonFunctions.isElementDisplayed(getMintMoneyDescr, 10, "Verify the description of the newsletter. ");
        boolean mintMoneyPreviewDisplayed = commonFunctions.isElementDisplayed(getMintMoneyPreview, 10, ".Verify the preview link.");
        boolean mintMoneyPlusIconDisplayed = commonFunctions.isElementDisplayed(getMintMoneyPlusIcon, 10, "Verify the subscribe CTA.button");
        if (mintMoneyDaysOfWeeksDisplayed && mintMoneyLogoDisplayed && mintMoneyPremiumTagDisplayed && mintMoneyTitleDisplayed && mintMoneyDescriptionDispayed && mintMoneyPreviewDisplayed && mintMoneyPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkMintTechOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean mintTechDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getMintTechDaysOfWeeks, 10, "Verify the days must be written on top i.e Thursday");
        boolean mintTechLogoDisplayed = commonFunctions.isElementDisplayed(getMintTechLogo, 10, "Logo should be displayed");
        boolean mintTechPremiumTagDisplayed = commonFunctions.isElementDisplayed(getPremiumTagOnMintTech);
        commonFunctions.scrollToElementView(getMintTechTitle, 10, "Verify the title of the newsletter.");
        boolean mintTechTitleDisplayed = commonFunctions.isElementDisplayed(getMintTechTitle, 10, "Verify the title of the newsletter.");
        boolean mintTechDescriptionDispayed = commonFunctions.isElementDisplayed(getMintTechDescr, 10, "Verify the description of the newsletter. ");
        boolean mintTechPreviewDisplayed = commonFunctions.isElementDisplayed(getMintTechPreview, 10, ".Verify the preview link.");
        boolean mintTechPlusIconDisplayed = commonFunctions.isElementDisplayed(getMintTechPlusIcon, 10, "Verify the subscribe CTA.button");
        if (mintTechDaysOfWeeksDisplayed && mintTechLogoDisplayed && mintTechPremiumTagDisplayed && mintTechTitleDisplayed && mintTechDescriptionDispayed && mintTechPreviewDisplayed && mintTechPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkMintPrimerOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean mintPrimerDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getMintPrimerDaysOfWeeks, 10, "Verify the days must be written on top i.e Wednesday");
        boolean mintPrimerLogoDisplayed = commonFunctions.isElementDisplayed(getMintPrimerLogo, 10, "Logo should be displayed");
        boolean mintPrimerPremiumTagDisplayed = commonFunctions.isElementDisplayed(getPremiumTagOnMintPrimer, 10, "Premium tag on Mint Primer");
        commonFunctions.scrollToElementView(getMintPrimerTitle, 10, "Verify the title of the newsletter.");
        boolean mintPrimerTitleDisplayed = commonFunctions.isElementDisplayed(getMintPrimerTitle, 10, "Verify the title of the newsletter.");
        boolean mintPrimerDescriptionDisplayed = commonFunctions.isElementDisplayed(getMintPrimerDescr, 10, "Verify the description of the newsletter. ");
        boolean mintPrimerPreviewDisplayed = commonFunctions.isElementDisplayed(getMintPrimerPreview, 10, ".Verify the preview link.");
        boolean mintPrimerPlusIconDisplayed = commonFunctions.isElementDisplayed(getMintPrimerPlusIcon, 10, "Verify the subscribe CTA.button");
        if (mintPrimerDaysOfWeeksDisplayed && mintPrimerLogoDisplayed && mintPrimerPremiumTagDisplayed && mintPrimerTitleDisplayed && mintPrimerDescriptionDisplayed && mintPrimerPreviewDisplayed && mintPrimerPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkPlainsFactOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean plainsFactDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getPlainFactsDaysOfWeeks, 10, "Verify the days must be written on top i.e Tuesday");
        boolean plainsFactLogoDisplayed = commonFunctions.isElementDisplayed(getPlainFactsLogo, 10, "Logo should be displayed");
        boolean plainsFactPremiumTagDisplayed = true;
        try {
            commonFunctions.scrollToElementView(getPremiumTagOnPlainsFacts, 10, "Premium tag on Mint Primer");
            commonFunctions.isElementDisplayed(getPremiumTagOnPlainsFacts, 20, "Premium tag on Mint Primer");
        } catch (Exception e) {
            System.out.println("plainsFactPremiumTagDisplayed");
        }
        commonFunctions.scrollToElementView(getPlainsFactsTitle, 10, "Verify the title of the newsletter.");
        boolean plainsFactTitleDisplayed = commonFunctions.isElementDisplayed(getPlainsFactsTitle, 10, "Verify the title of the newsletter.");
        boolean plainsFactDescriptionDisplayed = commonFunctions.isElementDisplayed(getPlainsFactsDescr, 10, "Verify the description of the newsletter. ");
        boolean plainsFactPreviewDisplayed = commonFunctions.isElementDisplayed(getPlainsFactPreview, 10, ".Verify the preview link.");
        boolean plainsFactPlusIconDisplayed = commonFunctions.isElementDisplayed(getPlainsFactPlusIcon, 10, "Verify the subscribe CTA.button");
        if (plainsFactDaysOfWeeksDisplayed && plainsFactLogoDisplayed && plainsFactPremiumTagDisplayed && plainsFactTitleDisplayed && plainsFactDescriptionDisplayed && plainsFactPreviewDisplayed && plainsFactPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkMarkToMarketOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean markToMarketDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getMarkToMarketDaysOfWeeks, 10, "Verify the days must be written on top i.e Monday");
        boolean markToMarketLogoDisplayed = commonFunctions.isElementDisplayed(getMarkToMarketLogo, 10, "Logo should be displayed");
        boolean markToMarketPremiumTagDisplayed = commonFunctions.isElementDisplayed(getPremiumTagOnMarkToMarket, 10, "Premium tag on Mint Primer");
        commonFunctions.scrollToElementView(getMarkToMarketTitle, 10, "Verify the title of the newsletter.");
        boolean markToMarketTitleDisplayed = commonFunctions.isElementDisplayed(getMarkToMarketTitle, 10, "Verify the title of the newsletter.");
        boolean markToMarketDescriptionDisplayed = commonFunctions.isElementDisplayed(getMarkToMarketDescr, 10, "Verify the description of the newsletter. ");
        boolean markToMarketPreviewDisplayed = commonFunctions.isElementDisplayed(getMarkToMarketPreview, 10, ".Verify the preview link.");
        boolean markToMarketPlusIconDisplayed = commonFunctions.isElementDisplayed(getMarkToMarketPlusIcon, 10, "Verify the subscribe CTA.button");
        if (markToMarketDaysOfWeeksDisplayed && markToMarketLogoDisplayed && markToMarketPremiumTagDisplayed && markToMarketTitleDisplayed && markToMarketDescriptionDisplayed && markToMarketPreviewDisplayed && markToMarketPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkTwichOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean twichDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getTwichDaysOfWeeks, 10, "Verify the days must be written on top i.e Thursday");
        boolean twichLogoDisplayed = commonFunctions.isElementDisplayed(getTwichLogo, 10, "Logo should be displayed");
        boolean twichPremiumTagDisplayed = true;
        try {
            commonFunctions.isElementDisplayed(getPremiumTagOnTwich, 10, "Premium tag on Mint Primer");
        } catch (Exception e) {
            System.out.println("twichPremiumTagDisplayed");
        }
        commonFunctions.scrollToElementView(getTwichTitle, 10, "Verify the title of the newsletter.");
        boolean twichTitleDisplayed = commonFunctions.isElementDisplayed(getTwichTitle, 10, "Verify the title of the newsletter.");
        boolean twichDescriptionDispayed = commonFunctions.isElementDisplayed(getTwichDescr, 10, "Verify the description of the newsletter. ");
        boolean twichPreviewDisplayed = commonFunctions.isElementDisplayed(getTwichPreview, 10, ".Verify the preview link.");
        boolean twichPlusIconDisplayed = commonFunctions.isElementDisplayed(getTwichPlusIcon, 10, "Verify the subscribe CTA.button");
        if (twichDaysOfWeeksDisplayed && twichLogoDisplayed && twichPremiumTagDisplayed && twichTitleDisplayed && twichDescriptionDispayed && twichPreviewDisplayed && twichPlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkLikeShareSuscribeOnNewslettersPageForSubscriberOnlyNewsletters() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean likeShareSubscribeDaysOfWeeksDisplayed = commonFunctions.isElementDisplayed(getlikeShareSubscribeDaysOfWeeks, 10, "Verify the days must be written on top i.e Sunday");
        boolean likeShareSubscribeLogoDisplayed = commonFunctions.isElementDisplayed(getLikeShareSubscribeLogo, 10, "Logo should be displayed");
        boolean likeShareSubscribePremiumTagDisplayed = commonFunctions.isElementDisplayed(getPremiumTagOnLikeShareSubscribe, 10, "Premium tag on Mint Primer");
        commonFunctions.scrollToElementView(getLikeShareSubscribeTitle, 10, "Verify the title of the newsletter.");
        boolean likeShareSubscribeTitleDisplayed = commonFunctions.isElementDisplayed(getLikeShareSubscribeTitle, 10, "Verify the title of the newsletter.");
        boolean likeShareSubscribeDescriptionDispayed = commonFunctions.isElementDisplayed(getLikeShareSubscribeDescr, 10, "Verify the description of the newsletter. ");
        boolean likeShareSubscribePreviewDisplayed = commonFunctions.isElementDisplayed(getLikeShareSubscribePreview, 10, ".Verify the preview link.");
        boolean likeShareSubscribePlusIconDisplayed = commonFunctions.isElementDisplayed(getLikeShareSubscribePlusIcon, 10, "Verify the subscribe CTA.button");
        if (likeShareSubscribeDaysOfWeeksDisplayed && likeShareSubscribeLogoDisplayed && likeShareSubscribePremiumTagDisplayed && likeShareSubscribeTitleDisplayed && likeShareSubscribeDescriptionDispayed && likeShareSubscribePreviewDisplayed && likeShareSubscribePlusIconDisplayed) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean checkRHSOnNewslettersPage() {
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        boolean RHSVisibility =commonFunctions.isElementDisplayed(rhsTopAds, 10, "RHS top ads visibility");
        RHSVisibility &=commonFunctions.isElementDisplayed(rhsRFU, 10, "RFU visibility");
        RHSVisibility &=commonFunctions.isElementDisplayed(trendingOnRHS, 10, "trending visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(latestOnRHS, 10, "latest visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(secondADSOnRHS, 10, "Second ads visibility");
        RHSVisibility &=commonFunctions.isElementDisplayed(primerOnRHS, 10, "primer visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(longStoryOnRHS, 10, "long story visibilty on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(thirdAdsOnRHS, 10, "third ads visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(premiumOnRhs, 10, "premium visibilty on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(popularVideosOnRHS, 10, "popular videos visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(fourthAdsOnRHS, 10, "fourth ads on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(companiesOnRHS, 10, "companies visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(wsjOnRHS, 10, "wsj visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(fifthAdsOnRHS, 10, "fifty ads visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(personalFinanceOnRHS, 10, "presonal finance visibility on RHS");
        RHSVisibility &=commonFunctions.isElementDisplayed(rhsTrendingSticky, 10, " rhs Trending Sticky visibility");
        RHSVisibility &=commonFunctions.scrollToElementView(lastAdsOnRHS, 10, "last ads visible");
        RHSVisibility &=commonFunctions.isElementDisplayed(lastAdsOnRHS, 10, "last ads visibility on RHS");
        return RHSVisibility;
    }
    @Override
    public boolean checkPreviewLinkOnNewslettersPage () {
        boolean previewOnNewsletters;
        commonFunctions.navigateToPageThroughExploremenu(explore, explorenewsletter, "newsletters");
        commonFunctions.waitForPageLoad();
        commonFunctions.scrollToElementView(FreeNewsletters,10,"Free Newsletter View");
        commonFunctions.isElementDisplayed(FreeNewsletters, 10, "Free Newsletters Cards should be displayed");
        previewOnNewsletters =previewUrlValidation(previewLink,"Crypto Notes");
        commonFunctions.isElementDisplayed(mintLogoOnPreviewPage,10,"mint logo on preview page");
        commonFunctions.isElementDisplayed(contentOnPreviewpage,10,"content visibility on preview page");
        return previewOnNewsletters;
    }
    @Override
    public boolean previewUrlValidation(WebElement element,String title){
        boolean previewLandingPage;
        commonFunctions.waitForPageLoading();
        commonFunctions.isElementClickable(element, 10, "Preview link ");
        commonFunctions.clickElement(element,10,"preview link");
        commonFunctions.waitForWindow(2,"newsletters page");
        commonFunctions.switchToWindowWithTitle("Crypto Notes: What's the future of DAO tokens?");
        String actualTitle= commonFunctions.getTitle();
         previewLandingPage=actualTitle.contains(title);
         return previewLandingPage;
    }
    @Override
    public boolean checkFreeNewsLetterSubscriptionByNonLoggedInUser() {
        boolean isShowing;
        commonFunctions.navigateToPageThroughExploremenu(explore,explorenewsletter,"newsletters");
        isShowing = commonFunctions.isElementDisplayed(freeNewslettersCard,10,"Free Newsletters card");
        isShowing &= commonFunctions.clickElementWithJS(getCryptoNotesPlusIcon, 10, "cryptonotes subscribe button");
        isShowing &= commonFunctions.isElementDisplayed(singInButton, 10, "login page");
        isShowing &= commonFunctions.clickElementWithJS(getCryptoNotesPlusIcon, 10, "cryptonotes subscribe button");

        commonFunctions.navigateBack();
        return isShowing;
    }
    @Override
    public boolean checkPaidNewsLetterSubscriptionByNonLoggedInUser() {
        boolean isShowing;
        commonFunctions.navigateToPageThroughExploremenu(explore,explorenewsletter,"newsletters");
        isShowing = commonFunctions.isElementDisplayed(paidNewslettersCard,10,"Paid Newsletters card");
        isShowing &= commonFunctions.clickElementWithJS(getMintMoneyPlusIcon, 10, "editor choice subscribe button");
        isShowing &= commonFunctions.isElementDisplayed(planPage, 10, "Plan page");

        commonFunctions.navigateBack();
        return isShowing;
    }

    @Override
    public boolean checkNewsLetterCarouselTitleOnHomePage() {
        return false;
    }

    @Override
    public boolean checkNewsLetterViewAllButton() {
        return false;
    }

    @Override
    public boolean checkNewsletterCardDesign() {
        return false;
    }

    @Override
    public boolean checkNewsLetterViewAllFunctionality() {
        return false;
    }

    @Override
    public boolean checkNewsletterSubscribeButton() {
        return false;
    }

    @Override
    public boolean checkNewsletterReadButtonAndFunctionality() {
        return false;
    }

    @Override
    public boolean checkNewsletterFreeTag() {
        return false;
    }

    @Override
    public boolean checkFreeNewsLetterSubscribeByNonLoggedInUser() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagByClickingOnSubscribeButton() {
        return false;
    }

    @Override
    public boolean checkSwipeFunctionality() {
        return false;
    }

    @Override
    public boolean checkFreeSubscriptionFlowInCaseOfNonLoggedInUsers() {
        return false;
    }

    @Override
    public boolean checkSubscribedTagAndClickOnUnsubscribed() {
        return false;
    }

    @Override
    public boolean checkPremiumTag() {
        return false;
    }
}