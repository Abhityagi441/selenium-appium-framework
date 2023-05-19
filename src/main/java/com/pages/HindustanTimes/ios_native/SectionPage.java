package com.pages.HindustanTimes.ios_native;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.commonFunctions.CommonFunctionsMobileHt;
import com.pages.HindustanTimes.generic.CommonSectionPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SectionPage extends CommonSectionPage {

    private IOSDriver<MobileElement> driver;
    private GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileHt commonFunctionsMobile;
    private static CommonSectionPage sectionPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Later']")
    private static MobileElement notificationLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
    private static MobileElement notificationAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Skip' or @name='SKIP']")
    private static MobileElement skipButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Allow')]")
    private static MobileElement allowTracking;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
    private static MobileElement continueButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Maybe Later']")
    private static MobileElement mayBeLater;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Skip']")
    private static MobileElement skip;

    @iOSXCUITFindBy(id = "ht nav logo")
    private static MobileElement htLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='World']")
    private static MobileElement worldSectionOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='World']")
    private static MobileElement world;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='WORLD']")
    private static MobileElement worldSection;

    @iOSXCUITFindBy(id = "Home")
    private static MobileElement home;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@enabled='true']")
    private static MobileElement bottomNav;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Explore']")
    private static MobileElement exploreButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Business']")
    private static MobileElement businessSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BUSINESS']")
    private static MobileElement businessLandingPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Market Statistics']")
    private static MobileElement marketStatistics;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Daily Sudoku']")
    private static MobileElement sudokuSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DAILY SUDOKU']")
    private static MobileElement sudokuLandingPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@enabled='true'])[1]")
    private static MobileElement citiesSectionArrow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Noida']")
    private static MobileElement noidaSubSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NOIDA']")
    private static MobileElement noidaSubSectionTag;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cities']/parent::XCUIElementTypeCell/child::XCUIElementTypeTable//XCUIElementTypeCell")
    private static MobileElement listOfCities;

    @iOSXCUITFindBy(id = "back new")
    private static MobileElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Popular Sections']")
    private static MobileElement popularSectionsPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Photos']")
    private static MobileElement photosSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CITIES']")
    private static MobileElement citiesPageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cities']")
    private static MobileElement citiesSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='India']")
    private static MobileElement india;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cities']/following-sibling::XCUIElementTypeButton")
    private static MobileElement citiesExploreButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText")
    private static List<MobileElement> sectionNames;

    @iOSXCUITFindBy(id = "Display & Text Size")
    private static MobileElement displayTextSize;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Select Text Size']/preceding-sibling::XCUIElementTypeButton)[3]")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='DISPLAY & TEXT SIZE']/following-sibling:: XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]")
    private static MobileElement darkThemes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Opinion']")
    private static MobileElement opinionOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OPINION']")
    private static MobileElement opinionSectionPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Display & Text Size']")
    private static MobileElement displayTestSizeOption;

    @iOSXCUITFindBy(id = "profileBarButton")
    private static MobileElement profileButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '(Dark Mode')]")
    private static MobileElement iSDarkMode;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText)[1]")
    private static MobileElement firstStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText[1]")
    private static MobileElement clickFirstStory;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell)[7]/XCUIElementTypeStaticText[@name='ADVERTISEMENT']")
    private static MobileElement secondAdAfterFiveStories;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='ADVERTISEMENT'])[2]")
    private static MobileElement secondAdInSection;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Cricket'])[1]")
    private static MobileElement cricketOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CRICKET']")
    private static MobileElement cricketSectionPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Entertainment'])[1]")
    private static MobileElement entertainmentOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ENTERTAINMENT']")
    private static MobileElement entertainmentSectionPage;

    //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell[2]//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyHeadingText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Entertainment']/following-sibling::XCUIElementTypeButton")
    private static MobileElement entertainmentExploreButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Bollywood'])[1]")
    private static MobileElement bollywoodInEntertainmnet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TV']")
    private static MobileElement tvInEntertainmnet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Music']")
    private static MobileElement musicInEntertainmnet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Hollywood']")
    private static MobileElement hollywoodInEntertainmnet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='TV']")
    private static MobileElement sectionNameTVBelowTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Trending']")
    private static MobileElement trendingOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TRENDING']")
    private static MobileElement trendingHeaderTitle;

    @iOSXCUITFindBy(id = "twitter")
    private static MobileElement twitter;

    @iOSXCUITFindBy(id = "share whatsapp")
    private static MobileElement whatsApp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Videos']")
    private static MobileElement videosSectionOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VIDEOS']")
    private static MobileElement videoPageHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='play new'])[1]/preceding-sibling:: XCUIElementTypeStaticText")
    private static MobileElement videoStoryTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='News']")
    private static MobileElement newsSubSectionInvideosPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='World News']")
    private static MobileElement worldNewsSubSectionInVideoPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Entertainment'])[2]")
    private static MobileElement entertainmentSubSectionInVideoSection;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='ADVERTISEMENT'])[1]")
    private static MobileElement firstAdInVideoSectionPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='label']")
    private static MobileElement videoStoryPageText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Videos']/following-sibling::XCUIElementTypeButton")
    private static MobileElement videosExploreButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='WORLD NEWS'])[1]")
    private static MobileElement WorlNewsStoryInVideosSubSection;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='ENTERTAINMENT'])[1]")
    private static MobileElement entertainmentStoryInVideosSubSection;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Lifestyle'])[2]")
    private static MobileElement lifeStyleSectionOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LIFESTYLE']")
    private static MobileElement lifeStylePageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lifestyle']/following-sibling::XCUIElementTypeButton")
    private static MobileElement lifeStyleExploreArrow;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Fashion'])[2]")
    private static MobileElement fashionSubSectionOfLifeStyle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='FASHION'])[1]")
    private static MobileElement fashionTagInFirstStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Fashion']")
    private static MobileElement fashionSubSectionInLifeStylePage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Education']")
    private static MobileElement educationSectionOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='EDUCATION']")
    private static MobileElement educationPageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Exam Results']")
    private static MobileElement examResultInEducation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Competitive Exams']")
    private static MobileElement competitiveExamSubSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Board Exams']")
    private static MobileElement boardExamInEducation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Admission News']")
    private static MobileElement admissionNewsInEducation;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Sports'])[2]")
    private static MobileElement sportsOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SPORTS']")
    private static MobileElement sportsPageHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Cricket'])[4]")
    private static MobileElement cricketSubSectionInSports;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Football'])[2]")
    private static MobileElement footballSubSectionInSports;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Tennis'])[2]")
    private static MobileElement tennisSubSectionInSports;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Other Sports'])[2]")
    private static MobileElement otherSports;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sports']/following-sibling::XCUIElementTypeButton")
    private static MobileElement sportsExploreArrow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cricket']")
    private static MobileElement cricketInSportsPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Football']")
    private static MobileElement footballInSportsPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tennis']")
    private static MobileElement tennisInSportsPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Other Sports']")
    private static MobileElement otherSportsInSportsPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='CRICKET'])[1]")
    private static MobileElement cricketTagInFirstStory;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement SportsStoryText;

    @iOSXCUITFindBy(id = "share day")
    private static MobileElement shareStoryOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static MobileElement threeDots;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='Messages']/XCUIElementTypeOther/XCUIElementTypeImage")
    private static MobileElement messangerOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PHOTOS']")
    private static MobileElement photosPageHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Label'])[2]")
    private static MobileElement storyHeadingTextInPhotosSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BSE SENSEX']")
    private static MobileElement bseSensexOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='BSE SENSEX']/following-sibling::XCUIElementTypeStaticText[1]")
    private static MobileElement valueInBSESensexOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NIFTY 50']")
    private static MobileElement nifty50Option;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NIFTY 50']/following-sibling::XCUIElementTypeStaticText[1]")
    private static MobileElement valueInNifty50Option;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NIFTY BANK']")
    private static MobileElement niftyBankOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NIFTY BANK']/following-sibling::XCUIElementTypeStaticText[1]")
    private static MobileElement valueInNiftyBankOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='GOLD']")
    private static MobileElement goldOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='GOLD']/following-sibling::XCUIElementTypeStaticText[1]")
    private static MobileElement valueInGoldOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three grey list']")
    private static List<MobileElement> allStoriesInBusinessSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Delhi News']")
    private static MobileElement delhiNewsOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DELHI NEWS']")
    private static MobileElement delhiNewsPageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mumbai News']")
    private static MobileElement mumbaiNewsOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='MUMBAI NEWS']")
    private static MobileElement mumbaiNewsPageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tv News']")
    private static MobileElement tvNewsOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TV']")
    private static MobileElement tvNewsPageHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='three white']/following-sibling:: XCUIElementTypeStaticText)[3]")
    private static MobileElement numOfPhotosInLeadStory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Web Stories']")
    private static MobileElement webStoriesSection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='web_icon']/preceding-sibling::XCUIElementTypeImage")
    private static List<MobileElement> allStoriesInWebStoriesPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='web_icon'])[1]/preceding-sibling::XCUIElementTypeImage")
    private static MobileElement firstStoryInWebStories;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='white_break_line']")
    private static List<MobileElement> allhorizontalLinesInWebStories;

    @iOSXCUITFindBy(id = "ht_logo")
    private static List<MobileElement> htLogosInWebStories;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='three white']")
    private static List<MobileElement> threeDotInAllWebStories;

    @iOSXCUITFindBy(id = "For You")
    private  static MobileElement forYouSectionTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Welcome')]")
    private  static MobileElement popUpMessageOnCities;

    @iOSXCUITFindBy(id= "Got It")
    private static MobileElement gotItButtonOnCitiesPopUp;

    @iOSXCUITFindBy(id= "Add your favourite cities")
    private static MobileElement addFavouriteCities;

    @iOSXCUITFindBy(id = "DeselectdCity")
    private static MobileElement plusSignBeforeCity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Reorder')]")
    private static MobileElement horizontalLinesTab;

    @iOSXCUITFindBy(id = "Maybe Later")
    private static MobileElement mayBeLaterButtonOnCitiesSection;

    @iOSXCUITFindBy(id = "Save Changes")
    private static MobileElement saveChangesButtonOnCitiesSection;

    @iOSXCUITFindBy(id = "Others")
    private static MobileElement othersOptionInCities;

    @iOSXCUITFindBy(id = "SelectdCity")
    private static MobileElement unSelectCities;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Add Cities')]")
    private static MobileElement addCitiesOption;

    @iOSXCUITFindBy(id = "Delhi")
    private static MobileElement delhiSelectButton;

    @iOSXCUITFindBy(id = "City Selected Successfully")
    private static MobileElement citySuccessfulPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeStaticText[@name='Cities']/following-sibling::XCUIElementTypeButton")
    private static MobileElement downArrowInCities;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='three grey list'])[12]")
    private static MobileElement anyStoryInOpinionSection;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView//XCUIElementTypeCell)[5]")
    private static MobileElement lastSectionOnTop;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'day')]")
    private static MobileElement dateOnSelectedCity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'°')]")
    private static MobileElement temperatureInCities;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='ADVERTISEMENT'])[1]")
    private static MobileElement adInCities;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'day')]/preceding-sibling::XCUIElementTypeStaticText[contains(@name,'News')]")
    private static MobileElement citiNameWithNews;

    @iOSXCUITFindBy(id = "Noida")
    private static MobileElement noidaCitySelectButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='DeselectdCity']/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listOfUnselectedCities;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SelectdCity']/following-sibling::XCUIElementTypeStaticText")
    private static List<MobileElement> listofSelectedCitiies;

    @iOSXCUITFindBy(id = "Gurugram")
    private static MobileElement gurugramCitySelectButton;

    @iOSXCUITFindBy(id = "Mumbai")
    private static MobileElement mumbaiCitySelectButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Select Text Size']/preceding-sibling::XCUIElementTypeButton)[2]")
    private static MobileElement lightThemes;

    public SectionPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver<MobileElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileHt.getInstance();
        /*commonFunctions.clickElementIfDisplayed(allowTracking, 5, "Allow Tracking");
        commonFunctions.clickElementIfDisplayed(notificationAllow, 5, "notificationAllow");
        commonFunctions.clickElementIfDisplayed(continueButton, 5, "Continue Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater, 5, "Later Button");
        commonFunctions.clickElementIfDisplayed(skip, 5, "Skip Button");
        commonFunctions.clickElementIfDisplayed(skip, 5, "Skip Button");*/

    }

    @Override
    public boolean checkBottomNavHomeSelected() {
        commonFunctions.clickElement(home, 5, "Home page");
        boolean isHomePage = commonFunctions.isElementDisplayed(htLogo, 5, "home page");
        commonFunctions.clickElement(worldSectionOption, 5, "Section page");
        boolean isBottomNavDisplayed = commonFunctions.isElementDisplayed(bottomNav, 5, "Bottom Nav");
        boolean isHomeSelected = commonFunctions.isElementSelected(home, 5, "Home");
        return isHomePage && isBottomNavDisplayed && isHomeSelected;
    }

    @Override
    public boolean checkBusinessSection() {
        commonFunctions.clickElement(home, 5, "Home page");
        commonFunctions.clickElement(exploreButton, 5, "Profile page");
        commonFunctions.scrollToMobileElement(photosSection);
        commonFunctions.clickElement(businessSection, 5, "Section page");
        boolean isBusinessDisplayed = commonFunctions.isElementDisplayed(businessLandingPage, 5, "Business Landing Page");
        boolean isMarketStatsDisplayed = commonFunctions.isElementDisplayed(marketStatistics, 5, "Market Statistics");
        commonFunctions.killAppAndReLaunch(notificationLater, 5, "Later");
        return isBusinessDisplayed && isMarketStatsDisplayed;
    }

    @Override
    public boolean checkSudokuSection() {
        boolean isSudokuDisplayed = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,sudokuSection,"Sudoku",sudokuLandingPage,"Sudoku");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isSudokuDisplayed;
    }

    @Override
    public boolean checkNoidaSubSectionNameisDispayed() {
        boolean isSubSectionNameDisplayed;
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaSubSection,"Select Noida city",saveChangesButtonOnCitiesSection);
        commonFunctions.clickElement(noidaCitySelectButton,5,"Noida city");
        isSubSectionNameDisplayed = commonFunctions.getElementText(citiNameWithNews, 5).equalsIgnoreCase("Noida News");
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Deselect Noida city",saveChangesButtonOnCitiesSection);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isSubSectionNameDisplayed;
    }

    @Override
    public boolean checkClickExplorePageAppearAgain() {
        commonFunctions.clickElement(home, 20, "HT home button");
        commonFunctions.clickElement(exploreButton, 20, "Explore button");
        commonFunctions.scrollUntilElementFound(businessSection);
        commonFunctions.clickElement(businessSection, 20, "Business section in Explore page");
        boolean sectionPageHeaderDisplay = commonFunctions.getElementText(businessLandingPage, 20).equalsIgnoreCase("Business");
        commonFunctions.clickElement(exploreButton, 20, "Explore button");
        commonFunctions.scrollToTopOniOSNative();
        boolean explorePageHeaderDisplay = commonFunctions.getElementText(popularSectionsPage, 20).equalsIgnoreCase("Popular Sections");
        return sectionPageHeaderDisplay && explorePageHeaderDisplay;
    }

    @Override
    public boolean checkClickCityDisplayCitiesInExplore() {
        commonFunctions.clickElement(home, 30, "Home Button");
        commonFunctions.clickElement(exploreButton, 30, "Explore Button");
        commonFunctions.clickElement(downArrowInCities,5,"Down arrow in cities");
//        commonFunctions.clickElementWithCoordinates(366, 314);//clicking on arrow not working although locator present, hence using coordinated
//        commonFunctions.clickElement(citiesSectionArrow, 30, "Cities Section Arrow");
//        commonFunctions.dummyWait(5);
//        commonFunctions.clickElement(home, 30, "Home Button");
        boolean isListOfCitiesDisplayed = commonFunctions.isElementDisplayed(listOfCities, 30, "List Of Cities");
        commonFunctions.clickElement(downArrowInCities,5,"Up arrow in cities");
        commonFunctions.scrollToTopOniOSNative();
        return isListOfCitiesDisplayed;
    }

    @Override
    public boolean checkCitiesSectionNameisDispayed() {
        boolean isCitiesSectionNameDisplayed;
        commonFunctions.clickElement(home, 20, "Home Button");
        commonFunctions.clickElement(exploreButton, 20, "Explore Button");
        commonFunctions.clickElement(citiesSection, 20, "Cities Section");
        commonFunctions.isElementDisplayed(citiesPageHeader, 30, "Cities Page Header");
        String SectionName = commonFunctions.getElementText(citiesPageHeader);
        isCitiesSectionNameDisplayed = commonFunctions.checkTextEquals("CITIES", SectionName, "Section Name");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitiesSectionNameDisplayed;
    }

    @Override
    public boolean checkRedirectionFromWorld() {
        commonFunctions.clickElement(home, 5, "Home page");
        boolean isHomePage = commonFunctions.isElementDisplayed(htLogo, 5, "home page");
        commonFunctions.clickElement(world, 5, "Section");
        //Commented for now as browserstack returns false for is selected
        //boolean isWorldSelected = commonFunctions.isElementSelected(worldSection, 5, "Section Page");
        boolean isHomeSelected = commonFunctions.isElementSelected(home, 5, "Home");
        return isHomePage &&/*isWorldSelected&&*/isHomeSelected;
    }

    @Override
    public boolean checkRedirectionFromIndia() {
        commonFunctions.clickElement(home, 5, "Home page");
        boolean isHomePage = commonFunctions.isElementDisplayed(htLogo, 5, "home page");
        commonFunctions.clickElement(india, 5, "Section");
        //Commented for now as browserstack returns false for is selected
        //boolean isWorldSelected = commonFunctions.isElementSelected(indiaSection, 5, "Section Page");
        boolean isHomeSelected = commonFunctions.isElementSelected(home, 5, "Home");
        return isHomePage &&/*isWorldSelected&&*/isHomeSelected;
    }

    @Override
    public boolean SubSectionNameInCitiesSection() {
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(citiesSectionArrow, 5, "Cities Section Arrow");
        commonFunctions.clickElement(citiesExploreButton, 5, "Cities Explore Button");
        boolean IsSubSectionUnderCities = false;
        if (sectionNames.size() >= 1) {
            IsSubSectionUnderCities = true;
            Utils.logStepInfo(true, "SubSections are visible");
        } else {
            IsSubSectionUnderCities = false;
            Utils.logStepInfo(false, "SubSections are not visible");
        }
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return IsSubSectionUnderCities;
    }

    @Override
    public boolean WorldSectionInDarkMode() {
        boolean isWorldSectionInDarkMode = false;
        applyDarkMode();
        /*commonFunctions.clickElement(home,5,"Home");
        commonFunctions.clickElement(profileButton,5,"Profile Button");
        boolean isDarkModeapplied = commonFunctions.isElementDisplayed(iSDarkMode,5,"dark Mode");*/
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        isWorldSectionInDarkMode = commonFunctions.isElementDisplayed(worldSectionOption, 5, "World Section Option");
        commonFunctions.clickElementIfDisplayed(home, 5, "Home");
        commonFunctions.clickElementIfDisplayed(lightThemes,5,"Light Theme");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isWorldSectionInDarkMode;
    }

    @Override
    public boolean opinionSectionRedirection() {
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        boolean iSOpinionOption = commonFunctions.isElementDisplayed(opinionOption, 5, "Opinion Option");
        if (iSOpinionOption) {
            commonFunctions.clickElement(opinionOption, 5, "Opinion Option");
        }
        boolean iSOpinionSectionPage = commonFunctions.isElementDisplayed(opinionSectionPage, 5, "Opinion Section Page");
        return iSOpinionOption && iSOpinionSectionPage;
    }

    @Override
    public boolean checkScrollingOnOpinion() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,opinionOption,"Opinion",opinionSectionPage,"Opinion");
        String firstStoryInOpinion = commonFunctions.getElementText(firstStory, 5);
        System.out.println("First Story Text is = " + firstStoryInOpinion);
        commonFunctions.scrollDownSlowToElement(anyStoryInOpinionSection,15);
        boolean IsFirstStoryDisplayAfterScrolling = commonFunctions.isElementNotDisplayed(firstStory, 5, "First Story in Opinion");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return IsFirstStoryDisplayAfterScrolling;
    }

    @Override
    public boolean redirectToStoryFromOpinion() {
        commonFunctions.clickElement(home, 5, "Home Page");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(opinionOption, 5, "opinion Option");
        commonFunctions.clickElement(clickFirstStory, 5, "First Story Open");
        commonFunctions.clickElementIfDisplayed(skipButton, 5, "SkipButtonInPopup");
        boolean isStoryPageRedirect = commonFunctions.isElementDisplayed(opinionSectionPage, 5, "Opinion story Page");
        return isStoryPageRedirect;
    }

    @Override
    public boolean checkAdAfterFiveStories() {
        commonFunctions.clickElement(home, 5, "Home Page");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(opinionOption, 5, "opinion Option");
        commonFunctions.scrollDownSlowToElement(secondAdInSection,2);
        Boolean isAdAfterFiveStories = commonFunctions.isElementDisplayed(secondAdAfterFiveStories, 5, "Second Ad after Fifth Story");
        return isAdAfterFiveStories;
    }

    @Override
    public boolean redirectToCricketSection() {
        boolean iSRedirectToCricketSection = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,cricketOption,"Cricket",cricketSectionPage,"Cricket");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return iSRedirectToCricketSection;
    }

    @Override
    public boolean redirectToEntertainmentSection() {
        commonFunctions.clickElement(home, 5, "Home Page");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(entertainmentOption, 5, "Entertainment Section");
        boolean iSRedirectToEntertainmentSection = commonFunctions.isElementDisplayed(entertainmentSectionPage, 5, "Entertainment Section Page");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return iSRedirectToEntertainmentSection;
    }

    @Override
    public boolean redirectToStoryFromEntertainment() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,entertainmentOption,"Entertainment",entertainmentSectionPage,"Entertainment");
        String firstStoryTextInStoryList = firstStory.getText();
        System.out.println("First Story text = " + firstStoryTextInStoryList);
        commonFunctions.clickElement(clickFirstStory, 5, "First Story in Entertainment Section");
        commonFunctions.clickElement(skip, 5, "Skip");
        commonFunctions.dummyWait(3);
        System.out.println("Opened Story's heading text = " + storyHeadingText.getText());
        boolean isStoryOpened = commonFunctions.compareTexts(firstStoryTextInStoryList, storyHeadingText.getText());
        boolean isDisplayOpenedStory = commonFunctions.isElementDisplayed(storyHeadingText, 5, "Story Heading");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isStoryOpened || isDisplayOpenedStory;
    }

    @Override
    public boolean subSectionInEntertainment() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,entertainmentExploreButton,"Entertainment",entertainmentSectionPage,"Entertainment");
        boolean bollyWood = commonFunctions.isElementDisplayed(bollywoodInEntertainmnet, 5, "Bollywood Sub Section");
        boolean tv = commonFunctions.isElementDisplayed(tvInEntertainmnet, 5, "TV Sub Section");
        boolean music = commonFunctions.isElementDisplayed(musicInEntertainmnet, 5, "Music Sub Section");
        boolean hollyWood = commonFunctions.isElementDisplayed(hollywoodInEntertainmnet, 5, "HollyWood Sub Section");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return (bollyWood && tv && music && hollyWood);
    }

    @Override
    public boolean redirectToSubSectionInEntertainment() {
        commonFunctions.clickElement(home, 5, "Home button");
        commonFunctions.clickElement(exploreButton, 5, "Explore button");
        commonFunctions.clickElement(entertainmentExploreButton, 5, "Open Sub Section under Entertainment");
        commonFunctions.clickElement(tvInEntertainmnet, 5, "Bollywood");
        boolean isTVPage = commonFunctions.isElementDisplayed(sectionNameTVBelowTitle, 5, "TV Sub Section");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isTVPage;
    }

    @Override
    public boolean redirectToToTrendingSection() {
        boolean isRedirectToTrendingPage = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,trendingOption,"Trending Option",trendingHeaderTitle,"Trending");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isRedirectToTrendingPage;
    }

    @Override
    public boolean redirectToStoryFromTrendingSection() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,trendingOption,"Trending Option",trendingHeaderTitle,"Trending");
        commonFunctions.clickElement(clickFirstStory, 5, "First Story in Trending Section");
        commonFunctions.clickElement(skip, 5, "Skip");
        boolean isTwitterOptionInStoryPage = commonFunctions.isElementDisplayed(twitter, 5, "Twitter Option in Story page");
        boolean isWhatsupOptionInStoryPage = commonFunctions.isElementDisplayed(whatsApp, 5, "Share What's up option in Trending Page");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isTwitterOptionInStoryPage || isWhatsupOptionInStoryPage;
    }

    @Override
    public boolean redirectOnVideoSection() {
        boolean isVideoSectionPage = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,videosSectionOption,"Video",videoPageHeader,"Video page header");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isVideoSectionPage;
    }

    @Override
    public boolean subSectionNamesInVideoPage() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,videosSectionOption,"Video",videoPageHeader,"Video");
        boolean isNewsSubSection = commonFunctions.isElementDisplayed(newsSubSectionInvideosPage, 5, "News Sub Section");
        boolean isWorldNewsSubSection = commonFunctions.isElementDisplayed(worldNewsSubSectionInVideoPage, 5, "World News SubSection");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isNewsSubSection && isWorldNewsSubSection;
    }

    @Override
    public boolean appearanceOfVideoSectionPage() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(videosSectionOption, 5, "Video Section Option");
        boolean isVideoSectionDisplay = commonFunctions.isElementDisplayed(videoPageHeader, 5, "Video Section Header");
        boolean isAdDisplyedInVideoSectionPage = commonFunctions.isElementDisplayed(firstAdInVideoSectionPage, 5, "First Ad in Videos Section");
        boolean isFirstImageStory = commonFunctions.isElementDisplayed(firstStory, 5, "First Story In Video Section");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return (isVideoSectionDisplay && isAdDisplyedInVideoSectionPage && isFirstImageStory);
    }

    @Override
    public boolean redirectToStoryFromVideoSectionPage() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(videosSectionOption, 5, "Video Section Option");
        /*String firstStorytext = firstStory.getText();
        System.out.println("First Story Text in Video Section Page= "+firstStorytext);*/
        commonFunctions.clickElement(clickFirstStory, 5, "First Story Open");
        commonFunctions.clickElementIfDisplayed(skipButton, 5, "SkipButtonInPopup");
        System.out.println("Opened Video Story Text is = " + videoStoryPageText.getText());
        boolean isVideoStoryText = commonFunctions.isElementDisplayed(videoStoryPageText, 5, "Video Page text");
        boolean isTwitterWhatsUpIcon = commonFunctions.isElementDisplayed(twitter, 5, "Twitter") &&
                commonFunctions.isElementDisplayed(whatsApp, 5, "WhatsApp");
        return isVideoStoryText && isTwitterWhatsUpIcon;
    }

    @Override
    public boolean redirectToSubsectionOfVideoSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(videosExploreButton, 5, "videos Extend Button");
        commonFunctions.clickElement(worldNewsSubSectionInVideoPage, 5, "World News SubSection");
        boolean isWorldNewsStoryInSubSectionPage = commonFunctions.isElementDisplayed(WorlNewsStoryInVideosSubSection, 5, "World News Story In Videos SubSection");
        commonFunctions.clickElement(exploreButton, 5, "Explore button");
        commonFunctions.clickElement(entertainmentSubSectionInVideoSection, 5, "Entertainment SubSection");
        boolean isEntainmentStoryInVedioSubSection = commonFunctions.isElementDisplayed(entertainmentStoryInVideosSubSection, 5, "Entertainment Stories in video Sub Section");
        return isWorldNewsStoryInSubSectionPage && isEntainmentStoryInVedioSubSection;
    }

    @Override
    public boolean redirectOnLifeStyleSection() {
        boolean isLifeStyleSectionPage = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,lifeStyleSectionOption,"Lifestyle",lifeStylePageHeader,"Lifestyle page header");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isLifeStyleSectionPage;
    }

    @Override
    public boolean redirectToSubSectionOfLifeStyle() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(lifeStyleExploreArrow, 5, "LifeStyle Arrow");
        commonFunctions.clickElement(fashionSubSectionOfLifeStyle, 5, "fashion SubSection Of LifeStyle");
        boolean isLifeStyleHeader = commonFunctions.isElementDisplayed(lifeStylePageHeader, 5, "LifeStyle Header");
        boolean isFashionSubSection = commonFunctions.isElementDisplayed(fashionSubSectionInLifeStylePage, 5, "fashion SubSection in LifeStyle Page");
        boolean isFashionTagInFirstStory = commonFunctions.isElementDisplayed(fashionTagInFirstStory, 5, "fashion Tag in FirstStory");
        return (isLifeStyleHeader && isFashionSubSection && isFashionTagInFirstStory);
    }

    @Override
    public boolean storyInLifeStyleSection() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,lifeStyleSectionOption,"Lifestyle",lifeStylePageHeader,"Lifestyle");
        String firstStoryText = clickFirstStory.getText();
        String firstStoryText1 = firstStory.getText();
        System.out.println("Text of First Story in LifeStyle = " + firstStoryText);
        commonFunctions.clickElement(clickFirstStory, 5, "First Story Open");
        commonFunctions.clickElementIfDisplayed(skipButton, 5, "Skip Button in Story");
        boolean isTwitterWhatsUpIcon = commonFunctions.isElementDisplayed(twitter, 5, "Twitter") &&
                commonFunctions.isElementDisplayed(whatsApp, 5, "WhatsApp");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isTwitterWhatsUpIcon;
    }

    @Override
    public boolean redirectToEducationSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(educationSectionOption,"Education section");
        commonFunctions.clickElement(educationSectionOption, 5, "Education");
        boolean isEducationSectionPage = commonFunctions.isElementDisplayed(educationPageHeader, 5, "Education Page Header");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isEducationSectionPage;
    }

    @Override
    public boolean subSectionOnEducationSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.clickElement(educationSectionOption, 5, "LifeStyle");
        boolean examResults = commonFunctions.isElementDisplayed(examResultInEducation, 5, "Exam Result Sub Section");
        boolean competitiveExam = commonFunctions.isElementDisplayed(competitiveExamSubSection, 5, "competitive Exam Sub Section");
        boolean boardExam = commonFunctions.isElementDisplayed(boardExamInEducation, 5, "board Exam Sub Section");
        boolean admissionNews = commonFunctions.isElementDisplayed(admissionNewsInEducation, 5, "Admission News Sub Section");
        return (examResults && competitiveExam && boardExam && admissionNews);
    }

    @Override
    public boolean redirectionOnSportSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(sportsOption, "sports");
        commonFunctions.clickElement(sportsOption, 5, "Sports");
        boolean isSportSectionPage = commonFunctions.isElementDisplayed(sportsPageHeader, 5, "Sports Page Header");
        return isSportSectionPage;
    }

    @Override
    public boolean redirectToSubSectionFromSportSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(sportsOption, "sports");
        commonFunctions.clickElement(sportsExploreArrow, 5, "Sports Arrow");
        boolean verifySportsSubSections = commonFunctions.isElementDisplayed(cricketSubSectionInSports, 5, "Cricket SubSection") &&
                commonFunctions.isElementDisplayed(footballSubSectionInSports, 5, "Football SubSection") &&
                commonFunctions.isElementDisplayed(tennisSubSectionInSports, 5, "Tennis SUbSection") &&
                commonFunctions.isElementDisplayed(otherSports, 5, "Other Sports");
        commonFunctions.clickElement(cricketSubSectionInSports, 5, "Cricket SubSection");
        boolean VerifySubSectionsInSportsPage = commonFunctions.isElementDisplayed(cricketInSportsPage, 5, "Cricket SubSection in Sports page") &&
                commonFunctions.isElementDisplayed(footballInSportsPage, 5, "Football SubSection in Sports Page") &&
                commonFunctions.isElementDisplayed(tennisInSportsPage, 5, "Tennis SubSection in Sports page") &&
                commonFunctions.isElementDisplayed(otherSportsInSportsPage, 5, "Other Sports in Sports page");
        boolean cricketTagInStory = commonFunctions.isElementDisplayed(cricketTagInFirstStory, 5, "Cricket Tag in Story");
        return verifySportsSubSections && VerifySubSectionsInSportsPage && cricketTagInStory;
    }

    @Override
    public boolean redirectToStoryFromSportSection() {
        redirectionOnSportSection();
        commonFunctions.clickElement(clickFirstStory, 5, "Fist Story");
        commonFunctions.clickElement(skip, 5, "Skip");
        boolean isWhatsUpTwitter = commonFunctions.isElementDisplayed(whatsApp, 5, "Whatsup") &&
                commonFunctions.isElementDisplayed(twitter, 5, "Twitter");
        System.out.println("Opened Story Text = " + SportsStoryText.getText());
        boolean isSportStoryText = commonFunctions.isElementDisplayed(SportsStoryText, 5, "Sport Story text");
        return isWhatsUpTwitter;
    }

    @Override
    public boolean redirectToPhotosSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(photosSection, "Photos Section");
        commonFunctions.clickElement(photosSection, 5, "Photos Section");
        boolean isPhotosSectionPage = commonFunctions.isElementDisplayed(photosPageHeader, 5, "Photos Page Header");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isPhotosSectionPage;

    }

    @Override
    public boolean shareStoryFromSportsSection() {
        redirectionOnSportSection();
        commonFunctions.clickElement(clickFirstStory, 5, "Fist Story");
        commonFunctions.clickElement(skip, 5, "Skip");
        boolean isShareIconDisplayed = commonFunctions.isElementDisplayed(shareStoryOption, 5, "Share option");
        return isShareIconDisplayed;
    }

    @Override
    public boolean appearanceOfPhotosSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.scrollToMobileElement(photosSection);
        commonFunctions.clickElement(photosSection, 5, "Photos Section");
        boolean isPhotosSectionDisplay = commonFunctions.isElementDisplayed(photosPageHeader, 5, "Photos Section Header");
        boolean isAdDisplyedInPhotosSectionPage = commonFunctions.isElementDisplayed(firstAdInVideoSectionPage, 10, "First Ad in Photos Section");
        boolean isFirstImageStory = commonFunctions.isElementDisplayed(firstStory, 5, "First Story In Photos Section");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return (isPhotosSectionDisplay && isAdDisplyedInPhotosSectionPage && isFirstImageStory);
    }

    @Override
    public boolean photoSectionInDarkMode() {
        boolean isPhotosSectionInDarkMode = false;
        applyDarkMode();
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(photosSection, "Photos Section");
        isPhotosSectionInDarkMode = commonFunctions.isElementDisplayed(photosSection, 5, "Photos Section Option");
        commonFunctions.clickElement(photosSection, 5, "Photos Section");
        isPhotosSectionInDarkMode &= commonFunctions.isElementDisplayed(photosPageHeader, 5, "Photos Section Header");
        isPhotosSectionInDarkMode &= commonFunctions.isElementDisplayed(firstAdInVideoSectionPage, 5, "First Ad in Photos Section");
        isPhotosSectionInDarkMode &= commonFunctions.isElementDisplayed(firstStory, 5, "First Story In Photos Section");
        commonFunctions.clickElementIfDisplayed(home, 5, "Home");
        commonFunctions.clickElementIfDisplayed(lightThemes,5,"Light Theme");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isPhotosSectionInDarkMode;
    }

    @Override
    public boolean redirectToPhotoSectionStory() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,photosSection,"Photos",photosPageHeader,"Photos");
        commonFunctions.clickElement(clickFirstStory, 5, "Fist Story");
        commonFunctions.clickElement(skip, 5, "Skip");
        boolean isWhatsUpTwitter = commonFunctions.isElementDisplayed(whatsApp, 5, "Whatsup") &&
                commonFunctions.isElementDisplayed(twitter, 5, "Twitter");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isWhatsUpTwitter;
    }

    @Override
    public boolean redirectToStoryFromPhotosSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(photosSection, "Photos Section");
        commonFunctions.clickElement(photosSection, 5, "Photos Section");
        commonFunctions.clickElement(clickFirstStory, 5, "Fist Story");
        commonFunctions.clickElement(skip, 5, "Skip");
        boolean isWhatsUpTwitter = commonFunctions.isElementDisplayed(whatsApp, 5, "Whatsup") &&
                commonFunctions.isElementDisplayed(twitter, 5, "Twitter");
        return isWhatsUpTwitter;
    }

    @Override
    public boolean shareStoryFromPhotoSection() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,photosSection,"Photos",photosPageHeader,"Photos");
        commonFunctions.clickElement(clickFirstStory, 5, "Fist Story");
        commonFunctions.clickElement(skip, 5, "Skip");
        boolean isShareIconDisplayed = commonFunctions.isElementDisplayed(shareStoryOption, 5, "Share option");
        return isShareIconDisplayed;
    }

    @Override
    public boolean marketStatWidgetAfterFirstStory() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,businessSection,"Business",businessLandingPage,"Business");
        boolean isMarketStatsDisplayed = commonFunctions.isElementDisplayed(marketStatistics, 5, "Market Statistics");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isMarketStatsDisplayed;
    }

    @Override
    public boolean redirectToBusinessSection() {
        boolean isBusinessDisplayed = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,businessSection,"Business",businessLandingPage,"Business");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isBusinessDisplayed;
    }

    @Override
    public boolean marketStatWidgetFourOptions() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,businessSection,"Business",businessLandingPage,"Business");
        boolean isMarketStatWidgetOption = commonFunctions.isElementDisplayed(bseSensexOption, 5, "BSE SENSEX");
        isMarketStatWidgetOption &= commonFunctions.isElementDisplayed(nifty50Option, 5, "NIFTY 50");
        isMarketStatWidgetOption &= commonFunctions.isElementDisplayed(niftyBankOption, 5, "NIFTY BANK");
        isMarketStatWidgetOption &= commonFunctions.isElementDisplayed(goldOption, 5, "GOLD");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isMarketStatWidgetOption;
    }

    @Override
    public boolean checkValuesInMarketStatWidget() {
        boolean isValueDisplayInMarketStatWidget = true;
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,businessSection,"Business",businessLandingPage,"Business");
        if (commonFunctions.isElementDisplayed(bseSensexOption, 5, "BSE SENSEX")) {
            String valueOfBSESensex = commonFunctions.getElementText(valueInBSESensexOption, 5);
            if (valueOfBSESensex != null) {
                isValueDisplayInMarketStatWidget &= true;
            }
        }
        if (commonFunctions.isElementDisplayed(nifty50Option, 5, "NIFTY 50")) {
            String valueOfnifty50 = commonFunctions.getElementText(valueInNifty50Option, 5);
            if (valueOfnifty50 != null) {
                isValueDisplayInMarketStatWidget &= true;
            }
        }
        if (commonFunctions.isElementDisplayed(niftyBankOption, 5, "NIFTY BANK")) {
            String valueOfniftyBank = commonFunctions.getElementText(valueInNiftyBankOption, 5);
            if (valueOfniftyBank != null) {
                isValueDisplayInMarketStatWidget &= true;
            }
        }
        if (commonFunctions.isElementDisplayed(goldOption, 5, "GOLD")) {
            String valueOfGold = commonFunctions.getElementText(valueInGoldOption, 5);
            if (valueOfGold != null) {
                isValueDisplayInMarketStatWidget &= true;
            }
        }
        return isValueDisplayInMarketStatWidget;
    }

    @Override
    public boolean redirectToMumbaiNewsSection() {
        boolean isMumbaiNewsSectionPage = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,mumbaiNewsOption,"Mumbai",mumbaiNewsPageHeader,"Mumbai");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isMumbaiNewsSectionPage;
    }

    @Override
    public boolean storyDisplayedAfterMarketStatWidget() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,businessSection,"Business",businessLandingPage,"Business");
        boolean IsStoriesDisplayedInBussinessSection = false;
        if (allStoriesInBusinessSection.size() >= 1) {
            IsStoriesDisplayedInBussinessSection = true;
            Utils.logStepInfo(true, "Stories are visible");
        } else {
            IsStoriesDisplayedInBussinessSection = false;
            Utils.logStepInfo(false, "Stories are not visible");
        }
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return IsStoriesDisplayedInBussinessSection;
    }

    @Override
    public boolean checkRedirectToBusinessStory() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,businessSection,"Business",businessLandingPage,"Business");
        commonFunctions.clickElement(clickFirstStory,5,"First Story");
        commonFunctions.clickElement(skip,5,"Skip");
        boolean isWhatsUpTwitter = commonFunctions.isElementDisplayed(whatsApp, 5, "Whatsup") &&
                commonFunctions.isElementDisplayed(twitter, 5, "Twitter");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isWhatsUpTwitter;
    }

    @Override
    public boolean checkRedirectToDelhiNewsSection() {
        boolean isDelhiNewsDisplayed = commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,delhiNewsOption,"Delhi news Section",delhiNewsPageHeader,"Delhi news");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isDelhiNewsDisplayed;
    }

    @Override
    public boolean redirectToStoryOfMumbaiNewsSection() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,mumbaiNewsOption,"Mumbai",mumbaiNewsPageHeader,"Mumbai");
        String firstStoryTextInStoryList = firstStory.getText();
        System.out.println("First Story text = " + firstStoryTextInStoryList);
        commonFunctions.clickElement(clickFirstStory,5,"First Story");
        commonFunctions.clickElement(skip,5,"Skip");
        boolean isDisplayOpenedStory = commonFunctions.isElementDisplayed(storyHeadingText, 5, "Story Heading");
        System.out.println("Value of Story Heading text = " +storyHeadingText.getText());
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isDisplayOpenedStory;

    }

    @Override
    public boolean checkRedirectToStoryFromDelhiNewsSection() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,delhiNewsOption,"Delhi news Section",delhiNewsPageHeader,"Delhi news");
        String firstStoryTextInStoryList = firstStory.getText();
        System.out.println("First Story text = " + firstStoryTextInStoryList);
        commonFunctions.clickElement(clickFirstStory,5,"First Story");
        commonFunctions.clickElement(skip,5,"Skip");
        boolean isDisplayOpenedStory = commonFunctions.isElementDisplayed(storyHeadingText, 5, "Story Heading");
        System.out.println("Value of Story Heading text = " +storyHeadingText.getText());
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isDisplayOpenedStory;
    }

    @Override
    public boolean checkRedirectToTvNewsSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.checkElementVisibilityByScrolling(tvNewsOption, "TV News Section Scrolling");
        commonFunctions.clickElement(tvNewsOption, 5, "TV News Section page");
        boolean isTvNewsDisplayed = commonFunctions.isElementDisplayed(tvNewsPageHeader, 5, "TV News Header Page");
        return isTvNewsDisplayed;
    }

    @Override
    public boolean checkRedirectToStoryFromTTvNewsSection() {
        checkRedirectToTvNewsSection();
        commonFunctions.clickElement(clickFirstStory,5,"First Story");
        commonFunctions.clickElement(skip,5,"Skip");
        boolean isWhatsUpTwitter = commonFunctions.isElementDisplayed(whatsApp, 5, "Whatsup") &&
                commonFunctions.isElementDisplayed(twitter, 5, "Twitter");
        return isWhatsUpTwitter;
    }

    @Override
    public boolean checkCameraIconWithNumberOfPhotosInPhotosSection() {
        commonFunctionsMobile.scrollAndClickToSectionInExplore(home,exploreButton,photosSection,"Photos",photosPageHeader,"Photos");
        boolean isNumInLeadStory = commonFunctions.isElementDisplayed(numOfPhotosInLeadStory,5,"Number In Lead Photo Story");
        String numInLeadStory = commonFunctions.getElementText(numOfPhotosInLeadStory,5);
        int realNumInLeadStory = Integer.parseInt(numInLeadStory);
        System.out.println("Number of Photos - " +realNumInLeadStory);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isNumInLeadStory;
    }

    @Override
    public boolean countInleadStoryInPhotosSection() {
        commonFunctions.clickElement(home, 5, "home");
        commonFunctions.clickElement(exploreButton, 5, "Explore Button");
        commonFunctions.scrollToMobileElement(photosSection);
        commonFunctions.clickElement(photosSection, 5, "Photos Section");
        boolean isPhotosSectionPage = commonFunctions.isElementDisplayed(photosPageHeader, 5, "Photos Page Header");
        boolean isNumInLeadStory = commonFunctions.isElementDisplayed(numOfPhotosInLeadStory,5,"Number In Lead Photo Story");
        System.out.println("Number of Photos - " +Integer.parseInt(numOfPhotosInLeadStory.getText()));
        commonFunctions.clickElement(back,5,"Back button");
        commonFunctions.scrollToTopOniOSNative();
        return isPhotosSectionPage && isNumInLeadStory;
    }

    @Override
    public boolean checkWebStoriesSectionFromTopSection() {
        commonFunctions.clickElement(home,5,"Home");
        boolean isWebStoriesDisplayed = false;
        for(int i=0;i<=5;i++){
        isWebStoriesDisplayed = commonFunctions.isElementDisplayed(webStoriesSection,5,"Web Stories on Top");
        if(isWebStoriesDisplayed){
            commonFunctions.clickElement(webStoriesSection,5,"Web Stories");
            break;
        } else {
            commonFunctions.clickElement(lastSectionOnTop);
            }
        }
        commonFunctions.dummyWait(5);
        boolean IsStoriesDisplayedInWebStories = false;
        if (allStoriesInWebStoriesPage.size() >= 1) {
            IsStoriesDisplayedInWebStories = true;
            Utils.logStepInfo(true, "Stories are visible");
        } else {
            IsStoriesDisplayedInWebStories = false;
            Utils.logStepInfo(false, "Stories are not visible");
        }
        return isWebStoriesDisplayed && IsStoriesDisplayedInWebStories;
    }

    @Override
    public boolean checkWebStoriesSectionFromExplore() {
        commonFunctions.clickElement(home,5,"Home");
        commonFunctions.clickElement(exploreButton,5,"Explore Button");
        boolean isWebStoriesDisplayed = commonFunctions.isElementDisplayed(webStoriesSection,5,"Web Stories on Top");
        if(isWebStoriesDisplayed){
            commonFunctions.clickElement(webStoriesSection,5,"Web Stories");
        }
        boolean IsStoriesDisplayedInWebStories = false;
        if (allStoriesInWebStoriesPage.size() >= 1) {
            IsStoriesDisplayedInWebStories = true;
            Utils.logStepInfo(true, "Stories are visible");
        } else {
            IsStoriesDisplayedInWebStories = false;
            Utils.logStepInfo(false, "Stories are not visible");
        }
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isWebStoriesDisplayed && IsStoriesDisplayedInWebStories;
    }

    @Override
    public boolean checkImagesHorizontalLinesInWebStories() {
        boolean isRedirectToWebStoriesFromTop = checkWebStoriesSectionFromTopSection();
        boolean IsHorizontalLinesInAllStories = false;
        if (allStoriesInWebStoriesPage.size() == allhorizontalLinesInWebStories.size()) {
            IsHorizontalLinesInAllStories = true;
            Utils.logStepInfo(true, "Images horizontal lines are displayed in all Web Stories");
        } else {
            IsHorizontalLinesInAllStories = false;
            Utils.logStepInfo(false, "Images horizontal lines displayed failed");
        }
        return isRedirectToWebStoriesFromTop && IsHorizontalLinesInAllStories;
    }

    @Override
    public boolean checkAppLogoInWebStories() {
        boolean isRedirectToWebStoriesFromTop = checkWebStoriesSectionFromTopSection();
        boolean isStoriesInWebStories = commonFunctions.compareWithSizeListOfElements(threeDotInAllWebStories,2,"Stories In Web Stories Page");
        boolean isHtLogosInWebStoriesPage = commonFunctions.compareWithSizeListOfElements(htLogosInWebStories,2,"HT Logos in Web Stories Page");
        Utils.logStepInfo("Number of HT Logo Displayed in Web Stories = "+htLogosInWebStories.size());
        Utils.logStepInfo("Number of Stories Displayed in Web Stories = "+threeDotInAllWebStories.size());
        boolean isLogoCountsMatchWithWebStories = htLogosInWebStories.size() == threeDotInAllWebStories.size();
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isRedirectToWebStoriesFromTop && isStoriesInWebStories && isHtLogosInWebStoriesPage;
    }

    @Override
    public boolean checkThreeDotsDislpayedInWebStories() {
        boolean isRedirectToWebStoriesFromTop = checkWebStoriesSectionFromTopSection();
        boolean isStoriesInWebStories = commonFunctions.compareWithSizeListOfElements(threeDotInAllWebStories,2,"Three dots In Web Stories Page");
        Utils.logStepInfo("Number of Stories Displayed in Web Stories = "+allStoriesInWebStoriesPage.size());
        Utils.logStepInfo("Number of Three Dots Displayed in Web Stories = "+threeDotInAllWebStories.size());
        boolean isThreeDotsCountsMatchWithWebStories = allStoriesInWebStoriesPage.size() == threeDotInAllWebStories.size();
        return isRedirectToWebStoriesFromTop && isStoriesInWebStories && isThreeDotsCountsMatchWithWebStories;
    }

    @Override
    public boolean checkRedirectionFromCities() {
        commonFunctions.clickElement(home, 5, "Home page");
        boolean isHomePage = commonFunctions.isElementDisplayed(htLogo, 5, "home page");
        //swipe is not working
        commonFunctions.swipeElementUsingTouchAction(120, 105, 275, 105);
        commonFunctions.clickElement(citiesSection, 5, "Section");
        //Commented for now as browserstack returns false for is selected
        //boolean isWorldSelected = commonFunctions.isElementSelected(citiesSection, 5, "Section Page");
        boolean isHomeSelected = commonFunctions.isElementSelected(home, 5, "Home");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isHomePage && isHomeSelected;
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionNamesDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionLiveBlogWithRedDotOnStory() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromExploreToPhotos() {
        return false;
    }

    @Override
    public boolean checkRedirectionFromExploreToVideos() {
        return false;
    }

    @Override
    public boolean checkPremiumStoryInsideSectionPage() {
        return false;
    }

    @Override
    public boolean checkUserScrollToBottomOfTopNewsPage() {
        return false;
    }

    @Override
    public boolean checkForLiveBlogForTopNewsPage() {
        return false;
    }

    @Override
    public boolean checkBottomNavDispalyFromAnotherSectionPage() {
        return false;
    }

    @Override
    public boolean checkSectionRedirectionPage() {
        return false;
    }

    @Override
    public boolean checkIsSectionIndiaNewsScrollable() {
        return false;
    }

    @Override
    public boolean checkIsSectionIndiaNewsDisplayedClickable() {
        return false;
    }

    @Override
    public boolean checkFullStoryVisisbleAndClickableInQuickRead(String quickReadURL, String readSFullStoryText, String target1, String target2) {
        return false;
    }

    @Override
    public boolean checkTopicPage(String topicURL) {
        return false;
    }

    @Override
    public boolean checkFourthStoryPartneredStory() {
        return false;
    }

    @Override
    public boolean checkViewFullScorecard(String cricketUrl, String liveScorecard) {
        return false;
    }

    @Override
    public boolean checkMatchCard(String cricketUrl) {
        return false;
    }

    @Override
    public boolean checkLHSAndRHSData(String indiaNewsUrl) {
        return false;
    }

    @Override
    public boolean checkPagination(String secondPageUrl,String worldNewsUrl) {
        return false;
    }

    @Override
    public boolean checkThirtyStoryOnSectionPage(String worldNewsUrl) {
        return false;
    }

    @Override
    public boolean checkAdsAfterEveryThreeStory() {
        return false;
    }

    @Override
    public boolean checkTopicLandingPage(String topicURL) {
        return false;
    }

    @Override
    public boolean checkL1LandingPage() {
        return false;
    }

    @Override
    public boolean checkBreadcrumbDisplayedFromGoogle(String url, String searchText) {
        return false;
    }

    @Override
    public boolean checkL2NewTag() {
        return false;
    }

    @Override
    public boolean checkFirstStoryInCardView() {
        return false;
    }

    @Override
    public boolean checkAppLaunchDisplayTopSection() {
        return false;
    }

    public void applyDarkMode(){
        commonFunctions.clickElement(home, 5, "Home");
        commonFunctions.clickElement(profileButton, 5, "Profile Button");
        commonFunctions.clickElementIfDisplayed(mayBeLater,5,"Maybe later");
        commonFunctions.clickElement(displayTextSize, 5, "Display & Text Size");
        commonFunctions.clickElement(darkThemes, 5, "Dark Theme");
        commonFunctions.dummyWait(5);
        commonFunctions.clickByCoordinates(316, 238);
        commonFunctions.dummyWait(5);
    }

    @Override
    public boolean checkRedirectionOnForYouSection() {
        commonFunctions.clickElement(home,5,"Home button");
        boolean isForYouSectionDisplayed = commonFunctions.clickElementIfDisplayed(forYouSectionTab,5,"For You section tab");
        //browserstack returns false for is selected, hence disabling this step
        //boolean isForYouTabSelected = commonFunctions.isElementSelected(forYouSectionTab,5,"For You Tab");
        return isForYouSectionDisplayed;
    }

    @Override
    public boolean checkEditProfilePageInDarkMode() {
        return false;
    }

    @Override
    public boolean checkTextOnCityPopUp() {
        boolean isCitiesSectionDisplay = commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitiesSectionDisplay;
    }

    @Override
    public boolean checkRedirectionOnCitiesSection() {
        return  checkRedirectionWhenTapOnGotItButton();
    }

    @Override
    public boolean checkRedirectionWhenTapOnGotItButton() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isAddYourFavouriteCitiesDisplayed = commonFunctions.isElementDisplayed(addFavouriteCities,5,"Add your favourite cities");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isAddYourFavouriteCitiesDisplayed;
    }

    @Override
    public boolean checkNoRedirectionWhenTapOnWhenAnyWhereExceptGotItButton() {
        checkTextOnCityPopUp();
        commonFunctions.clickElement(popUpMessageOnCities,5,"Tap anywhere on cities pop up except got it button");
        boolean isRedirectedToCitiesSection = commonFunctions.isElementDisplayed(addFavouriteCities,5,"Add your favourite cities");
        if(isRedirectedToCitiesSection == false) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkPlusSignDisplayBeforeCityName() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isPlusSignDisplayedBeforeCityName = commonFunctions.isElementDisplayed(plusSignBeforeCity,5,"\"+\" sign before city name");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isPlusSignDisplayedBeforeCityName;
    }

    @Override
    public boolean checkHorizontalLinesAtEndOfCityName() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isHorizontalLinesDisplayedAfterCityName = commonFunctions.isElementDisplayed(horizontalLinesTab,5,"Horizontal lines at the end of city name");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isHorizontalLinesDisplayedAfterCityName;
    }

    @Override
    public boolean checkMayBeLaterAndSaveChangesButton() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isMayBeLaterButtonDisplayed = commonFunctions.isElementDisplayed(mayBeLaterButtonOnCitiesSection, 5, "May be later button at the end of screen");
        boolean isSaveChangesButtonDisplayed = commonFunctions.isElementPresent(saveChangesButtonOnCitiesSection, 5, "Save changes button at the end of screen");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isMayBeLaterButtonDisplayed && isSaveChangesButtonDisplayed;
    }

    @Override
    public boolean checkOthersOptionInCities() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.scrollToElementDown(othersOptionInCities);
        boolean isOthersDisplayed = commonFunctions.isElementDisplayed(othersOptionInCities,5,"Others option in cities");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isOthersDisplayed;
    }

    @Override
    public boolean checkBehaviourWhenUserTapsOnPlusButtonBeforeCityName() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElement(plusSignBeforeCity,5,"Select any city in cities");
        boolean isSaveChangesEnabled = commonFunctions.isElementClickable(saveChangesButtonOnCitiesSection,5,"Save Changes enable");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isSaveChangesEnabled;
    }

    @Override
    public boolean checkBehaviourWhenUserTapsOnMayBeLaterButton() {
        boolean isRedirect = commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElement(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        boolean isAddCitiesDisplayed = commonFunctions.isElementDisplayed(addCitiesOption,5,"Add cities option");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isAddCitiesDisplayed && isRedirect;
    }

    @Override
    public boolean checkBehaviourNoCitySelectedAndTapsOnSaveChangesButton() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElementIfDisplayed(unSelectCities,5,"Deselect selected city");
        commonFunctions.clickElementIfDisplayed(saveChangesButtonOnCitiesSection,5,"Save Changes Button");
        boolean isAddYourFavouriteCitiesDisplayed = commonFunctions.isElementDisplayed(addFavouriteCities,5,"Add your favourite cities");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isAddYourFavouriteCitiesDisplayed;
    }

    @Override
    public boolean checkPopUpWhenSelectAnyCity() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida city",saveChangesButtonOnCitiesSection);
        String textOnCityPopUp = commonFunctions.getElementText(citySuccessfulPopUp,5);
        boolean isCitySuccessfulPopUpVerified = commonFunctions.checkTextEquals(textOnCityPopUp,"City Selected Successfully","City Selected Successfully");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        int sizeOfSelectedCities = listofSelectedCitiies.size();
        if(sizeOfSelectedCities ==2) {
            commonFunctions.clickElement(listofSelectedCitiies.get(1),5,"Unselect second selected city");
        }
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes button");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitySuccessfulPopUpVerified;
    }

    @Override
    public boolean checkSelectedCityShownUnderCitiesSection() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        boolean isSelectedCityDisplayed = commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isSelectedCityDisplayed;
    }

    @Override
    public boolean checkBehaviourWhenUserSelectAnyCityAndTapsOnMayBeLaterButton() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElement(plusSignBeforeCity,5,"Select any city");
        commonFunctions.clickElement(mayBeLaterButtonOnCitiesSection,5,"May be later button");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        boolean isSaveChangesDisabled = commonFunctions.isElementClickable(saveChangesButtonOnCitiesSection,5,"Save changes");
        if(isSaveChangesDisabled == false) {
            commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean checkDateInCitiesAfterSelectedCity() {
        boolean isCitySelected = commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        boolean isDateDisplayed = commonFunctions.isElementDisplayed(dateOnSelectedCity,5,"Date after selected city");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitySelected && isDateDisplayed;
    }

    @Override
    public boolean checkTemperatureDisplayedInCitiesSection() {
        boolean isCitySelected = commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        boolean isTemperatureDisplayed = commonFunctions.isElementDisplayed(temperatureInCities,5,"Temperature");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitySelected && isTemperatureDisplayed;
    }

    @Override
    public boolean checkCityNameDisplayedAfterAdWithNews() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctions.isElementDisplayed(adInCities,5,"Advertisement in cities before city name");
        boolean isCityNameDisplayedWithNews = commonFunctions.isElementDisplayed(citiNameWithNews,5,"City name with news");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCityNameDisplayedWithNews;
    }

    @Override
    public boolean checkRedirectionWhenTapOnOtherSelectedCities() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Select Noida city",saveChangesButtonOnCitiesSection);
        commonFunctions.clickElement(noidaCitySelectButton,5,"Noida city");
        boolean isNoidaNewsDisplayed = commonFunctions.getElementTextAndCheck(citiNameWithNews,"Noida News",5,"City name with news");
        commonFunctionsMobile.selectOrDeselectSecondCity(addCitiesOption,mayBeLaterButtonOnCitiesSection,noidaCitySelectButton,"Deselect Noida city",saveChangesButtonOnCitiesSection);
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isNoidaNewsDisplayed;
    }

    @Override
    public boolean checkRedirectionWhenTapOnMultipleCities() {
        commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctions.clickElementIfDisplayed(unSelectCities,5,"Deselect selected city");
        commonFunctions.clickElement(listOfUnselectedCities.get(1),5,"Select Second city");
        commonFunctions.clickElement(listOfUnselectedCities.get(0),5,"Select First city");
        String nameOfFirstCity = commonFunctions.getElementText(listofSelectedCitiies.get(0),5);
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes");
        boolean isFirstCitySelected = commonFunctions.getElementTextAndCheck(citiNameWithNews,nameOfFirstCity+" News",5,"First selected city");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.clickElement(listofSelectedCitiies.get(1),5,"Deselect Second selected city");
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isFirstCitySelected;
    }

    @Override
    public boolean checkBehaviourWhenUserDeselectAnySelectedCity() {
        boolean isCitySelected = commonFunctionsMobile.checkTextOnCitiesSection(home,citiesSection,gotItButtonOnCitiesPopUp,mayBeLaterButtonOnCitiesSection,addCitiesOption);
        commonFunctionsMobile.selectFirstCity(delhiSelectButton,"Delhi city",mayBeLaterButtonOnCitiesSection,saveChangesButtonOnCitiesSection,addFavouriteCities);;
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.clickElementIfDisplayed(gurugramCitySelectButton,5,"Gurugram city select button");
        commonFunctions.clickElementIfDisplayed(noidaCitySelectButton,5,"Noida city select button");
        commonFunctions.clickElementIfDisplayed(mumbaiCitySelectButton,5,"Mumbai city select button");
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes");
        boolean isMumbaiCityDisplayed = commonFunctions.isElementDisplayed(mumbaiCitySelectButton,5,"Mumbai city in L2");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities button");
        commonFunctions.clickElement(mumbaiCitySelectButton,5,"Mumbai city deselect button");
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes button");
        boolean isMumbaiCityNotDisplayed = commonFunctions.isElementNotDisplayed(mumbaiCitySelectButton,5,"Mumbai city in L2");
        commonFunctions.clickElement(addCitiesOption,5,"Add cities");
        commonFunctions.clickElement(gurugramCitySelectButton,5,"Deselect Gurugram city");
        commonFunctions.clickElement(noidaCitySelectButton,5,"Deselect Noida city");
        commonFunctions.clickElement(saveChangesButtonOnCitiesSection,5,"Save changes button");
        commonFunctions.killAppAndReLaunch(notificationLater,5,"Later");
        return isCitySelected && isMumbaiCityDisplayed && isMumbaiCityNotDisplayed;
    }
}