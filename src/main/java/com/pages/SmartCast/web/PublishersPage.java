package com.pages.SmartCast.web;

import com.commonFunctions.CommonFunctionsWeb;
import com.pages.SmartCast.generic.CommonPublishersPage;
import com.utils.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PublishersPage extends CommonPublishersPage {
    private static WebDriver driver;
    private static GlobalVars globalVars;
    private static CommonFunctionsWeb commonFunctions;

    @FindBy(xpath = "(//button[@class='ng-binding'])[1]")
    private static WebElement dontAllow;
    @FindBy(xpath = "//button[@id='optInText']")
    private static WebElement allow;
    @FindBy(xpath="(//nav[@class='primaryMenu']/ul/li/a)[3]")
    private static WebElement hamburgerPublishers;
    @FindBy(xpath = "//h1[@class='blockHeading']")
    private static List<WebElement> publishersPageTrays;
    @FindBy(xpath = "//div//span[@class='errorThumb']/img")
    private static WebElement error;
    @FindBy(xpath = "//h1[@class='blockHeading']/span/a")
    private static List<WebElement> publishersPageTraysSeeAllButton;
    @FindBy(xpath = "//h3[@class='heading']/a")
    private static List<WebElement> traysPodcastList;

    public PublishersPage() {
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
    public boolean navigateToPublishersPage() {
        boolean navigateToPublishersPageStatus = false;
        try{
            navigateToPublishersPageStatus=commonFunctions.navigateToSpecificPage(hamburgerPublishers,30,"Publishers Section");
            navigateToPublishersPageStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return navigateToPublishersPageStatus;
    }

    @Override
    public String getSmartCastTitle() {
        return commonFunctions.getTitle();
    }

    @Override
    public boolean checkPublishersSection() {
        boolean checkPublishersSectionStatus;
        boolean isPublishersPageTraysAvailable = false;
        boolean checkedAllTraysWithPage=false;
        try{
            isPublishersPageTraysAvailable=commonFunctions.checkNumberOfTraysInPage(publishersPageTrays,error);
            checkedAllTraysWithPage=commonFunctions.clickElementsListAndNavigateBack(publishersPageTraysSeeAllButton,traysPodcastList,30,"See All and navigated to trays podcast listing");
            commonFunctions.navigateToHomePageSC();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ( isPublishersPageTraysAvailable && checkedAllTraysWithPage) {
            checkPublishersSectionStatus = true;
        } else {
            checkPublishersSectionStatus = false;
        }
        return checkPublishersSectionStatus;
    }

}