package com.pages.LiveHindustan.commonFunctions;

import com.base.DriverController;
import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.utils.GlobalVars;
import com.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CommonFunctionsWebLH {
    private static int tryCount = 0;
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWebLH commonFunctionsWeb;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsMobile commonFunctionsMob;
    private static DriverController driverController;

    public static CommonFunctionsWebLH getInstance() {
        driverController = DriverController.getInstance();
        if (commonFunctionsWeb == null) {
            commonFunctionsWeb = new CommonFunctionsWebLH();
        }
        return commonFunctionsWeb;
    }

    public CommonFunctionsWebLH() {
        globalVars = GlobalVars.getInstance();
        driver = globalVars.getWebDriver();
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsMob = CommonFunctionsMobile.getInstance();
    }

    public boolean isAllElementsClickableAndNavigatedToCorrectURL(WebElement storySection, List<WebElement> allStories,int storySize) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;
        boolean storiesSize = false;
        int widgetStoriesCount = 0;
        commonFunctions.scrollDown(storySection);
        commonFunctions.dummyWait(5);
        commonFunctions.moveToElementWithActions(storySection,10,storySection.getText());
        if(commonFunctions.isElementDisplayed(storySection,10,storySection.getText() +" Widget")) {
            commonFunctions.scrollToElement(storySection,"next element");
            commonFunctions.dummyWait(5);
            int widgetStoriesSize = allStories.size();
            if (widgetStoriesSize == storySize) {
                for (int i = 0; i <= allStories.size() - 1; i++) {
                    widgetStoriesCount++;
                    String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
                    String menuTitle = allStories.get(i).getText();
                    isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, menuTitle);
                    commonFunctions.dummyWait(5);
                    ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
                    int windowSize=windowsList.size();
                    if(windowSize>1){
                        System.out.println("inside");
                        commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
                        Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                        isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                        isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
                        commonFunctions.closeAllWindowsExceptMasterTabOnly();
                        commonFunctions.dummyWait(5);
                    }
                    else{
                        Utils.logStepInfo(true, "current url is: " + commonFunctions.getCurrentURL());
                        isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
                        isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
                        commonFunctions.navigateBack(2);
                        commonFunctions.dummyWait(5);
                    }
                }
                if (widgetStoriesCount == storySize)
                    storiesSize = true;
            } else {
                Utils.logStepInfo(false, "Mismatch in expected and actual widget story size");
            }
        }
        else
        {
            Utils.logStepInfo(false, "Story section "+ storySection.getText()+" is not displayed");
        }
        return isUrlClickable && isLinkReturn200 && isUrlMatches && storiesSize;
    }


    public void clickElementWithGivenText(List<WebElement> elementList, String expectedResult) {
        for (int i = 0; i < elementList.size(); i++) {
            commonFunctions.moveToElementWithActions(elementList.get(i), 10, elementList.get(i).getText());
            if (elementList.get(i).getText().trim().contains(expectedResult)) {
                commonFunctions.clickElement(elementList.get(i), 10, expectedResult);
                break;
            }
        }
    }

    public boolean isAllElementsClickableAndNavigatedToCorrectURL(List<WebElement> allStories,int elementSize, String navigateUrl) {
        boolean isUrlMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;

        for (int i = 0; i < elementSize; i++) {
            commonFunctions.scrollToElement(allStories.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String url = commonFunctions.getAttributeValue(allStories.get(i), 10, "href");
            String menuTitle = allStories.get(i).getText().trim();

            isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, menuTitle);
            if(isUrlClickable == false){
                System.out.println(menuTitle+" is not clickable");
                Utils.logStepInfo(false, menuTitle+" is not clickable");
                break;
            }
            commonFunctions.dummyWait(5);
            System.out.println("url " +commonFunctions.getCurrentURL());
            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(menuTitle+" Status code is not 200");
                Utils.logStepInfo(false, menuTitle+" Status code is not 200");
                break;
            }

            if(menuTitle.equalsIgnoreCase("गौरीगंज")){
                isUrlMatches &= commonFunctions.getCurrentURL().contains("amethi");
            }else if(menuTitle.equalsIgnoreCase("ट्रांस हिंडन")){
                isUrlMatches &= commonFunctions.getCurrentURL().contains("ghaziabad");
            }else {
                isUrlMatches &= commonFunctions.getCurrentURL().contains(url);
            }

            if(isUrlMatches == false){
                System.out.println(menuTitle+" href is not matching with current url");
                Utils.logStepInfo(false, menuTitle+" href is not matching with current url");
                break;
            }
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }

        return isUrlMatches && isUrlClickable && isLinkReturn200;
    }

    public boolean isAllElementsClickableAndGiving200Status(List<WebElement> allStories,int elementSize, String navigateUrl, WebElement brdCrumredFirst, WebElement brdCrumredSec, WebElement brdCrumredThird) {
        boolean isMatches = true;
        boolean isUrlClickable = true;
        boolean isLinkReturn200 = true;

        for (int i = 0; i < elementSize; i++) {
            commonFunctions.scrollToElement(allStories.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String menuTitle = allStories.get(i).getText().trim();

            isUrlClickable &= commonFunctions.clickElementWithJS(allStories.get(i), 10, menuTitle);
            if(isUrlClickable == false){
                System.out.println(menuTitle+" is not clickable");
                Utils.logStepInfo(false, menuTitle+" is not clickable");
                break;
            }
            commonFunctions.dummyWait(5);

            isLinkReturn200 &= commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(menuTitle+" Status code is not 200");
                Utils.logStepInfo(false, menuTitle+" Status code is not 200");
                break;
            }

            if(i==0){
                System.out.println("brdCrumredFirst:- "+brdCrumredFirst.getText());
                isMatches &= brdCrumredFirst.getText().trim().contains("Hindi News");
            }else if(i==1){
                System.out.println("brdCrumredSec:- "+brdCrumredSec.getText());
                isMatches &= brdCrumredSec.getText().trim().contains(menuTitle.trim());
            }else if(i==2){
                System.out.println("brdCrumredThird:- "+brdCrumredThird.getText());
                isMatches &= brdCrumredThird.getText().trim().contains(menuTitle.trim());
            }

            if(isMatches == false){
                System.out.println(menuTitle+" BrdCurm is not redirecting to respected page");
                Utils.logStepInfo(false, menuTitle+" BrdCurm is not redirecting to respected page");
                break;
            }
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }

        return isMatches && isUrlClickable && isLinkReturn200;
    }

    public void navigateToPhotoPage(WebElement photoMenu, WebElement photoWdgt, String env, String url){
        commonFunctions.navigateToURL(globalVars.getURL());
        if(env.equalsIgnoreCase("AMP")){
            commonFunctions.navigateToURL(url);
        }else {
            commonFunctions.waitForPageToLoad();
            commonFunctions.dummyWait(5);
            commonFunctions.scrollToElement(photoMenu, "Photo Menu");
            commonFunctions.clickElementWithJS(photoMenu, 10, "Photo Menu");
        }
        commonFunctions.isElementDisplayed(photoWdgt, 10, "Photo Wdgt");
    }

    public boolean validateSocialSharingIconFunctionality(WebElement element, String matchingStr, String navigateUrl, String iconName){
        boolean socialFlag = false;
        boolean isLinkReturn200 = false;
        try{
            commonFunctions.waitForPageToLoad();
            commonFunctions.scrollToElement(element, iconName);
            commonFunctions.clickElementWithJS(element, 10, iconName);
            commonFunctions.dummyWait(5);
            ArrayList<String> windowsList = new ArrayList<>(commonFunctions.getWindowHandles());
            commonFunctions.switchToWindow(windowsList.get(windowsList.size() - 1));
            socialFlag = commonFunctions.getCurrentURL().contains(matchingStr);
            if(socialFlag == false){
                System.out.println(iconName+" Icon is not redirecting proper page");
                Utils.logStepInfo(false, iconName+" Icon is not redirecting proper page");
            }
            isLinkReturn200 = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
            if(isLinkReturn200 == false){
                System.out.println(iconName+" Status code is not 200");
                Utils.logStepInfo(false, iconName+" Status code is not 200");
            }
            commonFunctions.closeAllWindowsExceptMasterTab();
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }catch(Exception e){
            commonFunctions.closeAllWindowsExceptMasterTab();
            commonFunctions.navigateToURL(navigateUrl);
            commonFunctions.dummyWait(5);
        }
        return socialFlag && isLinkReturn200;
    }

    public boolean validatePlayAndPauseButton(WebElement ytplayerFrame, WebElement videoState, WebElement player, String attributeStr){
        boolean playerStatus=true;
        commonFunctions.dummyWait(5);
        commonFunctions.switchToFrame(ytplayerFrame, 10);
        commonFunctions.scrollToViewElement(videoState, "video",  5);
        String videoStateValue = commonFunctions.getAtribute(videoState, attributeStr);
        if(videoStateValue.trim().equalsIgnoreCase("Play")){
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Pause");
            if(playerStatus == false){
                System.out.println("Play is not working");
                Utils.logStepInfo("Play is not working");
            }
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Play");
            if(playerStatus == false){
                System.out.println("Pause is not working");
                Utils.logStepInfo("Pause is not working");
            }
        }else if(videoStateValue.trim().equalsIgnoreCase("Pause")){
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Play");
            if(playerStatus == false){
                System.out.println("Pause is not working");
                Utils.logStepInfo("Pause is not working");
            }
            commonFunctions.scrollPageWithJS(player, 5);
            commonFunctions.clickElement(player, 5, "player");
            commonFunctions.dummyWait(10);
            playerStatus &= commonFunctions.getAtribute(videoState, attributeStr).trim().equalsIgnoreCase("Pause");
            if(playerStatus == false){
                System.out.println("Play is not working");
                Utils.logStepInfo("Play is not working");
            }
        }

        commonFunctions.switchToDefaultContent();


        return playerStatus;
    }

    public boolean navigateToPhotoPage(WebElement photoMainMenu){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.clickElementWithJS(photoMainMenu,10,"photo main menu");
        commonFunctions.dummyWait(5);
        return commonFunctions.getCurrentURL().contains("/photos");
    }
    public boolean photoInExpandView(WebElement photoMainMenu,WebElement firstPhotoTitle,WebElement expandIcon,WebElement aanyaGalleryIcon){
        boolean isLandingPageOnPhotos=navigateToPhotoPage(photoMainMenu);
        String firstMainPhotoTextOfThePage = commonFunctions.getElementText(firstPhotoTitle, 10);
        commonFunctions.clickElementWithJS(firstPhotoTitle, 10, firstMainPhotoTextOfThePage);
        commonFunctions.dummyWait(5);
        commonFunctions.clickElementWithActions(expandIcon, 10, "Expand button for " + firstMainPhotoTextOfThePage);
        boolean isAanyaGalleryDisplayed = commonFunctions.isElementDisplayed(aanyaGalleryIcon, 10, "अन्य गैलरीी button");
        return isLandingPageOnPhotos && isAanyaGalleryDisplayed;
    }

}
