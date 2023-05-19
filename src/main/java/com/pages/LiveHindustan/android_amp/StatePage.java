package com.pages.LiveHindustan.android_amp;

import com.commonFunctions.CommonFunctionsMobile;
import com.commonFunctions.CommonFunctionsWeb;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsMobileLH;
import com.pages.LiveHindustan.commonFunctions.CommonFunctionsWebLH;
import com.pages.LiveHindustan.genericPages.CommonStatePage;
import com.utils.GlobalVars;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatePage extends CommonStatePage {

    private static AndroidDriver<WebElement> driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsMobile commonFunctions;
    private static CommonFunctionsWeb commonFunctionsWeb;
    private CommonFunctionsWebLH commonFunctionsWebLH;
    private CommonFunctionsMobileLH commonFunctionsMobile;

    @FindBy(xpath = "(//div[@class='newscardbig']/a)[1]")
    private static WebElement firstPramukhStory;

    public StatePage() {
        globalVars = GlobalVars.getInstance();
        driver = (AndroidDriver<WebElement>) globalVars.getAppiumDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonFunctions = CommonFunctionsMobile.getInstance();
        commonFunctionsWeb=CommonFunctionsWeb.getInstance();
        commonFunctionsMobile=CommonFunctionsMobileLH.getInstance();
        System.out.println("****************** Test started ******************");
        System.out.println("******************" + globalVars.getProjectName() + "******************");
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200Status()
    {
        return false;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200UttarPradeshState(){
        return false;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200BiharState(){
        return false;
    }

    @Override
    public boolean checkL2SubMenuPresentAndGiving200NcrState(){
        return false;
    }
    public boolean checkUttarPradeshNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }
    public boolean checkNCRNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }
    public boolean checkBiharNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }
    public boolean checkUttarakhandNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }
    public boolean checkJharkhandNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }
    public boolean checkChhattisgarhNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }
    public boolean checkMadhyaPradeshNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }
    public boolean checkMaharashtraNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }

    public boolean checkRajasthanNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }

    public boolean checkHaryanaNewsWidgetIsHaving6StoriesAndStatusIs200()
    {
        return false;
    }

}
