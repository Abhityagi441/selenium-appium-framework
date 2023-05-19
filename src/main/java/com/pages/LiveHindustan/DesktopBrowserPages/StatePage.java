package com.pages.LiveHindustan.DesktopBrowserPages;


import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonStatePage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatePage extends CommonStatePage {

    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;
    private static CommonFunctionsWebLH commonFunctionsWebLH;

    @FindBy(xpath = "//button[contains(@class,'closebtn btn')]")
    private static WebElement skipSignInButton;

    @FindBy(id = "deny")
    private static WebElement notificationDeny;

    @FindBy(xpath = "//a[@id='dsply-state']")
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
        driver = globalVars.getWebDriver();
        PageFactory.initElements(driver, this);
        commonFunctions = CommonFunctionsWeb.getInstance();
        commonFunctionsWebLH = CommonFunctionsWebLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
        commonFunctions.clickElementIfDisplayed(skipSignInButton, 2, "Skip sign in button");
        commonFunctions.clickElementIfDisplayed(notificationDeny, 2, "Notification deny");
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200Status()
    {
        navigateToStatePage();
        String stateUrl = commonFunctions.getCurrentURL();
        int stateL2MenuSize = stateL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(stateL2Menu, stateL2MenuSize, stateUrl);
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200UttarPradeshState(){
        navigateToStatePage();
        commonFunctions.scrollToElement(uttarPradesL2Menu, "uttarPradesL2Menu Menu");
        commonFunctions.clickElementWithJS(uttarPradesL2Menu, 10, "uttarPradesL2Menu Menu");
        commonFunctions.isElementDisplayed(uttarPradesWdgt, 10, "uttar Pradesh Wdgt");
        String uttarPradeshUrl = commonFunctions.getCurrentURL();
        int uttarPradeshL2MenuSize = uttarPradeshL2Menu.size();
        boolean isAllElementClickableTrue = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(uttarPradeshL2Menu, uttarPradeshL2MenuSize, uttarPradeshUrl);
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200BiharState(){
        navigateToStatePage();
        commonFunctions.scrollToElement(biharL2Menu, "biharL2Menu Menu");
        commonFunctions.clickElementWithJS(biharL2Menu, 10, "biharL2Menu Menu");
        commonFunctions.isElementDisplayed(biharWdgt, 10, "Bihar Wdgt");
        String biharUrl = commonFunctions.getCurrentURL();
        int biharL2MenuSize = biharL2Menus.size();
        boolean isAllElementClickableTrue = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(biharL2Menus, biharL2MenuSize, biharUrl);
        return isAllElementClickableTrue;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200NcrState(){
        navigateToStatePage();
        commonFunctions.scrollToElement(ncrL2Menu, "ncrL2Menu Menu");
        commonFunctions.clickElementWithJS(ncrL2Menu, 10, "ncrL2Menu Menu");
        commonFunctions.isElementDisplayed(ncrWdgt, 10, "NCR Wdgt");
        String ncrUrl = commonFunctions.getCurrentURL();
        int ncrL2MenuSize = ncrL2Menus.size();
        boolean isAllElementClickableTrue = commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(ncrL2Menus, ncrL2MenuSize, ncrUrl);
        return isAllElementClickableTrue;
    }

    public void navigateToStatePage(){
        commonFunctions.navigateToURL(globalVars.getURL()+"/state");
        commonFunctions.waitForPageToLoad();
        commonFunctions.dummyWait(5);
        commonFunctions.isElementDisplayed(stateWdgt, 10, "State Wdgt");
    }

    public boolean checkUttarPradeshNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int uttarPradeshNewsSize=6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(uttarPareshNewsStoriesSection,uttarPareshNewsStoriesLink,uttarPradeshNewsSize);
    }

    public boolean checkNCRNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int ncrNewsSize=6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(ncrNewsStoriesSection,ncrNewsStoriesLink,ncrNewsSize);
    }
    public boolean checkBiharNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int biharNewsSize=6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(biharNewsStoriesSection,biharNewsStoriesLink,biharNewsSize);
    }
    public boolean checkUttarakhandNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int uttarakhandNewsSize=6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(uttarakhandNewsStoriesSection,uttarakhandNewsStoriesLink,uttarakhandNewsSize);
    }
    public boolean checkJharkhandNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int jharkhandNewsSize=6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(jharkhandNewsStoriesSection,jharkhandNewsStoriesLink,jharkhandNewsSize);
    }
    public boolean checkChhattisgarhNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int chhattishgarhNewsSize=6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(chhattishgarhNewsStoriesSection,chhattishgarhNewsStoriesLink,chhattishgarhNewsSize);
    }
    public boolean checkMadhyaPradeshNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int madhyaPradeshNewsSize=6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(madhyaPradeshNewsStoriesSection,madhyaPradeshNewsStoriesLink,madhyaPradeshNewsSize);
    }
    public boolean checkMaharashtraNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int maharashtraNewsSize = 6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(maharashtraNewsStoriesSection,maharashtraNewsStoriesLink,maharashtraNewsSize);
    }

    public boolean checkRajasthanNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int rajasthanNewsSize = 6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(rajasthanNewsStoriesSection,rajasthanNewsStoriesLink,rajasthanNewsSize);
    }

    public boolean checkHaryanaNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        int haryanaNewsSize = 6;
        navigateToStatePage();
        return commonFunctionsWebLH.isAllElementsClickableAndNavigatedToCorrectURL(haryanaNewsStoriesSection,haryanaNewsStoriesLink,haryanaNewsSize);
    }
}
