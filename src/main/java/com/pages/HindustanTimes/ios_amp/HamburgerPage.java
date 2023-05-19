package com.pages.HindustanTimes.ios_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.HindustanTimes.generic.CommonHamburgerPage;
import com.utils.GlobalVars;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HamburgerPage extends CommonHamburgerPage {
    private static IOSDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    @FindBy(id = "agree")
    private static WebElement acceptCookie;

    @FindBy(className = "btnExplore")
    private static WebElement hamBurger;

    @FindBy(xpath="//div[@class='nav-sec']//a//em")
    private static List<WebElement> hamburgerMenuOptions;

    @FindBy(xpath="//div[@class='nav-sec']//li[3]//a")
    private static WebElement entertainmentOption;

    @FindBy(xpath="//div[@class='btnExplore']/button")
    private static WebElement hamburgerButton;

    public HamburgerPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctions.clickElementIfDisplayed(acceptCookie, 20, "accept cookie button");
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    public boolean clickOnHamburgerButton() {
        boolean isExplorerMenuClickSuccessful=false;
        try{
            isExplorerMenuClickSuccessful= commonFunctions.clickElement(hamburgerButton, 60,"hamburgerButton");
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExplorerMenuClickSuccessful;
    }

    public boolean checkHamburgerMenuAllOptionDisplayed() {
        boolean isHamburgerMenuAllOptionsDisplayed=false;

        try{
            int menuNamesCount = hamburgerMenuOptions.size();
            for(int i=0;i<5;i++) {
                String menuName = hamburgerMenuOptions.get(i).getText();
                if(!menuName.isEmpty()) {
                    isHamburgerMenuAllOptionsDisplayed = hamburgerMenuOptions.get(i).isDisplayed();
                    commonFunctions.scrollToElementView(hamburgerMenuOptions.get(i),60,"hamburgerOptions");
                    if(isHamburgerMenuAllOptionsDisplayed) {
                        commonFunctions.elementToTextDisplayed(menuName);
                    } else {
                        isHamburgerMenuAllOptionsDisplayed=false;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            isHamburgerMenuAllOptionsDisplayed =false;
        }
        return isHamburgerMenuAllOptionsDisplayed;
    }


    public boolean clickOnEntertainmentSection() {
        boolean isClickOnEntertainmentSuccessful=false;
        try{
            commonFunctions.navigateToURL(globalVars.getURL());
            commonFunctions.clickElement(hamburgerButton, 60,"hamburgerButton");
            commonFunctions.dummyWait(10);
            isClickOnEntertainmentSuccessful = commonFunctions.clickElementWithJS(entertainmentOption, 60,"entertainmentOption");
            commonFunctions.dummyWait(10);
        }catch(Exception e){
            e.printStackTrace();
        }
        return isClickOnEntertainmentSuccessful;
    }

    public boolean checkRedirectionToEntertainmentSection()  {
        boolean isRedirectToEntertainmentSuccessful=false;
        try{
            String currentURL = commonFunctions.getCurrentURL("URL","getCurrentURL Successful");
            System.out.println(currentURL);
            if(currentURL.equals(globalVars.getProdUrl()+"entertainment/amp")) {
                isRedirectToEntertainmentSuccessful = true;
                commonFunctions.dummyWait(5);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(isRedirectToEntertainmentSuccessful);
        return isRedirectToEntertainmentSuccessful;
    }

    @Override
    public boolean checkAnySectionPage() {
        return false;
    }

    @Override
    public boolean checkIndiaNewsPageScrollable() {
        return false;
    }

    @Override
    public boolean checkHamberburgerCases() {
        return false;
    }

    @Override
    public boolean checkHamburgerElementsClickable() {
        String url=globalVars.getURL();
        boolean clickOnHamburger=clickOnHamburgerButton();
        boolean checkHamburgerMenuOptions=checkHamburgerMenuAllOptionDisplayed();
        boolean clickEntertainmentSection=clickOnEntertainmentSection();
        boolean checkEntertainmentRedirection=checkRedirectionToEntertainmentSection();

        return clickOnHamburger && checkHamburgerMenuOptions && clickEntertainmentSection && checkEntertainmentRedirection;
    }

    @Override
    public boolean clickOnExplorerMenu() throws Exception {
        return false;
    }

    @Override
    public boolean checkNavigationIndiaNews() {
        return false;
    }

    @Override
    public boolean breadcrumbDisplayedOtherThanHomePage() {
        return false;
    }

    @Override
    public boolean checkNavigationPopularNews() {
        return false;
    }

    @Override
    public boolean checkNavigationCricketNews() {
        return false;
    }

    @Override
    public boolean checkNavigationEditorialNews() {
        return false;
    }

    @Override
    public boolean checkNavigationEntertainmentNews() {
        return false;
    }

    @Override
    public boolean checkNavigationCitiesNews() {
        return false;
    }

    @Override
    public boolean checkNavigationLatestNews() {
        return false;
    }

    @Override
    public boolean checkHamburgerMenuEntertainmentNewsOptionDisplayed() throws Exception {
        return false;
    }

    @Override
    public boolean clickWorldNewsSectionOnHamburgerMenu() {
        return false;
    }

    @Override
    public boolean checkExploreHTOptionDisplayedOnHamburgerMenu() {
        return false;
    }

    @Override
    public boolean checkPopularSectionsDisplayed() {
        return false;
    }

    @Override
    public boolean checkSectionsDisplayed() {
        return false;
    }
}
