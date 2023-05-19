package com.pages.SmartCast.AndroidWebPages;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.SmartCast.generic.CommonSearchPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends CommonSearchPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "srch")
    private static WebElement searchTextBox;
    @FindBy(xpath = "//div[@class='container']/span[2]")
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
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        boolean isElementPresent = commonFunctions.isElementDisplayedAndPresent(allow, 10, "allow notifications");
        if (isElementPresent) { commonFunctions.clickElementIfDisplayed(allow,20,"allow notifications"); }
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");

    }

    @Override
    public boolean getSearchResults(String expectedText) {
        boolean isShowsSearchSuccessful = false;
        boolean isEpisodesSearchSuccessful=false;
        boolean isSearchSuccessfulStatus;
        try {
            commonFunctions.clickElementIfDisplayed(searchIcon, 10, "SearchIcon");
            commonFunctions.sendKeysWithEnter(searchTextBox, expectedText, 10,"search Text Box");
            commonFunctions.isElementDisplayed(showsButton, 10, "Shows Button");
            commonFunctions.clickElementWithJS(showsButton, 10, "Shows Button");
            isShowsSearchSuccessful = commonFunctions.checkElementText(showsResult, expectedText, 10, "Correct text for shows");
            commonFunctions.isElementDisplayed(episodesButton, 10, "Episodes Button");
            commonFunctions.clickElementWithJS(episodesButton, 10, "Episodes Button");
            isEpisodesSearchSuccessful = commonFunctions.checkElementText(episodesResult, expectedText, 10, "Correct text for Episodes");
            commonFunctions.navigateToHomePage();
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