package com.pages.SmartCast.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.SmartCast.generic.CommonSearchPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends CommonSearchPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(id = "srch")
    private static WebElement searchTextBox;
    @FindBy(xpath = "//div[@class='form-group']/input[2]")
    private static WebElement searchIcon;
    @FindBy(xpath = "//div[@class='searchTags']/span[1]")
    private static WebElement showsButton;
    @FindBy(xpath = "//div[@class='mediaInfo']/h5/a")
    private static WebElement showsResult;
    @FindBy(xpath = "//div[@class='searchTags']/span[2]")
    private static WebElement episodesButton;
    @FindBy(xpath = "//div[@class='mediaInfo']/h6/a")
    private static WebElement episodesResult;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;

    public SearchPage() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        long t1=System.currentTimeMillis();
        commonFunctions.clickElementIfDisplayed(allow, 10,"Allow Notifications");
        long t2=System.currentTimeMillis();
        System.out.println("Cookie time for "+globalVars.getProjectName()+" >> "+(t2-t1));
        System.out.println("****************** Test started for :"+globalVars.getProjectName());

    }

    @Override
    public boolean getSearchResults(String expectedText) {
        boolean isShowsSearchSuccessful = false;
        boolean isEpisodesSearchSuccessful=false;
        boolean isSearchSuccessfulStatus;
        try {
            commonFunctions.sendKey(searchTextBox, expectedText, 10);
            commonFunctions.clickElementIfDisplayed(searchIcon, 10, "SearchIcon");
            commonFunctions.isElementDisplayedIgnoringStaleElement(showsButton, 10, "Shows Button");
            commonFunctions.clickElementWithFluentWait(showsButton, 10, "Shows Button");
            isShowsSearchSuccessful = commonFunctions.checkElementText(showsResult, expectedText, 10, "Correct text for shows");
            commonFunctions.isElementDisplayedIgnoringStaleElement(episodesButton, 10, "Episodes Button");
            commonFunctions.clickElementWithFluentWait(episodesButton, 10, "Episodes Button");
            isEpisodesSearchSuccessful = commonFunctions.checkElementText(episodesResult, expectedText, 10, "Correct text for Episodes");
            commonFunctions.navigateToHomePageSC();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (isShowsSearchSuccessful && isEpisodesSearchSuccessful) {
            isSearchSuccessfulStatus = true;
        } else {
            isSearchSuccessfulStatus = false;
        }
        return isSearchSuccessfulStatus;
    }
}