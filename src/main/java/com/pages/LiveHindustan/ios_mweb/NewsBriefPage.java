package com.pages.LiveHindustan.ios_mweb;

import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonNewsBriefPage;
import com.utils.GlobalVars;
import com.utils.Utils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewsBriefPage extends CommonNewsBriefPage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsMobileLH commonFunctionsMobile;

    @FindBy(xpath = "//nav[contains(@class, 'hdr-menu')]/a[contains(@title, 'न्यूज़ ब्रीफ')]")
    private static WebElement newsBrifMenu;

    @FindBy(xpath = "(//div[@id='swiper-height']/div/li)[1]")
    private static WebElement newsBrifWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> newsBrifL2Menu;

    @FindBy(xpath = "//div[@class='img-blk']/a")
    private static List<WebElement> newsBrifStories;

    @FindBy(xpath = "//nav[@id='sub-nv']/a[@title='उत्तर प्रदेश']")
    private static WebElement uttarPradesh;

    @FindBy(xpath = "(//div[@class='news-content']/p)[1]")
    private static WebElement newsContent;

    @FindBy(xpath = "(//div[@class='shre-innr'])[1]/a[contains(@class, 'wtsp-icn')]")
    private static WebElement whatsAppNewsBref;

    @FindBy(xpath = "(//div[@class='shre-innr'])[1]/a[contains(@class, 'fb-icn')]")
    private static WebElement facebookNewsBref;

    @FindBy(xpath = "(//div[@class='shre-innr'])[1]/a[contains(@class, 'twt-icn')]")
    private static WebElement twitterNewsBref;

    @FindBy(xpath = "//a[@class='nb-cnt-ftr' and text()='पूरी खबर पढ़ें']")
    private static List<WebElement> puriKhabarPadheLink;

    @FindBy(xpath = "//div[@class='brd-crum']")
    private static WebElement breadcrumb;

    public NewsBriefPage() {
        globalVars = GlobalVars.getInstance();
        driver = (IOSDriver) globalVars.getAppiumDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobile = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkAllCategoriesAndGiving200StatusCodeOnNewsBriefPage() {
        navigateToNewsBriefPage();
        String newsBriefUrl = commonFunctions.getCurrentURL();
        int newsBriefL2MenuSize = newsBrifL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(newsBrifL2Menu, newsBriefL2MenuSize, newsBriefUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkNewsBriefPageIsGiving200StatusCodeAfterLanding(){
        navigateToNewsBriefPage();
        String newsBriefUrl = commonFunctions.getCurrentURL();
        boolean newsBriefStatus = commonFunctions.getResponseCode(commonFunctions.getCurrentURL()) == 200;
        if(newsBriefStatus == false){
            System.out.println("NewsBrif Landing page is not giving 200");
            Utils.logStepInfo("NewsBrif Landing page is not giving 200");
        }

        int newsBriefL2MenuSize = newsBrifStories.size();
        if(newsBriefL2MenuSize>5){
            newsBriefL2MenuSize = 5;
        }
        boolean isAllElementClickableTrue = commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURL(newsBrifStories, newsBriefL2MenuSize, newsBriefUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue && newsBriefStatus;
    }

    @Override
    public boolean checkAllRelatedNewsArePresentForThatParticularCategory(){
        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;
        boolean catStoryStatue = true;
        navigateToNewsBriefPage();
        String newsBriefUrl = commonFunctions.getCurrentURL();
        int catSize = newsBrifL2Menu.size();

        randomList = commonFunctionsMobile.generateRandomNumberAccordingToCondition("CategoryValuesForRandomNumber");
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);

        System.out.println("startingPoint:- "+startingPoint);
        System.out.println("increasingPoint:- "+increasingPoint);

        for(int i = startingPoint; i < catSize; i = i+increasingPoint){
            commonFunctions.scrollToElement(newsBrifL2Menu.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String menuTitle = newsBrifL2Menu.get(i).getText().trim();
            commonFunctions.clickElementWithJS(newsBrifL2Menu.get(i), 10, menuTitle);
            commonFunctions.dummyWait(5);
            String categoryUrl = commonFunctions.getCurrentURL();
            String catUrl = commonFunctions.getCurrentURL();
            String[] str = catUrl.split("/");
            catUrl = str[str.length-1];
            System.out.println("catUrl:- "+catUrl);
            int storySize = newsBrifStories.size();
            if(storySize>2){
                storySize = 2;
            }
            for(int j = 0; j < storySize; j++){
                commonFunctions.scrollToElement(newsBrifStories.get(j), "Category Story");
                commonFunctions.dummyWait(2);
                commonFunctions.clickElementWithJS(newsBrifStories.get(j), 10, "Category Story");
                commonFunctions.dummyWait(5);
                String storyUrl = commonFunctions.getCurrentURL();
                catStoryStatue &= storyUrl.toLowerCase().trim().contains(catUrl.trim().toLowerCase());
                if(catStoryStatue == false){
                    System.out.println("news-brief stories are present on that page are not related to that category:- "+catUrl+" as in URL:- "+storyUrl);
                    Utils.logStepInfo("news-brief stories are present on that page are not related to that category:- "+catUrl+" as in URL:- "+storyUrl);
                    break;
                }

                commonFunctions.navigateToURL(categoryUrl);
                commonFunctions.dummyWait(5);
            }

            commonFunctions.navigateToURL(newsBriefUrl);
            commonFunctions.dummyWait(5);
        }
        return catStoryStatue;
    }

    public void navigateToNewsBriefPage(){
        commonFunctions.navigateToURL(globalVars.getURL());
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.scrollToElement(newsBrifMenu, "NewsBrif Menu");
        commonFunctions.clickElementWithJS(newsBrifMenu, 10, "NewsBrif Menu");
        commonFunctions.isElementDisplayed(newsBrifWdgt, 10, "NewsBrif Wdgt");
    }

    @Override
    public boolean checkWhileSwipingTheStoriesUrlShouldChange(){
        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int startingPoint;
        int increasingPoint;
        boolean swiping = true;
        boolean swipingStatue = false;
        navigateToNewsBriefPage();
        String newsBriefUrl = commonFunctions.getCurrentURL();
        int catSize = newsBrifL2Menu.size();

        randomList = commonFunctionsMobile.generateRandomNumberAccordingToCondition("CategoryValuesForRandomNumber");
        startingPoint = randomList.get(0);
        increasingPoint = randomList.get(1);

        for(int i = startingPoint; i < catSize; i = i+increasingPoint){
            commonFunctions.scrollToElement(newsBrifL2Menu.get(i), "L2 Menu");
            commonFunctions.dummyWait(2);
            String menuTitle = newsBrifL2Menu.get(i).getText().trim();
            commonFunctions.clickElementWithJS(newsBrifL2Menu.get(i), 10, menuTitle);
            commonFunctions.dummyWait(5);
            String categoryUrl = commonFunctions.getCurrentURL();

            for(int k =0;k<10;k++) {
                commonFunctions.swipeElementUsingTouchAction(31, 425, 169, 97);
                commonFunctions.dummyWait(2);
            }
            commonFunctions.dummyWait(5);
            String storyUrl = commonFunctions.getCurrentURL();
            System.out.println("categoryUrl:- "+categoryUrl);
            System.out.println("storyUrl:- "+storyUrl);
            if(!categoryUrl.equals(storyUrl)){
                swipingStatue = true;
            }

            if(swipingStatue == false){
                System.out.println("while swiping the stories URL is not changing for:- "+menuTitle);
                Utils.logStepInfo("while swiping the stories URL is not changing for:- "+menuTitle);
                swiping &= swipingStatue;
                break;
            }

            commonFunctions.navigateToURL(newsBriefUrl);
            commonFunctions.dummyWait(5);
        }
        return swiping;
    }

    @Override
    public boolean checkSocialSharingRedirectionOnNewsBriefPage(){
        navigateToNewsBriefPage();
        String newsBriefUrl = commonFunctions.getCurrentURL();

        Map<String, String> params = globalVars.getParamsDataSinglePropertySingleProperty("verifySocialSharingRedirectionOnNewsBriefPage");
        //commented for whatsapp because server side error is coming while clicking on whatsapp icon
        /*boolean whatsAppFlag = commonFunctionsMobile.validateSocialSharingIconFunctionalityIos(whatsAppNewsBref, params.get("WhatsApp"), newsBriefUrl, "WhatsApp");
        commonFunctions.dummyWait(2);*/
        boolean facebookFlag = commonFunctionsMobile.validateSocialSharingIconFunctionalityIos(facebookNewsBref, params.get("Facebook"), newsBriefUrl, "Facebook");
        commonFunctions.dummyWait(2);
        boolean twitterFlag = commonFunctionsMobile.validateSocialSharingIconFunctionalityIos(twitterNewsBref, params.get("Twitter"), newsBriefUrl, "Twitter");
        return facebookFlag && twitterFlag /*&& whatsAppFlag*/;
    }

    @Override
    public boolean checkRedirectionOfPuriKhabarPadheOnNewsBriefPage(){
        navigateToNewsBriefPage();
        String newsBriefUrl = commonFunctions.getCurrentURL();
        int puriKhabarSize = puriKhabarPadheLink.size();
        if(puriKhabarSize>10){
            puriKhabarSize = 10;
        }

        return commonFunctionsMobile.isAllElementsClickableAndNavigatedToCorrectURLWithBrdCurm(puriKhabarPadheLink, puriKhabarSize, newsBriefUrl, breadcrumb, "PuriKhabarPadheValuesForRandomNumber");
    }
}
