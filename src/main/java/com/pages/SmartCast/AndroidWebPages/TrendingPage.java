package com.pages.SmartCast.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.SmartCast.generic.CommonTrendingPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrendingPage extends CommonTrendingPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(xpath = "(//button[@class='ng-binding'])[1]")
    private static WebElement dontAllow;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;
    @FindBy(xpath = "//div[contains(@class,'mobileLinear')]")
    private static WebElement hamburger;
    @FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[2]")
    private static WebElement hamburgerTrending;
    @FindBy(xpath="(//div[@id='topcharts']/div/h4)[1]")
    private static WebElement trendingShows;
    @FindBy(xpath="(//div[@id='topcharts']/div/h4)[2]")
    private static WebElement trendingEpisodes;
    @FindBy(xpath = "//div[@class='mediaInfo']/h5/a")
    private static List<WebElement> trendingShowsAndEpisodesList;


    public TrendingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(allow, 10, "allow notifications");
        if (isElementPresent) { commonFunctions.clickElementIfDisplayed(allow,20,"allow notifications"); }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }


    @Override
    public boolean navigateToTrendingPage() {
        boolean navigateToTrendingPageStatus = false;
        try{
            commonFunctions.isElementClickable(hamburger,30,"hamburger Menu");
            commonFunctions.clickElementIfDisplayed(hamburger,20,"hamburger Menu");
            navigateToTrendingPageStatus=commonFunctions.navigateToSpecificPage(hamburgerTrending,30,"Trending Section");
            navigateToTrendingPageStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return navigateToTrendingPageStatus;
    }

    @Override
    public String getSmartCastTitle() {
        return commonFunctions.getTitle();
    }

    @Override
    public boolean checkTrendingSection(String expectedTextForShows, String expectedTextForEpisodes) {
        boolean checkTrendingSectionStatus;
        boolean isTrendingShowsAvailable = false;
        boolean isTrendingEpisodesAvailable = false;
        boolean isTrendingShowsAndEpisodesListAvailable = false;
        try{
            isTrendingShowsAvailable=commonFunctions.checkElementText(trendingShows,expectedTextForShows,30,"Trending Shows Heading");
            commonFunctions.scrollToElement(trendingEpisodes,"Trending Episodes");
            isTrendingEpisodesAvailable=commonFunctions.checkElementText(trendingEpisodes,expectedTextForEpisodes,30,"Trending Episodes Heading");
            Utils.logStepInfo(true,"******** Trending SHOWS And EPISODES List are given below ********");
            isTrendingShowsAndEpisodesListAvailable= commonFunctions.getElementListText(trendingShowsAndEpisodesList,60);
            Utils.logStepInfo(true,"******** Trending SHOWS And EPISODES List are completed **********");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isTrendingEpisodesAvailable && isTrendingShowsAvailable && isTrendingShowsAndEpisodesListAvailable) {
            checkTrendingSectionStatus = true;
        } else {
            checkTrendingSectionStatus = false;
        }
        return checkTrendingSectionStatus;
    }

}