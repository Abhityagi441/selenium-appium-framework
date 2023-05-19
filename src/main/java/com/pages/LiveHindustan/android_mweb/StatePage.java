package com.pages.LiveHindustan.android_mweb;


import com.commonFunctions.CommonFunctionsMobile;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.genericPages.CommonStatePage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatePage extends CommonStatePage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;

    private static CommonFunctionsMobileLH commonFunctionsMobileLH;

    @FindBy(xpath = "//nav[contains(@class, 'hdr-menu')]/a[contains(@title, 'राज्य')]")
    private static WebElement stateMenu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[contains(text(), 'राज्य')]")
    private static WebElement stateWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> stateL2Menu;

    @FindBy(xpath = "//nav[@id='sub-nv']/a[contains(@title, 'उत्तर प्रदेश')]")
    private static WebElement uttarPradesL2Menu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[contains(text(), 'उत्तर प्रदेश')]")
    private static WebElement uttarPradesWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> uttarPradeshL2Menu;

    @FindBy(xpath = "//nav[@id='sub-nv']/a[contains(@title, 'बिहार')]")
    private static WebElement biharL2Menu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[text()= 'बिहार']")
    private static WebElement biharWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> biharL2Menus;

    @FindBy(xpath = "//nav[@id='sub-nv']/a[contains(@title, 'NCR')]")
    private static WebElement ncrL2Menu;

    @FindBy(xpath = "//div[@class='wdgt-nav pg-nav']//a[text()= 'NCR']")
    private static WebElement ncrWdgt;

    @FindBy(xpath = "//nav[@id='sub-nv']/a")
    private static List<WebElement> ncrL2Menus;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='उत्तर प्रदेश समाचार']")
    private static WebElement uttarPareshNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='uttar-pradesh']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> uttarPareshNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='NCR समाचार']")
    private static WebElement ncrNewsStoriesSection;
    @FindBy(xpath = "//a[@title='NCR समाचार']//ancestor::section[@class='main-wdgt']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> ncrNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='बिहार समाचार']")
    private static WebElement biharNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='bihar']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> biharNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='उत्तराखंड समाचार']")
    private static WebElement uttarakhandNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='uttarakhand']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> uttarakhandNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='झारखण्ड समाचार']")
    private static WebElement jharkhandNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='jharkhand']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> jharkhandNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='छत्तीसगढ़ समाचार']")
    private static WebElement chhattishgarhNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='chhattisgarh']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> chhattishgarhNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='मध्य प्रदेश समाचार']")
    private static WebElement madhyaPradeshNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='madhya-pradesh']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> madhyaPradeshNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='महाराष्ट्र समाचार']")
    private static WebElement maharashtraNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='maharashtra']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> maharashtraNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='राजस्थान समाचार']")
    private static WebElement rajasthanNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='rajasthan']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> rajasthanNewsStoriesLink;
    @FindBy(xpath = "//div[@class='wdgt-hdng']//a[@title='हरियाणा समाचार']")
    private static WebElement haryanaNewsStoriesSection;
    @FindBy(xpath = "//div[@data-vars-widget-name='haryana']//div[@class='wdgt-wrap']//a")
    private static List<WebElement> haryanaNewsStoriesLink;

    public StatePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsMobileLH = CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200Status()
    {
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        String stateUrl = commonFunctions.getCurrentURL();
        int stateL2MenuSize = stateL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(stateL2Menu, stateL2MenuSize, stateUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200UttarPradeshState(){
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        commonFunctions.scrollToElement(uttarPradesL2Menu, "uttarPradesL2Menu Menu");
        commonFunctions.clickElementWithJS(uttarPradesL2Menu, 10, "uttarPradesL2Menu Menu");
        commonFunctions.isElementDisplayed(uttarPradesWdgt, 10, "uttar Pradesh Wdgt");
        String uttarPradeshUrl = commonFunctions.getCurrentURL();
        int uttarPradeshL2MenuSize = uttarPradeshL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(uttarPradeshL2Menu, uttarPradeshL2MenuSize, uttarPradeshUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200BiharState(){
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        commonFunctions.scrollToElement(biharL2Menu, "biharL2Menu Menu");
        commonFunctions.clickElementWithJS(biharL2Menu, 10, "biharL2Menu Menu");
        commonFunctions.isElementDisplayed(biharWdgt, 10, "Bihar Wdgt");
        String biharUrl = commonFunctions.getCurrentURL();
        int biharL2MenuSize = biharL2Menus.size();
        boolean isAllElementClickableTrue = commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(biharL2Menus, biharL2MenuSize, biharUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200NcrState(){
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        commonFunctions.scrollToElement(ncrL2Menu, "ncrL2Menu Menu");
        commonFunctions.clickElementWithJS(ncrL2Menu, 10, "ncrL2Menu Menu");
        commonFunctions.isElementDisplayed(ncrWdgt, 10, "NCR Wdgt");
        String ncrUrl = commonFunctions.getCurrentURL();
        int ncrL2MenuSize = ncrL2Menus.size();
        boolean isAllElementClickableTrue = commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(ncrL2Menus, ncrL2MenuSize, ncrUrl, "MenuValuesForRandomNumber");
        return isAllElementClickableTrue;
    }
    public boolean checkUttarPradeshNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int cricketSize=6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(uttarPareshNewsStoriesSection,uttarPareshNewsStoriesLink,cricketSize, "WidgitValuesForRandomNumber");
    }

    public boolean checkNCRNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int cricketSize=6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(ncrNewsStoriesSection,ncrNewsStoriesLink,cricketSize, "WidgitValuesForRandomNumber");
    }
    public boolean checkBiharNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int biharNewsSize=6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(biharNewsStoriesSection,biharNewsStoriesLink,biharNewsSize, "WidgitValuesForRandomNumber");
    }
    public boolean checkUttarakhandNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int uttarakhandNewsSize=6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(uttarakhandNewsStoriesSection,uttarakhandNewsStoriesLink,uttarakhandNewsSize, "WidgitValuesForRandomNumber");
    }
    public boolean checkJharkhandNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int jharkhandNewsSize=6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(jharkhandNewsStoriesSection,jharkhandNewsStoriesLink,jharkhandNewsSize, "WidgitValuesForRandomNumber");
    }
    public boolean checkChhattisgarhNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int chhattishgarhNewsSize=6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(chhattishgarhNewsStoriesSection,chhattishgarhNewsStoriesLink,chhattishgarhNewsSize, "WidgitValuesForRandomNumber");
    }
    public boolean checkMadhyaPradeshNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int madhyaPradeshNewsSize=6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(madhyaPradeshNewsStoriesSection,madhyaPradeshNewsStoriesLink,madhyaPradeshNewsSize, "WidgitValuesForRandomNumber");
    }
    public boolean checkMaharashtraNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int maharashtraNewsSize = 6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(maharashtraNewsStoriesSection,maharashtraNewsStoriesLink,maharashtraNewsSize, "WidgitValuesForRandomNumber");
    }

    public boolean checkRajasthanNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int rajasthanNewsSize = 6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(rajasthanNewsStoriesSection,rajasthanNewsStoriesLink,rajasthanNewsSize, "WidgitValuesForRandomNumber");
    }

    public boolean checkHaryanaNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int haryanaNewsSize = 6;
        commonFunctionsMobileLH.navigateToStatePage(stateMenu,stateWdgt);
        return commonFunctionsMobileLH.isAllElementsClickableAndNavigatedToCorrectURL(haryanaNewsStoriesSection,haryanaNewsStoriesLink,haryanaNewsSize, "WidgitValuesForRandomNumber");
    }
}
