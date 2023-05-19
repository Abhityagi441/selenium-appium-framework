package com.pages.LiveHindustan.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonLandingPage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LandingPage extends CommonLandingPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobileLH;
    @FindBy(xpath = "//div[@class='lhs-menu']/a[@title='मनोरंजन']")
    private static WebElement ampEntertainmentMenu;
    @FindBy(xpath = "//p[@class='wdgt-subtitle1']/ancestor::a")
    private static List<WebElement> entertainmentStories;
    @FindBy(xpath = "//div[@class='lhs-menu']/a")
    private static List<WebElement> homePageMenu;
    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> relatedPageSubMenu;
    @FindBy(xpath = "//div[@class='lhs-menu']/a[@title='देश']")
    private static WebElement ampNationalMenu;
    @FindBy(xpath = "//a[@class='thembtn']")
    private static WebElement aurPadheButton;

    public LandingPage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkLandingPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        return commonFunctionsMobileLH.checkEntertainmentLandingPageOnAMP(ampEntertainmentMenu,entertainmentStories);
    }

    @Override
    public boolean checkLandingPageSubMenu(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        return isAllRelatedLandingPageSubMenuTrue();
    }

    @Override
    public boolean checkAurPadheButtonOnLandingPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.scrollToElement(ampNationalMenu, 10, "National Menu");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(2);
        boolean isPhotoMenuPresent = commonFunctions.isElementPresent(ampNationalMenu,10,"National Menu");
        commonFunctions.clickElementWithJS(ampNationalMenu);
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(aurPadheButton, "Aur Padhe Button");
        commonFunctions.clickElementWithJS(aurPadheButton, 10, "Aur Padhe Button");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        String currentUrl = commonFunctions.getCurrentURL();
        return currentUrl.contains("news-2") && !currentUrl.contains("amp_")&&isPhotoMenuPresent;
    }

    public boolean isAllRelatedLandingPageSubMenuTrue() {
        String linkTitle;
        String urlContains;
        boolean isAllLandingPageAreRelated = true;
        boolean isAllLandingSubMenuAreRelated = true;
        int menuSize = homePageMenu.size();
        System.out.println("menuSize:- "+menuSize);
        for (int i=1; i<menuSize; i=i+4) {
            commonFunctions.moveToElementWithActions(homePageMenu.get(i), 10, "homePageMenu");
            linkTitle = commonFunctions.getElementText(homePageMenu.get(i), 10);
            urlContains = commonFunctions.getAttributeValue(homePageMenu.get(i), 10, "href");
            commonFunctions.moveToElementWithActions(homePageMenu.get(i), 10, linkTitle);
            commonFunctions.clickElementWithJS(homePageMenu.get(i), 10, linkTitle);
            commonFunctions.waitForPageToLoad();
            String currentUrl = commonFunctions.getCurrentURL();
            isAllLandingPageAreRelated &= commonFunctions.getCurrentURL().contains(urlContains);
            if (!isAllLandingPageAreRelated) {
                break;
            } else {
                if (currentUrl.contains("amp_")){
                    String subMenuLinkTitle;
                    String subMenuUrlContains;
                    int subMenuSize = relatedPageSubMenu.size();
                    for (int j = 0; j < subMenuSize; j=j+4) {
                        commonFunctions.moveToElementWithActions(relatedPageSubMenu.get(j), 10, "relatedPageSubMenu");
                        subMenuLinkTitle = commonFunctions.getElementText(relatedPageSubMenu.get(j), 10);
                        subMenuUrlContains = commonFunctions.getAttributeValue(relatedPageSubMenu.get(j), 10, "href");
                        commonFunctions.moveToElementWithActions(relatedPageSubMenu.get(j), 10, subMenuLinkTitle);
                        commonFunctions.clickElementWithJS(relatedPageSubMenu.get(j), 10, subMenuLinkTitle);
                        commonFunctions.waitForPageToLoad();
                        System.out.println("Url After Click:- "+commonFunctions.getCurrentURL());
                        isAllLandingSubMenuAreRelated &= commonFunctions.getCurrentURL().contains(subMenuUrlContains);
                        if (!isAllLandingSubMenuAreRelated) {
                            break;
                        } else {
                            driver.navigate().back();
                            commonFunctions.waitForPageToLoad();
                            commonFunctions.dummyWait(5);
                        }
                    }
                    commonFunctions.navigateToURL(globalVars.getURL());
                    commonFunctions.waitForPageToLoad();
                    commonFunctions.dummyWait(5);
            }else{
                    commonFunctions.navigateToURL(globalVars.getURL());
                    commonFunctions.waitForPageToLoad();
                    commonFunctions.dummyWait(5);
                }
        }
        }
        return isAllLandingPageAreRelated && isAllLandingSubMenuAreRelated;
    }

}
