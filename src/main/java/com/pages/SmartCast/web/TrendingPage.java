package com.pages.SmartCast.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.SmartCast.generic.CommonTrendingPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrendingPage extends CommonTrendingPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "(//button[@class='ng-binding'])[1]")
    private static WebElement dontAllow;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;
    @FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[2]")
    private static WebElement hamburgerTrending;
    @FindBy(xpath="(//div[@id='topcharts']/div/h4)[1]")
    private static WebElement trendingShows;
    @FindBy(xpath="(//div[@id='topcharts']/div/h4)[2]")
    private static WebElement trendingEpisodes;
    @FindBy(xpath = "//h5[@class='heading']/a")
    private static List<WebElement> trendingShowsAndEpisodesList;


    public TrendingPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        long t1=System.currentTimeMillis();
        commonFunctions.clickElementIfDisplayed(allow, 10,"enable-notifications");
        long t2=System.currentTimeMillis();
        System.out.println("Cookie time for "+globalVars.getProjectName()+" >> "+(t2-t1));
        System.out.println("****************** Test started for :"+globalVars.getProjectName());

    }


    @Override
    public boolean navigateToTrendingPage() {
        boolean navigateToTrendingPageStatus = false;
        try{
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